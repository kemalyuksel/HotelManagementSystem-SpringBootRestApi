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
                .cors().and().csrf().disable()
                .authorizeRequests().antMatchers("/","/v1/home/**","/v1/auth/**").permitAll()
                .antMatchers(HttpMethod.GET,"/v1/rooms/**").hasAnyAuthority("GUEST")
                .antMatchers("/v1/reservations/**","/v1/rooms/**").hasAnyAuthority("EMPLOYEE")
                .antMatchers("/v1/admin/**","/v1/departments/**","/v1/employees/**").hasAnyAuthority("ADMIN")
                .and()
                .formLogin().disable();

    //.authenticated giriş yaptıysa erişebilir
        //hasAnyAuthhority rolü oysa erişeblir

        //permitall herkes erişebilir

    }


}
