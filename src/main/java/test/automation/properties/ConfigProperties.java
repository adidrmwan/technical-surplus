package test.automation.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties({
        ConfigProperties.class
})
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {

    private Web web;
    private Android android;

    @Data
    public static class Web {
        private String baseUrl;
    }

    @Data
    public static class Android {
        private String appPackage;
        private String appActivity;
        private String appPath;
        private String name;
    }

}
