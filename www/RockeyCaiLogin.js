

    var exec = require('cordova/exec');

    var RockeyCaiLogin = exports;

    //登录方法
    RockeyCaiLogin.loginAction = function (fromJson , cb2Success , cb2Error) {
        exec(function(msg){
            cb2Success(msg);
        }, function(error){
            cb2Error(error);
        }, "RockeyCaiLogin", "loginAction", [fromJson]);
    };

    //获取数据配置
    RockeyCaiLogin.getSaveUserInfoAction = function (cb2Success , cb2Error) {
        exec(function(msg){
            cb2Success(msg);
        }, function(error){
            cb2Error(error);
        }, "RockeyCaiLogin", "getSaveUserInfoAction", null);
    };

    //退出登录
    RockeyCaiLogin.logoutAction = function (cb2Success , cb2Error) {
        exec(function(msg){
            cb2Success(msg);
        }, function(error){
            cb2Error(error);
        }, "RockeyCaiLogin", "logoutAction", null);
    };

    //获取登录数据
    RockeyCaiLogin.getUserInfoAction = function (cb2Success , cb2Error) {
        exec(function(msg){
            cb2Success(msg);
        }, function(error){
            cb2Error(error);
        }, "RockeyCaiLogin", "getUserInfoAction", null);
    };

    