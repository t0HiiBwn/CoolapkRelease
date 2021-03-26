package com.tencent.connect.common;

import android.content.Intent;
import com.tencent.open.a.f;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class UIListenerManager {
    private static UIListenerManager a;
    private Map<String, ApiTask> b;

    public static UIListenerManager getInstance() {
        if (a == null) {
            a = new UIListenerManager();
        }
        return a;
    }

    private UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.b = synchronizedMap;
        if (synchronizedMap == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        ApiTask put;
        String a2 = h.a(i);
        if (a2 == null) {
            f.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
            return null;
        }
        synchronized (this.b) {
            put = this.b.put(a2, new ApiTask(i, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int a2 = h.a(str);
        if (a2 == -1) {
            f.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.b) {
            put = this.b.put(str, new ApiTask(a2, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        String a2 = h.a(i);
        if (a2 != null) {
            return getListnerWithAction(a2);
        }
        f.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i);
        return null;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            f.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.b) {
            apiTask = this.b.get(str);
            this.b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        f.c("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra("key_action");
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra("key_error_code", 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra("key_response");
                if (stringExtra2 != null) {
                    try {
                        iUiListener.onComplete(j.d(stringExtra2));
                    } catch (JSONException e) {
                        iUiListener.onError(new UiError(-4, "服务器返回数据格式有误!", stringExtra2));
                        f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                    }
                } else {
                    f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    iUiListener.onComplete(new JSONObject());
                }
            } else {
                f.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                iUiListener.onError(new UiError(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
            }
        } else if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra3)) {
                iUiListener.onCancel();
            } else if ("error".equals(stringExtra3)) {
                iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
            } else if ("complete".equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    private IUiListener a(int i, IUiListener iUiListener) {
        if (i == 11101) {
            f.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11105) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11106) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public boolean onActivityResult(int i, int i2, Intent intent, IUiListener iUiListener) {
        f.c("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
        if (listnerWithRequestCode == null) {
            if (iUiListener != null) {
                listnerWithRequestCode = a(i, iUiListener);
            } else {
                f.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i2 != -1) {
            listnerWithRequestCode.onCancel();
        } else if (intent == null) {
            listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            String stringExtra = intent.getStringExtra("key_action");
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra("key_error_code", 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra("key_response");
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(j.d(stringExtra2));
                        } catch (JSONException e) {
                            listnerWithRequestCode.onError(new UiError(-4, "服务器返回数据格式有误!", stringExtra2));
                            f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        }
                    } else {
                        f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                        listnerWithRequestCode.onComplete(new JSONObject());
                    }
                } else {
                    f.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                    listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                }
            } else if ("action_share".equals(stringExtra)) {
                String stringExtra3 = intent.getStringExtra("result");
                String stringExtra4 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra3)) {
                    listnerWithRequestCode.onCancel();
                } else if ("error".equals(stringExtra3)) {
                    listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
                } else if ("complete".equals(stringExtra3)) {
                    try {
                        listnerWithRequestCode.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra4 + ""));
                    }
                }
            } else {
                int intExtra2 = intent.getIntExtra("key_error_code", 0);
                if (intExtra2 == 0) {
                    String stringExtra5 = intent.getStringExtra("key_response");
                    if (stringExtra5 != null) {
                        try {
                            listnerWithRequestCode.onComplete(j.d(stringExtra5));
                        } catch (JSONException unused) {
                            listnerWithRequestCode.onError(new UiError(-4, "服务器返回数据格式有误!", stringExtra5));
                        }
                    } else {
                        listnerWithRequestCode.onComplete(new JSONObject());
                    }
                } else {
                    listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                }
            }
        }
        return true;
    }

    /* compiled from: ProGuard */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, IUiListener iUiListener) {
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }
}
