// import * as React from 'react';
// import Button from '@mui/material/Button';
// import Dialog from '@mui/material/Dialog';
// import DialogContent from '@mui/material/DialogContent';
// import {
//   CheckCircleOutlined,
//   ClockCircleOutlined,
//   CloseCircleOutlined,
// } from '@ant-design/icons';
// import { Tag, Space } from 'antd';

// export default function StatusButton({status}) {
//   const [open, setOpen] = React.useState(false);
//   const handleClickOpen = () => {
//     setOpen(true);
//   };

//   const handleClose = () => {
//     setOpen(false);
//   };

//   return (
//     <>
//       <Space>
//       {
//         (status.status === 'Approved') ? (<a className="text-success" style={{'text-decoration':'none'}} onClick={handleClickOpen}>{status.status}</a>):
//         (status.status === 'Rejected') ? (<div className="text-danger" style={{'text-decoration':'none'}}  onClick={handleClickOpen}>{status.status}</div>):
//         (<a className="text-warning" style={{'text-decoration':'none'}} onClick={handleClickOpen}>{status.status}</a>)
//       }
//       </Space>
//       <Dialog open={open} onClose={handleClose}>
//       <div className="d-flex justify-content-start">
//         <DialogContent>
//             <Button onClick={() => handleClose(false)}>X</Button>
//             {status.responseText}
//         </DialogContent>
//       </div>
//       </Dialog>
//     </>
//   );
// }