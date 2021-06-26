

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
                row += "<td id = "+ i +">" + res[i].oznaka + "</td>";
                row += "<td>" + res[i].ime + "</td>";
                row += "<td>" + res[i].prezime + "</td>";
                row += "<td>" + res[i].nazivtreninga + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";
                row += "<td>" +  "    <input id="+  i +" type=\"radio\" name=\"brprijavljenih\"  value="+ res[i].id +"  />" + "</td>";
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


    var termin = $("input[name=brprijavljenih]:checked").val();
    var korisnik = localStorage.getItem("id");

    let url = new URL('http://localhost:8011/api/korisnici/prijavljeni');


        url.searchParams.append('termin', termin);
        url.searchParams.append('korisnik', localStorage.getItem("id"));


     console.log(termin);


    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",

        success: function (res) {

            alert("eeee");
        },
        error: function () {
            alert("Greška!");
        }

    });


});