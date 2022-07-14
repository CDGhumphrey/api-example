export default function StatisticsGrid(props) {
    const students = props.students;
    return (
        <div className="stats-container">
            <h2>Enrollment Statistics</h2>
            <div className="totals">
                <span className="title">Total Enrollement</span>
                <span className="value">{students && students.length}</span>
            </div>
            <div className="breakdown">
                <span className="title">Grade Level Breakdown</span>
                <span className="grade-stats">{getAllClassCounts(students)}</span>
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