package com.coolapk.market.view.file;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFileBinding;
import com.coolapk.market.databinding.ItemFileTitleBinding;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.view.file.FileContractor;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.decoration.VerticalItemDecoration;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileViewFragment extends RefreshRecyclerFragment implements FileContractor.View {
    public static final String EXTRA_DIRECTORY = "directory";
    private DataAdapter adapter;
    private final List<Object> dataList = new ArrayList();
    private String extDir;
    private FileContractor.Presenter presenter;

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onEmptyViewClick() {
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
    }

    public static FileViewFragment newInstance(String str) {
        FileViewFragment fileViewFragment = new FileViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("directory", str);
        fileViewFragment.setArguments(bundle);
        return fileViewFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        VerticalItemDecoration create = ItemDecorations.vertical(getActivity()).type(2131558744, 2131231052).type(2131558745, 2131231052).last(2131231052).create();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(create);
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        this.adapter = new DataAdapter();
        getRecyclerView().setAdapter(this.adapter);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886767), 0);
        String string = getArguments().getString("directory");
        if (string == null || !new File(string).exists()) {
            string = AppHolder.getAppSetting().getDownloadDir();
        }
        this.extDir = string;
        this.presenter.loadFileDir(string);
        ViewUtil.clickListener(((ToolbarActivity) getActivity()).getFab(), new View.OnClickListener() {
            /* class com.coolapk.market.view.file.FileViewFragment.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FileViewFragment.this.checkValidDirectory(new File(FileViewFragment.this.extDir));
            }
        });
    }

    /* access modifiers changed from: private */
    public void checkValidDirectory(File file) {
        if (!file.exists() || !file.isDirectory()) {
            Toast.show(getActivity(), 2131886542);
        } else if (!file.canRead() || !file.canWrite()) {
            Toast.show(getActivity(), 2131886545);
        } else {
            Intent intent = new Intent();
            intent.putExtra("directory", this.extDir);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ViewUtil.clickListener(((ToolbarActivity) getActivity()).getFab(), null);
    }

    public void setPresenter(FileContractor.Presenter presenter2) {
        this.presenter = presenter2;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return getDataList().size() == 0;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    public List<Object> getDataList() {
        return this.dataList;
    }

    @Override // com.coolapk.market.view.file.FileContractor.View
    public void onLoadSuccess(List<File> list) {
        this.dataList.clear();
        this.dataList.add(HolderItem.newBuilder().entityType("holder_title").build());
        this.dataList.addAll(list);
        this.adapter.notifyDataSetChanged();
        updateContentUI();
    }

    public void reloadContent() {
        this.presenter.loadFileDir(this.extDir);
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            switch (i) {
                case 2131558744:
                    return new FileViewHolder(inflate);
                case 2131558745:
                    return new TitleViewHolder(inflate, null);
                default:
                    throw new RuntimeException("unknown view type");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return FileViewFragment.this.getDataList().get(i) instanceof File ? 2131558744 : 2131558745;
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(FileViewFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return FileViewFragment.this.getDataList().size();
        }
    }

    private class FileViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558744;

        public FileViewHolder(View view) {
            super(view);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            final File file = (File) obj;
            ItemFileBinding itemFileBinding = (ItemFileBinding) getBinding();
            itemFileBinding.setFile(file);
            itemFileBinding.executePendingBindings();
            itemFileBinding.textView.setText(file.getName());
            ViewUtil.clickListener(itemFileBinding.getRoot(), new View.OnClickListener() {
                /* class com.coolapk.market.view.file.FileViewFragment.FileViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FileViewFragment.this.extDir = file.getAbsolutePath();
                    FileViewFragment.this.reloadContent();
                }
            });
        }
    }

    private class TitleViewHolder extends GenericBindHolder<ItemFileTitleBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558745;

        public TitleViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            TextView textView = ((ItemFileTitleBinding) getBinding()).textView;
            textView.setText(FileViewFragment.this.extDir);
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setSingleLine();
            boolean z = true;
            textView.setSelected(true);
            if (new File(FileViewFragment.this.extDir).getParent() == null) {
                z = false;
            }
            ((ItemFileTitleBinding) getBinding()).option1.setTextColor(z ? AppHolder.getAppTheme().getColorAccent() : -7829368);
            ViewUtil.clickListener(((ItemFileTitleBinding) getBinding()).option1, new View.OnClickListener() {
                /* class com.coolapk.market.view.file.FileViewFragment.TitleViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    File parentFile = new File(FileViewFragment.this.extDir).getParentFile();
                    if (parentFile != null) {
                        FileViewFragment.this.extDir = parentFile.getAbsolutePath();
                        FileViewFragment.this.reloadContent();
                        return;
                    }
                    Toast.show(FileViewFragment.this.getActivity(), 2131886811);
                }
            });
        }
    }
}
