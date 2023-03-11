import {Chart as ChartJS, BarElement, CategoryScale, LinearScale, Tooltip, Legend} from 'chart.js' ;
import { Bar } from 'react-chartjs-2';
// import * as Zoom from "chartjs-plugin-zoom";
  
ChartJS.register( BarElement, CategoryScale, LinearScale, Tooltip, Legend)

const projectName = ["project1", "project2", "project3","project4", "project2", "project3","project4", "project2", "project3","project4"];
const Data = [40,-20,60,-60,-20,60,-60,-20,60,-60];
const iscritical = ["no","yes","no","no","yes","no","no","yes","no","no"]
function colorSetter() {
  return(ctx) => {
    const color= iscritical[ctx.dataIndex] === "yes" ?  'rgba(75,192,192,1)'
    :iscritical[ctx.dataIndex] === "no" ? 'rgba(255,26,104,1)' :'black';
    return color;  
  }
}

export default function BarGraph() {
  const data = {
    labels: projectName,
    datasets: [
      {
        label: 'Projects',
        data:Data,
        backgroundColor: colorSetter(),
      },
    ]
  }
  const options = {
    maintainAspectRatio: false,    
    layout: {
      padding: {
        top: -10,
        left:0,
      }
    },
    plugins: {
        title: {
            display: true,
            text: 'Custom Chart Title'
        },
        legend: {
          display: false,
        },
    }, 
      

    scales: {
      y: { // defining min and max so hiding the dataset does not change scale range
        min: -60,
        max: 60,
      }
    }

  }
  // const options = {
  //   maintainAspectRatio: true,
  //   responsive : true,
  //   scales:{
  //     x:{},
  //     y:{
  //       beginAtZero: true,
  //       grid:{
  //         color: (context) =>{
  //           const zeroline= context.tick.value;
  //           const barcolor = zeroline === 0 ? '#666' :'#ccc';
  //           return barcolor
  //         }
  //       } 
  //     }
  //   },
  //   pan: {
  //     enabled :true,
  //     mod:"xy",
  //     speed: 10,
  //   },
  //   Zoom: {
  //     enabled :true,
  //     drag: false,
  //     mod:"xy",
  //     speed: 10,
  //     rangeMin: {
  //       x:0,
  //       y:0,
  //     },
  //     rangeMax: {
  //       x:1000,
  //       y:1000,
  //     },
  //   }   
  // }  

  return (
    <div style={{height:'15rem',}}>
      <Bar data={data} options={options}></Bar>
    </div>
  );
}
