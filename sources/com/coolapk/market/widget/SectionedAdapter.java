package com.coolapk.market.widget;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class SectionedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SparseArray<Section> mSections = new SparseArray<>();
    private RecyclerView.Adapter originalAdapter;
    private boolean valid = true;

    public abstract void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i);

    public abstract RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i);

    public SectionedAdapter(RecyclerView.Adapter adapter) {
        setHasStableIds(adapter.hasStableIds());
        this.originalAdapter = adapter;
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            /* class com.coolapk.market.widget.SectionedAdapter.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                SectionedAdapter sectionedAdapter = SectionedAdapter.this;
                sectionedAdapter.valid = sectionedAdapter.originalAdapter.getItemCount() > 0;
                SectionedAdapter.this.notifyDataSetChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                SectionedAdapter sectionedAdapter = SectionedAdapter.this;
                sectionedAdapter.valid = sectionedAdapter.originalAdapter.getItemCount() > 0;
                SectionedAdapter sectionedAdapter2 = SectionedAdapter.this;
                sectionedAdapter2.notifyItemRangeChanged(sectionedAdapter2.positionToSectionedPosition(i), i2);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                SectionedAdapter sectionedAdapter = SectionedAdapter.this;
                sectionedAdapter.valid = sectionedAdapter.originalAdapter.getItemCount() > 0;
                SectionedAdapter sectionedAdapter2 = SectionedAdapter.this;
                sectionedAdapter2.notifyItemRangeInserted(sectionedAdapter2.positionToSectionedPosition(i), i2);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                SectionedAdapter sectionedAdapter = SectionedAdapter.this;
                sectionedAdapter.valid = sectionedAdapter.originalAdapter.getItemCount() > 0;
                SectionedAdapter sectionedAdapter2 = SectionedAdapter.this;
                sectionedAdapter2.notifyItemRangeRemoved(sectionedAdapter2.positionToSectionedPosition(i), i2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (isSectionViewType(i)) {
            return onCreateSectionViewHolder(viewGroup, i);
        }
        return this.originalAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (isSectionHeaderPosition(i)) {
            onBindSectionViewHolder(viewHolder, i);
        } else {
            this.originalAdapter.onBindViewHolder(viewHolder, sectionedPositionToPosition(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Section section = getSection(i);
        if (section != null) {
            return section.itemType;
        }
        return this.originalAdapter.getItemViewType(sectionedPositionToPosition(i));
    }

    public static class Section {
        private int firstPosition;
        private int itemType;
        private Object object;
        private int sectionedPosition;

        public Section(int i, int i2, Object obj) {
            this.firstPosition = i;
            this.itemType = i2;
            this.object = obj;
        }

        public int getFirstPosition() {
            return this.firstPosition;
        }

        public int getSectionedPosition() {
            return this.sectionedPosition;
        }

        public int getItemType() {
            return this.itemType;
        }

        public Object getObject() {
            return this.object;
        }
    }

    public void setSections(List<Section> list) {
        this.mSections.clear();
        Collections.sort(list, new Comparator<Section>() {
            /* class com.coolapk.market.widget.SectionedAdapter.AnonymousClass2 */

            public int compare(Section section, Section section2) {
                if (section.firstPosition == section2.firstPosition) {
                    return 0;
                }
                return section.firstPosition < section2.firstPosition ? -1 : 1;
            }
        });
        int i = 0;
        for (Section section : list) {
            section.sectionedPosition = section.firstPosition + i;
            this.mSections.append(section.sectionedPosition, section);
            i++;
        }
        notifyDataSetChanged();
    }

    public int positionToSectionedPosition(int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mSections.size() && this.mSections.valueAt(i2).firstPosition <= i) {
            i3++;
            i2++;
        }
        return i + i3;
    }

    public int sectionedPositionToPosition(int i) {
        if (isSectionHeaderPosition(i)) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mSections.size() && this.mSections.valueAt(i2).sectionedPosition <= i) {
            i3--;
            i2++;
        }
        return i + i3;
    }

    public boolean isSectionHeaderPosition(int i) {
        return this.mSections.get(i) != null;
    }

    public boolean isSectionViewType(int i) {
        for (int i2 = 0; i2 < this.mSections.size(); i2++) {
            if (this.mSections.valueAt(i2).itemType == i) {
                return true;
            }
        }
        return false;
    }

    public Section getSection(int i) {
        return this.mSections.get(i);
    }

    public boolean hasSections() {
        return this.mSections.size() > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (isSectionHeaderPosition(i)) {
            return (long) (Integer.MAX_VALUE - this.mSections.indexOfKey(i));
        }
        return this.originalAdapter.getItemId(sectionedPositionToPosition(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.valid ? this.originalAdapter.getItemCount() + this.mSections.size() : this.mSections.size();
    }
}
