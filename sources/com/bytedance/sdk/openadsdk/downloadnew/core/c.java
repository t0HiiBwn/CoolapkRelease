package com.bytedance.sdk.openadsdk.downloadnew.core;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TTAppDownloadListenerGroup */
public class c implements TTAppDownloadListener {
    private final List<TTAppDownloadListener> a = Collections.synchronizedList(new LinkedList());

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        if (tTAppDownloadListener != null) {
            for (TTAppDownloadListener tTAppDownloadListener2 : this.a) {
                if (tTAppDownloadListener2 != null && tTAppDownloadListener2 == tTAppDownloadListener) {
                    return;
                }
            }
            synchronized (this.a) {
                this.a.add(tTAppDownloadListener);
            }
        }
    }

    public void a() {
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        synchronized (this.a) {
            Iterator<TTAppDownloadListener> it2 = this.a.iterator();
            while (it2.hasNext()) {
                TTAppDownloadListener next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.onIdle();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        synchronized (this.a) {
            Iterator<TTAppDownloadListener> it2 = this.a.iterator();
            while (it2.hasNext()) {
                TTAppDownloadListener next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.onDownloadActive(j, j2, str, str2);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        synchronized (this.a) {
            Iterator<TTAppDownloadListener> it2 = this.a.iterator();
            while (it2.hasNext()) {
                TTAppDownloadListener next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.onDownloadPaused(j, j2, str, str2);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        synchronized (this.a) {
            Iterator<TTAppDownloadListener> it2 = this.a.iterator();
            while (it2.hasNext()) {
                TTAppDownloadListener next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.onDownloadFailed(j, j2, str, str2);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        synchronized (this.a) {
            Iterator<TTAppDownloadListener> it2 = this.a.iterator();
            while (it2.hasNext()) {
                TTAppDownloadListener next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.onInstalled(str, str2);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        synchronized (this.a) {
            Iterator<TTAppDownloadListener> it2 = this.a.iterator();
            while (it2.hasNext()) {
                TTAppDownloadListener next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.onDownloadFinished(j, str, str2);
                }
            }
        }
    }
}
