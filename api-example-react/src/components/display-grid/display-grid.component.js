import StudentDisplay from "./student-display/student-display.component";

export default function DisplayGrid(props) {
    const { students } = props;
    return (
        <div>
            {students.map((student, id) =>
                <StudentDisplay student={student} key={id} />
            )}
        </div>
    );
}