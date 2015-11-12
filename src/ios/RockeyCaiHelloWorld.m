//
//  MyHelloWorld.m
//  HelloWorld
//
//  Created by RockeyCai on 15/11/11.
//
//

#import "RockeyCaiHelloWorld.h"

@implementation RockeyCaiHelloWorld

/**
 *  打印前台js传递过来数据入口
 *
 *  @param command <#command description#>
 */
- (void)sayHello:(CDVInvokedUrlCommand*)command{
    
    NSLog(@"--javaScript Call sayHello:HelloWorld----");

}


/**
 *  打印前台js传递过来数据入口,然后把数据给回调方法
 *
 *  @param command command description
 */
- (void)sayHelloAndCallBack:(CDVInvokedUrlCommand*)command{
    
    NSLog(@"--javaScript Call sayHelloAndCallBack----");
    
    CDVPluginResult* pluginResult = nil;
    
    NSDictionary* dict = [command.arguments objectAtIndex:0];
    NSLog(@"--javaScript Call sayHelloAndCallBack 接收到的参数:%@----" , dict);
    
    //设置返回值
    dict = @{@"result" : @"result data"};
    
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dict];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    
}



/**
 *  打开插件中的页面
 *
 *  @param command command description
 */
- (void)openPage:(CDVInvokedUrlCommand*)command{
    
    NSLog(@"--javaScript Call openPage----");

    
    CDVPluginResult* pluginResult = nil;
    
    NSDictionary* dict = [command.arguments objectAtIndex:0];
    
    //设置返回值
    dict = @{@"result" : @"openPage"};
    
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dict];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
