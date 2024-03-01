// import React, { useEffect, useState } from 'react';
// import './FrontPage.css';
// import { Link } from 'react-router-dom';
// import EmployeeService from './services/EmployeeService';

// const columns = [
// { key: 'firstName', label: 'FIRSTNAME' },
// { key: 'lastName', label: 'LASTNAME' },
// { key: 'email', label: 'EMAIL' },
// { key: 'mobileNumber', label: 'MOBILENUMBER' },
// { key: 'dob', label: 'DOB' },
// { key: 'address', label: 'ADDRESS' },
// { key: 'actions', label: 'ACTIONS' },
// ];

// function FrontPage() {
// const [employee, setEmployee] = useState([])
// useEffect(() => {
// getTemp();
// }, {})

// const getTemp = () => {
// EmployeeService.getEmployee().then((response) => {
// console.log(response.data);
// setEmployee(response.data);
// }).catch(error => {

// console.log(error);
// });
// }

// // function updateRecords(employeeId)
// // {
// // EmployeeService.updateRecords(employeeId).then((response) =>{
// // setEmployee(response);
// // }).catch(error =>
// // {
// // console.log(error);
// // })

// // }

// function deleteRecords(employeeId) {
// EmployeeService.deleteRecords(employeeId).then((response) => {
// getTemp();
// }).catch(error => {
// console.log(error)
// })
// }
// <></>
// return (
// <div className="App">
// <div class="header">
// <div class="img">
// <img id="logo1" src="https://divum.in/images/logo/Divum%20LOGO%202022.svg" />
// </div>
// <div className="btnn">
// <Link to="/login"><button type="submit" id="button">ADD</button></Link>
// <Link to="/"><button type="submit" id="back-back">BACK</button></Link>
// </div>
// </div>

// <table>
// <thead>
// <tr>
// {columns.map((column) => (
// <th key={column.key}>{column.label}</th>
// ))}
// </tr>
// </thead>
// <tbody>
// {employee.map((employee) => (
// <tr key={employee.id}>
// <td>{employee.firstName}</td>
// <td>{employee.lastName}</td>
// <td>{employee.email}</td>
// <td>{employee.mobileNumber}</td>
// <td>{employee.dob}</td>
// <td>{employee.address}</td>
// <td>{employee.actions}<button type="onClick" onClick={(e) => deleteRecords(employee.id)} id="actions">DELETE</button>
// <Link to={`/edit-user/${employee.id}`} ><button type="onClick" id="actions">UPDATE </button>
// </Link></td>
// </tr>
// ))}
// </tbody>
// </table>
// </div>
// );
// }
// export default FrontPage;

// import React, { useEffect, useState } from 'react';
// import './FrontPage.css';
// import { Link } from 'react-router-dom';
// import EmployeeService from './services/EmployeeService';
// import { Table } from 'antd';

// // const columns = [
// // { key: 'firstName', label: 'FIRSTNAME' },
// // { key: 'lastName', label: 'LASTNAME' },
// // { key: 'email', label: 'EMAIL' },
// // { key: 'mobileNumber', label: 'MOBILENUMBER' },
// // { key: 'dob', label: 'DOB' },
// // { key: 'address', label: 'ADDRESS' },
// // { key: 'actions', label: 'ACTIONS' },
// // ];

// function FrontPage() {
// const columns=[
// {
// title:"SI.No",
// render:(_,_record,index)=>index+1,
// },
// {
// title:"FIRSTNAME",
// dataIndex:"firstName",

// },
// {
// title:"LASTNAME",
// dataIndex:"lastName",

// },
// {
// title:"EMAIL",
// dataIndex:"email",

// },
// {
// title:"MOBILENUMBER",
// dataIndex:"mobileNumber",

// },
// {
// title:"DOB",
// dataIndex:"dob",

// },

// {
// title:"ADDRESS",
// dataIndex:"address",

// },
// {
// title:"ACTIONS",
// render:(_response)=>
// (
// <><button type="onClick" onClick={(e) => deleteRecords(employee.id)} id="actions">DELETE</button>
// <Link to={`/edit-user/${employee.id}`}><button type="onClick" id="actions">UPDATE </button> </Link></>

// )

// },

// ]
// const [employee, setEmployee] = useState([])
// useEffect(() => {
// getTemp();
// }, {})

