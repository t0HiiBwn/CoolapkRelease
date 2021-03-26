package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.rr.Request;
import java.net.HttpURLConnection;
import java.util.Map;

public class PlainRequest extends AbstractRequest {
    public PlainRequest(String str, Request.Method method, byte[] bArr) {
        super(str, method, bArr);
    }

    public PlainRequest(String str, Map<String, String> map, Request.Method method) {
        super(str, map, method);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Response initResponse(HttpURLConnection httpURLConnection) {
        return new PlainResponse(httpURLConnection);
    }
}
