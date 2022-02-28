package com.soyukkahve.myhotel.configuration;

import com.soyukkahve.myhotel.service.MyUserDetailsService;
import com.soyukkahve.myhotel.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService(userService);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests().antMatchers("/api/home/**","/api/auth/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/rooms/**").hasAnyAuthority("GUEST")
                .antMatchers("/api/reservations/**","/api/rooms/**").hasAnyAuthority("EMPLOYEE")
                .antMatchers("/api/admin/**","/api/departments/**","/api/employees/**").hasAnyAuthority("ADMIN")
                .and()
                .cors().and().csrf().disable()
                .formLogin().disable();

    //.authenticated giriş yaptıysa erişebilir
        //hasAnyAuthhority rolü oysa erişeblir

        //permitall herkes erişebilir

    }


}
