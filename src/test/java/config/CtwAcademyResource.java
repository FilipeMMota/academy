package config;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Map;

public class CtwAcademyResource implements QuarkusTestResourceLifecycleManager {

    @Override
    public Map<String, String> start() {
        Log.info("Starting ctwAcademyResource");
        return Map.of("quarkus.log.console.json", "true");
    }

    @Override
    public void stop() {
        Log.info("Stopping ctwAcademyResource");
    }
}
