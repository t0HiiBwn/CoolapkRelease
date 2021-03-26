package com.coolapk.market.view.webview;

import android.os.Bundle;
import com.coolapk.market.util.JavascriptInterfaceUtils;

public class WebHookViewFragment extends WebViewFragment {
    public static WebHookViewFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        WebHookViewFragment webHookViewFragment = new WebHookViewFragment();
        webHookViewFragment.setArguments(bundle);
        return webHookViewFragment;
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getWebView().addJavascriptInterface(new JavascriptInterfaceUtils(getActivity()), "webHook");
    }
}
