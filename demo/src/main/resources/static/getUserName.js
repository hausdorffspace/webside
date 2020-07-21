fetch('http://localhost:8080/getUserName')
    .then(res => res.json())
    .then((name) => {
        /*console.log('Output: ', name);*/
        document.getElementById('username').innerHTML = "<h1>" + name.name + "</h1>";
    }).catch(err => console.error(err));

