# cordova-helloworld
com-rockeycai-cordova-helloworld

//添加插件
cordova plugin add https://github.com/huqiji/cordova-helloworld.git

//删除插件
cordova plugin remove com-rockeycai-cordova-helloworld

//使用方法
$(document).on("pageinit", "#pageone", function () {

    //调用后台saveHello方法
    $("#sayHello").on("click", function () {
        RockeyCaiHelloWorld.sayHello(1);
    });

    //调用后台saveHelloAndCallBack方法，传递数据msg给回调
    $("#sayHelloAndCallBack").on("click", function () {
        RockeyCaiHelloWorld.sayHelloAndCallBack(1 , function(msg){
            alert(JSON.stringify(msg));
        });
    });


    //调用后台openPage打开页面
    $("#openPage").on("click", function () {
        RockeyCaiHelloWorld.openPage(null , function(msg){
						//cb
        });
    });

});
