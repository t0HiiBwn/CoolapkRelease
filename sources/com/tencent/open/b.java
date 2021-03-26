package com.tencent.open;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public abstract class b extends Dialog {
    protected a a;
    protected final WebChromeClient b = new WebChromeClient() {
        /* class com.tencent.open.b.AnonymousClass1 */

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            if (Build.VERSION.SDK_INT <= 7) {
                return true;
            }
            b.this.a(consoleMessage == null ? "" : consoleMessage.message());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i, String str2) {
            f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i + " of " + str2);
            if (Build.VERSION.SDK_INT == 7) {
                b.this.a(str);
            }
        }
    };

    protected abstract void a(String str);

    public b(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a();
    }
}
