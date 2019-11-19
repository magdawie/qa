package com.jsystems.qa.qajunit;
import com.google.common.truth.BigDecimalSubject;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit tests")
@Tag("unit")
public class JunitTest extends ConfigJunit   {

    @BeforeEach
    public void setupEach(TestInfo testInfo){
        System.out.println("================BeforeEach=====================");
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
    }

    @AfterEach
    public static void tearDownAll(){
        System.out.println("===================AfterAll=================");
    }

    final String stringTestowy = "stringTestowy";

    @DisplayName("First Junit tests")
    //@Disabled("bug: import, 1230")
    @Test
    public void firstTest() {
        assertTrue(stringTestowy.contains("tr"));
        assertTrue(5 == 2 + 3, "message for test result");


        //assertThat(stringTestowy).contains("k");
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        assertThat(stringTestowy).endsWith("wy");
    }

    @Tag("second")
    @Test
    public void secondTest(){
    //assertTrue(0.2*0.2==0.04); - bedzie blad
        System.out.println(0.2*0.2);
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        System.out.println(result);
        assertTrue(result == 0.04);
        assertFalse(0.2*0.2 ==0.04);
    }

    @Nested
    public class NestedTest{

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
                List<Integer> list2 = Arrays.asList(3,4,5);


        @Test
        public void firstNestedTest(){
            assertTrue(list1.containsAll(list2));
            assertThat(list1).hasSize(5);
            assertThat(list1).containsAnyOf(1,2,3);

        }
        @Test
        public void secondNestedTest(){

        }
    }
}
