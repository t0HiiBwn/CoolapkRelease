package com.huawei.agconnect.core.service.auth;

public interface Token {
    long getExpiration();

    long getIssuedAt();

    long getNotBefore();

    String getTokenString();
}
