const myName = prompt("isim giriniz:");


const myNameElement = document.getElementById("myName");
myNameElement.textContent = myName;


function showDateTime() {

    const now = new Date();
    const time = now.toLocaleTimeString();
    const date = now.toLocaleDateString();
    const myClockElement = document.getElementById("myClock");


    myClockElement.textContent = `${date} ${time}`;
    setTimeout(showDateTime, 1000);
}

document.addEventListener("DOMContentLoaded", showDateTime);
