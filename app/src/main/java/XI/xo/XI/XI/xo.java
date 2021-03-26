package XI.xo.XI.XI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public class xo extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r0 == 0) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            boolean z = false;
            int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                    if (stringArrayListExtra != null) {
                        z = stringArrayListExtra.contains(context.getPackageName());
                    }
                }
                if (!z) {
                    String stringExtra = intent.getStringExtra("openIdType");
                    CA XI2 = CA.XI();
                    XI2.getClass();
                    XI xi = "oaid".equals(stringExtra) ? XI2.K0 : "vaid".equals(stringExtra) ? XI2.xo : "aaid".equals(stringExtra) ? XI2.kM : "udid".equals(stringExtra) ? XI2.f1181XI : null;
                    if (xi != null) {
                        xi.f1183XI = 0;
                        return;
                    }
                    return;
                }
                return;
            }
            z = true;
            if (!z) {
            }
        }
    }
}
