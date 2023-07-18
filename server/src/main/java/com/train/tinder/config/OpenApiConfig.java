package com.train.tinder.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Train Tinder", version = "1.0", description = "Train Tinder API"), servers = {
        @Server(url = "/", description = "Default Server URL") })
public class OpenApiConfig {
}