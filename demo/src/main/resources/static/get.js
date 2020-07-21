fetch('http://localhost:8080/test')
    .then(res => res.json())
    .then((out) => {
        console.log('Output: ', out);
        var name = out.list[0];
        document.getElementById('demo').innerHTML = name;
    }).catch(err => console.error(err));

