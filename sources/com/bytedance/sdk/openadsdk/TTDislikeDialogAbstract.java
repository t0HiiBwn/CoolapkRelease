package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity;
import com.bytedance.sdk.openadsdk.utils.b;

public abstract class TTDislikeDialogAbstract extends Dialog {
    private View a;
    private l b;

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getPersonalizationPromptIds();

    public abstract int[] getTTDislikeListViewIds();

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        this.a = inflate;
        if (inflate != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.a;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            a();
            b();
            return;
        }
        throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
    }

    private void a() {
        if (!(this.b == null || this.a == null)) {
            int[] tTDislikeListViewIds = getTTDislikeListViewIds();
            if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
                throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
            }
            for (int i : tTDislikeListViewIds) {
                View findViewById = this.a.findViewById(i);
                if (findViewById == null) {
                    throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
                } else if (findViewById instanceof TTDislikeListView) {
                    ((TTDislikeListView) findViewById).setMaterialMeta(this.b);
                } else {
                    throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
                }
            }
        }
    }

    private void b() {
        int[] personalizationPromptIds;
        l lVar = this.b;
        if (!(lVar == null || this.a == null || lVar.am() == null || (personalizationPromptIds = getPersonalizationPromptIds()) == null || personalizationPromptIds.length == 0)) {
            for (int i : personalizationPromptIds) {
                View findViewById = this.a.findViewById(i);
                if (findViewById != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        /* class com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract.AnonymousClass1 */

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(TTDislikeDialogAbstract.this.getContext(), TTDislikeWebViewActivity.class));
                            intent.putExtra("title", TTDislikeDialogAbstract.this.b.am().getName());
                            intent.putExtra("url", TTDislikeDialogAbstract.this.b.am().getUrl());
                            b.a(TTDislikeDialogAbstract.this.getContext(), intent, null);
                        }
                    });
                }
            }
        }
    }

    public void setMaterialMeta(l lVar) {
        this.b = lVar;
        a();
        b();
    }
}
