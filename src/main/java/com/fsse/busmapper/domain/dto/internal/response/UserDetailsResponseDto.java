package com.fsse.busmapper.domain.dto.internal.response;

import com.google.firebase.auth.FirebaseToken;

public class UserDetailsResponseDto {
    private String uid;
    private String tenantId;
    private String issuer;
    private String name;
    private String picture;
    private String email;

    public UserDetailsResponseDto(FirebaseToken token) {
        this.uid = token.getUid();
        this.tenantId = token.getTenantId();
        this.issuer = token.getIssuer();
        this.name = token.getName();
        this.picture = token.getPicture();
        this.email = token.getEmail();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}