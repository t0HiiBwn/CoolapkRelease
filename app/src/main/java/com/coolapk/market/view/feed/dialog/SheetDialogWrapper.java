package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemActionSheetDialogBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetDialogWrapper.kt */
public final class SheetDialogWrapper<T> {
    public static final Companion Companion = new Companion(null);
    private TextView cancelTextView;
    private List<SheetGroup> currentSheetGroupList;
    private final T data;
    private Function0<Unit> dismissAction;
    private final SheetGroupListFactory<? super T> factory;
    private final SheetFactoryOptions options;
    private LinearLayout recyclerViewContainer;

    private SheetDialogWrapper(T t, SheetGroupListFactory<? super T> sheetGroupListFactory, SheetFactoryOptions sheetFactoryOptions) {
        this.data = t;
        this.factory = sheetGroupListFactory;
        this.options = sheetFactoryOptions;
    }

    public /* synthetic */ SheetDialogWrapper(Object obj, SheetGroupListFactory sheetGroupListFactory, SheetFactoryOptions sheetFactoryOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, sheetGroupListFactory, sheetFactoryOptions);
    }

    public static final /* synthetic */ TextView access$getCancelTextView$p(SheetDialogWrapper sheetDialogWrapper) {
        TextView textView = sheetDialogWrapper.cancelTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelTextView");
        }
        return textView;
    }

    public final T getData() {
        return this.data;
    }

    public final SheetGroupListFactory<? super T> getFactory() {
        return this.factory;
    }

    public final SheetFactoryOptions getOptions() {
        return this.options;
    }

    /* compiled from: SheetDialogWrapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feed.dialog.SheetDialogWrapper$Companion */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SheetDialogWrapper create$default(Companion companion, Object obj, SheetGroupListFactory sheetGroupListFactory, SheetFactoryOptions sheetFactoryOptions, int i, Object obj2) {
            if ((i & 2) != 0) {
                sheetGroupListFactory = DefaultSheetGroupListFactory.INSTANCE;
            }
            if ((i & 4) != 0) {
                sheetFactoryOptions = SheetFactoryOptions.Companion.getDEFAULT();
            }
            return companion.create(obj, sheetGroupListFactory, sheetFactoryOptions);
        }

        public final <T> SheetDialogWrapper<T> create(T t, SheetGroupListFactory<? super T> sheetGroupListFactory, SheetFactoryOptions sheetFactoryOptions) {
            Intrinsics.checkNotNullParameter(t, "data");
            Intrinsics.checkNotNullParameter(sheetGroupListFactory, "factory");
            Intrinsics.checkNotNullParameter(sheetFactoryOptions, "options");
            return new SheetDialogWrapper<>(t, sheetGroupListFactory, sheetFactoryOptions, null);
        }
    }

    public final void showDialog(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.dismissAction == null) {
            View createContentView = createContentView(activity, this.factory.createSheetGroupListFor(this.data, activity, this.options));
            this.dismissAction = DialogUtil.INSTANCE.showBottomSheetDialog(activity, createContentView, true, true);
            ViewExtents2Kt.tryListenWindowsInset(createContentView, new SheetDialogWrapper$showDialog$1(this));
            return;
        }
        throw new IllegalStateException("call showDialog secondTimes!!");
    }

    private final View createContentView(Activity activity, List<SheetGroup> list) {
        Activity activity2 = activity;
        LinearLayout linearLayout = new LinearLayout(activity2);
        linearLayout.setOrientation(1);
        Unit unit = Unit.INSTANCE;
        this.recyclerViewContainer = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewContainer");
        }
        fillSheetGroupListInto(activity, list, linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(activity2);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout2.setPadding(0, NumberExtendsKt.getDp((Number) 12), 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        float dpf = NumberExtendsKt.getDpf((Number) 12);
        gradientDrawable.setCornerRadii(new float[]{dpf, dpf, dpf, dpf, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        linearLayout2.setBackground(gradientDrawable);
        View view = new View(activity2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(NumberExtendsKt.getDp((Number) 32), NumberExtendsKt.getDp((Number) 4));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = NumberExtendsKt.getDp((Number) 8);
        Unit unit3 = Unit.INSTANCE;
        view.setLayoutParams(layoutParams);
        view.setBackground(new ColorDrawable(ResourceUtils.resolveData(activity2, 2130969227)));
        ViewExtendsKt.clipView$default(view, 0, (float) NumberExtendsKt.getDp((Number) 2), 1, null);
        Unit unit4 = Unit.INSTANCE;
        linearLayout2.addView(view);
        LinearLayout linearLayout3 = this.recyclerViewContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewContainer");
        }
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity2);
        textView.setText("取消");
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, NumberExtendsKt.getDp((Number) 52));
        layoutParams2.topMargin = NumberExtendsKt.getDp((Number) 8);
        Unit unit5 = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams2);
        textView.setBackgroundColor(Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#282828" : "#F5F5F5"));
        textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        textView.setOnClickListener(new SheetDialogWrapper$createContentView$$inlined$apply$lambda$1(this, activity));
        Unit unit6 = Unit.INSTANCE;
        this.cancelTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelTextView");
        }
        linearLayout2.addView(textView);
        return linearLayout2;
    }

    private final void fillSheetGroupListInto(Activity activity, List<SheetGroup> list, LinearLayout linearLayout) {
        this.currentSheetGroupList = list;
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            RecyclerView createRecyclerView = createRecyclerView(activity, it2.next());
            createRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            createRecyclerView.setPadding(NumberExtendsKt.getDp((Number) 8), 0, 0, NumberExtendsKt.getDp((Number) 8));
            createRecyclerView.setClipChildren(false);
            createRecyclerView.setClipToPadding(false);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(createRecyclerView);
        }
    }

    private final RecyclerView createRecyclerView(Activity activity, SheetGroup sheetGroup) {
        Activity activity2 = activity;
        RecyclerView recyclerView = new RecyclerView(activity2);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity2, 0, false));
        recyclerView.setAdapter(new SheetDialogWrapper$createRecyclerView$$inlined$apply$lambda$1(recyclerView, this, activity, sheetGroup));
        return recyclerView;
    }

    public final void handleSheetResult(SheetResult sheetResult) {
        if (sheetResult instanceof SheetResultClose) {
            Function0<Unit> function0 = this.dismissAction;
            if (function0 != null) {
                function0.invoke();
            }
            this.dismissAction = null;
        } else if (!(sheetResult instanceof SheetResultNothing) && (sheetResult instanceof SheetResultReplace)) {
            LinearLayout linearLayout = this.recyclerViewContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewContainer");
            }
            Context context = linearLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "recyclerViewContainer.context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            Intrinsics.checkNotNull(activityNullable);
            List<SheetGroup> list = this.currentSheetGroupList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentSheetGroupList");
            }
            LinearLayout linearLayout2 = this.recyclerViewContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewContainer");
            }
            linearLayout2.removeAllViews();
            LinearLayout linearLayout3 = this.recyclerViewContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewContainer");
            }
            ViewParent parent = linearLayout3.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "recyclerViewContainer.parent");
            ViewParent parent2 = parent.getParent();
            Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent2);
            SheetResultReplace sheetResultReplace = (SheetResultReplace) sheetResult;
            List<SheetGroup> sheetGroupList = sheetResultReplace.getSheetGroupList();
            LinearLayout linearLayout4 = this.recyclerViewContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewContainer");
            }
            fillSheetGroupListInto(activityNullable, sheetGroupList, linearLayout4);
            if (sheetResultReplace.getBackToTop()) {
                TextView textView = this.cancelTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cancelTextView");
                }
                textView.setText("返回上一层");
                TextView textView2 = this.cancelTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cancelTextView");
                }
                textView2.setOnClickListener(new SheetDialogWrapper$handleSheetResult$1(this, list));
                return;
            }
            TextView textView3 = this.cancelTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cancelTextView");
            }
            textView3.setText("取消");
            TextView textView4 = this.cancelTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cancelTextView");
            }
            textView4.setOnClickListener(new SheetDialogWrapper$handleSheetResult$2(this));
        }
    }

    /* compiled from: SheetDialogWrapper.kt */
    private static final class SimpleViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558573;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleViewHolder(View view) {
            super(view, null, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ImageView imageView = ((ItemActionSheetDialogBinding) getBinding()).iconView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
            imageView.setScaleType(ImageView.ScaleType.CENTER);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.feed.dialog.SheetDataItem");
            SheetDataItem sheetDataItem = (SheetDataItem) obj;
            ItemActionSheetDialogBinding itemActionSheetDialogBinding = (ItemActionSheetDialogBinding) getBinding();
            TextView textView = itemActionSheetDialogBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(sheetDataItem.getTitle());
            TextView textView2 = itemActionSheetDialogBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setMaxLines(sheetDataItem.getMaxLines());
            ImageViewApplyer imageAppler = sheetDataItem.getImageAppler();
            ImageView imageView = itemActionSheetDialogBinding.iconView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
            imageAppler.apply(imageView);
            TextView textView3 = itemActionSheetDialogBinding.bandageTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.bandageTextView");
            int i = 0;
            textView3.setVisibility(sheetDataItem.getBandageText().length() > 0 ? 0 : 8);
            TextView textView4 = itemActionSheetDialogBinding.bandageTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.bandageTextView");
            textView4.setText(sheetDataItem.getBandageText());
            FrameLayout frameLayout = itemActionSheetDialogBinding.expandView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.expandView");
            frameLayout.setVisibility(sheetDataItem.getSecondPageHint() ? 0 : 8);
            View view = itemActionSheetDialogBinding.rightDividerView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.rightDividerView");
            if (!sheetDataItem.getRightDivider()) {
                i = 8;
            }
            view.setVisibility(i);
        }

        /* compiled from: SheetDialogWrapper.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
