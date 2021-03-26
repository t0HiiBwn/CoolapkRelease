package com.alibaba.sdk.android.oss.common.auth;

public abstract class OSSCustomSignerCredentialProvider implements OSSCredentialProvider {
    @Override // com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public OSSFederationToken getFederationToken() {
        return null;
    }

    public abstract String signContent(String str);
}
