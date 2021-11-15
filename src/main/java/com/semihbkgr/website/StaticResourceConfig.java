package com.semihbkgr.website;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Value("${pages.dir}")
    private String pagesDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        var userDir=System.getProperty("user.dir").replace("\\","/");
        var pagesResourceLocation="file:///"+userDir+"/"+pagesDir+"/";
        registry.addResourceHandler("/**").addResourceLocations(pagesResourceLocation);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

}