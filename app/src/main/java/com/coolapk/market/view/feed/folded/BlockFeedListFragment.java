package com.coolapk.market.view.feed.folded;

import android.os.Bundle;
import com.coolapk.market.view.cardlist.CompatFeedListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/folded/BlockFeedListFragment;", "Lcom/coolapk/market/view/cardlist/CompatFeedListFragment;", "()V", "listType", "", "tagItem", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setPresenter", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlockFeedListFragment.kt */
public final class BlockFeedListFragment extends CompatFeedListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_COMMENT_LIST = "TYPE_COMMENT_LIST";
    public static final String TYPE_FEED_LIST = "TYPE_FEED_LIST";
    public static final String TYPE_PHONE_TAG_LIST = "TYPE_PHONE_TAG_LIST";
    public static final String TYPE_TAG_LIST = "TYPE_TAG_LIST";
    private String listType;
    private String tagItem;

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tagItem = requireArguments().getString("tag");
        String string = requireArguments().getString("listType");
        this.listType = string;
        setPresenter(string);
    }

    private final void setPresenter(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 380987267:
                    if (str.equals("TYPE_COMMENT_LIST")) {
                        setPresenter(new BlockFeedPresenter(this, this.tagItem, "TYPE_COMMENT_LIST"));
                        return;
                    }
                    return;
                case 1464296872:
                    if (str.equals("TYPE_TAG_LIST")) {
                        setPresenter(new BlockFeedPresenter(this, this.tagItem, "TYPE_TAG_LIST"));
                        return;
                    }
                    return;
                case 1948944825:
                    if (str.equals("TYPE_PHONE_TAG_LIST")) {
                        setPresenter(new BlockFeedPresenter(this, this.tagItem, "TYPE_PHONE_TAG_LIST"));
                        return;
                    }
                    return;
                case 2123995098:
                    if (str.equals("TYPE_FEED_LIST")) {
                        setPresenter(new BlockFeedPresenter(this, this.tagItem, "TYPE_FEED_LIST"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/folded/BlockFeedListFragment$Companion;", "", "()V", "TYPE_COMMENT_LIST", "", "TYPE_FEED_LIST", "TYPE_PHONE_TAG_LIST", "TYPE_TAG_LIST", "newInstance", "Lcom/coolapk/market/view/feed/folded/BlockFeedListFragment;", "tag", "listType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BlockFeedListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BlockFeedListFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "listType");
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            bundle.putString("listType", str2);
            BlockFeedListFragment blockFeedListFragment = new BlockFeedListFragment();
            blockFeedListFragment.setArguments(bundle);
            return blockFeedListFragment;
        }
    }
}
