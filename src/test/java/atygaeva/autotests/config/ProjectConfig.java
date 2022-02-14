package atygaeva.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("91.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    String browserMobileView();

    @DefaultValue("https:user1:1234@selenoid.autotests.cloud/wd/hub/")
    String remoteDriverUrl();

    @DefaultValue("https://selenoid.autotests.cloud/video/")
    String videoStorage();
}
