package com.coolapk.market.extend;

import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.XXPermissions;
import java.util.List;
import kotlin.Metadata;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\u0016\u0012\u0014 \u0006*\t\u0018\u00010\u0004¢\u0006\u0002\b\u00050\u0004¢\u0006\u0002\b\u0005 \u0006*\u001c\u0012\u0016\u0012\u0014 \u0006*\t\u0018\u00010\u0004¢\u0006\u0002\b\u00050\u0004¢\u0006\u0002\b\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "emitter", "Lrx/Emitter;", "", "Lorg/jetbrains/annotations/NotNull;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LibraryExtents.kt */
final class LibraryExtentsKt$asObservable$1<T> implements Action1<Emitter<Boolean>> {
    final /* synthetic */ XXPermissions $this_asObservable;

    LibraryExtentsKt$asObservable$1(XXPermissions xXPermissions) {
        this.$this_asObservable = xXPermissions;
    }

    public final void call(final Emitter<Boolean> emitter) {
        this.$this_asObservable.request(new OnPermissionCallback() {
            /* class com.coolapk.market.extend.LibraryExtentsKt$asObservable$1.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: rx.Emitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.hjq.permissions.OnPermissionCallback
            public void onDenied(List<String> list, boolean z) {
                emitter.onNext(false);
                emitter.onCompleted();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: rx.Emitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.hjq.permissions.OnPermissionCallback
            public void onGranted(List<String> list, boolean z) {
                emitter.onNext(true);
                emitter.onCompleted();
            }
        });
    }
}
