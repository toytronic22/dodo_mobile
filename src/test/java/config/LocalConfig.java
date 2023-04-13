package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/local.properties",})

public interface LocalConfig extends Config {

    String deviceName();

    String platformName();

    String platformVersion();
}