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
        super(name, dateOfBirth, healthLevel, fillLevel);
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
        super(name, dateOfBirth, healthLevel, fillLevel);
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
    let currentTime = currentDate.toLocaleDateString() + '  ' + currentDate.getHours() + ':' + currentDate.getMinutes();
    switch (animalType) {
        case 'koala':
            animal = new Koala(animalName, currentTime, 100, 100, 50);
            break;

        case 'cat':
            animal = new Cat(animalName, currentTime, 100, 100, 30);
            break;

        case 'raccoon':
            animal = new Raccoon(animalName, currentTime, 100, 100, 60);
            break;
        default:
            alert('Chose animal type please!');
    }
    console.log(animal);
    document.getElementById('animalCreation').innerHTML =
        '<div>' +
        '<p>Name: ' + animalName + '</p>' +
        '<p>Type: ' + animalType + '</p>' +
        '<p>Time of birth: ' + currentTime + '</p>' +
        '</div>';
});

