//var url = "http://localhost:8084/REST_JSON/api/person/10/fName,lName,street,city";
//
//var promise = fetch(url, {method: 'get'});
//promise.then(function (response) {
//    return response.text();
//}).then(function (text) {
//    var personArray = JSON.parse(text);
//
//
//    for (var i = 0; i < personArray.length; i++) {
//        var tabBody = document.getElementsByTagName("tbody").item(0);
//        var row = document.createElement("tr");
//        var cell1 = document.createElement("td");
//        var cell2 = document.createElement("td");
//        var cell3 = document.createElement("td");
//        if (!(personArray[i].city === undefined)) {
//            var cell4 = document.createElement("td");
//        }
//        var textnode1 = document.createTextNode(personArray[i].fName);
//        var textnode2 = document.createTextNode(personArray[i].lName);
//        var textnode3 = document.createTextNode(personArray[i].street);
//        if (!(personArray[i].city === undefined)) {
//            var textnode4 = document.createTextNode(personArray[i].city);
//        }
//        cell1.appendChild(textnode1);
//        cell2.appendChild(textnode2);
//        cell3.appendChild(textnode3);
//        if (!(personArray[i].city === undefined)) {
//            cell4.appendChild(textnode4);
//        }
//        row.appendChild(cell1);
//        row.appendChild(cell2);
//        row.appendChild(cell3);
//        if (!(personArray[i].city === undefined)) {
//            row.appendChild(cell4);
//        }
//        tabBody.appendChild(row);
//    }
//}
//);
(function () {
    function toJSONString(form) {
        var obj = {};
        var elements = form.querySelectorAll("input");
        for (var i = 0; i < elements.length; ++i) {
            var element = elements[i];
            var name = element.name;
            var value = element.value;

            if (name) {
                obj[ name ] = value;
            }
        }

        return JSON.stringify(obj);
    }

    document.addEventListener("DOMContentLoaded", function () {
        var form = document.getElementById("inputForm");
        var output = document.getElementById("output");
        form.addEventListener("submit", function (e) {
            e.preventDefault();
            var json = toJSONString(this);
            output.innerHTML = json;
        }, false);
    });
})();