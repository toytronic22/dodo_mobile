package config;

import org.aeonbits.owner.ConfigFactory;

public class AppBrowserstack {
    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
}
