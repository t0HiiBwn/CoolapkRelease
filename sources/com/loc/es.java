package com.loc;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* compiled from: Table */
public class es {
    public static final ThreadLocal<Charset> a = new ThreadLocal<Charset>() {
        /* class com.loc.es.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return Charset.forName("UTF-8");
        }
    };
    private static final ThreadLocal<CharsetDecoder> b = new ThreadLocal<CharsetDecoder>() {
        /* class com.loc.es.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return Charset.forName("UTF-8").newDecoder();
        }
    };
    private static final ThreadLocal<CharBuffer> c = new ThreadLocal<>();
}
