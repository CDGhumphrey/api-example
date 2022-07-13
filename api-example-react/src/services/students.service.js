import axios from 'axios';

const studentCache = [];

const addStudent = function (student) {
    return axios.post('http://localhost:8080/student', student)
        .then(
            (e) => {
                alert("student successfully created")
                studentCache.push(e.data);
            })
        .catch((err) =>
            alert("Error creating student"));
}

const getCachedStudents = function () {
    return studentCache;
}


const loadStudents = function () {
    return axios.get('http://localhost:8080/student')
        .then(
            (e) => {
                alert("students successfully loaded")
                studentCache.push(...   e.data);
            })
        .catch((err) =>
            alert("Error loading students"));
}

const StudentService = {
    addStudent: addStudent,
    getCachedStudents: getCachedStudents,
    loadStudents: loadStudents
}
export default StudentService;