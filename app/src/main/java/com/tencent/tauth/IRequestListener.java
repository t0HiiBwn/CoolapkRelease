package com.tencent.tauth;

import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public interface IRequestListener {
    void onComplete(JSONObject jSONObject);

    void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException);

    void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException);

    void onIOException(IOException iOException);

    void onJSONException(JSONException jSONException);

    void onMalformedURLException(MalformedURLException malformedURLException);

    void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException);

    void onSocketTimeoutException(SocketTimeoutException socketTimeoutException);

    void onUnknowException(Exception exc);
}
