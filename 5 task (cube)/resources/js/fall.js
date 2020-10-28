timer = null;
bottomBorder = 600;
topBorder = 0;
speed = 10;

function start() {
    if (timer != null) {
        clearInterval(timer);
        timer = null;
        document.getElementById("start__button").innerHTML = 'Квадрат, двигайся'
    } else {
        timer = setInterval(drop, 1000 / 600);
        document.getElementById("start__button").innerHTML = 'Остановить движение квадрата';
    }
}

function drop() {
    if (Math.abs(speed) <= 0) {
        clearInterval(timer);
        timer = null;
        document.getElementById("start__button").innerHTML = 'Квадрат, двигайся'
        if (square.offsetTop >= bottomBorder){
            speed = -10;
        } else {
            speed = 10;
        }
    } else {
        square = document.getElementById("img-containerID");
        square.style.top = (parseInt(square.style.top) || 0) + speed + 'px';
        if (square.offsetTop >= bottomBorder) {
            speed -= 2;
            speed = -speed;
        }
        if (square.offsetTop <= topBorder) {
            speed += 2;
            speed = -speed;
        }
    }
}