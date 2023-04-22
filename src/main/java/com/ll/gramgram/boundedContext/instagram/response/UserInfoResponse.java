package com.ll.gramgram.boundedContext.instagram.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfoResponse {
    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "username")
    private String username;
}
