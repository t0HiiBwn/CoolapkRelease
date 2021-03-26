package mtopsdk.network;

import android.content.Context;
import com.taobao.tao.remotebusiness.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.a;
import mtopsdk.network.domain.NetworkStats;
import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.Response;
import mtopsdk.network.domain.ResponseBody;
import org.json.JSONObject;

public abstract class AbstractCallImpl implements Call, Ext {
    private static final String TAG = "mtopsdk.AbstractCallImpl";
    protected static AtomicBoolean flag = new AtomicBoolean(false);
    public static volatile boolean isDebugApk;
    public static volatile boolean isOpenMock;
    protected volatile boolean canceled;
    protected Future future;
    protected Context mContext;
    protected Request mRequest;
    protected String seqNo;

    protected AbstractCallImpl(Request request, Context context) {
        this.mRequest = request;
        if (request != null) {
            this.seqNo = request.seqNo;
        }
        this.mContext = context;
        if (context != null && flag.compareAndSet(false, true)) {
            isDebugApk = MtopUtils.isApkDebug(this.mContext);
            isOpenMock = MtopUtils.isAppOpenMock(this.mContext);
            String str = this.seqNo;
            TBSdkLog.i("mtopsdk.AbstractCallImpl", str, "isDebugApk=" + isDebugApk + ",isOpenMock=" + isOpenMock);
        }
    }

    @Override // mtopsdk.network.Call
    public Request request() {
        return this.mRequest;
    }

    @Override // mtopsdk.network.Call
    public void cancel() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.AbstractCallImpl", "try to cancel call.");
        }
        this.canceled = true;
        Future future2 = this.future;
        if (future2 != null) {
            future2.cancel(true);
        }
    }

    protected a getMockResponse(String str) {
        a aVar;
        Exception e;
        if (str == null) {
            TBSdkLog.e("mtopsdk.AbstractCallImpl", this.seqNo, "[getMockResponse] apiName is null!");
            return null;
        } else if (this.mContext == null) {
            TBSdkLog.e("mtopsdk.AbstractCallImpl", this.seqNo, "[getMockResponse] mContext is null!");
            return null;
        } else {
            try {
                byte[] readFile = MtopUtils.readFile(this.mContext.getFilesDir().getCanonicalPath() + "/mock/deMock/" + str + ".json");
                if (readFile == null) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(readFile));
                    aVar = new a();
                    try {
                        aVar.a = str;
                        String optString = jSONObject.optString("mock_body");
                        if (optString != null) {
                            aVar.d = optString.getBytes("utf-8");
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("response_header");
                        if (optJSONObject != null) {
                            aVar.c = new HashMap();
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = optJSONObject.getString(next);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(string);
                                aVar.c.put(next, arrayList);
                            }
                        }
                        String optString2 = jSONObject.optString("response_status");
                        if (optString2 != null) {
                            aVar.b = Integer.parseInt(optString2);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        TBSdkLog.e("mtopsdk.AbstractCallImpl", this.seqNo, "[getMockData] get MockData error.api=" + str, e);
                        return aVar;
                    }
                } catch (Exception e3) {
                    aVar = null;
                    e = e3;
                    TBSdkLog.e("mtopsdk.AbstractCallImpl", this.seqNo, "[getMockData] get MockData error.api=" + str, e);
                    return aVar;
                }
                return aVar;
            } catch (IOException e4) {
                TBSdkLog.e("mtopsdk.AbstractCallImpl", this.seqNo, "[getMockResponse] parse ExternalFilesDir/mock/deMock/" + str + ".json filePath error.", e4);
                return null;
            }
        }
    }

    protected Response buildResponse(Request request, int i, String str, final Map<String, List<String>> map, final byte[] bArr, NetworkStats networkStats) {
        return new Response.Builder().request(request).code(i).message(str).headers(map).body(new ResponseBody() {
            /* class mtopsdk.network.AbstractCallImpl.AnonymousClass1 */

            @Override // mtopsdk.network.domain.ResponseBody
            public InputStream byteStream() {
                return null;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public String contentType() {
                return b.a(map, "Content-Type");
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public long contentLength() throws IOException {
                byte[] bArr = bArr;
                if (bArr != null) {
                    return (long) bArr.length;
                }
                return 0;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public byte[] getBytes() throws IOException {
                return bArr;
            }
        }).stat(networkStats).build();
    }
}
