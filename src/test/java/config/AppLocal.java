package config;

import org.aeonbits.owner.ConfigFactory;

public class AppLocal {
    public static LocalConfig config = ConfigFactory.create(LocalConfig.class, System.getProperties());
}
