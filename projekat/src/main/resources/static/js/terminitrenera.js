$(document).ready(function () {
    if (localStorage.getItem('uloga') === "TRENER") {


        let url = new URL('http://localhost:8011/api/treninzi/nadjitermine');



        url.searchParams.append('uloga', localStorage.getItem('uloga'));
        url.searchParams.append('korisnik', localStorage.getItem('id'));



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
                    row += "<td>" + res[i].oznaka + "</td>";
                    row += "<td>" + res[i].ime + "</td>";
                    row += "<td>" + res[i].prezime + "</td>";
                    row += "<td>" + res[i].nazivtreninga + "</td>";
                    row += "<td>" + res[i].opis + "</td>";
                    row += "<td>" + res[i].tip + "</td>";
                    row += "<td>" + res[i].trajanje + "</td>";

                        row += "<td>" + "    <input id=" + i + " type=\"radio\" name=\"izmenitermin\"  value=" + res[i].id + "  />" + "</td>";


                    row += "</tr>";
                    $('#terminitrenera').append(row);

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


$(document).on("click", '#izmenitermin', function(){
    if(localStorage.getItem("uloga") === "TRENER"){
         let termin = $("input[name=izmenitermin]:checked").val();

         if(typeof termin === 'undefined' || termin === null){
             alert("Niste odabrali termin");
             window.location.reload(true);
         }
      else{
        window.location.href ="izmenitermin.html?id="+termin;
    }}
    else{
        if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
        }
        else if(localStorage.getItem("uloga") === "ADMINISTRATOR"){
            alert("Nemate pristup ovoj stranici11!");
            window.location.href = "administrator.html";
        }
        else{
            alert("Nemate pristup ovoj stranici!");
            window.location.href ="login.html";
        }

    }

});










