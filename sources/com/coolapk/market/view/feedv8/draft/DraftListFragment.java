package com.coolapk.market.view.feedv8.draft;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedRoughDraftBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.base.refresh.LocalMultiTypeFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0006\u0010\u001a\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/feedv8/draft/DraftListFragment;", "Lcom/coolapk/market/view/base/refresh/LocalMultiTypeFragment;", "Lcom/coolapk/market/view/feedv8/draft/RoughDraft;", "()V", "showingSnackBar", "Lcom/google/android/material/snackbar/Snackbar;", "getShowingSnackBar", "()Lcom/google/android/material/snackbar/Snackbar;", "setShowingSnackBar", "(Lcom/google/android/material/snackbar/Snackbar;)V", "clearAllDraft", "", "initData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "reloadData", "FeedRoughDraftViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DraftListFragment.kt */
public final class DraftListFragment extends LocalMultiTypeFragment<RoughDraft> {
    private Snackbar showingSnackBar;

    public final Snackbar getShowingSnackBar() {
        return this.showingSnackBar;
    }

    public final void setShowingSnackBar(Snackbar snackbar) {
        this.showingSnackBar = snackbar;
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        getDataList().addAll(RoughDraftHelper.Companion.getInstance().getRoughDraftList());
        updateContentUI();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalMultiTypeFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        setEmptyData(getString(2131886827), 0);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558729).suitedClass(RoughDraft.class).constructor(new DraftListFragment$onActivityCreated$1(new FragmentBindingComponent(this))).build(), 0, 2, null);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator);
        Intrinsics.checkNotNullExpressionValue(itemAnimator, "recyclerView.itemAnimator!!");
        itemAnimator.setChangeDuration(300);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView2.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator2);
        Intrinsics.checkNotNullExpressionValue(itemAnimator2, "recyclerView.itemAnimator!!");
        itemAnimator2.setMoveDuration(300);
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView3.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator3);
        Intrinsics.checkNotNullExpressionValue(itemAnimator3, "recyclerView.itemAnimator!!");
        itemAnimator3.setAddDuration(300);
        RecyclerView recyclerView4 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator4 = recyclerView4.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator4);
        Intrinsics.checkNotNullExpressionValue(itemAnimator4, "recyclerView.itemAnimator!!");
        itemAnimator4.setRemoveDuration(300);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        reloadData();
    }

    public final void reloadData() {
        setNotifyAdapter(false);
        getDataList().clear();
        initData();
        getAdapter().notifyDataSetChanged();
        setNotifyAdapter(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        MenuItem add;
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded() && (add = menu.add(0, 2131361892, 0, getString(2131886713))) != null) {
            add.setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361892) {
            return true;
        }
        String string = getString(2131886713);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_clear_rough_draft)");
        String string2 = getString(2131886714);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_c…_rough_draft_description)");
        ConfirmDialog newInstance = ConfirmDialog.newInstance(string, string2);
        newInstance.setOnOkRunnable(new DraftListFragment$onOptionsItemSelected$1(this));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        newInstance.show(childFragmentManager, (String) null);
        return true;
    }

    /* access modifiers changed from: private */
    public final void clearAllDraft() {
        RoughDraftHelper.Companion.getInstance().clearAll();
        reloadData();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/feedv8/draft/DraftListFragment$FeedRoughDraftViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;)V", "bindTo", "", "data", "", "showActionPopMenu", "roughDraft", "Lcom/coolapk/market/view/feedv8/draft/RoughDraft;", "view", "showDeleteSnackBar", "startSubmitFeedV8ActivityForForwardFeed", "fragment", "Lcom/coolapk/market/view/feedv8/draft/DraftListFragment;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DraftListFragment.kt */
    private static final class FeedRoughDraftViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558729;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedRoughDraftViewHolder(View view, FragmentBindingComponent fragmentBindingComponent) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
            if (r7.equals("url") != false) goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b9, code lost:
            if (r7.equals("discovery") != false) goto L_0x00ef;
         */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x01be  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x01cc  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x01d8  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x01dd  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x01e3  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x01ef  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x01f8  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x0258  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x026c  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x028c  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x010b  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0152  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0161  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x017a  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0180  */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            String str;
            boolean z;
            boolean z2;
            String str2;
            String str3;
            int i;
            ItemFeedRoughDraftBinding itemFeedRoughDraftBinding = (ItemFeedRoughDraftBinding) getBinding();
            DataBindingComponent component = getComponent();
            String str4 = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof DraftListFragment)) {
                fragment = null;
            }
            DraftListFragment draftListFragment = (DraftListFragment) fragment;
            if (draftListFragment != null) {
                Object obj2 = obj;
                if (!(obj2 instanceof RoughDraft)) {
                    obj2 = null;
                }
                RoughDraft roughDraft = (RoughDraft) obj2;
                if (roughDraft != null) {
                    FeedMultiPart multiPart = roughDraft.getMultiPart();
                    String str5 = null;
                    String type = multiPart.type();
                    String str6 = "分享";
                    boolean z3 = true;
                    int i2 = 0;
                    if (type != null) {
                        switch (type.hashCode()) {
                            case -1412808770:
                                if (type.equals("answer")) {
                                    str6 = "回答";
                                    break;
                                }
                                break;
                            case -1294612184:
                                if (type.equals("ershou")) {
                                    str6 = "二手";
                                    break;
                                }
                                break;
                            case -1165870106:
                                if (type.equals("question")) {
                                    str6 = "提问";
                                    break;
                                }
                                break;
                            case -938102371:
                                if (type.equals("rating")) {
                                    str6 = "点评";
                                    break;
                                }
                                break;
                            case -577741570:
                                if (type.equals("picture")) {
                                    str6 = "酷图";
                                    break;
                                }
                                break;
                            case -121207376:
                                break;
                            case 116079:
                                break;
                            case 3138974:
                                if (type.equals("feed")) {
                                    if (!multiPart.isHtmlArticle()) {
                                        String forwardId = multiPart.forwardId();
                                        Intrinsics.checkNotNullExpressionValue(forwardId, "multiPart.forwardId()");
                                        if (!(forwardId.length() > 0)) {
                                            str6 = "动态";
                                            break;
                                        } else {
                                            str6 = "转发";
                                            break;
                                        }
                                    } else {
                                        str6 = "图文";
                                        break;
                                    }
                                }
                                break;
                            case 3625706:
                                if (type.equals("vote")) {
                                    str6 = "投票";
                                    break;
                                }
                                break;
                            case 950398559:
                                if (type.equals("comment")) {
                                    str6 = "评论";
                                    break;
                                }
                                break;
                            case 1408890901:
                                if (type.equals("voteComment")) {
                                    str6 = "观点";
                                    break;
                                }
                                break;
                        }
                        TextView textView = itemFeedRoughDraftBinding.typeView;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.typeView");
                        textView.setText(StringsKt.trim((CharSequence) str6).toString());
                        if (!multiPart.isHtmlArticle()) {
                            ArticleModel.Companion companion = ArticleModel.Companion;
                            String message = multiPart.message();
                            Intrinsics.checkNotNullExpressionValue(message, "multiPart.message()");
                            ArticleModel articleModel = (ArticleModel) CollectionsKt.getOrNull(companion.fromJson(message), 0);
                            if (articleModel != null) {
                                if (!(articleModel instanceof ArticleNative)) {
                                    articleModel = null;
                                }
                                ArticleNative articleNative = (ArticleNative) articleModel;
                                if (articleNative != null) {
                                    str4 = articleNative.getText();
                                }
                            }
                        } else {
                            str4 = multiPart.message();
                        }
                        AppTheme appTheme = AppHolder.getAppTheme();
                        str = str4;
                        z = str != null || str.length() == 0;
                        int textColorTertiary = appTheme.getTextColorTertiary();
                        int textColorPrimary = appTheme.getTextColorPrimary();
                        if (!z) {
                            textColorTertiary = textColorPrimary;
                        }
                        if (str != null || str.length() == 0) {
                            str4 = "无正文";
                        }
                        TextView textView2 = itemFeedRoughDraftBinding.textView;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
                        textView2.setText(str4);
                        itemFeedRoughDraftBinding.textView.setTextColor(textColorTertiary);
                        if (!multiPart.isHtmlArticle()) {
                            str2 = multiPart.messageTitle();
                        } else if (Intrinsics.areEqual(multiPart.type(), "answer")) {
                            str2 = roughDraft.getUiConfig().questionTitle();
                        } else if (Intrinsics.areEqual(multiPart.type(), "question")) {
                            str2 = multiPart.messageTitle();
                        } else if (Intrinsics.areEqual(multiPart.type(), "ershou")) {
                            str2 = multiPart.messageTitle();
                        } else {
                            str2 = str5;
                            z2 = false;
                            TextView textView3 = itemFeedRoughDraftBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                            textView3.setVisibility(z2 ? 0 : 8);
                            TextView textView4 = itemFeedRoughDraftBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
                            str3 = str2;
                            textView4.setText(str3 != null || str3.length() == 0 ? "无标题" : str3);
                            if (str3 != null || str3.length() == 0) {
                                i = AppHolder.getAppTheme().getTextColorTertiary();
                            } else {
                                i = AppHolder.getAppTheme().getTextColorPrimary();
                            }
                            itemFeedRoughDraftBinding.titleView.setTextColor(i);
                            Intrinsics.checkNotNullExpressionValue(itemFeedRoughDraftBinding, "binding");
                            View root = itemFeedRoughDraftBinding.getRoot();
                            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                            ViewExtendsKt.setUtilClickListener(root, new DraftListFragment$FeedRoughDraftViewHolder$bindTo$1(this, multiPart, roughDraft, draftListFragment));
                            TextView textView5 = itemFeedRoughDraftBinding.timeView;
                            Intrinsics.checkNotNullExpressionValue(textView5, "binding.timeView");
                            textView5.setText("编辑于" + DateUtils.getTimeDescription(getContext(), Long.valueOf(roughDraft.getCreateTime() / ((long) 1000))));
                            if (multiPart.imageUriList().size() > 0) {
                                ImageUrl imageUrl = multiPart.imageUriList().get(0);
                                Intrinsics.checkNotNullExpressionValue(imageUrl, "multiPart.imageUriList()[0]");
                                str5 = imageUrl.getSourceUrl();
                            } else if (multiPart.isHtmlArticle()) {
                                str5 = multiPart.messageCover();
                            }
                            ImageView imageView = itemFeedRoughDraftBinding.logoView;
                            Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
                            String str7 = str5;
                            if (!(str7 == null || str7.length() == 0)) {
                                z3 = false;
                            }
                            if (z3) {
                                i2 = 8;
                            }
                            imageView.setVisibility(i2);
                            AppHolder.getFragmentImageLoader().displayImage(draftListFragment, str5, itemFeedRoughDraftBinding.logoView);
                            ImageView imageView2 = itemFeedRoughDraftBinding.actionView;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.actionView");
                            ViewExtendsKt.setUtilClickListener(imageView2, new DraftListFragment$FeedRoughDraftViewHolder$bindTo$2(this, roughDraft));
                            itemFeedRoughDraftBinding.executePendingBindings();
                        }
                        z2 = true;
                        TextView textView3 = itemFeedRoughDraftBinding.titleView;
                        Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                        textView3.setVisibility(z2 ? 0 : 8);
                        TextView textView4 = itemFeedRoughDraftBinding.titleView;
                        Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
                        str3 = str2;
                        textView4.setText(str3 != null || str3.length() == 0 ? "无标题" : str3);
                        if (str3 != null || str3.length() == 0) {
                        }
                        itemFeedRoughDraftBinding.titleView.setTextColor(i);
                        Intrinsics.checkNotNullExpressionValue(itemFeedRoughDraftBinding, "binding");
                        View root = itemFeedRoughDraftBinding.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        ViewExtendsKt.setUtilClickListener(root, new DraftListFragment$FeedRoughDraftViewHolder$bindTo$1(this, multiPart, roughDraft, draftListFragment));
                        TextView textView5 = itemFeedRoughDraftBinding.timeView;
                        Intrinsics.checkNotNullExpressionValue(textView5, "binding.timeView");
                        textView5.setText("编辑于" + DateUtils.getTimeDescription(getContext(), Long.valueOf(roughDraft.getCreateTime() / ((long) 1000))));
                        if (multiPart.imageUriList().size() > 0) {
                        }
                        ImageView imageView = itemFeedRoughDraftBinding.logoView;
                        Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
                        String str7 = str5;
                        z3 = false;
                        if (z3) {
                        }
                        imageView.setVisibility(i2);
                        AppHolder.getFragmentImageLoader().displayImage(draftListFragment, str5, itemFeedRoughDraftBinding.logoView);
                        ImageView imageView2 = itemFeedRoughDraftBinding.actionView;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.actionView");
                        ViewExtendsKt.setUtilClickListener(imageView2, new DraftListFragment$FeedRoughDraftViewHolder$bindTo$2(this, roughDraft));
                        itemFeedRoughDraftBinding.executePendingBindings();
                    }
                    str6 = "其他";
                    TextView textView = itemFeedRoughDraftBinding.typeView;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.typeView");
                    textView.setText(StringsKt.trim((CharSequence) str6).toString());
                    if (!multiPart.isHtmlArticle()) {
                    }
                    AppTheme appTheme = AppHolder.getAppTheme();
                    str = str4;
                    if (str != null) {
                    }
                    int textColorTertiary = appTheme.getTextColorTertiary();
                    int textColorPrimary = appTheme.getTextColorPrimary();
                    if (!z) {
                    }
                    if (str != null || str.length() == 0) {
                    }
                    TextView textView2 = itemFeedRoughDraftBinding.textView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
                    textView2.setText(str4);
                    itemFeedRoughDraftBinding.textView.setTextColor(textColorTertiary);
                    if (!multiPart.isHtmlArticle()) {
                    }
                    z2 = true;
                    TextView textView3 = itemFeedRoughDraftBinding.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                    textView3.setVisibility(z2 ? 0 : 8);
                    TextView textView4 = itemFeedRoughDraftBinding.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
                    str3 = str2;
                    textView4.setText(str3 != null || str3.length() == 0 ? "无标题" : str3);
                    if (str3 != null || str3.length() == 0) {
                    }
                    itemFeedRoughDraftBinding.titleView.setTextColor(i);
                    Intrinsics.checkNotNullExpressionValue(itemFeedRoughDraftBinding, "binding");
                    View root = itemFeedRoughDraftBinding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    ViewExtendsKt.setUtilClickListener(root, new DraftListFragment$FeedRoughDraftViewHolder$bindTo$1(this, multiPart, roughDraft, draftListFragment));
                    TextView textView5 = itemFeedRoughDraftBinding.timeView;
                    Intrinsics.checkNotNullExpressionValue(textView5, "binding.timeView");
                    textView5.setText("编辑于" + DateUtils.getTimeDescription(getContext(), Long.valueOf(roughDraft.getCreateTime() / ((long) 1000))));
                    if (multiPart.imageUriList().size() > 0) {
                    }
                    ImageView imageView = itemFeedRoughDraftBinding.logoView;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
                    String str7 = str5;
                    z3 = false;
                    if (z3) {
                    }
                    imageView.setVisibility(i2);
                    AppHolder.getFragmentImageLoader().displayImage(draftListFragment, str5, itemFeedRoughDraftBinding.logoView);
                    ImageView imageView2 = itemFeedRoughDraftBinding.actionView;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.actionView");
                    ViewExtendsKt.setUtilClickListener(imageView2, new DraftListFragment$FeedRoughDraftViewHolder$bindTo$2(this, roughDraft));
                    itemFeedRoughDraftBinding.executePendingBindings();
                }
            }
        }

        public final void startSubmitFeedV8ActivityForForwardFeed(DraftListFragment draftListFragment, RoughDraft roughDraft) {
            Intrinsics.checkNotNullParameter(draftListFragment, "fragment");
            Intrinsics.checkNotNullParameter(roughDraft, "roughDraft");
            ProgressDialog progressDialog = new ProgressDialog(draftListFragment.requireActivity());
            progressDialog.setProgressStyle(0);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("读取数据");
            progressDialog.show();
            DataManager.getInstance().getFeedDetail(roughDraft.getMultiPart().forwardId(), "", "", "").compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new DraftListFragment$FeedRoughDraftViewHolder$startSubmitFeedV8ActivityForForwardFeed$1(progressDialog, draftListFragment, roughDraft));
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/draft/DraftListFragment$FeedRoughDraftViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: DraftListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final void showActionPopMenu(RoughDraft roughDraft, View view) {
            Intrinsics.checkNotNullParameter(roughDraft, "roughDraft");
            Intrinsics.checkNotNullParameter(view, "view");
            DataBindingComponent component = getComponent();
            LifecycleOwner lifecycleOwner = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (lifecycleOwner2 instanceof DraftListFragment) {
                lifecycleOwner = lifecycleOwner2;
            }
            DraftListFragment draftListFragment = (DraftListFragment) lifecycleOwner;
            if (draftListFragment != null) {
                BasePopMenu basePopMenu = new BasePopMenu(draftListFragment.requireActivity(), view);
                basePopMenu.getMenu().add(0, 101, 0, "删除草稿");
                if (Intrinsics.areEqual(roughDraft.getMultiPart().type(), "answer")) {
                    basePopMenu.getMenu().add(0, 102, 0, "查看此问题");
                }
                basePopMenu.setOnMenuItemClickListener(new DraftListFragment$FeedRoughDraftViewHolder$showActionPopMenu$1(this, draftListFragment, roughDraft));
                basePopMenu.show();
            }
        }

        public final void showDeleteSnackBar() {
            DataBindingComponent component = getComponent();
            LifecycleOwner lifecycleOwner = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (lifecycleOwner2 instanceof DraftListFragment) {
                lifecycleOwner = lifecycleOwner2;
            }
            DraftListFragment draftListFragment = (DraftListFragment) lifecycleOwner;
            if (draftListFragment != null) {
                DraftListFragment draftListFragment2 = draftListFragment;
                int adapterPosition = getAdapterPosition();
                RoughDraft roughDraft = (RoughDraft) draftListFragment2.getDataList().get(adapterPosition);
                View view = draftListFragment2.getView();
                if (view != null) {
                    Intrinsics.checkNotNullExpressionValue(view, "fragment.view.elvis { return }");
                    draftListFragment2.getDataList().remove(adapterPosition);
                    Snackbar showingSnackBar = draftListFragment2.getShowingSnackBar();
                    if (showingSnackBar != null && showingSnackBar.isShown()) {
                        showingSnackBar.dismiss();
                    }
                    Snackbar make = Snackbar.make(view, "删除一篇草稿", 0);
                    Intrinsics.checkNotNullExpressionValue(make, "Snackbar.make(view, \"删除一…稿\", Snackbar.LENGTH_LONG)");
                    make.setAction(2131887071, new DraftListFragment$FeedRoughDraftViewHolder$showDeleteSnackBar$2(draftListFragment2, adapterPosition, roughDraft));
                    make.addCallback(new DraftListFragment$FeedRoughDraftViewHolder$showDeleteSnackBar$3(roughDraft, draftListFragment2));
                    make.show();
                    draftListFragment2.setShowingSnackBar(make);
                }
            }
        }
    }
}
