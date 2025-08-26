package br.com.alura.marketplace.application.v1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@TestConfiguration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.alura.marketplace.application.advice")
@Import(ObjectMapper.class)
public class RestControllerTestConfig {

}
