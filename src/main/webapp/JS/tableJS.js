/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var url = "http://localhost:8084/Sem3CA2/api/person/complete/";

var promise = fetch(url, {method: 'get'});
promise.then(function (response) {
    return response.text();
}).then(function (text) {
    var personArray = JSON.parse(text);


    for (var i = 0; i < personArray.length; i++) {
    
        var tabBody = document.getElementsByTagName("tbody").item(0);
        var row = document.createElement("tr");
        var cell1 = document.createElement("td");
        var cell2 = document.createElement("td");
        var cell3 = document.createElement("td");

        var textnode1 = document.createTextNode(personArray[i].firstName);
        var textnode2 = document.createTextNode(personArray[i].lastName);
        var textnode3 = document.createTextNode(personArray[i].email);
        
        cell1.appendChild(textnode1);
        cell2.appendChild(textnode2);
        cell3.appendChild(textnode3);

        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        tabBody.appendChild(row);
    }
});