package com.taobao.tao.remotebusiness.b;

import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.domain.Request;

/* compiled from: MtopListenerProxyFactory */
public class e {
    public Mtop a;
    public MtopRequest b;
    public MtopResponse c;
    public MtopNetworkProp d = new MtopNetworkProp();
    public MtopListener e;
    public ApiID f;
    public MtopStatistics g;
    public String h;
    public Map<String, String> i;
    public Request j;
    public MtopBuilder k;

    public static MtopListener a(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MtopCallback.MtopFinishListener.class);
        if (mtopListener instanceof IRemoteProcessListener) {
            arrayList.add(MtopCallback.MtopProgressListener.class);
            arrayList.add(MtopCallback.MtopHeaderListener.class);
        }
        if ((mtopListener instanceof IRemoteCacheListener) || mtopBusiness.mtopProp.useCache) {
            arrayList.add(MtopCallback.MtopCacheListener.class);
        }
        return (MtopListener) Proxy.newProxyInstance(MtopListener.class.getClassLoader(), (Class[]) arrayList.toArray(new Class[arrayList.size()]), new a(mtopBusiness, mtopListener));
    }
}
