package com.coolapk.market.view.feedv8.article;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.databinding.SubmitFeedArticleImagePartBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.LazyTextWatcher;
import com.coolapk.market.widget.view.ScalingImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditFeedImageHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;)V", "getViewModel", "()Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "bindTo", "", "data", "", "setImageViewSize", "model", "Lcom/coolapk/market/view/feedv8/ArticleImage;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleEditFeedImageHolder.kt */
public final class ArticleEditFeedImageHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559151;
    private final ArticleViewModel viewModel;

    public final ArticleViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleEditFeedImageHolder(View view, ArticleViewModel articleViewModel) {
        super(view, null, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(articleViewModel, "viewModel");
        this.viewModel = articleViewModel;
        final SubmitFeedArticleImagePartBinding submitFeedArticleImagePartBinding = (SubmitFeedArticleImagePartBinding) getBinding();
        submitFeedArticleImagePartBinding.descriptionView.addTextChangedListener(new LazyTextWatcher(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedImageHolder.AnonymousClass1 */
            final /* synthetic */ ArticleEditFeedImageHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "s");
                super.afterTextChanged(editable);
                this.this$0.getViewModel().updateModel(this.this$0.getAdapterPosition(), new ArticleEditFeedImageHolder$1$afterTextChanged$1(this));
            }
        });
        EditText editText = submitFeedArticleImagePartBinding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.descriptionView");
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedImageHolder.AnonymousClass2 */
            final /* synthetic */ ArticleEditFeedImageHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.this$0.getViewModel().getMenuEnable().setValue(false);
                }
            }
        });
        submitFeedArticleImagePartBinding.closeView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedImageHolder.AnonymousClass3 */
            final /* synthetic */ ArticleEditFeedImageHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.this$0.getAdapterPosition() >= 0) {
                    ArticleViewModel.updateDataList$default(this.this$0.getViewModel(), false, false, new Function1<List<ArticleModel>, Unit>(this) {
                        /* class com.coolapk.market.view.feedv8.article.ArticleEditFeedImageHolder.AnonymousClass3.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass3 this$0;

                        {
                            this.this$0 = r1;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<ArticleModel> list) {
                            invoke(list);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<ArticleModel> list) {
                            Intrinsics.checkNotNullParameter(list, "it");
                            list.remove(this.this$0.this$0.getAdapterPosition());
                        }
                    }, 3, null);
                }
            }
        });
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, 16777215});
        FrameLayout frameLayout = submitFeedArticleImagePartBinding.longPicTextContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.longPicTextContainer");
        frameLayout.setBackground(gradientDrawable);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        SubmitFeedArticleImagePartBinding submitFeedArticleImagePartBinding = (SubmitFeedArticleImagePartBinding) getBinding();
        ArticleImage articleImage = (ArticleImage) obj;
        setImageViewSize(articleImage);
        Uri parse = Uri.parse(StringUtils.notNull(articleImage.getImageUrl()));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(model.imageUrl))");
        Uri safeFileUri = UtilExtendsKt.toSafeFileUri(parse);
        ScalingImageView scalingImageView = submitFeedArticleImagePartBinding.ivCover;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.ivCover");
        scalingImageView.setScaleType(ImageView.ScaleType.MATRIX);
        Intrinsics.checkNotNullExpressionValue(submitFeedArticleImagePartBinding, "binding");
        View root = submitFeedArticleImagePartBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        GlideApp.with(root.getContext()).load(safeFileUri).placeholder(2131231696).diskCacheStrategy(DiskCacheStrategy.NONE).into(submitFeedArticleImagePartBinding.ivCover);
        ScalingImageView scalingImageView2 = submitFeedArticleImagePartBinding.ivCover;
        Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.ivCover");
        scalingImageView2.setScaleType(ImageView.ScaleType.MATRIX);
        submitFeedArticleImagePartBinding.descriptionView.setText(articleImage.getText());
    }

    private final void setImageViewSize(ArticleImage articleImage) {
        SubmitFeedArticleImagePartBinding submitFeedArticleImagePartBinding = (SubmitFeedArticleImagePartBinding) getBinding();
        Uri parse = Uri.parse(StringUtils.notNull(articleImage.getImageUrl()));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(model.imageUrl))");
        Uri safeFileUri = UtilExtendsKt.toSafeFileUri(parse);
        Pair<Integer, Integer> pair = TuplesKt.to(1024, 1024);
        if (TextUtils.equals("file", safeFileUri.getScheme())) {
            Intrinsics.checkNotNullExpressionValue(submitFeedArticleImagePartBinding, "binding");
            View root = submitFeedArticleImagePartBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            pair = KotlinExtendKt.getBitmapSize(safeFileUri, context);
        } else {
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(articleImage.getImageUrl());
            if (size != null) {
                pair = TuplesKt.to(Integer.valueOf(size.getWidth()), Integer.valueOf(size.getHeight()));
            }
        }
        int decorViewWidth = DisplayUtils.getDecorViewWidth(getContext()) - NumberExtendsKt.getDp((Number) 32);
        float f = (float) decorViewWidth;
        int floatValue = (int) ((f / pair.getFirst().floatValue()) * pair.getSecond().floatValue());
        if (f / ((float) floatValue) < 0.45f) {
            FrameLayout frameLayout = submitFeedArticleImagePartBinding.longPicTextContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.longPicTextContainer");
            frameLayout.setVisibility(0);
            submitFeedArticleImagePartBinding.longPicTextContainer.setOnClickListener(new ArticleEditFeedImageHolder$setImageViewSize$1(this, safeFileUri, submitFeedArticleImagePartBinding));
            floatValue = (int) (f / 0.45f);
        } else {
            FrameLayout frameLayout2 = submitFeedArticleImagePartBinding.longPicTextContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.longPicTextContainer");
            frameLayout2.setVisibility(8);
        }
        ScalingImageView scalingImageView = submitFeedArticleImagePartBinding.ivCover;
        scalingImageView.getLayoutParams().width = decorViewWidth;
        scalingImageView.getLayoutParams().height = floatValue;
        scalingImageView.requestLayout();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleEditFeedImageHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleEditFeedImageHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
