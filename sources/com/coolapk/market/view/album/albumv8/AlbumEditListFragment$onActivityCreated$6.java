package com.coolapk.market.view.album.albumv8;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.event.AlbumItemAddDelEvent;
import com.coolapk.market.event.AlbumItemEditEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.widget.Toast;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumEditListFragment.kt */
final class AlbumEditListFragment$onActivityCreated$6 implements View.OnClickListener {
    final /* synthetic */ AlbumEditListFragment this$0;

    AlbumEditListFragment$onActivityCreated$6(AlbumEditListFragment albumEditListFragment) {
        this.this$0 = albumEditListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) null;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        if (CollectionUtils.safeSize(this.this$0.delList) < 1) {
            Toast.show$default(this.this$0.getActivity(), "没有选择任何app", 0, false, 12, null);
            return;
        }
        SimpleDialog newInstance = SimpleDialog.newInstance();
        newInstance.setMessage("确定要移除" + this.this$0.delList.size() + "个应用吗？");
        newInstance.setPositiveButton(2131886770, new DialogInterface.OnClickListener(this) {
            /* class com.coolapk.market.view.album.albumv8.AlbumEditListFragment$onActivityCreated$6.AnonymousClass1 */
            final /* synthetic */ AlbumEditListFragment$onActivityCreated$6 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (CollectionUtils.isEmpty(this.this$0.this$0.delList) || CollectionUtils.safeSize(this.this$0.this$0.delList) == 0) {
                    dialogInterface.dismiss();
                }
                Album album = this.this$0.this$0.mAlbum;
                Integer num = null;
                List<AlbumItem> albumItems = album != null ? album.getAlbumItems() : null;
                Iterator it2 = this.this$0.this$0.delList.iterator();
                while (it2.hasNext()) {
                    AlbumItem albumItem = (AlbumItem) it2.next();
                    if (albumItems != null) {
                        albumItems.remove(albumItem);
                    }
                }
                AlbumEditListFragment albumEditListFragment = this.this$0.this$0;
                Album.Builder newBuilder = Album.newBuilder(this.this$0.this$0.mAlbum);
                Album album2 = this.this$0.this$0.mAlbum;
                if (album2 != null) {
                    num = Integer.valueOf(album2.getTotalApkNum());
                }
                Intrinsics.checkNotNull(num);
                albumEditListFragment.mAlbum = newBuilder.totalApkNum(num.intValue() - this.this$0.this$0.delList.size()).albumItems(albumItems).build();
                final ProgressDialog progressDialog = new ProgressDialog(this.this$0.this$0.getActivity());
                progressDialog.setProgressStyle(0);
                progressDialog.setCancelable(false);
                progressDialog.show();
                progressDialog.setMessage("正在移除第1个App...");
                Observable.from(this.this$0.this$0.delList).map(new Func1<AlbumItem, AlbumItem>(this) {
                    /* class com.coolapk.market.view.album.albumv8.AlbumEditListFragment$onActivityCreated$6.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.coolapk.market.model.AlbumItem */
                    /* JADX WARN: Multi-variable type inference failed */
                    public final AlbumItem call(AlbumItem albumItem) {
                        objectRef.element = albumItem;
                        return albumItem;
                    }
                }).onBackpressureBuffer((long) this.this$0.this$0.delList.size()).flatMap(new Func1<AlbumItem, Observable<? extends Result<String>>>(this) {
                    /* class com.coolapk.market.view.album.albumv8.AlbumEditListFragment$onActivityCreated$6.AnonymousClass1.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Observable<? extends Result<String>> call(final AlbumItem albumItem) {
                        this.this$0.this$0.this$0.requireActivity().runOnUiThread(new Runnable(this) {
                            /* class com.coolapk.market.view.album.albumv8.AlbumEditListFragment$onActivityCreated$6.AnonymousClass1.AnonymousClass2.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass2 this$0;

                            {
                                this.this$0 = r1;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.this$0.this$0.this$0.this$0.dataList.remove(albumItem);
                                EventBus.getDefault().post(new AlbumItemAddDelEvent(albumItem, false));
                                ProgressDialog progressDialog = progressDialog;
                                progressDialog.setMessage("正在移除第" + intRef.element + "个App...");
                                Ref.IntRef intRef = intRef;
                                intRef.element = intRef.element + 1;
                            }
                        });
                        DataManager instance = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(albumItem, "albumItem");
                        return instance.delApkFromAlbum(albumItem.getAlbumId(), albumItem.getPackageName());
                    }
                }).compose(RxUtils.applyIOSchedulers()).subscribe(AnonymousClass3.INSTANCE, new Action1<Throwable>(this) {
                    /* class com.coolapk.market.view.album.albumv8.AlbumEditListFragment$onActivityCreated$6.AnonymousClass1.AnonymousClass4 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(Throwable th) {
                        Toast.error(this.this$0.this$0.this$0.getActivity(), th);
                        progressDialog.dismiss();
                    }
                }, new Action0(this) {
                    /* class com.coolapk.market.view.album.albumv8.AlbumEditListFragment$onActivityCreated$6.AnonymousClass1.AnonymousClass5 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // rx.functions.Action0
                    public final void call() {
                        progressDialog.dismiss();
                        Toast.show$default(this.this$0.this$0.this$0.getActivity(), "移除成功", 0, false, 12, null);
                        this.this$0.this$0.this$0.delList.clear();
                        this.this$0.this$0.this$0.delListChange();
                        EventBus.getDefault().post(new AlbumItemEditEvent(objectRef.element, "order"));
                        if (CollectionUtils.safeSize(this.this$0.this$0.this$0.dataList) == 1 && (this.this$0.this$0.this$0.dataList.get(0) instanceof Album)) {
                            this.this$0.this$0.this$0.dataList.add(Album.newBuilder(this.this$0.this$0.this$0.mAlbum).entityTemplate("albumEmpty").build());
                        }
                    }
                });
            }
        });
        newInstance.setNegativeButton(2131886768, AnonymousClass2.INSTANCE);
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        newInstance.show(childFragmentManager, (String) null);
    }
}
