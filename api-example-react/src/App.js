import logo from './logo.svg';
import './App.css';
import DisplayGrid from './components/display-grid/display-grid.component';
import StatisticsGrid from './components/statistics-grid/statistic-grid.component';
import studentService from './services/students.service';
import AddStudentForm from './components/add-student-form/add-student-form.component';
import React, { useEffect, useRef, useState } from 'react';
import StudentService from './services/students.service';

export default function App() {
  const mounted = useRef(false);
  const [students, setStudents] = useState([]);
  const [addingStudents, setAddingStudents] = useState(false);

  useEffect(loadStudents, []);

  function loadStudents() {
    if (mounted.current) {
      return;
    }
    mounted.current = true;
    StudentService.loadStudents()
      .then((response) => {
        setStudents(StudentService.getCachedStudents());
      });
  }
  function toggleAddStudent() {
    setAddingStudents(!addingStudents);
  }
  function updateStudentGrid() {
    toggleAddStudent();
    setStudents(StudentService.getCachedStudents());
  }

  return (
    <div className="App" >
      <h1>Student Tracker</h1>
      {
        !addingStudents ?
          <button className="add-button" onClick={toggleAddStudent}>Add Student</button> :
          <AddStudentForm updateHandler={updateStudentGrid} />
      }
      <DisplayGrid students={students} />
      <StatisticsGrid students={students} />
    </div>
  );
}

