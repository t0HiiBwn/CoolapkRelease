package com.coolapk.market.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"safeRegister", "", "Lorg/greenrobot/eventbus/EventBus;", "any", "", "safeUnregister", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: EventBusExtends.kt */
public final class EventBusExtendsKt {
    public static final void safeRegister(EventBus eventBus, Object obj) {
        Intrinsics.checkNotNullParameter(eventBus, "$this$safeRegister");
        Intrinsics.checkNotNullParameter(obj, "any");
        if (!eventBus.isRegistered(obj)) {
            eventBus.register(obj);
        }
    }

    public static final void safeUnregister(EventBus eventBus, Object obj) {
        Intrinsics.checkNotNullParameter(eventBus, "$this$safeUnregister");
        Intrinsics.checkNotNullParameter(obj, "any");
        if (eventBus.isRegistered(obj)) {
            eventBus.unregister(obj);
        }
    }
}
