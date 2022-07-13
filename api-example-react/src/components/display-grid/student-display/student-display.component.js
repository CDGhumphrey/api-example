import './student-display.component.css';
export default function StudentDisplay({ student }) {
    return (
        <div className= "container">
            <div className="student-info">
                <span className="title">Full Name</span>
                <span className="value">{student.firstName} {student.lastName}</span>
            </div>
            <div className="student-info">
                <span className="title">Grade Level</span>
                <span className="value">{student.gradeLevel}</span>
            </div>
            <div className="student-info">
                <span className="title">Class Number</span>
                <span className="value">{student.roomNumber }</span>
            </div>
        </div>
    )
}