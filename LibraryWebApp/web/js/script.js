function loanBook() {
    location.href = 'registerClient';
}

function registeredClient() {
    location.href = 'registeredClient';
}

function goToHome() {
    location.href = 'books';
}

function manageBooks() {
    location.href = 'addBook';
}
function manageClients(){
    location.href='/library/manage/app/clients';
}
function loadImages() {
    var i = 1;
    document.write("<div id='imgs'><div>");
    while (i <= 10) {
        document.write("<img src='assets/images/book" + (i) + ".jpg' width='200' height='200'>");
        i++;
    }document.write("</div></div>");
}

function changeImage(){
//    if(myIndex>10){
//        myIndex=1;
//    }
    document.getElementsById('bookImages').src='assets/images/book8.jpg';
//    myIndex++;
}

function next(){
    document.getElementsById('bookImages').src='assets/images/book8.jpg';
}