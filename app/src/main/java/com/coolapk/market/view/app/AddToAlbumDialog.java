package com.coolapk.market.view.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemAddToAlbumBinding;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.album.AlbumCreateDialog;
import com.coolapk.market.view.app.AddToAlbumDialogContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.MinimumWidthDialog;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.List;

public class AddToAlbumDialog extends MinimumWidthDialog implements AddToAlbumDialogContract.View {
    private TitleAdapter adapter;
    private AddToAlbumDialogContract.Presenter presenter;
    private RecyclerView recyclerView;
    private ServiceApp serviceApp;
    private String uid;

    public static AddToAlbumDialog newInstance(String str, ServiceApp serviceApp2) {
        Bundle bundle = new Bundle();
        bundle.putString("uid", str);
        bundle.putParcelable("serviceApp", serviceApp2);
        AddToAlbumDialog addToAlbumDialog = new AddToAlbumDialog();
        addToAlbumDialog.setArguments(bundle);
        return addToAlbumDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new AddToAlbumDialogPresenter(this);
        this.uid = getArguments().getString("uid");
        this.serviceApp = (ServiceApp) getArguments().getParcelable("serviceApp");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.recyclerView = new RecyclerView(getActivity());
        TitleAdapter titleAdapter = new TitleAdapter(new DataAdapter());
        this.adapter = titleAdapter;
        this.recyclerView.setAdapter(titleAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558924, 2131231052).create());
        this.recyclerView.getItemAnimator().setChangeDuration(0);
        this.recyclerView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        int dp2px = DisplayUtils.dp2px(getActivity(), 8.0f);
        this.recyclerView.setPadding(dp2px, dp2px, dp2px, dp2px);
        this.recyclerView.setClipToPadding(false);
        return new AlertDialog.Builder(getActivity()).setTitle(2131886109).setView(this.recyclerView).create();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.presenter.loadAlbumList(this.uid, 50);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SectionedAdapter.Section(0, 1, null));
        this.adapter.setSections(arrayList);
    }

    @Override // com.coolapk.market.view.app.AddToAlbumDialogContract.View
    public void onAlbumListLoadComplete(Result<List<Entity>> result, Throwable th) {
        if (th != null) {
            Toast.error(getActivity(), th);
        }
        this.recyclerView.getAdapter().notifyDataSetChanged();
    }

    private class TitleAdapter extends SectionedAdapter {
        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public TitleAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558575, viewGroup, false), new ItemActionHandler() {
                /* class com.coolapk.market.view.app.AddToAlbumDialog.TitleAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    AlbumItem.Builder newBuilder = AlbumItem.newBuilder();
                    newBuilder.setPackageName(AddToAlbumDialog.this.serviceApp.getPackageName()).setTitle(AddToAlbumDialog.this.serviceApp.getAppName()).setNote("").setUrl(AddToAlbumDialog.this.serviceApp.getApkUrl()).setLogoUrl(AddToAlbumDialog.this.serviceApp.getLogo()).setDisplayOrder(1).setVersionCode(AddToAlbumDialog.this.serviceApp.getVersionCode());
                    AlbumCreateDialog.newInstance(newBuilder.build()).show(AddToAlbumDialog.this.getChildFragmentManager(), (String) null);
                }
            });
        }
    }

    private static class HeaderViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558575;

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
        }

        public HeaderViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            view.setOnClickListener(this);
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private FragmentBindingComponent component;

        public DataAdapter() {
            this.component = new FragmentBindingComponent(AddToAlbumDialog.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558574, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.app.AddToAlbumDialog.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        AddToAlbumEditDialog.newInstance((Album) AddToAlbumDialog.this.presenter.getAlbumList().get(AddToAlbumDialog.this.adapter.sectionedPositionToPosition(viewHolder.getAdapterPosition())), AddToAlbumDialog.this.serviceApp, -1).show(AddToAlbumDialog.this.getChildFragmentManager(), (String) null);
                    }
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(AddToAlbumDialog.this.presenter.getAlbumList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(AddToAlbumDialog.this.presenter.getAlbumList());
        }
    }

    private static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558574;

        public DataViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            view.setOnClickListener(this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemAddToAlbumBinding itemAddToAlbumBinding = (ItemAddToAlbumBinding) getBinding();
            itemAddToAlbumBinding.setAlbum((Album) obj);
            itemAddToAlbumBinding.executePendingBindings();
        }
    }
}
