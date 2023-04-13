package helpers;

import config.RunConfig;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunHelper {
    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "local":
                return LocalMobileDriver.class;
            case "null":
                throw new NullPointerException("Device host is null");
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }
}
