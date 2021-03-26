package com.tencent.android.tpns.mqtt.internal.websocket;

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

public class Base64 {
    private static final Base64Encoder ENCODER;
    private static final Base64 INSTANCE;

    static {
        Base64 base64 = new Base64();
        INSTANCE = base64;
        ENCODER = new Base64Encoder();
    }

    public static String encode(String str) {
        Base64Encoder base64Encoder = ENCODER;
        base64Encoder.putByteArray("akey", str.getBytes());
        return base64Encoder.getBase64String();
    }

    public static String encodeBytes(byte[] bArr) {
        Base64Encoder base64Encoder = ENCODER;
        base64Encoder.putByteArray("aKey", bArr);
        return base64Encoder.getBase64String();
    }

    public class Base64Encoder extends AbstractPreferences {
        private String base64String = null;

        @Override // java.util.prefs.AbstractPreferences
        protected AbstractPreferences childSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected String[] childrenNamesSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void flushSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        protected String getSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected String[] keysSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void removeNodeSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void removeSpi(String str) {
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void syncSpi() throws BackingStoreException {
        }

        public Base64Encoder() {
            super(null, "");
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void putSpi(String str, String str2) {
            this.base64String = str2;
        }

        public String getBase64String() {
            return this.base64String;
        }
    }
}
