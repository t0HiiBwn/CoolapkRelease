package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.Locale;

public class PlayableLoadingView extends FrameLayout {
    private ProgressBar a;
    private TextView b;
    private TextView c;

    public PlayableLoadingView(Context context) {
        super(context);
        a(context);
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(ac.f(context, "tt_playable_loading_layout"), (ViewGroup) this, true);
        this.a = (ProgressBar) findViewById(ac.e(context, "tt_playable_pb_view"));
        this.b = (TextView) findViewById(ac.e(context, "tt_playable_progress_tip"));
        this.c = (TextView) findViewById(ac.e(context, "tt_playable_play"));
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i)));
        }
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        setVisibility(0);
    }

    public TextView getPlayView() {
        return this.c;
    }
}
