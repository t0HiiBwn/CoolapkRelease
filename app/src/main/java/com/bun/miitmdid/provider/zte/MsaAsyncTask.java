package com.bun.miitmdid.provider.zte;

import android.os.AsyncTask;
import com.bun.lib.MsaIdInterface;
import com.netease.nis.sdkwrapper.Utils;

public class MsaAsyncTask extends AsyncTask<Void, Void, Boolean> {
    public MsaServiceConnection _conn;
    public MsaIdInterface msaIdInterface;

    public MsaAsyncTask(MsaIdInterface msaIdInterface2, MsaServiceConnection msaServiceConnection) {
        this.msaIdInterface = msaIdInterface2;
        this._conn = msaServiceConnection;
    }

    public Boolean doInBackground(Void... voidArr) {
        return (Boolean) Utils.rL(new Object[]{this, voidArr, 108, 1606976968580L});
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Boolean, java.lang.Object] */
    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Boolean doInBackground(Void[] voidArr) {
        return Utils.rL(new Object[]{this, voidArr, 109, 1606976968581L});
    }

    public void onPostExecute(Boolean bool) {
        Utils.rL(new Object[]{this, bool, 110, 1606976968582L});
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        Utils.rL(new Object[]{this, bool, 111, 1606976968583L});
    }
}
