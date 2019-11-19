package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.TestCase.assertTrue;

public class QaParametrizedTest extends ConfigJunit {

 // @Test
  @ParameterizedTest(name = "Parameter test with value {0}")
  @ValueSource(ints = {5, 15, 25})
    public void firstParametrizedTest(int number){
      assertTrue(number %5 ==0);

       // int[] ints = {5, 15, 25};  - mozna zrobic logike ale po co
     //   for(int i = 0; i <ints.length ; i++){
      //      assertTrue(ints[i]%5 ==0);
    }
    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(strings = {"Hello", "Hello junit", "Hello studens"})
    public void secondParametrizedTest(String text){
        assertTrue(text.contains("Hello"));
    }
    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvSource(value = {"Hello, 5", "Hello junit, 5, 15", "'Hello 5!', 25"}, delimiter = ',')
    public void nextParametrizedTest(String text, int number){
        assertTrue(text.contains("Hello"));
        assertTrue(number %5 ==0);
    }
    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')
        public void csvFileParametrizedTest(String text, int number){
        assertTrue(text.contains("Hello"));
        assertTrue(number %5 ==0);
    }
   @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @EnumSource(value = ParamEnum.class)
    public void enumFileParametrizedTest(ParamEnum enumtype){

        assertTrue(enumtype.toString().contains("ENUM"));

        }

    enum ParamEnum {
      ENUM_ONE,
        ENUM_TWO
    }

}
