package com.coolapk.market.view.goodsList;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.event.GoodsDeleteEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
final class GoodGoodsEditListFragment$onActivityCreated$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ GoodGoodsEditListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodGoodsEditListFragment$onActivityCreated$2(GoodGoodsEditListFragment goodGoodsEditListFragment) {
        super(1);
        this.this$0 = goodGoodsEditListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        if (CollectionUtils.safeSize(this.this$0.delList) < 1) {
            Toast.show$default(this.this$0.getActivity(), "没有选择任何好物", 0, false, 12, null);
            return;
        }
        final SimpleDialog newInstance = SimpleDialog.newInstance();
        newInstance.setMessage("确定要移除" + this.this$0.delList.size() + "个好物吗？");
        newInstance.setPositiveButton(2131886708, new DialogInterface.OnClickListener(this) {
            /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass1 */
            final /* synthetic */ GoodGoodsEditListFragment$onActivityCreated$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (CollectionUtils.isEmpty(this.this$0.this$0.delList) || CollectionUtils.safeSize(this.this$0.this$0.delList) == 0) {
                    dialogInterface.dismiss();
                }
                StringBuilder sb = new StringBuilder();
                if (!this.this$0.this$0.delList.isEmpty()) {
                    int i2 = 0;
                    for (GoodsListItem goodsListItem : this.this$0.this$0.delList) {
                        sb.append(goodsListItem.getProductGoodsId());
                        if (i2 >= this.this$0.this$0.delList.size() - 1) {
                            break;
                        }
                        sb.append(",");
                        i2++;
                    }
                }
                Observable.from(this.this$0.this$0.delList).map(new Func1<GoodsListItem, GoodsListItem>(this) {
                    /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final GoodsListItem call(final GoodsListItem goodsListItem) {
                        this.this$0.this$0.this$0.requireActivity().runOnUiThread(new Runnable(this) {
                            /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.this$0.this$0.this$0.this$0.getDataList().remove(goodsListItem);
                                EventBus eventBus = EventBus.getDefault();
                                GoodsListItem goodsListItem = goodsListItem;
                                Intrinsics.checkNotNullExpressionValue(goodsListItem, "it");
                                eventBus.post(new GoodsDeleteEvent(goodsListItem));
                            }
                        });
                        return goodsListItem;
                    }
                }).flatMap(new Func1<GoodsListItem, Observable<? extends Result<String>>>(this) {
                    /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass1.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Observable<? extends Result<String>> call(GoodsListItem goodsListItem) {
                        DataManager instance = DataManager.getInstance();
                        String id = this.this$0.this$0.this$0.getFeed().getId();
                        Intrinsics.checkNotNullExpressionValue(goodsListItem, "it");
                        return instance.deleteGoods(id, goodsListItem.getProductGoodsId());
                    }
                }).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                    /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass1.AnonymousClass3 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(String str) {
                        Toast.show$default(this.this$0.this$0.this$0.getActivity(), str, 0, false, 12, null);
                    }
                }, new Action1<Throwable>(this) {
                    /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass1.AnonymousClass4 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(Throwable th) {
                        Toast.error(this.this$0.this$0.this$0.getActivity(), th);
                    }
                }, new Action0(this) {
                    /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass1.AnonymousClass5 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // rx.functions.Action0
                    public final void call() {
                        this.this$0.this$0.this$0.delList.clear();
                        this.this$0.this$0.this$0.delListChange();
                    }
                });
            }
        });
        newInstance.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onActivityCreated$2.AnonymousClass2 */

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                newInstance.dismiss();
            }
        });
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }
}
