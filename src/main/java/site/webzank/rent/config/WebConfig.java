package site.webzank.rent.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.webzank.rent.interceptor.AuthInterceptor;

/**
 * @author zank
 */
@Configuration
@Slf4j
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("拦截器已加载");
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/auth/**")
        ;
    }
}
