package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Intent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.view.dyhv8.DyhIncludActivity;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feedv8/DyhContentHolder;", "Lcom/coolapk/market/view/feedv8/NormalFeedContentHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "shouldSubmitAfterPickTopic", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onSubmitButtonClick", "onSubmitToButtonClick", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhContentHolder.kt */
public final class DyhContentHolder extends NormalFeedContentHolder {
    private boolean shouldSubmitAfterPickTopic;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DyhContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitButtonClick() {
        String str = getUiConfig().topicTitle();
        Intrinsics.checkNotNullExpressionValue(str, "uiConfig.topicTitle()");
        if (str.length() == 0) {
            Toast.show$default(getActivity(), "请选择看看号", 0, false, 12, null);
            this.shouldSubmitAfterPickTopic = true;
            ActionManager.startDyhIncludActivityForResult(getActivity(), 6666);
            return;
        }
        super.onSubmitButtonClick();
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitToButtonClick() {
        super.onSubmitToButtonClick();
        ActionManager.startDyhIncludActivityForResult(getActivity(), 6666);
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 6666) {
            String result = DyhIncludActivity.Companion.getResult(intent);
            if (result != null) {
                FeedUIConfig build = FeedUIConfig.builder(getUiConfig()).submitToText(result).build();
                Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(uiC…                 .build()");
                updateUiConfig$presentation_coolapkAppRelease(build);
                if (this.shouldSubmitAfterPickTopic) {
                    onSubmitButtonClick();
                    this.shouldSubmitAfterPickTopic = false;
                    return;
                }
                return;
            }
            return;
        }
        this.shouldSubmitAfterPickTopic = false;
    }
}
