package com.jsystems.qa.qaapi.qajunit;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
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
    public void tearDownEach(){
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
    @Test
    public void newnewTest(){

        String resultString = "Wordpress powers 34% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertTrue(resultString.startsWith("Wordpress powers"));
        assertTrue(resultString.endsWith("% of the internet"));
        assertThat(resultString).matches("(Wordpress powers )\\d+(% of the internet)");

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");
        int resultNumber = Integer.parseInt(result);
        assertTrue(resultNumber > 0);
    }

    @Test
    public void  stringtest(){

            String simpleString = "simplestring";
            String simple = "simplestring";

            String simpleString_2 = new String("simplestring");
            String simpleString_3 = new String("simplestring");

            assertTrue(simpleString =="simplestring");
            assertTrue(simpleString == simple);
            assertFalse(simpleString == simpleString_2);
            assertFalse(simpleString_2 == simpleString_3);
            assertTrue(simpleString.equals(simple));
            assertTrue(simpleString_2.equals(simpleString_3));
            int a = 1;
            Integer a_1 = 1;
        }
    enum ParamEnum {
        ENUM_ONE,
        ENUM_TWO
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

