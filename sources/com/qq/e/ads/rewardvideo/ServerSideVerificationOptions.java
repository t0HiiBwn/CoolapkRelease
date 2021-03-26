package com.qq.e.ads.rewardvideo;

public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";
    private String a;
    private String b;

    public static class Builder {
        private String a;
        private String b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
    }

    /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.a;
    }

    public String getUserId() {
        return this.b;
    }
}
