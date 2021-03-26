package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: PromptDialogs */
public final class k {

    /* compiled from: PromptDialogs */
    public static class b extends a {
        public b() {
            super();
        }

        @Override // com.huawei.hms.update.ui.k.a, com.huawei.hms.update.ui.b
        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        @Override // com.huawei.hms.update.ui.k.a
        protected int h() {
            return ResourceLoaderUtil.getStringId("hms_check_failure");
        }
    }

    /* compiled from: PromptDialogs */
    public static class c extends a {
        public c() {
            super();
        }

        @Override // com.huawei.hms.update.ui.k.a, com.huawei.hms.update.ui.b
        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        @Override // com.huawei.hms.update.ui.k.a
        protected int h() {
            return ResourceLoaderUtil.getStringId("hms_download_failure");
        }
    }

    /* compiled from: PromptDialogs */
    public static class d extends a {
        public d() {
            super();
        }

        @Override // com.huawei.hms.update.ui.k.a, com.huawei.hms.update.ui.b
        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        @Override // com.huawei.hms.update.ui.k.a
        protected int h() {
            return ResourceLoaderUtil.getStringId("hms_download_no_space");
        }
    }

    /* compiled from: PromptDialogs */
    private static abstract class a extends b {
        protected abstract int h();

        private a() {
        }

        @Override // com.huawei.hms.update.ui.b
        public AlertDialog a() {
            AlertDialog.Builder builder = new AlertDialog.Builder(f(), g());
            builder.setMessage(h());
            builder.setPositiveButton(i(), new DialogInterface.OnClickListener() {
                /* class com.huawei.hms.update.ui.k.a.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.e();
                }
            });
            return builder.create();
        }

        protected int i() {
            return ResourceLoaderUtil.getStringId("hms_confirm");
        }
    }
}
