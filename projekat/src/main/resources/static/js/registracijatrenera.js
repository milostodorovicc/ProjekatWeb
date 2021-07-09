



$(document).on("submit", "#form12", function (event) {
    if(localStorage.getItem('uloga') === "ADMINISTRATOR"){
        event.preventDefault();



        var korisnickoime = $("#korisnickoime").val();
        var lozinka = $("#lozinka").val();
        var ime = $("#ime").val();
        var prezime = $("#prezime").val();
        var telefon = $("#telefon").val();
        var email = $("#email").val();
        var datumrodjenja = $("#datumrodjenja").val();
        var uloga = "TRENER";
        var fitnesscentar = $("input[name=fitnescentar]:checked").val();
        var uloga1 = localStorage.getItem('uloga');



        var novitrener = {
            korisnickoime,
            lozinka,
            ime,
            prezime,
            telefon,
            email,
            datumrodjenja,
            uloga,
            fitnesscentar

        }

        if(isNaN(telefon)){
            alert("Niste ispunili(pravilno) telefon!");
            return;
        }

else{


        let url = new URL('http://localhost:8011/api/korisnici/aktivantrener' );
        url.searchParams.append('fitnesscentar', fitnesscentar);
        url.searchParams.append('uloga1', uloga1);

        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(novitrener),
            success: function (res) {

                console.log(res);
                alert("Trener " + res.id + " je uspesno kreiran(aktiviran je)!");
                window.location.href = "administrator.html";
            },
            error: function () {
                alert("Greška!");
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











