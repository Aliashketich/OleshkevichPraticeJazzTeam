$(document).ready(function () {
    $.get(
        "http://api.openweathermap.org/data/2.5/weather",
        {
            // "id": $(this).attr('value'),
            "q": $('select option:selected').val(),
            "appid": "70e1ed322b02acbc57d443dd91065f3e"
        },
        function (data) {
            let out = '';
            out += 'Погода: <b>' + data.weather[0].main + '</b><br>';
            out += '<p><img src="https://openweathermap.org/img/w/' + data.weather[0].icon + '.png"></p>';
            out += 'Температура: <b>' + Math.round(data.main.temp - 273) + '</b><br>';
            out += 'Влажность: <b>' + data.main.humidity + '%</b><br>';
            console.log(data.main);
            $('#weather').html(out).update();
        }
    )
});
