import axios from 'axios';
import React, { useState, useEffect } from 'react';
import StudentService from "../../services/students.service";

export default function AddStudentForm(props) {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [gradeLevel, setGradeLevel] = useState('');
    const [roomNumber, setRoomNumber] = useState('');

    function handleChange(value, callBack) {
        callBack(value);
    }

    function handleSubmit() {
        const student = { firstName, lastName, gradeLevel, roomNumber };
        StudentService.addStudent(student)
            .then((response) => {
                props.updateHandler();
            });
    };

    return (
        <div>
            <label>
                First Name:
                <input type="text" onChange={(event) => handleChange(event.target.value, setFirstName)} />
            </label>
            <label>
                Last Name:
                <input type="text" onChange={(event) => handleChange(event.target.value, setLastName)} />
            </label>
            <label>
                Grade Level:
                <input type="number" onChange={(event) => handleChange(event.target.value, setGradeLevel)} />
            </label>
            <label>
                Class Number:
                <input type="number" onChange={(event) => handleChange(event.target.value, setRoomNumber)} />
            </label>
            <input type="submit" value="Submit" onClick={handleSubmit} />
        </div>
    )
}
