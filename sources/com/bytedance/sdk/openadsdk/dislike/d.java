package com.bytedance.sdk.openadsdk.dislike;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TTDislikeDialog */
public class d extends TTDislikeDialogAbstract {
    private TextView a;
    private TTDislikeListView b;
    private b c;
    private View d;
    private TextView e;
    private l f;
    private a g;
    private boolean h = false;
    private String i;

    /* compiled from: TTDislikeDialog */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void a(boolean z);

        void b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getPersonalizationPromptIds() {
        return null;
    }

    public d(Context context, l lVar, String str) {
        super(context, ac.g(context, "tt_dislikeDialog_new"));
        this.f = lVar;
        this.i = str;
    }

    public void a(l lVar) {
        b bVar = this.c;
        if (bVar != null && lVar != null) {
            this.f = lVar;
            bVar.a(lVar.al());
            setMaterialMeta(this.f);
        }
    }

    public void a(String str) {
        if (str != null) {
            this.f.c(str);
            a(this.f);
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setMaterialMeta(this.f);
        a();
        c();
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        return ac.f(getContext(), "tt_dislike_dialog_layout2");
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return new int[]{ac.e(getContext(), "tt_filer_words_lv")};
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(ak.c(getContext(), 345.0f), -2);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        d();
    }

    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setDimAmount(0.34f);
            window.setAttributes(attributes);
        }
    }

    private void b() {
        setOnShowListener(new DialogInterface.OnShowListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.d.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (d.this.g != null) {
                    d.this.h = false;
                    d.this.g.a();
                }
                if (d.this.d.isShown()) {
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f, d.this.i, "ad_explation_show");
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.d.AnonymousClass2 */

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.g != null) {
                    d.this.g.a(d.this.h);
                }
            }
        });
        if (this.f.am() != null) {
            this.d.setVisibility(0);
            this.e.setText(this.f.am().getName());
            this.d.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.dislike.d.AnonymousClass3 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(d.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", d.this.f.am().getName());
                    intent.putExtra("url", d.this.f.am().getUrl());
                    intent.putExtra("tag", d.this.i);
                    intent.putExtra("meta", d.this.f.aF().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(d.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f, d.this.i, "ad_explation_click");
                }
            });
        }
        b bVar = new b(getLayoutInflater(), this.f.al());
        this.c = bVar;
        this.b.setAdapter((ListAdapter) bVar);
    }

    private void c() {
        this.d = findViewById(ac.e(getContext(), "tt_personalization_layout"));
        this.e = (TextView) findViewById(ac.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) findViewById(ac.e(getContext(), "tt_edit_suggestion"));
        this.a = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.d.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.g != null) {
                    d.this.h = true;
                    d.this.dismiss();
                    d.this.g.b();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(ac.e(getContext(), "tt_filer_words_lv"));
        this.b = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.d.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.g != null) {
                    try {
                        d.this.g.a(i, d.this.f.al().get(i));
                    } catch (Throwable unused) {
                    }
                }
                d.this.dismiss();
            }
        });
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    /* compiled from: TTDislikeDialog */
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

        public void a(List<FilterWord> list) {
            if (list != null && !list.isEmpty()) {
                this.c.clear();
                this.c.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* compiled from: TTDislikeDialog */
        private class a {
            TextView a;
            FlowLayout b;

            private a() {
            }
        }
    }

    /* compiled from: TTDislikeDialog */
    private class c implements View.OnClickListener {
        private FilterWord b;
        private int c;

        public c(FilterWord filterWord, int i) {
            this.b = filterWord;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.g.a(this.c, this.b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.b);
            com.bytedance.sdk.openadsdk.c.d.a(d.this.f, arrayList);
            d.this.dismiss();
        }
    }
}
