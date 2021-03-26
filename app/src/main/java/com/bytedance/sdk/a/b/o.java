package com.bytedance.sdk.a.b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* compiled from: Dns */
public interface o {
    public static final o a = new o() {
        /* class com.bytedance.sdk.a.b.o.AnonymousClass1 */

        @Override // com.bytedance.sdk.a.b.o
        public List<InetAddress> a(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            } else {
                throw new UnknownHostException("hostname == null");
            }
        }
    };

    List<InetAddress> a(String str) throws UnknownHostException;
}
