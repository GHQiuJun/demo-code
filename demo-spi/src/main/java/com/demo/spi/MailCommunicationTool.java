package com.demo.spi;

/**
 * @program: MailCommunicationTool
 * @description: mail  CommunicationTool
 * @author: 60007949
 * @create: 2022-02-14 14:16
 **/
public class MailCommunicationTool implements CommunicationToolSpiInterface{
    @Override
    public void sendMessage(String message) {
        System.out.println("mail send message");
    }
}
