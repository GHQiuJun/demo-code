package com.demo.spi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSpiTestTest {

    @Autowired
    private SpringSpiTestService springSpiTestService;

    @Test
    void test() {
        springSpiTestService.test();
    }
}