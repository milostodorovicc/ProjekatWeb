$(document).on("click", '#novitrening1', function(){


    let naziv = $('#naziv').val();
    let tip = $('#tip').val();
    let opis = $('#opis').val();
    let trajanje = $('#trajanje').val();

    var novitrening = {
        naziv,
        opis,
        tip,
        trajanje
    }


    if(isNaN(trajanje)) {
        alert("Za cenu morate uneti broj.");
        $('#trajanje').val('');
        $('#trajanje').focus();
        return;
    }

    let url = new URL('http://localhost:8011/api/treninzi/novitrening');


        url.searchParams.append('uloga', localStorage.getItem('uloga'));

    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novitrening),
        success: function (res) {
            alert("Uspesno ste napravili novi trening!");

        },
        error: function () {
            alert("Greška!");
        }
    });
});