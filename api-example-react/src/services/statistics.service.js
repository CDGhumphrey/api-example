export default function getStatistics() {
    return fetch('http://localhost:8080/statistics/',
        {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .catch(err => alert("Error retrieving statistics."));
}

