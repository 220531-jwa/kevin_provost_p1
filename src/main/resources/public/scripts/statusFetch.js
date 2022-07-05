//let apiURL = 'http://localhost:8080/managerLanding';

document.getElementById('getStatus').onclick = getData;

function getData() {
    var userInput = document.getElementById('reimbStatus').value;
    console.log(userInput);
    fetchData();

    async function fetchData() {
        // console.log(`${apiURL}/status/${userInput}`);
        // let response = await fetch(`${apiURL}/status/${userInput}`);
        let response = await fetch('http://localhost:8080/managerLanding/status/' + userInput);
        if (response.status === 200) {
            let requests = await response.json();
            console.log(requests);
            for (i = 0; i < requests.length; i++) {
                let req = requests[i];
                populateData(req);
            }
        } else {
            console.log("There are no requests with that status.");
        }
    }
}

function populateData(requests) {

    console.log(requests);

    let dataSection = document.getElementById('reimbResultTableBody');

    dataSection.innerHTML = "";


    let reimbId = requests.reimbId;
    let empId = requests.empId;
    let reimbType = requests.reimbType;
    let gradingFormat = requests.gradingFormat;
    let minPassingGrade = requests.minPassingGrade;
    let reimbAmount = requests.reimbAmount;
    let reimbSubmitted = requests.reimbSubmitted;
    let eventDate = requests.eventDate;
    let eventTime = requests.eventTime;
    let eventLocation = requests.eventLocation;
    let reimbDesc = requests.reimbDesc;
    let reimbComplete = requests.reimbComplete;
    let reimbStatus = requests.reimbStatus;
    let managerNotes = requests.managerNotes;
    let isUrgent = requests.isUrgent;

    let addRow = document.createElement("tr");
    let addReimbId = document.createElement('td');
    let addEmpId = document.createElement('td');
    let addReimbType = document.createElement('td');
    let addGradingFormat = document.createElement('td');
    let addMinPassingGrade = document.createElement('td');
    let addReimbAmount = document.createElement('td');
    let addReimbSubmitted = document.createElement('td');
    let addEventDate = document.createElement('td');
    let addEventTime = document.createElement('td');
    let addEventLocation = document.createElement('td');
    let addReimbDesc = document.createElement('td');
    let addReimbComplete = document.createElement('td');
    let addReimbStatus = document.createElement('td');
    let addManagerNotes = document.createElement('td');
    let addIsUrgent = document.createElement('td');

    addRow.append(addReimbId, addEmpId, addReimbType, addGradingFormat, addMinPassingGrade, addReimbAmount, addReimbSubmitted,
        addEventDate, addEventTime, addEventLocation, addReimbDesc, addReimbComplete, addReimbStatus, addManagerNotes, addIsUrgent);

    addReimbId.innerHTML = reimbId;
    addEmpId.innerHTML = empId;
    addReimbType.innerHTML = reimbType;
    addGradingFormat.innerHTML = gradingFormat;
    addMinPassingGrade.innerHTML = minPassingGrade;
    addReimbAmount.innerHTML = reimbAmount;
    addReimbSubmitted.innerHTML = reimbSubmitted;
    addEventDate.innerHTML = eventDate;
    addEventTime.innerHTML = eventTime;
    addEventLocation.innerHTML = eventLocation;
    addReimbDesc.innerHTML = reimbDesc;
    addReimbComplete.innerHTML = reimbComplete;
    addReimbStatus.innerHTML = reimbStatus;
    addManagerNotes.innerHTML = managerNotes;
    addIsUrgent.innerHTML = isUrgent;

    dataSection.append(addRow);
}
