package com.srg.ebankspring.Config;

import jdk.jfr.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authRequest ->{
            //allows page
          //  authRequest.requestMatchers("/").permitAll();
            //Authentication page
            authRequest.requestMatchers("/api/**").hasRole("ADMIN");
            authRequest.requestMatchers("/api/Transfer","/api/Transfer/AllTransfer").authenticated();
        });
        http.formLogin(Customizer.withDefaults());
        http.logout(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
