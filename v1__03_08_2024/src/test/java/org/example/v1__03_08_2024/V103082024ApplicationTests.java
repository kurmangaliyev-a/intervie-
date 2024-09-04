package org.example.v1__03_08_2024;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class V103082024ApplicationTests {

    @Test
    void contextLoads() {
    }

}
