package com.entropy.backend.security.config;

import com.entropy.backend.model.enumeration.UserType;
import com.entropy.backend.repository.HttpCookieOAuth2AuthorizationRequestRepository;
import com.entropy.backend.security.entrypoint.JwtAuthenticationEntryPoint;
import com.entropy.backend.security.jwt.JwtAuthenticationFilter;
import com.entropy.backend.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.entropy.backend.security.oauth2.OAuth2AuthenticationSuccessHandler;
import com.entropy.backend.service.impl.OAuth2UserCustomServiceImpl;
import com.entropy.backend.service.impl.UserDetailsImplServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author bac-ta
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsImplServiceImpl userDetailsService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final OAuth2UserCustomServiceImpl oAuth2UserCustomService;
    @Autowired
    private OAuth2AuthenticationSuccessHandler successHandler;
    @Autowired
    private OAuth2AuthenticationFailureHandler failureHandler;

    @Autowired
    public SecurityConfiguration(UserDetailsImplServiceImpl userDetailsService, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                                 OAuth2UserCustomServiceImpl oAuth2UserCustomService) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.oAuth2UserCustomService = oAuth2UserCustomService;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login", "/user/regist", "/file/view-file/*").permitAll()
                .antMatchers("/post/*", "/file/*", "/category/*").hasAuthority(UserType.ADMINITRATOR.getName())
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize")
                .authorizationRequestRepository(cookieAuthorizationRequestRepository())
                .and()
                .redirectionEndpoint()
                .baseUri("/oauth2/callback/*")
                .and()
                .userInfoEndpoint()
                .userService(oAuth2UserCustomService)
                .and()
                .successHandler(successHandler).failureHandler(failureHandler);
        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

}
