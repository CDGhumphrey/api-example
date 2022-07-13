export default function StatisticsGrid(props) {
    const students = props.students;
    return (
        <div>
            <span>Total Number Of Students Enrolled:</span>
            <span>{students && students.length}</span>

            <div>
                <span>Grade Level Breakdown</span>
                <span>{getAllClassCounts(students)}</span>
            </div>
        </div>
    )
}

function getAllClassCounts(students) {
    const allGradeLevelCounts = {};

    for (const student of students) {
        if (allGradeLevelCounts[student.gradeLevel]) {
            allGradeLevelCounts[student.gradeLevel]++;
        }
        else {
            allGradeLevelCounts[student.gradeLevel] = 1;
        }
    }

    return Object.keys(allGradeLevelCounts).map(gradeLevel =>
        getGradeStatistics(gradeLevel, allGradeLevelCounts[gradeLevel]));
}

function getGradeStatistics(gradeLevel, studentCount) {
    return (
        <div>
            <span>Grade Level: {gradeLevel}</span>
            <span>Student Count: {studentCount}</span>
        </div>
    );
}