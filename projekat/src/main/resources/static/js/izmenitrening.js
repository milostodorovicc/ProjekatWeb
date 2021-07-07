$(document).ready(function () {
    if (localStorage.getItem('uloga') === "TRENER") {

        let urlParams = new URLSearchParams(window.location.search);
        let trening = urlParams.get('id');

        if( trening === 'undefined' || trening === null){
            alert("Niste odabrali trening!");
            window.location.href = "svitreninzi.html";

        }

        else{




        let url = new URL('http://localhost:8011/api/treninzi/nadjitrening');



        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('trening', trening);



        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (res) {




                    $('input#naziv').val(res.naziv);
                    $('input#opis').val(res.opis);
                    $('input#tip').val(res.tip);
                    $('input#trajanje').val(res.trajanje);




            },
            error: function () {
                alert("Greška!");
            }
        });}}







     else {
        if (localStorage.getItem("uloga") === "ADMINISTRATOR") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "administrator.html";
        } else if (localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        } else {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "login.html";
        }

    }
});



$(document).on("click", '#izmenitrening', function(){
    if(localStorage.getItem('uloga') === "TRENER") {


        let urlParams = new URLSearchParams(window.location.search);
        let trening = urlParams.get('id');



        if( trening === 'undefined'){
            alert("Niste odabrali trening!");
            window.location.href = "svitreninzi.html";

        }

        if( trening === null){
            alert("Niste odabrali trening!");
            window.location.href = "svitreninzi.html";

        }




        let naziv = $('#naziv').val();
        let opis = $('#opis').val();
        let tip = $('#tip').val();
        let trajanje = $('#trajanje').val();


        var trening1 = {
            naziv,
            opis,
            tip,
            trajanje
        }

        let url = new URL('http://localhost:8011/api/treninzi/izmenitrening');


        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('trening', trening);


        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(trening1),
            success: function (res) {
                alert("Uspesno ste izmenili trening!");
                window.location.reload(true);

            },
            error: function () {
                alert("Greška!");
            }
        });



    }


    else {
        if (localStorage.getItem("uloga") === "ADMINISTRATOR") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "administrator.html";
        } else if (localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        } else {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "login.html";
        }

    }




});