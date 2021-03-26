package com.coolapk.market.view.message;

import android.app.Application;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.MessageTopTipBinding;
import com.coolapk.market.event.ContactsEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$onShowTip$1 implements View.OnClickListener {
    final /* synthetic */ MessageTopTipBinding $binding;
    final /* synthetic */ FrameLayout $contentView;
    final /* synthetic */ ChatListFragment this$0;

    ChatListFragment$onShowTip$1(ChatListFragment chatListFragment, FrameLayout frameLayout, MessageTopTipBinding messageTopTipBinding) {
        this.this$0 = chatListFragment;
        this.$contentView = frameLayout;
        this.$binding = messageTopTipBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append("是否关注用户『");
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        sb.append(requireActivity.getTitle());
        sb.append("』？关注对方即可让TA与你无限制聊天");
        ConfirmDialog newInstance = ConfirmDialog.newInstance("", sb.toString(), "确认关注", "取消");
        newInstance.setOnOkRunnable(new Runnable(this) {
            /* class com.coolapk.market.view.message.ChatListFragment$onShowTip$1.AnonymousClass1 */
            final /* synthetic */ ChatListFragment$onShowTip$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DataManager.getInstance().followUser(this.this$0.this$0.getUserId()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<Integer>>(this) {
                    /* class com.coolapk.market.view.message.ChatListFragment$onShowTip$1.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.this$0 = r1;
                    }

                    public void onNext(Result<Integer> result) {
                        Intrinsics.checkNotNullParameter(result, "integerResult");
                        super.onNext((AnonymousClass1) result);
                        if (result.isSuccess()) {
                            Toast.show$default(this.this$0.this$0.this$0.getActivity(), "关注成功", 0, false, 12, null);
                            EventBus.getDefault().post(new ContactsEvent(true, this.this$0.this$0.this$0.getUserId()));
                            FrameLayout frameLayout = this.this$0.this$0.$contentView;
                            MessageTopTipBinding messageTopTipBinding = this.this$0.this$0.$binding;
                            Intrinsics.checkNotNullExpressionValue(messageTopTipBinding, "binding");
                            frameLayout.removeView(messageTopTipBinding.getRoot());
                            return;
                        }
                        Application application = AppHolder.getApplication();
                        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
                        Toast.show(application, 2131886739);
                    }
                });
            }
        });
        FragmentActivity requireActivity2 = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }
}
