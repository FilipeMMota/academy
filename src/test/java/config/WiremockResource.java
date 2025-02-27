package config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.mockito.BDDMockito.willReturn;


public class WiremockResource implements QuarkusTestResourceLifecycleManager {

    WireMockServer wiremock;

    @Override
    public Map<String, String> start() {
        wiremock = new WireMockServer();
        wiremock.start();


//        WireMock.configureFor(new WireMock(wiremock));

//        wiremock.stubFor(WireMock.get(urlEqualTo("/external/hello")).willReturn(aResponse().withStatus(200)));

        wiremock.stubFor(WireMock.post(urlEqualTo("/external/hello")).willReturn(aResponse().withBody("Hello Filipe!")));

        return Map.of("external-api.url", wiremock.baseUrl());
    }

    @Override
    public void stop() {
        wiremock.stop();
    }
}
