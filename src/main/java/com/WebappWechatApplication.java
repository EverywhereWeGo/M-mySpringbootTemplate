package com;

import com.filter.CorsFilter;
import com.filter.IpFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebappWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappWechatApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean CorsFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("corsFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean IPFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new IpFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("ipfilter");
        registration.setOrder(2);
        return registration;
    }


}
