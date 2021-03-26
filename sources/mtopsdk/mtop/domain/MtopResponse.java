package mtopsdk.mtop.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopStatistics;
import org.json.JSONArray;
import org.json.JSONObject;

public class MtopResponse implements Serializable, IMTOPDataObject {
    private static final String SHARP = "::";
    private static final String TAG = "mtopsdk.MtopResponse";
    private static final long serialVersionUID = 1566423746968673499L;
    private String api;
    private volatile boolean bParsed = false;
    private byte[] bytedata;
    @Deprecated
    private byte[] data;
    private JSONObject dataJsonObject;
    private Map<String, List<String>> headerFields;
    public String mappingCode;
    public String mappingCodeSuffix;
    private MtopStatistics mtopStat;
    private int responseCode;
    private ResponseSource responseSource = ResponseSource.NETWORK_REQUEST;
    @Deprecated
    private String[] ret;
    private String retCode;
    private String retMsg;
    private String v;

    public enum ResponseSource {
        FRESH_CACHE,
        EXPIRED_CACHE,
        NETWORK_REQUEST
    }

    public MtopResponse() {
    }

    public MtopResponse(String str, String str2) {
        this.retCode = str;
        this.retMsg = str2;
    }

    public MtopResponse(String str, String str2, String str3, String str4) {
        this.api = str;
        this.v = str2;
        this.retCode = str3;
        this.retMsg = str4;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public String getMappingCode() {
        return this.mappingCode;
    }

    public String getRetMsg() {
        if (this.retMsg == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.retMsg;
    }

    public void setRetMsg(String str) {
        this.retMsg = str;
    }

    public String getApi() {
        if (this.api == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.api;
    }

    public void setApi(String str) {
        this.api = str;
    }

    public String getV() {
        if (this.v == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.v;
    }

    public void setV(String str) {
        this.v = str;
    }

    @Deprecated
    public String[] getRet() {
        if (this.ret == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.ret;
    }

    @Deprecated
    public void setRet(String[] strArr) {
        this.ret = strArr;
    }

    @Deprecated
    public byte[] getData() {
        return this.data;
    }

    @Deprecated
    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public JSONObject getDataJsonObject() {
        if (this.dataJsonObject == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.dataJsonObject;
    }

    public void setDataJsonObject(JSONObject jSONObject) {
        this.dataJsonObject = jSONObject;
    }

    public byte[] getBytedata() {
        return this.bytedata;
    }

    public void setBytedata(byte[] bArr) {
        this.bytedata = bArr;
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.headerFields;
    }

    public void setHeaderFields(Map<String, List<String>> map) {
        this.headerFields = map;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public MtopStatistics getMtopStat() {
        return this.mtopStat;
    }

    public void setMtopStat(MtopStatistics mtopStatistics) {
        this.mtopStat = mtopStatistics;
    }

    public void parseJsonByte() {
        String[] split;
        if (!this.bParsed) {
            synchronized (this) {
                if (!this.bParsed) {
                    byte[] bArr = this.bytedata;
                    if (bArr == null || bArr.length == 0) {
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                            TBSdkLog.e("mtopsdk.MtopResponse", "[parseJsonByte]MtopResponse bytedata is blank,api=" + this.api + ",v=" + this.v);
                        }
                        if (StringUtils.isBlank(this.retCode)) {
                            this.retCode = "ANDROID_SYS_JSONDATA_BLANK";
                        }
                        if (StringUtils.isBlank(this.retMsg)) {
                            this.retMsg = "返回JSONDATA为空";
                        }
                        this.bParsed = true;
                        return;
                    }
                    try {
                        String str = new String(this.bytedata);
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                            TBSdkLog.d("mtopsdk.MtopResponse", "[parseJsonByte]MtopResponse bytedata : " + str);
                        }
                        JSONObject jSONObject = new JSONObject(str);
                        if (this.api == null) {
                            this.api = jSONObject.getString("api");
                        }
                        if (this.v == null) {
                            this.v = jSONObject.getString("v");
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("ret");
                        int length = jSONArray.length();
                        this.ret = new String[length];
                        for (int i = 0; i < length; i++) {
                            this.ret[i] = jSONArray.getString(i);
                        }
                        if (length > 0) {
                            String str2 = this.ret[0];
                            if (StringUtils.isNotBlank(str2) && (split = str2.split("::")) != null && split.length > 1) {
                                if (StringUtils.isBlank(this.retCode)) {
                                    this.retCode = split[0];
                                }
                                if (StringUtils.isBlank(this.retMsg)) {
                                    this.retMsg = split[1];
                                }
                            }
                        }
                        this.dataJsonObject = jSONObject.optJSONObject("data");
                    } catch (Throwable th) {
                        this.bParsed = true;
                        throw th;
                    }
                    this.bParsed = true;
                }
            }
        }
    }

    public void setSource(ResponseSource responseSource2) {
        this.responseSource = responseSource2;
    }

    public ResponseSource getSource() {
        return this.responseSource;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        try {
            sb.append("MtopResponse[ api=");
            sb.append(this.api);
            sb.append(",v=");
            sb.append(this.v);
            sb.append(",retCode=");
            sb.append(this.retCode);
            sb.append(",retMsg=");
            sb.append(this.retMsg);
            sb.append(",mappingCode=");
            sb.append(this.mappingCode);
            sb.append(",mappingCodeSuffix=");
            sb.append(this.mappingCodeSuffix);
            sb.append(",ret=");
            sb.append(Arrays.toString(this.ret));
            sb.append(",data=");
            sb.append(this.dataJsonObject);
            sb.append(",responseCode=");
            sb.append(this.responseCode);
            sb.append(",headerFields=");
            sb.append(this.headerFields);
            sb.append(",bytedata=");
            sb.append(this.bytedata == null ? null : new String(this.bytedata));
            sb.append("]");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return super.toString();
        }
    }

    public String getResponseLog() {
        StringBuilder sb = new StringBuilder(128);
        try {
            sb.append("MtopResponse[ api=");
            sb.append(this.api);
            sb.append(",v=");
            sb.append(this.v);
            sb.append(",retCode=");
            sb.append(this.retCode);
            sb.append(",retMsg=");
            sb.append(this.retMsg);
            sb.append(",mappingCode=");
            sb.append(this.mappingCode);
            sb.append(",mappingCodeSuffix=");
            sb.append(this.mappingCodeSuffix);
            sb.append(",ret=");
            sb.append(Arrays.toString(this.ret));
            sb.append(",responseCode=");
            sb.append(this.responseCode);
            sb.append(",headerFields=");
            sb.append(this.headerFields);
            sb.append("]");
            return sb.toString();
        } catch (Throwable unused) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e("mtopsdk.MtopResponse", "[getResponseLog]MtopResponse get log error, api=" + this.api + ",v=" + this.v);
            }
            return super.toString();
        }
    }

    public String getFullKey() {
        if (StringUtils.isBlank(this.api) || StringUtils.isBlank(this.v)) {
            return null;
        }
        return StringUtils.concatStr2LowerCase(this.api, this.v);
    }

    public boolean isApiSuccess() {
        return ErrorConstant.isSuccess(getRetCode()) && getBytedata() != null;
    }

    public boolean isExpiredRequest() {
        return ErrorConstant.isExpiredRequest(getRetCode());
    }

    @Deprecated
    public boolean isSystemError() {
        return ErrorConstant.isSystemError(getRetCode());
    }

    public boolean isNetworkError() {
        return ErrorConstant.isNetworkError(getRetCode());
    }

    public boolean isNoNetwork() {
        return ErrorConstant.isNoNetwork(getRetCode());
    }

    public boolean isSessionInvalid() {
        return ErrorConstant.isSessionInvalid(getRetCode());
    }

    @Deprecated
    public boolean isIllegelSign() {
        return ErrorConstant.isIllegelSign(getRetCode());
    }

    public boolean is41XResult() {
        return ErrorConstant.is41XResult(getRetCode());
    }

    public boolean isApiLockedResult() {
        return 420 == this.responseCode || ErrorConstant.isApiLockedResult(getRetCode());
    }

    public boolean isApiLockedAndRequestQueued() {
        return 420 == this.responseCode && "FAIL_SYS_REQUEST_QUEUED".equalsIgnoreCase(getRetCode());
    }

    public boolean isMtopSdkError() {
        return ErrorConstant.isMtopSdkError(getRetCode());
    }

    public boolean isMtopServerError() {
        return ErrorConstant.isMtopServerError(getRetCode());
    }
}
