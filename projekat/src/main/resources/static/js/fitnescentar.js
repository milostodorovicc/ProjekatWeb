$(document).on("submit","#novifitnescentar",function (event) {
    event.preventDefault();
    var naziv = $("#naziv").val();
    var adresa = $("#adresa").val();
    var brojtelefonacentrale = $("#brojtelefona").val();
    var email = $("#email").val();

var fitnescentar ={
    naziv,
    adresa,
    brojtelefonacentrale,
    email


}
console.log(fitnescentar);

    $.ajax({
        type: "PUT",
        url: "http://localhost:8011/api/fitnescentar",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(fitnescentar),
        success: function (res) {
            console.log(res);
            alert("Fitnescentar " + res.id + " je uspesno kreiran!");
            window.location.href = "administrator.html";
        },
        error: function () {
            alert("Greška!");
        }


    });


})