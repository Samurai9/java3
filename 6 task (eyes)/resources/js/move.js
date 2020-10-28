x = null;
y = null;

function main() {
	followMouse();
	setInterval(moveApples, 1000/60);
}


function followMouse(){
	document.addEventListener('mousemove', function(e){
		x = e.clientX;
		y = e.clientY;
	})
}


function moveApples(){

	//<----Левый----->
	leftApple = document.getElementById("left-apple"); 
	//Глаза
	x0 = 35;
	y0 = 2;
	//Курсор (перенос осей координат в центр зрачка)
	x1 = x - 669; 
	y1 = y - 185;
	
	s = Math.sqrt((y1-y0)*(y1-y0)+(x1-x0)*(x1-x0));
	r = s;
	if(s > 20){
		s = 20;
	}
	k = s/r;

	x3 = x0 + (x1-x0)*k;
	y3 = y0 + (y1-y0)*k;

	leftApple.style.top = y3 + 'px';
	leftApple.style.left = x3 + 'px';

	//<----Правый----->
	rigthApple = document.getElementById("rigth-apple"); 
	//Курсор (перенос осей координат в центр зрачка)
	x1 = x - 779; 
	y1 = y - 185;
	s = Math.sqrt((y1-y0)*(y1-y0)+(x1-x0)*(x1-x0));
	r = s;
	if(s > 20){
		s = 20;
	}
	k = s/r;

	x3 = x0 + (x1-x0)*k;
	y3 = y0 + (y1-y0)*k;

	rigthApple.style.top = y3 + 'px';
	rigthApple.style.left = x3 + 'px';

}

