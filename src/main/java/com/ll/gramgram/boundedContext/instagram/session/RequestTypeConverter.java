package com.ll.gramgram.boundedContext.instagram.session;

import org.springframework.core.convert.converter.Converter;

public class RequestTypeConverter implements Converter<String, RequestType> {
    @Override
    public RequestType convert(String type) {
        return RequestType.of(type);
    }
}
