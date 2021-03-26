package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.g.a;

/* compiled from: O1DevicePlan */
public class g extends a {
    public g(Context context, a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent(e.c + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.c);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
