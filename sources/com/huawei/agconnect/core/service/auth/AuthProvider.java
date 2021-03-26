package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

public interface AuthProvider {
    void addTokenListener(OnTokenListener onTokenListener);

    Task<Token> getTokens();

    String getUid();

    void removeTokenListener(OnTokenListener onTokenListener);
}
