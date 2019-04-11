class Task {
    constructor(title) {
        this._title = title;
        this.done = false;
        Task.count++;
        console.log('Создание задачи ');
    }

    complete() {
        this.done = true;
        console.log('Задача ' + this.title + ' выполнена');
    }

    get title() {
        return this._title;
    }

    set title(value) {
        this._title = value;
    }

    static getDefaultTitle() {
        return 'Задача';
    }
}

Task.count = 0;

class SubTask extends Task {
    constructor(title, parent) {
        super(title);
        this.parent = parent;
        console.log('Создание подзадачи');
    }

    complete() {
        super.complete();
        console.log('Подзадача ' + this.title + ' выполнена');
    }
}

let task = new Task('Изучить JS');
let subTask = new SubTask('Изучить пример наследования в ES6', task);

console.log('getDefaultTask: ' + SubTask.getDefaultTitle());
console.log('count of created Tasks: ', SubTask.count);

task.complete();
subTask.complete();

console.log(task);
console.log(subTask);