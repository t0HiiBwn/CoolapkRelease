package com.coolapk.market.widget.emotion;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.EmotionPanelBinding;
import com.coolapk.market.databinding.EmotionPanelBottomTextBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.widget.emotion.Emotions;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmotionPanel extends FrameLayout implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final View.OnTouchListener BLOCK_ALL_LISTENER = new View.OnTouchListener() {
        /* class com.coolapk.market.widget.emotion.EmotionPanel.AnonymousClass1 */

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final int COLUMN_COUNT = 7;
    private static final BaseEmotion DELETE_EMOTION = new Emotions.DrawableEmotion(2131231167, "删除");
    private static final BaseEmotion EMPTY_EMOTION = new Emotions.EmptyEmotion();
    private static final int MAX_EMOTION_ONE_PAGE = 20;
    private static final RecentEmotionControl RECENT_EMOTION_CONTROL = new RecentEmotionControl();
    private EmotionPanelBinding mBinding;
    private List<EmotionItem> mEmotionItems;
    private LayoutInflater mLayoutInflater;
    private EmotionPanelListener mListener;
    private GridView mRecentGridView;
    private int mRecentGridViewPage;
    private RepeatListener mRepeatListener;

    public interface EmotionPanelListener {
        void onDeleteButtonClick();

        void onEmotionClick(BaseEmotion baseEmotion);
    }

    public EmotionPanel(Context context) {
        super(context);
        init();
    }

    public EmotionPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mLayoutInflater = LayoutInflater.from(getContext());
        this.mRepeatListener = new RepeatListener(1000, 50, new View.OnClickListener() {
            /* class com.coolapk.market.widget.emotion.$$Lambda$EmotionPanel$iJESAzmiqUCtGJkXrTSlMecK0kY */

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionPanel.this.lambda$init$0$EmotionPanel(view);
            }
        });
        this.mEmotionItems = new ArrayList();
        int i = 1;
        if (isInEditMode()) {
            this.mLayoutInflater.inflate(2131558548, (ViewGroup) this, true);
            return;
        }
        this.mBinding = (EmotionPanelBinding) DataBindingUtil.inflate(this.mLayoutInflater, 2131558548, this, true);
        createBottomItem();
        this.mBinding.emotionPanelViewPager.setAdapter(new GridViewPageAdapter());
        this.mBinding.emotionPanelViewPager.addOnPageChangeListener(new IndicatorPageListener());
        int i2 = this.mRecentGridViewPage;
        if (RECENT_EMOTION_CONTROL.getList().size() != 0) {
            i = i2;
        }
        this.mBinding.emotionPanelViewPager.setCurrentItem(i, false);
        checkIndicatorCount(i);
        checkBottom(i);
    }

    public /* synthetic */ void lambda$init$0$EmotionPanel(View view) {
        EmotionPanelListener emotionPanelListener = this.mListener;
        if (emotionPanelListener != null) {
            emotionPanelListener.onDeleteButtonClick();
        }
    }

    private void createBottomItem() {
        LinearLayout linearLayout = this.mBinding.emotionPanelBottom;
        List<EmotionAlbum> emotionListCopyForPanel = EmotionUtils.getEmotionListCopyForPanel();
        emotionListCopyForPanel.add(0, new EmotionAlbum(null, false, RECENT_EMOTION_CONTROL.getList(), getContext().getString(2131887315)));
        this.mRecentGridViewPage = 0;
        linearLayout.removeAllViews();
        for (int i = 0; i < emotionListCopyForPanel.size(); i++) {
            EmotionPanelBottomTextBinding emotionPanelBottomTextBinding = (EmotionPanelBottomTextBinding) DataBindingUtil.inflate(this.mLayoutInflater, 2131558549, linearLayout, true);
            EmotionItem emotionItem = new EmotionItem(emotionListCopyForPanel.get(i));
            emotionItem.setItemView(emotionPanelBottomTextBinding.textView);
            emotionPanelBottomTextBinding.textView.setOnClickListener(this);
            this.mEmotionItems.add(emotionItem);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) emotionPanelBottomTextBinding.getRoot().getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            if (i < emotionListCopyForPanel.size() - 1) {
                layoutParams.rightMargin = DisplayUtils.dp2px(getContext(), 1.0f);
            }
        }
    }

    public void setupWithEditText(EditText editText) {
        setupWithListener(new EmotionToEditTextListener(editText));
    }

    public void setupWithListener(EmotionPanelListener emotionPanelListener) {
        this.mListener = emotionPanelListener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BaseEmotion baseEmotion;
        if (this.mListener == null) {
            LogUtils.e("didn't you forget to call setupWithEditText()???", new Object[0]);
        } else if (i < 20 && (baseEmotion = (BaseEmotion) ((EmotionAdapter) adapterView.getAdapter()).getItem(i)) != null && baseEmotion.getRealText() != null) {
            onNewEmotionPress(baseEmotion);
        }
    }

    private void onNewEmotionPress(BaseEmotion baseEmotion) {
        RECENT_EMOTION_CONTROL.addNewEmotion(baseEmotion);
        this.mListener.onEmotionClick(baseEmotion);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131363551 && view.getParent() == this.mBinding.emotionPanelBottom) {
            scrollToItem(this.mBinding.emotionPanelBottom.indexOfChild(view));
        }
    }

    public void scrollToItem(int i) {
        if (i < this.mEmotionItems.size()) {
            ScrollStateViewPager scrollStateViewPager = this.mBinding.emotionPanelViewPager;
            EmotionItem emotionItem = this.mEmotionItems.get(i);
            if (emotionItem != getEmotionItemByPage(scrollStateViewPager.getCurrentItem())) {
                int i2 = 0;
                for (EmotionItem emotionItem2 : this.mEmotionItems) {
                    if (emotionItem != emotionItem2) {
                        i2 += emotionItem2.getPageCount();
                    } else {
                        scrollStateViewPager.setCurrentItem(i2, false);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkBottom(int i) {
        EmotionItem emotionItemByPage = getEmotionItemByPage(i);
        for (EmotionItem emotionItem : this.mEmotionItems) {
            if (emotionItem != emotionItemByPage) {
                emotionItem.setViewSelected(false);
            }
        }
        emotionItemByPage.setViewSelected(true);
    }

    /* access modifiers changed from: private */
    public void checkIndicatorCount(int i) {
        LinearLayout linearLayout = this.mBinding.emotionPanelIndicator;
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            linearLayout.getChildAt(i2).setSelected(false);
        }
        int pageCount = getEmotionItemByPage(i).getPageCount();
        int childCount = linearLayout.getChildCount();
        if (childCount == pageCount) {
            linearLayout.getChildAt(getEmotionItemIndexByPage(i)).setSelected(true);
        } else if (pageCount < childCount) {
            while (true) {
                if (pageCount != linearLayout.getChildCount() || childCount < 1) {
                    linearLayout.removeView(linearLayout.getChildAt(childCount - 1));
                    childCount--;
                } else {
                    linearLayout.getChildAt(getEmotionItemIndexByPage(i)).setSelected(true);
                    return;
                }
            }
        } else {
            while (childCount < pageCount) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dp2px(getContext(), 10.0f), DisplayUtils.dp2px(getContext(), 10.0f));
                int dp2px = DisplayUtils.dp2px(getContext(), 3.0f);
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams);
                imageView.setPadding(dp2px, dp2px, dp2px, dp2px);
                imageView.setImageDrawable(ResourceUtils.getDrawable(getContext(), 2131231290));
                linearLayout.addView(imageView);
                childCount++;
            }
            linearLayout.getChildAt(getEmotionItemIndexByPage(i)).setSelected(true);
        }
    }

    /* access modifiers changed from: private */
    public void checkRecentEmoticon(int i) {
        GridView gridView;
        if (i == this.mRecentGridViewPage && (gridView = this.mRecentGridView) != null) {
            EmotionAdapter emotionAdapter = (EmotionAdapter) gridView.getAdapter();
            emotionAdapter.setNotifyOnChange(false);
            emotionAdapter.clear();
            emotionAdapter.setNotifyOnChange(true);
            emotionAdapter.addAll(createListByPageIndex(this.mRecentGridViewPage));
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RECENT_EMOTION_CONTROL.saveRecentEmotion();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            checkRecentEmoticon(this.mBinding.emotionPanelViewPager.getCurrentItem());
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            RECENT_EMOTION_CONTROL.saveRecentEmotion();
        }
    }

    public EmotionItem getEmotionItemByPage(int i) {
        for (EmotionItem emotionItem : this.mEmotionItems) {
            if (i < emotionItem.getPageCount()) {
                return emotionItem;
            }
            i -= emotionItem.getPageCount();
        }
        return null;
    }

    public int getEmotionItemIndexByPage(int i) {
        for (EmotionItem emotionItem : this.mEmotionItems) {
            if (i < emotionItem.getPageCount()) {
                return i;
            }
            i -= emotionItem.getPageCount();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public List<BaseEmotion> createListByPageIndex(int i) {
        for (EmotionItem emotionItem : this.mEmotionItems) {
            if (i < emotionItem.getPageCount()) {
                return emotionItem.getPageEmotionList(i);
            }
            i -= emotionItem.getPageCount();
        }
        return null;
    }

    private static class EmotionItem {
        private int mCount;
        private EmotionAlbum mEmotionAlbum;
        private TextView mItemView;
        private boolean mSelected;

        public EmotionItem(EmotionAlbum emotionAlbum) {
            this.mEmotionAlbum = emotionAlbum;
            int size = emotionAlbum.getEmotionList().size();
            int i = (size / 20) + (size % 20 == 0 ? 0 : 1);
            this.mCount = i;
            if (i == 0) {
                this.mCount = 1;
            }
        }

        public void setItemView(TextView textView) {
            this.mItemView = textView;
            if (textView != null) {
                textView.setText(this.mEmotionAlbum.getName());
            }
        }

        public void setViewSelected(boolean z) {
            int i;
            TextView textView = this.mItemView;
            if (textView != null && this.mSelected != z) {
                this.mSelected = z;
                textView.setSelected(z);
                AppTheme appTheme = AppHolder.getAppTheme();
                this.mItemView.setBackgroundColor(z ? appTheme.getColorAccent() : appTheme.getContentBackgroundColor());
                if (z) {
                    i = -1;
                } else {
                    i = appTheme.getTextColorPrimary();
                }
                this.mItemView.setTextColor(i);
            }
        }

        public int getPageCount() {
            return this.mCount;
        }

        public List<BaseEmotion> getPageEmotionList(int i) {
            if (i < this.mCount) {
                int size = this.mEmotionAlbum.getEmotionList().size();
                int i2 = i * 20;
                int i3 = (i + 1) * 20;
                if (i3 <= size) {
                    size = i3;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mEmotionAlbum.getEmotionList().subList(i2, size));
                while (arrayList.size() < 20) {
                    arrayList.add(EmotionPanel.EMPTY_EMOTION);
                }
                arrayList.add(EmotionPanel.DELETE_EMOTION);
                return arrayList;
            }
            LogUtils.e("wrong position", new Object[0]);
            return null;
        }
    }

    private class IndicatorPageListener extends ViewPager.SimpleOnPageChangeListener {
        private IndicatorPageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            EmotionPanel.this.checkBottom(i);
            EmotionPanel.this.checkIndicatorCount(i);
            EmotionPanel.this.checkRecentEmoticon(i);
        }
    }

    private class GridViewPageAdapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private GridViewPageAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            int i = 0;
            for (EmotionItem emotionItem : EmotionPanel.this.mEmotionItems) {
                i += emotionItem.getPageCount();
            }
            return i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            int dp2px = DisplayUtils.dp2px(EmotionPanel.this.getContext(), 4.0f);
            int dp2px2 = DisplayUtils.dp2px(EmotionPanel.this.getContext(), 4.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundDividerColor()));
            float dp2px3 = (float) ConvertUtils.dp2px(4.0f);
            gradientDrawable.setCornerRadii(new float[]{dp2px3, dp2px3, dp2px3, dp2px3, dp2px3, dp2px3, dp2px3, dp2px3});
            GridView gridView = new GridView(EmotionPanel.this.getContext());
            gridView.setNumColumns(7);
            gridView.setGravity(17);
            gridView.setVerticalSpacing(dp2px);
            gridView.setHorizontalSpacing(dp2px2);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[0], null);
            gridView.setSelector(stateListDrawable);
            EmotionPanel emotionPanel = EmotionPanel.this;
            gridView.setAdapter((ListAdapter) new EmotionAdapter(emotionPanel.getContext(), EmotionPanel.this.createListByPageIndex(i)));
            gridView.setOnItemClickListener(EmotionPanel.this);
            if (i == EmotionPanel.this.mRecentGridViewPage) {
                EmotionPanel.this.mRecentGridView = gridView;
            }
            viewGroup.addView(gridView);
            return gridView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i == EmotionPanel.this.mRecentGridViewPage) {
                EmotionPanel.this.mRecentGridView = null;
            }
            viewGroup.removeView((View) obj);
        }
    }

    private class EmotionAdapter extends ArrayAdapter<BaseEmotion> {
        private int width = DisplayUtils.dp2px(getContext(), 48.0f);

        public EmotionAdapter(Context context, List<BaseEmotion> list) {
            super(context, 0, 0, list);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            char c;
            BaseEmotion baseEmotion = (BaseEmotion) getItem(i);
            String entityType = baseEmotion.getEntityType();
            switch (entityType.hashCode()) {
                case -43880290:
                    if (entityType.equals("DRAWABLE")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 2592:
                    if (entityType.equals("QQ")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 67868:
                    if (entityType.equals("DOG")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 64307737:
                    if (entityType.equals("COOLB")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 66095142:
                    if (entityType.equals("EMOJI")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 66096429:
                    if (entityType.equals("EMPTY")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 79818927:
                    if (entityType.equals("TIEBA")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1670194707:
                    if (entityType.equals("COOLAPK")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                ImageView imageViewOrThrow = getImageViewOrThrow(view);
                Drawable drawable = baseEmotion.getDrawable(getContext());
                imageViewOrThrow.setContentDescription(baseEmotion.getText());
                imageViewOrThrow.setImageDrawable(drawable);
                if (i == 20) {
                    imageViewOrThrow.setOnTouchListener(EmotionPanel.this.mRepeatListener);
                } else if (drawable == null) {
                    imageViewOrThrow.setOnTouchListener(EmotionPanel.BLOCK_ALL_LISTENER);
                } else {
                    imageViewOrThrow.setOnTouchListener(null);
                }
                return imageViewOrThrow;
            }
            TextView textViewOrThrow = getTextViewOrThrow(view);
            textViewOrThrow.setText(baseEmotion.getRealText());
            return textViewOrThrow;
        }

        private ImageView getImageViewOrThrow(View view) {
            if (view instanceof ImageView) {
                return (ImageView) view;
            }
            int dp2px = DisplayUtils.dp2px(getContext(), 10.0f);
            ImageView imageView = new ImageView(getContext());
            int i = this.width;
            imageView.setLayoutParams(new AbsListView.LayoutParams(i, i));
            imageView.setPadding(dp2px, dp2px, dp2px, dp2px);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return imageView;
        }

        private TextView getTextViewOrThrow(View view) {
            if (view instanceof TextView) {
                return (TextView) view;
            }
            TextView textView = new TextView(getContext());
            int i = this.width;
            textView.setLayoutParams(new AbsListView.LayoutParams(i, i));
            textView.setTextSize(22.0f);
            textView.setGravity(17);
            textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            return textView;
        }
    }

    public static class EmotionToEditTextListener implements EmotionPanelListener {
        private EditText editText;

        public EmotionToEditTextListener(EditText editText2) {
            this.editText = editText2;
        }

        @Override // com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
        public void onEmotionClick(BaseEmotion baseEmotion) {
            ViewExtendsKt.insertText(this.editText, baseEmotion.getRealText());
        }

        @Override // com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
        public void onDeleteButtonClick() {
            ViewExtendsKt.insertBackKey(this.editText);
        }
    }

    private static class RepeatListener implements View.OnTouchListener {
        private final View.OnClickListener clickListener;
        private View downView;
        private Handler handler = new Handler();
        private Runnable handlerRunnable = new Runnable() {
            /* class com.coolapk.market.widget.emotion.EmotionPanel.RepeatListener.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (RepeatListener.this.downView != null) {
                    RepeatListener.this.handler.removeCallbacksAndMessages(RepeatListener.this.downView);
                    RepeatListener.this.handler.postAtTime(this, RepeatListener.this.downView, SystemClock.uptimeMillis() + ((long) RepeatListener.this.normalInterval));
                    RepeatListener.this.clickListener.onClick(RepeatListener.this.downView);
                }
            }
        };
        private int initialInterval;
        private final int normalInterval;

        public RepeatListener(int i, int i2, View.OnClickListener onClickListener) {
            if (onClickListener == null) {
                throw new IllegalArgumentException("null runnable");
            } else if (i < 0 || i2 < 0) {
                throw new IllegalArgumentException("negative interval");
            } else {
                this.initialInterval = i;
                this.normalInterval = i2;
                this.clickListener = onClickListener;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.clickListener.onClick(view);
                } else if (!(action == 3 || action == 4)) {
                    return false;
                }
                this.handler.removeCallbacksAndMessages(this.downView);
                this.downView = null;
                return true;
            }
            this.downView = view;
            this.handler.removeCallbacks(this.handlerRunnable);
            this.handler.postAtTime(this.handlerRunnable, this.downView, SystemClock.uptimeMillis() + ((long) this.initialInterval));
            return true;
        }
    }

    private static class RecentEmotionControl {
        private List<BaseEmotion> sRecentEmotions;

        private RecentEmotionControl() {
        }

        public List<BaseEmotion> getList() {
            if (this.sRecentEmotions == null) {
                String preferencesString = DataManager.getInstance().getPreferencesString("recent_emotion_v8", null);
                this.sRecentEmotions = new ArrayList();
                if (!TextUtils.isEmpty(preferencesString)) {
                    try {
                        List<BaseEmotion> loadFromJson = loadFromJson(preferencesString);
                        int size = loadFromJson.size();
                        if (loadFromJson.size() > 20) {
                            size = 20;
                        }
                        this.sRecentEmotions.addAll(loadFromJson.subList(0, size));
                    } catch (Exception e) {
                        DataManager.getInstance().getPreferencesEditor().remove("recent_emotion_v8").apply();
                        e.printStackTrace();
                    }
                }
            }
            return this.sRecentEmotions;
        }

        private List<BaseEmotion> loadFromJson(String str) throws JSONException {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            Map<String, BaseEmotion> emotionMapForPanel = EmotionUtils.getEmotionMapForPanel();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("entityType");
                BaseEmotion baseEmotion = null;
                string.hashCode();
                char c = 65535;
                switch (string.hashCode()) {
                    case 2592:
                        if (string.equals("QQ")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 67868:
                        if (string.equals("DOG")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 64307737:
                        if (string.equals("COOLB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 66095142:
                        if (string.equals("EMOJI")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 79818927:
                        if (string.equals("TIEBA")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1670194707:
                        if (string.equals("COOLAPK")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        baseEmotion = emotionMapForPanel.get(new Emotions.QQEmotion(Integer.valueOf(jSONObject.getInt("resId")), jSONObject.getString("text")).getRealText());
                        break;
                    case 1:
                        baseEmotion = emotionMapForPanel.get(new Emotions.DogEmotion(Integer.valueOf(jSONObject.getInt("resId")), jSONObject.getString("text")).getRealText());
                        break;
                    case 2:
                        baseEmotion = emotionMapForPanel.get(new Emotions.CoolBEmotion(Integer.valueOf(jSONObject.getInt("resId")), jSONObject.getString("text")).getRealText());
                        break;
                    case 3:
                        baseEmotion = new Emotions.EmojiEmotion(jSONObject.getString("text"));
                        break;
                    case 4:
                        baseEmotion = emotionMapForPanel.get(new Emotions.TiebaEmotion(Integer.valueOf(jSONObject.getInt("resId")), jSONObject.getString("text")).getRealText());
                        break;
                    case 5:
                        baseEmotion = emotionMapForPanel.get(new Emotions.CoolapkEmotion(Integer.valueOf(jSONObject.getInt("resId")), jSONObject.getString("text")).getRealText());
                        break;
                }
                if (baseEmotion != null) {
                    arrayList.add(baseEmotion);
                }
            }
            arrayList.addAll(removeDuplicateWithOrder(arrayList));
            return arrayList;
        }

        private List<BaseEmotion> removeDuplicateWithOrder(List<BaseEmotion> list) {
            ArrayList arrayList = new ArrayList();
            for (BaseEmotion baseEmotion : list) {
                if (!arrayList.contains(baseEmotion)) {
                    arrayList.add(baseEmotion);
                }
            }
            list.clear();
            return arrayList;
        }

        /* access modifiers changed from: private */
        public void saveRecentEmotion() {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.sRecentEmotions.size(); i++) {
                    jSONArray.put(this.sRecentEmotions.get(i).toJson());
                }
                for (BaseEmotion baseEmotion : this.sRecentEmotions) {
                }
                DataManager.getInstance().getPreferencesEditor().putString("recent_emotion_v8", jSONArray.toString()).apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private int getExistsEmotionIndex(BaseEmotion baseEmotion) {
            for (int i = 0; i < this.sRecentEmotions.size(); i++) {
                if (TextUtils.equals(this.sRecentEmotions.get(i).getText(), baseEmotion.getText()) && TextUtils.equals(this.sRecentEmotions.get(i).getEntityType(), baseEmotion.getEntityType())) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: private */
        public void addNewEmotion(BaseEmotion baseEmotion) {
            if (this.sRecentEmotions != null) {
                int existsEmotionIndex = getExistsEmotionIndex(baseEmotion);
                if (existsEmotionIndex >= 0) {
                    this.sRecentEmotions.remove(existsEmotionIndex);
                    this.sRecentEmotions.add(0, baseEmotion);
                } else {
                    this.sRecentEmotions.add(0, baseEmotion);
                }
                while (this.sRecentEmotions.size() > 20) {
                    List<BaseEmotion> list = this.sRecentEmotions;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
