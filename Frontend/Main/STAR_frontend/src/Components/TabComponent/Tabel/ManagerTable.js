import AcceptRejctButton from '../Forms/ManagerForm';
import {React, useState, useRef} from 'react';
import { SearchOutlined } from '@ant-design/icons';
import { Button, Input, Space, Table } from 'antd';
import Highlighter from 'react-highlight-words';

function onChange(pagination, filters, sorter, extra) {
  console.log('params', pagination, filters, sorter, extra);
};

export default function ManagerTable({managerReq, managerId}) {
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
            width:120,
            sorter: (a, b) => a.timesheetNo.localeCompare(b.timesheetNo),
            sortDirections: ['descend', 'ascend'],
        },
        {
            title: 'Id',
            dataIndex:'userId',
            width:80,
            sorter:(a, b) => a.userId - b.userId,
            sortDirections:['descend', 'ascend'],
        },
        {
            title:'Name',
            dataIndex:'name',
            ellipsis:'true',
            ...getColumnSearchProps('name'),
            sorter:(a, b) => a.name.localeCompare(b.name),
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
            title:'From Date',
            dataIndex:'periodStart',
            width:120,
            sorter:(a, b) => a.periodStart.localeCompare(b.periodStart),
            sortDirections: ['descend', 'ascend'],
        },
        {
            title:'Till Date',
            dataIndex:'periodEnd',
            width:120,
            sorter:(a, b) => a.periodEnd.localeCompare(b.periodEnd),
            sortDirections: ['descend', 'ascend'],
        },
        {
            title:'Expected Hours',
            ellipsis:'true',
            width:90,
            dataIndex:'expectedHours',
            sorter:(a, b) => a.expectedHours - b.expectedHours,
            sortDirections: ['descend', 'ascend'],
        },
        {
            title:'Actual Hours',
            dataIndex:'hours',
            ellipsis:'true',
            width:90,
            sorter:(a, b) => a.hours - b.hours,
            sortDirections: ['descend', 'ascend'],
        },  
        {
            title: 'Action',
            dataIndex: '',
            width: 90,
            render: (data) => <AcceptRejctButton name={"Action"} timesheetId={data.id} userId={data.userId} managerId={managerId}/>,
        },
    ];
      
    return(
        <Table columns={columns} dataSource={managerReq} onChange={onChange}  scroll={{ y: 214 }}></Table>
        );
}   