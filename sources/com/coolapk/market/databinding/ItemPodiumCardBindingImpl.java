package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.ServiceApp;
import com.google.android.flexbox.FlexboxLayout;
import java.util.List;

public class ItemPodiumCardBindingImpl extends ItemPodiumCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;
    private final FlexboxLayout mboundView1;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"item_podium_card_item", "item_podium_card_item", "item_podium_card_item"}, new int[]{2, 3, 4}, new int[]{2131558867, 2131558867, 2131558867});
    }

    public ItemPodiumCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemPodiumCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ItemPodiumCardItemBinding) objArr[3], (ItemPodiumCardItemBinding) objArr[2], (ItemPodiumCardItemBinding) objArr[4]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.championView);
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        FlexboxLayout flexboxLayout = (FlexboxLayout) objArr[1];
        this.mboundView1 = flexboxLayout;
        flexboxLayout.setTag(null);
        setContainedBinding(this.secondPlaceView);
        setContainedBinding(this.thirdPlaceView);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
        }
        this.secondPlaceView.invalidateAll();
        this.championView.invalidateAll();
        this.thirdPlaceView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.secondPlaceView.hasPendingBindings() && !this.championView.hasPendingBindings() && !this.thirdPlaceView.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (281 == i) {
            setTitles((List) obj);
        } else if (33 == i) {
            setApps((List) obj);
        } else if (236 == i) {
            setScores((List) obj);
        } else if (193 != i) {
            return false;
        } else {
            setLogos((List) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardBinding
    public void setTitles(List<String> list) {
        this.mTitles = list;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(281);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardBinding
    public void setApps(List<ServiceApp> list) {
        this.mApps = list;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardBinding
    public void setScores(List<String> list) {
        this.mScores = list;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(236);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardBinding
    public void setLogos(List<String> list) {
        this.mLogos = list;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(193);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.secondPlaceView.setLifecycleOwner(lifecycleOwner);
        this.championView.setLifecycleOwner(lifecycleOwner);
        this.thirdPlaceView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeChampionView((ItemPodiumCardItemBinding) obj, i2);
        }
        if (i == 1) {
            return onChangeSecondPlaceView((ItemPodiumCardItemBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeThirdPlaceView((ItemPodiumCardItemBinding) obj, i2);
    }

    private boolean onChangeChampionView(ItemPodiumCardItemBinding itemPodiumCardItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSecondPlaceView(ItemPodiumCardItemBinding itemPodiumCardItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeThirdPlaceView(ItemPodiumCardItemBinding itemPodiumCardItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        ServiceApp serviceApp;
        ServiceApp serviceApp2;
        ServiceApp serviceApp3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        List list = this.mTitles;
        List list2 = this.mApps;
        List list3 = this.mScores;
        List list4 = this.mLogos;
        int i = ((136 & j) > 0 ? 1 : ((136 & j) == 0 ? 0 : -1));
        if (i == 0 || list == null) {
            str3 = null;
            str2 = null;
            str = null;
        } else {
            str2 = (String) getFromList(list, 0);
            str = (String) getFromList(list, 1);
            str3 = (String) getFromList(list, 2);
        }
        int i2 = ((j & 144) > 0 ? 1 : ((j & 144) == 0 ? 0 : -1));
        if (i2 == 0 || list2 == null) {
            serviceApp3 = null;
            serviceApp2 = null;
            serviceApp = null;
        } else {
            serviceApp3 = (ServiceApp) getFromList(list2, 2);
            serviceApp2 = (ServiceApp) getFromList(list2, 0);
            serviceApp = (ServiceApp) getFromList(list2, 1);
        }
        int i3 = ((j & 160) > 0 ? 1 : ((j & 160) == 0 ? 0 : -1));
        if (i3 == 0 || list3 == null) {
            str6 = null;
            str5 = null;
            str4 = null;
        } else {
            str6 = (String) getFromList(list3, 0);
            str5 = (String) getFromList(list3, 2);
            str4 = (String) getFromList(list3, 1);
        }
        int i4 = ((j & 192) > 0 ? 1 : ((j & 192) == 0 ? 0 : -1));
        if (i4 == 0 || list4 == null) {
            str9 = null;
            str8 = null;
            str7 = null;
        } else {
            str9 = (String) getFromList(list4, 1);
            str8 = (String) getFromList(list4, 2);
            str7 = (String) getFromList(list4, 0);
        }
        if (i2 != 0) {
            this.championView.setApp(serviceApp2);
            this.secondPlaceView.setApp(serviceApp);
            this.thirdPlaceView.setApp(serviceApp3);
        }
        if (i4 != 0) {
            this.championView.setLogo(str7);
            this.secondPlaceView.setLogo(str9);
            this.thirdPlaceView.setLogo(str8);
        }
        if (i3 != 0) {
            this.championView.setScore(str6);
            this.secondPlaceView.setScore(str4);
            this.thirdPlaceView.setScore(str5);
        }
        if (i != 0) {
            this.championView.setTitle(str2);
            this.secondPlaceView.setTitle(str);
            this.thirdPlaceView.setTitle(str3);
        }
        executeBindingsOn(this.secondPlaceView);
        executeBindingsOn(this.championView);
        executeBindingsOn(this.thirdPlaceView);
    }
}
