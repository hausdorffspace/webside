var canvas = document.querySelector("#playground");
const MAX_AMOUNT_OFPARTICLE = 200;
var particles = [];
var ctx = canvas.getContext('2d');


console.log("window innerwidth: ");
console.log(window.innerWidth);
console.log('canvas client width');
console.log(canvas.clientWidth);

ctx.fillStyle = 'red';

function initialise() {
    document.addEventListener('DOMContentLoaded',()=>{
        canvas.clientWidth = window.innerWidth;
        canvas.clientHeight = window.innerHeight;
    });
}

initialise();

var create = function (){
    if (particles.length > MAX_AMOUNT_OFPARTICLE){
        particles.shift();
    }
    var particle = {
        x: Math.random()*window.innerWidth,
        y: Math.random()*window.innerHeight,
        xVel: 10,
        yVel: 10,
        radius: 5
    };
    particles.push(particle);
}


var move = function (){
    particles.forEach(function (p){
        p.x += Math.random() - 0.5;
        p.y += Math.random() - 0.5;
    });
}

var draw = function () {
    ctx.clearRect(0,0,canvas.width,canvas.height);
    ctx.beginPath();
    particles.forEach(function(p){
        ctx.arc(p.x, p.y, p.radius, 0, Math.PI*2);
    });

    ctx.fill();
}

var loop = function () {
    create();
    draw();
    move()
    window.requestAnimationFrame(loop);
}


loop();
