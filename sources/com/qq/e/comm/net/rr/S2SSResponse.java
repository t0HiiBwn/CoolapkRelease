package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.rr.a;
import java.io.IOException;
import java.net.HttpURLConnection;

public class S2SSResponse extends AbstractResponse {
    public S2SSResponse(HttpURLConnection httpURLConnection) {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.net.rr.AbstractResponse, com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        try {
            return a.b(super.getBytesContent());
        } catch (a.b e) {
            e.printStackTrace();
            return null;
        }
    }
}
