
$(document).on("submit", "form", function (event) {
    event.preventDefault();
     if(document.getElementById("uloga").checked){

    var korisnickoime = $("#korisnickoime").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var telefon = $("#telefon").val();
    var email = $("#email").val();
    var datumrodjenja = $("#datumrodjenja").val();
    var uloga = "CLANFITNESCENTRA";


    var noviclanfitnescentra = {
        korisnickoime,
        lozinka,
        ime,
        prezime,
        telefon,
        email,
        datumrodjenja,
        uloga
    }
    console.log(noviclanfitnescentra);


    $.ajax({
        type: "POST",
        url: "http://localhost:8011/api/korisnici/clanfitnescentra",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviclanfitnescentra),
        success: function (res) {
            console.log(res);
            alert("Clanfitnescentra " + res.id + " je uspesno kreiran!");
            window.location.href = "login.html";
        },
        error: function () {
            alert("Greška!");
        }
    });}else{

         var korisnickoime = $("#korisnickoime").val();
         var lozinka = $("#lozinka").val();
         var ime = $("#ime").val();
         var prezime = $("#prezime").val();
         var telefon = $("#telefon").val();
         var email = $("#email").val();
         var datumrodjenja = $("#datumrodjenja").val();
         var uloga = "TRENER";




         var novitrener = {
             korisnickoime,
             lozinka,
             ime,
             prezime,
             telefon,
             email,
             datumrodjenja,
             uloga,
             prosecnaocena
         }
         console.log(novitrener);


         $.ajax({
             type: "POST",
             url: "http://localhost:8011/api/korisnici/trener",
             dataType: "json",
             contentType: "application/json",
             data: JSON.stringify(novitrener),
             success: function (res) {


                 console.log(res);
                 alert("Trener " + res.id + " je uspesno kreiran!");
                 window.location.href = "aktivacijatrenera.html";
             },
             error: function () {
                 alert("Greška!");
             }

         });}
});