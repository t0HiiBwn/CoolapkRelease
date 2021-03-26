package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.rr.Request;
import java.net.HttpURLConnection;

public class S2SSRequest extends AbstractRequest {
    public S2SSRequest(String str, byte[] bArr) {
        super(str, Request.Method.POST, bArr);
    }

    @Override // com.qq.e.comm.net.rr.AbstractRequest, com.qq.e.comm.net.rr.Request
    public byte[] getPostData() throws Exception {
        return a.a(super.getPostData());
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Response initResponse(HttpURLConnection httpURLConnection) {
        return new S2SSResponse(httpURLConnection);
    }
}
