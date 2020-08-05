fetch('http://localhost:8080/viewArticle', {method: 'GET'})
    .then(res => res.json())
    .then((article) => {

        var length = Object.keys(article.list).length;
        addElementToList(length, article);
    })
    .catch(
        err => console.error(err)
    );

function addElementToList(length, data) {
    var ul = document.getElementById('dynamic-list');
    for (var i = 0; i < length; i++) {
        var li = document.createElement('li');
        li.setAttribute('class', 'element-list');
        li.appendChild(document.createTextNode(data.list[i].content));
        ul.appendChild(li);
    }
}

