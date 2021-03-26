package com.tencent.android.tpns.mqtt.internal.security;

import com.tencent.android.tpns.mqtt.MqttSecurityException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SSLSocketFactoryFactory {
    public static final String CIPHERSUITES = "com.ibm.ssl.enabledCipherSuites";
    private static final String CLASS_NAME = "com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory";
    public static final String CLIENTAUTH = "com.ibm.ssl.clientAuthentication";
    public static final String DEFAULT_PROTOCOL = "TLS";
    public static final String JSSEPROVIDER = "com.ibm.ssl.contextProvider";
    public static final String KEYSTORE = "com.ibm.ssl.keyStore";
    public static final String KEYSTOREMGR = "com.ibm.ssl.keyManager";
    public static final String KEYSTOREPROVIDER = "com.ibm.ssl.keyStoreProvider";
    public static final String KEYSTOREPWD = "com.ibm.ssl.keyStorePassword";
    public static final String KEYSTORETYPE = "com.ibm.ssl.keyStoreType";
    public static final String SSLPROTOCOL = "com.ibm.ssl.protocol";
    public static final String SYSKEYMGRALGO = "ssl.KeyManagerFactory.algorithm";
    public static final String SYSKEYSTORE = "javax.net.ssl.keyStore";
    public static final String SYSKEYSTOREPWD = "javax.net.ssl.keyStorePassword";
    public static final String SYSKEYSTORETYPE = "javax.net.ssl.keyStoreType";
    public static final String SYSTRUSTMGRALGO = "ssl.TrustManagerFactory.algorithm";
    public static final String SYSTRUSTSTORE = "javax.net.ssl.trustStore";
    public static final String SYSTRUSTSTOREPWD = "javax.net.ssl.trustStorePassword";
    public static final String SYSTRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
    public static final String TRUSTSTORE = "com.ibm.ssl.trustStore";
    public static final String TRUSTSTOREMGR = "com.ibm.ssl.trustManager";
    public static final String TRUSTSTOREPROVIDER = "com.ibm.ssl.trustStoreProvider";
    public static final String TRUSTSTOREPWD = "com.ibm.ssl.trustStorePassword";
    public static final String TRUSTSTORETYPE = "com.ibm.ssl.trustStoreType";
    private static final byte[] key = {-99, -89, -39, Byte.MIN_VALUE, 5, -72, -119, -100};
    private static final String[] propertyKeys = {"com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication"};
    private static final String xorTag = "{xor}";
    private Hashtable configs;
    private Properties defaultProperties;
    private Logger logger;

    public static boolean isSupportedOnJVM() throws LinkageError, ExceptionInInitializerError {
        try {
            Class.forName("javax.net.ssl.SSLServerSocketFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public SSLSocketFactoryFactory() {
        this.logger = null;
        this.configs = new Hashtable();
    }

    public SSLSocketFactoryFactory(Logger logger2) {
        this();
        this.logger = logger2;
    }

    private boolean keyValid(String str) {
        String[] strArr;
        int i = 0;
        while (true) {
            strArr = propertyKeys;
            if (i >= strArr.length || strArr[i].equals(str)) {
                break;
            }
            i++;
        }
        if (i < strArr.length) {
            return true;
        }
        return false;
    }

    private void checkPropertyKeys(Properties properties) throws IllegalArgumentException {
        for (String str : properties.keySet()) {
            if (!keyValid(str)) {
                throw new IllegalArgumentException(str + " is not a valid IBM SSL property key.");
            }
        }
    }

    public static char[] toChar(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[(bArr.length / 2)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i + 1;
            cArr[i2] = (char) ((bArr[i] & 255) + ((bArr[i3] & 255) << 8));
            i2++;
            i = i3 + 1;
        }
        return cArr;
    }

    public static byte[] toByte(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = new byte[(cArr.length * 2)];
        int i = 0;
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i + 1;
            bArr[i] = (byte) (cArr[i2] & 255);
            i = i3 + 1;
            bArr[i3] = (byte) ((cArr[i2] >> '\b') & 255);
        }
        return bArr;
    }

    public static String obfuscate(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = toByte(cArr);
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte[] bArr2 = key;
            bArr[i] = (byte) ((b ^ bArr2[i % bArr2.length]) & 255);
        }
        return "{xor}" + new String(SimpleBase64Encoder.encode(bArr));
    }

    public static char[] deObfuscate(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] decode = SimpleBase64Encoder.decode(str.substring(5));
            for (int i = 0; i < decode.length; i++) {
                byte b = decode[i];
                byte[] bArr = key;
                decode[i] = (byte) ((b ^ bArr[i % bArr.length]) & 255);
            }
            return toChar(decode);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String packCipherSuites(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            stringBuffer.append(strArr[i]);
            if (i < strArr.length - 1) {
                stringBuffer.append(',');
            }
        }
        return stringBuffer.toString();
    }

    public static String[] unpackCipherSuites(String str) {
        if (str == null) {
            return null;
        }
        Vector vector = new Vector();
        int indexOf = str.indexOf(44);
        int i = 0;
        while (indexOf > -1) {
            vector.add(str.substring(i, indexOf));
            i = indexOf + 1;
            indexOf = str.indexOf(44, i);
        }
        vector.add(str.substring(i));
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    private void convertPassword(Properties properties) {
        String property = properties.getProperty("com.ibm.ssl.keyStorePassword");
        if (property != null && !property.startsWith("{xor}")) {
            properties.put("com.ibm.ssl.keyStorePassword", obfuscate(property.toCharArray()));
        }
        String property2 = properties.getProperty("com.ibm.ssl.trustStorePassword");
        if (property2 != null && !property2.startsWith("{xor}")) {
            properties.put("com.ibm.ssl.trustStorePassword", obfuscate(property2.toCharArray()));
        }
    }

    public void initialize(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        convertPassword(properties2);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public void merge(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = this.defaultProperties;
        if (str != null) {
            properties2 = (Properties) this.configs.get(str);
        }
        if (properties2 == null) {
            properties2 = new Properties();
        }
        convertPassword(properties);
        properties2.putAll(properties);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public boolean remove(String str) {
        if (str != null) {
            if (this.configs.remove(str) != null) {
                return true;
            }
        } else if (this.defaultProperties != null) {
            this.defaultProperties = null;
            return true;
        }
        return false;
    }

    public Properties getConfiguration(String str) {
        Object obj;
        if (str == null) {
            obj = this.defaultProperties;
        } else {
            obj = this.configs.get(str);
        }
        return (Properties) obj;
    }

    private String getProperty(String str, String str2, String str3) {
        String propertyFromConfig = getPropertyFromConfig(str, str2);
        return (propertyFromConfig == null && str3 != null) ? System.getProperty(str3) : propertyFromConfig;
    }

    private String getPropertyFromConfig(String str, String str2) {
        String str3 = null;
        Properties properties = str != null ? (Properties) this.configs.get(str) : null;
        if (properties != null && (str3 = properties.getProperty(str2)) != null) {
            return str3;
        }
        Properties properties2 = this.defaultProperties;
        if (properties2 == null || (str3 = properties2.getProperty(str2)) != null) {
        }
        return str3;
    }

    public String getSSLProtocol(String str) {
        return getProperty(str, "com.ibm.ssl.protocol", null);
    }

    public String getJSSEProvider(String str) {
        return getProperty(str, "com.ibm.ssl.contextProvider", null);
    }

    public String getKeyStore(String str) {
        String propertyFromConfig = getPropertyFromConfig(str, "com.ibm.ssl.keyStore");
        return propertyFromConfig != null ? propertyFromConfig : System.getProperty("javax.net.ssl.keyStore");
    }

    public char[] getKeyStorePassword(String str) {
        String property = getProperty(str, "com.ibm.ssl.keyStorePassword", "javax.net.ssl.keyStorePassword");
        if (property == null) {
            return null;
        }
        if (property.startsWith("{xor}")) {
            return deObfuscate(property);
        }
        return property.toCharArray();
    }

    public String getKeyStoreType(String str) {
        return getProperty(str, "com.ibm.ssl.keyStoreType", "javax.net.ssl.keyStoreType");
    }

    public String getKeyStoreProvider(String str) {
        return getProperty(str, "com.ibm.ssl.keyStoreProvider", null);
    }

    public String getKeyManager(String str) {
        return getProperty(str, "com.ibm.ssl.keyManager", "ssl.KeyManagerFactory.algorithm");
    }

    public String getTrustStore(String str) {
        return getProperty(str, "com.ibm.ssl.trustStore", "javax.net.ssl.trustStore");
    }

    public char[] getTrustStorePassword(String str) {
        String property = getProperty(str, "com.ibm.ssl.trustStorePassword", "javax.net.ssl.trustStorePassword");
        if (property == null) {
            return null;
        }
        if (property.startsWith("{xor}")) {
            return deObfuscate(property);
        }
        return property.toCharArray();
    }

    public String getTrustStoreType(String str) {
        return getProperty(str, "com.ibm.ssl.trustStoreType", null);
    }

    public String getTrustStoreProvider(String str) {
        return getProperty(str, "com.ibm.ssl.trustStoreProvider", null);
    }

    public String getTrustManager(String str) {
        return getProperty(str, "com.ibm.ssl.trustManager", "ssl.TrustManagerFactory.algorithm");
    }

    public String[] getEnabledCipherSuites(String str) {
        return unpackCipherSuites(getProperty(str, "com.ibm.ssl.enabledCipherSuites", null));
    }

    public boolean getClientAuthentication(String str) {
        String property = getProperty(str, "com.ibm.ssl.clientAuthentication", null);
        if (property != null) {
            return Boolean.valueOf(property).booleanValue();
        }
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001c: APUT  (r8v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r9v0 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003f: APUT  (r5v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.String) */
    private SSLContext getSSLContext(String str) throws MqttSecurityException {
        SSLContext sSLContext;
        String sSLProtocol = getSSLProtocol(str);
        if (sSLProtocol == null) {
            sSLProtocol = "TLS";
        }
        Logger logger2 = this.logger;
        String str2 = "null (broker defaults)";
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : str2;
            objArr[1] = sSLProtocol;
            logger2.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12000", objArr);
        }
        String jSSEProvider = getJSSEProvider(str);
        if (jSSEProvider == null) {
            try {
                sSLContext = SSLContext.getInstance(sSLProtocol);
            } catch (NoSuchAlgorithmException e) {
                throw new MqttSecurityException(e);
            } catch (NoSuchProviderException e2) {
                throw new MqttSecurityException(e2);
            } catch (KeyManagementException e3) {
                throw new MqttSecurityException(e3);
            }
        } else {
            sSLContext = SSLContext.getInstance(sSLProtocol, jSSEProvider);
        }
        Logger logger3 = this.logger;
        if (logger3 != null) {
            Object[] objArr2 = new Object[2];
            if (str != null) {
                str2 = str;
            }
            objArr2[0] = str2;
            objArr2[1] = sSLContext.getProvider().getName();
            logger3.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12001", objArr2);
        }
        sSLContext.init(getKeyManagersForSSLContext(str), getTrustManagersForSSLContext(str), null);
        return sSLContext;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x007f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r0v6, types: [javax.net.ssl.TrustManagerFactory] */
    /* JADX WARN: Type inference failed for: r0v8, types: [javax.net.ssl.TrustManagerFactory] */
    /* JADX WARN: Type inference failed for: r0v9, types: [javax.net.ssl.TrustManagerFactory] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001a: APUT  (r9v5 java.lang.Object[]), (0 ??[int, short, byte, char]), (r10v4 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0037: APUT  (r10v3 java.lang.Object[]), (0 ??[int, short, byte, char]), (r11v14 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005d: APUT  (r11v13 java.lang.Object[]), (0 ??[int, short, byte, char]), (r12v1 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00a3: APUT  (r11v12 java.lang.Object[]), (0 ??[int, short, byte, char]), (r13v0 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b4: APUT  (r6v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r15v18 java.lang.String) */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0104 A[SYNTHETIC, Splitter:B:91:0x0104] */
    /* JADX WARNING: Unknown variable types count: 4 */
    private TrustManager[] getTrustManagersForSSLContext(String str) throws NoSuchAlgorithmException, NoSuchProviderException, MqttSecurityException {
        Throwable th;
        ?? r11;
        KeyStoreException e;
        CertificateException e2;
        FileNotFoundException e3;
        IOException e4;
        ?? r0;
        String str2;
        String str3;
        String str4;
        String trustStore = getTrustStore(str);
        Logger logger2 = this.logger;
        String str5 = "null";
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = trustStore != null ? trustStore : str5;
            logger2.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getTrustManagersForSSLContext", "12011", objArr);
        }
        char[] trustStorePassword = getTrustStorePassword(str);
        Logger logger3 = this.logger;
        if (logger3 != null) {
            Object[] objArr2 = new Object[2];
            if (str != null) {
                str4 = str;
            } else {
                str4 = "null (broker defaults)";
            }
            objArr2[0] = str4;
            objArr2[1] = trustStorePassword != null ? obfuscate(trustStorePassword) : str5;
            logger3.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getTrustManagersForSSLContext", "12012", objArr2);
        }
        String trustStoreType = getTrustStoreType(str);
        if (trustStoreType == null) {
            trustStoreType = KeyStore.getDefaultType();
        }
        Logger logger4 = this.logger;
        if (logger4 != null) {
            Object[] objArr3 = new Object[2];
            if (str != null) {
                str3 = str;
            } else {
                str3 = "null (broker defaults)";
            }
            objArr3[0] = str3;
            if (trustStoreType != null) {
                str5 = trustStoreType;
            }
            objArr3[1] = str5;
            logger4.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getTrustManagersForSSLContext", "12013", objArr3);
        }
        String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        String trustStoreProvider = getTrustStoreProvider(str);
        String trustManager = getTrustManager(str);
        if (trustManager != null) {
            defaultAlgorithm = trustManager;
        }
        TrustManager[] trustManagerArr = null;
        if (!(trustStore == null || trustStoreType == null || defaultAlgorithm == null)) {
            try {
                ?? instance = KeyStore.getInstance(trustStoreType);
                ?? fileInputStream = new FileInputStream(trustStore);
                try {
                    instance.load(fileInputStream, trustStorePassword);
                    if (trustStoreProvider != null) {
                        r0 = TrustManagerFactory.getInstance(defaultAlgorithm, trustStoreProvider);
                    } else {
                        r0 = TrustManagerFactory.getInstance(defaultAlgorithm);
                    }
                    Logger logger5 = this.logger;
                    if (logger5 != null) {
                        Object[] objArr4 = new Object[2];
                        if (str != null) {
                            str2 = str;
                        } else {
                            str2 = "null (broker defaults)";
                        }
                        objArr4[0] = str2;
                        objArr4[1] = defaultAlgorithm;
                        logger5.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getTrustManagersForSSLContext", "12017", objArr4);
                        Logger logger6 = this.logger;
                        Object[] objArr5 = new Object[2];
                        if (str == null) {
                            str = "null (broker defaults)";
                        }
                        objArr5[0] = str;
                        objArr5[1] = r0.getProvider().getName();
                        logger6.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getTrustManagersForSSLContext", "12016", objArr5);
                    }
                    r0.init(instance);
                    trustManagerArr = r0.getTrustManagers();
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        throw new MqttSecurityException(e5);
                    }
                } catch (KeyStoreException e6) {
                    e = e6;
                    throw new MqttSecurityException(e);
                } catch (CertificateException e7) {
                    e2 = e7;
                    throw new MqttSecurityException(e2);
                } catch (FileNotFoundException e8) {
                    e3 = e8;
                    throw new MqttSecurityException(e3);
                } catch (IOException e9) {
                    e4 = e9;
                    trustManagerArr = fileInputStream;
                    throw new MqttSecurityException(e4);
                } catch (Throwable th2) {
                    th = th2;
                    r11 = fileInputStream;
                    if (r11 != 0) {
                    }
                    throw th;
                }
            } catch (KeyStoreException e10) {
                e = e10;
                throw new MqttSecurityException(e);
            } catch (CertificateException e11) {
                e2 = e11;
                throw new MqttSecurityException(e2);
            } catch (FileNotFoundException e12) {
                e3 = e12;
                throw new MqttSecurityException(e3);
            } catch (IOException e13) {
                e4 = e13;
                throw new MqttSecurityException(e4);
            } catch (Throwable th3) {
                th = th3;
                r11 = trustManagerArr;
                if (r11 != 0) {
                    try {
                        r11.close();
                    } catch (IOException e14) {
                        throw new MqttSecurityException(e14);
                    }
                }
                throw th;
            }
        }
        return trustManagerArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x008d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [javax.net.ssl.KeyManagerFactory] */
    /* JADX WARN: Type inference failed for: r3v13, types: [javax.net.ssl.KeyManagerFactory] */
    /* JADX WARN: Type inference failed for: r3v14, types: [javax.net.ssl.KeyManagerFactory] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0029: APUT  (r12v5 java.lang.Object[]), (0 ??[int, short, byte, char]), (r13v4 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0046: APUT  (r13v3 java.lang.Object[]), (0 ??[int, short, byte, char]), (r14v3 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x006c: APUT  (r14v2 java.lang.Object[]), (0 ??[int, short, byte, char]), (r15v1 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b3: APUT  (r15v0 java.lang.Object[]), (0 ??[int, short, byte, char]), (r16v0 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00c4: APUT  (r9v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r0v23 java.lang.String) */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f A[SYNTHETIC, Splitter:B:98:0x011f] */
    /* JADX WARNING: Unknown variable types count: 4 */
    private KeyManager[] getKeyManagersForSSLContext(String str) throws NoSuchAlgorithmException, NoSuchProviderException, MqttSecurityException {
        ?? r3;
        Throwable th;
        KeyStoreException e;
        CertificateException e2;
        FileNotFoundException e3;
        IOException e4;
        UnrecoverableKeyException e5;
        ?? r32;
        String str2;
        String str3;
        String str4;
        String str5 = str;
        KeyManager[] keyManagerArr = null;
        String property = getProperty(str5, "com.ibm.ssl.keyStore", null);
        if (property == null) {
            property = getProperty(str5, "com.ibm.ssl.keyStore", "javax.net.ssl.keyStore");
        }
        Logger logger2 = this.logger;
        String str6 = "null";
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str5 != null ? str5 : "null (broker defaults)";
            objArr[1] = property != null ? property : str6;
            logger2.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getKeyManagersForSSLContext", "12004", objArr);
        }
        char[] keyStorePassword = getKeyStorePassword(str);
        Logger logger3 = this.logger;
        if (logger3 != null) {
            Object[] objArr2 = new Object[2];
            if (str5 != null) {
                str4 = str5;
            } else {
                str4 = "null (broker defaults)";
            }
            objArr2[0] = str4;
            objArr2[1] = keyStorePassword != null ? obfuscate(keyStorePassword) : str6;
            logger3.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getKeyManagersForSSLContext", "12005", objArr2);
        }
        String keyStoreType = getKeyStoreType(str);
        if (keyStoreType == null) {
            keyStoreType = KeyStore.getDefaultType();
        }
        Logger logger4 = this.logger;
        if (logger4 != null) {
            Object[] objArr3 = new Object[2];
            if (str5 != null) {
                str3 = str5;
            } else {
                str3 = "null (broker defaults)";
            }
            objArr3[0] = str3;
            if (keyStoreType != null) {
                str6 = keyStoreType;
            }
            objArr3[1] = str6;
            logger4.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getKeyManagersForSSLContext", "12006", objArr3);
        }
        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        String keyStoreProvider = getKeyStoreProvider(str);
        String keyManager = getKeyManager(str);
        if (keyManager != null) {
            defaultAlgorithm = keyManager;
        }
        if (!(property == null || keyStoreType == null || defaultAlgorithm == null)) {
            try {
                ?? instance = KeyStore.getInstance(keyStoreType);
                ?? fileInputStream = new FileInputStream(property);
                try {
                    instance.load(fileInputStream, keyStorePassword);
                    if (keyStoreProvider != null) {
                        r32 = KeyManagerFactory.getInstance(defaultAlgorithm, keyStoreProvider);
                    } else {
                        r32 = KeyManagerFactory.getInstance(defaultAlgorithm);
                    }
                    Logger logger5 = this.logger;
                    if (logger5 != null) {
                        Object[] objArr4 = new Object[2];
                        if (str5 != null) {
                            str2 = str5;
                        } else {
                            str2 = "null (broker defaults)";
                        }
                        objArr4[0] = str2;
                        objArr4[1] = defaultAlgorithm;
                        logger5.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getKeyManagersForSSLContext", "12010", objArr4);
                        Logger logger6 = this.logger;
                        Object[] objArr5 = new Object[2];
                        if (str5 == null) {
                            str5 = "null (broker defaults)";
                        }
                        objArr5[0] = str5;
                        objArr5[1] = r32.getProvider().getName();
                        logger6.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "getKeyManagersForSSLContext", "12009", objArr5);
                    }
                    r32.init(instance, keyStorePassword);
                    keyManagerArr = r32.getKeyManagers();
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        throw new MqttSecurityException(e6);
                    }
                } catch (KeyStoreException e7) {
                    e = e7;
                    throw new MqttSecurityException(e);
                } catch (CertificateException e8) {
                    e2 = e8;
                    throw new MqttSecurityException(e2);
                } catch (FileNotFoundException e9) {
                    e3 = e9;
                    throw new MqttSecurityException(e3);
                } catch (IOException e10) {
                    e4 = e10;
                    throw new MqttSecurityException(e4);
                } catch (UnrecoverableKeyException e11) {
                    e5 = e11;
                    keyManagerArr = fileInputStream;
                    throw new MqttSecurityException(e5);
                } catch (Throwable th2) {
                    th = th2;
                    r3 = fileInputStream;
                    if (r3 != 0) {
                    }
                    throw th;
                }
            } catch (KeyStoreException e12) {
                e = e12;
                throw new MqttSecurityException(e);
            } catch (CertificateException e13) {
                e2 = e13;
                throw new MqttSecurityException(e2);
            } catch (FileNotFoundException e14) {
                e3 = e14;
                throw new MqttSecurityException(e3);
            } catch (IOException e15) {
                e4 = e15;
                throw new MqttSecurityException(e4);
            } catch (UnrecoverableKeyException e16) {
                e5 = e16;
                throw new MqttSecurityException(e5);
            } catch (Throwable th3) {
                th = th3;
                r3 = keyManagerArr;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e17) {
                        throw new MqttSecurityException(e17);
                    }
                }
                throw th;
            }
        }
        return keyManagerArr;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0012: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r4v0 java.lang.String) */
    public SSLSocketFactory createSocketFactory(String str) throws MqttSecurityException {
        SSLContext sSLContext = getSSLContext(str);
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = getEnabledCipherSuites(str) != null ? getProperty(str, "com.ibm.ssl.enabledCipherSuites", null) : "null (using platform-enabled cipher suites)";
            logger2.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "createSocketFactory", "12020", objArr);
        }
        return sSLContext.getSocketFactory();
    }
}
