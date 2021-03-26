package com.xiaomi.push;

import java.net.UnknownHostException;
import java.util.Objects;

final class gs {

    static class a {
        ex a;

        /* renamed from: a  reason: collision with other field name */
        String f522a;

        a() {
        }
    }

    static a a(Exception exc) {
        m376a(exc);
        boolean z = exc instanceof ft;
        Exception exc2 = exc;
        if (z) {
            ft ftVar = (ft) exc;
            exc2 = exc;
            if (ftVar.a() != null) {
                exc2 = ftVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = fk.a(exc2);
        if (a2 != 0) {
            aVar.a = ex.a(ex.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = ex.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == ex.GSLB_TCP_ERR_OTHER) {
            aVar.f522a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m376a(Exception exc) {
        Objects.requireNonNull(exc);
    }

    static a b(Exception exc) {
        ex exVar;
        Throwable cause;
        m376a(exc);
        boolean z = exc instanceof ft;
        Exception exc2 = exc;
        if (z) {
            ft ftVar = (ft) exc;
            exc2 = exc;
            if (ftVar.a() != null) {
                exc2 = ftVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fk.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            aVar.a = ex.a(ex.CONN_SUCCESS.a() + a2);
            if (aVar.a == ex.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                exVar = ex.CONN_BOSH_UNKNOWNHOST;
            }
            if (aVar.a == ex.CONN_TCP_ERR_OTHER || aVar.a == ex.CONN_XMPP_ERR || aVar.a == ex.CONN_BOSH_ERR) {
                aVar.f522a = str;
            }
            return aVar;
        }
        exVar = ex.CONN_XMPP_ERR;
        aVar.a = exVar;
        aVar.f522a = str;
        return aVar;
    }

    static a c(Exception exc) {
        ex exVar;
        m376a(exc);
        boolean z = exc instanceof ft;
        Exception exc2 = exc;
        if (z) {
            ft ftVar = (ft) exc;
            exc2 = exc;
            if (ftVar.a() != null) {
                exc2 = ftVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fk.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            exVar = ex.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            exVar = ex.BIND_TCP_ERR;
        } else if (a2 != 499) {
            exVar = a2 != 109 ? a2 != 110 ? ex.BIND_XMPP_ERR : ex.BIND_TCP_BROKEN_PIPE : ex.BIND_TCP_CONNRESET;
        } else {
            aVar.a = ex.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                exVar = ex.BIND_BOSH_ITEM_NOT_FOUND;
            }
            if (aVar.a == ex.BIND_TCP_ERR || aVar.a == ex.BIND_XMPP_ERR || aVar.a == ex.BIND_BOSH_ERR) {
                aVar.f522a = str;
            }
            return aVar;
        }
        aVar.a = exVar;
        aVar.f522a = str;
        return aVar;
    }

    static a d(Exception exc) {
        ex exVar;
        m376a(exc);
        boolean z = exc instanceof ft;
        Exception exc2 = exc;
        if (z) {
            ft ftVar = (ft) exc;
            exc2 = exc;
            if (ftVar.a() != null) {
                exc2 = ftVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fk.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            exVar = ex.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            exVar = ex.CHANNEL_TCP_ERR;
        } else if (a2 != 499) {
            exVar = a2 != 109 ? a2 != 110 ? ex.CHANNEL_XMPPEXCEPTION : ex.CHANNEL_TCP_BROKEN_PIPE : ex.CHANNEL_TCP_CONNRESET;
        } else {
            aVar.a = ex.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                exVar = ex.CHANNEL_BOSH_ITEMNOTFIND;
            }
            if (aVar.a == ex.CHANNEL_TCP_ERR || aVar.a == ex.CHANNEL_XMPPEXCEPTION || aVar.a == ex.CHANNEL_BOSH_EXCEPTION) {
                aVar.f522a = str;
            }
            return aVar;
        }
        aVar.a = exVar;
        aVar.f522a = str;
        return aVar;
    }
}
