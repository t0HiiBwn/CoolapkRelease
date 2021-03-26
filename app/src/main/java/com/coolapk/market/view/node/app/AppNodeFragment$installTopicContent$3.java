package com.coolapk.market.view.node.app;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.node.BaseNodePageActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$installTopicContent$3 implements Runnable {
    final /* synthetic */ BaseNodePageActivity $behavior;
    final /* synthetic */ ServiceApp $data;
    final /* synthetic */ ArrayList $tabApiList;
    final /* synthetic */ AppNodeFragment this$0;

    AppNodeFragment$installTopicContent$3(AppNodeFragment appNodeFragment, ServiceApp serviceApp, ArrayList arrayList, BaseNodePageActivity baseNodePageActivity) {
        this.this$0 = appNodeFragment;
        this.$data = serviceApp;
        this.$tabApiList = arrayList;
        this.$behavior = baseNodePageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        List list = this.this$0.getConfigList();
        if (list == null || (str = EntityExtendsKt.findValueFromUrlClientConfig(list, "selectedTab")) == null) {
            str = this.$data.getSelectedTab();
        }
        int i = 0;
        Iterator it2 = this.$tabApiList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            ConfigPage configPage = (ConfigPage) it2.next();
            Intrinsics.checkNotNullExpressionValue(configPage, "it");
            if (Intrinsics.areEqual(configPage.getPageName(), str)) {
                break;
            }
            i++;
        }
        this.$behavior.installFloatingView(this.$tabApiList, i, new Function1<ConfigPage, EntityListFragment>(this) {
            /* class com.coolapk.market.view.node.app.AppNodeFragment$installTopicContent$3.AnonymousClass1 */
            final /* synthetic */ AppNodeFragment$installTopicContent$3 this$0;

            {
                this.this$0 = r1;
            }

            public final EntityListFragment invoke(ConfigPage configPage) {
                Intrinsics.checkNotNullParameter(configPage, "config");
                if (Intrinsics.areEqual(configPage.getUrl(), "#/apk/detail")) {
                    return AppDetailListFragment.Companion.newInstance(this.this$0.$data);
                }
                AppNodeListFragment newInstance = AppNodeListFragment.Companion.newInstance(configPage);
                newInstance.setPresenter(this.this$0.this$0.getPresenter());
                newInstance.setViewModel(this.this$0.this$0.getViewModel());
                return newInstance;
            }
        }, null);
    }
}
