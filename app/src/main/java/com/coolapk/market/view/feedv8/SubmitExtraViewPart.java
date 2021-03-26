package com.coolapk.market.view.feedv8;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.SubmitFeedBottomSetVisibilityBinding;
import com.coolapk.market.databinding.SubmitFeedExtraChildBinding;
import com.coolapk.market.databinding.SubmitFeedExtraLogoBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.LocationInfo;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.dyhv8.DyhIncludActivity;
import com.coolapk.market.viewholder.iview.ViewPart;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SubmitExtraViewPart.kt */
public final class SubmitExtraViewPart extends ViewPart {
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_CATEGORY = 2131363440;
    public static final int TYPE_FORWARD_AND_REPLY = 2131363441;
    public static final int TYPE_KAN_KAN_HAO = 2131363442;
    public static final int TYPE_LOCATION = 2131363444;
    public static final int TYPE_SH_OUT_LINK = 2131363446;
    public static final int TYPE_SH_PARAMTER = 2131363448;
    public static final int TYPE_SH_PRICE = 2131363450;
    public static final int TYPE_SH_TYPE = 2131363454;
    public static final int TYPE_VISIBILITY = 2131363458;
    private SubmitFeedV8Activity activity;
    private final SparseArray<SubmitFeedExtraChildBinding> bindingArray = new SparseArray<>();
    private LocationInfo locationInfo;

    private final void onPickDyh(String str) {
    }

    private final void onRequestDyh() {
    }

    public static final /* synthetic */ SubmitFeedV8Activity access$getActivity$p(SubmitExtraViewPart submitExtraViewPart) {
        SubmitFeedV8Activity submitFeedV8Activity = submitExtraViewPart.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        return submitFeedV8Activity;
    }

