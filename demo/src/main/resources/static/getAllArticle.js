fetch('http://localhost:8080/viewArticle', {method: 'GET'})
    .then(res => res.json())
    .then((article) => {

        console.log(article.list[2].relase);
        console.log(article.list[1].relase);
        console.log(article.list[3].relase);

        var length = Object.keys(article.list).length;
        addDiv(length,article);
    })
    .catch(
        err => console.error(err)
    );


function addDiv(lenght, data) {
    var div = document.getElementById('article-container')
    for (var i = 0; i < lenght; i++) {

        var divName = document.createElement('div');
        divName.setAttribute('class','div-name');
        if (data.list[i].name == null){
            divName.appendChild(document.createTextNode('domyslny uzytkownik'));
        }else {
            divName.appendChild(document.createTextNode(data.list[i].name));
        }


        var divData = document.createElement('div');
        divData.setAttribute('class','div-data');
        divData.appendChild(document.createTextNode(data.list[i].relase));

        var divContent = document.createElement('div');
        divContent.setAttribute('class','div-content');
        divContent.appendChild(document.createTextNode(data.list[i].content));

        var divTitle = document.createElement('div');
        divTitle.setAttribute('class','div-title');
        divTitle.appendChild(document.createTextNode(data.list[i].title));

        var articleElement = document.createElement('div');
        articleElement.setAttribute('class','div-element');

        articleElement.appendChild(divName);
        articleElement.appendChild(divData);
        articleElement.appendChild(divTitle);
        articleElement.appendChild(divContent);

        div.appendChild(articleElement);
    }
}

