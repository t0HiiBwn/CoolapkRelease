package com.xiaomi.push;

import java.net.UnknownHostException;
import java.util.Objects;

final class fy {

    static class a {
        eb a;
        String b;

        a() {
        }
    }

    static a a(Exception exc) {
        e(exc);
        boolean z = exc instanceof ey;
        Exception exc2 = exc;
        if (z) {
            ey eyVar = (ey) exc;
            exc2 = exc;
            if (eyVar.a() != null) {
                exc2 = eyVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = eo.a(exc2);
        if (a2 != 0) {
            aVar.a = eb.a(eb.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = eb.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == eb.GSLB_TCP_ERR_OTHER) {
            aVar.b = str;
        }
        return aVar;
    }

    static a b(Exception exc) {
        eb ebVar;
        Throwable cause;
        e(exc);
        boolean z = exc instanceof ey;
        Exception exc2 = exc;
        if (z) {
            ey eyVar = (ey) exc;
            exc2 = exc;
            if (eyVar.a() != null) {
                exc2 = eyVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = eo.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            aVar.a = eb.a(eb.CONN_SUCCESS.a() + a2);
            if (aVar.a == eb.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                ebVar = eb.CONN_BOSH_UNKNOWNHOST;
            }
            if (aVar.a == eb.CONN_TCP_ERR_OTHER || aVar.a == eb.CONN_XMPP_ERR || aVar.a == eb.CONN_BOSH_ERR) {
                aVar.b = str;
            }
            return aVar;
        }
        ebVar = eb.CONN_XMPP_ERR;
        aVar.a = ebVar;
        aVar.b = str;
        return aVar;
    }

    static a c(Exception exc) {
        eb ebVar;
        e(exc);
        boolean z = exc instanceof ey;
        Exception exc2 = exc;
        if (z) {
            ey eyVar = (ey) exc;
            exc2 = exc;
            if (eyVar.a() != null) {
                exc2 = eyVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = eo.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            ebVar = eb.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            ebVar = eb.BIND_TCP_ERR;
        } else if (a2 != 499) {
            ebVar = a2 != 109 ? a2 != 110 ? eb.BIND_XMPP_ERR : eb.BIND_TCP_BROKEN_PIPE : eb.BIND_TCP_CONNRESET;
        } else {
            aVar.a = eb.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ebVar = eb.BIND_BOSH_ITEM_NOT_FOUND;
            }
            if (aVar.a == eb.BIND_TCP_ERR || aVar.a == eb.BIND_XMPP_ERR || aVar.a == eb.BIND_BOSH_ERR) {
                aVar.b = str;
            }
            return aVar;
        }
        aVar.a = ebVar;
        aVar.b = str;
        return aVar;
    }

    static a d(Exception exc) {
        eb ebVar;
        e(exc);
        boolean z = exc instanceof ey;
        Exception exc2 = exc;
        if (z) {
            ey eyVar = (ey) exc;
            exc2 = exc;
            if (eyVar.a() != null) {
                exc2 = eyVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = eo.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            ebVar = eb.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            ebVar = eb.CHANNEL_TCP_ERR;
        } else if (a2 != 499) {
            ebVar = a2 != 109 ? a2 != 110 ? eb.CHANNEL_XMPPEXCEPTION : eb.CHANNEL_TCP_BROKEN_PIPE : eb.CHANNEL_TCP_CONNRESET;
        } else {
            aVar.a = eb.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ebVar = eb.CHANNEL_BOSH_ITEMNOTFIND;
            }
            if (aVar.a == eb.CHANNEL_TCP_ERR || aVar.a == eb.CHANNEL_XMPPEXCEPTION || aVar.a == eb.CHANNEL_BOSH_EXCEPTION) {
                aVar.b = str;
            }
            return aVar;
        }
        aVar.a = ebVar;
        aVar.b = str;
        return aVar;
    }

    private static void e(Exception exc) {
        Objects.requireNonNull(exc);
    }
}
