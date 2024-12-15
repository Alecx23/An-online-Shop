var colors = ["blue", "yellow", "red", "green", "orange"];
var currentColor = 0;
var lis = document.querySelectorAll("#text");
var audio = new Audio('yippee.mp3');
audio.loop=true;
function changeColor() {  
	
  --currentColor;
  if (currentColor < 0) currentColor = colors.length -1;
  for (var i = 0; i < lis.length; i++) {
    lis[i].style.color = colors[(currentColor +i) % colors.length]
  }

}
audio.play();
setInterval(changeColor, 1000);