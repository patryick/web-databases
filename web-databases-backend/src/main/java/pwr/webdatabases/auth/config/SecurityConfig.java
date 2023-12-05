package pwr.webdatabases.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pwr.webdatabases.auth.filter.JwtAuthenticationFilter;
import pwr.webdatabases.auth.service.UserService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final boolean isOtherService;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserService userService, PasswordEncoder passwordEncoder) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        isOtherService = true;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//            .csrf(AbstractHttpConfigurer::disable)
//            .sessionManagement(session ->
//                session.
//                    sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            )
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers(HttpMethod.POST, "/signup", "/signin").permitAll()
//                .requestMatchers(HttpMethod.GET, "/test/anon").permitAll()
//                .requestMatchers(HttpMethod.GET, "/test/student").hasRole("STUDENT")
//                .anyRequest().authenticated()
//            )
//            .authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        if (isOtherService) {
            http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                    session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.GET, "/other-service").permitAll()
                );
        }
        else {
            http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                    session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.GET, "/other-service").denyAll()
                );
        }

        return http.build();
    }
}