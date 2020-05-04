import axios from 'axios';

const api = axios.create({
	baseURL: 'http://localhost:8090/tcc-java',
	headers: {
		'Authorization': localStorage.getItem('token')
	}
});

export default api;