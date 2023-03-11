import {React, useState } from 'react';
import {Divider} from 'antd';
import LineChart from './Graph/LineChart';
import BarComp from './Graph/BarGraph';
import './Graph/GraphStyle.css'
import { Card } from '@mui/material';

const graph1data = []
const graph2data = []
const graph3data = []
const graph4data = []


export default function Dashboard () {
  return (
    <div className="container" style={{'width':'200vh'}}>
        <div className="row">
            {/* <div col-md-12>
                <Card className='px-5 py-4'>Hello</Card>
            </div> */}
            <div className="row col-md-10">
                <div className='col-md-6'>
                    <LineChart/>
                </div>
                <div className='col-md-6'>
                    <LineChart/>
                </div>
                <Divider plain className='mt-4'>+</Divider>
                <div className='col-md-6'>
                    <BarComp/>
                </div>
                <div className='col-md-6'>
                    <BarComp/>
                </div>
            </div>
            <div className="col-md-2">
                <Card sx={{'height':'60vh'}} className='py-5'>details</Card>
            </div>
        </div>
    </div>
  )
}
