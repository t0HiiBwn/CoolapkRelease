package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: MtopBusiness */
final class a implements IRemoteBaseListener {
    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public final void onError(int i, MtopResponse mtopResponse, Object obj) {
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public final void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public final void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
    }

    a(MtopBusiness mtopBusiness) {
    }
}
