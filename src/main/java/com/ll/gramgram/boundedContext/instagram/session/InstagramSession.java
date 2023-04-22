package com.ll.gramgram.boundedContext.instagram.session;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstagramSession {
    private String redirectUri;
    private String state;
    private RequestType requestType;
}
