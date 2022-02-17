package com.demo.spi;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @program: JdkSpiTest
 * @description: jdk spi test
 * @author: 60007949
 * @create: 2022-02-14 14:26
 **/
public class JdkSpiTest {

    @Test
    void testJdkSpiUse() {
        // 加载配置文件中的实现类
        ServiceLoader<CommunicationToolSpiInterface> serviceLoader = ServiceLoader.load(CommunicationToolSpiInterface.class);

        // 遍历实现类
        for (CommunicationToolSpiInterface communicationToolSpiInterface : serviceLoader) {
            communicationToolSpiInterface.sendMessage("");
        }
        // 选择最后一个实现类调用
    }
}
