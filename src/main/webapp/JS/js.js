
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


