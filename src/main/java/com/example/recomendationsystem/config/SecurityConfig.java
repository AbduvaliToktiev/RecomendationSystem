package com.example.recomendationsystem.config;

import com.example.recomendationsystem.security.jwt.JwtConfigurer;
import com.example.recomendationsystem.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/api/v1/admin/**";
    private static final String USERS_ENDPOINT = "/api/v1/users/**";
    private static final String LOGIN_ENDPOINT = "/api/v1/auth/login";
    private static final String REGISTRATION_ENDPOINT = "/api/v1/users/registration";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(REGISTRATION_ENDPOINT, LOGIN_ENDPOINT).permitAll()
//                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(USERS_ENDPOINT).hasAnyAuthority("ROLE_USER")
                .antMatchers(ADMIN_ENDPOINT).hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
