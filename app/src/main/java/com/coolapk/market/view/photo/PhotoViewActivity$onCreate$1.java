package com.coolapk.market.view.photo;

import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.widget.CatchErrorViewPager;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/photo/PhotoViewActivity$onCreate$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
public final class PhotoViewActivity$onCreate$1 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ CatchErrorViewPager $viewPager;
    final /* synthetic */ PhotoViewActivity this$0;

    PhotoViewActivity$onCreate$1(PhotoViewActivity photoViewActivity, CatchErrorViewPager catchErrorViewPager) {
        this.this$0 = photoViewActivity;
        this.$viewPager = catchErrorViewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        TextView textView = this.this$0.getBinding().infoView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.infoView");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.$viewPager.getCurrentItem() + 1), Integer.valueOf(PhotoViewActivity.access$getData$p(this.this$0).size())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        textView.setText(format);
    }
}
