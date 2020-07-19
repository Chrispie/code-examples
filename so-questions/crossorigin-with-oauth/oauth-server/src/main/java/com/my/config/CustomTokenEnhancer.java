package com.my.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import com.my.model.CustomUser;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(final OAuth2AccessToken accessToken, final OAuth2Authentication authentication) {
        final CustomUser user = (CustomUser) authentication.getPrincipal();
        final Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
        if (user.getId() != null)
            info.put("id", user.getId());
        if (user.getName() != null)
            info.put("name", user.getName());
        if (user.getUsername() != null)
            info.put("userName", user.getUsername());
        final DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(info);
        return super.enhance(customAccessToken, authentication);
    }
}
