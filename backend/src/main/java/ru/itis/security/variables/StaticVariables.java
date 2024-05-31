package ru.itis.security.variables;

public class StaticVariables {
    public static final String[] PERMIT_ALL = {
           "/auth/**", "/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs", "/webjars/**"
    };

    public static final String[] IGNORE = {
    };
}
