
if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
$(document).ready(function (event) {
    var uloga = localStorage.getItem("uloga");
    var termin = localStorage.getItem('termin');

    let url = new URL('http://localhost:8011/api/treninzi/odabir');

    url.searchParams.append('uloga', uloga);
    url.searchParams.append('termin', termin);



    console.log(termin);

    $.ajax({
        type: "GET",
        url: url ,
        dataType: "json",
        success: function (res) {
            alert("Usao u success");






            let row = "<tr>";
            row += "<td>" + res.datum + "</td>";
            row += "<td>" + res.cena + "</td>";
            row += "<td>" + res.brojprijavljenihclanova + "</td>"
            row += "<td>" + res.nazivfitnescentra + "</td>";
            row += "<td >" + res.oznaka + "</td>";
            row += "<td>" + res.ime + "</td>";
            row += "<td>" + res.prezime + "</td>";
            row += "<td>" + res.nazivtreninga + "</td>";
            row += "<td>" + res.opis + "</td>";
            row += "<td>" + res.tip + "</td>";
            row += "<td>" + res.trajanje + "</td>";
            if(localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
                row += "<td>" + "    <input  type=\"radio\" name=\"brprijavljenih\"  value=" + res.id + "  />" + "</td>";
            }
            row += "</tr>";


            $('#prijava').append(row);




        },
        error: function () {
            alert("Greška!");
        }
    });

});}

else{
    if(localStorage.getItem("uloga") === "TRENER"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "trener.html";
    }
    else if(localStorage.getItem("uloga") === "ADMINISTRATOR"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "administrator.html";
    }
    else{
        alert("Nemate pristup ovoj stranici!");
        window.location.href ="login.html";
    }

}



if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
    $(document).on("click", '#prijavazatermin1', function(event){

        var uloga = localStorage.getItem("uloga");
        var termin = localStorage.getItem('termin');
        var korisnik = localStorage.getItem("id");

        let url = new URL('http://localhost:8011/api/korisnici/prijavljeni');

        url.searchParams.append('uloga', uloga);
        url.searchParams.append('termin', termin);
        url.searchParams.append('korisnik', localStorage.getItem("id"));


        console.log(termin);


        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",

            success: function (res) {

                alert("Uspesno ste se prijavili za odabrani termin!");
            },
            error: function () {
                alert("Vec je popunjena sala za odabrani termin!");
            }

        });


    });}
else{
    if(localStorage.getItem("uloga") === "TRENER"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "trener.html";
    }
    else if(localStorage.getItem("uloga") === "ADMINISTRATOR"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "administrator.html";
    }
    else{
        alert("Nemate pristup ovoj stranici!");
        window.location.href ="login.html";
    }

}