# cordova-helloworld
com-rockeycai-cordova-helloworld

//添加插件
cordova plugin add https://github.com/huqiji/cordova-helloworld.git

//删除插件
cordova plugin remove com-rockeycai-cordova-helloworld

//使用方法
$(document).on("pageinit", "#pageone", function () {

    //调用后台saveHello方法
    $("#sayHello").on("click", function () {
        RockeyCaiHelloWorld.sayHello(1);
    });

    //调用后台saveHelloAndCallBack方法，传递数据msg给回调
    $("#sayHelloAndCallBack").on("click", function () {
        RockeyCaiHelloWorld.sayHelloAndCallBack(1 , function(msg){
            alert(JSON.stringify(msg));
        });
    });


    //调用后台openPage打开页面
    $("#openPage").on("click", function () {
        RockeyCaiHelloWorld.openPage(null , function(msg){
						//cb
        });
    });

});

Demo    
<img src="https://github.com/xujingzhou/BeautyHour/blob/master/Resources/Demo/Demo.gif" width = "300" height = "500" alt="Demo" align=center />
