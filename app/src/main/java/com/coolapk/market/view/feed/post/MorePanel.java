package com.coolapk.market.view.feed.post;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.databinding.ItemMoreActionBinding;
import com.coolapk.market.databinding.PostMorePanelBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

public class MorePanel extends FrameLayout implements View.OnClickListener, AdapterView.OnItemClickListener {
    private List<HolderItem> mActionItems;
    private PostMorePanelBinding mBinding;
    private Fragment mFragment;
    private LayoutInflater mLayoutInflater;

    public MorePanel(Context context) {
        super(context);
        init();
    }

    public MorePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mLayoutInflater = LayoutInflater.from(getContext());
        this.mActionItems = new ArrayList();
        if (isInEditMode()) {
            this.mLayoutInflater.inflate(2131559090, (ViewGroup) this, true);
            return;
        }
        PostMorePanelBinding postMorePanelBinding = (PostMorePanelBinding) DataBindingUtil.inflate(this.mLayoutInflater, 2131559090, this, true);
        this.mBinding = postMorePanelBinding;
        postMorePanelBinding.morePanelViewPager.setAdapter(new GridViewPageAdapter());
        this.mBinding.morePanelViewPager.addOnPageChangeListener(new IndicatorPageListener());
        this.mActionItems = createListByPageIndex();
        checkIndicatorCount(0);
    }

    /* access modifiers changed from: private */
    public void checkIndicatorCount(int i) {
        LinearLayout linearLayout = this.mBinding.morePanelIndicator;
        int i2 = 0;
        for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
            linearLayout.getChildAt(i3).setSelected(false);
        }
        if (this.mActionItems.size() % 8 != 0) {
            i2 = 1;
        }
        int size = (this.mActionItems.size() / 8) + i2;
        int childCount = linearLayout.getChildCount();
        if (childCount == size) {
            linearLayout.getChildAt(size).setSelected(true);
        } else if (size < childCount) {
            while (true) {
                if (size != linearLayout.getChildCount() || childCount < 1) {
                    linearLayout.removeView(linearLayout.getChildAt(childCount - 1));
                    childCount--;
                } else {
                    linearLayout.getChildAt(i).setSelected(true);
                    return;
                }
            }
        } else {
            while (childCount < size) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dp2px(getContext(), 10.0f), DisplayUtils.dp2px(getContext(), 10.0f));
                int dp2px = DisplayUtils.dp2px(getContext(), 3.0f);
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams);
                imageView.setPadding(dp2px, dp2px, dp2px, dp2px);
                imageView.setImageDrawable(ResourceUtils.getDrawable(getContext(), 2131231279));
                linearLayout.addView(imageView);
                childCount++;
            }
            linearLayout.getChildAt(i).setSelected(true);
        }
    }

    public void setupWithFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        onAction((HolderItem) ((EmotionAdapter) adapterView.getAdapter()).getItem(i));
    }

    private void onAction(HolderItem holderItem) {
        String string = holderItem.getString();
        string.hashCode();
        if (string.equals("应用")) {
            ActionManager.startPickAppActivity(this.mFragment, 1561);
        } else if (string.equals("话题")) {
            ActionManager.startPickTopicActivity(this.mFragment, 6666);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public List<HolderItem> createListByPageIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(HolderItem.newBuilder().entityType("more_action").string("话题").intValue(2131231495).value("#2196F3").build());
        arrayList.add(HolderItem.newBuilder().entityType("more_action").string("应用").intValue(2131231654).value("#4CAF50").build());
        return arrayList;
    }

    private class IndicatorPageListener extends ViewPager.SimpleOnPageChangeListener {
        private IndicatorPageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            MorePanel.this.checkIndicatorCount(i);
        }
    }

    private class GridViewPageAdapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private GridViewPageAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            DisplayUtils.dp2px(MorePanel.this.getContext(), 6.0f);
            int dp2px = DisplayUtils.dp2px(MorePanel.this.getContext(), 4.0f);
            int dp2px2 = DisplayUtils.dp2px(MorePanel.this.getContext(), 4.0f);
            GridView gridView = new GridView(MorePanel.this.getContext());
            gridView.setNumColumns(4);
            gridView.setGravity(17);
            gridView.setVerticalSpacing(dp2px);
            gridView.setHorizontalSpacing(dp2px2);
            MorePanel morePanel = MorePanel.this;
            gridView.setAdapter((ListAdapter) new EmotionAdapter(morePanel.getContext(), MorePanel.this.createListByPageIndex()));
            gridView.setOnItemClickListener(MorePanel.this);
            viewGroup.addView(gridView);
            return gridView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    private class EmotionAdapter extends ArrayAdapter<HolderItem> {
        private int width = DisplayUtils.dp2px(getContext(), 48.0f);

        public EmotionAdapter(Context context, List<HolderItem> list) {
            super(context, 0, 0, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            HolderItem holderItem = (HolderItem) getItem(i);
            ItemMoreActionBinding itemMoreActionBinding = (ItemMoreActionBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558831, null, true);
            itemMoreActionBinding.actionTitle.setText(holderItem.getString());
            itemMoreActionBinding.actionIcon.setImageResource(holderItem.getIntValue().intValue());
            itemMoreActionBinding.actionIcon.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(holderItem.getValue())));
            return itemMoreActionBinding.getRoot();
        }
    }
}
