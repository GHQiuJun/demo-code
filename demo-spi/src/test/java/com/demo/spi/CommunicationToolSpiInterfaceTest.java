package com.demo.spi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationToolSpiInterfaceTest {

    @Test
    void sendMessage() {
        CommunicationToolSpiInterface phone = new PhoneCommunicationTool();
        phone.sendMessage("");
        // 若现在有一个mail  CommunicationTool 如何加载呢？
        // 改动源代码？
        // 想象一下，我们可以在配置文件中配置我们需要加载的实现类，每次去加载我们配置文件中的实现类，这就是SPI
    }
}