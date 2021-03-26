package com.aurelhubert.ahbottomnavigation;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.aurelhubert.ahbottomnavigation.notification.AHNotificationHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AHBottomNavigation extends FrameLayout {
    public static final int CURRENT_ITEM_NONE = -1;
    private static final String EXCEPTION_INDEX_OUT_OF_BOUNDS = "The position (%d) is out of bounds of the items (%d elements)";
    private static final int MAX_ITEMS = 5;
    private static final int MIN_ITEMS = 3;
    private static String TAG = "AHBottomNavigation";
    public static final int UPDATE_ALL_NOTIFICATIONS = -1;
    private View backgroundColorView;
    private boolean behaviorTranslationEnabled;
    private AHBottomNavigationBehavior<AHBottomNavigation> bottomNavigationBehavior;
    private int bottomNavigationHeight;
    private Animator circleRevealAnim;
    private boolean colored;
    private int coloredTitleColorActive;
    private int coloredTitleColorInactive;
    private Context context;
    private int currentColor;
    private int currentItem;
    private int defaultBackgroundColor;
    private int defaultBackgroundResource;
    private boolean forceTint;
    private boolean hideBottomNavigationWithAnimation;
    private boolean isBehaviorTranslationSet;
    private int itemActiveColor;
    private int itemDisableColor;
    private int itemInactiveColor;
    private ArrayList<AHBottomNavigationItem> items;
    private Boolean[] itemsEnabledStates;
    private LinearLayout linearLayoutContainer;
    private int navigationBarHeight;
    private OnNavigationPositionListener navigationPositionListener;
    private boolean needHideBottomNavigation;
    private float notSelectedItemWidth;
    private int notificationActiveMarginLeft;
    private int notificationActiveMarginTop;
    private long notificationAnimationDuration;
    private int notificationBackgroundColor;
    private Drawable notificationBackgroundDrawable;
    private int notificationInactiveMarginLeft;
    private int notificationInactiveMarginTop;
    private int notificationTextColor;
    private Typeface notificationTypeface;
    private List<AHNotification> notifications;
    private Resources resources;
    private boolean selectedBackgroundVisible;
    private float selectedItemWidth;
    private boolean soundEffectsEnabled;
    private OnTabSelectedListener tabSelectedListener;
    private float titleActiveTextSize;
    private int titleColorActive;
    private int titleColorInactive;
    private float titleInactiveTextSize;
    private TitleState titleState;
    private Typeface titleTypeface;
    private boolean translucentNavigationEnabled;
    private ArrayList<View> views;

    public interface OnNavigationPositionListener {
        void onPositionChange(int i);
    }

    public interface OnTabSelectedListener {
        boolean onTabSelected(int i, boolean z);
    }

    public enum TitleState {
        SHOW_WHEN_ACTIVE,
        SHOW_WHEN_ACTIVE_FORCE,
        ALWAYS_SHOW,
        ALWAYS_HIDE
    }

    public AHBottomNavigation(Context context2) {
        super(context2);
        this.items = new ArrayList<>();
        this.views = new ArrayList<>();
        this.colored = false;
        this.selectedBackgroundVisible = false;
        this.notifications = AHNotification.generateEmptyList(5);
        this.itemsEnabledStates = new Boolean[]{true, true, true, true, true};
        this.isBehaviorTranslationSet = false;
        this.currentItem = 0;
        this.currentColor = 0;
        this.behaviorTranslationEnabled = true;
        this.needHideBottomNavigation = false;
        this.hideBottomNavigationWithAnimation = false;
        this.soundEffectsEnabled = true;
        this.defaultBackgroundColor = -1;
        this.defaultBackgroundResource = 0;
        this.navigationBarHeight = 0;
        this.forceTint = true;
        this.titleState = TitleState.SHOW_WHEN_ACTIVE;
        init(context2, null);
    }

    public AHBottomNavigation(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.items = new ArrayList<>();
        this.views = new ArrayList<>();
        this.colored = false;
        this.selectedBackgroundVisible = false;
        this.notifications = AHNotification.generateEmptyList(5);
        this.itemsEnabledStates = new Boolean[]{true, true, true, true, true};
        this.isBehaviorTranslationSet = false;
        this.currentItem = 0;
        this.currentColor = 0;
        this.behaviorTranslationEnabled = true;
        this.needHideBottomNavigation = false;
        this.hideBottomNavigationWithAnimation = false;
        this.soundEffectsEnabled = true;
        this.defaultBackgroundColor = -1;
        this.defaultBackgroundResource = 0;
        this.navigationBarHeight = 0;
        this.forceTint = true;
        this.titleState = TitleState.SHOW_WHEN_ACTIVE;
        init(context2, attributeSet);
    }

    public AHBottomNavigation(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.items = new ArrayList<>();
        this.views = new ArrayList<>();
        this.colored = false;
        this.selectedBackgroundVisible = false;
        this.notifications = AHNotification.generateEmptyList(5);
        this.itemsEnabledStates = new Boolean[]{true, true, true, true, true};
        this.isBehaviorTranslationSet = false;
        this.currentItem = 0;
        this.currentColor = 0;
        this.behaviorTranslationEnabled = true;
        this.needHideBottomNavigation = false;
        this.hideBottomNavigationWithAnimation = false;
        this.soundEffectsEnabled = true;
        this.defaultBackgroundColor = -1;
        this.defaultBackgroundResource = 0;
        this.navigationBarHeight = 0;
        this.forceTint = true;
        this.titleState = TitleState.SHOW_WHEN_ACTIVE;
        init(context2, attributeSet);
    }

    @Override // android.view.View
    public void setSoundEffectsEnabled(boolean z) {
        super.setSoundEffectsEnabled(z);
        this.soundEffectsEnabled = z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        createItems();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.isBehaviorTranslationSet) {
            setBehaviorTranslationEnabled(this.behaviorTranslationEnabled);
            this.isBehaviorTranslationSet = true;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("current_item", this.currentItem);
        bundle.putParcelableArrayList("notifications", new ArrayList<>(this.notifications));
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.currentItem = bundle.getInt("current_item");
            this.notifications = bundle.getParcelableArrayList("notifications");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void init(Context context2, AttributeSet attributeSet) {
        this.context = context2;
        this.resources = context2.getResources();
        this.titleColorActive = ContextCompat.getColor(context2, R.color.colorBottomNavigationAccent);
        this.titleColorInactive = ContextCompat.getColor(context2, R.color.colorBottomNavigationInactive);
        this.itemDisableColor = ContextCompat.getColor(context2, R.color.colorBottomNavigationDisable);
        this.coloredTitleColorActive = ContextCompat.getColor(context2, R.color.colorBottomNavigationActiveColored);
        this.coloredTitleColorInactive = ContextCompat.getColor(context2, R.color.colorBottomNavigationInactiveColored);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.AHBottomNavigationBehavior_Params, 0, 0);
            try {
                this.selectedBackgroundVisible = obtainStyledAttributes.getBoolean(R.styleable.AHBottomNavigationBehavior_Params_selectedBackgroundVisible, false);
                this.translucentNavigationEnabled = obtainStyledAttributes.getBoolean(R.styleable.AHBottomNavigationBehavior_Params_translucentNavigationEnabled, false);
                this.titleColorActive = obtainStyledAttributes.getColor(R.styleable.AHBottomNavigationBehavior_Params_accentColor, ContextCompat.getColor(context2, R.color.colorBottomNavigationAccent));
                this.titleColorInactive = obtainStyledAttributes.getColor(R.styleable.AHBottomNavigationBehavior_Params_inactiveColor, ContextCompat.getColor(context2, R.color.colorBottomNavigationInactive));
                this.itemDisableColor = obtainStyledAttributes.getColor(R.styleable.AHBottomNavigationBehavior_Params_disableColor, ContextCompat.getColor(context2, R.color.colorBottomNavigationDisable));
                this.coloredTitleColorActive = obtainStyledAttributes.getColor(R.styleable.AHBottomNavigationBehavior_Params_coloredActive, ContextCompat.getColor(context2, R.color.colorBottomNavigationActiveColored));
                this.coloredTitleColorInactive = obtainStyledAttributes.getColor(R.styleable.AHBottomNavigationBehavior_Params_coloredInactive, ContextCompat.getColor(context2, R.color.colorBottomNavigationInactiveColored));
                this.colored = obtainStyledAttributes.getBoolean(R.styleable.AHBottomNavigationBehavior_Params_colored, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.notificationTextColor = ContextCompat.getColor(context2, 17170443);
        this.bottomNavigationHeight = (int) this.resources.getDimension(R.dimen.bottom_navigation_height);
        this.itemActiveColor = this.titleColorActive;
        this.itemInactiveColor = this.titleColorInactive;
        this.notificationActiveMarginLeft = (int) this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_left_active);
        this.notificationInactiveMarginLeft = (int) this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_left);
        this.notificationActiveMarginTop = (int) this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_top_active);
        this.notificationInactiveMarginTop = (int) this.resources.getDimension(R.dimen.bottom_navigation_notification_margin_top);
        this.notificationAnimationDuration = 150;
        ViewCompat.setElevation(this, this.resources.getDimension(R.dimen.bottom_navigation_elevation));
        setLayoutParams(new ViewGroup.LayoutParams(-1, this.bottomNavigationHeight));
    }

    private void createItems() {
        if (this.items.size() < 3) {
            Log.w(TAG, "The items list should have at least 3 items");
        } else if (this.items.size() > 5) {
            Log.w(TAG, "The items list should not have more than 5 items");
        }
        int dimension = (int) this.resources.getDimension(R.dimen.bottom_navigation_height);
        removeAllViews();
        this.views.clear();
        this.backgroundColorView = new View(this.context);
        if (Build.VERSION.SDK_INT >= 21) {
            addView(this.backgroundColorView, new FrameLayout.LayoutParams(-1, calculateHeight(dimension)));
            this.bottomNavigationHeight = dimension;
        }
        LinearLayout linearLayout = new LinearLayout(this.context);
        this.linearLayoutContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.linearLayoutContainer.setGravity(17);
        addView(this.linearLayoutContainer, new FrameLayout.LayoutParams(-1, dimension));
        if (isClassic()) {
            createClassicItems(this.linearLayoutContainer);
        } else {
            createSmallItems(this.linearLayoutContainer);
        }
        post(new Runnable() {
            /* class com.aurelhubert.ahbottomnavigation.AHBottomNavigation.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                AHBottomNavigation.this.requestLayout();
            }
        });
    }

    private int calculateHeight(int i) {
        if (!this.translucentNavigationEnabled) {
            return i;
        }
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.navigationBarHeight = this.resources.getDimensionPixelSize(identifier);
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{16842973, 16843760});
        obtainStyledAttributes.getBoolean(0, false);
        boolean z = obtainStyledAttributes.getBoolean(1, true);
        if (hasImmersive() && z) {
            i += this.navigationBarHeight;
        }
        obtainStyledAttributes.recycle();
        return i;
    }

    public boolean hasImmersive() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 > displayMetrics2.widthPixels || i > displayMetrics2.heightPixels;
    }

    private boolean isClassic() {
        return (this.titleState == TitleState.ALWAYS_HIDE || this.titleState == TitleState.SHOW_WHEN_ACTIVE_FORCE || (this.items.size() != 3 && this.titleState != TitleState.ALWAYS_SHOW)) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2  */
    private void createClassicItems(LinearLayout linearLayout) {
        final int i;
        float f;
        Drawable drawable;
        Drawable drawable2;
        boolean z;
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        float dimension = this.resources.getDimension(R.dimen.bottom_navigation_height);
        float dimension2 = this.resources.getDimension(R.dimen.bottom_navigation_min_width);
        float dimension3 = this.resources.getDimension(R.dimen.bottom_navigation_max_width);
        if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
            dimension2 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_min_width);
            dimension3 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_max_width);
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (width != 0 && this.items.size() != 0) {
            float size = (float) (width / this.items.size());
            if (size >= dimension2) {
                dimension2 = size > dimension3 ? dimension3 : size;
            }
            float dimension4 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_active);
            float dimension5 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_inactive);
            int dimension6 = (int) this.resources.getDimension(R.dimen.bottom_navigation_margin_top_active);
            float f2 = this.titleActiveTextSize;
            if (f2 != 0.0f) {
                float f3 = this.titleInactiveTextSize;
                if (f3 != 0.0f) {
                    dimension4 = f2;
                    dimension5 = f3;
                    boolean z2 = false;
                    i = 0;
                    while (i < this.items.size()) {
                        boolean z3 = this.currentItem == i;
                        AHBottomNavigationItem aHBottomNavigationItem = this.items.get(i);
                        View inflate = layoutInflater.inflate(R.layout.bottom_navigation_item, this, z2);
                        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.bottom_navigation_container);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.bottom_navigation_item_icon);
                        TextView textView = (TextView) inflate.findViewById(R.id.bottom_navigation_item_title);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.bottom_navigation_notification);
                        imageView.setImageDrawable(aHBottomNavigationItem.getDrawable(this.context));
                        textView.setText(aHBottomNavigationItem.getTitle(this.context));
                        Typeface typeface = this.titleTypeface;
                        if (typeface != null) {
                            textView.setTypeface(typeface);
                        }
                        if (this.titleState != TitleState.ALWAYS_SHOW || this.items.size() <= 3) {
                            f = dimension4;
                        } else {
                            f = dimension4;
                            frameLayout.setPadding(0, frameLayout.getPaddingTop(), 0, frameLayout.getPaddingBottom());
                        }
                        if (z3) {
                            if (this.selectedBackgroundVisible) {
                                z = true;
                                inflate.setSelected(true);
                            } else {
                                z = true;
                            }
                            imageView.setSelected(z);
                            if (inflate.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, dimension6, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                                marginLayoutParams2.setMargins(this.notificationActiveMarginLeft, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                                inflate.requestLayout();
                            }
                        } else {
                            imageView.setSelected(false);
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                            marginLayoutParams3.setMargins(this.notificationInactiveMarginLeft, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                        }
                        if (!this.colored) {
                            int i2 = this.defaultBackgroundResource;
                            if (i2 != 0) {
                                setBackgroundResource(i2);
                            } else {
                                setBackgroundColor(this.defaultBackgroundColor);
                            }
                        } else if (z3) {
                            setBackgroundColor(aHBottomNavigationItem.getColor(this.context));
                            this.currentColor = aHBottomNavigationItem.getColor(this.context);
                        }
                        textView.setTextSize(0, z3 ? f : dimension5);
                        if (this.itemsEnabledStates[i].booleanValue()) {
                            inflate.setOnClickListener(new View.OnClickListener() {
                                /* class com.aurelhubert.ahbottomnavigation.AHBottomNavigation.AnonymousClass2 */

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AHBottomNavigation.this.updateItems(i, true);
                                }
                            });
                            if (this.forceTint) {
                                drawable2 = AHHelper.getTintDrawable(this.items.get(i).getDrawable(this.context), z3 ? this.itemActiveColor : this.itemInactiveColor, this.forceTint);
                            } else {
                                drawable2 = this.items.get(i).getDrawable(this.context);
                            }
                            imageView.setImageDrawable(drawable2);
                            textView.setTextColor(z3 ? this.itemActiveColor : this.itemInactiveColor);
                            inflate.setSoundEffectsEnabled(this.soundEffectsEnabled);
                            inflate.setEnabled(true);
                        } else {
                            if (this.forceTint) {
                                drawable = AHHelper.getTintDrawable(this.items.get(i).getDrawable(this.context), this.itemDisableColor, this.forceTint);
                            } else {
                                drawable = this.items.get(i).getDrawable(this.context);
                            }
                            imageView.setImageDrawable(drawable);
                            textView.setTextColor(this.itemDisableColor);
                            inflate.setClickable(true);
                            inflate.setEnabled(false);
                        }
                        linearLayout.addView(inflate, new FrameLayout.LayoutParams((int) dimension2, (int) dimension));
                        this.views.add(inflate);
                        i++;
                        layoutInflater = layoutInflater;
                        dimension4 = f;
                        z2 = false;
                    }
                    updateNotifications(true, -1);
                }
            }
            if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
                dimension4 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_active);
                dimension5 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_inactive);
            }
            boolean z2 = false;
            i = 0;
            while (i < this.items.size()) {
            }
            updateNotifications(true, -1);
        }
    }

    private void createSmallItems(LinearLayout linearLayout) {
        Drawable drawable;
        Drawable drawable2;
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        float dimension = this.resources.getDimension(R.dimen.bottom_navigation_height);
        float dimension2 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_min_width);
        float dimension3 = this.resources.getDimension(R.dimen.bottom_navigation_small_inactive_max_width);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (width != 0 && this.items.size() != 0) {
            float size = (float) (width / this.items.size());
            if (size >= dimension2) {
                dimension2 = size > dimension3 ? dimension3 : size;
            }
            int dimension4 = (int) this.resources.getDimension(R.dimen.bottom_navigation_small_margin_top_active);
            float dimension5 = this.resources.getDimension(R.dimen.bottom_navigation_small_selected_width_difference);
            this.selectedItemWidth = (((float) this.items.size()) * dimension5) + dimension2;
            float f = dimension2 - dimension5;
            this.notSelectedItemWidth = f;
            final int i = 0;
            while (i < this.items.size()) {
                AHBottomNavigationItem aHBottomNavigationItem = this.items.get(i);
                View inflate = layoutInflater.inflate(R.layout.bottom_navigation_small_item, (ViewGroup) this, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.bottom_navigation_small_item_icon);
                TextView textView = (TextView) inflate.findViewById(R.id.bottom_navigation_small_item_title);
                TextView textView2 = (TextView) inflate.findViewById(R.id.bottom_navigation_notification);
                imageView.setImageDrawable(aHBottomNavigationItem.getDrawable(this.context));
                if (this.titleState != TitleState.ALWAYS_HIDE) {
                    textView.setText(aHBottomNavigationItem.getTitle(this.context));
                }
                float f2 = this.titleActiveTextSize;
                if (f2 != 0.0f) {
                    textView.setTextSize(0, f2);
                }
                Typeface typeface = this.titleTypeface;
                if (typeface != null) {
                    textView.setTypeface(typeface);
                }
                if (i == this.currentItem) {
                    if (this.selectedBackgroundVisible) {
                        inflate.setSelected(true);
                    }
                    imageView.setSelected(true);
                    if (this.titleState != TitleState.ALWAYS_HIDE && (inflate.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, dimension4, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                        marginLayoutParams2.setMargins(this.notificationActiveMarginLeft, this.notificationActiveMarginTop, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                        inflate.requestLayout();
                    }
                } else {
                    imageView.setSelected(false);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                    marginLayoutParams3.setMargins(this.notificationInactiveMarginLeft, this.notificationInactiveMarginTop, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                }
                if (!this.colored) {
                    int i2 = this.defaultBackgroundResource;
                    if (i2 != 0) {
                        setBackgroundResource(i2);
                    } else {
                        setBackgroundColor(this.defaultBackgroundColor);
                    }
                } else if (i == this.currentItem) {
                    setBackgroundColor(aHBottomNavigationItem.getColor(this.context));
                    this.currentColor = aHBottomNavigationItem.getColor(this.context);
                }
                if (this.itemsEnabledStates[i].booleanValue()) {
                    if (this.forceTint) {
                        drawable2 = AHHelper.getTintDrawable(this.items.get(i).getDrawable(this.context), this.currentItem == i ? this.itemActiveColor : this.itemInactiveColor, this.forceTint);
                    } else {
                        drawable2 = this.items.get(i).getDrawable(this.context);
                    }
                    imageView.setImageDrawable(drawable2);
                    textView.setTextColor(this.currentItem == i ? this.itemActiveColor : this.itemInactiveColor);
                    textView.setAlpha(this.currentItem == i ? 1.0f : 0.0f);
                    inflate.setOnClickListener(new View.OnClickListener() {
                        /* class com.aurelhubert.ahbottomnavigation.AHBottomNavigation.AnonymousClass3 */

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AHBottomNavigation.this.updateSmallItems(i, true);
                        }
                    });
                    inflate.setSoundEffectsEnabled(this.soundEffectsEnabled);
                    inflate.setEnabled(true);
                } else {
                    if (this.forceTint) {
                        drawable = AHHelper.getTintDrawable(this.items.get(i).getDrawable(this.context), this.itemDisableColor, this.forceTint);
                    } else {
                        drawable = this.items.get(i).getDrawable(this.context);
                    }
                    imageView.setImageDrawable(drawable);
                    textView.setTextColor(this.itemDisableColor);
                    textView.setAlpha(0.0f);
                    inflate.setClickable(true);
                    inflate.setEnabled(false);
                }
                int i3 = i == this.currentItem ? (int) this.selectedItemWidth : (int) f;
                if (this.titleState == TitleState.ALWAYS_HIDE) {
                    i3 = (int) (((double) f) * 1.16d);
                }
                linearLayout.addView(inflate, new FrameLayout.LayoutParams(i3, (int) dimension));
                this.views.add(inflate);
                i++;
            }
            updateNotifications(true, -1);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    public void updateItems(final int i, boolean z) {
        int i2;
        boolean z2 = true;
        if (this.currentItem == i) {
            OnTabSelectedListener onTabSelectedListener = this.tabSelectedListener;
            if (onTabSelectedListener != null && z) {
                onTabSelectedListener.onTabSelected(i, true);
                return;
            }
            return;
        }
        OnTabSelectedListener onTabSelectedListener2 = this.tabSelectedListener;
        if (onTabSelectedListener2 == null || !z || onTabSelectedListener2.onTabSelected(i, false)) {
            int dimension = (int) this.resources.getDimension(R.dimen.bottom_navigation_margin_top_active);
            int dimension2 = (int) this.resources.getDimension(R.dimen.bottom_navigation_margin_top_inactive);
            float dimension3 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_active);
            float dimension4 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_inactive);
            float f = this.titleActiveTextSize;
            if (f != 0.0f) {
                float f2 = this.titleInactiveTextSize;
                if (f2 != 0.0f) {
                    dimension3 = f;
                    dimension4 = f2;
                    i2 = 0;
                    while (i2 < this.views.size()) {
                        View view = this.views.get(i2);
                        if (this.selectedBackgroundVisible) {
                            view.setSelected(i2 == i);
                        }
                        if (i2 == i) {
                            TextView textView = (TextView) view.findViewById(R.id.bottom_navigation_item_title);
                            ImageView imageView = (ImageView) view.findViewById(R.id.bottom_navigation_item_icon);
                            imageView.setSelected(z2);
                            AHHelper.updateTopMargin(imageView, dimension2, dimension);
                            AHHelper.updateLeftMargin((TextView) view.findViewById(R.id.bottom_navigation_notification), this.notificationInactiveMarginLeft, this.notificationActiveMarginLeft);
                            AHHelper.updateTextColor(textView, this.itemInactiveColor, this.itemActiveColor);
                            AHHelper.updateTextSize(textView, dimension4, dimension3);
                            if (this.forceTint) {
                                AHHelper.updateDrawableColor(this.context, this.items.get(i).getDrawable(this.context), imageView, this.itemInactiveColor, this.itemActiveColor, this.forceTint);
                            }
                            if (Build.VERSION.SDK_INT >= 21 && this.colored) {
                                int max = Math.max(getWidth(), getHeight());
                                int x = ((int) view.getX()) + (view.getWidth() / 2);
                                int height = view.getHeight() / 2;
                                Animator animator = this.circleRevealAnim;
                                if (animator != null && animator.isRunning()) {
                                    this.circleRevealAnim.cancel();
                                    setBackgroundColor(this.items.get(i).getColor(this.context));
                                    this.backgroundColorView.setBackgroundColor(0);
                                }
                                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.backgroundColorView, x, height, 0.0f, (float) max);
                                this.circleRevealAnim = createCircularReveal;
                                createCircularReveal.setStartDelay(5);
                                this.circleRevealAnim.addListener(new Animator.AnimatorListener() {
                                    /* class com.aurelhubert.ahbottomnavigation.AHBottomNavigation.AnonymousClass4 */

                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationCancel(Animator animator) {
                                    }

                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationRepeat(Animator animator) {
                                    }

                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationStart(Animator animator) {
                                        AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem) AHBottomNavigation.this.items.get(i)).getColor(AHBottomNavigation.this.context));
                                    }

                                    @Override // android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator) {
                                        AHBottomNavigation aHBottomNavigation = AHBottomNavigation.this;
                                        aHBottomNavigation.setBackgroundColor(((AHBottomNavigationItem) aHBottomNavigation.items.get(i)).getColor(AHBottomNavigation.this.context));
                                        AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                                    }
                                });
                                this.circleRevealAnim.start();
                            } else if (this.colored) {
                                AHHelper.updateViewBackgroundColor(this, this.currentColor, this.items.get(i).getColor(this.context));
                            } else {
                                int i3 = this.defaultBackgroundResource;
                                if (i3 != 0) {
                                    setBackgroundResource(i3);
                                } else {
                                    setBackgroundColor(this.defaultBackgroundColor);
                                }
                                this.backgroundColorView.setBackgroundColor(0);
                            }
                        } else if (i2 == this.currentItem) {
                            TextView textView2 = (TextView) view.findViewById(R.id.bottom_navigation_item_title);
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.bottom_navigation_item_icon);
                            imageView2.setSelected(false);
                            AHHelper.updateTopMargin(imageView2, dimension, dimension2);
                            AHHelper.updateLeftMargin((TextView) view.findViewById(R.id.bottom_navigation_notification), this.notificationActiveMarginLeft, this.notificationInactiveMarginLeft);
                            AHHelper.updateTextColor(textView2, this.itemActiveColor, this.itemInactiveColor);
                            AHHelper.updateTextSize(textView2, dimension3, dimension4);
                            if (this.forceTint) {
                                AHHelper.updateDrawableColor(this.context, this.items.get(this.currentItem).getDrawable(this.context), imageView2, this.itemActiveColor, this.itemInactiveColor, this.forceTint);
                            }
                        }
                        i2++;
                        z2 = true;
                    }
                    this.currentItem = i;
                    if (i <= 0 && i < this.items.size()) {
                        this.currentColor = this.items.get(this.currentItem).getColor(this.context);
                        return;
                    } else if (this.currentItem != -1) {
                        int i4 = this.defaultBackgroundResource;
                        if (i4 != 0) {
                            setBackgroundResource(i4);
                        } else {
                            setBackgroundColor(this.defaultBackgroundColor);
                        }
                        this.backgroundColorView.setBackgroundColor(0);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
                dimension3 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_active);
                dimension4 = this.resources.getDimension(R.dimen.bottom_navigation_text_size_forced_inactive);
            }
            i2 = 0;
            while (i2 < this.views.size()) {
            }
            this.currentItem = i;
            if (i <= 0) {
            }
            if (this.currentItem != -1) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateSmallItems(final int i, boolean z) {
        if (this.currentItem == i) {
            OnTabSelectedListener onTabSelectedListener = this.tabSelectedListener;
            if (onTabSelectedListener != null && z) {
                onTabSelectedListener.onTabSelected(i, true);
                return;
            }
            return;
        }
        OnTabSelectedListener onTabSelectedListener2 = this.tabSelectedListener;
        if (onTabSelectedListener2 == null || !z || onTabSelectedListener2.onTabSelected(i, false)) {
            int dimension = (int) this.resources.getDimension(R.dimen.bottom_navigation_small_margin_top_active);
            int dimension2 = (int) this.resources.getDimension(R.dimen.bottom_navigation_small_margin_top);
            int i2 = 0;
            while (i2 < this.views.size()) {
                View view = this.views.get(i2);
                if (this.selectedBackgroundVisible) {
                    view.setSelected(i2 == i);
                }
                if (i2 == i) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.bottom_navigation_small_container);
                    TextView textView = (TextView) view.findViewById(R.id.bottom_navigation_small_item_title);
                    ImageView imageView = (ImageView) view.findViewById(R.id.bottom_navigation_small_item_icon);
                    TextView textView2 = (TextView) view.findViewById(R.id.bottom_navigation_notification);
                    imageView.setSelected(true);
                    if (this.titleState != TitleState.ALWAYS_HIDE) {
                        AHHelper.updateTopMargin(imageView, dimension2, dimension);
                        AHHelper.updateLeftMargin(textView2, this.notificationInactiveMarginLeft, this.notificationActiveMarginLeft);
                        AHHelper.updateTopMargin(textView2, this.notificationInactiveMarginTop, this.notificationActiveMarginTop);
                        AHHelper.updateTextColor(textView, this.itemInactiveColor, this.itemActiveColor);
                        AHHelper.updateWidth(frameLayout, this.notSelectedItemWidth, this.selectedItemWidth);
                    }
                    AHHelper.updateAlpha(textView, 0.0f, 1.0f);
                    if (this.forceTint) {
                        AHHelper.updateDrawableColor(this.context, this.items.get(i).getDrawable(this.context), imageView, this.itemInactiveColor, this.itemActiveColor, this.forceTint);
                    }
                    if (Build.VERSION.SDK_INT >= 21 && this.colored) {
                        int max = Math.max(getWidth(), getHeight());
                        int x = ((int) this.views.get(i).getX()) + (this.views.get(i).getWidth() / 2);
                        int height = this.views.get(i).getHeight() / 2;
                        Animator animator = this.circleRevealAnim;
                        if (animator != null && animator.isRunning()) {
                            this.circleRevealAnim.cancel();
                            setBackgroundColor(this.items.get(i).getColor(this.context));
                            this.backgroundColorView.setBackgroundColor(0);
                        }
                        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.backgroundColorView, x, height, 0.0f, (float) max);
                        this.circleRevealAnim = createCircularReveal;
                        createCircularReveal.setStartDelay(5);
                        this.circleRevealAnim.addListener(new Animator.AnimatorListener() {
                            /* class com.aurelhubert.ahbottomnavigation.AHBottomNavigation.AnonymousClass5 */

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem) AHBottomNavigation.this.items.get(i)).getColor(AHBottomNavigation.this.context));
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                AHBottomNavigation aHBottomNavigation = AHBottomNavigation.this;
                                aHBottomNavigation.setBackgroundColor(((AHBottomNavigationItem) aHBottomNavigation.items.get(i)).getColor(AHBottomNavigation.this.context));
                                AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                            }
                        });
                        this.circleRevealAnim.start();
                    } else if (this.colored) {
                        AHHelper.updateViewBackgroundColor(this, this.currentColor, this.items.get(i).getColor(this.context));
                    } else {
                        int i3 = this.defaultBackgroundResource;
                        if (i3 != 0) {
                            setBackgroundResource(i3);
                        } else {
                            setBackgroundColor(this.defaultBackgroundColor);
                        }
                        this.backgroundColorView.setBackgroundColor(0);
                    }
                } else if (i2 == this.currentItem) {
                    View findViewById = view.findViewById(R.id.bottom_navigation_small_container);
                    TextView textView3 = (TextView) view.findViewById(R.id.bottom_navigation_small_item_title);
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.bottom_navigation_small_item_icon);
                    TextView textView4 = (TextView) view.findViewById(R.id.bottom_navigation_notification);
                    imageView2.setSelected(false);
                    if (this.titleState != TitleState.ALWAYS_HIDE) {
                        AHHelper.updateTopMargin(imageView2, dimension, dimension2);
                        AHHelper.updateLeftMargin(textView4, this.notificationActiveMarginLeft, this.notificationInactiveMarginLeft);
                        AHHelper.updateTopMargin(textView4, this.notificationActiveMarginTop, this.notificationInactiveMarginTop);
                        AHHelper.updateTextColor(textView3, this.itemActiveColor, this.itemInactiveColor);
                        AHHelper.updateWidth(findViewById, this.selectedItemWidth, this.notSelectedItemWidth);
                    }
                    AHHelper.updateAlpha(textView3, 1.0f, 0.0f);
                    if (this.forceTint) {
                        AHHelper.updateDrawableColor(this.context, this.items.get(this.currentItem).getDrawable(this.context), imageView2, this.itemActiveColor, this.itemInactiveColor, this.forceTint);
                    }
                }
                i2++;
            }
            this.currentItem = i;
            if (i > 0 && i < this.items.size()) {
                this.currentColor = this.items.get(this.currentItem).getColor(this.context);
            } else if (this.currentItem == -1) {
                int i4 = this.defaultBackgroundResource;
                if (i4 != 0) {
                    setBackgroundResource(i4);
                } else {
                    setBackgroundColor(this.defaultBackgroundColor);
                }
                this.backgroundColorView.setBackgroundColor(0);
            }
        }
    }

    private void updateNotifications(boolean z, int i) {
        int i2 = 0;
        while (i2 < this.views.size() && i2 < this.notifications.size()) {
            if (i == -1 || i == i2) {
                AHNotification aHNotification = this.notifications.get(i2);
                int textColor = AHNotificationHelper.getTextColor(aHNotification, this.notificationTextColor);
                int backgroundColor = AHNotificationHelper.getBackgroundColor(aHNotification, this.notificationBackgroundColor);
                TextView textView = (TextView) this.views.get(i2).findViewById(R.id.bottom_navigation_notification);
                boolean z2 = !textView.getText().toString().equals(String.valueOf(aHNotification.getText()));
                if (z) {
                    textView.setTextColor(textColor);
                    Typeface typeface = this.notificationTypeface;
                    if (typeface != null) {
                        textView.setTypeface(typeface);
                    } else {
                        textView.setTypeface(null, 1);
                    }
                    if (this.notificationBackgroundDrawable != null) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            textView.setBackground(this.notificationBackgroundDrawable.getConstantState().newDrawable());
                        } else {
                            textView.setBackgroundDrawable(this.notificationBackgroundDrawable);
                        }
                    } else if (backgroundColor != 0) {
                        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.notification_background);
                        if (Build.VERSION.SDK_INT >= 16) {
                            textView.setBackground(AHHelper.getTintDrawable(drawable, backgroundColor, this.forceTint));
                        } else {
                            textView.setBackgroundDrawable(AHHelper.getTintDrawable(drawable, backgroundColor, this.forceTint));
                        }
                    }
                }
                if (aHNotification.isEmpty() && textView.getText().length() > 0) {
                    textView.setText("");
                    if (z2) {
                        textView.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(this.notificationAnimationDuration).start();
                    }
                } else if (!aHNotification.isEmpty()) {
                    textView.setText(String.valueOf(aHNotification.getText()));
                    if (z2) {
                        textView.setScaleX(0.0f);
                        textView.setScaleY(0.0f);
                        textView.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(new OvershootInterpolator()).setDuration(this.notificationAnimationDuration).start();
                    }
                }
            }
            i2++;
        }
    }

    public void addItemAtIndex(int i, AHBottomNavigationItem aHBottomNavigationItem) {
        if (this.items.size() > 5) {
            Log.w(TAG, "The items list should not have more than 5 items");
        }
        if (i < this.items.size()) {
            this.items.add(i, aHBottomNavigationItem);
        } else {
            String str = TAG;
            Log.w(str, "The index is out of bounds (index: " + i + ", size: " + this.items.size() + ")");
        }
        createItems();
    }

    public void addItem(AHBottomNavigationItem aHBottomNavigationItem) {
        if (this.items.size() > 5) {
            Log.w(TAG, "The items list should not have more than 5 items");
        }
        this.items.add(aHBottomNavigationItem);
        createItems();
    }

    public void addItems(List<AHBottomNavigationItem> list) {
        if (list.size() > 5 || this.items.size() + list.size() > 5) {
            Log.w(TAG, "The items list should not have more than 5 items");
        }
        this.items.addAll(list);
        createItems();
    }

    public void removeItemAtIndex(int i) {
        if (i < this.items.size()) {
            this.items.remove(i);
            createItems();
        }
    }

    public void removeAllItems() {
        this.items.clear();
        createItems();
    }

    public void refresh() {
        createItems();
    }

    public int getItemsCount() {
        return this.items.size();
    }

    public boolean isColored() {
        return this.colored;
    }

    public void setColored(boolean z) {
        this.colored = z;
        this.itemActiveColor = z ? this.coloredTitleColorActive : this.titleColorActive;
        this.itemInactiveColor = z ? this.coloredTitleColorInactive : this.titleColorInactive;
        createItems();
    }

    public int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    public void setDefaultBackgroundColor(int i) {
        this.defaultBackgroundColor = i;
        createItems();
    }

    public void setDefaultBackgroundResource(int i) {
        this.defaultBackgroundResource = i;
        createItems();
    }

    public int getAccentColor() {
        return this.itemActiveColor;
    }

    public void setAccentColor(int i) {
        this.titleColorActive = i;
        this.itemActiveColor = i;
        createItems();
    }

    public int getInactiveColor() {
        return this.itemInactiveColor;
    }

    public void setInactiveColor(int i) {
        this.titleColorInactive = i;
        this.itemInactiveColor = i;
        createItems();
    }

    public void setColoredModeColors(int i, int i2) {
        this.coloredTitleColorActive = i;
        this.coloredTitleColorInactive = i2;
        createItems();
    }

    public void setSelectedBackgroundVisible(boolean z) {
        this.selectedBackgroundVisible = z;
        createItems();
    }

    public void setTitleTypeface(Typeface typeface) {
        this.titleTypeface = typeface;
        createItems();
    }

    public void setTitleTextSize(float f, float f2) {
        this.titleActiveTextSize = f;
        this.titleInactiveTextSize = f2;
        createItems();
    }

    public void setTitleTextSizeInSp(float f, float f2) {
        this.titleActiveTextSize = TypedValue.applyDimension(2, f, this.resources.getDisplayMetrics());
        this.titleInactiveTextSize = TypedValue.applyDimension(2, f2, this.resources.getDisplayMetrics());
        createItems();
    }

    public AHBottomNavigationItem getItem(int i) {
        if (i >= 0 && i <= this.items.size() - 1) {
            return this.items.get(i);
        }
        String str = TAG;
        Log.w(str, "The position is out of bounds of the items (" + this.items.size() + " elements)");
        return null;
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setCurrentItem(int i, boolean z) {
        if (i >= this.items.size()) {
            String str = TAG;
            Log.w(str, "The position is out of bounds of the items (" + this.items.size() + " elements)");
        } else if (this.titleState == TitleState.ALWAYS_HIDE || this.titleState == TitleState.SHOW_WHEN_ACTIVE_FORCE || !(this.items.size() == 3 || this.titleState == TitleState.ALWAYS_SHOW)) {
            updateSmallItems(i, z);
        } else {
            updateItems(i, z);
        }
    }

    public boolean isBehaviorTranslationEnabled() {
        return this.behaviorTranslationEnabled;
    }

    public void setBehaviorTranslationEnabled(boolean z) {
        this.behaviorTranslationEnabled = z;
        if (getParent() instanceof CoordinatorLayout) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
            if (aHBottomNavigationBehavior == null) {
                this.bottomNavigationBehavior = new AHBottomNavigationBehavior<>(z, this.navigationBarHeight);
            } else {
                aHBottomNavigationBehavior.setBehaviorTranslationEnabled(z, this.navigationBarHeight);
            }
            OnNavigationPositionListener onNavigationPositionListener = this.navigationPositionListener;
            if (onNavigationPositionListener != null) {
                this.bottomNavigationBehavior.setOnNavigationPositionListener(onNavigationPositionListener);
            }
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(this.bottomNavigationBehavior);
            if (this.needHideBottomNavigation) {
                this.needHideBottomNavigation = false;
                this.bottomNavigationBehavior.hideView(this, this.bottomNavigationHeight, this.hideBottomNavigationWithAnimation);
            }
        }
    }

    public void manageFloatingActionButtonBehavior(FloatingActionButton floatingActionButton) {
        if (floatingActionButton.getParent() instanceof CoordinatorLayout) {
            ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).setBehavior(new AHBottomNavigationFABBehavior(this.navigationBarHeight));
        }
    }

    public void hideBottomNavigation() {
        hideBottomNavigation(true);
    }

    public void hideBottomNavigation(boolean z) {
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.hideView(this, this.bottomNavigationHeight, z);
        } else if (getParent() instanceof CoordinatorLayout) {
            this.needHideBottomNavigation = true;
            this.hideBottomNavigationWithAnimation = z;
        } else {
            ViewCompat.animate(this).translationY((float) this.bottomNavigationHeight).setInterpolator(new LinearOutSlowInInterpolator()).setDuration(z ? 300 : 0).start();
        }
    }

    public void restoreBottomNavigation() {
        restoreBottomNavigation(true);
    }

    public void restoreBottomNavigation(boolean z) {
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.resetOffset(this, z);
        } else {
            ViewCompat.animate(this).translationY(0.0f).setInterpolator(new LinearOutSlowInInterpolator()).setDuration(z ? 300 : 0).start();
        }
    }

    public boolean isTranslucentNavigationEnabled() {
        return this.translucentNavigationEnabled;
    }

    public void setTranslucentNavigationEnabled(boolean z) {
        this.translucentNavigationEnabled = z;
    }

    public boolean isForceTint() {
        return this.forceTint;
    }

    public void setForceTint(boolean z) {
        this.forceTint = z;
        createItems();
    }

    public TitleState getTitleState() {
        return this.titleState;
    }

    public void setTitleState(TitleState titleState2) {
        this.titleState = titleState2;
        createItems();
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.tabSelectedListener = onTabSelectedListener;
    }

    public void removeOnTabSelectedListener() {
        this.tabSelectedListener = null;
    }

    public void setOnNavigationPositionListener(OnNavigationPositionListener onNavigationPositionListener) {
        this.navigationPositionListener = onNavigationPositionListener;
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.setOnNavigationPositionListener(onNavigationPositionListener);
        }
    }

    public void removeOnNavigationPositionListener() {
        this.navigationPositionListener = null;
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.removeOnNavigationPositionListener();
        }
    }

    @Deprecated
    public void setNotification(int i, int i2) {
        String str;
        if (i2 < 0 || i2 > this.items.size() - 1) {
            throw new IndexOutOfBoundsException(String.format(Locale.US, "The position (%d) is out of bounds of the items (%d elements)", Integer.valueOf(i2), Integer.valueOf(this.items.size())));
        }
        if (i == 0) {
            str = "";
        } else {
            str = String.valueOf(i);
        }
        this.notifications.set(i2, AHNotification.justText(str));
        updateNotifications(false, i2);
    }

    public void setNotification(String str, int i) {
        if (i < 0 || i > this.items.size() - 1) {
            throw new IndexOutOfBoundsException(String.format(Locale.US, "The position (%d) is out of bounds of the items (%d elements)", Integer.valueOf(i), Integer.valueOf(this.items.size())));
        }
        this.notifications.set(i, AHNotification.justText(str));
        updateNotifications(false, i);
    }

    public void setNotification(AHNotification aHNotification, int i) {
        if (i < 0 || i > this.items.size() - 1) {
            throw new IndexOutOfBoundsException(String.format(Locale.US, "The position (%d) is out of bounds of the items (%d elements)", Integer.valueOf(i), Integer.valueOf(this.items.size())));
        }
        if (aHNotification == null) {
            aHNotification = new AHNotification();
        }
        this.notifications.set(i, aHNotification);
        updateNotifications(true, i);
    }

    public void setNotificationTextColor(int i) {
        this.notificationTextColor = i;
        updateNotifications(true, -1);
    }

    public void setNotificationTextColorResource(int i) {
        this.notificationTextColor = ContextCompat.getColor(this.context, i);
        updateNotifications(true, -1);
    }

    public void setNotificationBackground(Drawable drawable) {
        this.notificationBackgroundDrawable = drawable;
        updateNotifications(true, -1);
    }

    public void setNotificationBackgroundColor(int i) {
        this.notificationBackgroundColor = i;
        updateNotifications(true, -1);
    }

    public void setNotificationBackgroundColorResource(int i) {
        this.notificationBackgroundColor = ContextCompat.getColor(this.context, i);
        updateNotifications(true, -1);
    }

    public void setNotificationTypeface(Typeface typeface) {
        this.notificationTypeface = typeface;
        updateNotifications(true, -1);
    }

    public void setNotificationAnimationDuration(long j) {
        this.notificationAnimationDuration = j;
        updateNotifications(true, -1);
    }

    public void setNotificationMarginLeft(int i, int i2) {
        this.notificationActiveMarginLeft = i;
        this.notificationInactiveMarginLeft = i2;
        createItems();
    }

    public void setUseElevation(boolean z) {
        ViewCompat.setElevation(this, z ? this.resources.getDimension(R.dimen.bottom_navigation_elevation) : 0.0f);
        setClipToPadding(false);
    }

    public void setUseElevation(boolean z, float f) {
        if (!z) {
            f = 0.0f;
        }
        ViewCompat.setElevation(this, f);
        setClipToPadding(false);
    }

    public boolean isHidden() {
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            return aHBottomNavigationBehavior.isHidden();
        }
        return false;
    }

    public View getViewAtPosition(int i) {
        LinearLayout linearLayout = this.linearLayoutContainer;
        if (linearLayout == null || i < 0 || i >= linearLayout.getChildCount()) {
            return null;
        }
        return this.linearLayoutContainer.getChildAt(i);
    }

    public void enableItemAtPosition(int i) {
        if (i < 0 || i > this.items.size() - 1) {
            String str = TAG;
            Log.w(str, "The position is out of bounds of the items (" + this.items.size() + " elements)");
            return;
        }
        this.itemsEnabledStates[i] = true;
        createItems();
    }

    public void disableItemAtPosition(int i) {
        if (i < 0 || i > this.items.size() - 1) {
            String str = TAG;
            Log.w(str, "The position is out of bounds of the items (" + this.items.size() + " elements)");
            return;
        }
        this.itemsEnabledStates[i] = false;
        createItems();
    }

    public void setItemDisableColor(int i) {
        this.itemDisableColor = i;
    }
}
