if(localStorage.getItem('uloga')==="CLANFITNESCENTRA") {
    $(document).ready(function () {
        var korisnik = localStorage.getItem('id');
        var uloga = localStorage.getItem('uloga');

        let url = new URL('http://localhost:8011/api/korisnici/profil');

        url.searchParams.append('uloga', uloga);

        url.searchParams.append('korisnik', korisnik);


        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",

            success: function (res) {



                $("input:password").val(res.lozinka);
                $("input#email").val(res.email);
                $("input#datumrodjenja").val(res.datumrodjenja);
                $("input#ime").val(res.ime);
                $("input#prezime").val(res.prezime);
                $("input#korisnickoime").val(res.korisnickoime);
                $("input#telefon").val(res.telefon);


            },
            error: function () {
                alert("Greska!");
            }

        });

    });
}
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


if(localStorage.getItem('uloga')=== "CLANFITNESCENTRA"){
$(document).on("submit", "#profilkorisnika", function (event) {
    event.preventDefault();



        var korisnickoime = $("#korisnickoime").val();
        var lozinka = $("#lozinka").val();
        var ime = $("#ime").val();
        var prezime = $("#prezime").val();
        var telefon = $("#telefon").val();
        var email = $("#email").val();
        var datumrodjenja = $("#datumrodjenja").val();
        var uloga = localStorage.getItem('uloga');

    let url = new URL('http://localhost:8011/api/korisnici/izmenjenikorisnik');

    url.searchParams.append('uloga', uloga);

    url.searchParams.append('korisnik', localStorage.getItem("id"));


        var izmenjeniclan = {
            korisnickoime,
            lozinka,
            ime,
            prezime,
            telefon,
            email,
            datumrodjenja,
            uloga
        }



        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(izmenjeniclan),
            success: function (res) {

                alert("Uspesno ste izmenili podatke!");


            },
            error: function () {
                alert("Niste uspeli da izmenite podatke!");
            }
        });});}
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