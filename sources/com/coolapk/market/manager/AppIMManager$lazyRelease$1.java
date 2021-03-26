package com.coolapk.market.manager;

import com.coolapk.market.util.LogUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.coolapk.market.manager.AppIMManager$lazyRelease$1", f = "AppIMManager.kt", i = {0}, l = {83, 90, 101}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: AppIMManager.kt */
final class AppIMManager$lazyRelease$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppIMManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppIMManager$lazyRelease$1(AppIMManager appIMManager, Continuation continuation) {
        super(2, continuation);
        this.this$0 = appIMManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        AppIMManager$lazyRelease$1 appIMManager$lazyRelease$1 = new AppIMManager$lazyRelease$1(this.this$0, continuation);
        appIMManager$lazyRelease$1.L$0 = obj;
        return appIMManager$lazyRelease$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppIMManager$lazyRelease$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            long millis = TimeUnit.MINUTES.toMillis(5);
            LogUtils.d("[lazyRelease] 等待" + (millis / ((long) 1000)) + "秒后反初始化IM", new Object[0]);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(millis, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.this$0.unbindListener();
            if (this.this$0.isLogin()) {
                LogUtils.d("[lazyRelease] 退出登录", new Object[0]);
                AppIMManager appIMManager = this.this$0;
                this.L$0 = null;
                this.label = 3;
                if (appIMManager.logout(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            LogUtils.d("[lazyRelease] 反初始化", new Object[0]);
            V2TIMManager.getInstance().unInitSDK();
            return Unit.INSTANCE;
        } else if (i == 3) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            LogUtils.d("[lazyRelease] 反初始化", new Object[0]);
            V2TIMManager.getInstance().unInitSDK();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (CoroutineScopeKt.isActive(coroutineScope) && this.this$0.isInit()) {
            this.this$0.isInit = false;
            AppIMManager appIMManager2 = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (appIMManager2.quitAllGroup(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.this$0.unbindListener();
            if (this.this$0.isLogin()) {
            }
            LogUtils.d("[lazyRelease] 反初始化", new Object[0]);
            V2TIMManager.getInstance().unInitSDK();
        }
        return Unit.INSTANCE;
    }
}
