package com.angenin.springboot.config;

import com.angenin.springboot.component.LoginHandlerInterceptor;
import com.angenin.springboot.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

/**
 * @package_name: com.angenin.springboot.config
 * @name: MyConfig
 * @author: angenin
 * @dateTime: 2020/12/13 下午1:15
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override	//添加视图映射
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override   //注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器，addPathPatterns添加拦截路径（/**表示拦截所有请求），excludePathPatterns排除拦截路径
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                //排除登录页面的请求、提交表单的路径、静态资源路径
                .excludePathPatterns("/index.html", "/", "/user/login", "/webjars/**", "/asserts/**");
    }


    // 国际化（配置）
    @Bean
    @ConfigurationProperties(
            prefix = "spring.messages"
    )
    public MessageSourceProperties messageSourceProperties() {
        return new MessageSourceProperties();
    }

    // 国际化
    @Bean	//MessageSource(ResourceBundleMessageSource)是管理国际化的组件
    public MessageSource messageSource(MessageSourceProperties properties) {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        if (StringUtils.hasText(properties.getBasename())) {
            //设置国际化资源文件的基础名（去掉语言国家代码的）
            messageSource.setBasenames(StringUtils.commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(properties.getBasename())));
        }

        if (properties.getEncoding() != null) {
            messageSource.setDefaultEncoding(properties.getEncoding().name());
        }

        messageSource.setFallbackToSystemLocale(properties.isFallbackToSystemLocale());
        Duration cacheDuration = properties.getCacheDuration();
        if (cacheDuration != null) {
            messageSource.setCacheMillis(cacheDuration.toMillis());
        }

        messageSource.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat());
        messageSource.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
        return messageSource;
    }


    // 切换语言（国际化）
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}