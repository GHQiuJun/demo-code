package com.demo.spi;

import org.junit.jupiter.api.Test;

/**
 * @program: GetClassPath
 * @description: 获取ClassPath
 * @author: 60007949
 * @create: 2022-02-21 18:57
 **/
public class GetClassPath {

    @Test
    void testGetClassPath() throws Exception {
        System.out.println(System.getProperty("java.class.path"));
    }
}
