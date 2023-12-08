package dev.azizoglusergen.cknewsletter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "converkit")
public record ConvertKitProperties(String url, String apiKey) {
}
