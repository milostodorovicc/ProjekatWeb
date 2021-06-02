
 if(localStorage.getItem("uloga")=== "ADMINISTRATOR") {
    $(document).ready(function () {

        let url = new URL('http://localhost:8011/api/korisnici');
        url.searchParams.append('uloga', localStorage.getItem("uloga"));
        $.ajax({
            type: "GET",

            url: url,
            dataType: "json",
            success: function (res) {
                console.log("SUCCESS:\n", res);
                for (i = 0; i < res.length; i++) {
                    let row = "<tr>";
                    row += "<td>" + res[i].ime + "</td>";
                    row += "<td>" + res[i].prezime + "</td>";
                    row += "<td>" + res[i].korisnickoime + "</td>";

                    let btn = "<button class='aktiviraj' data-id=" + res[i].id + ">Aktiviraj</button>";
                    row += "<td>" + btn + "</td>"
                    row += "</tr>";
                    $('#aktivacijatrenera1').append(row);
                }
            },

            error: function (res) {
                if(localStorage.getItem("uloga") ==="TRENER"){
                    window.location.href = "trener.html";
                }else{
                    window.location.href = "clanfitnescentra.html";
                }
                console.log("ERROR:\n", res);

            }
        });
    });
 }
 else{
     if(localStorage.getItem("uloga") ==="TRENER"){
         alert("Nemate pristup ovoj stranici!");
         window.location.href = "trener.html";
     }else if(localStorage.getItem("uloga") ==="TRENER"){
         localStorage.getItem("uloga") ==="TRENER"
         window.location.href = "clanfitnescentra.html";
     }
 }

 if(localStorage.getItem("uloga")=== "ADMINISTRATOR") {
$(document).on('click', '.aktiviraj', function (){


    let trenerid = this.dataset.id;
    let url = new URL('http://localhost:8011/api/korisnici/' + trenerid);
    url.searchParams.append('uloga', localStorage.getItem("uloga"));

    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (res) {
            console.log("SUCCESS:\n", res);
            alert("Trener je postao aktivan");
            window.location.reload(true);

        },
        error: function (res) {
            if(localStorage.getItem("uloga") ==="TRENER"){
                window.location.href = "trener.html";
            }else if(localStorage.getItem("uloga")==="CLANFITNESCENTRA"){
                window.location.href = "clanfitnescentra.html";
            }else {
                console.log("ERROR:\n", res);
                alert("Nije uspela aktivacija trenera");
            }}
    });
});}
 else{
     if(localStorage.getItem("uloga") ==="TRENER"){
         alert("Nemate pristup ovoj stranici!");
         window.location.href = "trener.html";
     }else if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
         alert("Nemate pristup ovoj stranici!");
         window.location.href = "clanfitnescentra.html";
     }else{
         alert("Nemate pristup ovoj stranici!");
         window.location.href = "login.html";
     }


 }