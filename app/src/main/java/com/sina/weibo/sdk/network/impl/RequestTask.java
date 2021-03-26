package com.sina.weibo.sdk.network.impl;

import android.os.AsyncTask;
import android.os.Bundle;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.RequestCancelable;
import com.sina.weibo.sdk.network.base.RequestResult;
import com.sina.weibo.sdk.network.base.WbResponse;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.network.exception.SdkException;
import com.sina.weibo.sdk.network.intercept.GlobalInterceptHelper;
import com.sina.weibo.sdk.network.target.Target;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

public class RequestTask<T, R> extends AsyncTask<Object, Object, RequestResult> implements RequestCancelable {
    private IRequestParam param;
    Class<T> tClass;
    private Target<R> target;

    @Override // com.sina.weibo.sdk.network.RequestCancelable
    public void cancelRequest() {
    }

    @Override // com.sina.weibo.sdk.network.RequestCancelable
    public boolean isCancelRequest() {
        return false;
    }

    public RequestTask(IRequestParam iRequestParam, Target<R> target2) {
        this.param = iRequestParam;
        this.target = target2;
    }

    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public RequestResult doInBackground(Object... objArr) {
        RequestResult requestResult = new RequestResult();
        if (!NetStateManager.isNetworkConnected(this.param.getContext())) {
            LogUtil.e("Task", "RequestTask:android.permission.ACCESS_NETWORK_STATE");
            requestResult.setE(new SdkException("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.param.needIntercept()) {
            try {
                Bundle bundle = new Bundle();
                HashMap<String, IRequestIntercept> globalIntercept = GlobalInterceptHelper.init().getGlobalIntercept();
                for (String str : globalIntercept.keySet()) {
                    IRequestIntercept iRequestIntercept = globalIntercept.get(str);
                    if (iRequestIntercept != null && iRequestIntercept.needIntercept(this.param, bundle)) {
                        iRequestIntercept.doIntercept(this.param, bundle);
                    }
                }
                Iterator<IRequestIntercept> it2 = this.param.getIntercept().iterator();
                while (it2.hasNext()) {
                    IRequestIntercept next = it2.next();
                    if (next.needIntercept(this.param, bundle)) {
                        next.doIntercept(this.param, bundle);
                    }
                }
                this.param.getPostBundle().putAll(bundle);
            } catch (InterceptException e) {
                requestResult.setE(e);
                return requestResult;
            }
        }
        try {
            WbResponse request = RequestEngine.request(this.param);
            R transResponse = this.target.transResponse(request);
            this.target.onRequestSuccessBg(transResponse);
            requestResult.setResponse(transResponse);
            try {
                InputStream byteStream = request.body().byteStream();
                if (byteStream != null) {
                    byteStream.close();
                }
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            requestResult.setE(e2);
        }
        return requestResult;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.sina.weibo.sdk.network.target.Target<R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onPostExecute(RequestResult requestResult) {
        super.onPostExecute((RequestTask<T, R>) requestResult);
        Target<R> target2 = this.target;
        if (target2 != null) {
            target2.onRequestDone();
            if (requestResult.getE() != null) {
                this.target.onFailure(requestResult.getE());
                this.target.onError();
                return;
            }
            this.target.onRequestSuccess(requestResult.getResponse());
        }
    }
}
