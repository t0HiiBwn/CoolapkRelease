package com.coolapk.market.view.feed.pick;

import android.view.LayoutInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.SearchBackHeaderBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.feed.pick.NodePickDataListFragment;
import com.coolapk.market.view.feed.pick.NodePickRecentListFragment;
import com.coolapk.market.widget.view.TabLayout;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0014¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0011H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u0004 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/feed/pick/NodeRecommendPickerActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "searchKeyWord", "", "searchViewPart", "Lcom/coolapk/market/view/feed/pick/SearchHeaderViewPart;", "subject", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "subscriber", "Lrx/Subscription;", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "inputKeywords", "", "keywords", "onAppThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "onCreateTabs", "", "()[Ljava/lang/String;", "onDestroy", "setupToolbar", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeRecommendPickerActivity.kt */
public final class NodeRecommendPickerActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_INTENT_DATA = "DATA";
    public static final String KEY_INTENT_TYPE = "TYPE";
    private String searchKeyWord;
    private SearchHeaderViewPart searchViewPart;
    private PublishSubject<String> subject = PublishSubject.create();
    private Subscription subscriber;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feed/pick/NodeRecommendPickerActivity$Companion;", "", "()V", "KEY_INTENT_DATA", "", "KEY_INTENT_TYPE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeRecommendPickerActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        String str = this.searchKeyWord;
        if (str == null || str.length() == 0) {
            return new String[]{"最近", "数码", "应用"};
        }
        return new String[]{"综合", "数码", "应用"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        String str = "";
        if (i == 0) {
            NodePickRecentListFragment.Companion companion = NodePickRecentListFragment.Companion;
            String str2 = this.searchKeyWord;
            if (str2 != null) {
                str = str2;
            }
            return companion.newInstance(str, "/member/recentFeedTargetList");
        } else if (i == 1) {
            NodePickDataListFragment.Companion companion2 = NodePickDataListFragment.Companion;
            String str3 = this.searchKeyWord;
            if (str3 != null) {
                str = str3;
            }
            return companion2.newInstance(str, "product", "/product/categoryDetailList?type=category&id=0");
        } else if (i == 2) {
            NodePickDataListFragment.Companion companion3 = NodePickDataListFragment.Companion;
            String str4 = this.searchKeyWord;
            if (str4 != null) {
                str = str4;
            }
            return companion3.newInstance(str, "localApkGame", "/apk/apkStatList?type=today&column=commentnum");
        } else {
            throw new IllegalArgumentException("unknown position " + i);
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected void setupToolbar() {
        Toolbar toolbar = getToolbar();
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewExtendsKt.detachFromParent(toolbar);
        if (this.searchViewPart == null) {
            SearchHeaderViewPart searchHeaderViewPart = new SearchHeaderViewPart(this);
            LayoutInflater from = LayoutInflater.from(this);
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
            searchHeaderViewPart.createView(from, getAppBarLayout());
            searchHeaderViewPart.setOnKeyWords(new NodeRecommendPickerActivity$setupToolbar$1(this));
            getAppBarLayout().addView(searchHeaderViewPart.getView(), 0);
            getAppBarLayout().postDelayed(new NodeRecommendPickerActivity$setupToolbar$2(this, searchHeaderViewPart), 100);
            this.subscriber = this.subject.debounce(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new NodeRecommendPickerActivity$setupToolbar$3(this));
            ((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText.addTextChangedListener(new NodeRecommendPickerActivity$setupToolbar$4(this));
            this.searchViewPart = searchHeaderViewPart;
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        recreate();
    }

    /* access modifiers changed from: private */
    public final void inputKeywords(String str) {
        String str2 = this.searchKeyWord;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String str3 = str;
        if (!Intrinsics.areEqual(str2, StringsKt.trim((CharSequence) str3).toString())) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            this.searchKeyWord = StringsKt.trim((CharSequence) str3).toString();
            getAdapter().notifyDataSetChanged();
            String[] onCreateTabs = onCreateTabs();
            int length = onCreateTabs.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str4 = onCreateTabs[i];
                int i3 = i2 + 1;
                TabLayout.Tab tabAt = getTabLayout().getTabAt(i2);
                if (tabAt != null) {
                    tabAt.setText(str4);
                }
                i++;
                i2 = i3;
            }
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.subscriber;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscriber = null;
    }
}
