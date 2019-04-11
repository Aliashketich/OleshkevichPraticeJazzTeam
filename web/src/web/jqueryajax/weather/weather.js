document.getElementById("btnLida").addEventListener('click', function () {
    getData(document.getElementById("btnLida"));
});
document.getElementById("btnSoligorsk").addEventListener('click', function () {
    getData(document.getElementById("btnSoligorsk"));
});
document.getElementById("btnMinsk").addEventListener('click', function () {
    getData(document.getElementById("btnMinsk"));
});
document.getElementById("btnBrest").addEventListener('click', function () {
    getData(document.getElementById("btnBrest"));
});
document.getElementById("btnKiev").addEventListener('click', function () {
    getData(document.getElementById("btnKiev"));
});
document.getElementById("btnMoscow").addEventListener('click', function () {
    getData(document.getElementById("btnMoscow"));
});
document.getElementById("btnBerlin").addEventListener('click', function () {
    getData(document.getElementById("btnBerlin"));
});
document.getElementById("btnStolin").addEventListener('click', function () {
    getData(document.getElementById("btnStolin"));
});

function getData(btn) {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        data: {
            "q": btn.getAttribute("value"),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        success: function (data) {
            parseAnswer(data);
        }
    });
}

function parseAnswer(data) {
    let out = '';
    out += 'Погода: <b>' + data.weather[0].main + '</b><br>';
    out += '<p><img src="https://openweathermap.org/img/w/' + data.weather[0].icon + '.png"></p>';
    out += 'Температура: <b>' + Math.round(data.main.temp - 273) + '</b><br>';
    out += 'Влажность: <b>' + data.main.humidity + '%</b><br>';
    console.log(out);
    $('#weather').html(out);
    return out;
}
