package com.coolapk.market.view.album.albumv8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.AlbumCommentBarBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001#B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0003H\u0014J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u000eH\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumCommentBarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/AlbumCommentBarBinding;", "Lcom/coolapk/market/model/Album;", "Landroid/view/View$OnClickListener;", "()V", "album", "getAlbum", "()Lcom/coolapk/market/model/Album;", "setAlbum", "(Lcom/coolapk/market/model/Album;)V", "externalListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "getExternalListener", "()Lkotlin/jvm/functions/Function1;", "setExternalListener", "(Lkotlin/jvm/functions/Function1;)V", "showReturnAlbumView", "", "getShowReturnAlbumView", "()Z", "setShowReturnAlbumView", "(Z)V", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumCommentBar.kt */
public final class AlbumCommentBarViewPart extends BindingViewPart<AlbumCommentBarBinding, Album> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private Album album;
    private Function1<? super View, Unit> externalListener;
    private boolean showReturnAlbumView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumCommentBarViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/album/albumv8/AlbumCommentBarViewPart;", "album", "Lcom/coolapk/market/model/Album;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumCommentBar.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AlbumCommentBarViewPart newInstance(Album album, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(album, "album");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            AlbumCommentBarViewPart albumCommentBarViewPart = new AlbumCommentBarViewPart();
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            albumCommentBarViewPart.createView(from, viewGroup);
            albumCommentBarViewPart.bindToContent(album);
            return albumCommentBarViewPart;
        }
    }

    public final Album getAlbum() {
        return this.album;
    }

    public final void setAlbum(Album album2) {
        this.album = album2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit>, kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> */
    public final Function1<View, Unit> getExternalListener() {
        return this.externalListener;
    }

    public final void setExternalListener(Function1<? super View, Unit> function1) {
        this.externalListener = function1;
    }

    public final boolean getShowReturnAlbumView() {
        return this.showReturnAlbumView;
    }

    public final void setShowReturnAlbumView(boolean z) {
        this.showReturnAlbumView = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public AlbumCommentBarBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558442, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…nt_bar, viewGroup, false)");
        return (AlbumCommentBarBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = ((AlbumCommentBarBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setTopElevation$default(root, 0.0f, 1, null);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Album album2) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(album2, "data");
        super.onBindToContent((AlbumCommentBarViewPart) album2);
        this.album = album2;
        ((AlbumCommentBarBinding) getBinding()).setClick(this);
        String str5 = "1w+";
        String valueOf = album2.getReplyNum() < 9999 ? String.valueOf(album2.getReplyNum()) : str5;
        String valueOf2 = album2.getLikeNum() < 9999 ? String.valueOf(album2.getLikeNum()) : str5;
        String valueOf3 = album2.getFavoriteNum() < 9999 ? String.valueOf(album2.getFavoriteNum()) : str5;
        if (album2.getShareNum() < 9999) {
            str5 = String.valueOf(album2.getShareNum());
        }
        TextView textView = ((AlbumCommentBarBinding) getBinding()).commentCount;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.commentCount");
        textView.setText(album2.getReplyNum() > 0 ? valueOf : "");
        TextView textView2 = ((AlbumCommentBarBinding) getBinding()).likeCount;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.likeCount");
        if (album2.getLikeNum() > 0) {
            str = valueOf2;
        }
        textView2.setText(str);
        TextView textView3 = ((AlbumCommentBarBinding) getBinding()).starCount;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.starCount");
        if (album2.getFavoriteNum() > 0) {
            str2 = valueOf3;
        }
        textView3.setText(str2);
        TextView textView4 = ((AlbumCommentBarBinding) getBinding()).shareCount;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.shareCount");
        if (album2.getShareNum() > 0) {
            str3 = str5;
        }
        textView4.setText(str3);
        ((AlbumCommentBarBinding) getBinding()).executePendingBindings();
        UserAction userAction = album2.getUserAction();
        boolean z = false;
        boolean z2 = userAction != null && userAction.getLike() == 1;
        UserAction userAction2 = album2.getUserAction();
        if (userAction2 != null && userAction2.getCollect() == 1) {
            z = true;
        }
        ((AlbumCommentBarBinding) getBinding()).likeIcon.setImageResource(z2 ? 2131689495 : 2131689494);
        ImageView imageView = ((AlbumCommentBarBinding) getBinding()).likeIcon;
        AppTheme appTheme = AppHolder.getAppTheme();
        imageView.setColorFilter(z2 ? appTheme.getColorAccent() : appTheme.getTextColorSecondary());
        ((AlbumCommentBarBinding) getBinding()).likeCount.setTextColor(z2 ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorSecondary());
        ((AlbumCommentBarBinding) getBinding()).starIcon.setImageResource(z ? 2131689478 : 2131689477);
        ImageView imageView2 = ((AlbumCommentBarBinding) getBinding()).starIcon;
        AppTheme appTheme2 = AppHolder.getAppTheme();
        imageView2.setColorFilter(z ? appTheme2.getColorAccent() : appTheme2.getTextColorSecondary());
        ((AlbumCommentBarBinding) getBinding()).starCount.setTextColor(z ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorSecondary());
        AppTheme appTheme3 = AppHolder.getAppTheme();
        if (this.showReturnAlbumView) {
            TextView textView5 = ((AlbumCommentBarBinding) getBinding()).commentCount;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.commentCount");
            textView5.setText(getContext().getString(2131886569));
            TextView textView6 = ((AlbumCommentBarBinding) getBinding()).commentCount;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.commentCount");
            ViewGroup.LayoutParams layoutParams = textView6.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = DisplayUtils.dp2px(getContext(), 16.0f);
            TextView textView7 = ((AlbumCommentBarBinding) getBinding()).commentCount;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.commentCount");
            textView7.setLayoutParams(layoutParams2);
            ((AlbumCommentBarBinding) getBinding()).commentCount.setTextColor(appTheme3.getColorAccent());
            ((AlbumCommentBarBinding) getBinding()).commentIcon.setImageResource(2131231184);
            ((AlbumCommentBarBinding) getBinding()).commentIcon.setColorFilter(appTheme3.getColorAccent());
            return;
        }
        TextView textView8 = ((AlbumCommentBarBinding) getBinding()).commentCount;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding.commentCount");
        ViewGroup.LayoutParams layoutParams3 = textView8.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.topMargin = DisplayUtils.dp2px(getContext(), 10.0f);
        TextView textView9 = ((AlbumCommentBarBinding) getBinding()).commentCount;
        Intrinsics.checkNotNullExpressionValue(textView9, "binding.commentCount");
        textView9.setLayoutParams(layoutParams4);
        TextView textView10 = ((AlbumCommentBarBinding) getBinding()).commentCount;
        Intrinsics.checkNotNullExpressionValue(textView10, "binding.commentCount");
        if (album2.getReplyNum() > 0) {
            str4 = valueOf;
        }
        textView10.setText(str4);
        ((AlbumCommentBarBinding) getBinding()).commentCount.setTextColor(appTheme3.getTextColorSecondary());
        ((AlbumCommentBarBinding) getBinding()).commentIcon.setImageResource(2131689479);
        ((AlbumCommentBarBinding) getBinding()).commentIcon.setColorFilter(appTheme3.getTextColorSecondary());
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        Function1<? super View, Unit> function1 = this.externalListener;
        if (function1 != null) {
            function1.invoke(view);
        }
    }
}
