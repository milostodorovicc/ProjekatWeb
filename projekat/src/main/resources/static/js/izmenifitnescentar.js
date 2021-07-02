$(document).ready(function (){


    var fitnescentar = localStorage.getItem('fitnescentar');
    var uloga = localStorage.getItem('uloga');
    var novi = {
        fitnescentar,
        uloga
    }
    console.log(novi);
    alert("eeee");

    let url = new URL('http://localhost:8011/api/fitnescentar/jedan');

    url.searchParams.append('fitnescentar', fitnescentar);
    url.searchParams.append('uloga', uloga);



    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",

        success: function (res) {

       alert("Usao u success");


            $("input#naziv").val(res.naziv);
            $("input#adresa").val(res.adresa);
            $("input#brojtelefonacentrale").val(res.brojtelefonacentrale);
            $("input#email").val(res.email);




        },
        error: function () {
            alert("Greska!");
        }

    });









});