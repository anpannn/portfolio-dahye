package com.dahye.portfolio.admin.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AdminInterceptorConfigurationval(
    val adminInterceptor: AdminInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {

        registry.addInterceptor(adminInterceptor)
            .addPathPatterns("/admin/**")
            .excludePathPatterns("/as sets/**", "/css/**", "/js/**", "h2**")
    }
}