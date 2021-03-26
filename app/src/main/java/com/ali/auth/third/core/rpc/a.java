package com.ali.auth.third.core.rpc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class a {
    protected static ByteArrayOutputStream a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    protected static String a(String str) {
        return "utf-8";
    }

    protected static void a(int i) {
        if (i != 200) {
            throw new RuntimeException("http request exception, response code: " + i);
        }
    }
}
