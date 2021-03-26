package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.BucketLifecycleRule;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RequestMessage extends HttpMessage {
    private String bucketName;
    private boolean checkCRC64;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;
    private boolean httpDnsEnable = false;
    private String ipWithHeader;
    private boolean isAuthorizationRequired = true;
    private boolean isInCustomCnameExcludeList = false;
    private HttpMethod method;
    private String objectKey;
    private Map<String, String> parameters = new LinkedHashMap();
    private URI service;
    private byte[] uploadData;
    private String uploadFilePath;
    private Uri uploadUri;

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ InputStream getContent() {
        return super.getContent();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ long getContentLength() {
        return super.getContentLength();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ String getStringBody() {
        return super.getStringBody();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setContent(InputStream inputStream) {
        super.setContent(inputStream);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setContentLength(long j) {
        super.setContentLength(j);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setHeaders(Map map) {
        super.setHeaders(map);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setStringBody(String str) {
        super.setStringBody(str);
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public OSSCredentialProvider getCredentialProvider() {
        return this.credentialProvider;
    }

    public void setCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public URI getService() {
        return this.service;
    }

    public void setService(URI uri) {
        this.service = uri;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public void setEndpoint(URI uri) {
        this.endpoint = uri;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public void setParameters(Map<String, String> map) {
        this.parameters = map;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public void setUploadFilePath(String str) {
        this.uploadFilePath = str;
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public void setUploadData(byte[] bArr) {
        this.uploadData = bArr;
    }

    public Uri getUploadUri() {
        return this.uploadUri;
    }

    public void setUploadUri(Uri uri) {
        this.uploadUri = uri;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public void setIsAuthorizationRequired(boolean z) {
        this.isAuthorizationRequired = z;
    }

    public boolean isInCustomCnameExcludeList() {
        return this.isInCustomCnameExcludeList;
    }

    public void setIsInCustomCnameExcludeList(boolean z) {
        this.isInCustomCnameExcludeList = z;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    public String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public void setIpWithHeader(String str) {
        this.ipWithHeader = str;
    }

    public void createBucketRequestBodyMarshall(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null) {
            stringBuffer.append("<CreateBucketConfiguration>");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
            }
            stringBuffer.append("</CreateBucketConfiguration>");
            byte[] bytes = stringBuffer.toString().getBytes("utf-8");
            setContent(new ByteArrayInputStream(bytes));
            setContentLength((long) bytes.length);
        }
    }

    public void putBucketRefererRequestBodyMarshall(ArrayList<String> arrayList, boolean z) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<RefererConfiguration>");
        StringBuilder sb = new StringBuilder();
        sb.append("<AllowEmptyReferer>");
        sb.append(z ? "true" : "false");
        sb.append("</AllowEmptyReferer>");
        stringBuffer.append(sb.toString());
        if (arrayList != null && arrayList.size() > 0) {
            stringBuffer.append("<RefererList>");
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                stringBuffer.append("<Referer>" + it2.next() + "</Referer>");
            }
            stringBuffer.append("</RefererList>");
        }
        stringBuffer.append("</RefererConfiguration>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = (long) bytes.length;
        setContent(new ByteArrayInputStream(bytes));
        setContentLength(length);
    }

    public void putBucketLoggingRequestBodyMarshall(String str, String str2) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<BucketLoggingStatus>");
        if (str != null) {
            stringBuffer.append("<LoggingEnabled><TargetBucket>" + str + "</TargetBucket>");
            if (str2 != null) {
                stringBuffer.append("<TargetPrefix>" + str2 + "</TargetPrefix>");
            }
            stringBuffer.append("</LoggingEnabled>");
        }
        stringBuffer.append("</BucketLoggingStatus>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = (long) bytes.length;
        setContent(new ByteArrayInputStream(bytes));
        setContentLength(length);
    }

    public void putBucketLifecycleRequestBodyMarshall(ArrayList<BucketLifecycleRule> arrayList) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<LifecycleConfiguration>");
        Iterator<BucketLifecycleRule> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BucketLifecycleRule next = it2.next();
            stringBuffer.append("<Rule>");
            if (next.getIdentifier() != null) {
                stringBuffer.append("<ID>" + next.getIdentifier() + "</ID>");
            }
            if (next.getPrefix() != null) {
                stringBuffer.append("<Prefix>" + next.getPrefix() + "</Prefix>");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<Status>");
            sb.append(next.getStatus() ? "Enabled" : "Disabled");
            sb.append("</Status>");
            stringBuffer.append(sb.toString());
            if (next.getDays() != null) {
                stringBuffer.append("<Days>" + next.getDays() + "</Days>");
            } else if (next.getExpireDate() != null) {
                stringBuffer.append("<Date>" + next.getExpireDate() + "</Date>");
            }
            if (next.getMultipartDays() != null) {
                stringBuffer.append("<AbortMultipartUpload><Days>" + next.getMultipartDays() + "</Days></AbortMultipartUpload>");
            } else if (next.getMultipartExpireDate() != null) {
                stringBuffer.append("<AbortMultipartUpload><Date>" + next.getMultipartDays() + "</Date></AbortMultipartUpload>");
            }
            if (next.getIADays() != null) {
                stringBuffer.append("<Transition><Days>" + next.getIADays() + "</Days><StorageClass>IA</StorageClass></Transition>");
            } else if (next.getIAExpireDate() != null) {
                stringBuffer.append("<Transition><Date>" + next.getIAExpireDate() + "</Date><StorageClass>IA</StorageClass></Transition>");
            } else if (next.getArchiveDays() != null) {
                stringBuffer.append("<Transition><Days>" + next.getArchiveDays() + "</Days><StorageClass>Archive</StorageClass></Transition>");
            } else if (next.getArchiveExpireDate() != null) {
                stringBuffer.append("<Transition><Date>" + next.getArchiveExpireDate() + "</Date><StorageClass>Archive</StorageClass></Transition>");
            }
            stringBuffer.append("</Rule>");
        }
        stringBuffer.append("</LifecycleConfiguration>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        setContent(new ByteArrayInputStream(bytes));
        setContentLength((long) bytes.length);
    }

    public byte[] deleteMultipleObjectRequestBodyMarshall(List<String> list, boolean z) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<Delete>");
        if (z) {
            stringBuffer.append("<Quiet>true</Quiet>");
        } else {
            stringBuffer.append("<Quiet>false</Quiet>");
        }
        for (String str : list) {
            stringBuffer.append("<Object>");
            stringBuffer.append("<Key>");
            stringBuffer.append(str);
            stringBuffer.append("</Key>");
            stringBuffer.append("</Object>");
        }
        stringBuffer.append("</Delete>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = (long) bytes.length;
        setContent(new ByteArrayInputStream(bytes));
        setContentLength(length);
        return bytes;
    }

    public String buildOSSServiceURL() {
        OSSUtils.assertTrue(this.service != null, "Service haven't been set!");
        String host = this.service.getHost();
        String scheme = this.service.getScheme();
        String str = null;
        if (!isHttpDnsEnable() || !scheme.equalsIgnoreCase("http")) {
            OSSLog.logDebug("[buildOSSServiceURL], disable httpdns or http is not need httpdns");
        } else {
            str = HttpdnsMini.getInstance().getIpByHostAsync(host);
        }
        if (str == null) {
            str = host;
        }
        getHeaders().put("Host", host);
        String str2 = scheme + "://" + str;
        String paramToQueryString = OSSUtils.paramToQueryString(this.parameters, "utf-8");
        if (OSSUtils.isEmptyString(paramToQueryString)) {
            return str2;
        }
        return str2 + "?" + paramToQueryString;
    }

    public String buildCanonicalURL() throws Exception {
        OSSUtils.assertTrue(this.endpoint != null, "Endpoint haven't been set!");
        String scheme = this.endpoint.getScheme();
        String host = this.endpoint.getHost();
        int port = this.endpoint.getPort();
        String str = null;
        String valueOf = port != -1 ? String.valueOf(port) : null;
        if (TextUtils.isEmpty(host)) {
            OSSLog.logDebug("endpoint url : " + this.endpoint.toString());
        }
        OSSLog.logDebug(" scheme : " + scheme);
        OSSLog.logDebug(" originHost : " + host);
        OSSLog.logDebug(" port : " + valueOf);
        String str2 = scheme + "://" + host;
        if (!TextUtils.isEmpty(valueOf)) {
            str2 = str2 + ":" + valueOf;
        }
        if (!TextUtils.isEmpty(this.bucketName)) {
            if (OSSUtils.isOssOriginHost(host)) {
                String str3 = this.bucketName + "." + host;
                if (isHttpDnsEnable()) {
                    str = HttpdnsMini.getInstance().getIpByHostAsync(str3);
                } else {
                    OSSLog.logDebug("[buildCannonicalURL], disable httpdns");
                }
                addHeader("Host", str3);
                str2 = !TextUtils.isEmpty(str) ? scheme + "://" + str : scheme + "://" + str3;
            } else if (OSSUtils.isValidateIP(host)) {
                str2 = str2 + "/";
                addHeader("Host", getIpWithHeader());
            }
        }
        if (!TextUtils.isEmpty(this.objectKey)) {
            str2 = str2 + "/" + HttpUtil.urlEncode(this.objectKey, "utf-8");
        }
        String paramToQueryString = OSSUtils.paramToQueryString(this.parameters, "utf-8");
        StringBuilder sb = new StringBuilder();
        sb.append("request---------------------\n");
        sb.append("request url=" + str2 + "\n");
        sb.append("request params=" + paramToQueryString + "\n");
        for (String str4 : getHeaders().keySet()) {
            sb.append("requestHeader [" + str4 + "]: ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append((String) getHeaders().get(str4));
            sb2.append("\n");
            sb.append(sb2.toString());
        }
        OSSLog.logDebug(sb.toString());
        if (OSSUtils.isEmptyString(paramToQueryString)) {
            return str2;
        }
        return str2 + "?" + paramToQueryString;
    }
}
