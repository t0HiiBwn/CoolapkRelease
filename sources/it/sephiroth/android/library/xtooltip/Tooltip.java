package it.sephiroth.android.library.xtooltip;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.IBinder;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: Tooltip.kt */
public final class Tooltip {
    private final Runnable activateRunnable;
    private View contentView;
    private final Context context;
    private Gravity gravity;
    private final Runnable hideRunnable;
    private boolean isShowing;
    private boolean isVisible;
    private long mActivateDelay;
    private boolean mActivated;
    private Point mAnchorPoint;
    private WeakReference<View> mAnchorView;
    private int mAnimationStyleResId;
    private ValueAnimator mAnimator;
    private ClosePolicy mClosePolicy;
    private View mContentView;
    private Positions mCurrentPosition;
    private TooltipTextDrawable mDrawable;
    private int mEnterAnimation;
    private int mExitAnimation;
    private Function1<? super Tooltip, Unit> mFailureFunc;
    private Animation mFloatingAnimation;
    private boolean mFollowAnchor;
    private final List<Gravity> mGravities;
    private final Handler mHandler;
    private boolean mHasAnchorView;
    private Function1<? super Tooltip, Unit> mHiddenFunc;
    private boolean mIsCustomView;
    private final boolean mLayoutInsetDecor;
    private Integer mMaxWidth;
    private int[] mNewLocation;
    private int[] mOldLocation;
    private int mOverlayStyle;
    private int mPadding;
    private TooltipViewContainer mPopupView;
    private Function1<? super Tooltip, Unit> mPrepareFun;
    private boolean mShowArrow;
    private long mShowDuration;
    private boolean mShowOverlay;
    private Function1<? super Tooltip, Unit> mShownFunc;
    private final float mSizeTolerance;
    private final int mSoftInputMode;
    private CharSequence mText;
    private int mTextStyleResId;
    private TextView mTextView;
    private int mTextViewIdRes;
    private int mTooltipLayoutIdRes;
    private Typeface mTypeface;
    private TooltipOverlay mViewOverlay;
    private final int mWindowLayoutType;
    private float offsetX;
    private float offsetY;
    private ViewTreeObserver.OnPreDrawListener predrawListener;
    private CharSequence text;
    private final WindowManager windowManager;

