let baseUrl = "http://localhost:8080/employeeLanding";

// const reimbRequest = {
//     "reimbId": '1',
//     "empId": empId,
//     "reimbType": reimbType,
//     "gradingFormat": gradingFormat,
//     "minPassingGrade": minPassingGrade,
//     "reimbAmount": reimbAmount,
//     "reimbSubmitted": reimbSubmitted,
//     "eventDate": eventDate,
//     "eventTime": eventTime,
//     "eventLocation": eventLocation,
//     "reimbDesc":reimbDesc
// }

function setupEmployee() {
    let user = sessionStorage.getItem("user");
    parsedUser = JSON.parse(user);
    let empId = parsedUser.empId;
    console.log(empId);
    return empId;

}

async function submitRequest() {
    let empId = setupEmployee();
    let reimbType = document.getElementById('reimbType').value;
    let gradingFormat = document.getElementById('gradingFormat').value;
    let minPassingGrade = document.getElementById('minPassingGrade').value;
    let reimbAmount = document.getElementById('reimbAmount').value;
    let reimbSubmitted = new Date().toISOString().slice(0, 10);
    let eventDate = document.getElementById('eventDate').value;
    let eventTime = document.getElementById('eventTime').value;
    let eventLocation = document.getElementById('eventLocation').value;
    let reimbDesc = document.getElementById('reimbDesc').value;

    if (reimbType == 0) {
        reimbAmount = (reimbAmount * 0.8);
    } else if (reimbType == 1) {
        reimbAmount = (reimbAmount * 0.6);
    } else if (reimbType == 2) {
        reimbAmount = (reimbAmount * 0.75);
    } else if (reimbType == 4) {
        reimbAmount = (reimbAmount * 0.9);
    } else if (reimbType == 5) {
        reimbAmount = (reimbAmount * 0.3);
    }

    let reimbRequest = {
        "reimbId": '1',
        "empId": empId,
        "reimbType": reimbType,
        "gradingFormat": gradingFormat,
        "minPassingGrade": minPassingGrade,
        "reimbAmount": reimbAmount,
        "reimbSubmitted": reimbSubmitted,
        "eventDate": eventDate,
        "eventTime": eventTime,
        "eventLocation": eventLocation,
        "reimbDesc": reimbDesc
    }
    console.log(reimbRequest);

    let reimbRequestJson = JSON.stringify(reimbRequest);

    console.log(reimbRequestJson);

    let res = await fetch(
        `${baseUrl}/${empId}`, // the url where we're sending this request
        {
            method: 'POST',
            header: { 'Content-Type': 'application/json' },
            body: reimbRequestJson
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
        })

        .catch((error) => {
            console.log(error);
        })
}