// const getTemp = () => {
// EmployeeService.getEmployee().then((response) => {
// console.log(response.data);
// setEmployee(response.data);
// }).catch(error => {

// console.log(error);
// });
// }

// // function updateRecords(employeeId)
// // {
// // EmployeeService.updateRecords(employeeId).then((response) =>{
// // setEmployee(response);
// // }).catch(error =>
// // {
// // console.log(error);
// // })

// // }

// function deleteRecords(employeeId) {
// EmployeeService.deleteRecords(employeeId).then((response) => {
// getTemp();
// }).catch(error => {
// console.log(error)
// })
// }
// <></>
// return (
// <div className="App">
// <div class="header">
// <div class="img">
// <img id="logo1" src="https://divum.in/images/logo/Divum%20LOGO%202022.svg" />
// </div>
// <div className="btnn">
// <Link to="/login"><button type="submit" id="button">ADD</button></Link>
// <Link to="/"><button type="submit" id="back-back">BACK</button></Link>
// </div>
// </div>
// <div class ="body">
// <Table id="pagination" columns={columns} dataSource={employee}></Table>

// </div>
// {/* 
// <table>
// <thead>
// <tr>
// {columns.map((column) => (
// <th key={column.key}>{column.label}</th>
// ))}
// </tr>
// </thead>
// <tbody>
// {employee.map((employee) => (
// <tr key={employee.id}>
// <td>{employee.firstName}</td>
// <td>{employee.lastName}</td>
// <td>{employee.email}</td>
// <td>{employee.mobileNumber}</td>
// <td>{employee.dob}</td>
// <td>{employee.address}</td>
// <td>{employee.actions}<button type="onClick" onClick={(e) => deleteRecords(employee.id)} id="actions">DELETE</button>
// <Link to={`/edit-user/${employee.id}`} ><button type="onClick" id="actions">UPDATE </button>
// </Link></td>
// </tr>
// ))}
// </tbody>
// </table> */}
// </div>
// );
// }
// export default FrontPage;





import React, { useEffect, useState } from 'react';
import './FrontPage.css';
import { Link } from 'react-router-dom';
import EmployeeService from './services/EmployeeService';
import { Table, Button } from 'antd';

function FrontPage() {
  const [employee, setEmployee] = useState([]);
  
  const columns = [
    {
      title: "FIRSTNAME",
      dataIndex: "firstName",
      className:"heading",
    },
    {
      title: "LASTNAME",
      dataIndex: "lastName",
      className:"heading",
    },
    {
      title: "EMAIL",
      dataIndex: "email",
      className:"heading",
    },
    {
      title: "MOBILENUMBER",
      dataIndex: "mobileNumber",
      className:"heading",
    },
    {
      title: "DOB",
      dataIndex: "dob",
      className:"heading"
    },
    {
      title: "ADDRESS",
      dataIndex: "address",
      className:"heading",
    },
    {
      title: "ACTIONS",
      dataIndex: "actions",
      className:"heading",
      render: (_text, employee) => (
          <>
              <Button onClick={() => deleteRecords(employee.id)} id="actions" type="onSumbit">DELETE</Button>
              
              <Link to={`/edit-user/${employee.id}`}><Button type="onSumbit" id="actions">UPDATE</Button></Link></>

      ),
    },
  ];

  useEffect(() => {
    getTemp();
  }, []);

  const getTemp = () => {
    EmployeeService.getEmployee()
      .then((response) => {
        console.log(response.data,"jkkkk");
        setEmployee(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  function deleteRecords(employeeId) {
    EmployeeService.deleteRecords(employeeId)
      .then(() => {
        setEmployee(employee.filter((item) => item.id !== employeeId));
        
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div className="App">
      <div class="header">
        <div class="img">
          <img
            id="logo1"
            src="https://divum.in/images/logo/Divum%20LOGO%202022.svg"
            alt="Logo"
          />
        </div>
        <div className="btnn">
          <Link to="/login"><button type="submit" id="button">ADD</button></Link>
          <Link to="/"><button type="submit" id="back-back"> BACK</button></Link>
        </div>
      </div>
      <div class="table-body">
        <Table id="box" columns={columns} dataSource={employee} />
      </div>
    </div>
  );
}
export default FrontPage;




