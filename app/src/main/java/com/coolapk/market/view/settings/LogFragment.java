package com.coolapk.market.view.settings;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.LogItemBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import rx.Observable;
import rx.Subscriber;

public class LogFragment extends NewAsyncListFragment<Cursor> {
    public static final String KEY_LOG_TAG = "LOG_TAG";
    private Cursor cursor;
    private String logTag;

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.logTag = getArguments().getString("LOG_TAG");
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886764), 0);
        setAdapter(new DataAdapter());
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(0, 2131231052).last(2131231052).create());
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setRefreshEnable(true);
        setLoadMoreEnable(false);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            MenuItemCompat.setShowAsAction(menu.add(0, 2131361891, 0, "清除"), 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131361891) {
            return super.onOptionsItemSelected(menuItem);
        }
        ConfirmDialog newInstance = ConfirmDialog.newInstance("清除log", "你确定要清除所有log吗？");
        newInstance.setOnOkRunnable(new Runnable() {
            /* class com.coolapk.market.view.settings.LogFragment.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                DataManager.getInstance().cleanLogs(LogFragment.this.logTag);
                LogFragment.this.reloadData();
            }
        });
        newInstance.show(getChildFragmentManager(), (String) null);
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Cursor cursor2 = this.cursor;
        if (cursor2 != null) {
            cursor2.close();
        }
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Cursor cursor2) {
        Cursor cursor3 = this.cursor;
        if (cursor3 != null) {
            cursor3.close();
        }
        this.cursor = cursor2;
        updateContentUI();
        getRecyclerView().getAdapter().notifyDataSetChanged();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<Cursor> onCreateRequest(boolean z, int i) {
        return Observable.create(new Observable.OnSubscribe<Cursor>() {
            /* class com.coolapk.market.view.settings.LogFragment.AnonymousClass2 */

            public void call(Subscriber<? super Cursor> subscriber) {
                try {
                    subscriber.onNext(DataManager.getInstance().getLogs(LogFragment.this.logTag));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        Cursor cursor2 = this.cursor;
        return cursor2 != null && cursor2.getCount() > 0;
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131559014, viewGroup, false), new ItemActionHandler() {
                /* class com.coolapk.market.view.settings.LogFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(LogFragment.this.cursor);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (LogFragment.this.cursor != null) {
                return LogFragment.this.cursor.getCount();
            }
            return 0;
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public DataViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Cursor cursor = (Cursor) obj;
            cursor.moveToPosition(getAdapterPosition());
            String string = cursor.getString(cursor.getColumnIndex("message"));
            String string2 = cursor.getString(cursor.getColumnIndex("error"));
            long j = cursor.getLong(cursor.getColumnIndex("created"));
            LogItemBinding logItemBinding = (LogItemBinding) getBinding();
            logItemBinding.setMessage(string);
            logItemBinding.setError(string2);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            logItemBinding.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(instance.getTime()));
            logItemBinding.executePendingBindings();
        }
    }
}
