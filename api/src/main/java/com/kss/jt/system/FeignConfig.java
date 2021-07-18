package com.kss.jt.system;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Configuration
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {

                ServletRequestAttributes requestAttributes =
                        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = requestAttributes.getRequest();

                Map<String, String[]> parameterMap = request.getParameterMap();
                if (parameterMap.containsKey("pageCurrent")){
                    requestTemplate.header("pageCurrent",request.getParameterValues("pageCurrent"));
                    requestTemplate.header("pageCurrent",request.getParameterValues("pageCurrent"));
                }


            }
        };
    }
}
