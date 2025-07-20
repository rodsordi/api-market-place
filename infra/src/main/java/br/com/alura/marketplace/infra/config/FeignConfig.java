package br.com.alura.marketplace.infra.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "br.com.alura")
@Configuration
public class FeignConfig {

}
