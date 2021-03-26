package com.coolapk.market.viewholder;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedSourcePartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Video;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UserUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoModelKt;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001cB\u0019\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSourceViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedSourcePartBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "ninePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNinePicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "ninePicViewPart$delegate", "Lkotlin/Lazy;", "videoViewHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedSourceViewPart.kt */
public final class FeedSourceViewPart extends BindingViewPart<ItemFeedSourcePartBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558737;
    private final DataBindingComponent component;
    private final Lazy ninePicViewPart$delegate;
    private BaseVideoHotPlug videoViewHotPlug;

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    @JvmStatic
    public static final FeedSourceViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
        return Companion.newInstance(viewGroup, dataBindingComponent);
    }

    public /* synthetic */ FeedSourceViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataBindingComponent, itemActionHandler);
    }

    private FeedSourceViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        this.component = dataBindingComponent;
        this.ninePicViewPart$delegate = LazyKt.lazy(new FeedSourceViewPart$ninePicViewPart$2(this));
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        Space space = ((ItemFeedSourcePartBinding) getBinding()).videoPlayerSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.videoPlayerSpaceView");
        this.videoViewHotPlug = new FeedSourceViewPart$onViewCreated$1(this, space, this.component);
    }

    public void onBindToContent(Feed feed) {
        VideoModel videoModel;
        Intrinsics.checkNotNullParameter(feed, "data");
        ItemFeedSourcePartBinding itemFeedSourcePartBinding = (ItemFeedSourcePartBinding) getBinding();
        String uid = feed.getUid();
        SpannableStringBuilder convert = LinkTextUtils.convert(UserUtils.getUserSpan(uid, "@" + feed.getUserName()), AppHolder.getAppTheme().getColorAccent(), null);
        String message = feed.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "source.message");
        SpannableStringBuilder convert2 = LinkTextUtils.convert(new Regex("[\\n\\r]").replace(message, " "), AppHolder.getAppTheme().getColorAccent(), null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886718));
        boolean z = false;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
        String str = "";
        if (Intrinsics.areEqual(feed.getFeedType(), "answer")) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("【答：");
            String messageTitle = feed.getMessageTitle();
            if (messageTitle != null) {
                str = messageTitle;
            }
            SpannableStringBuilder append = spannableStringBuilder2.append((CharSequence) str).append((CharSequence) "】");
            append.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getTextColorPrimary()), 0, append.length(), 33);
            append.setSpan(new StyleSpan(1), 0, append.length(), 33);
            SpannableStringBuilder append2 = new SpannableStringBuilder(convert).append((CharSequence) ": ").append((CharSequence) append).append((CharSequence) convert2);
            CoolEllipsizeTextView coolEllipsizeTextView = itemFeedSourcePartBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
            Intrinsics.checkNotNullExpressionValue(append2, "builder");
            ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView, 4, append2, spannableStringBuilder, false, 8, null);
            CoolEllipsizeTextView coolEllipsizeTextView2 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.bottomTextView");
            coolEllipsizeTextView2.setText((CharSequence) null);
            CoolEllipsizeTextView coolEllipsizeTextView3 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView3, "binding.bottomTextView");
            coolEllipsizeTextView3.setVisibility(8);
            getNinePicViewPart().setMaxShowCount(3);
            getNinePicViewPart().setFullSizeWhenOne(false);
            getNinePicViewPart().bindToContent(EntityExtendsKt.getHtmlPicArray(feed));
        } else if (Intrinsics.areEqual(feed.getFeedType(), "question")) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("【问：");
            String messageTitle2 = feed.getMessageTitle();
            if (messageTitle2 != null) {
                str = messageTitle2;
            }
            SpannableStringBuilder append3 = spannableStringBuilder3.append((CharSequence) str).append((CharSequence) "】");
            append3.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getTextColorPrimary()), 0, append3.length(), 33);
            append3.setSpan(new StyleSpan(1), 0, append3.length(), 33);
            SpannableStringBuilder append4 = new SpannableStringBuilder(convert).append((CharSequence) ": ").append((CharSequence) append3).append((CharSequence) convert2);
            CoolEllipsizeTextView coolEllipsizeTextView4 = itemFeedSourcePartBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView4, "binding.textView");
            Intrinsics.checkNotNullExpressionValue(append4, "builder");
            ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView4, 4, append4, spannableStringBuilder, false, 8, null);
            CoolEllipsizeTextView coolEllipsizeTextView5 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView5, "binding.bottomTextView");
            coolEllipsizeTextView5.setText((CharSequence) null);
            CoolEllipsizeTextView coolEllipsizeTextView6 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView6, "binding.bottomTextView");
            coolEllipsizeTextView6.setVisibility(8);
            getNinePicViewPart().setMaxShowCount(3);
            getNinePicViewPart().setFullSizeWhenOne(false);
            getNinePicViewPart().bindToContent(EntityExtendsKt.getHtmlPicArray(feed));
        } else if (Intrinsics.areEqual(feed.getEntityTemplate(), "feedCover")) {
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("【");
            String messageTitle3 = feed.getMessageTitle();
            if (messageTitle3 == null) {
                messageTitle3 = str;
            }
            SpannableStringBuilder append5 = spannableStringBuilder4.append((CharSequence) messageTitle3).append((CharSequence) "】");
            append5.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getTextColorPrimary()), 0, append5.length(), 33);
            append5.setSpan(new StyleSpan(1), 0, append5.length(), 33);
            SpannableStringBuilder append6 = new SpannableStringBuilder(convert).append((CharSequence) ": ").append((CharSequence) append5);
            CoolEllipsizeTextView coolEllipsizeTextView7 = itemFeedSourcePartBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView7, "binding.textView");
            coolEllipsizeTextView7.setText(append6);
            CoolEllipsizeTextView coolEllipsizeTextView8 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView8, "binding.bottomTextView");
            ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView8, 4, convert2, null, false, 12, null);
            CoolEllipsizeTextView coolEllipsizeTextView9 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView9, "binding.bottomTextView");
            coolEllipsizeTextView9.setVisibility(0);
            getNinePicViewPart().setMaxShowCount(9);
            getNinePicViewPart().setFullSizeWhenOne(true);
            NinePicViewPart ninePicViewPart = getNinePicViewPart();
            String messageCover = feed.getMessageCover();
            if (messageCover != null) {
                str = messageCover;
            }
            List singletonList = Collections.singletonList(str);
            Intrinsics.checkNotNullExpressionValue(singletonList, "Collections.singletonLis…e.messageCover.notNull())");
            ninePicViewPart.bindToContent(singletonList);
        } else if (feed.getIsHtmlArticle() == 1) {
            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("【");
            String messageTitle4 = feed.getMessageTitle();
            if (messageTitle4 != null) {
                str = messageTitle4;
            }
            SpannableStringBuilder append7 = spannableStringBuilder5.append((CharSequence) str).append((CharSequence) "】");
            append7.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getTextColorPrimary()), 0, append7.length(), 33);
            append7.setSpan(new StyleSpan(1), 0, append7.length(), 33);
            SpannableStringBuilder append8 = new SpannableStringBuilder(convert).append((CharSequence) ": ").append((CharSequence) append7).append((CharSequence) "\n").append((CharSequence) convert2);
            CoolEllipsizeTextView coolEllipsizeTextView10 = itemFeedSourcePartBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView10, "binding.textView");
            Intrinsics.checkNotNullExpressionValue(append8, "builder");
            ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView10, 4, append8, null, false, 12, null);
            CoolEllipsizeTextView coolEllipsizeTextView11 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView11, "binding.bottomTextView");
            coolEllipsizeTextView11.setText((CharSequence) null);
            CoolEllipsizeTextView coolEllipsizeTextView12 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView12, "binding.bottomTextView");
            coolEllipsizeTextView12.setVisibility(8);
            getNinePicViewPart().setMaxShowCount(3);
            getNinePicViewPart().setFullSizeWhenOne(false);
            ArrayList arrayList = new ArrayList();
            String messageCover2 = feed.getMessageCover();
            if (messageCover2 == null || messageCover2.length() == 0) {
                z = true;
            }
            if (!z) {
                String messageCover3 = feed.getMessageCover();
                Intrinsics.checkNotNull(messageCover3);
                Intrinsics.checkNotNullExpressionValue(messageCover3, "source.messageCover!!");
                arrayList.add(messageCover3);
            }
            arrayList.addAll(EntityExtendsKt.getHtmlPicArray(feed));
            getNinePicViewPart().bindToContent(arrayList);
        } else {
            SpannableStringBuilder append9 = new SpannableStringBuilder(convert).append((CharSequence) ": ").append((CharSequence) convert2);
            CoolEllipsizeTextView coolEllipsizeTextView13 = itemFeedSourcePartBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView13, "binding.textView");
            Intrinsics.checkNotNullExpressionValue(append9, "builder");
            ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView13, 4, append9, spannableStringBuilder, false, 8, null);
            CoolEllipsizeTextView coolEllipsizeTextView14 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView14, "binding.bottomTextView");
            coolEllipsizeTextView14.setText((CharSequence) null);
            CoolEllipsizeTextView coolEllipsizeTextView15 = itemFeedSourcePartBinding.bottomTextView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView15, "binding.bottomTextView");
            coolEllipsizeTextView15.setVisibility(8);
            getNinePicViewPart().setMaxShowCount(9);
            getNinePicViewPart().setFullSizeWhenOne(false);
            getNinePicViewPart().bindToContent(EntityExtendsKt.getHtmlPicArray(feed));
        }
        itemFeedSourcePartBinding.textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        ViewExtendsKt.setUtilClickListener(getView(), new FeedSourceViewPart$onBindToContent$1(this, feed));
        itemFeedSourcePartBinding.executePendingBindings();
        Video findVideo = VideoModelKt.findVideo(feed);
        if (findVideo == null || (videoModel = VideoModelKt.toViewModel(findVideo)) == null) {
            videoModel = VideoModel.Companion.getNO_VIDEO();
        }
        BaseVideoHotPlug baseVideoHotPlug = this.videoViewHotPlug;
        if (baseVideoHotPlug == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoViewHotPlug");
        }
        baseVideoHotPlug.bindTo(videoModel);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedSourcePartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558737, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemFeedSourcePartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        BaseVideoHotPlug baseVideoHotPlug = this.videoViewHotPlug;
        if (baseVideoHotPlug == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoViewHotPlug");
        }
        baseVideoHotPlug.onRecycled();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSourceViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "newInstance", "Lcom/coolapk/market/viewholder/FeedSourceViewPart;", "container", "Landroid/view/ViewGroup;", "component", "Landroidx/databinding/DataBindingComponent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSourceViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FeedSourceViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            FeedSourceViewPart feedSourceViewPart = new FeedSourceViewPart(dataBindingComponent, null, null);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(container.context)");
            feedSourceViewPart.createView(from, viewGroup);
            return feedSourceViewPart;
        }
    }
}
