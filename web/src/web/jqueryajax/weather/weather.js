let btnMinsk = document.getElementById("btnMinsk");
btnMinsk.addEventListener('click', function () {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        data: {
            "q": btnMinsk.getAttribute("value"),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        success: function (data) {
            parseAnswer(data);
        }
    });
});

let btnBrest = document.getElementById("btnBrest");
btnBrest.addEventListener('click', function () {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        data: {
            "q": btnBrest.getAttribute("value"),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        success: function (data) {
            parseAnswer(data);
        }
    });
});

let btnSoligorsk = document.getElementById("btnSoligorsk");
btnSoligorsk.addEventListener('click', function () {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        data: {
            "q": btnSoligorsk.getAttribute("value"),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        success: function (data) {
            parseAnswer(data);
        }
    });
});

let btnMoscow = document.getElementById("btnMoscow");
btnMoscow.addEventListener('click', function () {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        data: {
            "q": btnMoscow.getAttribute("value"),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        success: function (data) {
            parseAnswer(data);
        }
    });
});
let btnBerlin = document.getElementById("btnBerlin");
btnBerlin.addEventListener('click', function () {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        data: {
            "q": btnBerlin.getAttribute("value"),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        success: function (data) {
            parseAnswer(data);
        }
    });
});
let btnLida = document.getElementById("btnLida");
btnLida.addEventListener('click', function () {
    $.ajax({
        url: "http://api.openweathermap.org/data/2.5/weather",
        data: {
            "q": btnLida.getAttribute("value"),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        success: function (data) {
            parseAnswer(data);
        }
    });
});

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
