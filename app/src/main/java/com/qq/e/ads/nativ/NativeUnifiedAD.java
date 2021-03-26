package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class NativeUnifiedAD extends AbstractAD<NUADI> {
    private AdListenerAdapter a;
    private List<Integer> b = new ArrayList();
    private List<String> c;
    private String d;
    private volatile int e;
    private volatile int f;
    private String g;

    private static class AdListenerAdapter implements ADListener {
        private NativeADUnifiedListener a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.a != null) {
                Object[] paras = aDEvent.getParas();
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type == 2 && paras.length > 0 && (paras[0] instanceof Integer)) {
                        this.a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    }
                } else if (paras.length == 1 && (paras[0] instanceof List)) {
                    List<NativeUnifiedADData> list = (List) paras[0];
                    ArrayList arrayList = new ArrayList();
                    if (list != null && list.size() > 0) {
                        for (NativeUnifiedADData nativeUnifiedADData : list) {
                            arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                        }
                    }
                    this.a.onADLoaded(arrayList);
                }
            } else {
                GDTLogger.i("not bind NativeADUnifiedListener");
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, nativeADUnifiedListener);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(nativeADUnifiedListener, 2003);
    }

    @Deprecated
    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, str2, nativeADUnifiedListener);
    }

    private void a(int i, boolean z) {
        if (!c()) {
            GDTLogger.e("Parameters or context error, details in init NativeUnifiedAD log");
        } else if (b()) {
            NUADI nuadi = (NUADI) a();
            if (nuadi != null) {
                nuadi.loadData(i);
            }
        } else if (z) {
            this.b.add(Integer.valueOf(i));
        }
    }

    private void a(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        if (context == null || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            GDTLogger.e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", str, str2, context));
            a(nativeADUnifiedListener, 2001);
            return;
        }
        this.a = new AdListenerAdapter(nativeADUnifiedListener);
        this.d = str2;
        a(context, str, str2, (AbstractAD.BasicADListener) nativeADUnifiedListener);
    }

    /* Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NUADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.a);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final void a(final AbstractAD.BasicADListener basicADListener, final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.qq.e.ads.nativ.NativeUnifiedAD.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                NativeUnifiedAD.super.a(basicADListener, i);
            }
        });
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NUADI nuadi) {
        NUADI nuadi2 = nuadi;
        nuadi2.setMinVideoDuration(this.e);
        nuadi2.setMaxVideoDuration(this.f);
        nuadi2.setVastClassName(this.g);
        List<String> list = this.c;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.b) {
            a(num.intValue(), false);
        }
    }

    public String getAdNetWorkName() {
        NUADI nuadi = (NUADI) a();
        if (nuadi != null) {
            return nuadi.getAdNetWorkName();
        }
        GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onADLoaded\"");
        return null;
    }

    public void loadData(int i) {
        a(i, true);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        loadData(i);
    }

    public void setCategories(List<String> list) {
        this.c = list;
        NUADI nuadi = (NUADI) a();
        if (nuadi != null && list != null) {
            nuadi.setCategories(list);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f = i;
        if (this.f > 0 && this.e > this.f) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        NUADI nuadi = (NUADI) a();
        if (nuadi != null) {
            nuadi.setMaxVideoDuration(this.f);
        }
    }

    public void setMinVideoDuration(int i) {
        this.e = i;
        if (this.f > 0 && this.e > this.f) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        NUADI nuadi = (NUADI) a();
        if (nuadi != null) {
            nuadi.setMinVideoDuration(this.e);
        }
    }

    public void setTag(Map map) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", new JSONObject(map), this.d);
            } catch (Exception e2) {
                GDTLogger.e("NativeUnifiedAD#setTag Exception");
                e2.printStackTrace();
            }
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name can't be null");
            return;
        }
        this.g = str;
        NUADI nuadi = (NUADI) a();
        if (nuadi != null) {
            nuadi.setVastClassName(str);
        }
    }

    @Deprecated
    public void setVideoADContainerRender(int i) {
    }

    @Deprecated
    public void setVideoPlayPolicy(int i) {
    }
}
