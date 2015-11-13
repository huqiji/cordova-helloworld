//
//  CDBUserLogin.m
//  HelloWorld
//
//  Created by RockeyCai on 15/11/10.
//
//

#import "CDVUserLogin.h"

#define saveNameKey @"saveNameKey"
#define savePasswordKey @"savePasswordKey"

#define fNameKey @"fName"
#define fPasswordKey @"fPassword"
#define saveUserInfoKey @"saveUserInfo"
#define isLogin @"isLogin"


@implementation CDVUserLogin

/**
 *  登录请求
 *
 *  @param command <#command description#>
 */
- (void)loginAction:(CDVInvokedUrlCommand*)command{
    
    CDVPluginResult* pluginResult = nil;
    NSDictionary* dict = [command.arguments objectAtIndex:0];
    NSLog(@"--%@--" , dict);
    if (dict != nil) {
        
        NSUserDefaults *def = [NSUserDefaults standardUserDefaults];
        
        NSString *fName = [dict objectForKey:fNameKey];
        NSString *fPassword = [dict objectForKey:fPasswordKey];
        NSString *saveUserInfo = [dict objectForKey:saveUserInfoKey];
        
        if ( [fName isEqualToString:@"admin"] && [fPassword isEqualToString:@"123456"]) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"1"];
            //获取登录状态
            [def setValue:@"1" forKey:isLogin];
        }else{
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"0"];
        }
        
        [def setValue:saveUserInfo forKey:saveUserInfoKey];
        
        if ([saveUserInfo isEqualToString:@"1"]) {
            [def setValue:fName forKey:saveNameKey];
            [def setValue:fPassword forKey:savePasswordKey];
        }else{
            [def removeObjectForKey:saveNameKey];
            [def removeObjectForKey:savePasswordKey];
        }
        //登录成功用户名密码
        [def setValue:[NSString stringWithFormat:@"%@昵称" , fName] forKey:fNameKey];
        [def setValue:fPassword forKey:fPasswordKey];
        
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    
    
}

/**
 *  获取记住的用户名密码
 *
 *  @param command <#command description#>
 */
- (void)getSaveUserInfoAction:(CDVInvokedUrlCommand*)command{
    
    CDVPluginResult* pluginResult = nil;
    
    NSMutableDictionary *dict = [NSMutableDictionary new];
    
    NSUserDefaults *def = [NSUserDefaults standardUserDefaults];
    NSString *saveUserInfo = [def stringForKey:saveUserInfoKey];

    //获取登录状态
    [dict setValue:[def stringForKey:isLogin] forKey:isLogin];
    
    NSString *fName = @"";
    NSString *fPassword = @"";
    
    //获取保存用户名密码
    if ([saveUserInfo isEqualToString:@"1"]) {
        fName = [def stringForKey:saveNameKey];
        fPassword = [def stringForKey:savePasswordKey];
    }
    
    if (!saveUserInfo) {
        saveUserInfo = @"1";
    }
    
    [dict setValue:fName forKey:fNameKey];
    [dict setValue:fPassword forKey:fPasswordKey];
    //是否记住密码标签
    [dict setValue:saveUserInfo forKey:saveUserInfoKey];
    
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dict];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

/**
 *  获取登录用的信息
 *
 *  @param command <#command description#>
 */
- (void)getUserInfoAction:(CDVInvokedUrlCommand*)command{
    
    CDVPluginResult* pluginResult = nil;
    
    NSUserDefaults *def = [NSUserDefaults standardUserDefaults];
    NSString *fName = [def stringForKey:fNameKey];
    
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:fName];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

/**
 *  注销登录
 *
 *  @param command <#command description#>
 */
- (void)logoutAction:(CDVInvokedUrlCommand*)command{
    
    CDVPluginResult* pluginResult = nil;
    NSUserDefaults *def = [NSUserDefaults standardUserDefaults];
    //获取登录状态
    [def removeObjectForKey:isLogin];
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:nil];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}


@end