    /* compiled from: SubmitExtraViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void fillRelativeInfoViewIntoLayout$default(Companion companion, LinearLayout linearLayout, FeedUIConfig feedUIConfig, LinearLayout.LayoutParams layoutParams, int i, Object obj) {
            if ((i & 4) != 0) {
                layoutParams = null;
            }
            companion.fillRelativeInfoViewIntoLayout(linearLayout, feedUIConfig, layoutParams);
        }

        public final void fillRelativeInfoViewIntoLayout(LinearLayout linearLayout, FeedUIConfig feedUIConfig, LinearLayout.LayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(linearLayout, "layout");
            Intrinsics.checkNotNullParameter(feedUIConfig, "uiConfig");
            Context context = linearLayout.getContext();
            String relativeLogo = feedUIConfig.relativeLogo();
            boolean z = true;
            if (!(relativeLogo == null || relativeLogo.length() == 0)) {
                String relativeTitle = feedUIConfig.relativeTitle();
                if (!(relativeTitle == null || relativeTitle.length() == 0)) {
                    z = false;
                }
                if (!z && linearLayout.getChildCount() <= 0) {
                    SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding = (SubmitFeedExtraLogoBinding) DataBindingUtil.inflate(LayoutInflater.from(linearLayout.getContext()), 2131559158, linearLayout, false);
                    TextView textView = submitFeedExtraLogoBinding.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                    textView.setText(feedUIConfig.relativeTitle());
                    Intrinsics.checkNotNullExpressionValue(submitFeedExtraLogoBinding, "binding");
                    submitFeedExtraLogoBinding.setClick(new SubmitExtraViewPart$Companion$fillRelativeInfoViewIntoLayout$listener$1(context, feedUIConfig));
                    ImageLoaderOptions.Builder newBuilder = ImageLoaderOptions.newBuilder();
                    int i = 2131231172;
                    if (!feedUIConfig.isSecondHandViewVisible()) {
                        i = 2131231363;
                    }
                    LinearLayout.LayoutParams layoutParams2 = null;
                    AppHolder.getContextImageLoader().displayImage(context, feedUIConfig.relativeLogo(), submitFeedExtraLogoBinding.imageView, newBuilder.placeHolderRes(i).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 4), false, 2, null));
                    linearLayout.addView(submitFeedExtraLogoBinding.getRoot());
                    Intrinsics.checkNotNullExpressionValue(context, "activity");
                    View newSmallDividerView = newSmallDividerView(context);
                    if (layoutParams != null) {
                        newSmallDividerView.setLayoutParams(layoutParams);
                    } else {
                        ViewGroup.LayoutParams layoutParams3 = newSmallDividerView.getLayoutParams();
                        if (layoutParams3 instanceof LinearLayout.LayoutParams) {
                            layoutParams2 = layoutParams3;
                        }
                        LinearLayout.LayoutParams layoutParams4 = layoutParams2;
                        if (layoutParams4 != null) {
                            layoutParams4.height = DisplayUtils.dp2px(context, 8.0f);
                            layoutParams4.leftMargin = 0;
                            layoutParams4.rightMargin = 0;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    linearLayout.addView(newSmallDividerView);
                }
            }
        }

        public final View newSmallDividerView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            View view = new View(context);
            view.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(2131165598));
            layoutParams.leftMargin = DisplayUtils.dp2px(context, 16.0f);
            layoutParams.rightMargin = DisplayUtils.dp2px(context, 16.0f);
            Unit unit = Unit.INSTANCE;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(layoutInflater.getContext());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        return linearLayout;
    }

    public final void initWith(SubmitFeedV8Activity submitFeedV8Activity) {
        Intrinsics.checkNotNullParameter(submitFeedV8Activity, "activity");
        this.activity = submitFeedV8Activity;
        View view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        Companion companion = Companion;
        SubmitFeedV8Activity submitFeedV8Activity2 = submitFeedV8Activity;
        linearLayout.addView(companion.newSmallDividerView(submitFeedV8Activity2));
        boolean isLocationViewVisible = submitFeedV8Activity.getUiConfig().isLocationViewVisible();
        boolean areEqual = Intrinsics.areEqual(submitFeedV8Activity.getMultiPart().type(), "picture");
        boolean isAnonymousAnswerBarVisible = submitFeedV8Activity.getUiConfig().isAnonymousAnswerBarVisible();
        LinearLayout.LayoutParams layoutParams = null;
        if (isLocationViewVisible) {
            SubmitFeedExtraChildBinding newSubmitExtraBinding = newSubmitExtraBinding(linearLayout);
            Intrinsics.checkNotNullExpressionValue(newSubmitExtraBinding, "binding");
            newSubmitExtraBinding.setClick(this);
            View root = newSubmitExtraBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setId(2131363444);
            this.bindingArray.put(2131363444, newSubmitExtraBinding);
            linearLayout.addView(newSubmitExtraBinding.getRoot());
            updateLocationInfo();
            View newSmallDividerView = companion.newSmallDividerView(submitFeedV8Activity2);
            ViewGroup.LayoutParams layoutParams2 = newSmallDividerView.getLayoutParams();
            if (!(layoutParams2 instanceof LinearLayout.LayoutParams)) {
                layoutParams2 = null;
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
            if (layoutParams3 != null) {
                layoutParams3.height = DisplayUtils.dp2px(submitFeedV8Activity2, 8.0f);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(newSmallDividerView);
        }
        if (areEqual) {
            SubmitFeedExtraChildBinding newSubmitExtraBinding2 = newSubmitExtraBinding(linearLayout);
            Intrinsics.checkNotNullExpressionValue(newSubmitExtraBinding2, "binding");
            newSubmitExtraBinding2.setClick(this);
            View root2 = newSubmitExtraBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setId(2131363440);
            this.bindingArray.put(2131363440, newSubmitExtraBinding2);
            linearLayout.addView(newSubmitExtraBinding2.getRoot());
            linearLayout.addView(companion.newSmallDividerView(submitFeedV8Activity2));
            updateCategory();
        }
        if (isAnonymousAnswerBarVisible) {
            View childAt = linearLayout.getChildAt(linearLayout.getChildCount() - 1);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                if (layoutParams4 instanceof LinearLayout.LayoutParams) {
                    layoutParams = layoutParams4;
                }
                LinearLayout.LayoutParams layoutParams5 = layoutParams;
                if (layoutParams5 != null) {
                    layoutParams5.height = DisplayUtils.dp2px(submitFeedV8Activity2, 8.0f);
                    layoutParams5.leftMargin = 0;
                    layoutParams5.rightMargin = 0;
                }
            }
            SubmitFeedExtraChildBinding newSubmitExtraBinding3 = newSubmitExtraBinding(linearLayout);
            Intrinsics.checkNotNullExpressionValue(newSubmitExtraBinding3, "binding");
            newSubmitExtraBinding3.setClick(this);
            View root3 = newSubmitExtraBinding3.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            root3.setId(2131363458);
            this.bindingArray.put(2131363458, newSubmitExtraBinding3);
            linearLayout.addView(newSubmitExtraBinding3.getRoot());
            linearLayout.addView(companion.newSmallDividerView(submitFeedV8Activity2));
            updateVisibilityInfo();
        }
        View childAt2 = linearLayout.getChildAt(linearLayout.getChildCount() - 1);
        if (childAt2 != null) {
            ViewExtendsKt.detachFromParent(childAt2);
        }
    }

    public final void fillForwardViewIntoLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "layout");
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        boolean isForward = submitFeedV8Activity.getUiConfig().isForward();
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        Entity forwardEntity = submitFeedV8Activity2.getUiConfig().forwardEntity();
        boolean z = (forwardEntity instanceof Feed) && Intrinsics.areEqual(((Feed) forwardEntity).getFeedType(), "question");
        if (isForward && !z) {
            SubmitFeedExtraChildBinding newSubmitExtraBinding = newSubmitExtraBinding(linearLayout);
            Intrinsics.checkNotNullExpressionValue(newSubmitExtraBinding, "binding");
            newSubmitExtraBinding.setClick(this);
            View root = newSubmitExtraBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setId(2131363441);
            this.bindingArray.put(2131363441, newSubmitExtraBinding);
            linearLayout.addView(newSubmitExtraBinding.getRoot());
            updateForwardAndReplyInfo();
        }
    }

    private final SubmitFeedExtraChildBinding newSubmitExtraBinding(LinearLayout linearLayout) {
        return (SubmitFeedExtraChildBinding) DataBindingUtil.inflate(LayoutInflater.from(linearLayout.getContext()), 2131559157, linearLayout, false);
    }

    private final void setTint(SubmitFeedExtraChildBinding submitFeedExtraChildBinding, int i) {
        submitFeedExtraChildBinding.arrowView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        submitFeedExtraChildBinding.imageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        submitFeedExtraChildBinding.titleView.setTextColor(i);
        submitFeedExtraChildBinding.descriptionView.setTextColor(i);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        int id = view.getId();
        if (id == 2131363444) {
            onRequestLocation();
        } else if (id != 2131363458) {
            switch (id) {
                case 2131363440:
                    onRequestCategory();
                    return;
                case 2131363441:
                    onRequestForwardAndReply();
                    return;
                case 2131363442:
                    onRequestDyh();
                    return;
                default:
                    return;
            }
        } else {
            onRequestVisibility();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        String result;
        Intrinsics.checkNotNullParameter(intent, "data");
        if (i == 888) {
            Parcelable parcelableExtra = intent.getParcelableExtra("KEY_LOCATION");
            Intrinsics.checkNotNull(parcelableExtra);
            Intrinsics.checkNotNullExpressionValue(parcelableExtra, "data.getParcelableExtra<…nFragment.KEY_LOCATION)!!");
            onPickLocation((LocationInfo) parcelableExtra);
        } else if (i == 3423) {
            String result2 = PickPicCategoryFragment.Companion.getResult(intent);
            String replace$default = result2 != null ? StringsKt.replace$default(result2, "#", "", false, 4, (Object) null) : null;
            if (replace$default != null) {
                onPickCategory(replace$default);
            }
        } else if (i == 6666 && (result = DyhIncludActivity.Companion.getResult(intent)) != null) {
            onPickDyh(result);
        }
    }

    private final void onRequestLocation() {
        LocationInfo locationInfo2 = this.locationInfo;
        if (locationInfo2 == null) {
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedMultiPart multiPart = submitFeedV8Activity.getMultiPart();
            if (!TextUtils.isEmpty(multiPart.location())) {
                locationInfo2 = LocationInfo.newBuilder().setAddress(multiPart.location()).setSnippet("").setCity(multiPart.locationCity()).setCountry(multiPart.locationCountry()).setLongAddress(multiPart.longLocation()).setLatitude(Double.valueOf(multiPart.latitude())).setLongitude(Double.valueOf(multiPart.longitude())).setBusinessArea("").setIsChecked(true).setIsHideLocation(false).setEntityType("location").build();
            }
        }
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        if (Intrinsics.areEqual(submitFeedV8Activity2.getMultiPart().type(), "ershou")) {
            SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
            if (submitFeedV8Activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            ActionManager.startNearActivity(submitFeedV8Activity3, locationInfo2, "ershou");
            return;
        }
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        ActionManager.startNearActivity(submitFeedV8Activity4, locationInfo2);
    }

    private final void onPickLocation(LocationInfo locationInfo2) {
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder = FeedMultiPart.builder(submitFeedV8Activity.getMultiPart());
        double d = 0.0d;
        String str = "";
        if (locationInfo2.getIsHideLocation()) {
            builder.location(str).longitude(0.0d).latitude(0.0d).longLocation(str).province(str).cityCode(str).locationCity(str).locationCountry(str);
        } else {
            String address = locationInfo2.getAddress();
            if (address == null) {
                address = str;
            }
            FeedMultiPart.Builder location = builder.location(address);
            Double longitude = locationInfo2.getLongitude();
            FeedMultiPart.Builder longitude2 = location.longitude(longitude != null ? longitude.doubleValue() : 0.0d);
            Double latitude = locationInfo2.getLatitude();
            if (latitude != null) {
                d = latitude.doubleValue();
            }
            FeedMultiPart.Builder latitude2 = longitude2.latitude(d);
            String longAddress = locationInfo2.getLongAddress();
            if (longAddress == null) {
                longAddress = str;
            }
            FeedMultiPart.Builder longLocation = latitude2.longLocation(longAddress);
            String city = locationInfo2.getCity();
            if (city == null) {
                city = str;
            }
            FeedMultiPart.Builder locationCity = longLocation.locationCity(city);
            String province = locationInfo2.getProvince();
            if (province == null) {
                province = str;
            }
            FeedMultiPart.Builder province2 = locationCity.province(province);
            String cityCode = locationInfo2.getCityCode();
            if (cityCode == null) {
                cityCode = str;
            }
            FeedMultiPart.Builder cityCode2 = province2.cityCode(cityCode);
            String country = locationInfo2.getCountry();
            if (country == null) {
                country = str;
            }
            cityCode2.locationCountry(country);
        }
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        submitFeedV8Activity2.updateMultiPart(build);
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig.Builder tintMarkView = FeedUIConfig.builder(submitFeedV8Activity3.getUiConfig()).tintMarkView(!locationInfo2.getIsHideLocation());
        String address2 = locationInfo2.getAddress();
        if (address2 != null) {
            str = address2;
        }
        FeedUIConfig build2 = tintMarkView.locationName(str).build();
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        Intrinsics.checkNotNullExpressionValue(build2, "uiConfig");
        submitFeedV8Activity4.updateUIConfig(build2);
        this.locationInfo = locationInfo2;
        updateLocationInfo();
    }

    private final void updateLocationInfo() {
        SubmitFeedExtraChildBinding submitFeedExtraChildBinding = this.bindingArray.get(2131363444);
        if (submitFeedExtraChildBinding != null) {
            SubmitFeedExtraChildBinding submitFeedExtraChildBinding2 = submitFeedExtraChildBinding;
            submitFeedExtraChildBinding2.imageView.setImageResource(2131231418);
            TextView textView = submitFeedExtraChildBinding2.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
            textView.setText("");
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
            String locationName = uiConfig.locationName();
            Intrinsics.checkNotNullExpressionValue(locationName, "uiConfig.locationName()");
            if (!(locationName.length() == 0) || uiConfig.tintMarkView()) {
                setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
                TextView textView2 = submitFeedExtraChildBinding2.titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                textView2.setText(uiConfig.locationName());
                return;
            }
            SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
            if (submitFeedV8Activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity2, 2131099891));
            submitFeedExtraChildBinding2.titleView.setText(2131887172);
        }
    }

    public final void initLocation(LocationInfo locationInfo2) {
        Intrinsics.checkNotNullParameter(locationInfo2, "info");
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig build = FeedUIConfig.builder(submitFeedV8Activity.getUiConfig()).tintMarkView(!locationInfo2.getIsHideLocation()).locationName(locationInfo2.getCity()).build();
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        Intrinsics.checkNotNullExpressionValue(build, "uiConfig");
        submitFeedV8Activity2.updateUIConfig(build);
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder = FeedMultiPart.builder(submitFeedV8Activity3.getMultiPart());
        FeedMultiPart.Builder location = builder.location(locationInfo2.getCity());
        Double longitude = locationInfo2.getLongitude();
        Intrinsics.checkNotNullExpressionValue(longitude, "info.longitude");
        FeedMultiPart.Builder longitude2 = location.longitude(longitude.doubleValue());
        Double latitude = locationInfo2.getLatitude();
        Intrinsics.checkNotNullExpressionValue(latitude, "info.latitude");
        longitude2.latitude(latitude.doubleValue()).longLocation(locationInfo2.getLongAddress()).locationCity(locationInfo2.getCity()).province(locationInfo2.getProvince()).cityCode(locationInfo2.getCityCode()).locationCountry(locationInfo2.getCountry());
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
        submitFeedV8Activity4.updateMultiPart(build2);
        this.locationInfo = locationInfo2;
        updateLocationInfo();
    }

    private final void updateSecondHandInfo(int i) {
        int i2;
        SubmitFeedExtraChildBinding submitFeedExtraChildBinding = this.bindingArray.get(i);
        if (submitFeedExtraChildBinding != null) {
            SubmitFeedExtraChildBinding submitFeedExtraChildBinding2 = submitFeedExtraChildBinding;
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
            SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
            if (submitFeedV8Activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            boolean z = true;
            boolean z2 = !Intrinsics.areEqual(submitFeedV8Activity2.getMultiPart().secondHandSthType(), "104");
            SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
            if (submitFeedV8Activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig.Builder builder = FeedUIConfig.builder(submitFeedV8Activity3.getUiConfig());
            builder.showParamsItem(z2);
            SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
            if (submitFeedV8Activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "uiBuilder.build()");
            submitFeedV8Activity4.updateUIConfig(build);
            String str = "";
            if (i == 2131363446) {
                TextView textView = submitFeedExtraChildBinding2.titleView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                textView.setText("闲鱼/转转链接");
                submitFeedExtraChildBinding2.imageView.setImageResource(2131231401);
                TextView textView2 = submitFeedExtraChildBinding2.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
                textView2.setText(!TextUtils.isEmpty(uiConfig.secondHandOutLink()) ? "已填写" : str);
                String secondHandOutLink = uiConfig.secondHandOutLink();
                if (!(secondHandOutLink == null || secondHandOutLink.length() == 0)) {
                    z = false;
                }
                if (z) {
                    SubmitFeedV8Activity submitFeedV8Activity5 = this.activity;
                    if (submitFeedV8Activity5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity5, 2131099891));
                    return;
                }
                setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
            } else if (i == 2131363448) {
                LinearLayout linearLayout = submitFeedExtraChildBinding2.itemView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
                linearLayout.setClickable(uiConfig.showParamsItem());
                TextView textView3 = submitFeedExtraChildBinding2.titleView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                textView3.setText("基本参数");
                submitFeedExtraChildBinding2.imageView.setImageResource(2131231173);
                TextView textView4 = submitFeedExtraChildBinding2.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
                String productConfigShowText = uiConfig.productConfigShowText();
                if (productConfigShowText != null) {
                    str = productConfigShowText;
                }
                textView4.setText(str);
                if (!TextUtils.isEmpty(uiConfig.productConfigShowText())) {
                    setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
                } else {
                    SubmitFeedV8Activity submitFeedV8Activity6 = this.activity;
                    if (submitFeedV8Activity6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity6, 2131099891));
                }
                if (!TextUtils.isEmpty(uiConfig.productConfigShowText())) {
                    i2 = AppHolder.getAppTheme().getColorAccent();
                } else if (!uiConfig.showParamsItem()) {
                    i2 = AppHolder.getAppTheme().getContentBackgroundDividerColor();
                } else {
                    SubmitFeedV8Activity submitFeedV8Activity7 = this.activity;
                    if (submitFeedV8Activity7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    i2 = ResourceUtils.getColorInt(submitFeedV8Activity7, 2131099891);
                }
                setTint(submitFeedExtraChildBinding2, i2);
            } else if (i != 2131363450) {
                TextView textView5 = submitFeedExtraChildBinding2.titleView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
                textView5.setText(str);
                submitFeedExtraChildBinding2.imageView.setImageResource(0);
                TextView textView6 = submitFeedExtraChildBinding2.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.descriptionView");
                textView6.setText(str);
            } else {
                TextView textView7 = submitFeedExtraChildBinding2.titleView;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
                textView7.setText("开个价");
                submitFeedExtraChildBinding2.imageView.setImageResource(2131231238);
                String secondHandPrice = uiConfig.secondHandPrice();
                if (secondHandPrice == null) {
                    secondHandPrice = str;
                }
                Intrinsics.checkNotNullExpressionValue(secondHandPrice, "uiConfig.secondHandPrice().elvis { \"\" }");
                TextView textView8 = submitFeedExtraChildBinding2.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView8, "binding.descriptionView");
                boolean z3 = secondHandPrice.length() == 0;
                String str2 = (char) 165 + secondHandPrice;
                if (!z3) {
                    str = str2;
                }
                textView8.setText(str);
                String secondHandPrice2 = uiConfig.secondHandPrice();
                if (!(secondHandPrice2 == null || secondHandPrice2.length() == 0)) {
                    z = false;
                }
                if (z) {
                    SubmitFeedV8Activity submitFeedV8Activity8 = this.activity;
                    if (submitFeedV8Activity8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity8, 2131099891));
                    return;
                }
                setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
            }
        }
    }

    private final void updateDyhInfo() {
        SubmitFeedExtraChildBinding submitFeedExtraChildBinding = this.bindingArray.get(2131363442);
        if (submitFeedExtraChildBinding != null) {
            SubmitFeedExtraChildBinding submitFeedExtraChildBinding2 = submitFeedExtraChildBinding;
            submitFeedExtraChildBinding2.imageView.setImageResource(2131231380);
            TextView textView = submitFeedExtraChildBinding2.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText("发布到看看号");
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
            String dyhTitle = uiConfig.dyhTitle();
            if (dyhTitle == null || dyhTitle.length() == 0) {
                SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
                if (submitFeedV8Activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity2, 2131099891));
                TextView textView2 = submitFeedExtraChildBinding2.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
                textView2.setText("");
                return;
            }
            setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
            TextView textView3 = submitFeedExtraChildBinding2.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
            textView3.setText(uiConfig.dyhTitle());
        }
    }

    private final void onRequestVisibility() {
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        SubmitFeedBottomSetVisibilityBinding submitFeedBottomSetVisibilityBinding = (SubmitFeedBottomSetVisibilityBinding) DataBindingUtil.inflate(LayoutInflater.from(submitFeedV8Activity), 2131559156, null, false);
        Intrinsics.checkNotNullExpressionValue(submitFeedBottomSetVisibilityBinding, "binding");
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        submitFeedBottomSetVisibilityBinding.setUiConfig(submitFeedV8Activity2.getUiConfig());
        View root = submitFeedBottomSetVisibilityBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        float dpf = NumberExtendsKt.getDpf((Number) 12);
        gradientDrawable.setCornerRadii(new float[]{dpf, dpf, dpf, dpf, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        root.setBackground(gradientDrawable);
        View root2 = submitFeedBottomSetVisibilityBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        ViewExtents2Kt.tryListenWindowsInset(root2, new SubmitExtraViewPart$onRequestVisibility$2(submitFeedBottomSetVisibilityBinding));
        DialogUtil dialogUtil = DialogUtil.INSTANCE;
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        View root3 = submitFeedBottomSetVisibilityBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
        submitFeedBottomSetVisibilityBinding.setClick(new SubmitExtraViewPart$onRequestVisibility$3(this, dialogUtil.showBottomSheetDialog(submitFeedV8Activity3, root3, true, true)));
    }

    public final void updateVisibilityInfo() {
        SubmitFeedExtraChildBinding submitFeedExtraChildBinding = this.bindingArray.get(2131363458);
        if (submitFeedExtraChildBinding != null) {
            SubmitFeedExtraChildBinding submitFeedExtraChildBinding2 = submitFeedExtraChildBinding;
            submitFeedExtraChildBinding2.imageView.setImageResource(2131231287);
            TextView textView = submitFeedExtraChildBinding2.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText("谁可以看");
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            int visibleState = submitFeedV8Activity.getUiConfig().visibleState();
            if (visibleState == -1) {
                submitFeedExtraChildBinding2.descriptionView.setText(2131887175);
                setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
            } else if (visibleState == 1) {
                submitFeedExtraChildBinding2.descriptionView.setText(2131887174);
                SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
                if (submitFeedV8Activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity2, 2131099891));
            }
        }
    }

    private final void onRequestCategory() {
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        ActionManager.startPickPicCategoryFragment(submitFeedV8Activity);
    }

    private final void onPickCategory(String str) {
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig build = FeedUIConfig.builder(submitFeedV8Activity2.getUiConfig()).topicTitle(str).submitToText(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(act…\n                .build()");
        submitFeedV8Activity.updateUIConfig(build);
        updateCategory();
    }

    private final void updateCategory() {
        SubmitFeedExtraChildBinding submitFeedExtraChildBinding = this.bindingArray.get(2131363440);
        if (submitFeedExtraChildBinding != null) {
            SubmitFeedExtraChildBinding submitFeedExtraChildBinding2 = submitFeedExtraChildBinding;
            submitFeedExtraChildBinding2.imageView.setImageResource(2131231170);
            TextView textView = submitFeedExtraChildBinding2.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText("选择分类");
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
            String str = uiConfig.topicTitle();
            if (str == null || str.length() == 0) {
                SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
                if (submitFeedV8Activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity2, 2131099891));
                TextView textView2 = submitFeedExtraChildBinding2.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
                textView2.setText("");
                return;
            }
            setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
            TextView textView3 = submitFeedExtraChildBinding2.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
            textView3.setText(uiConfig.topicTitle());
        }
    }

    private final void updateForwardAndReplyInfo() {
        CheckBox checkBox;
        SubmitFeedExtraChildBinding submitFeedExtraChildBinding = this.bindingArray.get(2131363441);
        if (submitFeedExtraChildBinding != null) {
            SubmitFeedExtraChildBinding submitFeedExtraChildBinding2 = submitFeedExtraChildBinding;
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedMultiPart multiPart = submitFeedV8Activity.getMultiPart();
            submitFeedExtraChildBinding2.titleView.setText(2131886884);
            TextView textView = submitFeedExtraChildBinding2.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
            textView.setText("");
            ImageView imageView = submitFeedExtraChildBinding2.arrowView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.arrowView");
            imageView.setVisibility(8);
            ImageView imageView2 = submitFeedExtraChildBinding2.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageView");
            if (imageView2.getParent() == null) {
                ImageView imageView3 = submitFeedExtraChildBinding2.imageView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.imageView");
                Object tag = imageView3.getTag();
                if (!(tag instanceof CheckBox)) {
                    tag = null;
                }
                checkBox = (CheckBox) tag;
                Intrinsics.checkNotNull(checkBox);
            } else {
                SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
                if (submitFeedV8Activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                checkBox = new CheckBox(submitFeedV8Activity2);
                TintHelper.setTint(checkBox, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
                ImageView imageView4 = submitFeedExtraChildBinding2.imageView;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.imageView");
                imageView4.setTag(checkBox);
                checkBox.setChecked(multiPart.isReplyWithForward());
                checkBox.setOnCheckedChangeListener(new SubmitExtraViewPart$updateForwardAndReplyInfo$checkBox$1(this));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                Unit unit = Unit.INSTANCE;
                checkBox.setLayoutParams(layoutParams);
                SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
                if (submitFeedV8Activity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FrameLayout frameLayout = new FrameLayout(submitFeedV8Activity3);
                frameLayout.addView(checkBox);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ConvertUtils.dp2px(40.0f), -2);
                layoutParams2.leftMargin = ConvertUtils.dp2px(8.0f);
                layoutParams2.rightMargin = ConvertUtils.dp2px(8.0f);
                Unit unit2 = Unit.INSTANCE;
                frameLayout.setLayoutParams(layoutParams2);
                ViewUtil.replaceView(submitFeedExtraChildBinding2.imageView, frameLayout);
            }
            if (checkBox.isChecked() != multiPart.isReplyWithForward()) {
                checkBox.setChecked(multiPart.isReplyWithForward());
            }
            if (!multiPart.isReplyWithForward()) {
                SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
                if (submitFeedV8Activity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                setTint(submitFeedExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity4, 2131099891));
                return;
            }
            setTint(submitFeedExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
        }
    }

    public final void onRequestForwardAndReply() {
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart multiPart = submitFeedV8Activity.getMultiPart();
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build = multiPart.newBuilder().isReplyWithForward(!multiPart.isReplyWithForward()).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …\n                .build()");
        submitFeedV8Activity2.updateMultiPart(build);
        updateForwardAndReplyInfo();
    }
}
