package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

public class ExceptionCode {
    public static final int CANCEL = 1104;
    private static final String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 110205;
    public static final int CONNECTION_REFUSED = 110209;
    public static final int CONNECTION_RESET = 110204;
    public static final int CONNECT_FAILED = 110206;
    public static final int CRASH_EXCEPTION = 1103;
    public static final int INTERRUPT_CONNECT_CLOSE = 110214;
    public static final int INTERRUPT_EXCEPTION = 110213;
    public static final int NETWORK_IO_EXCEPTION = 1102;
    public static final int NETWORK_UNREACHABLE = 110208;
    private static final String READ = "read";
    public static final int READ_ERROR = 110203;
    public static final int ROUTE_FAILED = 110207;
    public static final int SOCKET_CLOSE = 110215;
    public static final int SOCKET_CONNECT_TIMEOUT = 110221;
    public static final int SOCKET_READ_TIMEOUT = 110223;
    public static final int SOCKET_TIMEOUT = 110200;
    public static final int SOCKET_WRITE_TIMEOUT = 110225;
    public static final int SSL_HANDSHAKE_EXCEPTION = 110211;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 110212;
    public static final int SSL_PROTOCOL_EXCEPTION = 110210;
    public static final int UNABLE_TO_RESOLVE_HOST = 110202;
    public static final int UNEXPECTED_EOF = 110201;
    private static final String WRITE = "write";

    private static String checkExceptionContainsKey(Exception exc, String... strArr) {
        String checkStrContainsKey = checkStrContainsKey(StringUtils.toLowerCase(exc.getMessage()), strArr);
        if (!TextUtils.isEmpty(checkStrContainsKey)) {
            return checkStrContainsKey;
        }
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            checkStrContainsKey = checkStrContainsKey(StringUtils.toLowerCase(stackTraceElement.toString()), strArr);
            if (!TextUtils.isEmpty(checkStrContainsKey)) {
                return checkStrContainsKey;
            }
        }
        return checkStrContainsKey;
    }

    private static String checkStrContainsKey(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static int getErrorCodeFromException(Exception exc) {
        if (exc == null) {
            return 1102;
        }
        if (!(exc instanceof IOException)) {
            return 1103;
        }
        String message = exc.getMessage();
        if (message == null) {
            return 1102;
        }
        String lowerCase = StringUtils.toLowerCase(message);
        int errorCodeFromMsg = getErrorCodeFromMsg(lowerCase);
        if (errorCodeFromMsg != 1102) {
            return errorCodeFromMsg;
        }
        if (exc instanceof SocketTimeoutException) {
            return getErrorCodeSocketTimeout(exc);
        }
        if (exc instanceof ConnectException) {
            return 110206;
        }
        if (exc instanceof NoRouteToHostException) {
            return 110207;
        }
        if (exc instanceof SSLProtocolException) {
            return 110210;
        }
        if (exc instanceof SSLHandshakeException) {
            return 110211;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 110212;
        }
        if (exc instanceof UnknownHostException) {
            return 110202;
        }
        return exc instanceof InterruptedIOException ? lowerCase.contains("connection has been shut down") ? 110214 : 110213 : errorCodeFromMsg;
    }

    private static int getErrorCodeFromMsg(String str) {
        if (str.contains("unexpected end of stream")) {
            return 110201;
        }
        if (str.contains("unable to resolve host")) {
            return 110202;
        }
        if (str.contains("read error")) {
            return 110203;
        }
        if (str.contains("connection reset")) {
            return 110204;
        }
        if (str.contains("software caused connection abort")) {
            return 110205;
        }
        if (str.contains("failed to connect to")) {
            return 110206;
        }
        if (str.contains("connection refused")) {
            return 110209;
        }
        if (str.contains("connection timed out")) {
            return 110221;
        }
        if (str.contains("no route to host")) {
            return 110207;
        }
        if (str.contains("network is unreachable")) {
            return 110208;
        }
        return str.contains("socket closed") ? 110215 : 1102;
    }

    private static int getErrorCodeSocketTimeout(Exception exc) {
        String checkExceptionContainsKey = checkExceptionContainsKey(exc, "connect", "read", "write");
        checkExceptionContainsKey.hashCode();
        char c = 65535;
        switch (checkExceptionContainsKey.hashCode()) {
            case 3496342:
                if (checkExceptionContainsKey.equals("read")) {
                    c = 0;
                    break;
                }
                break;
            case 113399775:
                if (checkExceptionContainsKey.equals("write")) {
                    c = 1;
                    break;
                }
                break;
            case 951351530:
                if (checkExceptionContainsKey.equals("connect")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 110223;
            case 1:
                return 110225;
            case 2:
                return 110221;
            default:
                return 110200;
        }
    }
}
