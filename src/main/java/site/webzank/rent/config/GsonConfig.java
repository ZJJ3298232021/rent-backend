package site.webzank.rent.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zank
 */
@Configuration
@Slf4j
public class GsonConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }
}
