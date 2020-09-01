fetch('http://localhost:8080/viewArticle', {method: 'GET'})
    .then(res => res.json())
    .then(article => {
        console.log(article.articleList[2].relase);
        console.log(article.articleList[1].relase);
        var articleListLenght = Object.keys(article.articleList).length;
        var commentListLenght = Object.keys(article.commentList).length;
        addDiv(articleListLenght,commentListLenght, article);
    })
    .catch(
        err => console.error(err)
    );

function addDiv(articleListlenght,commentListLenght ,data) {
    var div = document.getElementById('article-container')
    for (var i = 0; i < articleListlenght; i++) {

        var divName = document.createElement('div');
        divName.setAttribute('class', 'div-name');
        if (data.articleList[i].name == null) {
            divName.appendChild(document.createTextNode('Annonymous'));
        } else {
            divName.appendChild(document.createTextNode(data.articleList[i].name));
        }


        //TODO date ?????????? if(true)????
        var divData = document.createElement('div');
        divData.setAttribute('class', 'div-data');
        if (true) {
            divData.appendChild(document.createTextNode("18 maj"));
        } else {
            divData.appendChild(document.createTextNode(data.articleList[i].relase));
        }

        var divContent = document.createElement('div');
        divContent.setAttribute('class', 'div-content');
        divContent.appendChild(document.createTextNode(data.articleList[i].content));

        var divTitle = document.createElement('div');
        divTitle.setAttribute('class', 'div-title');
        divTitle.appendChild(document.createTextNode(data.articleList[i].title));


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

        for (var j = 0; j<commentListLenght;j++){
            if (data.articleList[i].id==data.commentList[j].article.id){
                var divCommentContent = document.createElement('div');
                divCommentContent.setAttribute('class','div-Comment-Content');
                divCommentContent.appendChild(document.createTextNode(data.commentList[j].content));
                divContainerForComments.appendChild(divCommentContent)
            }
        }

        //WHOLE Container for article and comment
        var articleElement = document.createElement('div');
        articleElement.setAttribute('class', 'div-article');

        articleElement.appendChild(divName);
        articleElement.appendChild(divData);
        articleElement.appendChild(divTitle);
        articleElement.appendChild(divContent);
        articleElement.appendChild(divComment); //change name
        articleElement.appendChild(divContainerForComments);

        div.appendChild(articleElement);
    }
}

//TODO
function createComment() {

}


//TODO
function displayAllComment() {

}

