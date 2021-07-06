$(document).ready(function () {
    if (localStorage.getItem('uloga') === "TRENER") {


        let url = new URL('http://localhost:8011/api/treninzi/svitreninzi1');


        url.searchParams.append('uloga', localStorage.getItem('uloga'));



        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (res) {
                alert("Usao u success");


                console.log(res);
                for (let i = 0; i < res.length; i++) {


                    let row = "<tr>";
                    row += "<td>" + res[i].naziv + "</td>";
                    row += "<td>" + res[i].opis + "</td>";
                    row += "<td>" + res[i].tip + "</td>"
                    row += "<td>" + res[i].trajanje + "</td>";
                    row += "<td>" + "    <input type=\"radio\" name=\"trening\"  value=" + res[i].id + "  />" + "</td>";


                    row += "</tr>";
                    $('#svitreninzi').append(row);
                }
            },
            error: function () {
                alert("Greška!");
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



$(document).on("click", '#napravinovitermin', function(){
    if(localStorage.getItem('uloga') === "TRENER") {
        var trening = $("input[name=trening]:checked").val();

        window.location.href = "novitermin.html?id=" + trening;
    }


    else {
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

$(document).on("click", '#izmenitrening', function(){
    if(localStorage.getItem('uloga') === "TRENER") {
        var trening = $("input[name=trening]:checked").val();

        window.location.href = "izmenitrening.html?id=" + trening;
    }


    else {
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