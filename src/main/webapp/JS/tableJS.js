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
    var delBut = document.createElement("BUTTON");
    var delButText = document.createTextNode("Delete");
    delBut.appendChild(delButText);

    for (var i = 0; i < personArray.length; i++) {

        var tabBody = document.getElementsByTagName("tbody").item(0);
        var row = document.createElement("tr");
        var cell1 = document.createElement("td");
        var cell2 = document.createElement("td");
        var cell3 = document.createElement("td");
        var cell4 = document.createElement("td");
       // var cell5 = document.createElement("td");
        var textnode1 = document.createTextNode(personArray[i].id);
        var textnode2 = document.createTextNode(personArray[i].firstName);
        var textnode3 = document.createTextNode(personArray[i].lastName);
        var textnode4 = document.createTextNode(personArray[i].email);
        //var textnode5 = document.createTextNode();
        //"<div><button id=\"del\" class=\"btn btn-danger\" type=\"button\" name=\"button\">Delete</button></div>"
        //<button id="edit" class="btn btn-primary" type="button" name="button">Edit</button>'

        cell1.appendChild(textnode1);
        cell2.appendChild(textnode2);
        cell3.appendChild(textnode3);
        cell4.appendChild(textnode4);
        //cell5.appendChild(textnode5);

        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);
        //row.appendChild(cell5);
        tabBody.appendChild(row);
    }
});
