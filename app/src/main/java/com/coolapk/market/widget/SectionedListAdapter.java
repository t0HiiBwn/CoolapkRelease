package com.coolapk.market.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Comparator;

public class SectionedListAdapter extends BaseAdapter {
    private ListAdapter mBaseAdapter;
    private LayoutInflater mLayoutInflater;
    private int mSectionResourceId;
    private SparseArray<Section> mSections = new SparseArray<>();
    private boolean mValid = true;

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public static class Section {
        int firstPosition;
        int sectionedPosition;
        CharSequence title;

        public Section(int i, CharSequence charSequence) {
            this.firstPosition = i;
            this.title = charSequence;
        }

        public CharSequence getTitle() {
            return this.title;
        }
    }

    public SectionedListAdapter(Context context, int i, ListAdapter listAdapter) {
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mSectionResourceId = i;
        this.mBaseAdapter = listAdapter;
        listAdapter.registerDataSetObserver(new DataSetObserver() {
            /* class com.coolapk.market.widget.SectionedListAdapter.AnonymousClass1 */

            @Override // android.database.DataSetObserver
            public void onChanged() {
                SectionedListAdapter sectionedListAdapter = SectionedListAdapter.this;
                sectionedListAdapter.mValid = !sectionedListAdapter.mBaseAdapter.isEmpty();
                SectionedListAdapter.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                SectionedListAdapter.this.mValid = false;
                SectionedListAdapter.this.notifyDataSetInvalidated();
            }
        });
    }

    public void setSections(Section[] sectionArr) {
        this.mSections.clear();
        Arrays.sort(sectionArr, new Comparator<Section>() {
            /* class com.coolapk.market.widget.SectionedListAdapter.AnonymousClass2 */

            public int compare(Section section, Section section2) {
                if (section.firstPosition == section2.firstPosition) {
                    return 0;
                }
                return section.firstPosition < section2.firstPosition ? -1 : 1;
            }
        });
        int i = 0;
        for (Section section : sectionArr) {
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

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mValid) {
            return this.mBaseAdapter.getCount() + this.mSections.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (isSectionHeaderPosition(i)) {
            return this.mSections.get(i);
        }
        return this.mBaseAdapter.getItem(sectionedPositionToPosition(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (isSectionHeaderPosition(i)) {
            return (long) (Integer.MAX_VALUE - this.mSections.indexOfKey(i));
        }
        return this.mBaseAdapter.getItemId(sectionedPositionToPosition(i));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (isSectionHeaderPosition(i)) {
            return getViewTypeCount() - 1;
        }
        return this.mBaseAdapter.getItemViewType(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (isSectionHeaderPosition(i)) {
            return false;
        }
        return this.mBaseAdapter.isEnabled(sectionedPositionToPosition(i));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mBaseAdapter.getViewTypeCount() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mBaseAdapter.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mBaseAdapter.isEmpty();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!isSectionHeaderPosition(i)) {
            return this.mBaseAdapter.getView(sectionedPositionToPosition(i), view, viewGroup);
        }
        TextView textView = (TextView) view;
        if (textView == null) {
            textView = (TextView) this.mLayoutInflater.inflate(this.mSectionResourceId, viewGroup, false);
        }
        textView.setText(this.mSections.get(i).title);
        return textView;
    }
}
