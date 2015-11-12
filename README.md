# cordova-helloworld
com-rockeycai-cordova-helloworld




$(document).on("pageinit", "#pageone", function () {

    //saveHello
    $("#sayHello").on("click", function () {
        RockeyCaiHelloWorld.sayHello(1);
    });

    //saveHelloAndCallBack
    $("#sayHelloAndCallBack").on("click", function () {
        RockeyCaiHelloWorld.sayHelloAndCallBack(1 , function(msg){
            alert(JSON.stringify(msg));
        });
    });


    //saveHelloAndCallBack
    $("#openPage").on("click", function () {
        RockeyCaiHelloWorld.openPage(null , function(msg){
						//cb
        });
    });

});