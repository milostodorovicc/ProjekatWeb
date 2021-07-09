

    $(document).ready(function () {
        if(localStorage.getItem('uloga') === "CLANFITNESCENTRA"){
    var uloga = localStorage.getItem("uloga");

    var korisnik = localStorage.getItem("id");

    let url = new URL('http://localhost:8011/api/korisnici/neocenjeni');

    url.searchParams.append('uloga', uloga);
    url.searchParams.append('korisnik', korisnik);


    $.ajax({
        type: "GET",
        url: url ,
        dataType: "json",
        success: function (res) {




            console.log(res);
            for ( let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].datum + "</td>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<td>" + res[i].brojprijavljenihclanova + "</td>"
                row += "<td>" + res[i].nazivfitnescentra + "</td>";
                row += "<td id = "+ i +">" + res[i].oznaka + "</td>";
                row += "<td>" + res[i].ime + "</td>";
                row += "<td>" + res[i].prezime + "</td>";
                row += "<td>" + res[i].nazivtreninga + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";
                row += "<td>" + "    <input id=  "+res[i].id+"   type=\"number\" name="+res[i].id+" max = '10' min = '1'  />" + "</td>";
                row += "<td>" + "    <input type=\"radio\" name=\"ocena\"  value=" + res[i].id + "  />" + "</td>";
                 // let a = "res[i].id";
                 // document.getElementById("a").required = true;

                row += "</tr>";
                $('#neocenjenitreninzi').append(row);
            }
        },
        error: function () {
            alert("Greška!");
        }
    });}


else{
    if(localStorage.getItem("uloga") === "TRENER"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "trener.html";
    }
    else if(localStorage.getItem("uloga") === "ADMINISTRATOR"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "administrator.html";
    }
    else{
        alert("Nemate pristup ovoj stranici!");
        window.location.href ="login.html";
    }

}
    });



$(document).on("click", "#ocena", function(event){
    if(localStorage.getItem('uloga') === "CLANFITNESCENTRA"){

     var uloga = localStorage.getItem('uloga');
    var termin = $("input[name=ocena]:checked").val();

    var korisnik = localStorage.getItem("id");

    var ocena = $(`input#${termin}`).val();
    console.log(ocena);



    if(typeof termin === 'undefined' ||  !ocena){
        alert("Niste izabrali termin ili niste ocenili termin !");
    }





else{
    let url = new URL('http://localhost:8011/api/treninzi/oceni');

    url.searchParams.append('uloga', uloga);
    url.searchParams.append('korisnik', korisnik);
    url.searchParams.append('termin', termin);
    url.searchParams.append('ocena', ocena);









    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",

        success: function (res) {
            console.log(res);
            alert("Uspesno ste ocenili izabrani termin!");
            window.location.reload(true);


        },
        error: function () {
            alert("Niste uspeli da ocenite termin!");
            window.location.reload(true);
        }
    });}}




else{
    if(localStorage.getItem("uloga") === "TRENER"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "trener.html";
    }
    else if(localStorage.getItem("uloga") === "ADMINISTRATOR"){
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "administrator.html";
    }
    else{
        alert("Nemate pristup ovoj stranici!");
        window.location.href ="login.html";
    }

}
});
