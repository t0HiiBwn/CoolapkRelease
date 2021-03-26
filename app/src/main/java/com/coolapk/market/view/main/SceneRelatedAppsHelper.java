package com.coolapk.market.view.main;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u00132\u001c\u0010\u0015\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J$\u0010\u0019\u001a\u00020\u00132\u001c\u0010\u0015\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/main/SceneRelatedAppsHelper;", "", "()V", "<set-?>", "Lcom/coolapk/market/model/Entity;", "card", "getCard", "()Lcom/coolapk/market/model/Entity;", "setCard", "(Lcom/coolapk/market/model/Entity;)V", "card$delegate", "Lkotlin/properties/ReadWriteProperty;", "currentEntityUniqueId", "", "loaderSub", "Lrx/Subscription;", "onCardChangedCallbacks", "", "Lkotlin/Function2;", "", "addOnCardChangedCallback", "callback", "loadCard", "app", "Lcom/coolapk/market/model/ServiceApp;", "removeOnCardChangedCallback", "shouldShow", "", "entityUniqueId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SceneRelatedAppsHelper.kt */
public final class SceneRelatedAppsHelper {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SceneRelatedAppsHelper.class, "card", "getCard()Lcom/coolapk/market/model/Entity;", 0))};
    private final ReadWriteProperty card$delegate;
    private String currentEntityUniqueId;
    private Subscription loaderSub;
    private final List<Function2<String, Entity, Unit>> onCardChangedCallbacks = new ArrayList();

    /* access modifiers changed from: private */
    public final void setCard(Entity entity) {
        this.card$delegate.setValue(this, $$delegatedProperties[0], entity);
    }

    public final Entity getCard() {
        return (Entity) this.card$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public SceneRelatedAppsHelper() {
        Delegates delegates = Delegates.INSTANCE;
        this.card$delegate = new SceneRelatedAppsHelper$$special$$inlined$observable$1(null, null, this);
    }

    public final void loadCard(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        RxUtils.unsubscribe(this.loaderSub);
        this.loaderSub = DataManager.getInstance().getDataList("#/apk/sceneRelatedAppList?packageName=" + serviceApp.getPackageName() + "&generateCard=1", "", "", 1, "", "", "").compose(RxUtils.apiCommonToData()).subscribe(new SceneRelatedAppsHelper$loadCard$1(this, serviceApp), SceneRelatedAppsHelper$loadCard$2.INSTANCE);
    }

    public final boolean shouldShow(String str) {
        Intrinsics.checkNotNullParameter(str, "entityUniqueId");
        return Intrinsics.areEqual(this.currentEntityUniqueId, str) && getCard() != null;
    }

    public final void addOnCardChangedCallback(Function2<? super String, ? super Entity, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        this.onCardChangedCallbacks.add(function2);
    }

    public final void removeOnCardChangedCallback(Function2<? super String, ? super Entity, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        this.onCardChangedCallbacks.remove(function2);
    }
}
