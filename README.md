# cordova-helloworld
com-rockeycai-cordova-helloworld

//添加插件
cordova plugin add https://github.com/huqiji/cordova-helloworld.git

//删除插件
cordova plugin remove com-rockeycai-cordova-helloworld

//使用方法
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
