package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* compiled from: InputtipsSearchCore */
public final class ba implements IInputtipsSearch {
    private Context a;
    private Inputtips.InputtipsListener b;
    private Handler c = s.a();
    private InputtipsQuery d;

    public ba(Context context, Inputtips.InputtipsListener inputtipsListener) {
        this.a = context.getApplicationContext();
        this.b = inputtipsListener;
    }

    public ba(Context context, InputtipsQuery inputtipsQuery) {
        this.a = context.getApplicationContext();
        this.d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.ba.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.obj = ba.this.b;
                    obtainMessage.arg1 = 5;
                    try {
                        ba baVar = ba.this;
                        ArrayList<? extends Parcelable> a2 = baVar.a(baVar.d);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("result", a2);
                        obtainMessage.setData(bundle);
                        obtainMessage.what = 1000;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        ba.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ba.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str == null || str.equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
        this.d = inputtipsQuery;
        inputtipsQuery.setType(str3);
        requestInputtipsAsyn();
    }

    /* access modifiers changed from: private */
    public ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            q.a(this.a);
            if (inputtipsQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                return (ArrayList) new o(this.a, inputtipsQuery).b();
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (Throwable th) {
            i.a(th, "Inputtips", "requestInputtips");
            if (!(th instanceof AMapException)) {
                return null;
            }
            throw th;
        }
    }
}
