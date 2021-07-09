$(document).ready(function () {

    if(localStorage.getItem("uloga")!= "CLANFITNESCENTRA"){
        document.getElementById("listatermina").style.visibility="hidden";
        document.getElementById("odabir").style.visibility="hidden";
        document.getElementById("odradjenitreninzi").style.visibility="hidden";
        document.getElementById("odradjeniocenjeni").style.visibility="hidden";
        document.getElementById("odradjenineocenjeni").style.visibility="hidden";

    }
});