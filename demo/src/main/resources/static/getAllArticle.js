fetch('http://localhost:8080/viewArticle', {method: 'GET'})
    .then(res => res.json())
    .then(article => {
        console.log(article.list[2].relase);
        console.log(article.list[1].relase);
        addDiv(Object.keys(article.list).length, article);
    })
    .catch(
        err => console.error(err)
    );

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
        divComment.setAttribute('class', 'div-comment');
        var form = document.createElement('form');  //form
        var textArea = document.createElement('textarea');
        var inputIdArticle = document.createElement('input');
        inputIdArticle.setAttribute('type', 'hidden');
        inputIdArticle.setAttribute('name', 'articleId');
        inputIdArticle.setAttribute('value', i.toString());
        textArea.setAttribute('name', 'comment-body');
        form.setAttribute('action', '/createComment');
        form.setAttribute('method', 'post');
        var button = document.createElement('button');
        button.setAttribute('value', 'add comment');
        button.appendChild(document.createTextNode('add comment'));
        form.appendChild(inputIdArticle);
        form.appendChild(textArea);
        form.appendChild(button);
        divComment.appendChild(form);
        var divContainerForComments = document.createElement('div');
        divContainerForComments.setAttribute('class', 'div-container-for-comments');


        //TODO  something gone wrong, don't know what.
        var containerForComment;
        fetch('http://localhost:8080/getAllComments?id='.concat((i+1).toString()), {method: 'GET'})
            .then(response => response.json())
            .then(comment => {
                console.log(comment);
                containerForComment = comment;
            })
            .catch(
                err => console.error(err)
            );
        console.log(containerForComment);

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

function listAllComment() {

}

//TODO
function createComment() {

}


//TODO
function displayAllComment() {

}

