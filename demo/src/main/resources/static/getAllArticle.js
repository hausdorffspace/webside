fetch('http://localhost:8080/viewArticle', {method: 'GET'})
    .then(res => res.json())
    .then((article) => {

        var length = Object.keys(article.list).length;
        addElementToList(length, article);
        /*console.log(article.list[0].id);*/
        test();
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

function test() {
    var demo = document.getElementById('demo')
    var htmlDivElement = document.createElement('div');
    htmlDivElement.setAttribute('class', 'class-test')
    htmlDivElement.innerHTML = '<h1> to jest tekst </h1>'
    demo.appendChild(htmlDivElement);
}