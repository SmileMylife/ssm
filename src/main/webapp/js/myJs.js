/**
 * Created by ZhangPei on 2018/8/21.
 */
/*function valueCopy(obj) {
    obj.username = "zhangpei";
    obj = new Object();
    obj.username = "zhangxu";
    console.log(obj.username);
}

var obj1 = new Object();
valueCopy(obj1);
console.log(obj1.username);


var username = "zhangsan";
console.log(window.username);


function add(num1) {
    num1 += 10;
    function division() {
        console.log( num1);
    }
    division();
}
add(10);

if (10 < 11) {
    var color = "blue";
}
console.log(window.color);

var compare = function Compare(num1, num2) {
    if(num1 < num2) {
        return 1;
    }else if (num1 > num2) {
        return -1;
    }else {
        return 0;
    }
}

var arr = [1, 3, 2, 5, 4];
var arrResult = arr.sort(compare);
console.log(arrResult);

var arr1 = arr.slice(0, 1);
console.log(arr1);


for (var i = 0; i < 10; i++) {
    i += 1;
}
console.log(i);*/


/*console.log(add);
var result = add(1, 2);
console.log(result);
var add = function(num1, num2) {
    return num1 + num2;
}*/

/*
function add(num1, num2) {
    return (num1 + num2) * 10;
}*/
/*
function getFunc() {
    return function add(num1, num2) {
        return num1 + num2;
    }
}

var func = getFunc();

var sum = func(1, 2);
console.log(sum);*/
/*function add(num1, num2) {
    console.log(arguments.callee);
}

add(1, 2);*/


//call和apply

/*var color = "red";
var o = {"color": "blue"};
function getColor() {
    console.log(this.color);
    return this.color;
}

getColor();     //打印出red
getColor.apply(o, new Array());   //打印出blue*/

/*
var num = 100000;
console.log(num.toLocaleString());
console.log(num.toString());


var date = new Date();
console.log(date.toLocaleString());
console.log(date.toString());*/

/*window.color = "red";
var o = {"color": "blue"};
function getColor() {
    console.log(this.color);
}
getColor();         //red
var getColor1 = getColor.bind(o);
getColor1();*/

/*
window.color = "red";
var o = {"color": "blue"};
function getColor() {
    console.log(this.color);
}
console.log(getColor.toString());
getColor.apply(this, null);
getColor.apply(o, null);*/

/*
var str = new String("123");
str.username = "zhangsan";
console.log(str.username);      //zhangsan

var str1 = "123";
str1.username = "zhangpei";
str1 = null;
console.log(str1.username);     //undefined

var num = 10;*/

/*function Person(username, password) {
    this.username = username;
    this.password = password;
    this.sayHello = sayHello;
}

function sayHello() {
}

var person1 = new Person();
var person2 = new Person();

console.log(person1.sayHello == person2.sayHello);*/

/*function GrandFather(firstName) {
    this.firstName = firstName;
    this.useFire = function() {
        alert("用火");
    }
}

function Father(xuexing, shuangyanpi, height) {
    this.xuexing = xuexing;
    this.shuangyanpi = shuangyanpi;
    this.height = height;
    this.makeMoney = function() {
        console.log("make money");
    }
}

function Son(name, age) {
    this.name = name;
    this.age = age;
    this.learn = function() {
        console.log("learn");
    }
}*/

/*var father = new Father("AB", "danyanpi", "175");
var grandFather = new GrandFather("张");
Son.prototype = father;
father.__proto__ = grandFather;
var son1 = new Son("zhangsan", "22");
console.log(son1);
console.log(son1.__proto__);
console.log(son1.xuexing);
console.log(son1.height);
console.log(son1.shuangyanpi);
son1.makeMoney();
console.log(son1.firstName);
son1.useFire();*/

//Person对象的构造函数
/*
function Person(username, password) {

}

//定义构造函数的原型对象属性
Person.prototype.username = "zhangsan";
Person.prototype.sayHello = function() {
    alert("hello");

}

var person = new Person();

console.log(person.__proto__ == Person.prototype);      //返回true，说明了实例的_proto_属性和构造函数的prototype属性共同指向了原型对象
console.log(Person.prototype.constructor == Person);  //自定义对象的原型对象中只包括了constructor属性，该属性指向了构造函数本身
console.log(Person.prototype.constructor.toLocaleString());     //可证明上一条*/


/*
function SuperType() {
    this.colors = ["red", "blue", "green"];
}

function SubType() {
    SuperType().call(this);
}

var instants1 = new SubType();
instants1.colors.push("yellow");
alert(instants1.colors);

var instance2 = new SubType();
alert(instance2.colors);    //"red,blue,green"*/

/*
var a = "旧值a";
function alertA() {
    alert(a);
    var a = "新值a";
    alert(a);
}

alertA();*/

/*function returnFunc() {
    return function add(num1, num2) {
        return num1 + num2;
    }
}

var func = returnFunc();
console.log(func);

alert(func(1, 2));*/
console.log(4969 + 680 + 650 + 650);