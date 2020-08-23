fetch('http://localhost:8080/viewArticle', {method: 'GET'})
    .then(res => res.json())
    .then((article) => {

        console.log(article.list[2].relase);
        console.log(article.list[1].relase);
        console.log(article.list[3].relase);

        var length = Object.keys(article.list).length;
        addDiv(length, article);
    })
    .catch(
        err => console.error(err)
    );

/*var allComents = function getAllComent(){
    fetch('http://localhost:8080/getAllComments', {method: 'GET'})
        .then(res => res.json())
        .then((comments) => )
}*/

function addDiv(lenght, data) {
    var div = document.getElementById('article-container')
    for (var i = 0; i < lenght; i++) {

        var divName = document.createElement('div');
        divName.setAttribute('class', 'div-name');
        if (data.list[i].name == null) {
            divName.appendChild(document.createTextNode('Annonymous'));
        } else {
            divName.appendChild(document.createTextNode(data.list[i].name));
        }


        //TODO date ?????????? if(true)????
        var divData = document.createElement('div');
        divData.setAttribute('class', 'div-data');
        if (true) {
            divData.appendChild(document.createTextNode("18 maj"));
        } else {
            divData.appendChild(document.createTextNode(data.list[i].relase));
        }

        var divContent = document.createElement('div');
        divContent.setAttribute('class', 'div-content');
        divContent.appendChild(document.createTextNode(data.list[i].content));

        var divTitle = document.createElement('div');
        divTitle.setAttribute('class', 'div-title');
        divTitle.appendChild(document.createTextNode(data.list[i].title));


        var divComment = document.createElement('div');
        divComment.setAttribute('class','div-comment');
        var form = document.createElement('form');  //form
        var input = document.createElement('input');
        var inputIdArticle = document.createElement('input');
        inputIdArticle.setAttribute('type','hidden');
        inputIdArticle.setAttribute('name','articleId');
        inputIdArticle.setAttribute('value',i.toString());
        input.setAttribute('type','text');
        input.setAttribute('name','comment-body');
        form.setAttribute('action','/createComment');
        form.setAttribute('method','post');
        var button = document.createElement('button');
        button.setAttribute('value', 'add comment');
        button.appendChild(document.createTextNode('add comment'));
        form.appendChild(inputIdArticle);
        form.appendChild(input);
        form.appendChild(button);
        var divContainerForComments = document.createElement('div');
        divContainerForComments.setAttribute('class','div-container-for-comments');
        /*for (let j = 0; j < ; j++) {

        }*/
        var listOdComment = document.createElement('div');
        divContainerForComments.appendChild(listOdComment);
        divComment.appendChild(form);

        var articleElement = document.createElement('div');
        articleElement.setAttribute('class', 'div-article');

        articleElement.appendChild(divName);
        articleElement.appendChild(divData);
        articleElement.appendChild(divTitle);
        articleElement.appendChild(divContent);
        articleElement.appendChild(divComment);

        div.appendChild(articleElement);
    }
}

//TODO
function createComment() {

}


//TODO
function displayAllComment() {

}

