
$(document).on("submit", "#form1", function (event) {
    event.preventDefault();

     if(document.getElementById("uloga2").checked){

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
          var fitnesscentar = $("input[name=fitnescentar]:checked").val();



         var novitrener = {
             korisnickoime,
             lozinka,
             ime,
             prezime,
             telefon,
             email,
             datumrodjenja,
             uloga,
              fitnesscentar

         }
         console.log(novitrener);

          let url = new URL('http://localhost:8011/api/korisnici/trener' );
          url.searchParams.append('fitnesscentar', fitnesscentar);
         $.ajax({
             type: "POST",
             url: url,
             dataType: "json",
             contentType: "application/json",
             data: JSON.stringify(novitrener),
             success: function (res) {

                 console.log(res);
                 alert("Trener " + res.id + " je uspesno kreiran!");
                 window.location.href = "login.html";
             },
             error: function () {
                 alert("Greška!");
             }

         });}
});




$(document).on('click', '#uloga1', function () {
    $('#fitnescentar').empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8011/api/fitnescentar",
        dataType: "json",
        success: function (res) {
            console.log("SUCCESS:\n", res);
            let fieldset = "Fitnes centar u kojem radite:<br/>"
            for (i = 0; i < res.length; i++) {


                 fieldset +=  "<label for=\"fitnescentar "+ i +" \">" + res[i].naziv + "</label>\n" +
                    "    <input id=\"fitnescentar "+ i +"\" type=\"radio\" name=\"fitnescentar\"  value="+ res[i].naziv +"  />\n"


            }
            $('#fitnescentar').append(fieldset);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});




$(document).on('click', '#uloga2', function () {
    $('#fitnescentar').empty();
})

