package com.coolapk.market.view.photo;

import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FileDetail;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: PicAdminDialog.kt */
final class PicAdminDialog$updateList$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ FileDetail $detail;
    final /* synthetic */ PicAdminDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PicAdminDialog$updateList$1(PicAdminDialog picAdminDialog, FileDetail fileDetail) {
        super(1);
        this.this$0 = picAdminDialog;
        this.$detail = fileDetail;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        list.clear();
        boolean z = false;
        boolean z2 = this.$detail.isBlock() == 1;
        if (this.$detail.isForbid() == 1) {
            z = true;
        }
        MultiItemDialogFragmentKt.addItem(list, z2 ? "取消折叠" : "折叠", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass1 */
            final /* synthetic */ PicAdminDialog$updateList$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                DataManager.getInstance().changeFileStatusToBlock(PicAdminDialog.access$getUrl$p(this.this$0.this$0)).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                    /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(String str) {
                        Toast.show$default(this.this$0.this$0.this$0.getActivity(), str, 0, false, 12, null);
                    }
                }, new Action1<Throwable>(this) {
                    /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass1.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(Throwable th) {
                        Toast.error(this.this$0.this$0.this$0.getActivity(), th);
                    }
                });
            }
        });
        MultiItemDialogFragmentKt.addItem(list, z ? "取消禁止上传" : "禁止上传", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass2 */
            final /* synthetic */ PicAdminDialog$updateList$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                DataManager.getInstance().changeFileStatusToFobid(PicAdminDialog.access$getUrl$p(this.this$0.this$0)).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                    /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass2.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass2 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(String str) {
                        Toast.show$default(this.this$0.this$0.this$0.getActivity(), str, 0, false, 12, null);
                    }
                }, new Action1<Throwable>(this) {
                    /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass2.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass2 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(Throwable th) {
                        Toast.error(this.this$0.this$0.this$0.getActivity(), th);
                    }
                });
            }
        });
        MultiItemDialogFragmentKt.addItem(list, "删除动态及回复", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass3 */
            final /* synthetic */ PicAdminDialog$updateList$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                DataManager.getInstance().deleteFeedFromUploadFileLog(PicAdminDialog.access$getUrl$p(this.this$0.this$0)).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                    /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass3.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass3 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(String str) {
                        Toast.show$default(this.this$0.this$0.this$0.getActivity(), str, 0, false, 12, null);
                    }
                }, new Action1<Throwable>(this) {
                    /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass3.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass3 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(Throwable th) {
                        Toast.error(this.this$0.this$0.this$0.getActivity(), th);
                    }
                });
            }
        });
        MultiItemDialogFragmentKt.addItem(list, "查看状态", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.photo.PicAdminDialog$updateList$1.AnonymousClass4 */
            final /* synthetic */ PicAdminDialog$updateList$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                ActionManager.startTextViewActivity(this.this$0.this$0.getActivity(), StringUtils.getModelInfo(this.this$0.$detail.toString()), 12, "feed");
            }
        });
    }
}
