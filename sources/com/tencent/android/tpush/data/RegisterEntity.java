package com.tencent.android.tpush.data;

import com.tencent.android.tpush.common.f;
import com.tencent.android.tpush.logging.TLogger;
import java.io.Serializable;

/* compiled from: ProGuard */
public class RegisterEntity implements Serializable {
    private static final String TAG = "RegisterEntity";
    public static final byte TYPE_REGISTER = 0;
    public static final byte TYPE_REMOTE_UNINSTALL = 4;
    public static final byte TYPE_REMOTE_UNREGISTER = 3;
    public static final byte TYPE_UNINSTALL = 2;
    public static final byte TYPE_UNREGISTER = 1;
    private static final long serialVersionUID = -7991157757568940718L;
    public long accessId;
    public String accessKey;
    public String appVersion;
    public long channelId;
    public long guid;
    public String packageName;
    public int state;
    public long timestamp;
    public String token;
    public String xgSDKVersion = "1.2.3.1";

    public long getGuid() {
        return this.guid;
    }

    public void setGuid(long j) {
        this.guid = j;
    }

    public static String encode(RegisterEntity registerEntity) {
        try {
            return f.a(registerEntity);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static RegisterEntity decode(String str) {
        try {
            return (RegisterEntity) f.a(str);
        } catch (ClassNotFoundException unused) {
            TLogger.i("RegisterEntity", "RegisterEntity decode ClassNotFound");
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean isRegistered() {
        return this.state == 0;
    }

    public boolean isUnregistered() {
        return this.state == 1;
    }

    public boolean isUnstalled() {
        return this.state == 2;
    }

    public void setRegistered() {
        this.state = 0;
    }

    public void setUnstalled() {
        this.state = 2;
    }

    public void setUnregistered() {
        this.state = 1;
    }

    @Override // java.lang.Object
    public String toString() {
        return "RegisterEntity [accessId=" + this.accessId + ", accessKey=" + this.accessKey + ", token=" + this.token + ", packageName=" + this.packageName + ", state=" + this.state + ", timestamp=" + this.timestamp + ", xgSDKVersion=" + this.xgSDKVersion + ", appVersion=" + this.appVersion + ", guid=" + this.guid + "]";
    }
}
