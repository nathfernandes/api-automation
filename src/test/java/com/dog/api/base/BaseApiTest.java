package com.dog.api.base;

import com.dog.api.config.RestAssuredConfig;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseApiTest {

    @BeforeAll
    static void setup() {
        RestAssuredConfig.init();
    }
}
