import axios from 'axios';

// encapsulated axios functionality in iffy
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

    const get = (callback, uuid = '') => {
        return axios.get(`${endpoint}/fetch/${uuid}`)
            .then((response) => {
                console.log(response.data);
                callback(response.data);
            })
            .catch((error) => {
                console.log("Error occurred when fetching the data ...", error);
            })
    };

    return {
        get: get,
        update: update,
        create: create
    }

})();

export default Service;