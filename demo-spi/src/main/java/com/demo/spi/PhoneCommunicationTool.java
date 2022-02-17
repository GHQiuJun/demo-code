package com.demo.spi;

/**
 * @program: PhoneCommunicationTool
 * @description: 电话通讯
 * @author: 60007949
 * @create: 2022-02-14 11:31
 **/
public class PhoneCommunicationTool implements CommunicationToolSpiInterface {
    @Override
    public void sendMessage(String message) {
        System.out.println("phone send message");
    }
}
