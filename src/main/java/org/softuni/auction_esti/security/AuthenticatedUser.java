package org.softuni.auction_esti.security;

import org.softuni.auction_esti.domain.entities.Role;
import org.softuni.auction_esti.domain.entities.UserPassword;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private UserPassword user;

    public AuthenticatedUser(UserPassword user) {
        super(user.getEmail(), user.getPassword(), getAuthorities(user));
        this.user = user;
    }

    public UserPassword getUser() {
        return user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(UserPassword user) {
        Set<String> roleAndPermissions = new HashSet<>();
        List<Role> roles = user.getRoles();

        for (Role role : roles) {
            roleAndPermissions.add(role.getName());
        }
        String[] roleNames = new String[roleAndPermissions.size()];
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
        return authorities;
    }
}
