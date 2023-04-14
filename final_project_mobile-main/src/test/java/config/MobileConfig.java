package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})

public interface  MobileConfig extends Config{
    @Key("login")
    String login();
    @Key("password")
    String password();
    @Key("baseURL")
    String baseUrl();
    @Key("appURL")
    String appUrl();
    @Key("device")
    String device();
    @Key("os_version")
    String osVersion();
    @Key("project")
    String projectName();
    @Key("build")
    String buildName();
    @Key("name")
    String testName();
    @Key("appiumServer")
    String appiumServer();
    @Key("deviceName")
    String deviceName();
    @Key("platformVersion")
    String platformVersion();
    @Key("getAppPath")
    String getAppPath();
    @Key("appPackage")
    String appPackage();
    @Key("appActivity")
    String appActivity();
}
