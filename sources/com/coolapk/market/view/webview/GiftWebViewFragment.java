package com.coolapk.market.view.webview;

import android.os.Bundle;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.JavascriptInterfaceUtils;

public class GiftWebViewFragment extends WebViewFragment {
    public static final String KEY_APP = "APP";
    public static final String KEY_GIFT = "GIFT";

    public static GiftWebViewFragment newInstance(String str, Gift gift, ServiceApp serviceApp) {
        Bundle bundle = new Bundle();
        bundle.putString("external_url", str);
        bundle.putParcelable("GIFT", gift);
        bundle.putParcelable("APP", serviceApp);
        GiftWebViewFragment giftWebViewFragment = new GiftWebViewFragment();
        giftWebViewFragment.setArguments(bundle);
        return giftWebViewFragment;
    }

    @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getWebView().addJavascriptInterface(new JavascriptInterfaceUtils(getActivity(), (Gift) getArguments().getParcelable("GIFT"), (ServiceApp) getArguments().getParcelable("APP")), "webHook");
    }
}
