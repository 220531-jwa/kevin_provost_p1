function setupEmployee() {
    let user = sessionStorage.getItem("user");
    parsedUser = JSON.parse(user);
    let empId = parsedUser.empId;
    console.log(empId);
    return empId;

}

document.getElementById('get').onclick = getData;

function getData() {
    var userInput = document.getElementById('reimbStatus').value;
    let empId = setupEmployee();
    console.log("empId: " + empId);
    console.log("userInput: " + userInput);
    fetchData();
    
    async function fetchData() {
        let empId = setupEmployee();
        let response = await fetch('http://localhost:8080/employeeLanding/' + empId + '/status/' + userInput);
        if (response.status === 200) {
            let requests = await response.json();
            console.log(requests);
            for (i = 0; i < requests.length; i++) {
                let req = requests[i];
                populateData(req);
            }
        } else {
            console.log("You have no requests with that status.");
        }
    }
}

function populateData(requests) {

let dataSection = document.getElementById('empReimbTableBody'); 


let reimbId = requests.reimbId;
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

addRow.append(addReimbId,addReimbType,addGradingFormat,
    addMinPassingGrade,addReimbAmount,addReimbSubmitted,
    addEventDate,addEventTime,addEventLocation,addReimbDesc,
    addReimbComplete,addReimbStatus,addManagerNotes,
    addIsUrgent);

addReimbId.innerHTML = reimbId;
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