$(document).on("click", "#sortiranjetermina",function(){
    window.location.href = "sortiranje.html";
    alert("eeeee");

});

$(document).on('click', '.sortiraj', function (event){

        event.preventDefault();

    $('#sortiranje tbody').empty();



let sortid = this.dataset.id;
    $.ajax({
        type: "GET",
        url: "http://localhost:8011/api/treninzi/" + sortid ,
        dataType: "json",
        success: function (res) {
            alert("Usao u success");



            console.log(res);
            for ( let i = 0; i < res.length; i++) {



                var row = "<tr>";
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
                row += "</tr>";
                $('#sortiranje').append(row);


            }
        },
        error: function () {
            alert("Greška!");
        }
    });








});