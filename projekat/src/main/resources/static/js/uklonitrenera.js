$(document).ready(function () {
    if (localStorage.getItem('uloga') === "ADMINISTRATOR") {


        let url = new URL('http://localhost:8011/api/korisnici/svitreneri');


        url.searchParams.append('uloga', localStorage.getItem('uloga'));



        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (res) {



                console.log(res);
                for (let i = 0; i < res.length; i++) {


                    let row = "<tr>";
                    row += "<td>" + res[i].ime + "</td>";
                    row += "<td>" + res[i].prezime + "</td>";

                    row += "<td>" + res[i].prosecnaocena + "</td>";
                    row += "<td>" + "    <input type=\"radio\" name=\"uklonitrenera1\"  value=" + res[i].id + "  />" + "</td>";


                    row += "</tr>";
                    $('#uklonitrenera').append(row);
                }
            },
            error: function () {
                alert("Greška!");
            }
        });







    } else {
        if (localStorage.getItem("uloga") === "TRENER") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "trener.html";
        } else if (localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        } else {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "login.html";
        }

    }
});





$(document).on("click", '#uklonitrenera1', function(){
    if (localStorage.getItem('uloga') === "ADMINISTRATOR") {


        let url = new URL('http://localhost:8011/api/korisnici/uklonitrenera');
        let trener = $("input[name=uklonitrenera1]:checked").val();

        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('trener', trener);



        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (res) {
                alert("Uspesno ste uklonili odabranog trenera!");
                window.location.reload(true);
            },
            error: function () {
                alert("Niste uspeli da uklonite odabranog trenera!");
            }
        });







    } else {
        if (localStorage.getItem("uloga") === "ADMINISTRATOR") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "administrator.html";
        } else if (localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        } else {
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "login.html";
        }

    }
});

