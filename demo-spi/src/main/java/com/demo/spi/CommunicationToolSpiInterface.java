package com.demo.spi;

/**
 * @program: spi
 * @description: 通讯工具SPI接口·
 * @author:
 * @create: 2022-02-14 11:24
 **/
public interface CommunicationToolSpiInterface {
    /**
     * 发送消息
     *
     * @param message 消息
     */
    void sendMessage(String message);
}
