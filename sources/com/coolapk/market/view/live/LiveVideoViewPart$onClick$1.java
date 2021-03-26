package com.coolapk.market.view.live;

import android.content.DialogInterface;
import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Live;
import com.coolapk.market.util.FloatWindowUtil;
import com.coolapk.market.util.SettingsCompat;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.live.LiveContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final class LiveVideoViewPart$onClick$1 implements PopupMenu.OnMenuItemClickListener {
    final /* synthetic */ MenuItem $banPost;
    final /* synthetic */ MenuItem $banPostPic;
    final /* synthetic */ Live $live;
    final /* synthetic */ MenuItem $liveStatus;
    final /* synthetic */ LiveVideoViewPart this$0;

    LiveVideoViewPart$onClick$1(LiveVideoViewPart liveVideoViewPart, MenuItem menuItem, Live live, MenuItem menuItem2, MenuItem menuItem3) {
        this.this$0 = liveVideoViewPart;
        this.$banPost = menuItem;
        this.$live = live;
        this.$banPostPic = menuItem2;
        this.$liveStatus = menuItem3;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullExpressionValue(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 2131361864:
                SimpleDialog newInstance = SimpleDialog.newInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("确认");
                MenuItem menuItem2 = this.$banPost;
                Intrinsics.checkNotNullExpressionValue(menuItem2, "banPost");
                sb.append(menuItem2.getTitle());
                sb.append("吗？");
                newInstance.setMessage(sb.toString());
                newInstance.setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
                    /* class com.coolapk.market.view.live.LiveVideoViewPart$onClick$1.AnonymousClass1 */
                    final /* synthetic */ LiveVideoViewPart$onClick$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        boolean canPost = this.this$0.$live.canPost();
                        LiveContract.Presenter presenter = this.this$0.this$0.getViewModel().getPresenter();
                        String id = this.this$0.$live.getId();
                        Intrinsics.checkNotNull(id);
                        Intrinsics.checkNotNullExpressionValue(id, "live.id!!");
                        presenter.banAllPost(id, canPost);
                    }
                });
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.this$0.getActivity()).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                break;
            case 2131361865:
                SimpleDialog newInstance2 = SimpleDialog.newInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("确认");
                MenuItem menuItem3 = this.$banPostPic;
                Intrinsics.checkNotNullExpressionValue(menuItem3, "banPostPic");
                sb2.append(menuItem3.getTitle());
                sb2.append("吗？");
                newInstance2.setMessage(sb2.toString());
                newInstance2.setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
                    /* class com.coolapk.market.view.live.LiveVideoViewPart$onClick$1.AnonymousClass2 */
                    final /* synthetic */ LiveVideoViewPart$onClick$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        boolean canPostPic = this.this$0.$live.canPostPic();
                        LiveContract.Presenter presenter = this.this$0.this$0.getViewModel().getPresenter();
                        String id = this.this$0.$live.getId();
                        Intrinsics.checkNotNull(id);
                        Intrinsics.checkNotNullExpressionValue(id, "live.id!!");
                        presenter.banAllPostPic(id, canPostPic);
                    }
                });
                FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(this.this$0.getActivity()).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.requireAppCompa…().supportFragmentManager");
                newInstance2.show(supportFragmentManager2, (String) null);
                break;
            case 2131361866:
                String id = this.$live.getId();
                Intrinsics.checkNotNull(id);
                ActionManager.startLiveBannedUserTabActivity(this.this$0.getActivity(), id);
                break;
            case 2131361907:
                if (SettingsCompat.canDrawOverlays(this.this$0.getActivity())) {
                    this.this$0.enterFloatingWindow();
                    break;
                } else {
                    FloatWindowUtil.INSTANCE.showNeedFloatingPermissionDialog(this.this$0.getActivity());
                    break;
                }
            case 2131361919:
                SimpleDialog newInstance3 = SimpleDialog.newInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("确认");
                MenuItem menuItem4 = this.$liveStatus;
                Intrinsics.checkNotNullExpressionValue(menuItem4, "liveStatus");
                sb3.append(menuItem4.getTitle());
                sb3.append("吗？");
                newInstance3.setMessage(sb3.toString());
                newInstance3.setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
                    /* class com.coolapk.market.view.live.LiveVideoViewPart$onClick$1.AnonymousClass3 */
                    final /* synthetic */ LiveVideoViewPart$onClick$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        int liveStatus = this.this$0.$live.getLiveStatus();
                        int i2 = 1;
                        if (liveStatus == -1) {
                            i2 = 0;
                        } else if (liveStatus == 1) {
                            i2 = -1;
                        }
                        LiveContract.Presenter presenter = this.this$0.this$0.getViewModel().getPresenter();
                        String id = this.this$0.$live.getId();
                        Intrinsics.checkNotNull(id);
                        Intrinsics.checkNotNullExpressionValue(id, "live.id!!");
                        presenter.changeLiveStatus(id, i2);
                    }
                });
                FragmentManager supportFragmentManager3 = ContextExtendsKt.requireAppCompatActivity(this.this$0.getActivity()).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "activity.requireAppCompa…().supportFragmentManager");
                newInstance3.show(supportFragmentManager3, (String) null);
                break;
            case 2131361981:
                String sourceUrl = this.this$0.data.getSourceUrl();
                if (sourceUrl.length() > 0) {
                    ActionManagerCompat.startActivityByUrl$default(this.this$0.getActivity(), sourceUrl, null, null, 12, null);
                    break;
                }
                break;
        }
        return true;
    }
}
