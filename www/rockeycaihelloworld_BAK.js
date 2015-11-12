cordova.define("cordova-plugin-rockeycaihelloworld.rockeycaihelloworld", function (require, exports, module) {

    var exec = require('cordova/exec');


    var namedColors = {};


    var RockeyCaiHelloWorld = exports;


    RockeyCaiHelloWorld.sayHello = function () {
        exec(null, null, "RockeyCaiHelloWorld", "sayHello", null);
    };

    RockeyCaiHelloWorld.sayHelloAndCallBack = function (data , cb) {
        exec(cb, null, "RockeyCaiHelloWorld", "sayHelloAndCallBack", [data]);
    };

    RockeyCaiHelloWorld.openPage = function (data , cb) {
        exec(function(msg){
            document.location.href = "plugins/com.rockeycai.cordova.helloworld/www/helloworld.html";
        }, null, "RockeyCaiHelloWorld", "openPage", [data]);
    };

});
