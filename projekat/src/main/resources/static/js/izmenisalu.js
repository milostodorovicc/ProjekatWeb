$(document).ready(function (){
   if(localStorage.getItem('uloga') === "ADMINISTRATOR"){

    let urlParams = new URLSearchParams(window.location.search);
    let sala = urlParams.get('id');
    // var sala = localStorage.getItem('sala');
    var uloga = localStorage.getItem('uloga');

       if( sala === 'undefined' || sala === null){
           alert("Niste odabrali salu");
           window.location.href = "svesale.html";
       }else{

    let url = new URL('http://localhost:8011/api/fitnescentar/jednasala');

    url.searchParams.append('sala', sala);
    url.searchParams.append('uloga', uloga);

    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",

        success: function (res) {

            $("input#kapacitet").val(res.kapacitet);
            $("input#oznaka").val(res.oznaka);

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



$(document).on("click", '#izmenisalu', function () {

    if(localStorage.getItem('uloga') === "ADMINISTRATOR") {
        var kapacitet = $("#kapacitet").val();
        var oznaka = $("#oznaka").val();


        let urlParams = new URLSearchParams(window.location.search);
        let sala1 = urlParams.get('id');

         if(sala1 === 'undefined' || sala1 === null){
             alert("Niste odabrali salu!");
             window.location.href = "svesale.html";
         }
else{
        var novasala = {
            kapacitet,
            oznaka
        }


        var uloga = localStorage.getItem('uloga');

        let url = new URL('http://localhost:8011/api/fitnescentar/izmenisalu');

        url.searchParams.append('sala1', sala1);
        url.searchParams.append('uloga', uloga);


        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(novasala),
            success: function (res) {
                alert("Uspesno ste izmenili odabranu salu!");
                $("input#kapacitet").val(res.kapacitet);
                $("input#oznaka").val(res.oznaka);

                window.location.reload(true);


            },
            error: function () {
                alert("Greska!");
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