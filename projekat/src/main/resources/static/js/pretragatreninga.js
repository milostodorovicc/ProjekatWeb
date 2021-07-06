$(document).ready(function () {

    if(localStorage.getItem("uloga")!= "CLANFITNESCENTRA"){
        document.getElementById("listatermina").style.visibility="hidden";
        document.getElementById("terminprijava1").style.visibility="hidden";
    }
});

$(document).on("click", "#pretrazikriterijum", function () {

       window.location.href = "pretragatreninga.html";
       alert("pretraga");



});

$(document).on("click", "#pretrazi", function(event){
    event.preventDefault();
    $('#nazivi tbody').empty();
    let naziv = $('#naziv').val();
    let tip = $('#tip').val();
    let opis = $('#opis').val();
    let cena = $('#cena').val();
    let vreme = $('#vreme').val();

    if(isNaN(cena)) {
        alert("Za cenu morate uneti broj.");
        $('#cena').val('');
        $('#cena').focus();
        return;
    }

    let url = new URL('http://localhost:8011/api/treninzi');

    if (naziv) {
        url.searchParams.append('naziv', naziv);
    }
    if (tip) {
        url.searchParams.append('tip', tip);
    }
    if (opis) {
        url.searchParams.append('opis', opis);
    }
    if (cena) {
        url.searchParams.append('cena', cena);
    }
    if (vreme) {
        url.searchParams.append('vreme', vreme);
    }

    $.ajax({
        type: "GET",
        url: url ,
        dataType: "json",
        success: function (res) {
            alert("Usao u success");



             console.log(res);
             for ( let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].datum + "</td>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<td>" + res[i].brojprijavljenihclanova + "</td>"
                row += "<td>" + res[i].nazivfitnescentra + "</td>";

                row += "<td>" + res[i].nazivtreninga + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";
                if(localStorage.getItem("uloga") === "CLANFITNESCENTRA") {
                    row += "<td>" + "    <input id=" + i + " type=\"radio\" name=\"brprijavljenih\"  value=" + res[i].id + "  />" + "</td>";
                }
                row += "</tr>";
                $('#nazivi').append(row);
            }
        },
        error: function () {
            alert("Greška!");
        }
    });
});


$(document).on("click", '.terminprijava', function(event){
    if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){

    var uloga = localStorage.getItem("uloga");
    var termin = $("input[name=brprijavljenih]:checked").val();
    var korisnik = localStorage.getItem("id");

    let url = new URL('http://localhost:8011/api/korisnici/prijavljeni');

        url.searchParams.append('uloga', uloga);
        url.searchParams.append('termin', termin);
        url.searchParams.append('korisnik', localStorage.getItem("id"));


     console.log(termin);


    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",

        success: function (res) {

            alert("Uspesno ste se prijavili za odabrani termin!");
        },
        error: function () {
            alert("Vec je popunjena sala za odabrani termin!");
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





$(document).on("click", "#listatermina", function(event){
    if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
    window.location.href ="termini.html";
    event.preventDefault();}
    else{
            if(localStorage.getItem("uloga") === "TRENER"){
                alert("Nemate pristup ovoj stranici!");
                window.location.href = "trener.html";
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




$(document).on("click", "#odradjenitreninzi", function(event){
    if(localStorage.getItem('uloga') === "CLANFITNESCENTRA") {
        event.preventDefault();

        window.location.href = "odradjenitreninzi.html";

    }

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




$(document).on("click", "#odradjeniocenjeni", function(){

    if(localStorage.getItem("uloga") === "CLANFITNESCENTRA") {

        window.location.href = "odradjeniocenjeni.html";
    }

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




$(document).on("click", "#odradjenineocenjeni", function() {
    if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){

    window.location.href = "odradjenineocenjeni.html";
}
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



$(document).on("click", '#odabir', function(event){
    if(localStorage.getItem("uloga") === "CLANFITNESCENTRA") {


        let termin =  $("input[name=brprijavljenih]:checked").val();
        window.location.href = "prijavazatrening.html?id="+termin;
    }
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






$(document).on("click", '#novitrening', function(){
if(localStorage.getItem("uloga") === "TRENER") {
    window.location.href = "novitrening.html";
}
else{
        if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
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

$(document).on("click", '#svitreninzi', function(){
    if(localStorage.getItem("uloga") === "TRENER") {
        window.location.href = "svitreninzi.html";
    }
    else{
        if(localStorage.getItem("uloga") === "CLANFITNESCENTRA"){
            alert("Nemate pristup ovoj stranici!");
            window.location.href = "clanfitnescentra.html";
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

$(document).on("click", "#registracijatrenera", function(event){
    if(localStorage.getItem('uloga') === "ADMINISTRATOR") {


        window.location.href = "registracijatrenera.html";

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
