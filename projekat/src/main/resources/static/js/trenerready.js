if(localStorage.getItem("uloga")=== "TRENER") {
    $(document).ready(function () {
        alert("Pocetna stranica trenera");

    });}
else {
    if (localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "clanfitnescentra.html"
    } else if (localStorage.getItem("uloga") === "ADMINISTRATOR") {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "administrator.html";
    } else {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "login.html"
    }
}