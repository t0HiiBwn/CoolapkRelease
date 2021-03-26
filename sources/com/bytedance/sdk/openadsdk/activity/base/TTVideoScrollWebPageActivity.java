package com.bytedance.sdk.openadsdk.activity.base;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.TTScrollView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.u;

public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView h;

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(ac.e(getApplicationContext(), "tt_scroll_view"));
        this.h = tTScrollView;
        tTScrollView.setListener(new TTScrollView.a() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.TTScrollView.a
            public void a(boolean z) {
                try {
                    if (TTVideoScrollWebPageActivity.this.g == null) {
                        return;
                    }
                    if (TTVideoScrollWebPageActivity.this.g instanceof f) {
                        if (!z || TTVideoScrollWebPageActivity.this.g.w()) {
                            TTVideoScrollWebPageActivity.this.g.h();
                        } else {
                            ((f) TTVideoScrollWebPageActivity.this.g).g(false);
                        }
                    }
                } catch (Throwable th) {
                    u.c("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        if (this.g != null) {
            this.g.e(false);
        }
        if (this.f != null) {
            this.f.setVideoAdInteractionListener(new c.b() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity.AnonymousClass2 */

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void a(long j, long j2) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void d() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void e_() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void d_() {
                    if (TTVideoScrollWebPageActivity.this.h != null && !TTVideoScrollWebPageActivity.this.h.a()) {
                        u.b("TTVideoScrollWebPageActivity", "video start play but video is hidden so pause");
                        if (TTVideoScrollWebPageActivity.this.g != null) {
                            TTVideoScrollWebPageActivity.this.g.i();
                        }
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(ac.f(getApplicationContext(), "tt_activity_video_scroll_landingpage"));
    }
}
