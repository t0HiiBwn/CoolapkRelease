package com.bytedance.sdk.openadsdk.dislike;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.ArrayList;
import java.util.List;

public class LandingDislikeDialog extends FrameLayout {
    private View a;
    private TextView b;
    private TTDislikeListView c;
    private b d;
    private View e;
    private TextView f;
    private l g;
    private a h;
    private boolean i;
    private String j;

    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);
    }

    public LandingDislikeDialog(Context context, l lVar, String str) {
        this(context);
        this.g = lVar;
        this.j = str;
        b();
    }

    public LandingDislikeDialog(Context context) {
        this(context, null);
    }

    public LandingDislikeDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LandingDislikeDialog(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingDislikeDialog.this.a(true);
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.a = LayoutInflater.from(context).inflate(ac.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = ak.c(getContext(), 345.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClickable(true);
        c();
        b();
    }

    private void b() {
        if (this.g != null) {
            b bVar = new b(LayoutInflater.from(getContext()), this.g.al());
            this.d = bVar;
            this.c.setAdapter((ListAdapter) bVar);
            this.c.setMaterialMeta(this.g);
            if (this.g.am() != null) {
                this.e.setVisibility(0);
                this.f.setText(this.g.am().getName());
                this.e.setOnClickListener(new View.OnClickListener() {
                    /* class com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.AnonymousClass2 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(LandingDislikeDialog.this.getContext(), TTDislikeWebViewActivity.class));
                        intent.putExtra("title", LandingDislikeDialog.this.g.am().getName());
                        intent.putExtra("url", LandingDislikeDialog.this.g.am().getUrl());
                        intent.putExtra("tag", LandingDislikeDialog.this.j);
                        intent.putExtra("meta", LandingDislikeDialog.this.g.aF().toString());
                        com.bytedance.sdk.openadsdk.utils.b.a(LandingDislikeDialog.this.getContext(), intent, null);
                        d.b(LandingDislikeDialog.this.getContext(), LandingDislikeDialog.this.g, LandingDislikeDialog.this.j, "ad_explation_click");
                    }
                });
            }
        }
    }

    private void c() {
        this.e = this.a.findViewById(ac.e(getContext(), "tt_personalization_layout"));
        this.f = (TextView) this.a.findViewById(ac.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) this.a.findViewById(ac.e(getContext(), "tt_edit_suggestion"));
        this.b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandingDislikeDialog.this.h != null) {
                    LandingDislikeDialog.this.a(false);
                    LandingDislikeDialog.this.h.a();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.a.findViewById(ac.e(getContext(), "tt_filer_words_lv"));
        this.c = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (LandingDislikeDialog.this.h != null) {
                    try {
                        LandingDislikeDialog.this.h.a(i, LandingDislikeDialog.this.g.al().get(i));
                    } catch (Throwable unused) {
                    }
                }
                LandingDislikeDialog.this.a(true);
            }
        });
    }

    public void a() {
        if (this.a.getParent() == null) {
            addView(this.a);
        }
        if (this.e.isShown()) {
            d.b(getContext(), this.g, this.j, "ad_explation_show");
        }
        d();
        setVisibility(0);
        this.i = true;
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.i = false;
        a aVar = this.h;
        if (aVar != null && z) {
            aVar.b(this);
        }
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.c;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.h = aVar;
    }

    public class b extends BaseAdapter {
        private boolean b = true;
        private final List<FilterWord> c;
        private final LayoutInflater d;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.c = list;
            this.d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.c.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            if (view == null) {
                aVar = new a();
                LayoutInflater layoutInflater = this.d;
                view2 = layoutInflater.inflate(ac.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.a = (TextView) view2.findViewById(ac.e(this.d.getContext(), "tt_item_tv"));
                aVar.b = (FlowLayout) view2.findViewById(ac.e(this.d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.c.get(i);
            aVar.a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i != this.c.size() - 1) {
                    aVar.a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.b && i == 0) {
                aVar.a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.b.removeAllViews();
                for (int i2 = 0; i2 < filterWord.getOptions().size(); i2++) {
                    LayoutInflater layoutInflater2 = this.d;
                    TextView textView = (TextView) layoutInflater2.inflate(ac.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.b, false);
                    textView.setText(filterWord.getOptions().get(i2).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i2), i2));
                    aVar.b.addView(textView);
                }
                aVar.b.setVisibility(0);
            } else {
                aVar.b.setVisibility(8);
            }
            return view2;
        }

        private class a {
            TextView a;
            FlowLayout b;

            private a() {
            }
        }
    }

    private class c implements View.OnClickListener {
        private FilterWord b;
        private int c;

        public c(FilterWord filterWord, int i) {
            this.b = filterWord;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LandingDislikeDialog.this.h.a(this.c, this.b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.b);
            d.a(LandingDislikeDialog.this.g, arrayList);
            LandingDislikeDialog.this.a(true);
        }
    }
}
