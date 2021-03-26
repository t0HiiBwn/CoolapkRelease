package com.coolapk.market.extend;

import com.hjq.permissions.XXPermissions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\r\u0012\t\u0012\u00070\u0002¢\u0006\u0002\b\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"asObservable", "Lrx/Observable;", "", "Lorg/jetbrains/annotations/NotNull;", "Lcom/hjq/permissions/XXPermissions;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: LibraryExtents.kt */
public final class LibraryExtentsKt {
    public static final Observable<Boolean> asObservable(XXPermissions xXPermissions) {
        Intrinsics.checkNotNullParameter(xXPermissions, "$this$asObservable");
        Observable<Boolean> create = Observable.create(new LibraryExtentsKt$asObservable$1(xXPermissions), Emitter.BackpressureMode.LATEST);
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create({ emit….BackpressureMode.LATEST)");
        return create;
    }
}
