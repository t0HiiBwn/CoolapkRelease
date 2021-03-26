package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    protected ListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        AnonymousClass1 r0 = new AsyncListDiffer.ListListener<T>() {
            /* class androidx.recyclerview.widget.ListAdapter.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(List<T> list, List<T> list2) {
                ListAdapter.this.onCurrentListChanged(list, list2);
            }
        };
        this.mListener = r0;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(r0);
    }

    protected ListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        AnonymousClass1 r0 = new AsyncListDiffer.ListListener<T>() {
            /* class androidx.recyclerview.widget.ListAdapter.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(List<T> list, List<T> list2) {
                ListAdapter.this.onCurrentListChanged(list, list2);
            }
        };
        this.mListener = r0;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(r0);
    }

    public void submitList(List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    protected T getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }
}
