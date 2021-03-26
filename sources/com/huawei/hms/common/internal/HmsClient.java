package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class HmsClient extends BaseHmsClient implements AnyClient {
    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.AnyClient
    public void post(IMessageEntity iMessageEntity, String str, AnyClient.CallBack callBack) {
        if (callBack == null) {
            HMSLog.e("HmsClient", "callback is invalid, discard.");
        } else if (!(iMessageEntity instanceof RequestHeader) || str == null) {
            HMSLog.e("HmsClient", "arguments is invalid.");
            callBack.onCallback(new ResponseHeader(1, 907135000, "Args is invalid"), new JSONObject().toString());
        } else if (!isConnected()) {
            HMSLog.e("HmsClient", "post failed for no connected.");
            callBack.onCallback(new ResponseHeader(1, 907135001, "Not Connected"), new JSONObject().toString());
        } else {
            RequestHeader requestHeader = (RequestHeader) iMessageEntity;
            HMSLog.i("HmsClient", "post msg " + requestHeader);
            Activity cpActivity = getClientSettings().getCpActivity();
            (cpActivity == null ? new BaseAdapter(this) : new BaseAdapter(this, cpActivity)).baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new a(this, callBack));
        }
    }

    public void updateSessionId(String str) {
        if (TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }

    private static class a implements BaseAdapter.BaseCallBack {
        private final AnyClient.CallBack a;
        private final WeakReference<HmsClient> b;

        a(HmsClient hmsClient, AnyClient.CallBack callBack) {
            this.a = callBack;
            this.b = new WeakReference<>(hmsClient);
        }

        private void a(String str) {
            HmsClient hmsClient = this.b.get();
            if (hmsClient != null) {
                hmsClient.updateSessionId(str);
            }
        }

        private void a(String str, String str2) {
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                HMSLog.i("HmsClient", "receive msg " + responseHeader);
                a(responseHeader.getSessionId());
                this.a.onCallback(responseHeader, str2);
                return;
            }
            this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
        }

        private void a(String str, String str2, Parcelable parcelable) {
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                responseHeader.setParcelable(parcelable);
                HMSLog.i("HmsClient", "receive msg " + responseHeader);
                a(responseHeader.getSessionId());
                this.a.onCallback(responseHeader, str2);
                return;
            }
            this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onComplete(String str, String str2, Parcelable parcelable) {
            if (parcelable == null) {
                a(str, str2);
            } else {
                a(str, str2, parcelable);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onError(String str) {
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                HMSLog.i("HmsClient", "receive msg " + responseHeader);
                a(responseHeader.getSessionId());
                this.a.onCallback(responseHeader, new JSONObject().toString());
                return;
            }
            this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
        }
    }
}
