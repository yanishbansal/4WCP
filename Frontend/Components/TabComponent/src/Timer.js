import React from 'react'
export default  function Timer(time) {
    return (
    <div className='py-2'><span>{time.time.getHours()} : {time.time.getMinutes()} : {time.time.getSeconds()}</span></div>
    );
}