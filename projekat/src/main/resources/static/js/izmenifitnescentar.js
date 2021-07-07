$(document).ready(function (){
    if(localStorage.getItem('uloga') === "ADMINISTRATOR") {

        let urlParams = new URLSearchParams(window.location.search);
        let fitnescentar = urlParams.get('id');

        if( fitnescentar === 'undefined' || fitnescentar === null ){
            alert("Niste odabrali fitnes centar");
            window.location.href = "svifitnescentri.html";
        }
        // if( fitnescentar === null ){
        //     alert("Niste odabrali fitnes centar");
        //     window.location.href = "svifitnescentri.html";
        // }


else{
    // var fitnescentar = localStorage.getItem('fitnescentar');
    var uloga = localStorage.getItem('uloga');


    let url = new URL('http://localhost:8011/api/fitnescentar/jedan');

    url.searchParams.append('fitnescentar', fitnescentar);
    url.searchParams.append('uloga', uloga);



    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",

        success: function (res) {




            $("input#naziv").val(res.naziv);
            $("input#adresa").val(res.adresa);
            $("input#brojtelefonacentrale").val(res.brojtelefonacentrale);
            $("input#email").val(res.email);




        },
        error: function () {
            alert("Greska!");
            window.location.href = "svifitnescentri.html";
        }

    });}}

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


$(document).on("click", '#fitnescentar1', function () {


    if(localStorage.getItem('uloga') === "ADMINISTRATOR") {

        let urlParams = new URLSearchParams(window.location.search);
        let fitnescentar= urlParams.get('id');

        var naziv = $("#naziv").val();
        var adresa = $("#adresa").val();
        var brojtelefonacentrale = $("#brojtelefonacentrale").val();
        var email = $("#email").val();


        var fitnescentar1 = {
            naziv,
            adresa,
            brojtelefonacentrale,
            email
        }




        var uloga = localStorage.getItem('uloga');

        let url = new URL('http://localhost:8011/api/fitnescentar/izmenifitnescentar');

        url.searchParams.append('fitnescentar', fitnescentar);
        url.searchParams.append('uloga', uloga);


        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(fitnescentar1),
            success: function (res) {
                alert("Uspesno ste izmenili fitnes centar!");
                 window.location.reload(true);
            },
            error: function () {
                alert("Greška!");
            }
        });

    }


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