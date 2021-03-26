package com.bytedance.sdk.openadsdk.i.e;

import com.bytedance.sdk.openadsdk.i.i;
import java.io.InputStream;
import java.util.List;

/* compiled from: AbsResponseWrapper */
public abstract class a {
    List<i.b> a;
    f b;

    public abstract int a();

    protected String a(int i) {
        switch (i) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case 300:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case 305:
                        return "Use Proxy";
                    default:
                        switch (i) {
                            case 400:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case 402:
                                return "Payment Required";
                            case 403:
                                return "Forbidden";
                            case 404:
                                return "Not Found";
                            case 405:
                                return "Method Not Allowed";
                            case 406:
                                return "Not Acceptable";
                            case 407:
                                return "Proxy Authentication Required";
                            case 408:
                                return "Request Time-Out";
                            case 409:
                                return "Conflict";
                            case 410:
                                return "Gone";
                            case 411:
                                return "Length Required";
                            case 412:
                                return "Precondition Failed";
                            case 413:
                                return "Request Entity Too Large";
                            case 414:
                                return "Request-URI Too Large";
                            case 415:
                                return "Unsupported Media Type";
                            default:
                                switch (i) {
                                    case 500:
                                        return "Internal Server Error";
                                    case 501:
                                        return "Not Implemented";
                                    case 502:
                                        return "Bad Gateway";
                                    case 503:
                                        return "Service Unavailable";
                                    case 504:
                                        return "Gateway Timeout";
                                    case 505:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String a(String str, String str2);

    public abstract boolean b();

    public abstract List<i.b> c();

    public abstract InputStream d();

    public abstract String e();

    public abstract String f();

    public f g() {
        return this.b;
    }

    protected i.b a(String str) {
        List<i.b> list;
        if (!(str == null || (list = this.a) == null || list.size() <= 0)) {
            for (i.b bVar : this.a) {
                if (str.equals(bVar.a)) {
                    return bVar;
                }
            }
        }
        return null;
    }
}
