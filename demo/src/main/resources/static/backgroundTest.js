var canvas = document.querySelector('#playground');


canvas.clientWidth = window.innerWidth;
canvas.clientHeight = window.innerHeight;

var ctx = canvas.getContext('2d');

ctx.beginPath();
ctx.fillStyle = 'red';
ctx.arc(10,10,10,0,Math.PI*2);
ctx.fill();