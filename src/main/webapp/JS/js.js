
var url = "http://localhost:8084/Sem3CA2/api/person/addPerson";
//var form = document.getElementsByTagName(form)[0];
var firstnameEl = document.getElementById("firstname");
var lastnameEl = document.getElementById("lastname");
var emailEl = document.getElementById("email");
document.getElementById("inputForm").onsubmit = function (e) {
    var firstname = firstnameEl.value;
    var lastname = lastnameEl.value;
    var email = emailEl.value;
    console.log("firstname: "+firstname);
    e.preventDefault();
    var promise = fetch(url, {method: 'post',
            headers: {
            "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({
                    firstName: firstname,
                    lastName: lastname,
                    email: email
            })
        });
    promise.then(function (response) {
        return response.text();
    }).then(function (text) {
        console.log(text);
    });
};