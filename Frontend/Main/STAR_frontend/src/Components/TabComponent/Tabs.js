import * as React from 'react';
import Box from '@mui/material/Box';
import Tab from '@mui/material/Tab';
import TabContext from '@mui/lab/TabContext';
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';
import ManagerTable from './Tabel/ManagerTable';
import ResourceTable from './Tabel/ResourceTable';
import HistoryTable from './Tabel/History';
import Accept from '../Card/StatisticsCardAccept'
import Pending from '../Card/StatisticsCardPending'
import Reject from '../Card/StatisticsCardReject'

export default function Tabs({resource, managerReq, reqHistory, resourceReq, status}) {
  const [value, setValue] = React.useState('1');

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };
  
  return (
    <TabContext value={value}>
      <TabPanel value="1" style={{padding:'0'}}>         
        <div class="d-flex justify-content-evenly">
          <Accept count={status.resourceApproved}/>
          <Pending count={resourceReq.length-status.resourceApproved-status.resourceRejected}/>
          <Reject count={status.resourceRejected}/>
        </div>
      </TabPanel>
      <TabPanel value="2" style={{padding:'0'}}>         
        <div class="d-flex justify-content-evenly">
          <Accept count={status.managerApproved}/>
          <Pending count={managerReq.length}/>
          <Reject count={status.managerRejected}/>
        </div>
      </TabPanel>
      <Box className='mt-2' sx={{ borderBottom: 1, borderColor: 'divider' }}>
        <TabList onChange={handleChange}>
          <Tab sx={{fontWeight:'bold', color:'gray'}} className="mx-2" label="My Profile " value="1" />
          {(managerReq.length === 0 && reqHistory.length)?(''):(<Tab sx={{fontWeight:'bold', color:'gray'}} label="Requests" value="2" />)}
          {(managerReq.length === 0 && reqHistory.length)?(''):(<Tab sx={{fontWeight:'bold', color:'gray'}} label="History" value="3" />)}
        </TabList>  
      </Box>
      <TabPanel value="1">
        <ResourceTable ReqData={resourceReq}/>
      </TabPanel>
      <TabPanel value="2">
        <ManagerTable  managerReq={managerReq} managerId={resource.userId}/>
      </TabPanel>
      <TabPanel value="3">
        <HistoryTable  reqHistory={reqHistory} managerId={resource.userId}/>
      </TabPanel>
    </TabContext>
  );
}
