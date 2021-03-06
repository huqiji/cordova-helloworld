

    var exec = require('cordova/exec');

    var namedColors = {};

    var RockeyCaiHelloWorld = exports;

    RockeyCaiHelloWorld.sayHello = function () {
        exec(null, null, "RockeyCaiHelloWorld", "sayHello", [null]);
    };

    RockeyCaiHelloWorld.sayHelloAndCallBack = function (data , cb) {
        exec(cb, null, "RockeyCaiHelloWorld", "sayHelloAndCallBack", [data]);
    };

    //RockeyCaiHelloWorld.openPage_iOS = function (data , cb) {
    //    exec(function(msg){
    //        document.location.href = "plugins/com-rockeycai-cordova-helloworld/www/helloworld.html";
    //        cb(msg)
    //    }, null, "RockeyCaiHelloWorld", "openPage", [data]);
    //};
    //
    //RockeyCaiHelloWorld.openPage_Android = function (data , cb) {
    //    exec(function(msg){
    //        document.location.href = "helloworld.html";
    //        cb(msg)
    //    }, null, "RockeyCaiHelloWorld", "openPage", [data]);
    //};

     RockeyCaiHelloWorld.openPage = function (data , cb) {
        exec(function(msg){
            var jsonData = eval(msg);
            if(jsonData.success == 1){
                if(jsonData.isType == 1){
                    document.location.href = "plugins/com-rockeycai-cordova-helloworld/www/helloworld.html";
                }else if(jsonData.isType == 2){
                    document.location.href = "helloworld.html";
                }
            }
            cb(msg)
        }, null, "RockeyCaiHelloWorld", "openPage", [data]);
     };

    RockeyCaiHelloWorld.openPageVC = function (data , cb) {
        exec(function(msg){
            cb(msg)
        }, null, "RockeyCaiHelloWorld", "openPageVC", [data]);
    };

