import logo from './logo.svg';
import './App.css';
import DisplayGrid from './components/display-grid/display-grid.component';
import StatisticsGrid from './components/statistics-grid/statistic-grid.component';
import studentService from './services/students.service';
import AddStudentForm from './components/add-student-form/add-student-form.component';
import React, { useState } from 'react';
import StudentService from './services/students.service';

export default function App() {
  const [students, setStudents] = useState([]);
  const [addingStudents, setAddingStudents] = useState(false);

  function toggleAddStudent(){
    setAddingStudents(!addingStudents);
  }
  function updateStudentGrid(){
    toggleAddStudent();
    setStudents(StudentService.getCachedStudents());
  }

  return (  
    <div className="App" >
      <h1>Student Tracker</h1>

      {!addingStudents ? <button onClick={toggleAddStudent}>Add Student</button> : <AddStudentForm updateHandler={updateStudentGrid} />}
  
      <DisplayGrid students={students} />
    </div>
  );
}

