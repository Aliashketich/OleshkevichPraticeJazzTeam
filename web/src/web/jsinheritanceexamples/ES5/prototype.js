function Task(title) {
    this._title = title;
    this.done = false;
    Task.count++;
    console.log('Создание задачи');
}

Object.defineProperty(Task, 'title', {
    get: function () {
        return this._title;
    },
    set: function (value) {
        this._title = value;
    }
});

Task.prototype.complete = function () {
    this.done = true;
    console.log('Задача ' + this._title + ' выполнена');
};

Task.getDefaultTitle = function () {
    return 'Задача';
};

Task.count = 0;

function SubTask(title, parent) {
    Task.call(this, title);
    this._parent = parent;
    console.log('Создание подзадачи');
}

SubTask.prototype.complete = Object.create(Task.prototype);
SubTask.prototype.constructor = SubTask;

var task = new Task('Изучить JavaScript');
var subTask = new SubTask('Изучить наследование в ES5', task);

task.complete();

console.log('getDefaultTask: ' + Task.getDefaultTitle());
console.log('count of created Tasks: ', Task.count);

console.log(task);
console.log(subTask);

console.log(window.Task === Task);