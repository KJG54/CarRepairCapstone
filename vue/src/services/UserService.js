import axios from "axios";

export default {

    getCarsByUser(id) {
        return axios.get(`/user/${id}`)
    },
    getUsers() {
        return axios.get(`/user`)
    }

}