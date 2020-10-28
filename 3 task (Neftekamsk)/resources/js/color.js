var consistently = false;
timerId1;
timerId2;
timerId3;
timerId4;



function changeColorToOrange() {
    firstColor = "orange"; //all
    textColor = "#fff";


    document.getElementsByClassName("header")[0].style.backgroundColor = firstColor;
    document.getElementsByTagName("footer")[0].style.backgroundColor = firstColor;

    elements = document.getElementsByClassName("card")
    i = elements.length;
    while (i--) {
        elements[i].style.borderColor = firstColor;
    }

    elements = document.getElementsByTagName("hr")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = firstColor;
    }

    elements = document.getElementsByTagName("a")
    i = elements.length;
    while (i--) {
        elements[i].style.color = firstColor;
    }

    elements = document.getElementsByClassName("btn btn-primary mt-auto")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = firstColor;
        elements[i].style.color = textColor;
        elements[i].style.borderColor = firstColor;
    }

    elements = document.getElementsByClassName("btn btn-primary")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = firstColor;
        elements[i].style.borderColor = firstColor;
        elements[i].style.color  = textColor;
    }

    document.getElementById("search__button").style.color = textColor;
    document.getElementById("search__button").style.backgroundColor = firstColor;

    document.getElementById("carouselExampleIndicators").style.borderColor = firstColor;

    document.getElementById("administration__img").style.borderColor = firstColor;

    document.getElementsByClassName("carousel-inner")[0].style.borderColor = firstColor;

}


function changeColorToGreen() {

    firstColor = "green"; //all
    textColor = "#fff";


    document.getElementsByClassName("header")[0].style.backgroundColor = firstColor;
    document.getElementsByTagName("footer")[0].style.backgroundColor = firstColor;

    elements = document.getElementsByClassName("card")
    i = elements.length;
    while (i--) {
        elements[i].style.borderColor = firstColor;
    }

    elements = document.getElementsByTagName("hr")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = firstColor;
    }

    elements = document.getElementsByTagName("a")
    i = elements.length;
    while (i--) {
        elements[i].style.color = firstColor;
    }

    elements = document.getElementsByClassName("btn btn-primary mt-auto")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = firstColor;
        elements[i].style.color = textColor;
        elements[i].style.borderColor = firstColor;
    }

    elements = document.getElementsByClassName("btn btn-primary")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = firstColor;
        elements[i].style.borderColor = firstColor;
        elements[i].style.color  = textColor;
    }

    document.getElementById("search__button").style.color = textColor;
    document.getElementById("search__button").style.backgroundColor = firstColor;

    document.getElementById("carouselExampleIndicators").style.borderColor = firstColor;

    document.getElementById("administration__img").style.borderColor = firstColor;

    document.getElementsByClassName("carousel-inner")[0].style.borderColor = firstColor;
}

function changeColorToBlue() {
    firstColor = "#005590"; //header, footer
    secondColor = "#007bff"; //card.border, btn
    thirdColor = "blue"; //hr,search btn
    fifthColor = "lightblue" //img border
    textColor = "#fff";


    document.getElementsByClassName("header")[0].style.backgroundColor = firstColor;
    document.getElementsByTagName("footer")[0].style.backgroundColor = firstColor;

    elements = document.getElementsByClassName("card")
    i = elements.length;
    while (i--) {
        elements[i].style.borderColor = secondColor;
    }

    elements = document.getElementsByTagName("hr")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = thirdColor;
    }

    elements = document.getElementsByTagName("a")
    i = elements.length;
    while (i--) {
        elements[i].style.color = secondColor;
    }

    elements = document.getElementsByClassName("btn btn-primary mt-auto")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = secondColor;
        elements[i].style.color = textColor;
        elements[i].style.borderColor = secondColor;
    }

    elements = document.getElementsByClassName("btn btn-primary")
    i = elements.length;
    while (i--) {
        elements[i].style.backgroundColor = secondColor;
        elements[i].style.borderColor = secondColor;
        elements[i].style.color  = textColor;
    }

    document.getElementById("search__button").style.color = textColor;
    document.getElementById("search__button").style.backgroundColor = thirdColor;

    document.getElementById("carouselExampleIndicators").style.borderColor = fifthColor;

    document.getElementById("administration__img").style.borderColor = fifthColor;

    document.getElementsByClassName("carousel-inner")[0].style.borderColor = fifthColor;

}



function changeColorConsistently() { 
    timerId1 = setTimeout(changeColorToBlue, 0000);
    timerId2 = setTimeout(changeColorToOrange, 2000);
    timerId3 = setTimeout(changeColorToGreen, 4000);
    timerId4 = setTimeout(changeColorConsistently, 6000);
}

function stopChangingConsistently(){
    clearInterval(timerId1,0);
    clearInterval(timerId2,0);
    clearInterval(timerId3,0);
    clearInterval(timerId4,0);
}

