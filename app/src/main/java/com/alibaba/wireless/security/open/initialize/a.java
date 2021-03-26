package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;

public class a implements IInitializeComponent {
    b a;

    public a() {
        this.a = new b();
    }

    public a(String str) {
        this.a = new b(str);
    }

    public ISGPluginManager a() {
        return this.a.a();
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int initialize(Context context) throws SecException {
        return loadLibrarySync(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void initializeAsync(Context context) {
        try {
            loadLibraryAsync(context);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public boolean isSoValid(Context context) throws SecException {
        return this.a.a(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void loadLibraryAsync(Context context) throws SecException {
        this.a.b(context, null, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context) throws SecException {
        return this.a.a(context, null, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context, String str) throws SecException {
        return this.a.a(context, str, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void registerInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.a.a(iInitFinishListener);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.a.b(iInitFinishListener);
    }
}
