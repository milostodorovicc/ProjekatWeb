   if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
    $(document).ready(function () {
    let url = new URL('http://localhost:8011/api/korisnici/listatermina');



    url.searchParams.append('korisnik', localStorage.getItem("id"));
    url.searchParams.append('uloga', localStorage.getItem("uloga"));


    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",

        success: function (res) {

            for(let i =0 ; i<res.length; i++){



                let row = "<tr>";
                row += "<td>" + res[i].datum + "</td>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<td>" + res[i].brojprijavljenihclanova + "</td>"
                row += "<td>" + res[i].nazivfitnescentra + "</td>";
                row += "<td>" + res[i].oznaka + "</td>";
                row += "<td>" + res[i].ime + "</td>";
                row += "<td>" + res[i].prezime + "</td>";
                row += "<td>" + res[i].nazivtreninga + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";
                if(localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
                    row += "<td>" + "    <input id=" + i + " type=\"radio\" name=\"otkazitermin\"  value=" + res[i].id + "  />" + "</td>";
                }

                row += "</tr>";
                $('#prijavljenitreninzi').append(row);


            }
        },
        error: function () {
            alert("Nemate pristup ovim podacima!");
        }

    });
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


    $(document).on("click", '#otkazitermin', function (event) {

        if(localStorage.getItem('uloga')=== "CLANFITNESCENTRA") {

        var uloga = localStorage.getItem("uloga");
        var termin = $("input[name=otkazitermin]:checked").val();
        var korisnik = localStorage.getItem("id");


        if(typeof termin === 'undefined' || termin === null){
            alert("Niste odabrali termin!");
            window.location.reload(true);

        }

      else{

        let url = new URL('http://localhost:8011/api/korisnici/otkazitermin');

        url.searchParams.append('uloga', uloga);
        url.searchParams.append('termin', termin);
        url.searchParams.append('korisnik', localStorage.getItem("id"));


        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",

            success: function (res) {

                alert("Uspesno ste otkazali prijavu za odabrani termin!");
                $('#prijavljenitreninzi').empty();


                for (let i = 0; i < res.length; i++) {


                    let row = "<tr>";
                    row += "<td>" + res[i].datum + "</td>";
                    row += "<td>" + res[i].cena + "</td>";
                    row += "<td>" + res[i].brojprijavljenihclanova + "</td>"
                    row += "<td>" + res[i].nazivfitnescentra + "</td>";
                    row += "<td>" + res[i].oznaka + "</td>";
                    row += "<td>" + res[i].ime + "</td>";
                    row += "<td>" + res[i].prezime + "</td>";
                    row += "<td>" + res[i].nazivtreninga + "</td>";
                    row += "<td>" + res[i].opis + "</td>";
                    row += "<td>" + res[i].tip + "</td>";
                    row += "<td>" + res[i].trajanje + "</td>";
                    if (localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
                        row += "<td>" + "    <input id=" + i + " type=\"radio\" name=\"otkazitermin\"  value=" + res[i].id + "  />" + "</td>";
                    }

                    row += "</tr>";
                    $('#prijavljenitreninzi').append(row);

                }
                window.location.reload(true);
            },
            error: function () {
                alert("Niste uspeli da otkazete prijavu za odabrani termin!");
            }

        });}}



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
    });



