package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: ConfirmDialogs */
public final class e {

    /* compiled from: ConfirmDialogs */
    public static class b extends a {
        public b() {
            super();
        }

        @Override // com.huawei.hms.update.ui.e.a, com.huawei.hms.update.ui.b
        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int h() {
            return ResourceLoaderUtil.getStringId("hms_update_nettype");
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int i() {
            return ResourceLoaderUtil.getStringId("hms_update_continue");
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int j() {
            return ResourceLoaderUtil.getStringId("hms_cancel");
        }
    }

    /* compiled from: ConfirmDialogs */
    public static class c extends a {
        public c() {
            super();
        }

        @Override // com.huawei.hms.update.ui.e.a, com.huawei.hms.update.ui.b
        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int h() {
            return ResourceLoaderUtil.getStringId("hms_download_retry");
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int i() {
            return ResourceLoaderUtil.getStringId("hms_retry");
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int j() {
            return ResourceLoaderUtil.getStringId("hms_cancel");
        }
    }

    /* compiled from: ConfirmDialogs */
    public static class d extends a {
        public d() {
            super();
        }

        @Override // com.huawei.hms.update.ui.e.a, com.huawei.hms.update.ui.b
        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int h() {
            return ResourceLoaderUtil.getStringId("hms_abort_message");
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int i() {
            return ResourceLoaderUtil.getStringId("hms_abort");
        }

        @Override // com.huawei.hms.update.ui.e.a
        protected int j() {
            return ResourceLoaderUtil.getStringId("hms_cancel");
        }
    }

    /* compiled from: ConfirmDialogs */
    private static abstract class a extends b {
        protected abstract int h();

        protected abstract int i();

        protected abstract int j();

        private a() {
        }

        @Override // com.huawei.hms.update.ui.b
        public AlertDialog a() {
            AlertDialog.Builder builder = new AlertDialog.Builder(f(), g());
            builder.setMessage(h());
            builder.setPositiveButton(i(), new DialogInterface.OnClickListener() {
                /* class com.huawei.hms.update.ui.e.a.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.e();
                }
            });
            builder.setNegativeButton(j(), new DialogInterface.OnClickListener() {
                /* class com.huawei.hms.update.ui.e.a.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.b();
                }
            });
            return builder.create();
        }
    }
}
