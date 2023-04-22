package com.ll.gramgram.base.appConfig;

import com.ll.gramgram.boundedContext.instagram.session.RequestTypeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new RequestTypeConverter());
    }
}


