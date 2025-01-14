package config;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
})
public interface RemoteConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseURL")
    @DefaultValue("https://spb.hh.ru/")
    String getBaseUrl();

    @Key("remoteURL")
    String getRemoteUrl();

    @Key("remoteVideoURL")
    @DefaultValue("https://selenoid.autotests.cloud/video/")
    String getRemoteVideoURL();
}
