$(document).on("click", '#novasala1', function () {

    if(localStorage.getItem('uloga') === "ADMINISTRATOR"){
    var kapacitet = $("#kapacitet").val();
    var oznaka = $("#oznaka").val();
    let urlParams = new URLSearchParams(window.location.search);
    let fitnescentar1 = urlParams.get('id');

    console.log(fitnescentar1)
    alert("eee");


    if(fitnescentar1 === 'undefined' ){
        alert("Niste odabrali fitnes centar!");
        window.location.href = "svifitnescentri.html";
    }

        if(fitnescentar1 == null ){
            alert("Niste odabrali fitnes centar!");
            window.location.href = "svifitnescentri.html";
        }



    var novasala ={
        kapacitet,
        oznaka
    }

    // var fitnescentar1 = localStorage.getItem('fitnescentar1');
    var uloga = localStorage.getItem('uloga');

    let url = new URL('http://localhost:8011/api/fitnescentar/novasala');

    url.searchParams.append('fitnescentar1', fitnescentar1);
    url.searchParams.append('uloga', uloga);


    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novasala),
        success: function (res) {
            alert("Uspesno ste dodali novu salu u odabrani fitnes centar!");

        },
        error: function () {
            alert("Greška!");
        }
    });}

    else{
        if(localStorage.getItem("uloga") === "TRENER"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "trener.html";
        }
        else if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        }
        else{
            alert("Nemate pristup ovoj stranici!");
            window.location.href ="login.html";
        }

    }


});







$(document).ready(function () {
    if (localStorage.getItem('uloga') === "ADMINISTRATOR") {
        alert("ok");
    } else {
        if (localStorage.getItem("uloga") === "TRENER") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "trener.html";
        } else if (localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        } else {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "login.html";
        }

    }
});