package com.coolapk.market.viewholder;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemFeedSecondHandViewPartBinding;
import com.coolapk.market.databinding.ItemProductExtraParamsBinding;
import com.coolapk.market.databinding.ItemProductParamsBinding;
import com.coolapk.market.databinding.ItemSecondHandDetailBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.GsonUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.CoolMarketURLSpan;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import group.infotech.drawable.dsl.ShapesKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0005\u001a\u001b\u001c\u001d\u001eB\u0019\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0015J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedSecondHandViewPartBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "component", "Landroidx/databinding/DataBindingComponent;", "inForwardFeed", "", "(Landroidx/databinding/DataBindingComponent;Z)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "list", "", "", "paramsList", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "DataAdapter", "DataViewHolder", "ParamsDataAdapter", "ParamsDataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedSecondHandViewPart.kt */
public final class FeedSecondHandViewPart extends BindingViewPart<ItemFeedSecondHandViewPartBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558725;
    private final DataBindingComponent component;
    private Feed feed;
    private final boolean inForwardFeed;
    private final List<String> list;
    private final List<String> paramsList;

    public FeedSecondHandViewPart(DataBindingComponent dataBindingComponent, boolean z) {
        this.component = dataBindingComponent;
        this.inForwardFeed = z;
        this.list = new ArrayList();
        this.paramsList = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedSecondHandViewPart(DataBindingComponent dataBindingComponent, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataBindingComponent, z);
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSecondHandViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldShowView(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "data");
            return feed.isSecondHand();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedSecondHandViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558725, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemFeedSecondHandViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        if (!this.inForwardFeed) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
            RecyclerView recyclerView = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.tagList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.secondHandParams.tagList");
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView2 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.tagList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.secondHandParams.tagList");
            recyclerView2.setAdapter(new DataAdapter());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            RecyclerView recyclerView3 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.paramsList;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.secondHandParams.paramsList");
            recyclerView3.setLayoutManager(gridLayoutManager);
            RecyclerView recyclerView4 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.paramsList;
            Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.secondHandParams.paramsList");
            recyclerView4.setAdapter(new ParamsDataAdapter());
            RecyclerViewDivider build = RecyclerViewDivider.Companion.with(getContext()).size(NumberExtendsKt.getDp((Number) 8)).asSpace().hideLastDivider().build();
            RecyclerView recyclerView5 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.tagList;
            Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.secondHandParams.tagList");
            build.addTo(recyclerView5);
            RecyclerViewDivider build2 = RecyclerViewDivider.Companion.with(getContext()).size(NumberExtendsKt.getDp((Number) 8)).asSpace().hideLastDivider().build();
            RecyclerView recyclerView6 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.paramsList;
            Intrinsics.checkNotNullExpressionValue(recyclerView6, "binding.secondHandParams.paramsList");
            build2.addTo(recyclerView6);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x03e0  */
    public void onBindToContent(Feed feed2) {
        boolean z;
        String title;
        int i;
        String str;
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedSecondHandViewPart) feed2);
        this.feed = feed2;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        SecondHandInfo secondHandInfo = feed2.getSecondHandInfo();
        if (secondHandInfo == null) {
            ((ItemFeedSecondHandViewPartBinding) getBinding()).executePendingBindings();
            return;
        }
        boolean z2 = UiUtils.getActivityNullable(getContext()) instanceof FeedDetailActivityV8;
        if (z2) {
            TextView textView = ((ItemFeedSecondHandViewPartBinding) getBinding()).textNotice;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textNotice");
            textView.setVisibility(secondHandInfo.isShowNotice() ? 0 : 8);
            LinearLayout linearLayout = ((ItemFeedSecondHandViewPartBinding) getBinding()).urlNoticeLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.urlNoticeLayout");
            linearLayout.setVisibility(secondHandInfo.hasLink() ? 0 : 8);
            TextView textView2 = ((ItemFeedSecondHandViewPartBinding) getBinding()).textNotice;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textNotice");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            int i2 = 2131099790;
            ShapesKt.setSolidColor(gradientDrawable, ColorUtils.setAlphaComponent(ResourceUtils.getColorInt(getContext(), 2131099790), 26));
            Unit unit = Unit.INSTANCE;
            textView2.setBackground(gradientDrawable);
            LinearLayout linearLayout2 = ((ItemFeedSecondHandViewPartBinding) getBinding()).urlNoticeLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.urlNoticeLayout");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setGradientType(0);
            ShapesKt.setSolidColor(gradientDrawable2, ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
            Unit unit2 = Unit.INSTANCE;
            linearLayout2.setBackground(gradientDrawable2);
            boolean isSelled = secondHandInfo.isSelled();
            String str2 = isSelled ? "交易已结束" : "请前往交易";
            TextView textView3 = ((ItemFeedSecondHandViewPartBinding) getBinding()).urlNotice;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.urlNotice");
            textView3.setText("卖家已填写" + secondHandInfo.getSource() + "链接，" + str2);
            String str3 = "<a href=\"" + secondHandInfo.getUrl() + "\">去" + secondHandInfo.getSource() + ">></a>";
            if (isSelled) {
                str3 = "";
            }
            TextViewBindingAdapters.setTextViewLinkable(((ItemFeedSecondHandViewPartBinding) getBinding()).goShoppingView, str3);
            ((ItemFeedSecondHandViewPartBinding) getBinding()).urlNoticeLayout.setOnClickListener(new FeedSecondHandViewPart$onBindToContent$3(this, isSelled, secondHandInfo));
            TextViewBindingAdapters.setTextViewLinkable(((ItemFeedSecondHandViewPartBinding) getBinding()).textNotice, secondHandInfo.getLinkNotice());
            TextView textView4 = ((ItemFeedSecondHandViewPartBinding) getBinding()).textNotice;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.textNotice");
            CharSequence text = textView4.getText();
            if (text instanceof SpannableString) {
                SpannableString spannableString = (SpannableString) text;
                CoolMarketURLSpan[] coolMarketURLSpanArr = (CoolMarketURLSpan[]) spannableString.getSpans(0, text.length(), CoolMarketURLSpan.class);
                int length = coolMarketURLSpanArr.length;
                int i3 = 0;
                while (i3 < length) {
                    CoolMarketURLSpan coolMarketURLSpan = coolMarketURLSpanArr[i3];
                    int spanStart = spannableString.getSpanStart(coolMarketURLSpan);
                    int spanEnd = spannableString.getSpanEnd(coolMarketURLSpan);
                    int spanFlags = spannableString.getSpanFlags(coolMarketURLSpan);
                    spannableString.removeSpan(coolMarketURLSpan);
                    Intrinsics.checkNotNullExpressionValue(coolMarketURLSpan, "span");
                    spannableString.setSpan(new FeedSecondHandViewPart$onBindToContent$4(this, coolMarketURLSpan, coolMarketURLSpan.getURL(), ResourceUtils.getColorInt(getContext(), i2), true), spanStart, spanEnd, spanFlags);
                    i3++;
                    length = length;
                    i2 = 2131099790;
                }
                TextView textView5 = ((ItemFeedSecondHandViewPartBinding) getBinding()).textNotice;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.textNotice");
                textView5.setText(text);
                TextView textView6 = ((ItemFeedSecondHandViewPartBinding) getBinding()).textNotice;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.textNotice");
                textView6.setVisibility(0);
            }
        }
        String configJson = secondHandInfo.getConfigJson();
        boolean z3 = true;
        if (configJson == null || configJson.length() == 0) {
            ItemSecondHandDetailBinding itemSecondHandDetailBinding = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams;
            Intrinsics.checkNotNullExpressionValue(itemSecondHandDetailBinding, "binding.secondHandParams");
            View root = itemSecondHandDetailBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.secondHandParams.root");
            root.setVisibility(8);
            ((ItemFeedSecondHandViewPartBinding) getBinding()).executePendingBindings();
            return;
        }
        JsonElement parse = new JsonParser().parse(secondHandInfo.getConfigJson());
        Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(info.configJson)");
        JsonObject asJsonObject = parse.getAsJsonObject();
        String optString = GsonUtils.optString(asJsonObject, "color");
        String optString2 = GsonUtils.optString(asJsonObject, "ram");
        String optString3 = GsonUtils.optString(asJsonObject, "rom");
        String optString4 = GsonUtils.optString(asJsonObject, "area");
        String optString5 = GsonUtils.optString(asJsonObject, "purity");
        String optString6 = GsonUtils.optString(asJsonObject, "extra");
        if (!TextUtils.isEmpty(secondHandInfo.getProductId())) {
            String productId = secondHandInfo.getProductId();
            Intrinsics.checkNotNull(productId);
            Integer valueOf = Integer.valueOf(productId);
            if (valueOf == null || valueOf.intValue() != 0) {
                z = true;
                String str4 = !z ? "机型" : "类别";
                title = secondHandInfo.getTitle();
                Intrinsics.checkNotNull(title);
                if (!TextUtils.isEmpty(title)) {
                    List<String> list2 = this.paramsList;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append((char) 65306);
                    String title2 = secondHandInfo.getTitle();
                    Intrinsics.checkNotNull(title2);
                    sb.append(title2);
                    list2.add(sb.toString());
                }
                if (!TextUtils.isEmpty(optString)) {
                    List<String> list3 = this.paramsList;
                    Intrinsics.checkNotNullExpressionValue(optString, "colorText");
                    list3.add(optString);
                }
                if (!TextUtils.isEmpty(optString2)) {
                    List<String> list4 = this.paramsList;
                    Intrinsics.checkNotNullExpressionValue(optString2, "ramText");
                    list4.add(optString2);
                }
                if (!TextUtils.isEmpty(optString3)) {
                    List<String> list5 = this.paramsList;
                    Intrinsics.checkNotNullExpressionValue(optString3, "romText");
                    list5.add(optString3);
                }
                if (!TextUtils.isEmpty(optString4)) {
                    List<String> list6 = this.paramsList;
                    Intrinsics.checkNotNullExpressionValue(optString4, "areaText");
                    list6.add(optString4);
                }
                if (!TextUtils.isEmpty(optString5)) {
                    List<String> list7 = this.paramsList;
                    Intrinsics.checkNotNullExpressionValue(optString5, "purityText");
                    list7.add(optString5);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[SecondHand]");
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setShape(0);
                gradientDrawable3.setColor(AppHolder.getAppTheme().getColorAccent());
                gradientDrawable3.setCornerRadius(2.0f);
                gradientDrawable3.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 3.0f), DisplayUtils.dp2px(getContext(), 18.0f));
                spannableStringBuilder.setSpan(new ImageSpan(gradientDrawable3, "[SecondHand]", 0), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) " 商品信息");
                TextView textView7 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.titleView;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.secondHandParams.titleView");
                textView7.setText(spannableStringBuilder);
                ItemSecondHandDetailBinding itemSecondHandDetailBinding2 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams;
                Intrinsics.checkNotNullExpressionValue(itemSecondHandDetailBinding2, "binding.secondHandParams");
                View root2 = itemSecondHandDetailBinding2.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "binding.secondHandParams.root");
                if (z2) {
                    String configJson2 = secondHandInfo.getConfigJson();
                    Intrinsics.checkNotNull(configJson2);
                    Intrinsics.checkNotNullExpressionValue(configJson2, "info.configJson!!");
                    if (configJson2.length() <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i = 0;
                        root2.setVisibility(i);
                        str = optString6;
                        if (!TextUtils.isEmpty(str)) {
                            Intrinsics.checkNotNullExpressionValue(optString6, "extraText");
                            for (String str5 : StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)) {
                                if (!this.list.contains(str5)) {
                                    this.list.add(str5);
                                }
                            }
                        } else {
                            RecyclerView recyclerView = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.tagList;
                            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.secondHandParams.tagList");
                            recyclerView.setVisibility(8);
                        }
                        ((ItemFeedSecondHandViewPartBinding) getBinding()).executePendingBindings();
                    }
                }
                i = 8;
                root2.setVisibility(i);
                str = optString6;
                if (!TextUtils.isEmpty(str)) {
                }
                ((ItemFeedSecondHandViewPartBinding) getBinding()).executePendingBindings();
            }
        }
        z = false;
        if (!z) {
        }
        title = secondHandInfo.getTitle();
        Intrinsics.checkNotNull(title);
        if (!TextUtils.isEmpty(title)) {
        }
        if (!TextUtils.isEmpty(optString)) {
        }
        if (!TextUtils.isEmpty(optString2)) {
        }
        if (!TextUtils.isEmpty(optString3)) {
        }
        if (!TextUtils.isEmpty(optString4)) {
        }
        if (!TextUtils.isEmpty(optString5)) {
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[SecondHand]");
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setColor(AppHolder.getAppTheme().getColorAccent());
        gradientDrawable3.setCornerRadius(2.0f);
        gradientDrawable3.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 3.0f), DisplayUtils.dp2px(getContext(), 18.0f));
        spannableStringBuilder.setSpan(new ImageSpan(gradientDrawable3, "[SecondHand]", 0), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) " 商品信息");
        TextView textView7 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams.titleView;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.secondHandParams.titleView");
        textView7.setText(spannableStringBuilder);
        ItemSecondHandDetailBinding itemSecondHandDetailBinding2 = ((ItemFeedSecondHandViewPartBinding) getBinding()).secondHandParams;
        Intrinsics.checkNotNullExpressionValue(itemSecondHandDetailBinding2, "binding.secondHandParams");
        View root2 = itemSecondHandDetailBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.secondHandParams.root");
        if (z2) {
        }
        i = 8;
        root2.setVisibility(i);
        str = optString6;
        if (!TextUtils.isEmpty(str)) {
        }
        ((ItemFeedSecondHandViewPartBinding) getBinding()).executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$ParamsDataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$ParamsDataViewHolder;", "(Lcom/coolapk/market/viewholder/FeedSecondHandViewPart;)V", "dataSet", "", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSecondHandViewPart.kt */
    public final class ParamsDataAdapter extends RecyclerView.Adapter<ParamsDataViewHolder> {
        private final List<String> dataSet;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ParamsDataAdapter() {
            this.dataSet = FeedSecondHandViewPart.this.paramsList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ParamsDataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558870, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new ParamsDataViewHolder(inflate);
        }

        public void onBindViewHolder(ParamsDataViewHolder paramsDataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(paramsDataViewHolder, "holder");
            paramsDataViewHolder.bindTo(this.dataSet.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataSet.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$DataViewHolder;", "(Lcom/coolapk/market/viewholder/FeedSecondHandViewPart;)V", "dataSet", "", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSecondHandViewPart.kt */
    public final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        private final List<String> dataSet;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
            this.dataSet = FeedSecondHandViewPart.this.list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558867, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate);
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            dataViewHolder.bindTo(this.dataSet.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataSet.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemProductExtraParamsBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSecondHandViewPart.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558867;
        private final ItemProductExtraParamsBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemProductExtraParamsBinding itemProductExtraParamsBinding = (ItemProductExtraParamsBinding) getBinding();
            this.binding = itemProductExtraParamsBinding;
            Intrinsics.checkNotNullExpressionValue(itemProductExtraParamsBinding, "binding");
            itemProductExtraParamsBinding.setClick(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedSecondHandViewPart.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            TextView textView = this.binding.titleParamsView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleParamsView");
            textView.setText((String) obj);
            this.binding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            view.getId();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$ParamsDataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemProductParamsBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSecondHandViewPart.kt */
    public static final class ParamsDataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558870;
        private final ItemProductParamsBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParamsDataViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemProductParamsBinding itemProductParamsBinding = (ItemProductParamsBinding) getBinding();
            this.binding = itemProductParamsBinding;
            Intrinsics.checkNotNullExpressionValue(itemProductParamsBinding, "binding");
            itemProductParamsBinding.setClick(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandViewPart$ParamsDataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedSecondHandViewPart.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            TextView textView = this.binding.titleParamsView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleParamsView");
            textView.setText((String) obj);
            this.binding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            view.getId();
        }
    }
}
