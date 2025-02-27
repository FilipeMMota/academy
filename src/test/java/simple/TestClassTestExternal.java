package simple;

import io.quarkus.test.junit.mockito.InjectSpy;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TestClassTestExternal {

//    @Spy
//    ExternalMessageService externalMessageService;
//
//    @InjectMocks
//    TestClass testClass;
//
//    @Test
//    @DisplayName("hello from outer space")
//    void hello_from_outer_space() {
////        TestClass testClass = new TestClass();
//        String name = "Filipe";
////
////        ExternalMessageService externalMessageService = Mockito.mock(ExternalMessageService.class);
////        testClass.externalMessageService = externalMessageService;
//
////        Mockito.when(externalMessageService.sayHelloFromOuterSpace()).thenReturn("Hello from outer space");
////        Mockito.when(externalMessageService.sayHelloFromOuterSpace(Mockito.anyString())).thenReturn("Hello %s from outer space".formatted(name));
////
////        String result = testClass.sayHello(name);
////
////        assertThat(result).isEqualTo("Hello Filipe from outer space");
//
//
//        // Com o spy já exite uma implementação ou seja tu das "override" a uma implementação existente
//        //
//
//
////        TestClass testClass = new TestClass();
////
////        ExternalMessageService externalMessageService = Mockito.spy(ExternalMessageServiceImpl.class);
////        testClass.externalMessageService = externalMessageService;
//
//        Mockito.doReturn("Hello from outer space Filipe").when(externalMessageService).sayHelloFromOuterSpace("Filipe");
//
//        String result = testClass.sayHello("Filipe");
//
//        assertThat(result).isEqualTo("Hello from outer space Filipe");
//    }
}