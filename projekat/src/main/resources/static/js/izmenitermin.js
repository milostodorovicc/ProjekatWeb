$(document).ready(function () {
    if (localStorage.getItem('uloga') === "TRENER") {


        let url = new URL('http://localhost:8011/api/treninzi/nadjitermin');

        let urlParams = new URLSearchParams(window.location.search);
        let termin = urlParams.get('id');

        if(termin === 'undefined' || termin === null){
            alert('Niste odabrali termin!');
            window.location.href = "terminitrenera.html";
        }

        else{

        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('termin', termin);



        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (res) {

                $('#datumivreme').val(res.datum);
                $('#cena').val(res.cena);





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




$(document).on("click", '#svesale', function(){
    if (localStorage.getItem('uloga') === "TRENER") {


        let url = new URL('http://localhost:8011/api/fitnescentar/nadjisale1');




        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('korisnik', localStorage.getItem('id'));



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



                    row += "<td>" + "    <input id=" + i + " type=\"radio\" name=\"sala\"  value=" + res[i].id + "  />" + "</td>";


                    row += "</tr>";
                    $('#izmenisalu').append(row);

                }
            },
            error: function () {
                alert("Greška!");
            }
        });







    } else {
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


$(document).on("click", '#promenatermina', function(){
    if (localStorage.getItem('uloga') === "TRENER") {


        let url = new URL('http://localhost:8011/api/treninzi/izmenitermin');

        let sala = $("input[name=sala]:checked").val();


        if(typeof sala === 'undefined' || sala === null) {
            alert('Niste odabrali salu!');
            window.location.reload(true);
        }

        else{

        let datum = $('#datumivreme').val();
        let cena = $('#cena').val();

        let urlParams = new URLSearchParams(window.location.search);
        let termin = urlParams.get('id');

        var termin1 = {
            datum,
            cena

        }


        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('termin', termin);
        url.searchParams.append('sala', sala);



        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(termin1),
            success: function (res) {
                alert("Uspesno ste izmenili odabrani termin!");
                window.location.reload(true);




            },
            error: function () {
                alert("Niste uspeli da izmenite termin!");
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






