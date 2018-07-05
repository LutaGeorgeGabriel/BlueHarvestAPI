import axios from 'axios';

const Service = (function() {

    const endpoint = 'http://localhost:8080';

    const create = (user) => {
        return axios.post(`${endpoint}/create`, user)
            .then((response) => {
                console.log(response.data)
            })
            .catch((error) => {
                console.log("Error occurred when fetching the data ...", error);
            })
    };

    const update = (customerID, initialCredit) => {
        return axios.post(`${endpoint}/update/${initialCredit}`, customerID)
            .then((response) => {
                console.log(response.data)
            })
            .catch((error) => {
                console.log("Error occurred when pushing the data ...", error);
            })
    };

    const fetch = (uuid = '') => {
        return axios.get(`${endpoint}/fetch/${uuid}`)
            .then((response) => {
                console.log(response.data);
            })
            .catch((error) => {
                console.log("Error occurred when fetching the data ...", error);
            })
    };

    return {
        fetch: fetch,
        update: update,
        create: create
    }

})();

export default Service;