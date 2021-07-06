$(document).ready(function () {
    if(localStorage.getItem('uloga') === "ADMINISTRATOR"){


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
                $('#fitnescentar1').append(fieldset);
            },
            error: function (res) {
                console.log("ERROR:\n", res);
            }
        });}


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