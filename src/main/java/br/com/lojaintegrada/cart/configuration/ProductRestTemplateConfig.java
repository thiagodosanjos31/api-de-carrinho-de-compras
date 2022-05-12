package br.com.lojaintegrada.cart.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ProductRestTemplateConfig {

    private final int readTimeout;
    private final int connectTimeout;

    @Autowired
    public ProductRestTemplateConfig(
            @Value("${product_service_read_timeout:850}") final int readTimeout,
            @Value("${default_connect_timeout:500}") final int connectTimeout) {
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }

    @Bean("restTemplateProduct")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(connectTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }
}
