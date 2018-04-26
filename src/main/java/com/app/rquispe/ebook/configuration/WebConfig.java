package com.app.rquispe.ebook.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
     *This will keep a locale attribute
     *in the user’s HTTP session, so as long as the user’s HTTP session
     * is active, the locale used for this user will be the one specified
     * in the HTTP session locale attribute
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    /*
     * this will intercept each request to check whether there is a lang parameter present.
     * Basically, this interceptor would intercept this request, set the user’s locale to pt (Portuguese),
     * and store it in the user’s HTTP session locale attribute
     * From now on, all application texts will be read from the resource bundle messages_pt.properties.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
