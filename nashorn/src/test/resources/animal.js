function Animal(name) {
    this.name = name;
    this.sayName = function() {
        return "My name is " + this.name;
    }
}