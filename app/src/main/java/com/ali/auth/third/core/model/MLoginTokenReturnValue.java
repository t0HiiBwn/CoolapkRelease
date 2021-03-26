package com.ali.auth.third.core.model;

import java.io.Serializable;

public class MLoginTokenReturnValue implements Serializable {
    public int expireTime;
    public String token;
}
