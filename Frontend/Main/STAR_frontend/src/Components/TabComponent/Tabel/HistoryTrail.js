import {React, useEffect} from 'react'
import {Steps} from 'antd' 



function HistoryTrail({trail}) {
    let data = [];
    trail.map((item) => {
        let status = "Rejected";
        if (item.isApproved == true)  status = "Accepted";
        const log = {
            'title': item.updatedOn.replace('T', ' ').substr(0, 19),
            'description': status + ": " + item.responseText,
        }
        data.push(log);
    });
  return (
    <div className='mx-5 d-flex align-items-center justify-content-center'>
        <Steps
            progressDot
            direction="vertical"
            items={data}
        />
    </div>
  )
}

export default HistoryTrail