package com.coolapk.market;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÃ\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022(\b\u0002\u0010\u0003\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u0001`\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u0001`\u00052(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u0001`\u00052(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0018\u0001`\u0005¢\u0006\u0002\u0010\t*.\u0010\n\u001a\u0004\b\u0000\u0010\u0002\u001a\u0004\b\u0001\u0010\u0001\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0004¨\u0006\u000b"}, d2 = {"runOnAppMode", "R", "T", "onUniversal", "Lkotlin/Function1;", "Lcom/coolapk/market/OnAppMode;", "onCommunity", "onMarket", "onElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "OnAppMode", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: AppMetadata.kt */
public final class AppMetadataKt {
    public static /* synthetic */ Object runOnAppMode$default(Object obj, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function13 = null;
        }
        if ((i & 8) != 0) {
            function14 = null;
        }
        return runOnAppMode(obj, function1, function12, function13, function14);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    public static final <T, R> R runOnAppMode(T t, Function1<? super T, ? extends R> function1, Function1<? super T, ? extends R> function12, Function1<? super T, ? extends R> function13, Function1<? super T, ? extends R> function14) {
        Object obj;
        String appMode = AppHolder.getAppMetadata().getAppMode();
        if (appMode != null) {
            int hashCode = appMode.hashCode();
            R r = null;
            if (hashCode != -1480249367) {
                if (hashCode != -1081306052) {
                    if (hashCode == -409534901 && appMode.equals("universal")) {
                        if (function1 != null) {
                            obj = function1.invoke(t);
                            if (obj == null) {
                                r = (R) obj;
                            } else if (function14 != null) {
                                r = (R) function14.invoke(t);
                            }
                            if (r == null) {
                                return r;
                            }
                            throw new RuntimeException("Do you miss onElse");
                        }
                    }
                } else if (appMode.equals("market")) {
                    if (function13 != null) {
                        obj = function13.invoke(t);
                        if (obj == null) {
                        }
                        if (r == null) {
                        }
                    }
                }
            } else if (appMode.equals("community")) {
                if (function12 != null) {
                    obj = function12.invoke(t);
                    if (obj == null) {
                    }
                    if (r == null) {
                    }
                }
            }
            obj = null;
            if (obj == null) {
            }
            if (r == null) {
            }
        }
        throw new RuntimeException("Unknown mode " + appMode);
    }
}
