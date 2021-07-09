

    $(document).ready(function () {
        if (localStorage.getItem('uloga') === "CLANFITNESCENTRA") {

            var uloga = localStorage.getItem("uloga");

            var korisnik = localStorage.getItem("id");


            let url = new URL('http://localhost:8011/api/korisnici/odradjeni');

            url.searchParams.append('uloga', uloga);

            url.searchParams.append('korisnik', korisnik);


            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                success: function (res) {



                    console.log(res);
                    for (let i = 0; i < res.length; i++) {


                        let row = "<tr>";
                        row += "<td>" + res[i].datum + "</td>";
                        row += "<td>" + res[i].cena + "</td>";
                        row += "<td>" + res[i].brojprijavljenihclanova + "</td>"
                        row += "<td>" + res[i].nazivfitnescentra + "</td>";
                        row += "<td id = " + i + ">" + res[i].oznaka + "</td>";
                        row += "<td>" + res[i].ime + "</td>";
                        row += "<td>" + res[i].prezime + "</td>";
                        row += "<td>" + res[i].nazivtreninga + "</td>";
                        row += "<td>" + res[i].opis + "</td>";
                        row += "<td>" + res[i].tip + "</td>";
                        row += "<td>" + res[i].trajanje + "</td>";

                        row += "</tr>";
                        $('#odradjeni').append(row);
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
            } else if (localStorage.getItem("uloga") === "ADMINISTRATOR") {
                alert("Nemate pristup ovoj stranici!");
                window.location.href = "administrator.html";
            } else {
                alert("Nemate pristup ovoj stranici!");
                window.location.href = "login.html";
            }

        }
    });