package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class ObjectMetadata {
    public static final String AES_256_SERVER_SIDE_ENCRYPTION = "AES256";
    private Map<String, Object> metadata = new CaseInsensitiveHashMap();
    private Map<String, String> userMetadata = new CaseInsensitiveHashMap();

    public Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public void setUserMetadata(Map<String, String> map) {
        this.userMetadata.clear();
        if (map != null && !map.isEmpty()) {
            this.userMetadata.putAll(map);
        }
    }

    public void setHeader(String str, Object obj) {
        this.metadata.put(str, obj);
    }

    public void addUserMetadata(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    public Date getLastModified() {
        return (Date) this.metadata.get("Last-Modified");
    }

    public void setLastModified(Date date) {
        this.metadata.put("Last-Modified", date);
    }

    public Date getExpirationTime() throws ParseException {
        return DateUtil.parseRfc822Date((String) this.metadata.get("Expires"));
    }

    public void setExpirationTime(Date date) {
        this.metadata.put("Expires", DateUtil.formatRfc822Date(date));
    }

    public String getRawExpiresValue() {
        return (String) this.metadata.get("Expires");
    }

    public long getContentLength() {
        Long l = (Long) this.metadata.get("Content-Length");
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public void setContentLength(long j) {
        if (j <= 5368709120L) {
            this.metadata.put("Content-Length", Long.valueOf(j));
            return;
        }
        throw new IllegalArgumentException("The content length could not be more than 5GB.");
    }

    public String getContentType() {
        return (String) this.metadata.get("Content-Type");
    }

    public void setContentType(String str) {
        this.metadata.put("Content-Type", str);
    }

    public String getContentMD5() {
        return (String) this.metadata.get("Content-MD5");
    }

    public void setContentMD5(String str) {
        this.metadata.put("Content-MD5", str);
    }

    public String getSHA1() {
        return (String) this.metadata.get("x-oss-hash-sha1");
    }

    public void setSHA1(String str) {
        this.metadata.put("x-oss-hash-sha1", str);
    }

    public String getContentEncoding() {
        return (String) this.metadata.get("Content-Encoding");
    }

    public void setContentEncoding(String str) {
        this.metadata.put("Content-Encoding", str);
    }

    public String getCacheControl() {
        return (String) this.metadata.get("Cache-Control");
    }

    public void setCacheControl(String str) {
        this.metadata.put("Cache-Control", str);
    }

    public String getContentDisposition() {
        return (String) this.metadata.get("Content-Disposition");
    }

    public void setContentDisposition(String str) {
        this.metadata.put("Content-Disposition", str);
    }

    public String getETag() {
        return (String) this.metadata.get("ETag");
    }

    public String getServerSideEncryption() {
        return (String) this.metadata.get("x-oss-server-side-encryption");
    }

    public void setServerSideEncryption(String str) {
        this.metadata.put("x-oss-server-side-encryption", str);
    }

    public String getObjectType() {
        return (String) this.metadata.get("x-oss-object-type");
    }

    public Map<String, Object> getRawMetadata() {
        return Collections.unmodifiableMap(this.metadata);
    }

    public String toString() {
        String str;
        try {
            str = getExpirationTime().toString();
        } catch (Exception unused) {
            str = "";
        }
        return "Last-Modified:" + getLastModified() + "\nExpires:" + str + "\nrawExpires:" + getRawExpiresValue() + "\nContent-MD5:" + getContentMD5() + "\nx-oss-object-type:" + getObjectType() + "\nx-oss-server-side-encryption:" + getServerSideEncryption() + "\nContent-Disposition:" + getContentDisposition() + "\nContent-Encoding:" + getContentEncoding() + "\nCache-Control:" + getCacheControl() + "\nETag:" + getETag() + "\n";
    }
}
