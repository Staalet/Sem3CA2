
var url = "http://localhost:8084/Sem3CA2/api/person/addPerson";

var promise = fetch(url, {method: 'post'});
promise.then(function (response) {
    return response.text();


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
});