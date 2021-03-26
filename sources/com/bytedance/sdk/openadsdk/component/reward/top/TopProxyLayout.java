package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.u;

public class TopProxyLayout extends View implements a<TopProxyLayout> {
    private a a;

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public TopProxyLayout(Context context) {
        this(context, null);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    public TopProxyLayout a(boolean z, l lVar) {
        TopLayoutDislike2 a2 = new TopLayoutDislike2(getContext()).a(z, lVar);
        if (a2 instanceof a) {
            this.a = a2;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                a(a2, (ViewGroup) parent);
            }
            return this;
        }
        u.f("TopProxyLayout", "view not implements ITopLayout interface");
        return this;
    }

    private void a(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowSkip(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setSkipEnable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowSound(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowCountDown(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(charSequence, charSequence2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowDislike(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setListener(bVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }
}
