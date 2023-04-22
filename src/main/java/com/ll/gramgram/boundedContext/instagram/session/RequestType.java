package com.ll.gramgram.boundedContext.instagram.session;

public enum RequestType {
    USER_INFO("user_info"),

    ;

    private final String type;

    RequestType(String type) {
        this.type = type;
    }

    public static RequestType of(String type) {
        if (type == null) {
            throw new IllegalStateException();
        }

        for (RequestType requestType: RequestType.values()) {
            if (requestType.type.equals(type)) {
                return requestType;
            }
        }

        throw new IllegalStateException();
    }
}
