$(document).ready(function () {
    if (localStorage.getItem('uloga') === "TRENER") {
        let urlParams = new URLSearchParams(window.location.search);
        let trening = urlParams.get('id');
        if( trening === 'undefined' || trening === null){
            alert("Niste odabrali trening!");
            window.location.href = "svitreninzi.html";

        }


     else{
        let url = new URL('http://localhost:8011/api/fitnescentar/nadjisale1');


        url.searchParams.append('korisnik', localStorage.getItem('id'));
        url.searchParams.append('uloga', localStorage.getItem('uloga'));



        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (res) {



                console.log(res);
                for (let i = 0; i < res.length; i++) {


                    let row = "<tr>";
                    row += "<td>" + res[i].oznaka + "</td>";
                    row += "<td>" + res[i].kapacitet + "</td>";

                    row += "<td>" + "    <input type=\"radio\" name=\"sala\"  value=" + res[i].id + "  />" + "</td>";


                    row += "</tr>";
                    $('#sala1').append(row);
                }
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




$(document).on("click", '#novitermin2', function(){
    if(localStorage.getItem('uloga') === "TRENER") {
        var sala = $("input[name=sala]:checked").val();

        let urlParams = new URLSearchParams(window.location.search);
        let trening = urlParams.get('id');


        var korisnik = localStorage.getItem('id');

        let datum = $('#datumivreme').val();
        let cena = $('#cena').val();

        if(!datum || !cena){
            alert("Morate popuniti sve podatke!");
            return;
        }



        if( typeof sala === 'undefined' || sala === null ){
            alert("Niste odabrali salu !");
            window.location.reload(true);

        }





else{




        var termin = {
            datum,
            cena
        }

        let url = new URL('http://localhost:8011/api/treninzi/novitermin1');


        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('trening', trening);
        url.searchParams.append('sala', sala);
        url.searchParams.append('korisnik', korisnik);

        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(termin),
            success: function (res) {
                alert("Uspesno ste napravili novi termin!");
                window.location.reload(true);

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