    /* compiled from: Tooltip.kt */
    public enum Gravity {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        CENTER
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Gravity.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Gravity.LEFT.ordinal()] = 1;
            iArr[Gravity.RIGHT.ordinal()] = 2;
            iArr[Gravity.TOP.ordinal()] = 3;
            iArr[Gravity.BOTTOM.ordinal()] = 4;
            iArr[Gravity.CENTER.ordinal()] = 5;
            int[] iArr2 = new int[Gravity.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Gravity.LEFT.ordinal()] = 1;
            iArr2[Gravity.TOP.ordinal()] = 2;
            iArr2[Gravity.RIGHT.ordinal()] = 3;
            iArr2[Gravity.BOTTOM.ordinal()] = 4;
            iArr2[Gravity.CENTER.ordinal()] = 5;
            int[] iArr3 = new int[Gravity.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[Gravity.LEFT.ordinal()] = 1;
            iArr3[Gravity.RIGHT.ordinal()] = 2;
            iArr3[Gravity.TOP.ordinal()] = 3;
            iArr3[Gravity.BOTTOM.ordinal()] = 4;
            iArr3[Gravity.CENTER.ordinal()] = 5;
        }
    }

    private Tooltip(Context context2, Builder builder) {
        int i;
        this.context = context2;
        Object systemService = context2.getSystemService("window");
        if (systemService != null) {
            this.windowManager = (WindowManager) systemService;
            Gravity[] values = Gravity.values();
            ArrayList arrayList = new ArrayList();
            int length = values.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= length) {
                    break;
                }
                Gravity gravity2 = values[i2];
                if (gravity2 == Gravity.CENTER ? false : z2) {
                    arrayList.add(gravity2);
                }
                i2++;
            }
            this.mGravities = arrayList;
            Resources resources = this.context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
            this.mSizeTolerance = resources.getDisplayMetrics().density * ((float) 10);
            this.mLayoutInsetDecor = true;
            this.mWindowLayoutType = 1000;
            this.mSoftInputMode = 2;
            this.mHandler = new Handler();
            this.mTooltipLayoutIdRes = R.layout.textview;
            this.mTextViewIdRes = 16908308;
            this.hideRunnable = new Tooltip$hideRunnable$1(this);
            this.activateRunnable = new Tooltip$activateRunnable$1(this);
            this.predrawListener = new Tooltip$predrawListener$1(this);
            TypedArray obtainStyledAttributes = this.context.getTheme().obtainStyledAttributes(null, R.styleable.TooltipLayout, builder.getDefStyleAttr$xtooltip_release(), builder.getDefStyleRes$xtooltip_release());
            this.mPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TooltipLayout_ttlm_padding, 30);
            this.mOverlayStyle = obtainStyledAttributes.getResourceId(R.styleable.TooltipLayout_ttlm_overlayStyle, R.style.ToolTipOverlayDefaultStyle);
            if (builder.getAnimationStyle$xtooltip_release() != null) {
                Integer animationStyle$xtooltip_release = builder.getAnimationStyle$xtooltip_release();
                if (animationStyle$xtooltip_release == null) {
                    Intrinsics.throwNpe();
                }
                i = animationStyle$xtooltip_release.intValue();
            } else {
                i = obtainStyledAttributes.getResourceId(R.styleable.TooltipLayout_ttlm_animationStyle, 16973828);
            }
            this.mAnimationStyleResId = i;
            TypedArray obtainStyledAttributes2 = this.context.getTheme().obtainStyledAttributes(this.mAnimationStyleResId, new int[]{16842932, 16842933});
            this.mEnterAnimation = obtainStyledAttributes2.getResourceId(obtainStyledAttributes2.getIndex(0), 0);
            this.mExitAnimation = obtainStyledAttributes2.getResourceId(obtainStyledAttributes2.getIndex(1), 0);
            obtainStyledAttributes2.recycle();
            String string = obtainStyledAttributes.getString(R.styleable.TooltipLayout_ttlm_font);
            this.mTextStyleResId = obtainStyledAttributes.getResourceId(R.styleable.TooltipLayout_ttlm_textStyle, 0);
            obtainStyledAttributes.recycle();
            this.mText = builder.getText$xtooltip_release();
            this.mActivateDelay = builder.getActivateDelay$xtooltip_release();
            Point point$xtooltip_release = builder.getPoint$xtooltip_release();
            if (point$xtooltip_release == null) {
                Intrinsics.throwNpe();
            }
            this.mAnchorPoint = point$xtooltip_release;
            this.mClosePolicy = builder.getClosePolicy$xtooltip_release();
            this.mMaxWidth = builder.getMaxWidth$xtooltip_release();
            this.mFloatingAnimation = builder.getFloatingAnimation$xtooltip_release();
            this.mShowDuration = builder.getShowDuration$xtooltip_release();
            this.mShowOverlay = builder.getOverlay$xtooltip_release();
            if (builder.getShowArrow$xtooltip_release() && builder.getLayoutId$xtooltip_release() == null) {
                z = true;
            }
            this.mShowArrow = z;
            View anchorView$xtooltip_release = builder.getAnchorView$xtooltip_release();
            if (anchorView$xtooltip_release != null) {
                this.mAnchorView = new WeakReference<>(anchorView$xtooltip_release);
                this.mHasAnchorView = true;
                this.mFollowAnchor = builder.getFollowAnchor$xtooltip_release();
            }
            Integer layoutId$xtooltip_release = builder.getLayoutId$xtooltip_release();
            if (layoutId$xtooltip_release != null) {
                layoutId$xtooltip_release.intValue();
                Integer textId$xtooltip_release = builder.getTextId$xtooltip_release();
                if (textId$xtooltip_release == null) {
                    Intrinsics.throwNpe();
                }
                this.mTextViewIdRes = textId$xtooltip_release.intValue();
                Integer layoutId$xtooltip_release2 = builder.getLayoutId$xtooltip_release();
                if (layoutId$xtooltip_release2 == null) {
                    Intrinsics.throwNpe();
                }
                this.mTooltipLayoutIdRes = layoutId$xtooltip_release2.intValue();
                this.mIsCustomView = true;
            } else {
                Tooltip tooltip = this;
                tooltip.mDrawable = new TooltipTextDrawable(tooltip.context, builder);
            }
            Typeface typeface$xtooltip_release = builder.getTypeface$xtooltip_release();
            if (typeface$xtooltip_release != null) {
                this.mTypeface = typeface$xtooltip_release;
            } else {
                Tooltip tooltip2 = this;
                if (string != null) {
                    tooltip2.mTypeface = Typefaces.INSTANCE.get(tooltip2.context, string);
                }
            }
            this.mNewLocation = new int[]{0, 0};
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public /* synthetic */ Tooltip(Context context2, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, builder);
    }

    public static final /* synthetic */ TextView access$getMTextView$p(Tooltip tooltip) {
        TextView textView = tooltip.mTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        }
        return textView;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final Gravity getGravity() {
        Positions positions = this.mCurrentPosition;
        if (positions != null) {
            return positions.getGravity();
        }
        return null;
    }

    public final CharSequence getText() {
        return this.mText;
    }

    public final View getContentView() {
        View view = this.mContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        return view;
    }

    public final Tooltip doOnFailure(Function1<? super Tooltip, Unit> function1) {
        this.mFailureFunc = function1;
        return this;
    }

    public final Tooltip doOnShown(Function1<? super Tooltip, Unit> function1) {
        this.mShownFunc = function1;
        return this;
    }

    public final Tooltip doOnPrepare(Function1<? super Tooltip, Unit> function1) {
        this.mPrepareFun = function1;
        return this;
    }

    public final Tooltip doOnHidden(Function1<? super Tooltip, Unit> function1) {
        this.mHiddenFunc = function1;
        return this;
    }

    public final void update(CharSequence charSequence) {
        this.mText = charSequence;
        if (this.isShowing && this.mPopupView != null) {
            TextView textView = this.mTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextView");
            }
            if (!(charSequence instanceof Spannable)) {
                if (charSequence != null) {
                    charSequence = Html.fromHtml((String) charSequence);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            }
            textView.setText(charSequence);
        }
    }

    public final void update(int i) {
        update(this.context.getResources().getString(i));
    }

    private final WindowManager.LayoutParams createPopupLayoutParams(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.flags = computeFlags(layoutParams.flags);
        layoutParams.type = this.mWindowLayoutType;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.mSoftInputMode;
        layoutParams.setTitle("ToolTip:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private final int computeFlags(int i) {
        int i2 = i | 32;
        int i3 = (this.mClosePolicy.inside() || this.mClosePolicy.outside()) ? i2 & -9 : i2 | 8;
        if (!this.mClosePolicy.consume()) {
            i3 |= 16;
        }
        return i3 | 131072 | 262144 | 512 | 256 | 65536;
    }

    private final void preparePopup(WindowManager.LayoutParams layoutParams, Gravity gravity2) {
        TooltipViewContainer tooltipViewContainer = this.mPopupView;
        if (tooltipViewContainer == null) {
            Tooltip tooltip = this;
            TooltipViewContainer tooltipViewContainer2 = new TooltipViewContainer(tooltip, tooltip.context);
            if (tooltip.mShowOverlay && tooltip.mViewOverlay == null) {
                TooltipOverlay tooltipOverlay = new TooltipOverlay(tooltip.context, 0, tooltip.mOverlayStyle);
                tooltip.mViewOverlay = tooltipOverlay;
                if (tooltipOverlay == null) {
                    Intrinsics.throwNpe();
                }
                tooltipOverlay.setAdjustViewBounds(true);
                tooltipOverlay.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            View inflate = LayoutInflater.from(tooltip.context).inflate(tooltip.mTooltipLayoutIdRes, (ViewGroup) tooltipViewContainer2, false);
            if (!tooltip.mIsCustomView) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(new ContextThemeWrapper(tooltip.context, tooltip.mTextStyleResId));
                tooltip.mTextView = appCompatTextView;
                if (appCompatTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTextView");
                }
                appCompatTextView.setId(16908308);
                if (inflate != null) {
                    ViewGroup viewGroup = (ViewGroup) inflate;
                    TextView textView = tooltip.mTextView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
                    }
                    viewGroup.addView(textView);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            Animation animation = tooltip.mFloatingAnimation;
            if (animation != null) {
                Intrinsics.checkExpressionValueIsNotNull(inflate, "contentView");
                int radius = animation.getRadius();
                inflate.setPadding(radius, radius, radius, radius);
            }
            View findViewById = inflate.findViewById(tooltip.mTextViewIdRes);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "contentView.findViewById(mTextViewIdRes)");
            TextView textView2 = (TextView) findViewById;
            tooltip.mTextView = textView2;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextView");
            }
            TooltipTextDrawable tooltipTextDrawable = tooltip.mDrawable;
            if (tooltipTextDrawable != null) {
                textView2.setBackground(tooltipTextDrawable);
            }
            if (tooltip.mShowArrow) {
                int i = tooltip.mPadding;
                textView2.setPadding(i, i, i, i);
            } else {
                int i2 = tooltip.mPadding;
                textView2.setPadding(i2 / 2, i2 / 2, i2 / 2, i2 / 2);
            }
            Spanned spanned = tooltip.mText;
            if (!(spanned instanceof Spannable)) {
                CharSequence charSequence = this.mText;
                if (charSequence != null) {
                    spanned = Html.fromHtml((String) charSequence);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            }
            textView2.setText(spanned);
            Integer num = tooltip.mMaxWidth;
            if (num != null) {
                textView2.setMaxWidth(num.intValue());
            }
            Typeface typeface = tooltip.mTypeface;
            if (typeface != null) {
                textView2.setTypeface(typeface);
            }
            TooltipOverlay tooltipOverlay2 = tooltip.mViewOverlay;
            if (tooltipOverlay2 != null) {
                tooltipViewContainer2.addView(tooltipOverlay2, new FrameLayout.LayoutParams(-2, -2));
            }
            tooltipViewContainer2.addView(inflate, new FrameLayout.LayoutParams(-2, -2));
            tooltipViewContainer2.setMeasureAllChildren(true);
            tooltipViewContainer2.measure(0, 0);
            Timber.i("viewContainer size: " + tooltipViewContainer2.getMeasuredWidth() + ", " + tooltipViewContainer2.getMeasuredHeight(), new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("contentView size: ");
            Intrinsics.checkExpressionValueIsNotNull(inflate, "contentView");
            sb.append(inflate.getMeasuredWidth());
            sb.append(", ");
            sb.append(inflate.getMeasuredHeight());
            Timber.i(sb.toString(), new Object[0]);
            TextView textView3 = tooltip.mTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextView");
            }
            AttachStateChangeListener attachStateChangeListener = new AttachStateChangeListener();
            attachStateChangeListener.onViewAttachedToWindow(new Tooltip$$special$$inlined$addOnAttachStateChangeListener$lambda$1(tooltip));
            attachStateChangeListener.onViewDetachedFromWindow(new Tooltip$$special$$inlined$addOnAttachStateChangeListener$lambda$2(tooltip));
            textView3.addOnAttachStateChangeListener(attachStateChangeListener);
            tooltip.mContentView = inflate;
            tooltip.mPopupView = tooltipViewContainer2;
        } else if (this.mViewOverlay != null && gravity2 == Gravity.CENTER) {
            tooltipViewContainer.removeView(this.mViewOverlay);
            this.mViewOverlay = null;
        }
    }

    static /* synthetic */ Positions findPosition$default(Tooltip tooltip, View view, View view2, Point point, ArrayList arrayList, WindowManager.LayoutParams layoutParams, boolean z, int i, Object obj) {
        return tooltip.findPosition(view, view2, point, arrayList, layoutParams, (i & 32) != 0 ? false : z);
    }

    private final Positions findPosition(View view, View view2, Point point, ArrayList<Gravity> arrayList, WindowManager.LayoutParams layoutParams, boolean z) {
        TooltipOverlay tooltipOverlay;
        if (this.mPopupView == null || arrayList.isEmpty()) {
            return null;
        }
        int i = 0;
        Gravity remove = arrayList.remove(0);
        Intrinsics.checkExpressionValueIsNotNull(remove, "gravities.removeAt(0)");
        Gravity gravity2 = remove;
        Timber.i("findPosition. " + gravity2 + ", offset: " + point, new Object[0]);
        Rect rect = new Rect();
        int[] iArr = {0, 0};
        PointF pointF = new PointF(point);
        view.getWindowVisibleDisplayFrame(rect);
        if (view2 != null) {
            view2.getLocationOnScreen(iArr);
            pointF.x += (float) (iArr[0] + (view2.getWidth() / 2));
            pointF.y += (float) (iArr[1] + (view2.getHeight() / 2));
            int i2 = WhenMappings.$EnumSwitchMapping$0[gravity2.ordinal()];
            if (i2 == 1) {
                iArr[1] = iArr[1] + (view2.getHeight() / 2);
            } else if (i2 == 2) {
                iArr[0] = iArr[0] + view2.getWidth();
                iArr[1] = iArr[1] + (view2.getHeight() / 2);
            } else if (i2 == 3) {
                iArr[0] = iArr[0] + (view2.getWidth() / 2);
            } else if (i2 == 4) {
                iArr[0] = iArr[0] + (view2.getWidth() / 2);
                iArr[1] = iArr[1] + view2.getHeight();
            } else if (i2 == 5) {
                iArr[0] = iArr[0] + (view2.getWidth() / 2);
                iArr[1] = iArr[1] + (view2.getHeight() / 2);
            }
            i = 0;
        }
        iArr[i] = iArr[i] + point.x;
        iArr[1] = iArr[1] + point.y;
        Timber.d("anchorPosition: " + iArr[i] + ", " + iArr[1], new Object[i]);
        StringBuilder sb = new StringBuilder();
        sb.append("centerPosition: ");
        sb.append(pointF);
        Timber.d(sb.toString(), new Object[i]);
        Timber.d("displayFrame: " + rect, new Object[i]);
        View view3 = this.mContentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        int measuredWidth = view3.getMeasuredWidth();
        View view4 = this.mContentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        int measuredHeight = view4.getMeasuredHeight();
        Timber.v("contentView size: " + measuredWidth + ", " + measuredHeight, new Object[0]);
        Point point2 = new Point();
        Point point3 = new Point();
        Animation animation = this.mFloatingAnimation;
        int radius = animation != null ? animation.getRadius() : 0;
        int i3 = WhenMappings.$EnumSwitchMapping$1[gravity2.ordinal()];
        if (i3 == 1) {
            point2.x = iArr[0] - measuredWidth;
            int i4 = measuredHeight / 2;
            point2.y = iArr[1] - i4;
            point3.y = (i4 - (this.mPadding / 2)) - radius;
        } else if (i3 == 2) {
            int i5 = measuredWidth / 2;
            point2.x = iArr[0] - i5;
            point2.y = iArr[1] - measuredHeight;
            point3.x = (i5 - (this.mPadding / 2)) - radius;
        } else if (i3 == 3) {
            point2.x = iArr[0];
            int i6 = measuredHeight / 2;
            point2.y = iArr[1] - i6;
            point3.y = (i6 - (this.mPadding / 2)) - radius;
        } else if (i3 == 4) {
            int i7 = measuredWidth / 2;
            point2.x = iArr[0] - i7;
            point2.y = iArr[1];
            point3.x = (i7 - (this.mPadding / 2)) - radius;
        } else if (i3 == 5) {
            point2.x = iArr[0] - (measuredWidth / 2);
            point2.y = iArr[1] - (measuredHeight / 2);
        }
        if (view2 == null && (tooltipOverlay = this.mViewOverlay) != null) {
            int i8 = WhenMappings.$EnumSwitchMapping$2[gravity2.ordinal()];
            if (i8 == 1) {
                point2.x -= tooltipOverlay.getMeasuredWidth() / 2;
            } else if (i8 == 2) {
                point2.x += tooltipOverlay.getMeasuredWidth() / 2;
            } else if (i8 == 3) {
                point2.y -= tooltipOverlay.getMeasuredHeight() / 2;
            } else if (i8 == 4) {
                point2.y += tooltipOverlay.getMeasuredHeight() / 2;
            }
        }
        Timber.d("arrowPosition: " + point3, new Object[0]);
        Timber.d("centerPosition: " + pointF, new Object[0]);
        Timber.d("contentPosition: " + point2, new Object[0]);
        if (z) {
            Rect rect2 = new Rect(point2.x, point2.y, point2.x + measuredWidth, point2.y + measuredHeight);
            int i9 = (int) this.mSizeTolerance;
            if (!rect.contains(rect2.left + i9, rect2.top + i9, rect2.right - i9, rect2.bottom - i9)) {
                Timber.e("content won't fit! " + rect + ", " + rect2, new Object[0]);
                return findPosition(view, view2, point, arrayList, layoutParams, z);
            }
        }
        return new Positions(rect, new PointF(point3), pointF, new PointF(point2), gravity2, layoutParams);
    }

    private final Tooltip invokePopup(Positions positions) {
        PointF pointF = null;
        if (positions != null) {
            this.isShowing = true;
            this.mCurrentPosition = positions;
            setupAnimation(positions.getGravity());
            if (this.mHasAnchorView) {
                WeakReference<View> weakReference = this.mAnchorView;
                if ((weakReference != null ? weakReference.get() : null) != null) {
                    WeakReference<View> weakReference2 = this.mAnchorView;
                    if (weakReference2 == null) {
                        Intrinsics.throwNpe();
                    }
                    View view = weakReference2.get();
                    if (view == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(view, "mAnchorView!!.get()!!");
                    setupListeners(view);
                }
            }
            TooltipTextDrawable tooltipTextDrawable = this.mDrawable;
            if (tooltipTextDrawable != null) {
                Gravity gravity2 = positions.getGravity();
                boolean z = this.mShowArrow;
                int i = !z ? 0 : this.mPadding / 2;
                if (z) {
                    pointF = new PointF(positions.getArrowPointX(), positions.getArrowPointY());
                }
                tooltipTextDrawable.setAnchor(gravity2, i, pointF);
            }
            offsetBy(0.0f, 0.0f);
            positions.getParams().packageName = this.context.getPackageName();
            TooltipViewContainer tooltipViewContainer = this.mPopupView;
            if (tooltipViewContainer != null) {
                tooltipViewContainer.setFitsSystemWindows(this.mLayoutInsetDecor);
            }
            this.windowManager.addView(this.mPopupView, positions.getParams());
            fadeIn();
            return this;
        }
        Tooltip tooltip = this;
        Function1<? super Tooltip, Unit> function1 = tooltip.mFailureFunc;
        if (function1 != null) {
            function1.invoke(tooltip);
        }
        return null;
    }

    public final void offsetBy(float f, float f2) {
        if (this.isShowing && this.mPopupView != null && this.mCurrentPosition != null) {
            Timber.i("offsetBy(" + f + ", " + f2 + ')', new Object[0]);
            Positions positions = this.mCurrentPosition;
            if (positions == null) {
                Intrinsics.throwNpe();
            }
            positions.offsetBy(f, f2);
            View view = this.mContentView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            }
            Positions positions2 = this.mCurrentPosition;
            if (positions2 == null) {
                Intrinsics.throwNpe();
            }
            view.setTranslationX(positions2.getContentPointX());
            View view2 = this.mContentView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            }
            Positions positions3 = this.mCurrentPosition;
            if (positions3 == null) {
                Intrinsics.throwNpe();
            }
            view2.setTranslationY(positions3.getContentPointY());
            TooltipOverlay tooltipOverlay = this.mViewOverlay;
            if (tooltipOverlay != null) {
                Positions positions4 = this.mCurrentPosition;
                if (positions4 == null) {
                    Intrinsics.throwNpe();
                }
                tooltipOverlay.setTranslationX(positions4.getCenterPointX() - ((float) (tooltipOverlay.getMeasuredWidth() / 2)));
                Positions positions5 = this.mCurrentPosition;
                if (positions5 == null) {
                    Intrinsics.throwNpe();
                }
                tooltipOverlay.setTranslationY(positions5.getCenterPointY() - ((float) (tooltipOverlay.getMeasuredHeight() / 2)));
            }
        }
    }

    public final void offsetTo(float f, float f2) {
        if (this.isShowing && this.mPopupView != null && this.mCurrentPosition != null) {
            Timber.i("offsetTo(" + f + ", " + f2 + ')', new Object[0]);
            Positions positions = this.mCurrentPosition;
            if (positions == null) {
                Intrinsics.throwNpe();
            }
            positions.offsetTo(f, f2);
            View view = this.mContentView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            }
            Positions positions2 = this.mCurrentPosition;
            if (positions2 == null) {
                Intrinsics.throwNpe();
            }
            view.setTranslationX(positions2.getContentPointX());
            View view2 = this.mContentView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            }
            Positions positions3 = this.mCurrentPosition;
            if (positions3 == null) {
                Intrinsics.throwNpe();
            }
            view2.setTranslationY(positions3.getContentPointY());
            TooltipOverlay tooltipOverlay = this.mViewOverlay;
            if (tooltipOverlay != null) {
                Positions positions4 = this.mCurrentPosition;
                if (positions4 == null) {
                    Intrinsics.throwNpe();
                }
                tooltipOverlay.setTranslationX(positions4.getCenterPointX() - ((float) (tooltipOverlay.getMeasuredWidth() / 2)));
                Positions positions5 = this.mCurrentPosition;
                if (positions5 == null) {
                    Intrinsics.throwNpe();
                }
                tooltipOverlay.setTranslationY(positions5.getCenterPointY() - ((float) (tooltipOverlay.getMeasuredHeight() / 2)));
            }
        }
    }

    public final void setOffsetX(float f) {
        this.offsetX = f;
    }

    public final float getOffsetX() {
        Positions positions = this.mCurrentPosition;
        if (positions != null) {
            return positions.getMOffsetX();
        }
        return 0.0f;
    }

    public final void setOffsetY(float f) {
        this.offsetY = f;
    }

    public final float getOffsetY() {
        Positions positions = this.mCurrentPosition;
        if (positions != null) {
            return positions.getMOffsetY();
        }
        return 0.0f;
    }

    public final void removeListeners(View view) {
        ViewTreeObserver viewTreeObserver;
        if (this.mFollowAnchor && view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(this.predrawListener);
        }
    }

    private final void setupAnimation(Gravity gravity2) {
        Animation animation;
        int i;
        TextView textView = this.mTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        }
        View view = this.mContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        }
        if (textView != view && (animation = this.mFloatingAnimation) != null) {
            if (animation == null) {
                Intrinsics.throwNpe();
            }
            int radius = animation.getRadius();
            Animation animation2 = this.mFloatingAnimation;
            if (animation2 == null) {
                Intrinsics.throwNpe();
            }
            long duration = animation2.getDuration();
            Animation animation3 = this.mFloatingAnimation;
            if (animation3 == null) {
                Intrinsics.throwNpe();
            }
            if (animation3.getDirection() == 0) {
                i = (gravity2 == Gravity.TOP || gravity2 == Gravity.BOTTOM) ? 2 : 1;
            } else {
                Animation animation4 = this.mFloatingAnimation;
                if (animation4 == null) {
                    Intrinsics.throwNpe();
                }
                i = animation4.getDirection();
            }
            String str = i == 2 ? "translationY" : "translationX";
            TextView textView2 = this.mTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTextView");
            }
            float f = (float) radius;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView2, str, -f, f);
            this.mAnimator = ofFloat;
            if (ofFloat == null) {
                Intrinsics.throwNpe();
            }
            ofFloat.setDuration(duration);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(2);
        }
    }

    public static /* synthetic */ void show$default(Tooltip tooltip, View view, Gravity gravity2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        tooltip.show(view, gravity2, z);
    }

    public final void show(View view, Gravity gravity2, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "parent");
        Intrinsics.checkParameterIsNotNull(gravity2, "gravity");
        if (!this.isShowing) {
            View view2 = null;
            if (this.mHasAnchorView) {
                WeakReference<View> weakReference = this.mAnchorView;
                if ((weakReference != null ? weakReference.get() : null) == null) {
                    return;
                }
            }
            this.isVisible = false;
            IBinder windowToken = view.getWindowToken();
            Intrinsics.checkExpressionValueIsNotNull(windowToken, "parent.windowToken");
            WindowManager.LayoutParams createPopupLayoutParams = createPopupLayoutParams(windowToken);
            preparePopup(createPopupLayoutParams, gravity2);
            ArrayList<Gravity> arrayList = (ArrayList) CollectionsKt.toCollection(this.mGravities, new ArrayList());
            arrayList.remove(gravity2);
            arrayList.add(0, gravity2);
            Function1<? super Tooltip, Unit> function1 = this.mPrepareFun;
            if (function1 != null) {
                function1.invoke(this);
            }
            WeakReference<View> weakReference2 = this.mAnchorView;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            invokePopup(findPosition(view, view2, this.mAnchorPoint, arrayList, createPopupLayoutParams, z));
        }
    }

    public final void hide() {
        Timber.i("hide", new Object[0]);
        if (this.isShowing) {
            fadeOut();
        }
    }

    public final void dismiss() {
        if (this.isShowing && this.mPopupView != null) {
            WeakReference<View> weakReference = this.mAnchorView;
            removeListeners(weakReference != null ? weakReference.get() : null);
            removeCallbacks();
            this.windowManager.removeView(this.mPopupView);
            Timber.v("dismiss: " + this.mPopupView, new Object[0]);
            this.mPopupView = null;
            this.isShowing = false;
            this.isVisible = false;
            Function1<? super Tooltip, Unit> function1 = this.mHiddenFunc;
            if (function1 != null) {
                function1.invoke(this);
            }
        }
    }

    public final void removeCallbacks() {
        this.mHandler.removeCallbacks(this.hideRunnable);
        this.mHandler.removeCallbacks(this.activateRunnable);
    }

    private final void fadeIn() {
        if (this.isShowing && !this.isVisible) {
            if (this.mEnterAnimation != 0) {
                TextView textView = this.mTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTextView");
                }
                textView.clearAnimation();
                TextView textView2 = this.mTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTextView");
                }
                textView2.startAnimation(AnimationUtils.loadAnimation(this.context, this.mEnterAnimation));
            }
            this.isVisible = true;
            Function1<? super Tooltip, Unit> function1 = this.mShownFunc;
            if (function1 != null) {
                function1.invoke(this);
            }
        }
    }

    private final void fadeOut() {
        if (this.isShowing && this.isVisible) {
            int i = this.mExitAnimation;
            if (i != 0) {
                android.view.animation.Animation loadAnimation = AnimationUtils.loadAnimation(this.context, i);
                Intrinsics.checkExpressionValueIsNotNull(loadAnimation, "animation");
                AnimationListener animationListener = new AnimationListener();
                animationListener.onAnimationEnd(new Tooltip$fadeOut$$inlined$setListener$lambda$1(this));
                loadAnimation.setAnimationListener(animationListener);
                loadAnimation.start();
                TextView textView = this.mTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTextView");
                }
                textView.clearAnimation();
                TextView textView2 = this.mTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTextView");
                }
                textView2.startAnimation(loadAnimation);
                return;
            }
            this.isVisible = false;
            removeCallbacks();
            dismiss();
        }
    }

    /* compiled from: Tooltip.kt */
    public final class TooltipViewContainer extends FrameLayout {
        private HashMap _$_findViewCache;
        private Function2<? super Integer, ? super Integer, Unit> sizeChange;
        final /* synthetic */ Tooltip this$0;

        public void _$_clearFindViewByIdCache() {
            HashMap hashMap = this._$_findViewCache;
            if (hashMap != null) {
                hashMap.clear();
            }
        }

        public View _$_findCachedViewById(int i) {
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
            if (view != null) {
                return view;
            }
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TooltipViewContainer(Tooltip tooltip, Context context) {
            super(context);
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.this$0 = tooltip;
            setClipChildren(false);
            setClipToPadding(false);
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            Function2<? super Integer, ? super Integer, Unit> function2 = this.sizeChange;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
            }
        }

        @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                int[] iArr = {-1, -1};
                getLocationOnScreen(iArr);
                Timber.v("globalVisibleRect: " + iArr[0] + ", " + iArr[1], new Object[0]);
                offsetTopAndBottom(-iArr[1]);
            }
        }

        @Override // android.view.View, android.view.ViewGroup
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            Intrinsics.checkParameterIsNotNull(keyEvent, "event");
            if (!this.this$0.isShowing() || !this.this$0.isVisible || !this.this$0.mActivated) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getKeyCode() != 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() != 1 || (keyDispatcherState = getKeyDispatcherState()) == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled()) {
                return super.dispatchKeyEvent(keyEvent);
            } else {
                Timber.v("Back pressed, close the tooltip", new Object[0]);
                this.this$0.hide();
                return true;
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkParameterIsNotNull(motionEvent, "event");
            if (!this.this$0.isShowing() || !this.this$0.isVisible || !this.this$0.mActivated) {
                return false;
            }
            Timber.i("onTouchEvent: " + motionEvent, new Object[0]);
            Timber.d("event position: " + motionEvent.getX() + ", " + motionEvent.getY(), new Object[0]);
            Rect rect = new Rect();
            Tooltip.access$getMTextView$p(this.this$0).getGlobalVisibleRect(rect);
            boolean contains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            if (this.this$0.mClosePolicy.anywhere()) {
                this.this$0.hide();
            } else if (this.this$0.mClosePolicy.inside() && contains) {
                this.this$0.hide();
            } else if (this.this$0.mClosePolicy.outside() && !contains) {
                this.this$0.hide();
            }
            return this.this$0.mClosePolicy.consume();
        }
    }

    /* compiled from: Tooltip.kt */
    private static final class Positions {
        private final PointF arrowPoint;
        private float arrowPointX;
        private float arrowPointY;
        private final PointF centerPoint;
        private float centerPointX;
        private float centerPointY;
        private final PointF contentPoint;
        private float contentPointX;
        private float contentPointY;
        private final Rect displayFrame;
        private final Gravity gravity;
        private float mOffsetX;
        private float mOffsetY;
        private final WindowManager.LayoutParams params;

        public static /* synthetic */ Positions copy$default(Positions positions, Rect rect, PointF pointF, PointF pointF2, PointF pointF3, Gravity gravity2, WindowManager.LayoutParams layoutParams, int i, Object obj) {
            if ((i & 1) != 0) {
                rect = positions.displayFrame;
            }
            if ((i & 2) != 0) {
                pointF = positions.arrowPoint;
            }
            if ((i & 4) != 0) {
                pointF2 = positions.centerPoint;
            }
            if ((i & 8) != 0) {
                pointF3 = positions.contentPoint;
            }
            if ((i & 16) != 0) {
                gravity2 = positions.gravity;
            }
            if ((i & 32) != 0) {
                layoutParams = positions.params;
            }
            return positions.copy(rect, pointF, pointF2, pointF3, gravity2, layoutParams);
        }

        public final Rect component1() {
            return this.displayFrame;
        }

        public final PointF component2() {
            return this.arrowPoint;
        }

        public final PointF component3() {
            return this.centerPoint;
        }

        public final PointF component4() {
            return this.contentPoint;
        }

        public final Gravity component5() {
            return this.gravity;
        }

        public final WindowManager.LayoutParams component6() {
            return this.params;
        }

        public final Positions copy(Rect rect, PointF pointF, PointF pointF2, PointF pointF3, Gravity gravity2, WindowManager.LayoutParams layoutParams) {
            Intrinsics.checkParameterIsNotNull(rect, "displayFrame");
            Intrinsics.checkParameterIsNotNull(pointF, "arrowPoint");
            Intrinsics.checkParameterIsNotNull(pointF2, "centerPoint");
            Intrinsics.checkParameterIsNotNull(pointF3, "contentPoint");
            Intrinsics.checkParameterIsNotNull(gravity2, "gravity");
            Intrinsics.checkParameterIsNotNull(layoutParams, "params");
            return new Positions(rect, pointF, pointF2, pointF3, gravity2, layoutParams);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Positions)) {
                return false;
            }
            Positions positions = (Positions) obj;
            return Intrinsics.areEqual(this.displayFrame, positions.displayFrame) && Intrinsics.areEqual(this.arrowPoint, positions.arrowPoint) && Intrinsics.areEqual(this.centerPoint, positions.centerPoint) && Intrinsics.areEqual(this.contentPoint, positions.contentPoint) && Intrinsics.areEqual(this.gravity, positions.gravity) && Intrinsics.areEqual(this.params, positions.params);
        }

        public int hashCode() {
            Rect rect = this.displayFrame;
            int i = 0;
            int hashCode = (rect != null ? rect.hashCode() : 0) * 31;
            PointF pointF = this.arrowPoint;
            int hashCode2 = (hashCode + (pointF != null ? pointF.hashCode() : 0)) * 31;
            PointF pointF2 = this.centerPoint;
            int hashCode3 = (hashCode2 + (pointF2 != null ? pointF2.hashCode() : 0)) * 31;
            PointF pointF3 = this.contentPoint;
            int hashCode4 = (hashCode3 + (pointF3 != null ? pointF3.hashCode() : 0)) * 31;
            Gravity gravity2 = this.gravity;
            int hashCode5 = (hashCode4 + (gravity2 != null ? gravity2.hashCode() : 0)) * 31;
            WindowManager.LayoutParams layoutParams = this.params;
            if (layoutParams != null) {
                i = layoutParams.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "Positions(displayFrame=" + this.displayFrame + ", arrowPoint=" + this.arrowPoint + ", centerPoint=" + this.centerPoint + ", contentPoint=" + this.contentPoint + ", gravity=" + this.gravity + ", params=" + this.params + ")";
        }

        public Positions(Rect rect, PointF pointF, PointF pointF2, PointF pointF3, Gravity gravity2, WindowManager.LayoutParams layoutParams) {
            Intrinsics.checkParameterIsNotNull(rect, "displayFrame");
            Intrinsics.checkParameterIsNotNull(pointF, "arrowPoint");
            Intrinsics.checkParameterIsNotNull(pointF2, "centerPoint");
            Intrinsics.checkParameterIsNotNull(pointF3, "contentPoint");
            Intrinsics.checkParameterIsNotNull(gravity2, "gravity");
            Intrinsics.checkParameterIsNotNull(layoutParams, "params");
            this.displayFrame = rect;
            this.arrowPoint = pointF;
            this.centerPoint = pointF2;
            this.contentPoint = pointF3;
            this.gravity = gravity2;
            this.params = layoutParams;
        }

        public final Rect getDisplayFrame() {
            return this.displayFrame;
        }

        public final PointF getArrowPoint() {
            return this.arrowPoint;
        }

        public final PointF getCenterPoint() {
            return this.centerPoint;
        }

        public final PointF getContentPoint() {
            return this.contentPoint;
        }

        public final Gravity getGravity() {
            return this.gravity;
        }

        public final WindowManager.LayoutParams getParams() {
            return this.params;
        }

        public final float getMOffsetX() {
            return this.mOffsetX;
        }

        public final void setMOffsetX(float f) {
            this.mOffsetX = f;
        }

        public final float getMOffsetY() {
            return this.mOffsetY;
        }

        public final void setMOffsetY(float f) {
            this.mOffsetY = f;
        }

        public final void offsetBy(float f, float f2) {
            this.mOffsetX += f;
            this.mOffsetY += f2;
        }

        public final void offsetTo(float f, float f2) {
            this.mOffsetX = f;
            this.mOffsetY = f2;
        }

        public final void setCenterPointX(float f) {
            this.centerPointX = f;
        }

        public final float getCenterPointX() {
            return this.centerPoint.x + this.mOffsetX;
        }

        public final void setCenterPointY(float f) {
            this.centerPointY = f;
        }

        public final float getCenterPointY() {
            return this.centerPoint.y + this.mOffsetY;
        }

        public final void setArrowPointX(float f) {
            this.arrowPointX = f;
        }

        public final float getArrowPointX() {
            return this.arrowPoint.x + this.mOffsetX;
        }

        public final void setArrowPointY(float f) {
            this.arrowPointY = f;
        }

        public final float getArrowPointY() {
            return this.arrowPoint.y + this.mOffsetY;
        }

        public final void setContentPointX(float f) {
            this.contentPointX = f;
        }

        public final float getContentPointX() {
            return this.contentPoint.x + this.mOffsetX;
        }

        public final void setContentPointY(float f) {
            this.contentPointY = f;
        }

        public final float getContentPointY() {
            return this.contentPoint.y + this.mOffsetY;
        }
    }

    /* compiled from: Tooltip.kt */
    public static final class Animation {
        public static final Companion Companion = new Companion(null);
        private static final Animation DEFAULT = new Animation(8, 0, 400);
        private static final Animation SLOW = new Animation(4, 0, 600);
        private final int direction;
        private final long duration;
        private final int radius;

        public static /* synthetic */ Animation copy$default(Animation animation, int i, int i2, long j, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = animation.radius;
            }
            if ((i3 & 2) != 0) {
                i2 = animation.direction;
            }
            if ((i3 & 4) != 0) {
                j = animation.duration;
            }
            return animation.copy(i, i2, j);
        }

        public final int component1() {
            return this.radius;
        }

        public final int component2() {
            return this.direction;
        }

        public final long component3() {
            return this.duration;
        }

        public final Animation copy(int i, int i2, long j) {
            return new Animation(i, i2, j);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Animation) {
                    Animation animation = (Animation) obj;
                    if (this.radius == animation.radius) {
                        if (this.direction == animation.direction) {
                            if (this.duration == animation.duration) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.duration;
            return (((this.radius * 31) + this.direction) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "Animation(radius=" + this.radius + ", direction=" + this.direction + ", duration=" + this.duration + ")";
        }

        public Animation(int i, int i2, long j) {
            this.radius = i;
            this.direction = i2;
            this.duration = j;
        }

        public final int getDirection() {
            return this.direction;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final int getRadius() {
            return this.radius;
        }

        /* compiled from: Tooltip.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Animation getDEFAULT() {
                return Animation.DEFAULT;
            }

            public final Animation getSLOW() {
                return Animation.SLOW;
            }
        }
    }

    /* compiled from: Tooltip.kt */
    public static final class Builder {
        private long activateDelay;
        private View anchorView;
        private Integer animationStyle;
        private ClosePolicy closePolicy = ClosePolicy.Companion.getTOUCH_INSIDE_CONSUME();
        private final Context context;
        private int defStyleAttr = R.attr.ttlm_defaultStyle;
        private int defStyleRes = R.style.ToolTipLayoutDefaultStyle;
        private Animation floatingAnimation;
        private boolean followAnchor;
        private Integer layoutId;
        private Integer maxWidth;
        private boolean overlay = true;
        private Point point;
        private boolean showArrow = true;
        private long showDuration;
        private CharSequence text;
        private Integer textId;
        private Typeface typeface;

        public Builder(Context context2) {
            Intrinsics.checkParameterIsNotNull(context2, "context");
            this.context = context2;
        }

        public final Point getPoint$xtooltip_release() {
            return this.point;
        }

        public final void setPoint$xtooltip_release(Point point2) {
            this.point = point2;
        }

        public final ClosePolicy getClosePolicy$xtooltip_release() {
            return this.closePolicy;
        }

        public final void setClosePolicy$xtooltip_release(ClosePolicy closePolicy2) {
            Intrinsics.checkParameterIsNotNull(closePolicy2, "<set-?>");
            this.closePolicy = closePolicy2;
        }

        public final CharSequence getText$xtooltip_release() {
            return this.text;
        }

        public final void setText$xtooltip_release(CharSequence charSequence) {
            this.text = charSequence;
        }

        public final View getAnchorView$xtooltip_release() {
            return this.anchorView;
        }

        public final void setAnchorView$xtooltip_release(View view) {
            this.anchorView = view;
        }

        public final Integer getMaxWidth$xtooltip_release() {
            return this.maxWidth;
        }

        public final void setMaxWidth$xtooltip_release(Integer num) {
            this.maxWidth = num;
        }

        public final int getDefStyleRes$xtooltip_release() {
            return this.defStyleRes;
        }

        public final void setDefStyleRes$xtooltip_release(int i) {
            this.defStyleRes = i;
        }

        public final int getDefStyleAttr$xtooltip_release() {
            return this.defStyleAttr;
        }

        public final void setDefStyleAttr$xtooltip_release(int i) {
            this.defStyleAttr = i;
        }

        public final Typeface getTypeface$xtooltip_release() {
            return this.typeface;
        }

        public final void setTypeface$xtooltip_release(Typeface typeface2) {
            this.typeface = typeface2;
        }

        public final boolean getOverlay$xtooltip_release() {
            return this.overlay;
        }

        public final void setOverlay$xtooltip_release(boolean z) {
            this.overlay = z;
        }

        public final Animation getFloatingAnimation$xtooltip_release() {
            return this.floatingAnimation;
        }

        public final void setFloatingAnimation$xtooltip_release(Animation animation) {
            this.floatingAnimation = animation;
        }

        public final long getShowDuration$xtooltip_release() {
            return this.showDuration;
        }

        public final void setShowDuration$xtooltip_release(long j) {
            this.showDuration = j;
        }

        public final boolean getShowArrow$xtooltip_release() {
            return this.showArrow;
        }

        public final void setShowArrow$xtooltip_release(boolean z) {
            this.showArrow = z;
        }

        public final long getActivateDelay$xtooltip_release() {
            return this.activateDelay;
        }

        public final void setActivateDelay$xtooltip_release(long j) {
            this.activateDelay = j;
        }

        public final boolean getFollowAnchor$xtooltip_release() {
            return this.followAnchor;
        }

        public final void setFollowAnchor$xtooltip_release(boolean z) {
            this.followAnchor = z;
        }

        public final Integer getAnimationStyle$xtooltip_release() {
            return this.animationStyle;
        }

        public final void setAnimationStyle$xtooltip_release(Integer num) {
            this.animationStyle = num;
        }

        public final Integer getLayoutId$xtooltip_release() {
            return this.layoutId;
        }

        public final void setLayoutId$xtooltip_release(Integer num) {
            this.layoutId = num;
        }

        public final Integer getTextId$xtooltip_release() {
            return this.textId;
        }

        public final void setTextId$xtooltip_release(Integer num) {
            this.textId = num;
        }

        public final Builder typeface(Typeface typeface2) {
            this.typeface = typeface2;
            return this;
        }

        public final Builder styleId(Integer num) {
            if (num != null) {
                int intValue = num.intValue();
                this.defStyleAttr = 0;
                this.defStyleRes = intValue;
            } else {
                Builder builder = this;
                builder.defStyleRes = R.style.ToolTipLayoutDefaultStyle;
                builder.defStyleAttr = R.attr.ttlm_defaultStyle;
            }
            return this;
        }

        public final Builder customView(int i, int i2) {
            this.layoutId = Integer.valueOf(i);
            this.textId = Integer.valueOf(i2);
            return this;
        }

        public final Builder activateDelay(long j) {
            this.activateDelay = j;
            return this;
        }

        public final Builder arrow(boolean z) {
            this.showArrow = z;
            return this;
        }

        public final Builder showDuration(long j) {
            this.showDuration = j;
            return this;
        }

        public final Builder floatingAnimation(Animation animation) {
            this.floatingAnimation = animation;
            return this;
        }

        public final Builder maxWidth(int i) {
            this.maxWidth = Integer.valueOf(i);
            return this;
        }

        public final Builder overlay(boolean z) {
            this.overlay = z;
            return this;
        }

        public final Builder anchor(int i, int i2) {
            this.anchorView = null;
            this.point = new Point(i, i2);
            return this;
        }

        public static /* synthetic */ Builder anchor$default(Builder builder, View view, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            if ((i3 & 8) != 0) {
                z = false;
            }
            return builder.anchor(view, i, i2, z);
        }

        public final Builder anchor(View view, int i, int i2, boolean z) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            this.anchorView = view;
            this.followAnchor = z;
            this.point = new Point(i, i2);
            return this;
        }

        public final Builder text(CharSequence charSequence) {
            Intrinsics.checkParameterIsNotNull(charSequence, "text");
            this.text = charSequence;
            return this;
        }

        public final Builder text(int i) {
            this.text = this.context.getString(i);
            return this;
        }

        public final Builder text(int i, Object... objArr) {
            Intrinsics.checkParameterIsNotNull(objArr, "args");
            this.text = this.context.getString(i, objArr);
            return this;
        }

        public final Builder closePolicy(ClosePolicy closePolicy2) {
            Intrinsics.checkParameterIsNotNull(closePolicy2, "policy");
            this.closePolicy = closePolicy2;
            Timber.v("closePolicy: " + closePolicy2, new Object[0]);
            return this;
        }

        public final Builder animationStyle(int i) {
            this.animationStyle = Integer.valueOf(i);
            return this;
        }

        public final Tooltip create() {
            if (this.anchorView != null || this.point != null) {
                return new Tooltip(this.context, this, null);
            }
            throw new IllegalArgumentException("missing anchor point or anchor view");
        }
    }

    private final void setupListeners(View view) {
        AttachStateChangeListener attachStateChangeListener = new AttachStateChangeListener();
        attachStateChangeListener.onViewDetachedFromWindow(new Tooltip$setupListeners$$inlined$addOnAttachStateChangeListener$lambda$1(this));
        view.addOnAttachStateChangeListener(attachStateChangeListener);
        if (this.mFollowAnchor) {
            view.getViewTreeObserver().addOnPreDrawListener(this.predrawListener);
        }
    }
}
