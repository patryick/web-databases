package pwr.webdatabases.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import pwr.webdatabases.auth.data.model.Role;
import pwr.webdatabases.auth.filter.JwtAuthenticationFilter;
import pwr.webdatabases.auth.service.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserService userService, PasswordEncoder passwordEncoder) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(
                    mvcMatcherBuilder.pattern("/signin")
                )
                .permitAll()
                .requestMatchers(
                    mvcMatcherBuilder.pattern("/grades/*"),
                    mvcMatcherBuilder.pattern("/students/*")
                )
                .hasAuthority(Role.STUDENT.toString())
                .anyRequest().denyAll()
            )
            .authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
//
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
//
//        if (isOtherService) {
//            http
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(session ->
//                    session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .authorizeHttpRequests(authorize -> authorize
//                    .requestMatchers(
//                        mvcMatcherBuilder.pattern("test/users")
//                    ).access((authentication, object) -> authentication
//                        .get().getAuthorities().stream()
//                        .map(Objects::toString)
//                        .filter(a -> a.equals(Role.STUDENT.toString()))
//                        .findAny()
//                        .isEmpty() ? new AuthorizationDecision(false): new AuthorizationDecision(true)
//                    )
//                )
//                .authorizeHttpRequests(authorize -> authorize
//                    .requestMatchers(
//                        mvcMatcherBuilder.pattern("/test/anon"),
//                        mvcMatcherBuilder.pattern("/signin"),
//                        mvcMatcherBuilder.pattern("/signup")
//                    ).permitAll()
//                )
//                .authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);;
//        }
//
//        return http.build();
//    }
}