package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.jaq.securitybody.IJAQVerificationComponent;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import java.util.HashMap;

public class SecurityVerification {
    private Context context;

    public SecurityVerification(Context context2) {
        if (context2 != null) {
            this.context = context2.getApplicationContext();
        }
    }

    public String doJAQVerfificationSync(HashMap<String, String> hashMap, int i) throws JAQException {
        try {
            return ((IJAQVerificationComponent) SecurityGuardManager.getInstance(this.context).getInterface(IJAQVerificationComponent.class)).doJAQVerfificationSync(hashMap, i);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }
}
