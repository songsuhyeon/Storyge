package com.example.project.config;

import com.example.project.user.model.jwt.JwtAuthenticationFilter;
import com.example.project.user.model.jwt.JwtExceptionFilter;
import com.example.project.user.model.jwt.TokenProvider;
import com.example.project.user.model.oauth.CustomOAuth2AuthorizationRequestRepository;
import com.example.project.user.model.oauth.CustomOAuth2UserService;
import com.example.project.user.model.oauth.Handler.OAuth2FailureHandler;
import com.example.project.user.model.oauth.Handler.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final CorsConfig corsConfig;
    private final CustomOAuth2AuthorizationRequestRepository<OAuth2AuthorizationRequest> customOAuth2AuthorizationRequestRepository;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final OAuth2FailureHandler oAuth2FailureHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, CustomOAuth2UserService customOAuth2UserService) throws Exception {
        http
                .addFilter(corsConfig.corsFilter()) // cors ??????. ?????? ?????? ????????????
                .httpBasic().disable() // ?????? ????????? ?????? ????????????
                .formLogin().disable()
                .csrf().disable()   // csrf ?????? ????????????
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt???????????? session ????????????
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**", "/swagger-resources/", "/**", "/favicon.ico").permitAll()
                .antMatchers("/users/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .loginProcessingUrl("/oauth/callback/*") // ??? ???????????? ????????? URL ??????
                .authorizationEndpoint(authorize -> authorize.authorizationRequestRepository(
                        customOAuth2AuthorizationRequestRepository)) // ???????????? ???????????? ?????????????????? ???????????? API??? ?????? ??????
                .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                .successHandler(oAuth2SuccessHandler)
                .failureHandler(oAuth2FailureHandler)
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtExceptionFilter(), JwtAuthenticationFilter.class);
        return http.build();
    }
}
