package ru.job4j.model;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    DBA,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
