package com.worksplit.resourceserver;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorksplitUserAuthenticationConverter implements UserAuthenticationConverter {

    private final String EMAIL = "email";

    private Collection<? extends GrantedAuthority> defaultAuthorities;

    public void setDefaultAuthorities(String[] defaultAuthorities){
        this.defaultAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.arrayToCommaDelimitedString(defaultAuthorities));
    }
    @Override
    public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
        Map<String , Object> response = new LinkedHashMap<>();
        response.put(USERNAME, userAuthentication.getName());
        if(userAuthentication.getAuthorities() != null && !userAuthentication.getAuthorities().isEmpty()){
            response.put(AUTHORITIES , AuthorityUtils.authorityListToSet(userAuthentication.getAuthorities()));
        }
        return response;
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if(map.containsKey(USERNAME)) {
            return new UsernamePasswordAuthenticationToken(new WorksplitPrincipal((map.get(USERNAME).toString()), map.get(EMAIL).toString()),"N/A",getAuthorities(map));
        }
        return null;
    }

    private Collection<? extends  GrantedAuthority> getAuthorities(Map<String,?> map) {
        if(!map.containsKey(AUTHORITIES)){
            return defaultAuthorities;
        }
        Object auth = map.get(AUTHORITIES);
        if(auth instanceof String){
            return  AuthorityUtils.commaSeparatedStringToAuthorityList(auth.toString());
        }
        if(auth instanceof Collection){
            return  AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString((Collection<?>) auth));
        }
        throw new IllegalArgumentException("Authorities must be either String or Collection");
    }
}
