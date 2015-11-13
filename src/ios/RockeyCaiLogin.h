//
//  CDBUserLogin.h
//  HelloWorld
//
//  Created by RockeyCai on 15/11/10.
//
//

#import <Cordova/CDVPlugin.h>
#import <Cordova/CDV.h>


@interface RockeyCaiLogin : CDVPlugin
/**
 *  登录请求
 *
 *  @param command <#command description#>
 */
- (void)loginAction:(CDVInvokedUrlCommand*)command;

/**
 *  获取记住的用户名密码
 *
 *  @param command <#command description#>
 */
- (void)getSaveUserInfoAction:(CDVInvokedUrlCommand*)command;
/**
 *  获取登录用的信息
 *
 *  @param command <#command description#>
 */
- (void)getUserInfoAction:(CDVInvokedUrlCommand*)command;
/**
 *  注销登录
 *
 *  @param command <#command description#>
 */
- (void)logoutAction:(CDVInvokedUrlCommand*)command;



@end
