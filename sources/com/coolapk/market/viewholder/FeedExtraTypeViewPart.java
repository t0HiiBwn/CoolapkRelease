package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedExtraTypePartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideImageHelper;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.BlurLogoTransform;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u000bH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedExtraTypePartBinding;", "Lcom/coolapk/market/model/Feed;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "handleApkButtonClick", "", "view", "Landroid/view/View;", "loadBlurLogoBackground", "pic", "", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedExtraTypeViewPart.kt */
public final class FeedExtraTypeViewPart extends BindingViewPart<ItemFeedExtraTypePartBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558698;
    private final DataBindingComponent component;
    private Feed feed;

    public FeedExtraTypeViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedExtraTypeViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedExtraTypePartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558698, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemFeedExtraTypePartBinding) inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        int hashCode;
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedExtraTypeViewPart) feed2);
        this.feed = feed2;
        ItemFeedExtraTypePartBinding itemFeedExtraTypePartBinding = (ItemFeedExtraTypePartBinding) getBinding();
        String extraTitle = feed2.getExtraTitle();
        boolean z = true;
        int i = 0;
        if (extraTitle == null || extraTitle.length() == 0) {
            View root = itemFeedExtraTypePartBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setVisibility(8);
            itemFeedExtraTypePartBinding.executePendingBindings();
            return;
        }
        View root2 = itemFeedExtraTypePartBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        root2.setVisibility(0);
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        itemFeedExtraTypePartBinding.setModel(feed3);
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String extraType = feed4.getExtraType();
        if (extraType != null && extraType.hashCode() == 96796 && extraType.equals("apk")) {
            loadBlurLogoBackground(feed2.getExtraPic());
            String extraInfo = feed2.getExtraInfo();
            TextView textView = itemFeedExtraTypePartBinding.extendSubtitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.extendSubtitle");
            String str = extraInfo;
            textView.setText(str);
            TextView textView2 = itemFeedExtraTypePartBinding.extendSubtitle;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.extendSubtitle");
            if (!(str == null || str.length() == 0)) {
                z = false;
            }
            if (z) {
                i = 8;
            }
            textView2.setVisibility(i);
        } else {
            itemFeedExtraTypePartBinding.extendLayout.setBackgroundColor(ResourceUtils.resolveData(getContext(), 2130968793));
            String extraInfo2 = feed2.getExtraInfo();
            String str2 = extraInfo2;
            if (str2 == null || str2.length() == 0) {
                String extraUrl = feed2.getExtraUrl();
                if (!(extraUrl == null || extraUrl.length() == 0)) {
                    String extraUrl2 = feed2.getExtraUrl();
                    if (extraUrl2 == null) {
                        extraUrl2 = "";
                    }
                    extraInfo2 = KotlinExtendKt.getSimpleHost(KotlinExtendKt.asUri(extraUrl2));
                }
            }
            TextView textView3 = itemFeedExtraTypePartBinding.extendSubtitle;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.extendSubtitle");
            String str3 = extraInfo2;
            textView3.setText(str3);
            TextView textView4 = itemFeedExtraTypePartBinding.extendSubtitle;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.extendSubtitle");
            if (!(str3 == null || str3.length() == 0)) {
                z = false;
            }
            if (z) {
                i = 8;
            }
            textView4.setVisibility(i);
        }
        ImageView imageView = itemFeedExtraTypePartBinding.extendIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.extendIcon");
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        itemFeedExtraTypePartBinding.executePendingBindings();
        if (TextUtils.isEmpty(feed2.getExtraPic())) {
            String feedType = feed2.getFeedType();
            int i2 = (feedType != null && ((hashCode = feedType.hashCode()) == 116079 ? feedType.equals("url") : !(hashCode == 3138974 ? !feedType.equals("feed") : hashCode != 950398559 || !feedType.equals("comment")))) ? 2131231397 : 2131231410;
            ImageView imageView2 = itemFeedExtraTypePartBinding.extendIcon;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.extendIcon");
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            itemFeedExtraTypePartBinding.extendIcon.setImageResource(i2);
            itemFeedExtraTypePartBinding.extendIcon.setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
            return;
        }
        ImageView imageView3 = itemFeedExtraTypePartBinding.extendIcon;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.extendIcon");
        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView imageView4 = itemFeedExtraTypePartBinding.extendIcon;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.extendIcon");
        imageView4.setBackground(null);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemFeedExtraTypePartBinding) getBinding()).setClick(this);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131361886) {
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (FeedUtils.isDiscoveryType(feed2.getFeedType())) {
                Context context = getContext();
                Feed feed3 = this.feed;
                if (feed3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                ActionManager.startAppViewActivity(context, feed3.getPackageName());
                return;
            }
            Feed feed4 = this.feed;
            if (feed4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (Intrinsics.areEqual(feed4.getExtraType(), "apk")) {
                handleApkButtonClick(view);
            }
        } else if (id == 2131362481) {
            Feed feed5 = this.feed;
            if (feed5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (FeedUtils.isDiscoveryType(feed5.getFeedType())) {
                Feed feed6 = this.feed;
                if (feed6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                if (feed6.isIncludedDiscoveryFeed()) {
                    Context context2 = getContext();
                    Feed feed7 = this.feed;
                    if (feed7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feed");
                    }
                    ActionManager.startAppViewActivity(context2, feed7.getPackageName());
                    return;
                }
                Context context3 = getContext();
                StringBuilder sb = new StringBuilder();
                sb.append("https://www.coolapk.com");
                Feed feed8 = this.feed;
                if (feed8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                String extraLinkUrl = feed8.getExtraLinkUrl();
                Intrinsics.checkNotNull(extraLinkUrl);
                sb.append(extraLinkUrl);
                String sb2 = sb.toString();
                Feed feed9 = this.feed;
                if (feed9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                String extraInfo = feed9.getExtraInfo();
                Feed feed10 = this.feed;
                if (feed10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                ActionManager.startExternalMarketByName(context3, sb2, extraInfo, feed10.getExtraKey());
                return;
            }
            Feed feed11 = this.feed;
            if (feed11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (FeedUtils.isAlbumType(feed11.getFeedType())) {
                Context context4 = getContext();
                Feed feed12 = this.feed;
                if (feed12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                ActionManager.startV8AlbumDetailActivity(context4, feed12.getId());
                return;
            }
            Context context5 = getContext();
            Feed feed13 = this.feed;
            if (feed13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            ActionManagerCompat.startActivityByUrl$default(context5, feed13.getExtraUrl(), null, null, 12, null);
            Feed feed14 = this.feed;
            if (feed14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            if (Intrinsics.areEqual(feed14.getExtraType(), "apk")) {
                StatisticHelper.Companion.getInstance().recordEvent("V9页面Card", "动态之推荐应用位");
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0057: APUT  
      (r3v7 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x0053: INVOKE  (r6v1 java.lang.String) = (r6v0 com.coolapk.market.model.Feed), (0 int) type: STATIC call: com.coolapk.market.extend.EntityExtendsKt.getDownloadUrlMd5(com.coolapk.market.model.Feed, int):java.lang.String)
     */
    private final void handleApkButtonClick(View view) {
        String str = null;
        UpgradeInfo upgradeInfo = null;
        DataManager instance = DataManager.getInstance();
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        MobileApp mobileAppExistFast = instance.getMobileAppExistFast(EntityExtendsKt.getApkExtraPackageName(feed2));
        if (mobileAppExistFast != null) {
            upgradeInfo = mobileAppExistFast.getUpgradeInfo();
        }
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        ClickInfo.Builder newBuilder = ClickInfo.newBuilder(feed3);
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        ClickInfo.Builder packageName = newBuilder.packageName(EntityExtendsKt.getApkExtraPackageName(feed4));
        Feed feed5 = this.feed;
        if (feed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        ClickInfo.Builder targetUrl = packageName.targetUrl(EntityExtendsKt.getDownloadUrl(feed5, 0));
        String[] strArr = new String[4];
        Feed feed6 = this.feed;
        if (feed6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        strArr[0] = EntityExtendsKt.getDownloadUrlMd5(feed6, 0);
        Feed feed7 = this.feed;
        if (feed7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        strArr[1] = EntityExtendsKt.getDownloadUrlMd5(feed7, 2);
        strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
        if (upgradeInfo != null) {
            str = upgradeInfo.getDownloadUrlMd5(1);
        }
        strArr[3] = str;
        StateUtils.handleClick(UiUtils.getActivityNullable(getContext()), targetUrl.downloadKeys(strArr).build(), view);
    }

    private final void loadBlurLogoBackground(String str) {
        Fragment fragment;
        LinearLayout linearLayout = ((ItemFeedExtraTypePartBinding) getBinding()).extendLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.extendLayout");
        if (GlideImageHelper.shouldLoadAppIcon()) {
            DataBindingComponent dataBindingComponent = this.component;
            if ((dataBindingComponent instanceof FragmentBindingComponent) && ((FragmentBindingComponent) dataBindingComponent).getContainer() != null && (fragment = (Fragment) ((FragmentBindingComponent) this.component).getContainer()) != null) {
                Intrinsics.checkNotNullExpressionValue(fragment, "component.container ?: return");
                GlideApp.with(fragment).asBitmap().load(str).diskCacheStrategy(DiskCacheStrategy.DATA).transform((Transformation<Bitmap>) new BlurLogoTransform()).into((GlideRequest<Bitmap>) new FeedExtraTypeViewPart$loadBlurLogoBackground$1(this, linearLayout));
                return;
            }
            return;
        }
        linearLayout.setBackgroundColor(ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
    }
}
