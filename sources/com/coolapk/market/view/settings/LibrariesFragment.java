package com.coolapk.market.view.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemLibraryShowBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Library;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.view.settings.LibrariesFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;

public class LibrariesFragment extends LocalDataFragment<Library> {
    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        return 2131558799;
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LibraryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), null);
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        getDataList().addAll(DataManager.getInstance().getProjectLibraries());
    }

    public class LibraryViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558799;

        public LibraryViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemLibraryShowBinding itemLibraryShowBinding = (ItemLibraryShowBinding) getBinding();
            itemLibraryShowBinding.setModel((Library) obj);
            itemLibraryShowBinding.cardView.setOnClickListener(new View.OnClickListener(obj) {
                /* class com.coolapk.market.view.settings.$$Lambda$LibrariesFragment$LibraryViewHolder$ofEc12E4bWVgaEG3aCkr3IiWdw */
                public final /* synthetic */ Object f$1;

                {
                    this.f$1 = r2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibrariesFragment.LibraryViewHolder.this.lambda$bindTo$0$LibrariesFragment$LibraryViewHolder(this.f$1, view);
                }
            });
            itemLibraryShowBinding.executePendingBindings();
        }

        public /* synthetic */ void lambda$bindTo$0$LibrariesFragment$LibraryViewHolder(Object obj, View view) {
            ActionManager.startActivityByUrl(LibrariesFragment.this.getActivity(), ((Library) obj).getUrl());
        }
    }
}
