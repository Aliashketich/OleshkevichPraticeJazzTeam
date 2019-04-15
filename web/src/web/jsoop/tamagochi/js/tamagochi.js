class Animal {
    constructor(name, dateOfBirth, healthLevel, fillLevel, animalType) {
        this._name = name;
        this._dateOfBirth = dateOfBirth;
        this._healthLevel = healthLevel;
        this._fillLevel = fillLevel;
        this._animalType = animalType;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get dateOfBirth() {
        return this._dateOfBirth;
    }

    set dateOfBirth(value) {
        this._dateOfBirth = value;
    }

    get healthLevel() {
        return this._healthLevel;
    }

    set healthLevel(value) {
        this._healthLevel = value;
    }

    get fillLevel() {
        return this._fillLevel;
    }

    set fillLevel(value) {
        this._fillLevel = value;
    }

    get animalType() {
        return this._animalType;
    }

    set animalType(value) {
        this._animalType = value;
    }
}

class Raccoon extends Animal {
    constructor(name, dateOfBirth, healthLevel, fillLevel, washHappiness) {
        super(name, dateOfBirth, healthLevel, fillLevel, 'raccoon');
        this._washHappiness = washHappiness;
        console.log('Tamagochi name: raccoon ' + name);
    }

    get washHappiness() {
        return this._washHappiness;
    }

    set washHappiness(value) {
        this._washHappiness = value;
    }
}

class Cat extends Animal {
    constructor(name, dateOfBirth, healthLevel, fillLevel, milkLevel) {
        super(name, dateOfBirth, healthLevel, fillLevel, 'cat');
        this._milkLevel = milkLevel;
        console.log('Tamagochi name: cat ' + name);
    }


    get milkLevel() {
        return this._milkLevel;
    }

    set milkLevel(value) {
        this._milkLevel = value;
    }
}

class Koala extends Animal {
    constructor(name, dateOfBirth, healthLevel, fillLevel, sleepLevel) {
        super(name, dateOfBirth, healthLevel, fillLevel, 'koala');
        this._sleepLevel = sleepLevel;
        console.log('Tamagochi name: koala ' + name);
    }

    get sleepLevel() {
        return this._sleepLevel;
    }

    set sleepLevel(value) {
        this._sleepLevel = value;
    }
}

let btnCreation = document.getElementById('createBtn');
let animal = btnCreation.addEventListener('click', function () {
    let numberOfSelectedTypeOption = document.getElementById('animalType').options.selectedIndex;
    let animalType = document.getElementById('animalType').options[numberOfSelectedTypeOption].value;
    let animalName = document.getElementById('animalName').value;

    let currentDate = new Date();
    let currentTime;
    if (currentDate.getMinutes() < 10) {
        currentTime = currentDate.getHours() + ':0' + currentDate.getMinutes();
    } else
        currentTime = currentDate.getHours() + ':' + currentDate.getMinutes();

    let classBar = '';
    let classAction = '';
    switch (animalType) {
        case 'koala':
            animal = new Koala(animalName, currentTime, 100, 100, 50);
            classBar = 'Sleep';
            classAction = 'let me sleep';
            break;

        case 'cat':
            animal = new Cat(animalName, currentTime, 100, 100, 30);
            classBar = 'Milk';
            classAction = 'gimme Milk';
            break;

        case 'raccoon':
            animal = new Raccoon(animalName, currentTime, 100, 100, 60);
            classBar = 'Wash';
            classAction = 'let me Wash';
            break;
        default:
            alert('Chose animal type please!');
            location.reload();
    }

    document.getElementById('animalCreation').innerHTML =
        '<div>' +
        '<p>Name: ' + animal["name"] + '</p>' +
        '<p>Type: ' + animal["animalType"] + '</p>' +
        '<p>Time of birth: ' + currentTime + '</p>' +
        '</div>';


    document.getElementById('tamagochiBars').innerHTML = '<div class="col-xs-9"><div class="progress progress-striped">' +
        '<div id="health-level" class="progress-bar progress-bar-success">Health Level</div>' +
        '</div></div>' +
        '<div class="col-xs-3"><button id="heal" class="btn btn-success">Heal me!' +
        '</button></div>' +
        '<div class="col-xs-9"><div class="progress progress-striped">' +
        '<div id="food-level" class="progress-bar progress-bar-success">Food Level</div>' +
        '</div></div>' +
        '<div class="col-xs-3"><button id="feed" class="btn btn-success">Feed' +
        '</button></div>' +
        '<div class="col-xs-9"><div class="progress progress-striped">' +
        '<div id="happiness-level" class="progress-bar progress-bar-success">' + classBar + '  Level</div>' +
        '</div></div>' +
        '<div class="col-xs-3"><button id="happiness" class="btn btn-success">' + classAction +
        '</button></div>';


    document.getElementById('timer').innerHTML = '<label id="minutes">00</label>:<label id="seconds">00</label>';
    var minutesLabel = document.getElementById("minutes");
    var secondsLabel = document.getElementById("seconds");
    var totalSeconds = 0;
    setInterval(setTime, 1000);

    function setTime() {
        ++totalSeconds;
        secondsLabel.innerHTML = pad(totalSeconds % 60);
        minutesLabel.innerHTML = pad(parseInt(totalSeconds / 60));
    }

    function pad(val) {
        var valString = val + "";
        if (valString.length < 2) {
            return "0" + valString;
        } else {
            return valString;
        }
    }

    let count = setInterval(timer, 250);


    //действия кнопок для повышения хар=к
    $('#feed').click(function () {
        animal.fillLevel += 5;
        animal.healthLevel += 2;

    });
    $('#heal').click(function () {
        animal.healthLevel += 5;
    });
    $('#happiness').click(function () {
        switch (animalType) {
            case 'koala':
                animal.healthLevel += 2;
                animal.sleepLevel += 4;
                animal.fillLevel -= 2;
                break;
            case 'raccoon':
                animal.healthLevel -= 3;
                animal.washHappiness += 5;
                break;
            case 'cat':
                animal.fillLevel += 3;
                animal.milkLevel += 4;
                break;
        }
    });


    function timer() {
        //логика уменьшения хар=х с течением времени
        animal["healthLevel"] -= 0.12;
        animal["fillLevel"] -= 0.15;

        //TODO cast to Switch
        let happinessLevel = '';
        if (animalType === 'raccoon') {
            animal["washHappiness"] -= 0.05;
            happinessLevel = "washHappiness";
            // console.log(animal["washHappiness"]);
        }
        if (animalType === 'cat') {
            animal["milkLevel"] -= 0.03;
            happinessLevel = "milkLevel";
            // console.log(animal["milkLevel"]);
        }
        if (animalType === 'koala') {
            animal["sleepLevel"] -= 0.07;
            happinessLevel = "sleepLevel";
            // console.log(animal["sleepLevel"]);
        }


        //логика смены окраса линий
        if (animal.fillLevel > 65) {
            $('#food-level').removeClass();
            $('#food-level').addClass('progress-bar progress-bar-success');
        } else if (animal.fillLevel < 65 && animal.fillLevel > 30) {
            $('#food-level').removeClass();
            $('#food-level').addClass('progress-bar progress-bar-warning');
        } else if (animal.fillLevel < 30) {
            $('#food-level').removeClass();
            $('#food-level').addClass('progress-bar progress-bar-danger');
        }
        if (animal.healthLevel > 65) {
            $('#health-level').removeClass();
            $('#health-level').addClass('progress-bar progress-bar-success');
        } else if (animal.healthLevel < 65 && animal.healthLevel > 30) {
            $('#health-level').removeClass();
            $('#health-level').addClass('progress-bar progress-bar-warning');
        } else if (animal.healthLevel < 30) {
            $('#health-level').removeClass();
            $('#health-level').addClass('progress-bar progress-bar-danger');
        }
        if (animal[happinessLevel] > 65) {
            $('#happiness-level').removeClass();
            $('#happiness-level').addClass('progress-bar progress-bar-success');
        } else if (animal[happinessLevel] < 65 && animal[happinessLevel] > 30) {
            $('#happiness-level').removeClass();
            $('#happiness-level').addClass('progress-bar progress-bar-warning');
        } else if (animal[happinessLevel] < 30) {
            $('#happiness-level').removeClass();
            $('#happiness-level').addClass('progress-bar progress-bar-danger');
        }


        //Ограничения на выход уровней хар-к за 100
        if (animal.fillLevel > 100) {
            animal.fillLevel = 100;
        }

        if (animal.healthLevel > 100) {
            animal.healthLevel = 100;
        }
        switch (animalType) {
            case 'koala':
                if (animal.sleepLevel > 100) {
                    animal.sleepLevel = 100;
                }
                break;
            case 'raccoon':
                if (animal.washHappiness > 100) {
                    animal.washHappiness = 100;
                }
                break;
            case 'cat':
                if (animal.milkLevel > 100) {
                    animal.milkLevel = 100;
                }
                break;
        }


        // console.log(animal["fillLevel"]);


        //условия смерти
        if (animal["healthLevel"] < 0 || animal["fillLevel"] < 0 || animal[happinessLevel] < 0) {

            //сообщение о конце игры
            let deadInfo = '';
            if (animal["healthLevel"] < 0) {
                deadInfo = 'health problems';
            } else if (animal["fillLevel"] < 0) {
                deadInfo = 'from exhaustion'
            } else if (animal[happinessLevel] < 0) {
                deadInfo = 'low ' + happinessLevel;
            }
            alert('Tamagochi died of ' + deadInfo + ' in ' + totalSeconds + ' seconds');
            clearInterval(count);
            console.log(animal + ' is Dead');
            location.reload();
        }

        $('#food-level').css('width', animal.fillLevel + "%");
        $('#health-level').css('width', animal.healthLevel + "%");
        switch (animalType) {
            case 'koala':
                $('#happiness-level').css('width', animal.sleepLevel + "%");
                break;
            case 'cat':
                $('#happiness-level').css('width', animal.milkLevel + "%");
                break;
            case 'raccoon':
                $('#happiness-level').css('width', animal.washHappiness + "%");
                break;
        }
    }
});