if(localStorage.getItem("uloga")=== "CLANFITNESCENTRA") {
    $(document).ready(function () {
        alert("Pocetna stranica clana fitnes centra");

    });}
else {
    if (localStorage.getItem("uloga") === "TRENER") {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "trener.html"
    } else if (localStorage.getItem("uloga") === "ADMINISTRATOR") {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "administrator.html";
    } else {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "login.html"
    }
}

$(document).on("click","#profil", function(event){
    event.preventDefault();

    window.location.href = "profil.html";





});







