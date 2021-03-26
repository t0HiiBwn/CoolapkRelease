package com.coolapk.market.view.sharev8;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemShareAppBinding;
import com.coolapk.market.databinding.ShareListViewBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ItemModel;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.BottomDialogFragment;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ShareListFragment extends BottomDialogFragment {
    public static String EXTRA_ENTITY = "extra_entity";
    public static String EXTRA_SHARE_CONTENT = "extra_share_content";
    public static String EXTRA_SHARE_TITLE = "extra_share_title";
    public static String EXTRA_SHARE_URL = "extra_share_url";
    private static final String KEY_DATA = "DATA";
    private FragmentBindingComponent component;
    private String content;
    private final ObservableArrayList<ItemModel> dataList = new ObservableArrayList<>();
    private Entity entity;
    private boolean hasQQ;
    private boolean hasWECHAT;
    private boolean hasWEIBO;
    private boolean hasZHIHU;
    private ShareListViewBinding mBinding;
    private final String mQQActivityName = "com.tencent.mobileqq.activity.JumpActivity";
    private final String mQQName = "com.tencent.mobileqq";
    private RecyclerView mRecyclerView;
    private final String mWBName = "com.sina.weibo";
    private final String mWXName = "com.tencent.mm";
    private final String mWechatActivityName = "com.tencent.mm.ui.tools.ShareImgUI";
    private final String mWeiboActivityName = "com.sina.weibo.composerinde.ComposerDispatchActivity";
    private final String mZHName = "com.zhihu.android";
    private final String mZhihuActivityName = "com.zhihu.android.app.ui.activity.share.ShareToFeedActivity";
    private List<ResolveInfo> resolveInfos = new ArrayList();
    private String title;
    private String url;

    public static ShareListFragment newInstance(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_SHARE_TITLE, str);
        bundle.putString(EXTRA_SHARE_CONTENT, str2);
        bundle.putString(EXTRA_SHARE_URL, str3);
        ShareListFragment shareListFragment = new ShareListFragment();
        shareListFragment.setArguments(bundle);
        return shareListFragment;
    }

    public static ShareListFragment newInstance(Entity entity2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_ENTITY, entity2);
        ShareListFragment shareListFragment = new ShareListFragment();
        shareListFragment.setArguments(bundle);
        return shareListFragment;
    }

    @Override // com.coolapk.market.view.base.BottomDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
        this.content = getArguments().getString(EXTRA_SHARE_CONTENT);
        this.title = getArguments().getString(EXTRA_SHARE_TITLE);
        this.url = getArguments().getString(EXTRA_SHARE_URL);
        Entity entity2 = (Entity) getArguments().getParcelable(EXTRA_ENTITY);
        this.entity = entity2;
        if (entity2 != null) {
            ShareUtils.ShareInfo obtainShareInfo = ShareUtils.obtainShareInfo(entity2);
            this.content = obtainShareInfo.getContent();
            this.title = obtainShareInfo.getTitle();
            this.url = obtainShareInfo.getUrl();
        }
        if (TextUtils.isEmpty(this.url)) {
            this.url = StringUtils.getExtraUrl(getActivity(), this.content);
        }
        this.component = new FragmentBindingComponent(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ShareListViewBinding shareListViewBinding = (ShareListViewBinding) DataBindingUtil.inflate(layoutInflater, 2131559148, viewGroup, false, this.component);
        this.mBinding = shareListViewBinding;
        shareListViewBinding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.coolapk.market.view.sharev8.ShareListFragment.AnonymousClass1 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ShareListFragment.this.mBinding.getRoot().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ShareListFragment.this.mBinding.getRoot().setTranslationY((float) ShareListFragment.this.mBinding.getRoot().getHeight());
                ShareListFragment.this.mBinding.getRoot().animate().translationY(0.0f).start();
            }
        });
        return this.mBinding.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.mBinding.getRoot().animate().translationY((float) this.mBinding.getRoot().getHeight()).start();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
    }

    public ObservableArrayList<ItemModel> getDataList() {
        return this.dataList;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRecyclerView = this.mBinding.recyclerView;
        this.mRecyclerView.setAdapter(new DataAdapter());
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mRecyclerView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.mRecyclerView.setPadding(DisplayUtils.dp2px(getActivity(), 16.0f), 0, DisplayUtils.dp2px(getActivity(), 16.0f), DisplayUtils.dp2px(getActivity(), 16.0f));
        this.dataList.addAll(getItems());
        this.mBinding.dialogCancelView.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.sharev8.ShareListFragment.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareListFragment.this.dismiss();
            }
        });
    }

    private List<ItemModel> getItems() {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> shareApps = PackageUtils.getShareApps(getActivity());
        this.resolveInfos = shareApps;
        for (int size = shareApps.size() - 1; size >= 0; size--) {
            if (!TextUtils.equals(this.resolveInfos.get(size).activityInfo.name, "com.tencent.mobileqq.activity.JumpActivity") && !TextUtils.equals(this.resolveInfos.get(size).activityInfo.name, "com.tencent.mm.ui.tools.ShareImgUI") && !TextUtils.equals(this.resolveInfos.get(size).activityInfo.name, "com.sina.weibo.composerinde.ComposerDispatchActivity") && !TextUtils.equals(this.resolveInfos.get(size).activityInfo.name, "com.zhihu.android.app.ui.activity.share.ShareToFeedActivity")) {
                this.resolveInfos.remove(size);
            }
        }
        arrayList.add(ItemModel.newBuilder().title("酷安").content(this.content).packageName(AppHolder.getApplication().getPackageName()).activityName("com.coolapk.market.view.feedv8.ShareFeedV8Activity").targetUrl(this.url).build());
        Entity entity2 = this.entity;
        if (entity2 != null && EntityUtils.isFeedType(entity2.getEntityType())) {
            arrayList.add(ItemModel.newBuilder().title("酷安看看号").content("").targetUrl(this.url).packageName("").activityName("").build());
        }
        if (this.resolveInfos.size() == 0) {
            arrayList.add(ItemModel.newBuilder().title("复制链接").content(this.content).targetUrl(this.url).packageName("").activityName("").build());
            arrayList.add(ItemModel.newBuilder().title("更多").content(this.content).packageName("").targetUrl("").activityName("").build());
        } else {
            int i = 0;
            while (true) {
                if (i >= this.resolveInfos.size()) {
                    break;
                }
                arrayList.add(ItemModel.newBuilder().title(this.resolveInfos.get(i).loadLabel(getActivity().getPackageManager()).toString()).content(this.content).packageName(this.resolveInfos.get(i).activityInfo.packageName).activityName(this.resolveInfos.get(i).activityInfo.name).targetUrl(this.url).build());
                if (CollectionUtils.safeSize(arrayList) == 6 || i == this.resolveInfos.size() - 1) {
                    break;
                }
                i++;
            }
            arrayList.add(ItemModel.newBuilder().title("复制链接").content(this.content).targetUrl(this.url).packageName("").activityName("").build());
            arrayList.add(ItemModel.newBuilder().title("更多").content(this.content).packageName("").targetUrl("").activityName("").build());
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private class ItemModelViewHolder extends GenericBindHolder<ItemShareAppBinding, ItemModel> {
        public static final int LAYOUT_ID = 2131558934;

        public ItemModelViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        /* JADX WARN: Type inference failed for: r3v5, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v16, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v19, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v22, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v25, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v28, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v31, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v34, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r3v37, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARNING: Unknown variable types count: 9 */
        public void bindToContent(final ItemModel itemModel) {
            ((ItemShareAppBinding) getBinding()).setModel(itemModel);
            ((ItemShareAppBinding) getBinding()).executePendingBindings();
            ((ItemShareAppBinding) getBinding()).rootView.setOnClickListener(new View.OnClickListener() {
                /* class com.coolapk.market.view.sharev8.ShareListFragment.ItemModelViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(itemModel.getPackageName())) {
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setComponent(new ComponentName(itemModel.getPackageName(), itemModel.getActivityName()));
                        intent.setType("text/*");
                        intent.putExtra("android.intent.extra.TEXT", itemModel.getContent());
                        intent.setFlags(268435456);
                        ShareListFragment.this.getActivity().startActivity(intent);
                    } else if (TextUtils.equals(itemModel.getTitle(), "复制链接")) {
                        StringUtils.copyText(ShareListFragment.this.getActivity(), itemModel.getTargetUrl());
                        Toast.show(ShareListFragment.this.getActivity(), "链接已复制");
                    } else if (TextUtils.equals(itemModel.getTitle(), "酷安看看号")) {
                        ActionManager.startDyhIncludActivity(ShareListFragment.this.getActivity(), ShareListFragment.this.entity.getId());
                    } else {
                        ActionManager.shareTextBySystem(ShareListFragment.this.getActivity(), "分享到：", itemModel.getTitle(), itemModel.getContent());
                    }
                    ShareListFragment.this.dismiss();
                }
            });
            if (TextUtils.equals(itemModel.getTitle(), "更多")) {
                GlideApp.with(ShareListFragment.this).load((Integer) 2131231448).into(((ItemShareAppBinding) getBinding()).iconView);
            } else if (TextUtils.equals(itemModel.getTitle(), "复制链接")) {
                GlideApp.with(ShareListFragment.this).load((Integer) 2131231410).into(((ItemShareAppBinding) getBinding()).iconView);
            } else if (TextUtils.equals("酷安看看号", itemModel.getTitle())) {
                GlideApp.with(ShareListFragment.this).load((Integer) 2131231390).into(((ItemShareAppBinding) getBinding()).iconView);
            } else if (TextUtils.equals("酷安", itemModel.getTitle())) {
                GlideApp.with(ShareListFragment.this).load((Integer) 2131231242).into(((ItemShareAppBinding) getBinding()).iconView);
            } else if (TextUtils.equals("com.zhihu.android.app.ui.activity.share.ShareToFeedActivity", itemModel.getActivityName())) {
                GlideApp.with(ShareListFragment.this).load((Integer) 2131231695).into(((ItemShareAppBinding) getBinding()).iconView);
            } else if (TextUtils.equals("com.tencent.mm.ui.tools.ShareImgUI", itemModel.getActivityName())) {
                GlideApp.with(ShareListFragment.this).load((Integer) 2131231658).into(((ItemShareAppBinding) getBinding()).iconView);
            } else if (TextUtils.equals("com.tencent.mobileqq.activity.JumpActivity", itemModel.getActivityName())) {
                if (itemModel.getPackageName().contains("tim")) {
                    GlideApp.with(ShareListFragment.this).load((Integer) 2131231622).into(((ItemShareAppBinding) getBinding()).iconView);
                } else {
                    GlideApp.with(ShareListFragment.this).load((Integer) 2131231510).into(((ItemShareAppBinding) getBinding()).iconView);
                }
            } else if (TextUtils.equals("com.sina.weibo.composerinde.ComposerDispatchActivity", itemModel.getActivityName())) {
                GlideApp.with(ShareListFragment.this).load((Integer) 2131231661).into(((ItemShareAppBinding) getBinding()).iconView);
                ((ItemShareAppBinding) getBinding()).iconView.setBackgroundResource(2131231081);
                ((ItemShareAppBinding) getBinding()).iconView.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundDividerColor()));
            }
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558934;
        }

        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558934) {
                ShareListFragment shareListFragment = ShareListFragment.this;
                return new ItemModelViewHolder(inflate, shareListFragment.component, null);
            }
            throw new IllegalStateException("Unknown view type " + i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(ShareListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ShareListFragment.this.dataList.size();
        }
    }
}
