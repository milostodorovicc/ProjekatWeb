 $(document).ready(function(){

     $.ajax({
         type: "GET",
         url: "http://localhost:8011/api/treninzi/svitreninzi",
         dataType: "json",
         success: function (res) {

             console.log("SUCCESS:\n", res);

             for (i = 0; i < res.length; i++) {


                  row = "<tr>";
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
                 $('#treninzi').append(row);
             }

         },
         error: function (res) {
             console.log("ERROR:\n", res);
             alert("Nije uspeo pregled treninga!");
         }
     });
 });


















