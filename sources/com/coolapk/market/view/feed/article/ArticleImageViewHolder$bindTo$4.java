package com.coolapk.market.view.feed.article;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.ItemArticleViewImageBinding;
import com.coolapk.market.manager.AppPictureSizeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "drawable", "Landroid/graphics/drawable/Drawable;", "<anonymous parameter 2>", "Landroid/view/View;", "<anonymous parameter 3>", "", "<anonymous parameter 4>", "", "onLoadComplete"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleImageViewHolder.kt */
final class ArticleImageViewHolder$bindTo$4 implements OnImageLoadListener {
    final /* synthetic */ ItemArticleViewImageBinding $binding;
    final /* synthetic */ Object $data;
    final /* synthetic */ String $url;
    final /* synthetic */ ArticleImageViewHolder this$0;

    ArticleImageViewHolder$bindTo$4(ArticleImageViewHolder articleImageViewHolder, String str, ItemArticleViewImageBinding itemArticleViewImageBinding, Object obj) {
        this.this$0 = articleImageViewHolder;
        this.$url = str;
        this.$binding = itemArticleViewImageBinding;
        this.$data = obj;
    }

    @Override // com.coolapk.market.app.OnImageLoadListener
    public final void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
        if (drawable != null) {
            AppPictureSizeManager.getInstance().put(this.$url, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ItemArticleViewImageBinding itemArticleViewImageBinding = this.$binding;
            Intrinsics.checkNotNullExpressionValue(itemArticleViewImageBinding, "binding");
            itemArticleViewImageBinding.getRoot().post(new Runnable(this) {
                /* class com.coolapk.market.view.feed.article.ArticleImageViewHolder$bindTo$4.AnonymousClass1 */
                final /* synthetic */ ArticleImageViewHolder$bindTo$4 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.this$0.bindTo(this.this$0.$data);
                }
            });
        }
    }
}
