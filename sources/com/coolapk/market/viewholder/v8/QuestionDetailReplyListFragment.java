package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemArticleAnswerPreviewTopBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.reply.FeedDetailFragmentV8;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/v8/QuestionDetailReplyListFragment;", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "()V", "questionReplyHolder", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "getQuestionReplyHolder$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/HolderItem;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onViewCreated", "view", "Landroid/view/View;", "updateHeaderData", "ArticleAnswerTopViewHolder", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionDetailReplyListFragment.kt */
public final class QuestionDetailReplyListFragment extends FeedDetailFragmentV8 {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_QUESTION_FEED_TOP = "QUESTION_TOP";
    private final HolderItem questionReplyHolder = HolderItem.newBuilder().entityType("QUESTION_TOP").build();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/v8/QuestionDetailReplyListFragment$Companion;", "", "()V", "ENTITY_TYPE_QUESTION_FEED_TOP", "", "newInstance", "Lcom/coolapk/market/viewholder/v8/QuestionDetailReplyListFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionDetailReplyListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ QuestionDetailReplyListFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final QuestionDetailReplyListFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            QuestionDetailReplyListFragment questionDetailReplyListFragment = new QuestionDetailReplyListFragment();
            questionDetailReplyListFragment.setArguments(bundle);
            return questionDetailReplyListFragment;
        }
    }

    public final HolderItem getQuestionReplyHolder$presentation_coolapkAppRelease() {
        return this.questionReplyHolder;
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
        if (getDataList().isEmpty()) {
            List<Parcelable> dataList = getDataList();
            HolderItem holderItem = this.questionReplyHolder;
            Intrinsics.checkNotNullExpressionValue(holderItem, "questionReplyHolder");
            dataList.add(holderItem);
            Entity detailSponsorCard = getFeed$presentation_coolapkAppRelease().getDetailSponsorCard();
            if (detailSponsorCard != null) {
                getDataList().add(detailSponsorCard);
                return;
            }
            return;
        }
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(EntityListFragment.findFirstEntityIndex$default(this, "QUESTION_TOP", null, false, false, 6, null));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
            alphableToolbar.setToolbarAlpha(1.0f);
            alphableToolbar.setToolbarTitle("提问");
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(activity, 36.0f), new QuestionDetailReplyListFragment$onViewCreated$1(this, activity)));
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558612).suitedMethod(QuestionDetailReplyListFragment$onActivityCreated$1.INSTANCE).constructor(new QuestionDetailReplyListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        MenuItem findItem = menu.findItem(2131361969);
        if (findItem != null) {
            findItem.setVisible(true);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/v8/QuestionDetailReplyListFragment$ArticleAnswerTopViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemArticleAnswerPreviewTopBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionDetailReplyListFragment.kt */
    public static final class ArticleAnswerTopViewHolder extends GenericBindHolder<ItemArticleAnswerPreviewTopBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558612;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticleAnswerTopViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
            ItemArticleAnswerPreviewTopBinding itemArticleAnswerPreviewTopBinding = (ItemArticleAnswerPreviewTopBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemArticleAnswerPreviewTopBinding, "binding");
            itemArticleAnswerPreviewTopBinding.setClick(this);
            ItemArticleAnswerPreviewTopBinding itemArticleAnswerPreviewTopBinding2 = (ItemArticleAnswerPreviewTopBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemArticleAnswerPreviewTopBinding2, "binding");
            itemArticleAnswerPreviewTopBinding2.setTransformer(new CircleTransform(false, 0, 3, null));
            LinearLayout linearLayout = ((ItemArticleAnswerPreviewTopBinding) getBinding()).userViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.userViewContainer");
            linearLayout.setVisibility(8);
            View view2 = ((ItemArticleAnswerPreviewTopBinding) getBinding()).dividerView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.dividerView");
            view2.setVisibility(8);
            ((ItemArticleAnswerPreviewTopBinding) getBinding()).titleContainer.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.coolapk.market.viewholder.v8.QuestionDetailReplyListFragment.ArticleAnswerTopViewHolder.AnonymousClass1 */
                final /* synthetic */ ArticleAnswerTopViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    Feed feed$presentation_coolapkAppRelease;
                    DataBindingComponent component = this.this$0.getComponent();
                    LifecycleOwner lifecycleOwner = null;
                    if (!(component instanceof FragmentBindingComponent)) {
                        component = null;
                    }
                    FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                    LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                    if (lifecycleOwner2 instanceof FeedDetailFragmentV8) {
                        lifecycleOwner = lifecycleOwner2;
                    }
                    FeedDetailFragmentV8 feedDetailFragmentV8 = (FeedDetailFragmentV8) lifecycleOwner;
                    if (feedDetailFragmentV8 == null || (feed$presentation_coolapkAppRelease = feedDetailFragmentV8.getFeed$presentation_coolapkAppRelease()) == null) {
                        return true;
                    }
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    EntityExtendsKt.showItemDialog(feed$presentation_coolapkAppRelease, context);
                    return true;
                }
            });
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            DataBindingComponent component = getComponent();
            LifecycleOwner lifecycleOwner = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (lifecycleOwner2 instanceof FeedDetailFragmentV8) {
                lifecycleOwner = lifecycleOwner2;
            }
            FeedDetailFragmentV8 feedDetailFragmentV8 = (FeedDetailFragmentV8) lifecycleOwner;
            if (feedDetailFragmentV8 != null) {
                Feed feed$presentation_coolapkAppRelease = feedDetailFragmentV8.getFeed$presentation_coolapkAppRelease();
                if (view.getId() == 2131363590) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed$presentation_coolapkAppRelease), null, null, 12, null);
                }
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/QuestionDetailReplyListFragment$ArticleAnswerTopViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: QuestionDetailReplyListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            DataBindingComponent component = getComponent();
            LifecycleOwner lifecycleOwner = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (lifecycleOwner2 instanceof FeedDetailFragmentV8) {
                lifecycleOwner = lifecycleOwner2;
            }
            FeedDetailFragmentV8 feedDetailFragmentV8 = (FeedDetailFragmentV8) lifecycleOwner;
            if (feedDetailFragmentV8 != null) {
                Feed feed$presentation_coolapkAppRelease = feedDetailFragmentV8.getFeed$presentation_coolapkAppRelease();
                ItemArticleAnswerPreviewTopBinding itemArticleAnswerPreviewTopBinding = (ItemArticleAnswerPreviewTopBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemArticleAnswerPreviewTopBinding, "binding");
                itemArticleAnswerPreviewTopBinding.setModel(feed$presentation_coolapkAppRelease);
                TextView textView = ((ItemArticleAnswerPreviewTopBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                String messageTitle = feed$presentation_coolapkAppRelease.getMessageTitle();
                if (messageTitle == null) {
                    messageTitle = "";
                }
                textView.setText(messageTitle);
                TextView textView2 = ((ItemArticleAnswerPreviewTopBinding) getBinding()).countView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.countView");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%d人回答 · %d人关注", Arrays.copyOf(new Object[]{Integer.valueOf(feed$presentation_coolapkAppRelease.getQuestionAnswerNum()), Integer.valueOf(feed$presentation_coolapkAppRelease.getQuestionFollowNum())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                textView2.setText(format);
                ((ItemArticleAnswerPreviewTopBinding) getBinding()).executePendingBindings();
            }
        }
    }
}
