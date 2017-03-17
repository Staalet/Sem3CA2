
//var url = "http://localhost:8084/Sem3CA2/api/person/addPerson";
//
//var promise = fetch(url, {method: 'post'});
//promise.then(function (response) {
//    return response.text();
//
//
fetch('http://localhost:8084/Sem3CA2/api/person/addPerson/', {
	method: 'POST', 
	mode: 'cors', 
	redirect: 'follow',
	headers: new Headers({
		'Content-Type': 'application/json'
	})
})
        .then(function() {
    fetch('http://localhost:8084/Sem3CA2/api/person/complete/{1}').then(function(response){
       return response.json(jsonobj); 
    }).then(function(j){
        console.log(j);
    });
});



var jsonobj = (function () {
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