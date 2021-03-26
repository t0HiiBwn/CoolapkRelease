package com.bun.miitmdid.provider.zte;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import com.bun.lib.MsaIdInterface;
import com.netease.nis.sdkwrapper.Utils;
import java.util.Objects;

public class MsaClient {
    private static String TAG = "MSA Client library";
    private ServiceConnection mConnection;
    private Context mContext;
    private MsaIdInterface mDeviceidInterface;

    public MsaClient(Context context, final MsaServiceConnection msaServiceConnection) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.mContext = context;
        this.mConnection = new ServiceConnection() {
            /* class com.bun.miitmdid.provider.zte.MsaClient.AnonymousClass1 */

            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MsaClient.access$002(MsaClient.this, MsaIdInterface.Stub.asInterface(iBinder));
                new MsaAsyncTask(MsaClient.access$000(MsaClient.this), msaServiceConnection).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                MsaClient.access$100();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                MsaClient.access$002(MsaClient.this, null);
                MsaClient.access$100();
                MsaClient.access$002(MsaClient.this, null);
            }
        };
    }

    public static void StartMsaKlService(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = 113;
        objArr[4] = 1606976968585L;
        Utils.rL(objArr);
    }

    public static /* synthetic */ MsaIdInterface access$000(MsaClient msaClient) {
        Object[] objArr = new Object[4];
        objArr[1] = msaClient;
        objArr[2] = 114;
        objArr[3] = 1606976968586L;
        return (MsaIdInterface) Utils.rL(objArr);
    }

    public static /* synthetic */ MsaIdInterface access$002(MsaClient msaClient, MsaIdInterface msaIdInterface) {
        Object[] objArr = new Object[5];
        objArr[1] = msaClient;
        objArr[2] = msaIdInterface;
        objArr[3] = 115;
        objArr[4] = 1606976968587L;
        return (MsaIdInterface) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$100() {
        Object[] objArr = new Object[3];
        objArr[1] = 116;
        objArr[2] = 1606976968588L;
        return (String) Utils.rL(objArr);
    }

    public void BindService(String str) {
        Utils.rL(new Object[]{this, str, 117, 1606976968589L});
    }

    public String getAAID() {
        return (String) Utils.rL(new Object[]{this, 118, 1606976968590L});
    }

    public String getOAID() {
        return (String) Utils.rL(new Object[]{this, 119, 1606976968591L});
    }

    public String getUDID() {
        return (String) Utils.rL(new Object[]{this, 120, 1606976968592L});
    }

    public String getVAID() {
        return (String) Utils.rL(new Object[]{this, 121, 1606976968593L});
    }

    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 122, 1606976968594L})).booleanValue();
    }

    public void shutdown() {
        Utils.rL(new Object[]{this, 123, 1606976968595L});
    }
}
