import axios from 'axios'

const REST_API_URL = 'http://localhost:8070/api/divum';
const REST_API_GET_URL = 'http://localhost:8070/api/divum/deepsi';
const REST_API_CHECK_URL = 'http://localhost:8070/api/divum/check';
const REST_API_PAGINATION_URL="http://localhost:8070/api/divum/page/page/size";

class EmployeeService{

    getEmployee(){
        return axios.get(REST_API_GET_URL);
    }

    saveRecords(employee){
        return axios.post(REST_API_URL, employee)
    }

    deleteRecords(employeeId){
        return axios.delete(REST_API_URL+ '/' + employeeId);
    }
    getUserById(employeeId){
        console.log("iiiu",REST_API_URL + '/' + employeeId)
        return axios.get(REST_API_URL + '/' + employeeId);
    }

    updateRecords(employeeId,user){
        
        return axios.put(REST_API_URL + '/' +employeeId,user);
    }
    getMail(email)
    {
        // console.log("kkkkk",REST_API_URL +'/' +email,user);
        return axios.get(REST_API_CHECK_URL + '/' +email);
    }
    getPaging(page,size)
    {
        return axios.get(REST_API_PAGINATION_URL + '/' +page,size);
    }

}

export default new EmployeeService();