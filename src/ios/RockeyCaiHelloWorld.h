//
//  MyHelloWorld.h
//  HelloWorld
//
//  Created by RockeyCai on 15/11/11.
//
//

#import <Cordova/CDVPlugin.h>
#import <Cordova/CDVInvokedUrlCommand.h>

@interface RockeyCaiHelloWorld : CDVPlugin

/**
 *  打印前台js传递过来数据入口
 *
 *  @param command <#command description#>
 */
- (void)sayHello:(CDVInvokedUrlCommand*)command;

/**
 *  打印前台js传递过来数据入口,然后把数据给回调方法
 *
 *  @param command command description
 */
- (void)sayHelloAndCallBack:(CDVInvokedUrlCommand*)command;


/**
 *  打开插件中的页面
 *
 *  @param command command description
 */
- (void)openPage:(CDVInvokedUrlCommand*)command;


/**
 *  打开插件中的页面
 *
 *  @param command command description
 */
- (void)openPageVC:(CDVInvokedUrlCommand*)command;


@end
