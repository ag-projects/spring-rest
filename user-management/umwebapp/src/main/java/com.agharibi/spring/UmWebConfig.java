package com.agharibi.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableWebMvc
@ComponentScan("com.agharibi.web")
public class UmWebConfig extends WebMvcConfigurerAdapter {

    public UmWebConfig() {
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> converter = converters.stream().filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();

        if(converter.isPresent()) {
            AbstractJackson2HttpMessageConverter messageConverter = (AbstractJackson2HttpMessageConverter) converter.get();
            messageConverter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            messageConverter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
    }
}
