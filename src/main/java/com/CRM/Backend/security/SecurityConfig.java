package com.CRM.Backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity(debug = true)
@ComponentScan
public class SecurityConfig {
    private JWTAuthEntryPoint authEntryPoint;
    private CustomUserDetailsService userDetailsService;
    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService, JWTAuthEntryPoint authEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.authEntryPoint = authEntryPoint;
    }

    @Bean
            public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .cors()
                    .and()
                    .csrf().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(authEntryPoint)
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/auth/**").permitAll()
                       .antMatchers("/Societe/getall").hasAuthority("admin")
                    .antMatchers("/Societe/addAndAssignUser").hasAuthority("directure")
                    .antMatchers("/sub/addsub").hasAuthority("admin")
                    .antMatchers("/sublimit/addsublimit").hasAuthority("admin")
                    .antMatchers("/{subId}/assign-sublim/{sublimId}").hasAuthority("admin")
                    .antMatchers("/{{societeId}}/assign-sub/{{subId}}").hasAuthority("directure")
                    .antMatchers("/Product/getall").permitAll()
                    .antMatchers("/Product/getall/{id}").permitAll()
                    .antMatchers("/Product/addproduct").permitAll()
                    .antMatchers("/Product/updateproduct").permitAll()
                    .antMatchers("/Commande/**").permitAll()
                    .antMatchers("/Commande/updateproduct/**").permitAll()
                    .antMatchers("/User/getall").hasAuthority("admin")
                    .antMatchers("/Societe/details").hasAuthority("directure")



                      .anyRequest().authenticated()
                    .and()
                    .httpBasic();
            http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
    @Autowired

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public  JWTAuthentifcationFilter jwtAuthenticationFilter() {
        return new JWTAuthentifcationFilter();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000"); // Allow requests from your frontend
        configuration.addAllowedMethod("*"); // Allow all HTTP methods
        configuration.addAllowedHeader("*"); // Allow all headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

