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
                if(res.uloga === "TRENER"){
                    if(res.aktivan){
                        window.location.href = "trener.html"
                    }else{
                        alert("Administrator vas jos nije aktivirao!")
                    }
                }else if(res.uloga === "ADMINISTRATOR"){
                    window.location.href = "administrator.html"
                }else{
                    window.location.href = "clanfitnescentra.html"
                }

            },
            error: function () {
                alert("Greška!");
            }

        });



});