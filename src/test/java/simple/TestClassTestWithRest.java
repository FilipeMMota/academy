package simple;

import com.github.tomakehurst.wiremock.client.WireMock;
import config.CtwAcademyTestProfile;
import config.WiremockResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.osgi.resource.Wire;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestProfile(CtwAcademyTestProfile.class)
class TestClassTestWithRest {

    @Inject
    TestClass testClass;

//    @Test
//    @DisplayName("Saying hello from external api")
//    void saying_hello_from_external_api() {
//        String name = "Filipe";
//
////        stubFor(get("/").willReturn(okJson("{\"message\":  \"Hello Filipe!\"}")));
//
//        String result = testClass.sayHello(name);
//
////        WireMock client = new WireMock();
////        assertThat(get("/some/thing")., is(200));
//        assertThat(result).isEqualTo("Hello Filipe!");
//
//    }

}