package com.coolapk.market.widget;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemMarketAppsBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.view.base.BottomDialogFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MultiMarketDialog extends BottomDialogFragment {
    private List<ResolveInfo> infoList = new ArrayList();
    private RecyclerView layoutView;
    private String packageName;

    public static MultiMarketDialog newInstance() {
        Bundle bundle = new Bundle();
        MultiMarketDialog multiMarketDialog = new MultiMarketDialog();
        multiMarketDialog.setArguments(bundle);
        return multiMarketDialog;
    }

    public void setData(List<ResolveInfo> list, String str) {
        this.infoList.addAll(list);
        this.packageName = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dp2px = DisplayUtils.dp2px(getActivity(), 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        float f = (float) dp2px;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
        RecyclerView recyclerView = new RecyclerView(getActivity());
        this.layoutView = recyclerView;
        recyclerView.setElevation((float) DisplayUtils.dp2px(getActivity(), 8.0f));
        this.layoutView.setBackground(gradientDrawable);
        this.layoutView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.layoutView.setPadding(0, DisplayUtils.dp2px(getActivity(), 8.0f), 0, DisplayUtils.dp2px(getActivity(), 8.0f));
        this.layoutView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.layoutView.setAdapter(new MarketAdapter(createItemModelList()));
        this.layoutView.setOverScrollMode(2);
        this.layoutView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.coolapk.market.widget.MultiMarketDialog.AnonymousClass1 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                MultiMarketDialog.this.layoutView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                MultiMarketDialog.this.layoutView.setTranslationY((float) MultiMarketDialog.this.layoutView.getHeight());
                MultiMarketDialog.this.layoutView.animate().translationY(0.0f).start();
            }
        });
        return this.layoutView;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.layoutView.animate().translationY((float) this.layoutView.getHeight()).start();
    }

    private List<ItemModel> createItemModelList() {
        PackageManager packageManager = getActivity().getPackageManager();
        final ArrayList arrayList = new ArrayList();
        arrayList.add("com.android.vending");
        arrayList.add("com.tencent.android.qqdownloader");
        arrayList.add("com.wandoujia.phoenix2");
        arrayList.add("com.yingyonghui.market");
        arrayList.add("com.apkpure.aegon");
        arrayList.add("com.xiaomi.market");
        arrayList.add("com.taptap");
        arrayList.add("cn.com.shouji.market");
        arrayList.add("com.qihoo.appstore");
        arrayList.add("com.baidu.appsearch");
        arrayList.add("com.diguayouxi");
        arrayList.add("com.netease.apper");
        arrayList.add("com.pp.assistant");
        ArrayList<ResolveInfo> arrayList2 = new ArrayList(this.infoList);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            String str = ((ResolveInfo) it2.next()).activityInfo.packageName;
            if (str.equals(getActivity().getPackageName()) || str.equals("com.android.vending") || str.equals("com.tencent.android.qqdownloader") || str.equals("com.wandoujia.phoenix2") || str.equals("com.yingyonghui.market")) {
                it2.remove();
            }
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(createMarketModel(this.packageName));
        if (arrayList2.size() <= 6 - arrayList3.size()) {
            for (ResolveInfo resolveInfo : arrayList2) {
                arrayList3.add(ItemModel.create(packageManager, resolveInfo));
            }
            Collections.sort(arrayList3, new Comparator<ItemModel>() {
                /* class com.coolapk.market.widget.MultiMarketDialog.AnonymousClass2 */

                public int compare(ItemModel itemModel, ItemModel itemModel2) {
                    int indexOf = arrayList.indexOf(itemModel.getPackageName());
                    int indexOf2 = arrayList.indexOf(itemModel2.getPackageName());
                    return (indexOf < 0 || indexOf2 < 0 || indexOf > indexOf2) ? 1 : -1;
                }
            });
        } else {
            int i = 0;
            while (i < arrayList2.size() && arrayList3.size() < 5) {
                ResolveInfo resolveInfo2 = (ResolveInfo) arrayList2.get(i);
                if (arrayList.contains(resolveInfo2.activityInfo.packageName)) {
                    arrayList3.add(ItemModel.create(packageManager, resolveInfo2));
                    arrayList2.remove(i);
                    i--;
                }
                i++;
            }
            Collections.sort(arrayList3, new Comparator<ItemModel>() {
                /* class com.coolapk.market.widget.MultiMarketDialog.AnonymousClass3 */

                public int compare(ItemModel itemModel, ItemModel itemModel2) {
                    int indexOf = arrayList.indexOf(itemModel.getPackageName());
                    int indexOf2 = arrayList.indexOf(itemModel2.getPackageName());
                    return (indexOf < 0 || indexOf2 < 0 || indexOf > indexOf2) ? 1 : -1;
                }
            });
            if (arrayList3.size() < 5) {
                while (arrayList3.size() < 5) {
                    arrayList3.add(ItemModel.create(getActivity().getPackageManager(), (ResolveInfo) arrayList2.get(0)));
                    arrayList2.remove(0);
                }
            }
            arrayList3.add(ItemModel.create(getActivity().getString(2131886875), ShapeUtils.createCircleShapeIcon(ResourceUtils.getDrawable(getActivity(), 2131231435))));
        }
        return arrayList3;
    }

    public static class ItemModel {
        public Drawable icon;
        public String logoUrl;
        public String packageName;
        public String targetUrl;
        public String title;

        /* access modifiers changed from: private */
        public static ItemModel create(PackageManager packageManager, ResolveInfo resolveInfo) {
            ItemModel itemModel = new ItemModel();
            itemModel.icon = resolveInfo.loadIcon(packageManager);
            itemModel.title = resolveInfo.loadLabel(packageManager).toString();
            itemModel.packageName = resolveInfo.activityInfo.packageName;
            return itemModel;
        }

        /* access modifiers changed from: private */
        public static ItemModel create(String str, Drawable drawable) {
            ItemModel itemModel = new ItemModel();
            itemModel.icon = drawable;
            itemModel.title = str;
            itemModel.packageName = null;
            return itemModel;
        }

        /* access modifiers changed from: private */
        public static ItemModel create(String str, String str2, String str3, String str4) {
            ItemModel itemModel = new ItemModel();
            itemModel.logoUrl = str3;
            itemModel.title = str;
            itemModel.packageName = str2;
            itemModel.targetUrl = str4;
            return itemModel;
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public String getTitle() {
            return this.title;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getLogoUrl() {
            return this.logoUrl;
        }
    }

    private static class MarketViewHolder extends BindingViewHolder {
        MarketViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemModel itemModel = (ItemModel) obj;
            ItemMarketAppsBinding itemMarketAppsBinding = (ItemMarketAppsBinding) getBinding();
            itemMarketAppsBinding.setClick(this);
            if (itemModel.icon != null) {
                GlideApp.with(itemMarketAppsBinding.iconView).clear(itemMarketAppsBinding.iconView);
                itemMarketAppsBinding.iconView.setImageDrawable(itemModel.icon);
            } else {
                AppHolder.getContextImageLoader().displayImage(getContext(), itemModel.logoUrl, itemMarketAppsBinding.iconView, 2131231363);
            }
            itemMarketAppsBinding.titleView.setText(itemModel.title);
        }
    }

    private class MarketAdapter extends RecyclerView.Adapter<MarketViewHolder> {
        private List<ItemModel> itemModels;

        MarketAdapter(List<ItemModel> list) {
            this.itemModels = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MarketViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MarketViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558822, viewGroup, false), new ItemActionHandler() {
                /* class com.coolapk.market.widget.MultiMarketDialog.MarketAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    if (viewHolder.getAdapterPosition() >= 0) {
                        ItemModel itemModel = (ItemModel) MarketAdapter.this.itemModels.get(viewHolder.getAdapterPosition());
                        if (itemModel.packageName != null) {
                            ResolveInfo resolveInfoFromList = MultiMarketDialog.this.getResolveInfoFromList(itemModel.packageName);
                            if (resolveInfoFromList != null) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MultiMarketDialog.this.packageName));
                                intent.setComponent(new ComponentName(resolveInfoFromList.activityInfo.packageName, resolveInfoFromList.activityInfo.name));
                                try {
                                    MultiMarketDialog.this.getActivity().startActivity(intent);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else if (itemModel.targetUrl != null) {
                                ActionManager.startMarketWebViewActivity(MultiMarketDialog.this.getActivity(), itemModel.targetUrl);
                            }
                        } else {
                            MultiMarketDialog.this.startActivity(Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MultiMarketDialog.this.packageName)), itemModel.title));
                        }
                    }
                    MultiMarketDialog.this.dismiss();
                }
            });
        }

        public void onBindViewHolder(MarketViewHolder marketViewHolder, int i) {
            marketViewHolder.bindTo(this.itemModels.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemModels.size();
        }
    }

    /* access modifiers changed from: private */
    public ResolveInfo getResolveInfoFromList(String str) {
        for (ResolveInfo resolveInfo : this.infoList) {
            if (str.equals(resolveInfo.activityInfo.packageName)) {
                return resolveInfo;
            }
        }
        return null;
    }

    public static List<ItemModel> createMarketModel(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ItemModel.create("Google Play", "com.android.vending", "http://image.coolapk.com/apk_logo/2016/0408/257251_1460047459_672.png", "https://play.google.com/store/apps/details?id=" + str));
        arrayList.add(ItemModel.create("应用宝", "com.tencent.android.qqdownloader", "http://image.coolapk.com/apk_logo/2017/0628/t010ecad23c672f0def-for-31336-o_1bjm7cs1l1h1m1bg71amefp344nq-uid-408649.png", "http://a.app.qq.com/o/simple.jsp?pkgname=" + str));
        arrayList.add(ItemModel.create("豌豆荚", "com.wandoujia.phoenix2", "http://image.coolapk.com/apk_logo/2017/0628/t012e5c1c093d9a687d-for-31759-o_1bjm7h2meoehj2g1t631ff6g1mq-uid-408649.png", "http://www.wandoujia.com/apps/" + str));
        arrayList.add(ItemModel.create("应用汇", "com.yingyonghui.market", "http://image.coolapk.com/apk_logo/2017/0628/t01ca7dd4f58e3762f2-for-31736-o_1bjm7fa8mda8vl1i8m84rr43q-uid-408649.png", "http://m.appchina.com/app/" + str));
        return arrayList;
    }
}
