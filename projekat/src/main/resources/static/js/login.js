$(document).on("submit", "form", function (event) {

        event.preventDefault();

        var korisnickoime = $("#korisnickoime").val();
        var lozinka = $("#lozinka").val();


        var login = {
                korisnickoime,
                lozinka,

        }
        console.log(login);


        $.ajax({
            type: "POST",
            url: "http://localhost:8011/api/korisnici/login",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(login),
            success: function (res) {
                console.log(res);
                // var id1 = res.id;
                if(res.uloga === "TRENER"){

                    if(res.aktivan){
                        localStorage.setItem("id", res.id);
                        localStorage.setItem("uloga", "TRENER");
                        window.location.href = "trener.html"
                    }else{
                        alert("Administrator vas jos nije aktivirao!")
                    }
                }else if(res.uloga === "ADMINISTRATOR"){
                    localStorage.setItem("id", res.id);
                    localStorage.setItem("uloga", "ADMINISTRATOR");
                    window.location.href = "administrator.html"
                }else{
                    localStorage.setItem("id", res.id);
                    localStorage.setItem("uloga", "CLANFITNESCENTRA");
                    window.location.href = "clanfitnescentra.html"
                }

            },
            error: function () {
                alert("Niste uneli dobro korisnicko ime ili lozinku!");
            }

        });



});