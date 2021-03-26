package com.bytedance.embedapplog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bi implements IDataObserver {
    private static ArrayList<WeakReference<IDataObserver>> a = new ArrayList<>(4);

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onIdLoaded(String str, String str2, String str3) {
        Iterator<WeakReference<IDataObserver>> it2 = a.iterator();
        while (it2.hasNext()) {
            IDataObserver iDataObserver = it2.next().get();
            if (iDataObserver == null) {
                it2.remove();
            } else {
                iDataObserver.onIdLoaded(str, str2, str3);
            }
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<WeakReference<IDataObserver>> it2 = a.iterator();
        while (it2.hasNext()) {
            IDataObserver iDataObserver = it2.next().get();
            if (iDataObserver == null) {
                it2.remove();
            } else {
                iDataObserver.onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
            }
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<IDataObserver>> it2 = a.iterator();
        while (it2.hasNext()) {
            IDataObserver iDataObserver = it2.next().get();
            if (iDataObserver == null) {
                it2.remove();
            } else {
                iDataObserver.onRemoteConfigGet(z, jSONObject);
            }
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<IDataObserver>> it2 = a.iterator();
        while (it2.hasNext()) {
            IDataObserver iDataObserver = it2.next().get();
            if (iDataObserver == null) {
                it2.remove();
            } else {
                iDataObserver.onRemoteAbConfigGet(z, jSONObject);
            }
        }
    }

    public synchronized void a(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            a.add(new WeakReference<>(iDataObserver));
        }
    }

    public synchronized void b(IDataObserver iDataObserver) {
        Iterator<WeakReference<IDataObserver>> it2 = a.iterator();
        while (it2.hasNext()) {
            IDataObserver iDataObserver2 = it2.next().get();
            if (iDataObserver2 == null) {
                it2.remove();
            } else if (iDataObserver2.equals(iDataObserver)) {
                it2.remove();
            }
        }
    }
}
