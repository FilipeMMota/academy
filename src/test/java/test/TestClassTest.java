package test;

import simple.TestClass;
import io.quarkus.logging.Log;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

class TestClassTest {

    public static Stream<Arguments> argumentsOfSayHello() {
        return Stream.of(Arguments.of("Hello Filipe", "Filipe"), Arguments.of("Hello Rennan", "Rennan"), Arguments.of("Hello Nuno", "Nuno"));
    }

    private static TestClass testClass;

    @BeforeAll
    static void setup(){
        testClass = new TestClass();
    }

    @ParameterizedTest
    @Order(1)
    @MethodSource(value = {"argumentsOfSayHello"})
    void sayHello(String expected, String name) {

        String result = testClass.sayHello(name);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @Order(2)
    @NullSource

    void test_invalid_name(String name){

        String result = testClass.sayHello(name);

        Assertions.assertEquals("Hello", result);
    }

    @AfterAll
    static void closing(){
        Log.info("Closing");
    }
}