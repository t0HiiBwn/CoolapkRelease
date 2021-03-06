package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    public static class C0145a {
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0145a aVar) {
        String str;
        if (context == null) {
            str = "send fail, invalid argument";
        } else if (d.b(aVar.action)) {
            str = "send fail, action is null";
        } else {
            String str2 = null;
            if (!d.b(aVar.a)) {
                str2 = aVar.a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.action);
            if (aVar.bundle != null) {
                intent.putExtras(aVar.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 637928448);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", aVar.content);
            intent.putExtra("_mmessage_support_content_type", aVar.b);
            intent.putExtra("_mmessage_checksum", b.a(aVar.content, 637928448, packageName));
            context.sendBroadcast(intent, str2);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
