package com.kiry665.trainpass.ModelsRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class AuthenticationResponse {

    private String token;
    private long expires;

    public AuthenticationResponse(String token, long expiration) {
        this.token = token;
        this.expires = System.currentTimeMillis() + expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }
}
