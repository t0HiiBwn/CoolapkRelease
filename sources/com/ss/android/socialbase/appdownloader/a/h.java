package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.g.a;

/* compiled from: O2DevicePlan */
public class h extends a {
    public h(Context context, a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent(e.c + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.c);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
