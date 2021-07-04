$(document).ready(function (){
    if(localStorage.getItem('uloga') === "ADMINISTRATOR"){
    var uloga = localStorage.getItem("uloga");
      // $("#fitnescentar").hide();
    let url = new URL('http://localhost:8011/api/fitnescentar/svi');

    url.searchParams.append('uloga', uloga);

    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",

        success: function (res) {

            for ( let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].adresa + "</td>";
                row += "<td>" + res[i].brojtelefonacentrale + "</td>"
                row += "<td>" + res[i].email + "</td>";

                if(localStorage.getItem("uloga") === "ADMINISTRATOR") {
                    row += "<td>" + "    <input id=" + i + " type=\"radio\" name=\"fitnescentar\"  value=" + res[i].id + "  />" + "</td>";
                }
                row += "</tr>";
                $('#svifitnescentri').append(row);
            }
        },
        error: function () {
            alert("Vec je popunjena sala za odabrani termin!");
        }

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


});








$(document).on("click", '#izmenifitnescentar', function(){
     if(localStorage.getItem('uloga') === "ADMINISTRATOR") {
         var fitnescentar1 = $("input[name=fitnescentar]:checked").val();
         if (typeof fitnescentar1 === 'undefined') {
             alert("Niste izabrali fitnes centar");

         }


         window.location.href = "izmenifitnescentar.html?id=" + fitnescentar1;
     }

     else{
         if(localStorage.getItem("uloga") === "TRENER"){
             alert("Nemate pristup ovoj stranici!");
             window.location.href = "trener.html";
         }
         else if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
             alert("Nemate pristup ovoj stranici!");
             window.location.href = "clanfitnescentra.html";
         }
         else{
             alert("Nemate pristup ovoj stranici!");
             window.location.href ="login.html";
         }

     }
});


$(document).on("click", '#izbrisifitnescentar', function(){

    if(localStorage.getItem('uloga') === "ADMINISTRATOR") {
        var uloga = localStorage.getItem('uloga');
        var fitnescentar = $("input[name = fitnescentar]:checked").val();
        // localStorage.setItem('fitnescentar', fitnescentar);

        if(typeof fitnescentar == 'undefined'){
            alert("Niste izabrali fitnes centar!");
            window.location.reload(true);
        }

        let url = new URL('http://localhost:8011/api/fitnescentar/izbrisi');


        url.searchParams.append('fitnescentar', fitnescentar);
        url.searchParams.append('uloga', uloga);


        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",

            success: function (res) {

                alert("Odabrani fitnes centar je izbrisan!");
                window.location.reload(true);


            },
            error: function () {
                alert("Greska!");
            }

        });
    }

    else{
        if(localStorage.getItem("uloga") === "TRENER"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "trener.html";
        }
        else if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        }
        else{
            alert("Nemate pristup ovoj stranici!");
            window.location.href ="login.html";
        }

    }



});






$(document).on("click", '#dodajnovusalu', function(){

     if(localStorage.getItem('uloga')==="ADMINISTRATOR"){
    var fitnescentar1 = $("input[name = fitnescentar]:checked").val();
    if( typeof fitnescentar1 === 'undefined'){
        alert("Niste odabrali fitnes centar!");
        throw new Error("Niste odabrali fitnescentar!");
    }
         window.location.href = "novasala.html?id="+fitnescentar1;
   }
     else{
         if(localStorage.getItem("uloga") === "TRENER"){
             alert("Nemate pristup ovoj stranici!");
             window.location.href = "trener.html";
         }
         else if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
             alert("Nemate pristup ovoj stranici!");
             window.location.href = "clanfitnescentra.html";
         }
         else{
             alert("Nemate pristup ovoj stranici!");
             window.location.href ="login.html";
         }

     }




});


$(document).on("click", '#svesale', function(){

if(localStorage.getItem('uloga')==="ADMINISTRATOR") {
    let fitnescentar = $("input[name = fitnescentar]:checked").val();
    window.location.href = "svesale.html?id="+fitnescentar;

}
else{
        if(localStorage.getItem("uloga") === "TRENER"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "trener.html";
        }
        else if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        }
        else{
            alert("Nemate pristup ovoj stranici!");
            window.location.href ="login.html";
        }

    }


});




