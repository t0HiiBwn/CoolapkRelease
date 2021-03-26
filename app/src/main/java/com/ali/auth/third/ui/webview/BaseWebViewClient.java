package com.ali.auth.third.ui.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.ui.R;
import java.lang.ref.WeakReference;

public class BaseWebViewClient extends WebViewClient {
    protected WeakReference<Activity> b;
    protected boolean c = true;
    protected boolean d = false;

    public BaseWebViewClient(Activity activity) {
        this.b = new WeakReference<>(activity);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        this.b.get();
        if (this.c) {
            String string = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_title);
            String string2 = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_info);
            String string3 = webView.getContext().getResources().getString(R.string.aliuser_common_ok);
            AnonymousClass1 r2 = new DialogInterface.OnClickListener() {
                /* class com.ali.auth.third.ui.webview.BaseWebViewClient.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                    BaseWebViewClient.this.d = true;
                }
            };
            String string4 = webView.getContext().getResources().getString(R.string.aliuser_cancel);
            AnonymousClass2 r4 = new DialogInterface.OnClickListener() {
                /* class com.ali.auth.third.ui.webview.BaseWebViewClient.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    BaseWebViewClient.this.d = false;
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
            builder.setPositiveButton(string3, r2);
            builder.setNeutralButton(string4, r4);
            try {
                AlertDialog create = builder.create();
                create.setTitle(string);
                create.setMessage(string2);
                create.show();
                this.c = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.d) {
            sslErrorHandler.proceed();
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }
}
