
    if(localStorage.getItem("uloga") === "ADMINISTRATOR") {
        $(document).on("submit", "#novifitnescentar", function (event) {
            event.preventDefault();
            let url = new URL('http://localhost:8011/api/fitnescentar');
            url.searchParams.append('uloga', localStorage.getItem("uloga"));
            var naziv = $("#naziv").val();
            var adresa = $("#adresa").val();
            var brojtelefonacentrale = $("#brojtelefona").val();
            var email = $("#email").val();

            var fitnescentar = {
                naziv,
                adresa,
                brojtelefonacentrale,
                email


            }
            console.log(fitnescentar);

            $.ajax({
                type: "PUT",
                url: url,
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
                    if (localStorage.getItem("uloga") === "TRENER") {
                        window.location.href = "trener.html";
                    } else if(localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
                        window.location.href = "clanfitnescentra.html";
                    }else{
                        window.location.href = "login.html";
                    }
                }


            });


        });
  




$(document).on("click","#dodajfitnescentar",function (){

    window.location.href = "fitnescentar.html";
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


    $(document).on("click","#svifitnescentri",function (){

        if(localStorage.getItem("uloga") === "ADMINISTRATOR") {

            window.location.href = "svifitnescentri.html"

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
