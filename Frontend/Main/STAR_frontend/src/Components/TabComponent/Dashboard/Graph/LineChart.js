import React from "react";
import 'chart.js/auto'
import { Line } from "react-chartjs-2";

const labels = ["Delivery", "Data & AI", "Cloud", "Product Engineering", "Medicine", "Investment"]; //x axis

const data = {
  labels: labels,
  datasets: [
    {
      label: "Extra Hours Required",
      backgroundColor: "rgb(255, 99, 132)",
      borderColor: "rgb(255, 99, 132)",
      data: [26,-12,18,-12,18,32], //y axis
    },
    {
        label: "No. of Employee Doing Overtime",
        backgroundColor: "rgb(255, 165, 0)",
        borderColor: "rgb(255, 165, 0)",
        data: [21,2,15,2,15,2], //y axis
      }
  ],
};
const options = {
  maintainAspectRatio: false,  
  layout: {
    padding: {
      top: -10,
      left:0,
      bottom:-5,
    }
  },
  plugins: {
      title: {
          display: true,
          text: 'Custom Chart Title'
      },
      
      legend: {
        display: true,
        position: 'bottom',
        align:'start',
      },
  }, 
}
export default function LineChart () {
  return (
    <div style={{height:'15rem'}} >
      <Line data={data} options={options}></Line>
    </div>
  );
};

