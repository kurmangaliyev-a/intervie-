package org.example.v1__03_08_2024;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.example.v1__03_08_2024.utils.DividersUtil.task2;
import static org.junit.Assert.*;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class DividersUtilTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void DividedByThree() throws Exception {
        assertArrayEquals("Fizz".getBytes(), task2(3));
        assertArrayEquals("Fizz".getBytes(), task2(333));
    }

    @Test
    public void DividedOnlyByFive() throws Exception {
        assertArrayEquals("Buzz".getBytes(), task2(5));
        assertArrayEquals("Buzz".getBytes(), task2(5555));
    }

    @Test
    public void DividedOn3And5() throws Exception {
        assertArrayEquals("FizzBuzz".getBytes(), task2(0));
        assertArrayEquals("FizzBuzz".getBytes(), task2(151515));
    }

    @Test
    public void NotDevidedOn3And5() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> task2(13));
        assertThrows(IllegalArgumentException.class, () -> task2(133));

    }

}
