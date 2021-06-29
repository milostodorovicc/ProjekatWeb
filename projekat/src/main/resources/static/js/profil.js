$(document).ready(function(){

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
            alert("usao u success");


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