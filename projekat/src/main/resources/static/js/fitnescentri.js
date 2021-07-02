$(document).ready(function (){
    var uloga = localStorage.getItem("uloga");

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

    });


});








$(document).on("click", '#izmenifitnescentar', function(){
    var termin = $("input[name=fitnescentar]:checked").val();
    localStorage.setItem('fitnescentar', termin);
    window.location.href = "izmenifitnescentar.html";





});