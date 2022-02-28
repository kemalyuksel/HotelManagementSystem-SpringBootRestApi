package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.configuration.MyUserPrincipal;
import com.soyukkahve.myhotel.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserPrincipal(user);
    }

}
