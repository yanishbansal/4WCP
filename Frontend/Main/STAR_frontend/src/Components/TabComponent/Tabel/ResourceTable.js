import {React, useState, useRef} from 'react';
import { SearchOutlined } from '@ant-design/icons';
import { Button, Input, Space, Table } from 'antd';
import Highlighter from 'react-highlight-words';
import HistoryTrail from './HistoryTrail';

function onChange(pagination, filters, sorter, extra) {
  console.log('params', pagination, filters, sorter, extra);
};

export default function ManagerTable({ReqData}) {
    const [searchText, setSearchText] = useState('');
    const [searchedColumn, setSearchedColumn] = useState('');
    const searchInput = useRef(null);
    const handleSearch = (selectedKeys, confirm, dataIndex) => {
    confirm();
    setSearchText(selectedKeys[0]);
    setSearchedColumn(dataIndex);
    };
    const handleReset = (clearFilters) => {
    clearFilters();
    setSearchText('');
    };
    const getColumnSearchProps = (dataIndex) => ({
    filterDropdown: ({ setSelectedKeys, selectedKeys, confirm, clearFilters, close }) => (
        <div
        style={{
            padding: 8,
        }}
        onKeyDown={(e) => e.stopPropagation()}
        >
        <Input
            ref={searchInput}
            placeholder={`Search ${dataIndex}`}
            value={selectedKeys[0]}
            onChange={(e) => setSelectedKeys(e.target.value ? [e.target.value] : [])}
            onPressEnter={() => handleSearch(selectedKeys, confirm, dataIndex)}
            style={{
            marginBottom: 8,
            display: 'block',
            }}
        />
        <Space>
            <Button
            type="primary"
            onClick={() => handleSearch(selectedKeys, confirm, dataIndex)}
            icon={<SearchOutlined />}
            size="small"
            style={{
                width: 90,
            }}
            >
            Search
            </Button>
            <Button
            onClick={() => clearFilters && handleReset(clearFilters)}
            size="small"
            style={{
                width: 90,
            }}
            >
            Reset
            </Button>
        </Space>
        </div>
    ),
    filterIcon: (filtered) => (
        <SearchOutlined
        style={{
            color: filtered ? '#1890ff' : undefined,
        }}
        />
    ),
    onFilter: (value, record) =>
        record[dataIndex].toString().toLowerCase().includes(value.toLowerCase()),
    onFilterDropdownOpenChange: (visible) => {
        if (visible) {
        setTimeout(() => searchInput.current?.select(), 100);
        }
    },
    render: (text) =>
        searchedColumn === dataIndex ? (
        <Highlighter
            highlightStyle={{
            backgroundColor: '#ffc069',
            padding: 0,
            }}
            searchWords={[searchText]}
            autoEscape
            textToHighlight={text ? text.toString() : ''}
        />
        ) : (
        text
        ),
    });
    const columns = [
        {
            title: 'Timesheet',
            dataIndex: 'timesheetNo',
            width:140,
            sorter: (a, b) => a.timesheetNo.localeCompare(b.timesheetNo),
            sortDirections: ['descend', 'ascend'],
        },
        {
            title:'Project',
            dataIndex:'projectName',
            ellipsis:'true',
            ...getColumnSearchProps('projectName'),
            sorter:(a, b) => a.projectName.localeCompare(b.projectName),
            sortDirections: ['descend', 'ascend'],
        },
        {
            title:'Hours',
            dataIndex:'extraHours',
            width:110,
            sorter:(a, b) => a.extraHours - b.extraHours,
            sortDirections: ['descend', 'ascend'],
        },  
        {
            title:'From Date',
            dataIndex:'startTime',
            width:140,
            sorter:(a, b) => a.startTime.localeCompare(b.startTime),
            sortDirections: ['descend', 'ascend'],
        },        {
            title:'Till Date',
            dataIndex:'endTime',
            width:140,
            sorter:(a, b) => a.endTime.localeCompare(b.endTime),
            sortDirections: ['descend', 'ascend'],
        },
        {
            title:'Manager Name',
            dataIndex:'managerName',
            ...getColumnSearchProps('managerName'),
            sorter:(a, b) => a.managerName.localeCompare(b.managerName),
            sortDirections: ['descend', 'ascend'],
        },
        {
          title: 'Status',
          width:110,
          dataIndex: '',
        //   key:'operation',    
          filters: [
            {
              text: 'Approved',
              value: 'Approved',
            },
            {
              text: 'Pending',
              value: 'Pending',
            },
            {
              text: 'Rejected',
              value: 'Rejected',
            },
          ],
          filterSearch: true,
          onFilter: (value, record) => record.status.startsWith(value),
          render: (data) =>       
          <Space>
            {(data.status === 'Approved') ? (<a className="text-success" style={{'text-decoration':'none'}}>{data.status}</a>):
            (data.status === 'Rejected') ? (<div className="text-danger" style={{'text-decoration':'none'}} >{data.status}</div>):
            (<a className="text-warning" style={{'text-decoration':'none'}}>{data.status}</a>)}
          </Space>,
        },
    ];
    return(
        <Table columns={columns} expandable={{
            expandedRowRender: (record) => (
                <HistoryTrail trail={record.requestLogs}/>
            ),
            rowExpandable: (record) => record.status !== 'Pending',
          }} dataSource={ReqData} onChange={onChange}  scroll={{ y: 214 }} ></Table>
    );
}   