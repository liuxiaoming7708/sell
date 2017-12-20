package com.payease.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 * 2017-07-04 01:05
 */
@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

//    @Bean
//    public BestPayServiceImpl bestPayService() {
//        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
//        bestPayService.setWxPayH5Config(wxPayH5Config());
//        return bestPayService;
//    }
//
//    @Bean
//    public WxPayH5Config wxPayH5Config() {
//        WxPayH5Config wxPayH5Config = new WxPayH5Config();
//        wxPayH5Config.setAppId(accountConfig.getMpAppId());
//        wxPayH5Config.setAppSecret(accountConfig.getMpAppSecret());
//        wxPayH5Config.setMchId(accountConfig.getMchId());
//        wxPayH5Config.setMchKey(accountConfig.getMchKey());
//        wxPayH5Config.setKeyPath(accountConfig.getKeyPath());
//        wxPayH5Config.setNotifyUrl(accountConfig.getNotifyUrl());
//        return wxPayH5Config;
//    }
}
