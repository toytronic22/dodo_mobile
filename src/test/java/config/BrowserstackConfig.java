package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/browserstack.properties", })

public interface BrowserstackConfig extends Config {
    String browserstackUrl();
    String browserstackLogin();
    String browserstackPassword();
    String appUrl();
    String deviceName();
    String osVersion();
}
