document.getElementById('updateStatus').onclick = editReimb;

async function editReimb() {
    let reimbStatus = document.getElementById('reimbStatus').value;
    let reimbId = document.getElementById('reimbId').value;
    let managerNotes = document.getElementById('managerNotes').value;
    let statusName = '';

    if (reimbStatus == 2) {
        statusName = '"In Review"'
    } else if (reimbStatus == 3) {
        statusName = '"Completed"'
    } else if (reimbStatus == 4) {
        statusName = '"Rejected"'
    }

    let updatedReimb = {
        "reimbId": reimbId,
        "reimbStatus": reimbStatus,
        "managerNotes": `Status updated to: ` + statusName + ` on: ` + new Date().toISOString().slice(0, 10) + ` - ` + managerNotes
    }

    console.log(updatedReimb);

    let updatedReimbJson = JSON.stringify(updatedReimb);

    console.log(updatedReimbJson);

    console.log('http://localhost:8080/managerLanding/edit/' + reimbId + '/' + reimbStatus);

    let res = await fetch('http://localhost:8080/managerLanding/edit/' + reimbId + '/' + reimbStatus,
        {
            method: 'PATCH',
            header: { 'Content-Type': 'application/json' },
            body: updatedReimbJson

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