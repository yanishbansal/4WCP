import * as React from 'react';
import Box from '@mui/material/Box';
import Tab from '@mui/material/Tab';
import TabContext from '@mui/lab/TabContext';
import TabList from '@mui/lab/TabList';
import Timer from './Timer'
import List from './List'
import TabPanel from '@mui/lab/TabPanel';

export default function Tabs() {
  const [value, setValue] = React.useState('1');

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };
  const data = [
    {name:"alert alert-primary", message:"It is a custom message no 1"},
    {name:"alert alert-secondary", message:"It is a custom message no 2"},
    {name:"alert alert-success", message:"It is a custom message no 3"},
    {name:"alert alert-danger", message:"It is a custom message no 4"},
    {name:"alert alert-warning", message:"It is a custom message no 5"},
    {name:"alert alert-info", message:"It is a custom message no 6"}
  ];
  var list_items = data.map((item, i) => {
    return <List message={item.message} name={item.name}></List>
  });
  return (
    <Box sx={{ width: '100%', typography: 'body1' }}>
      <TabContext value={value}>
        <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
          <TabList onChange={handleChange} aria-label="lab API tabs example">
            <Tab label="Item One" value="1" />
            <Tab label="Item Two" value="2" />
          </TabList>
        </Box>
        <TabPanel value="1">
          <span className='display-1 text-danger'><Timer time={new Date()}></Timer></span>
        </TabPanel>
        <TabPanel value="2">
          <div className='container py-4 my-5'>{list_items}</div>
        </TabPanel>
      </TabContext>
    </Box>
  );
}