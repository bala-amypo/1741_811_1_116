package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> ou = userRepository.findByEmail(username);
        User u = ou.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Set<GrantedAuthority> auth = u.getRoles() == null ? Set.of() : u.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), auth);
    }
}
