
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




$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8011/api/korisnici",
        dataType: "json",
        success: function (res) {
            console.log("SUCCESS:\n", res);
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].ime + "</td>";
                row += "<td>" + res[i].prezime + "</td>";
                row += "<td>" + res[i].korisnickoime + "</td>";
                // row += "<td>" + res[i].uloga + "</td>";
                let checkbox = "<input type=\"checkbox\" id=\"aktiviraj\" name=\"aktiviraj\" value=\"aktiviraj\" >\n" +
                    "<label for=\"aktiviraj\"> Aktivan</label><br>\n"

                row += "<td>" +  checkbox + "</td>"
                row += "</tr>";
                $('#aktivacijatrenera1').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});