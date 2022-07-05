let baseUrl = "http://localhost:8080"; // /users, /users/1

async function login() {
    document.getElementById("invalid").innerHTML = "";
    console.log("login button pressed")

    // gather input from the user - using our DOM
    let uname = document.getElementById('uname').value;

    let pass = document.getElementById('pass').value;

    // create an object literal 
    let user = {
        "username": uname,
        "pass": pass
    }
        
    // print that to the console
    console.log(user);

    // we need to convert the user object literal to a Json string
    // so we can send it in the body of our request
    let userJson = JSON.stringify(user);
    console.log(userJson);
    
    
    // send a POST request to our backend using the Fetch API
    // fetch method returns a Promise
    let res = await fetch(
                        `${baseUrl}/login`, // the url where we're sending this request
                        {
                            method: 'POST',
                            header: {'Content-Type': 'application/json'},
                            body: userJson
                        }
                    );
    let resJson = await res.json()
        // .then will execute if the promise is successfully resolved
        // .then() takes a function as an argument
        .then((resp) => {
           if (resp.employeeType == 0) {
           console.log(resp); // this is where we will eventually put our DOM manipulation if needed
           sessionStorage.setItem("user", JSON.stringify(resp))
           window.location.assign("../managerLanding.html");}
           else {
            console.log(resp);
            sessionStorage.setItem("user", JSON.stringify(resp))
            window.location.assign("../employeeLanding.html");
           }
        })
        // .catch will execute if there's any error
        .catch((error) => {
            document.getElementById("invalid").innerHTML = "Invalid credentials"
            console.log(error);
        });   
}