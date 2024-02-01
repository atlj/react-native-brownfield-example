//
//  AppDelegate.h
//  Brownfield
//
//  Created by Burak Güner on 30.01.2024.
//

#import <UIKit/UIKit.h>
#import <React/RCTBridge.h>
#import <React/RCTBundleURLProvider.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate, RCTBridgeDelegate>
@property (nullable, nonatomic, strong) UIWindow *window;
@property (nullable, nonatomic, strong) RCTBridge *bridge;

@end

