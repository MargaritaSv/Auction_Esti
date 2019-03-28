package org.softuni.auction_esti.security;

import org.softuni.auction_esti.domain.entities.UserPassword;
import org.softuni.auction_esti.repository.UserPasswordRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final UserPasswordRepository userPasswordRepository;

    public CustomUserDetailsService(UserPasswordRepository userPasswordRepository) {
        this.userPasswordRepository = userPasswordRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserPassword user = userPasswordRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + username + "not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities(user));

    }

    private static Collection<? extends GrantedAuthority> getAuthorities(UserPassword user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
