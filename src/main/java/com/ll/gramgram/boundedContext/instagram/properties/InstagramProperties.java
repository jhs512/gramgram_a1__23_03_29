package com.ll.gramgram.boundedContext.instagram.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "custom.instagram")
public class InstagramProperties {
    private final String clientSecret;
    private final String clientId;
    private final String scope;
    private final String authorizationUri;
    private final String apiUri;
    private final String graphUri;
    private final String redirectUri;
}
