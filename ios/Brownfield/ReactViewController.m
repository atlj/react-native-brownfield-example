//
//  ViewController.m
//  Brownfield
//
//  Created by Burak Güner on 30.01.2024.
//

#import "ReactViewController.h"
#import <React/RCTBridge.h>
#import <React/RCTRootView.h>
#import <UIKit/UIApplication.h>
#import "AppDelegate.h"

@interface ReactViewController ()

@end

@implementation ReactViewController {
}

- (void)viewDidLoad {
    AppDelegate *delegate = [[UIApplication sharedApplication] delegate];
    self.view = [[RCTRootView alloc] initWithBridge:delegate.bridge moduleName:@"Brownfield" initialProperties:nil];

    // Do any additional setup after loading the view.
}

@end
