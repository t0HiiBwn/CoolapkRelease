package com.tencent.beacon.pagepath;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.beacon.core.a;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.upload.UploadStrategy;
import java.util.Map;

public class ModuleImpl extends c {
    private static ModuleImpl mInstance;
    private boolean enableModule = UploadStrategy.DEFAULT_PAGE_PATH_ENABLE;

    public ModuleImpl(Context context) {
        super(context);
    }

    public static synchronized ModuleImpl getInstance(Context context) {
        ModuleImpl moduleImpl;
        synchronized (ModuleImpl.class) {
            if (mInstance == null) {
                mInstance = new ModuleImpl(context);
            }
            moduleImpl = mInstance;
        }
        return moduleImpl;
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStrategyUpdated(int i, Map<String, String> map) {
        super.onModuleStrategyUpdated(i, map);
        if (i == 1) {
            this.enableModule = h.a(map.get("isPagePath"), this.enableModule);
            b.b("[module] get isPagePath: " + this.enableModule, new Object[0]);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x001f: IGET  (r3v0 boolean) = (r4v0 'this' com.tencent.beacon.pagepath.ModuleImpl A[IMMUTABLE_TYPE, THIS]) com.tencent.beacon.pagepath.ModuleImpl.enableModule boolean)] */
    @Override // com.tencent.beacon.core.c
    public void onModuleStarted() {
        super.onModuleStarted();
        this.enableModule = this.enableModule && Build.VERSION.SDK_INT >= 14 && a.a;
        StringBuilder sb = new StringBuilder();
        sb.append(this.enableModule);
        b.a("[module] pagePath module > %S", sb.toString());
        if (this.enableModule) {
            ((Application) this.mContext).registerActivityLifecycleCallbacks(new a());
        }
    }
}
