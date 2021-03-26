package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.zip.CheckedInputStream;
import okhttp3.Headers;
import okhttp3.Response;

public abstract class AbstractResponseParser<T extends OSSResult> implements ResponseParser {
    public boolean needCloseResponse() {
        return true;
    }

    abstract T parseData(ResponseMessage responseMessage, T t) throws Exception;

    public static void safeCloseResponse(ResponseMessage responseMessage) {
        try {
            responseMessage.close();
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.ResponseParser
    public T parse(ResponseMessage responseMessage) throws IOException {
        try {
            T t = (T) ((OSSResult) ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance());
            if (t != null) {
                t.setRequestId((String) responseMessage.getHeaders().get("x-oss-request-id"));
                t.setStatusCode(responseMessage.getStatusCode());
                t.setResponseHeader(parseResponseHeader(responseMessage.getResponse()));
                setCRC(t, responseMessage);
                t = parseData(responseMessage, t);
            }
            if (needCloseResponse()) {
                safeCloseResponse(responseMessage);
            }
            return t;
        } catch (Exception e) {
            IOException iOException = new IOException(e.getMessage(), e);
            e.printStackTrace();
            OSSLog.logThrowable2Local(e);
            throw iOException;
        } catch (Throwable th) {
            if (needCloseResponse()) {
                safeCloseResponse(responseMessage);
            }
            throw th;
        }
    }

    private CaseInsensitiveHashMap<String, String> parseResponseHeader(Response response) {
        CaseInsensitiveHashMap<String, String> caseInsensitiveHashMap = new CaseInsensitiveHashMap<>();
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            caseInsensitiveHashMap.put(headers.name(i), headers.value(i));
        }
        return caseInsensitiveHashMap;
    }

    public <Result extends OSSResult> void setCRC(Result result, ResponseMessage responseMessage) {
        InputStream content = responseMessage.getRequest().getContent();
        if (content != null && (content instanceof CheckedInputStream)) {
            result.setClientCRC(Long.valueOf(((CheckedInputStream) content).getChecksum().getValue()));
        }
        String str = (String) responseMessage.getHeaders().get("x-oss-hash-crc64ecma");
        if (str != null) {
            result.setServerCRC(Long.valueOf(new BigInteger(str).longValue()));
        }
    }
}
