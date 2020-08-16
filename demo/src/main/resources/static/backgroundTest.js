var canvas = document.querySelector("#playground");
const MAX_AMOUNT_OFPARTICLE = 10000;
var particles = [];
var ctx = canvas.getContext('2d');


console.log("window innerwidth: ");
console.log(window.innerWidth);
console.log('canvas client width');
console.log(canvas.clientWidth);

ctx.fillStyle = 'red';

function initialise() {
    document.addEventListener('DOMContentLoaded', () => {
        canvas.clientWidth = window.innerWidth;
        canvas.clientHeight = window.innerHeight;
    });
}

initialise();


/*var limitersWidth = function () {
    var wholeRangeOfWidth = Math.random() * window.innerWidth;

    //TODO define x1 and x2
    if (wholeRangeOfWidth > x1 && wholeRangeOfWidth < x2) {
        limitersWidth();
    } else {
        return wholeRangeOfWidth;
    }
};

var limitersHeight = function () {
    //TODO
};*/

var colapse = function (){
    particles.forEach(function (p){
        p.radius *= 0.99;
    })
}



var create = function () {
    if (particles.length > MAX_AMOUNT_OFPARTICLE) {
        particles.shift();
    }
    var particle = {
        x: Math.random() * window.innerWidth,
        y: Math.random() * window.innerHeight,
        xVel: (Math.random() - 0.5),
        yVel: (Math.random() - 0.5),
        radius: 2
    };
    particles.push(particle);
};


var move = function () {
    particles.forEach(function (p) {
        p.x += p.xVel;
        p.y += p.yVel;
    });
};

var draw = function () {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    particles.forEach(function (p) {
        ctx.beginPath();
        ctx.arc(p.x, p.y, p.radius, 0, Math.PI * 2);
        ctx.fill();
    });
};

var displaycordinates = function (){
    particles.forEach(function (p){
        console.log('x cordinates: ',p.x);
        console.log('table lenght: ',particles.length);
    })
}

/*var escapeFromMouse = function (){
    particles.forEach(function (p){
        if ()
    })
}*/

var loop = function () {
    create();
    draw();/*
    colapse();*/
    move();
    displaycordinates();
    window.requestAnimationFrame(loop);
};


loop();
