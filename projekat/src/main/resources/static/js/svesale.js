$(document).ready(function (){
    if(localStorage.getItem('uloga') === "ADMINISTRATOR"){
    let urlParams = new URLSearchParams(window.location.search);
    let fitnescentar = urlParams.get('id');

    let uloga = localStorage.getItem('uloga');



    let url = new URL('http://localhost:8011/api/fitnescentar/svesale');
    if( fitnescentar === 'undefined' || fitnescentar === null){
        alert("Niste odabrali fitnes centar");
        window.location.href = "svifitnescentri.html";
    }
    else{

    url.searchParams.append('fitnescentar', fitnescentar);
    url.searchParams.append('uloga', uloga);

    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",

        success: function (res) {

            for ( let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].kapacitet + "</td>";
                row += "<td>" + res[i].oznaka + "</td>";


                if(localStorage.getItem("uloga") === "ADMINISTRATOR") {
                    row += "<td>" + "    <input id=" + i + " type=\"radio\" name=\"sala\"  value=" + res[i].id + "  />" + "</td>";
                }
                row += "</tr>";
                $('#svesale1').append(row);
            }
        },
        error: function () {


            alert("Greska!");
        }

    });}}

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



$(document).on("click", '#izmenisalu', function(){
   if(localStorage.getItem('uloga') === "ADMINISTRATOR") {
       var sala = $("input[name=sala]:checked").val();
        if(typeof sala === 'undefined' || sala === null){
            alert("Niste odabrali salu!!");
            window.location.reload(true);

        }
        else{
       window.location.href = "izmenisalu.html?id=" + sala;
   }}

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

$(document).on("click", "#izbrisisalu", function () {

    if(localStorage.getItem('uloga') === "ADMINISTRATOR") {
        let sala1 = $("input[name=sala]:checked").val();


        console.log(sala1);


       if(typeof sala1 === 'undefined' || sala1 === null){
           alert("Niste odabrali salu");
           window.location.reload(true);

       }



else{
        var uloga = localStorage.getItem('uloga');

        let url = new URL('http://localhost:8011/api/fitnescentar/izbrisisalu');

        url.searchParams.append('sala1', sala1);
        url.searchParams.append('uloga', uloga);


        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",

            success: function (res) {
                alert("Odabrana sala je uspesno obrisana!");

                window.location.reload(true);


            },
            error: function () {
                alert("Nije uspelo brisanje sale!");
            }
        });

    }}


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

