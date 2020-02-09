package com.ejournal.java.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by kristiyan.parvanov on 1.12.19 г.
 */
public interface CustomUserDetailsService extends UserDetailsService {

    UserDetails loadUserById(String id);
}
