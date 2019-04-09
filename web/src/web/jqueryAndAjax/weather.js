$(document).ready(function () {
    $.getJSON('current.city.list.json', function (data) {
        $('select').on('change', function () {
            let out = '';
            for (let key in data) {
                if (data[key].country == $('select option:selected').value()) {
                    out += '<p value="${data[key].id}">${data[key].name}</p>';
                }
            }
            $('#city').html(out);
            $('#city p').on('click', function () {
                $(document).ready(function () {
                    $.get(
                        "http://api.openweathermap.org/data/2.5/weather",
                        {
                            "id": $(this).attr('value'),
                            "appid": "70e1ed322b02acbc57d443dd91065f3e"
                        },
                        function (data) {
                            let out = '';
                            out += 'Погода: <b>' + data.weather[0].main + '</b><br>';
                            out += '<p><img src="https://openweathermap.org/img/w/' + data.weather[0].icon + '.png"></p>';
                            out += 'Температура: <b>' + Math.round(data.main.temp - 273) + '</b><br>';
                            out += 'Влажность: <b>' + data.main.humidity + '%</b><br>';
                            console.log(data.main);
                            $('#weather').html(out);
                        }
                    )
                });
            });
        });
    })
});
