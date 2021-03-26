package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

public interface CredentialsProvider {
    Task<Token> getTokens();
}
