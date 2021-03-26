package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.ItemFeedGoodsInfoBinding;
import com.coolapk.market.databinding.NormalFeedContentV8Binding;
import com.coolapk.market.databinding.SubmitFeedRelativeInfoPickerBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.model.Video;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleSourceViewPart;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.SubmitExtraViewPart;
import com.coolapk.market.view.feedv8.util.FeedGoodsAddHelper;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPartKt;
import com.coolapk.market.viewholder.FeedSourceDeletedViewPart;
import com.coolapk.market.viewholder.FeedSourceViewPart;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.emotion.BaseEmotion;
import com.coolapk.market.widget.emotion.EmotionUtils;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoModelKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\r\u0010,\u001a\u00020\u0013H\u0010¢\u0006\u0002\b-J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\r\u00100\u001a\u000201H\u0010¢\u0006\u0002\b2J\b\u00103\u001a\u000204H\u0002J\r\u00105\u001a\u00020)H\u0010¢\u0006\u0002\b6J \u00107\u001a\u00020)2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010*\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u001dH\u0016J\u0015\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020@H\u0010¢\u0006\u0002\bAJ\b\u0010B\u001a\u00020)H\u0016J\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020+H\u0016J\u0010\u0010H\u001a\u00020)2\u0006\u0010*\u001a\u00020;H\u0016J\u0010\u0010I\u001a\u00020)2\u0006\u0010*\u001a\u00020;H\u0016J\u0016\u0010J\u001a\u00020)2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002040LH\u0016J\u0010\u0010M\u001a\u00020)2\u0006\u0010*\u001a\u00020;H\u0016J\b\u0010N\u001a\u00020)H\u0016J\b\u0010O\u001a\u00020)H\u0016J\u0010\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020)H\u0016J\b\u0010T\u001a\u00020)H\u0016J\u0018\u0010U\u001a\u00020)2\u0006\u0010Q\u001a\u0002042\u0006\u0010V\u001a\u000204H\u0016J\b\u0010W\u001a\u00020)H\u0016J\u0013\u0010X\u001a\b\u0012\u0004\u0012\u0002010YH\u0010¢\u0006\u0002\bZJ\b\u0010[\u001a\u00020)H\u0002J\b\u0010\\\u001a\u00020)H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006^"}, d2 = {"Lcom/coolapk/market/view/feedv8/NormalFeedContentHolder;", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "adapter", "Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;", "getAdapter$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;", "setAdapter$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;)V", "binding", "Lcom/coolapk/market/databinding/NormalFeedContentV8Binding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/NormalFeedContentV8Binding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/NormalFeedContentV8Binding;)V", "disableSuggestAddGoods", "", "getDisableSuggestAddGoods$presentation_coolapkAppRelease", "()Z", "setDisableSuggestAddGoods$presentation_coolapkAppRelease", "(Z)V", "focusEditText", "Landroid/widget/EditText;", "getFocusEditText", "()Landroid/widget/EditText;", "focusEditorView", "Landroid/view/View;", "getFocusEditorView", "()Landroid/view/View;", "relativeInfoPickerViewPart", "Lcom/coolapk/market/view/feedv8/RelativeInfoPickerViewPart;", "videoViewHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "getVideoViewHotPlug", "()Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "videoViewHotPlug$delegate", "Lkotlin/Lazy;", "addRelativeInfo", "", "data", "Lcom/coolapk/market/model/Entity;", "checkSubmittable", "checkSubmittable$presentation_coolapkAppRelease", "createForwardFeedView", "fillRelativeViewIfNeed", "generateDraftCopy", "Lcom/coolapk/market/model/FeedMultiPart;", "generateDraftCopy$presentation_coolapkAppRelease", "getForwardHint", "", "notifyUIChange", "notifyUIChange$presentation_coolapkAppRelease", "onActivityResult", "requestCode", "", "resultCode", "Landroid/content/Intent;", "onClick", "v", "onCreateContentView", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onDeleteButtonClick", "onEmotionClick", "emotions", "Lcom/coolapk/market/widget/emotion/BaseEmotion;", "onExtraEntityLoaded", "entity", "onPickAppIntent", "onPickAtIntent", "onPickImageListChange", "pathList", "", "onPickTopicIntent", "onRemoveExtraEntity", "onRequestPickImage", "onShareInfoLoaded", "info", "Lcom/coolapk/market/model/ShareFeedInfo;", "onSubmitButtonClick", "onSubmitToButtonClick", "onVideoDataLoaded", "sourceUrl", "onVideoDataRemoved", "prepareMultiFeed", "Lrx/Observable;", "prepareMultiFeed$presentation_coolapkAppRelease", "removeRelativeInfo", "setLogoViewPlaceHolder", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NormalFeedContentHolder.kt */
public class NormalFeedContentHolder extends BaseFeedContentHolder implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_CODE_NODE = 3242;
    public PickPhotoAdapterV8 adapter;
    public NormalFeedContentV8Binding binding;
    private boolean disableSuggestAddGoods;
    private RelativeInfoPickerViewPart relativeInfoPickerViewPart;
    private final Lazy videoViewHotPlug$delegate = LazyKt.lazy(new NormalFeedContentHolder$videoViewHotPlug$2(this));

    private final BaseVideoHotPlug getVideoViewHotPlug() {
        return (BaseVideoHotPlug) this.videoViewHotPlug$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalFeedContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/NormalFeedContentHolder$Companion;", "", "()V", "REQUEST_CODE_NODE", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NormalFeedContentHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final NormalFeedContentV8Binding getBinding$presentation_coolapkAppRelease() {
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return normalFeedContentV8Binding;
    }

    public final void setBinding$presentation_coolapkAppRelease(NormalFeedContentV8Binding normalFeedContentV8Binding) {
        Intrinsics.checkNotNullParameter(normalFeedContentV8Binding, "<set-?>");
        this.binding = normalFeedContentV8Binding;
    }

    public final PickPhotoAdapterV8 getAdapter$presentation_coolapkAppRelease() {
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return pickPhotoAdapterV8;
    }

    public final void setAdapter$presentation_coolapkAppRelease(PickPhotoAdapterV8 pickPhotoAdapterV8) {
        Intrinsics.checkNotNullParameter(pickPhotoAdapterV8, "<set-?>");
        this.adapter = pickPhotoAdapterV8;
    }

    public final boolean getDisableSuggestAddGoods$presentation_coolapkAppRelease() {
        return this.disableSuggestAddGoods;
    }

    public final void setDisableSuggestAddGoods$presentation_coolapkAppRelease(boolean z) {
        this.disableSuggestAddGoods = z;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View getFocusEditorView() {
        return getFocusEditText();
    }

    private final EditText getFocusEditText() {
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = normalFeedContentV8Binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        return editText;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        VideoModel videoModel;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = false;
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559065, null, false, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        NormalFeedContentV8Binding normalFeedContentV8Binding = (NormalFeedContentV8Binding) inflate;
        this.binding = normalFeedContentV8Binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding.setUiConfig(getUiConfig());
        PickPhotoAdapterV8 pickPhotoAdapterV8 = new PickPhotoAdapterV8(getActivity());
        this.adapter = pickPhotoAdapterV8;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.setOnPhotoCountChangeListener(new NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$1(this));
        pickPhotoAdapterV8.setPickPhotoClickListener(new NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$2(this));
        pickPhotoAdapterV8.setInitList(getMultiPart().imageUriList());
        pickPhotoAdapterV8.setEditTable(true);
        pickPhotoAdapterV8.setMaxPickCount(getUiConfig().maxPickPhotoCount());
        NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
        if (normalFeedContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = normalFeedContentV8Binding2.recyclerView;
        PickPhotoAdapterV8 pickPhotoAdapterV82 = this.adapter;
        if (pickPhotoAdapterV82 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(pickPhotoAdapterV82);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setOverScrollMode(2);
        NormalFeedContentV8Binding normalFeedContentV8Binding3 = this.binding;
        if (normalFeedContentV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = normalFeedContentV8Binding3.editTitle;
        editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(getUiConfig().editTitleMaxLength())});
        editText.setText(getMultiPart().messageTitle());
        editText.addTextChangedListener(new CommentHelper.CharRejectHelper('\n'));
        editText.setOnFocusChangeListener(new NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$3(this));
        NormalFeedContentV8Binding normalFeedContentV8Binding4 = this.binding;
        if (normalFeedContentV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = normalFeedContentV8Binding4.editTitleFreeNum;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.editTitleFreeNum");
        textView.setText(String.valueOf(getUiConfig().editTitleMaxLength()));
        NormalFeedContentV8Binding normalFeedContentV8Binding5 = this.binding;
        if (normalFeedContentV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = normalFeedContentV8Binding5.editText;
        editText2.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        editText2.setText(LinkTextUtils.convert(getMultiPart().message(), AppHolder.getAppTheme().getColorAccent(), null));
        String message = getMultiPart().message();
        Intrinsics.checkNotNullExpressionValue(message, "multiPart.message()");
        if (StringsKt.endsWith$default(message, " ", false, 2, (Object) null)) {
            editText2.append(" ");
        }
        editText2.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        editText2.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$4(this)));
        editText2.addTextChangedListener(new NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$5(this));
        editText2.setOnFocusChangeListener(new NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$6(this));
        if (getUiConfig().isForward()) {
            createForwardFeedView();
        }
        NormalFeedContentV8Binding normalFeedContentV8Binding6 = this.binding;
        if (normalFeedContentV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding6.setClick(this);
        if (Intrinsics.areEqual(getMultiPart().type(), "discovery")) {
            NormalFeedContentV8Binding normalFeedContentV8Binding7 = this.binding;
            if (normalFeedContentV8Binding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText3 = normalFeedContentV8Binding7.editText;
            Intrinsics.checkNotNullExpressionValue(editText3, "binding.editText");
            Selection.setSelection(editText3.getText(), 0, 0);
        } else {
            NormalFeedContentV8Binding normalFeedContentV8Binding8 = this.binding;
            if (normalFeedContentV8Binding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText4 = normalFeedContentV8Binding8.editText;
            Intrinsics.checkNotNullExpressionValue(editText4, "binding.editText");
            Editable text = editText4.getText();
            NormalFeedContentV8Binding normalFeedContentV8Binding9 = this.binding;
            if (normalFeedContentV8Binding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText5 = normalFeedContentV8Binding9.editText;
            Intrinsics.checkNotNullExpressionValue(editText5, "binding.editText");
            int length = editText5.getText().length();
            NormalFeedContentV8Binding normalFeedContentV8Binding10 = this.binding;
            if (normalFeedContentV8Binding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText6 = normalFeedContentV8Binding10.editText;
            Intrinsics.checkNotNullExpressionValue(editText6, "binding.editText");
            Selection.setSelection(text, length, editText6.getText().length());
        }
        if (getUiConfig().isForward()) {
            NormalFeedContentV8Binding normalFeedContentV8Binding11 = this.binding;
            if (normalFeedContentV8Binding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            normalFeedContentV8Binding11.editText.setOnFocusChangeListener(new NormalFeedContentHolder$onCreateContentView$5(this));
        }
        NormalFeedContentV8Binding normalFeedContentV8Binding12 = this.binding;
        if (normalFeedContentV8Binding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = normalFeedContentV8Binding12.removeExtraView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.removeExtraView");
        ViewExtendsKt.expandTouchRect(imageView, DisplayUtils.dp2px(getActivity(), 8.0f));
        fillRelativeViewIfNeed();
        String mediaInfo = getMultiPart().mediaInfo();
        Intrinsics.checkNotNullExpressionValue(mediaInfo, "multiPart.mediaInfo()");
        if (mediaInfo.length() > 0) {
            z = true;
        }
        if (z) {
            Video parseJsonAsVideo = VideoModelKt.parseJsonAsVideo(getMultiPart().mediaInfo());
            BaseVideoHotPlug videoViewHotPlug = getVideoViewHotPlug();
            if (parseJsonAsVideo == null || (videoModel = VideoModelKt.toViewModel(parseJsonAsVideo)) == null) {
                videoModel = VideoModel.Companion.getNO_VIDEO();
            }
            videoViewHotPlug.bindTo(videoModel);
        }
        NormalFeedContentV8Binding normalFeedContentV8Binding13 = this.binding;
        if (normalFeedContentV8Binding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.replaceView(normalFeedContentV8Binding13.spaceView, getExtraViewPart$presentation_coolapkAppRelease().getView());
        NormalFeedContentV8Binding normalFeedContentV8Binding14 = this.binding;
        if (normalFeedContentV8Binding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding14.executePendingBindings();
        setLogoViewPlaceHolder();
        List<Entity> extraEntities = getUiConfig().extraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "uiConfig.extraEntities()");
        if (!extraEntities.isEmpty()) {
            List<Entity> extraEntities2 = getUiConfig().extraEntities();
            Intrinsics.checkNotNullExpressionValue(extraEntities2, "uiConfig.extraEntities()");
            Object first = CollectionsKt.first((List<? extends Object>) extraEntities2);
            Intrinsics.checkNotNullExpressionValue(first, "uiConfig.extraEntities().first()");
            onExtraEntityLoaded((Entity) first);
        }
        NormalFeedContentV8Binding normalFeedContentV8Binding15 = this.binding;
        if (normalFeedContentV8Binding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = normalFeedContentV8Binding15.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setLogoViewPlaceHolder() {
        String extraViewLogoUrl = getUiConfig().extraViewLogoUrl();
        if (extraViewLogoUrl == null || extraViewLogoUrl.length() == 0) {
            if (getMultiPart().mediaType() == 0) {
                NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
                if (normalFeedContentV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                normalFeedContentV8Binding.logoView.setImageResource(2131231408);
            } else {
                NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
                if (normalFeedContentV8Binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                normalFeedContentV8Binding2.logoView.setImageResource(2131231421);
            }
            NormalFeedContentV8Binding normalFeedContentV8Binding3 = this.binding;
            if (normalFeedContentV8Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView = normalFeedContentV8Binding3.logoView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            NormalFeedContentV8Binding normalFeedContentV8Binding4 = this.binding;
            if (normalFeedContentV8Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            normalFeedContentV8Binding4.logoView.setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
            return;
        }
        NormalFeedContentV8Binding normalFeedContentV8Binding5 = this.binding;
        if (normalFeedContentV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = normalFeedContentV8Binding5.logoView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.logoView");
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        NormalFeedContentV8Binding normalFeedContentV8Binding6 = this.binding;
        if (normalFeedContentV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView3 = normalFeedContentV8Binding6.logoView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.logoView");
        imageView3.setBackground(null);
    }

    private final void fillRelativeViewIfNeed() {
        if (getUiConfig().relativeInfoPickable()) {
            if (this.relativeInfoPickerViewPart == null) {
                RelativeInfoPickerViewPart relativeInfoPickerViewPart2 = new RelativeInfoPickerViewPart();
                LayoutInflater from = LayoutInflater.from(getActivity());
                Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
                NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
                if (normalFeedContentV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                relativeInfoPickerViewPart2.createView(from, normalFeedContentV8Binding.relativeView);
                relativeInfoPickerViewPart2.setOnCloseViewClick(new NormalFeedContentHolder$fillRelativeViewIfNeed$1(this));
                relativeInfoPickerViewPart2.setOnPickItemClick(new NormalFeedContentHolder$fillRelativeViewIfNeed$2(this));
                NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
                if (normalFeedContentV8Binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                normalFeedContentV8Binding2.relativeView.addView(((SubmitFeedRelativeInfoPickerBinding) relativeInfoPickerViewPart2.getBinding()).getRoot());
                this.relativeInfoPickerViewPart = relativeInfoPickerViewPart2;
            }
            RelativeInfoPickerViewPart relativeInfoPickerViewPart3 = this.relativeInfoPickerViewPart;
            if (relativeInfoPickerViewPart3 != null) {
                relativeInfoPickerViewPart3.bindToContent(getUiConfig());
                return;
            }
            return;
        }
        SubmitExtraViewPart.Companion companion = SubmitExtraViewPart.Companion;
        NormalFeedContentV8Binding normalFeedContentV8Binding3 = this.binding;
        if (normalFeedContentV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = normalFeedContentV8Binding3.relativeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.relativeView");
        SubmitExtraViewPart.Companion.fillRelativeInfoViewIntoLayout$default(companion, linearLayout, getUiConfig(), null, 4, null);
    }

    /* access modifiers changed from: private */
    public final void removeRelativeInfo() {
        FeedUIConfig build = getUiConfig().newBuilder().relativeLogo("").relativeTitle("").build();
        Intrinsics.checkNotNullExpressionValue(build, "uiConfig.newBuilder()\n  …\n                .build()");
        updateUiConfig$presentation_coolapkAppRelease(build);
        FeedMultiPart.Builder newBuilder = getMultiPart().newBuilder();
        if (Intrinsics.areEqual(getMultiPart().type(), "comment")) {
            newBuilder.type("feed");
        }
        Unit unit = Unit.INSTANCE;
        FeedMultiPart build2 = newBuilder.targetId("").targetType("").build();
        Intrinsics.checkNotNullExpressionValue(build2, "multiPart.newBuilder()\n …\n                .build()");
        updateMultiPart$presentation_coolapkAppRelease(build2);
    }

    private final void addRelativeInfo(Entity entity) {
        if (entity instanceof ServiceApp) {
            ServiceApp serviceApp = (ServiceApp) entity;
            FeedUIConfig build = getUiConfig().newBuilder().relativeLogo(serviceApp.getLogo()).relativeTitle(serviceApp.getAppName()).build();
            Intrinsics.checkNotNullExpressionValue(build, "uiConfig.newBuilder()\n  …                 .build()");
            updateUiConfig$presentation_coolapkAppRelease(build);
            FeedMultiPart.Builder targetType = getMultiPart().newBuilder().type("comment").targetType("apk");
            String targetId = serviceApp.getTargetId();
            if (targetId == null) {
                targetId = "";
            }
            FeedMultiPart build2 = targetType.targetId(targetId).build();
            Intrinsics.checkNotNullExpressionValue(build2, "multiPart.newBuilder()\n …                 .build()");
            updateMultiPart$presentation_coolapkAppRelease(build2);
        } else if (entity instanceof Product) {
            Product product = (Product) entity;
            FeedUIConfig build3 = getUiConfig().newBuilder().relativeLogo(product.getLogo()).relativeTitle(product.getTitle()).build();
            Intrinsics.checkNotNullExpressionValue(build3, "uiConfig.newBuilder()\n  …                 .build()");
            updateUiConfig$presentation_coolapkAppRelease(build3);
            FeedMultiPart build4 = getMultiPart().newBuilder().type("feed").targetId(product.getId()).targetType("product_phone").build();
            Intrinsics.checkNotNullExpressionValue(build4, "multiPart.newBuilder()\n …                 .build()");
            updateMultiPart$presentation_coolapkAppRelease(build4);
        }
    }

    private final void createForwardFeedView() {
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = normalFeedContentV8Binding.forwardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.forwardView");
        SubmitExtraViewPart extraViewPart$presentation_coolapkAppRelease = getExtraViewPart$presentation_coolapkAppRelease();
        NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
        if (normalFeedContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = normalFeedContentV8Binding2.forwardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.forwardView");
        extraViewPart$presentation_coolapkAppRelease.fillForwardViewIntoLayout(linearLayout2);
        Entity forwardEntity = getUiConfig().forwardEntity();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (forwardEntity instanceof Feed) {
            Feed feed = (Feed) forwardEntity;
            if (feed.getForwardSourceFeed() != null) {
                feed = feed.getForwardSourceFeed();
                Intrinsics.checkNotNull(feed);
            }
            FeedSourceViewPart newInstance = FeedSourceViewPart.Companion.newInstance(linearLayout, new ContextBindingComponent(getActivity()));
            newInstance.bindToContent(feed);
            View view = newInstance.getView();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) marginLayoutParams;
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.topMargin = 0;
                marginLayoutParams2.bottomMargin = 0;
                marginLayoutParams2.height = -2;
            }
            linearLayout.addView(view);
        } else if (forwardEntity instanceof DyhArticle) {
            DyhArticleSourceViewPart newInstance2 = DyhArticleSourceViewPart.Companion.newInstance(linearLayout, new ContextBindingComponent(getActivity()));
            newInstance2.bindToContent(forwardEntity);
            View view2 = newInstance2.getView();
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) marginLayoutParams;
            if (marginLayoutParams3 != null) {
                marginLayoutParams3.topMargin = 0;
                marginLayoutParams3.bottomMargin = 0;
                marginLayoutParams3.height = -2;
            }
            linearLayout.addView(view2);
        } else {
            FeedSourceDeletedViewPart newInstance3 = FeedSourceDeletedViewPart.Companion.newInstance(linearLayout, new ContextBindingComponent(getActivity()));
            if (forwardEntity == null) {
                newInstance3.setDeletedHint();
            } else {
                newInstance3.setUpdateHint();
            }
            ViewGroup.LayoutParams layoutParams3 = newInstance3.getView().getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams3;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = marginLayoutParams;
            if (marginLayoutParams4 != null) {
                marginLayoutParams4.topMargin = 0;
                marginLayoutParams4.bottomMargin = 0;
                marginLayoutParams4.height = -2;
            }
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void notifyUIChange$presentation_coolapkAppRelease() {
        super.notifyUIChange$presentation_coolapkAppRelease();
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding.setUiConfig(getUiConfig());
        NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
        if (normalFeedContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding2.executePendingBindings();
        fillRelativeViewIfNeed();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onExtraEntityLoaded(Entity entity) {
        TextView textView;
        Intrinsics.checkNotNullParameter(entity, "entity");
        super.onExtraEntityLoaded(entity);
        getUiConfig().extraEntities().clear();
        getUiConfig().extraEntities().add(entity);
        FeedMultiPart.Builder newBuilder = getMultiPart().newBuilder();
        String url = entity.getUrl();
        if (url == null) {
            url = "";
        }
        FeedMultiPart build = newBuilder.extraUrl(url).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …\n                .build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        notifyUIChange$presentation_coolapkAppRelease();
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding.extraViewContainer.removeAllViews();
        if (entity instanceof FeedGoods) {
            FeedGoodsInfoViewPart feedGoodsInfoViewPart = new FeedGoodsInfoViewPart(new ContextBindingComponent(getActivity()));
            LayoutInflater from = LayoutInflater.from(getActivity());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
            NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
            if (normalFeedContentV8Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            feedGoodsInfoViewPart.createView(from, normalFeedContentV8Binding2.extraViewContainer);
            View view = feedGoodsInfoViewPart.getView();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            marginLayoutParams2.topMargin = NumberExtendsKt.getDp((Number) 6);
            marginLayoutParams2.leftMargin = NumberExtendsKt.getDp((Number) 12);
            marginLayoutParams2.rightMargin = NumberExtendsKt.getDp((Number) 12);
            view.setLayoutParams(marginLayoutParams);
            feedGoodsInfoViewPart.bindToContent(FeedGoodsInfoViewPartKt.toGoodsSimpleInfo((FeedGoods) entity));
            ((ItemFeedGoodsInfoBinding) feedGoodsInfoViewPart.getBinding()).setClick(null);
            textView = feedGoodsInfoViewPart.getView();
        } else {
            TextView textView2 = new TextView(getActivity());
            textView2.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            textView2.setTextSize(16.0f);
            textView2.setText("暂不支持，请升级后再试");
            textView2.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16));
            textView = textView2;
        }
        NormalFeedContentV8Binding normalFeedContentV8Binding3 = this.binding;
        if (normalFeedContentV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding3.extraViewContainer.addView(textView);
        NormalFeedContentV8Binding normalFeedContentV8Binding4 = this.binding;
        if (normalFeedContentV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = normalFeedContentV8Binding4.extraViewContainer;
        NormalFeedContentV8Binding normalFeedContentV8Binding5 = this.binding;
        if (normalFeedContentV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        frameLayout.addView(normalFeedContentV8Binding5.removeExtraEntityView);
        NormalFeedContentV8Binding normalFeedContentV8Binding6 = this.binding;
        if (normalFeedContentV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = normalFeedContentV8Binding6.removeExtraEntityView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.removeExtraEntityView");
        ViewExtendsKt.expandTouchRect(imageView, NumberExtendsKt.getDp((Number) 8));
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onRemoveExtraEntity() {
        super.onRemoveExtraEntity();
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        normalFeedContentV8Binding.extraViewContainer.removeAllViews();
        getUiConfig().extraEntities().clear();
        FeedMultiPart build = getMultiPart().newBuilder().extraUrl("").build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …\n                .build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onShareInfoLoaded(ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        super.onShareInfoLoaded(shareFeedInfo);
        setLogoViewPlaceHolder();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onVideoDataLoaded(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "info");
        Intrinsics.checkNotNullParameter(str2, "sourceUrl");
        super.onVideoDataLoaded(str, str2);
        Video parseJsonAsVideo = VideoModelKt.parseJsonAsVideo(str);
        if (parseJsonAsVideo != null) {
            FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
            builder.mediaInfo(str).imageUriList(new ArrayList()).mediaUrl(str2);
            FeedMultiPart build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            updateMultiPart$presentation_coolapkAppRelease(build);
            String name = parseJsonAsVideo.getName();
            if (!(name == null || name.length() == 0)) {
                NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
                if (normalFeedContentV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                EditText editText = normalFeedContentV8Binding.editText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
                Editable text = editText.getText();
                text.append((CharSequence) (' ' + parseJsonAsVideo.getName() + ' '));
            }
            PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
            if (pickPhotoAdapterV8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            pickPhotoAdapterV8.onPickedImageChange(new ArrayList());
            getVideoViewHotPlug().bindTo(VideoModelKt.toViewModel(parseJsonAsVideo));
            FeedUIConfig.Builder builder2 = FeedUIConfig.builder(getUiConfig());
            builder2.isExtraViewVisible(false).isPickPhotoContainerVisible(false).addPhotoMenuEnable(false).isRemoveExtraViewVisible(true);
            FeedUIConfig build2 = builder2.build();
            Intrinsics.checkNotNullExpressionValue(build2, "uiConfigBuilder.build()");
            updateUiConfig$presentation_coolapkAppRelease(build2);
            notifyUIChange$presentation_coolapkAppRelease();
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onVideoDataRemoved() {
        super.onVideoDataRemoved();
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        builder.mediaInfo("");
        builder.mediaUrl("");
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        getVideoViewHotPlug().bindTo(VideoModel.Companion.getNO_VIDEO());
        FeedUIConfig.Builder builder2 = FeedUIConfig.builder(getUiConfig());
        builder2.isExtraViewVisible(false).isPickPhotoContainerVisible(true).addPhotoMenuEnable(true).isRemoveExtraViewVisible(false);
        FeedUIConfig build2 = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "uiConfigBuilder.build()");
        updateUiConfig$presentation_coolapkAppRelease(build2);
        notifyUIChange$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onActivityResult(i, i2, intent);
        if (i == 3242 && (stringExtra = intent.getStringExtra("TYPE")) != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != -309474065) {
                if (hashCode == 96796 && stringExtra.equals("apk")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("DATA");
                    Intrinsics.checkNotNull(parcelableExtra);
                    Intrinsics.checkNotNullExpressionValue(parcelableExtra, "data.getParcelableExtra<…tivity.KEY_INTENT_DATA)!!");
                    addRelativeInfo((Entity) parcelableExtra);
                }
            } else if (stringExtra.equals("product")) {
                Parcelable parcelableExtra2 = intent.getParcelableExtra("DATA");
                Intrinsics.checkNotNull(parcelableExtra2);
                Intrinsics.checkNotNullExpressionValue(parcelableExtra2, "data.getParcelableExtra<…tivity.KEY_INTENT_DATA)!!");
                addRelativeInfo((Entity) parcelableExtra2);
            }
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onDeleteButtonClick() {
        super.onDeleteButtonClick();
        ViewExtendsKt.insertBackKey(getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onEmotionClick(BaseEmotion baseEmotion) {
        Intrinsics.checkNotNullParameter(baseEmotion, "emotions");
        super.onEmotionClick(baseEmotion);
        String realText = baseEmotion.getRealText();
        EditText focusEditText = getFocusEditText();
        Intrinsics.checkNotNullExpressionValue(realText, "emotionText");
        ViewExtendsKt.insertText(focusEditText, realText);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickTopicIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickTopicIntent(intent);
        CommentHelper.processTopicResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAtIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAtIntent(intent);
        CommentHelper.processAtUserResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAppIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAppIntent(intent);
        CommentHelper.processAddAppResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickImageListChange(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
        super.onPickImageListChange(list);
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.onPickedImageChange(list);
        requestCheckSubmittable$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onRequestPickImage() {
        super.onRequestPickImage();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.pickImage();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitButtonClick() {
        if (Intrinsics.areEqual(getMultiPart().type(), "discovery")) {
            PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
            if (pickPhotoAdapterV8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            if (pickPhotoAdapterV8.getImageUrls().size() <= 0) {
                Toast.show$default(getActivity(), "亲，至少添加一张图片喔", 0, false, 12, null);
                return;
            }
        }
        if (Intrinsics.areEqual(getMultiPart().type(), "feed") && getUiConfig().extraEntities().isEmpty() && !this.disableSuggestAddGoods) {
            NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
            if (normalFeedContentV8Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = normalFeedContentV8Binding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            if (FeedGoodsAddHelper.INSTANCE.didInputTextContainGoodsTag(CollectionsKt.listOf(editText.getText().toString()))) {
                FeedGoodsAddHelper feedGoodsAddHelper = FeedGoodsAddHelper.INSTANCE;
                Activity activity = getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                feedGoodsAddHelper.showSuggestAddGoodsDialog((AppCompatActivity) activity, new NormalFeedContentHolder$onSubmitButtonClick$1(this), new NormalFeedContentHolder$onSubmitButtonClick$2(this));
                return;
            }
        }
        startSubmitFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease() {
        LinkTextUtils linkTextUtils = LinkTextUtils.INSTANCE;
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = normalFeedContentV8Binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String reconvertToString = linkTextUtils.reconvertToString(new SpannableStringBuilder(editText.getText()));
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        String str = reconvertToString;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        builder.message(str.subSequence(i, length + 1).toString());
        NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
        if (normalFeedContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = normalFeedContentV8Binding2.editTitle;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editTitle");
        String obj = editText2.getText().toString();
        int length2 = obj.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare(obj.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (!z3) {
                if (!z4) {
                    z3 = true;
                } else {
                    i2++;
                }
            } else if (!z4) {
                break;
            } else {
                length2--;
            }
        }
        builder.messageTitle(obj.subSequence(i2, length2 + 1).toString());
        Map map = (Map) Observable.from(getMultiPart().imageUriList()).toMap(NormalFeedContentHolder$generateDraftCopy$oldImageMap$1.INSTANCE).toBlocking().first();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        builder.imageUriList((List) Observable.from(pickPhotoAdapterV8.getImageUrls()).map(new NormalFeedContentHolder$generateDraftCopy$fixedList$1(map)).toList().toBlocking().first());
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01e5  */
    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        boolean z;
        int length;
        int i;
        String obj;
        NormalFeedContentV8Binding normalFeedContentV8Binding;
        int length2;
        int i2;
        PickPhotoAdapterV8 pickPhotoAdapterV8;
        LinkTextUtils linkTextUtils = LinkTextUtils.INSTANCE;
        NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
        if (normalFeedContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = normalFeedContentV8Binding2.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String reconvertToString = linkTextUtils.reconvertToString(new SpannableStringBuilder(editText.getText()));
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        String id = getMultiPart().id();
        Intrinsics.checkNotNullExpressionValue(id, "multiPart.id()");
        boolean z2 = id.length() > 0;
        String str = getUiConfig().topicTitle();
        Intrinsics.checkNotNullExpressionValue(str, "uiConfig.topicTitle()");
        boolean z3 = str.length() > 0;
        if (z3) {
            if (StringsKt.contains$default((CharSequence) reconvertToString, (CharSequence) ("#" + getUiConfig().topicTitle() + "#"), false, 2, (Object) null)) {
                z = true;
                if (z3 && !z) {
                    if (!FeedUtils.isPictureType(getMultiPart().type())) {
                        reconvertToString = "#" + getUiConfig().topicTitle() + "# " + reconvertToString;
                    } else if (z2) {
                        FeedMultiPart build = getMultiPart().newBuilder().targetId("").targetType("").build();
                        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().t…\").targetType(\"\").build()");
                        updateMultiPart$presentation_coolapkAppRelease(build);
                        FeedUIConfig build2 = getUiConfig().newBuilder().topicTitle("").build();
                        Intrinsics.checkNotNullExpressionValue(build2, "uiConfig.newBuilder().topicTitle(\"\").build()");
                        updateUiConfig$presentation_coolapkAppRelease(build2);
                    } else {
                        reconvertToString = "#" + getUiConfig().topicTitle() + "# " + reconvertToString;
                    }
                }
                String str2 = reconvertToString;
                length = str2.length() - 1;
                i = 0;
                boolean z4 = false;
                while (i <= length) {
                    boolean z5 = Intrinsics.compare(str2.charAt(!z4 ? i : length), 32) <= 0;
                    if (!z4) {
                        if (!z5) {
                            z4 = true;
                        } else {
                            i++;
                        }
                    } else if (!z5) {
                        break;
                    } else {
                        length--;
                    }
                }
                obj = str2.subSequence(i, length + 1).toString();
                if ((obj.length() != 0) && getUiConfig().isForward()) {
                    obj = getForwardHint();
                }
                builder.message(obj);
                normalFeedContentV8Binding = this.binding;
                if (normalFeedContentV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                EditText editText2 = normalFeedContentV8Binding.editTitle;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.editTitle");
                String obj2 = editText2.getText().toString();
                length2 = obj2.length() - 1;
                i2 = 0;
                boolean z6 = false;
                while (i2 <= length2) {
                    boolean z7 = Intrinsics.compare(obj2.charAt(!z6 ? i2 : length2), 32) <= 0;
                    if (!z6) {
                        if (!z7) {
                            z6 = true;
                        } else {
                            i2++;
                        }
                    } else if (!z7) {
                        break;
                    } else {
                        length2--;
                    }
                }
                builder.messageTitle(obj2.subSequence(i2, length2 + 1).toString());
                FeedMultiPart build3 = builder.build();
                Intrinsics.checkNotNullExpressionValue(build3, "builder.build()");
                updateMultiPart$presentation_coolapkAppRelease(build3);
                FeedMultiPart multiPart = getMultiPart();
                Map map = (Map) Observable.from(multiPart.imageUriList()).toMap(NormalFeedContentHolder$prepareMultiFeed$oldImageMap$1.INSTANCE).toBlocking().first();
                pickPhotoAdapterV8 = this.adapter;
                if (pickPhotoAdapterV8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                List list = (List) Observable.from(pickPhotoAdapterV8.getImageUrls()).map(new NormalFeedContentHolder$prepareMultiFeed$fixedList$1(map)).toList().toBlocking().first();
                multiPart.imageUriList().clear();
                List<ImageUrl> imageUriList = multiPart.imageUriList();
                Intrinsics.checkNotNullExpressionValue(list, "fixedList");
                imageUriList.addAll(list);
                return super.prepareMultiFeed$presentation_coolapkAppRelease();
            }
        }
        z = false;
        if (!FeedUtils.isPictureType(getMultiPart().type())) {
        }
        String str2 = reconvertToString;
        length = str2.length() - 1;
        i = 0;
        boolean z4 = false;
        while (i <= length) {
        }
        obj = str2.subSequence(i, length + 1).toString();
        obj = getForwardHint();
        builder.message(obj);
        normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
        }
        EditText editText2 = normalFeedContentV8Binding.editTitle;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editTitle");
        String obj2 = editText2.getText().toString();
        length2 = obj2.length() - 1;
        i2 = 0;
        boolean z6 = false;
        while (i2 <= length2) {
        }
        builder.messageTitle(obj2.subSequence(i2, length2 + 1).toString());
        FeedMultiPart build3 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build3, "builder.build()");
        updateMultiPart$presentation_coolapkAppRelease(build3);
        FeedMultiPart multiPart = getMultiPart();
        Map map = (Map) Observable.from(multiPart.imageUriList()).toMap(NormalFeedContentHolder$prepareMultiFeed$oldImageMap$1.INSTANCE).toBlocking().first();
        pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
        }
        List list = (List) Observable.from(pickPhotoAdapterV8.getImageUrls()).map(new NormalFeedContentHolder$prepareMultiFeed$fixedList$1(map)).toList().toBlocking().first();
        multiPart.imageUriList().clear();
        List<ImageUrl> imageUriList = multiPart.imageUriList();
        Intrinsics.checkNotNullExpressionValue(list, "fixedList");
        imageUriList.addAll(list);
        return super.prepareMultiFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
        if (normalFeedContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = normalFeedContentV8Binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        if (EmotionUtils.getEmotionCount(editText.getText().toString()) > 100) {
            return false;
        }
        if (Intrinsics.areEqual(getMultiPart().type(), "question")) {
            NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
            if (normalFeedContentV8Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText2 = normalFeedContentV8Binding2.editTitle;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.editTitle");
            if (TextUtils.isEmpty(editText2.getText().toString())) {
                return false;
            }
            return super.checkSubmittable$presentation_coolapkAppRelease();
        }
        NormalFeedContentV8Binding normalFeedContentV8Binding3 = this.binding;
        if (normalFeedContentV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText3 = normalFeedContentV8Binding3.editText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.editText");
        String obj = editText3.getText().toString();
        int length = obj.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(obj.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        boolean isEmpty = TextUtils.isEmpty(obj.subSequence(i, length + 1).toString());
        if (getUiConfig().isForward()) {
            return true;
        }
        return !isEmpty;
    }

    private final String getForwardHint() {
        Entity forwardEntity = getUiConfig().forwardEntity();
        if (forwardEntity instanceof Feed) {
            String string = getActivity().getString(2131887321);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.title_forward_feed)");
            return string;
        } else if (!(forwardEntity instanceof DyhArticle)) {
            return "";
        } else {
            String string2 = getActivity().getString(2131887320);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.title_forward_article)");
            return string2;
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitToButtonClick() {
        super.onSubmitToButtonClick();
        if (Intrinsics.areEqual(getMultiPart().type(), "answer")) {
            requestConvertToArticleMode$presentation_coolapkAppRelease();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        boolean z = false;
        ViewGroup viewGroup = null;
        switch (view.getId()) {
            case 2131362261:
                NormalFeedContentV8Binding normalFeedContentV8Binding = this.binding;
                if (normalFeedContentV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FeedWarningBinding feedWarningBinding = normalFeedContentV8Binding.alertView;
                Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
                View root = feedWarningBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.alertView.root");
                ViewParent parent = root.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = parent;
                }
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 != null) {
                    TransitionManager.beginDelayedTransition(viewGroup2);
                    NormalFeedContentV8Binding normalFeedContentV8Binding2 = this.binding;
                    if (normalFeedContentV8Binding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    FeedWarningBinding feedWarningBinding2 = normalFeedContentV8Binding2.alertView;
                    Intrinsics.checkNotNullExpressionValue(feedWarningBinding2, "binding.alertView");
                    View root2 = feedWarningBinding2.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.alertView.root");
                    root2.setVisibility(8);
                    return;
                }
                return;
            case 2131362501:
                String extraUrl = getMultiPart().extraUrl();
                if (!TextUtils.isEmpty(extraUrl)) {
                    Intrinsics.checkNotNullExpressionValue(extraUrl, "url");
                    if (UriUtils.isInAppUrl(extraUrl)) {
                        ActionManagerCompat.startActivityByUrl(getActivity(), extraUrl, getMultiPart().extraTitle(), null);
                        return;
                    } else if (StringsKt.startsWith$default(extraUrl, "http", false, 2, (Object) null)) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
                        if (pickPhotoAdapterV8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        }
                        for (ImageUrl imageUrl : pickPhotoAdapterV8.getImageUrls()) {
                            Intrinsics.checkNotNullExpressionValue(imageUrl, "list");
                            Uri parse = Uri.parse(imageUrl.getSourceUrl());
                            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(list.sourceUrl)");
                            String path = parse.getPath();
                            Intrinsics.checkNotNull(path);
                            arrayList.add(path);
                        }
                        onRequestWebViewUrl$presentation_coolapkAppRelease(extraUrl, arrayList);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 2131363250:
                onRemoveExtraEntity();
                return;
            case 2131363251:
                String mediaInfo = getMultiPart().mediaInfo();
                Intrinsics.checkNotNullExpressionValue(mediaInfo, "multiPart.mediaInfo()");
                if (mediaInfo.length() == 0) {
                    z = true;
                }
                if (z) {
                    onShareInfoRemove$presentation_coolapkAppRelease();
                    return;
                } else {
                    onVideoDataRemoved();
                    return;
                }
            default:
                return;
        }
    }
}
