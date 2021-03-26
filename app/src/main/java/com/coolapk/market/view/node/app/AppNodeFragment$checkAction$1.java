package com.coolapk.market.view.node.app;

import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.State;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/node/app/AppNodeFragment$checkAction$1", "Lcom/coolapk/market/model/ClickInfo$DownloadOnlyClickHandleAdapter;", "onClickHandleDownload", "", "state", "Lcom/coolapk/market/model/State;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
public final class AppNodeFragment$checkAction$1 extends ClickInfo.DownloadOnlyClickHandleAdapter {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppNodeFragment$checkAction$1(AppNodeFragment appNodeFragment) {
        this.this$0 = appNodeFragment;
    }

    @Override // com.coolapk.market.model.ClickInfo.DownloadOnlyClickHandleAdapter, com.coolapk.market.model.ClickInfo.ClickHandleListener
    public boolean onClickHandleDownload(State state) {
        Toast.show$default(this.this$0.getActivity(), "正在下载…", 0, false, 12, null);
        return super.onClickHandleDownload(state);
    }
}
