package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import java.util.ArrayList;

public class TTDislikeListView extends ListView {
    private l a;
    private AdapterView.OnItemClickListener b;
    private AdapterView.OnItemClickListener c = new AdapterView.OnItemClickListener() {
        /* class com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
            FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
            if (!filterWord.hasSecondOptions()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                if (TTDislikeListView.this.a != null) {
                    d.a(TTDislikeListView.this.a, arrayList);
                }
                if (TTDislikeListView.this.b != null) {
                    TTDislikeListView.this.b.onItemClick(adapterView, view, i, j);
                }
            }
        }
    };

    public TTDislikeListView(Context context) {
        super(context);
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setMaterialMeta(l lVar) {
        this.a = lVar;
    }

    private void a() {
        super.setOnItemClickListener(this.c);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }
}
