package com.taobao.tao.remotebusiness.b;

import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: MtopBaseListener */
abstract class b {
    protected MtopListener a;
    protected MtopBusiness b;

    protected b(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        this.b = mtopBusiness;
        this.a = mtopListener;
    }
}
