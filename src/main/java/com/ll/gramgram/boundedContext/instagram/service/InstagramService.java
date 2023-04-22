package com.ll.gramgram.boundedContext.instagram.service;

import com.ll.gramgram.boundedContext.instagram.client.InstagramApiClient;
import com.ll.gramgram.boundedContext.instagram.client.InstagramGraphClient;
import com.ll.gramgram.boundedContext.instagram.properties.InstagramProperties;
import com.ll.gramgram.boundedContext.instagram.response.ShortTokenResponse;
import com.ll.gramgram.boundedContext.instagram.response.TokenResponse;
import com.ll.gramgram.boundedContext.instagram.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstagramService {
    private final InstagramApiClient instagramApiClient;
    private final InstagramGraphClient instagramGraphClient;
    private final InstagramProperties instagramProperties;

    public TokenResponse getAccessToken(String code) {
        ShortTokenResponse shortTokenResponse = instagramApiClient.getAccessToken(createShortTokenForm(code));

        TokenResponse tokenResponse = instagramGraphClient.getAccessToken(
                "ig_exchange_token", instagramProperties.getClientSecret(), shortTokenResponse.getAccessToken());
        tokenResponse.setLocalDateTimeExpiresIn(LocalDateTime.now().plusSeconds(tokenResponse.getExpiresIn()));
        tokenResponse.setUserId(shortTokenResponse.getUserId());
        return tokenResponse;
    }

    public UserInfoResponse getUserInfo(String userId, String accessToken) {
        return instagramGraphClient.getUserInfo(userId, "id,username", accessToken);
    }

    private String createShortTokenForm(String code) {
        return Map.of(
                        "client_id", instagramProperties.getClientId(),
                        "client_secret", instagramProperties.getClientSecret(),
                        "code", code,
                        "grant_type", "authorization_code",
                        "redirect_uri", instagramProperties.getRedirectUri()
                ).entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }
}
