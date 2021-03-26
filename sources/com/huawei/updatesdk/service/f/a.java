package com.huawei.updatesdk.service.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.huawei.updatesdk.service.otaupdate.g;

public class a {
    private b a;
    private Context b;
    private String c;
    private CharSequence d;
    private AlertDialog e;
    private AlertDialog.Builder f;
    private DialogInterface.OnShowListener g;
    private DialogInterface.OnDismissListener h;

    /* renamed from: com.huawei.updatesdk.service.f.a$a  reason: collision with other inner class name */
    public enum EnumC0080a {
        CONFIRM,
        CANCEL
    }

    public interface b {
        void a();
    }

    protected a(Context context, String str, CharSequence charSequence) {
        this.b = context;
        this.c = str;
        this.d = charSequence;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        this.f = builder;
        builder.setTitle(this.c);
        this.f.setPositiveButton(g.b(context, "upsdk_third_app_dl_sure_cancel_download"), (DialogInterface.OnClickListener) null);
        this.f.setNegativeButton(g.b(context, "upsdk_cancel"), (DialogInterface.OnClickListener) null);
        this.f.setMessage(this.d);
    }

    public static a a(Context context, String str, CharSequence charSequence) {
        return (!(context instanceof Activity) || !((Activity) context).isFinishing()) ? new a(context, str, charSequence) : new c(context, str, charSequence);
    }

    public void a() {
        AlertDialog.Builder builder = this.f;
        if (builder != null) {
            builder.setNegativeButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        }
    }

    public void a(int i, int i2) {
        if (com.huawei.updatesdk.service.e.b.a().b() >= 11) {
            Button button = null;
            AlertDialog alertDialog = this.e;
            if (alertDialog != null) {
                button = alertDialog.getButton(-1);
            }
            if (button != null) {
                button.setBackgroundResource(i);
                button.setTextColor(this.b.getResources().getColor(i2));
            }
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.h = onDismissListener;
    }

    public void a(DialogInterface.OnKeyListener onKeyListener) {
        AlertDialog alertDialog = this.e;
        if (alertDialog != null) {
            alertDialog.setOnKeyListener(onKeyListener);
        }
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        this.g = onShowListener;
    }

    public void a(View view) {
        ImageView imageView;
        if (this.f != null) {
            int b2 = com.huawei.updatesdk.service.e.b.a().b();
            if ((b2 < 11 || b2 >= 17) && (imageView = (ImageView) view.findViewById(g.a(view.getContext(), "divider"))) != null) {
                imageView.setVisibility(8);
            }
            this.f.setMessage((CharSequence) null);
            this.f.setView(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d  */
    public void a(EnumC0080a aVar, String str) {
        Button button;
        AlertDialog alertDialog;
        int i;
        if (this.e != null) {
            if (aVar == EnumC0080a.CONFIRM) {
                alertDialog = this.e;
                i = -1;
            } else if (aVar == EnumC0080a.CANCEL) {
                alertDialog = this.e;
                i = -2;
            } else {
                button = null;
                if (button == null) {
                    button.setText(str);
                    button.setAllCaps(true);
                    return;
                }
                return;
            }
            button = alertDialog.getButton(i);
            if (button == null) {
            }
        }
    }

    public void a(b bVar) {
        Context context = this.b;
        if (context == null || ((Activity) context).isFinishing()) {
            if (bVar != null) {
                bVar.a();
            }
        } else if (!b()) {
            try {
                AlertDialog create = this.f.create();
                this.e = create;
                create.setCanceledOnTouchOutside(false);
                this.e.setOnShowListener(new DialogInterface.OnShowListener() {
                    /* class com.huawei.updatesdk.service.f.a.AnonymousClass1 */

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        AlertDialog alertDialog = (AlertDialog) dialogInterface;
                        alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() {
                            /* class com.huawei.updatesdk.service.f.a.AnonymousClass1.AnonymousClass1 */

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (a.this.a != null) {
                                    a.this.a.a();
                                }
                            }
                        });
                        Button button = alertDialog.getButton(-2);
                        if (button != null) {
                            button.setOnClickListener(new View.OnClickListener() {
                                /* class com.huawei.updatesdk.service.f.a.AnonymousClass1.AnonymousClass2 */

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (a.this.a != null) {
                                        a.this.a.b();
                                    }
                                }
                            });
                        }
                        if (a.this.g != null) {
                            a.this.g.onShow(dialogInterface);
                        }
                    }
                });
                this.e.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.huawei.updatesdk.service.f.a.AnonymousClass2 */

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (a.this.h != null) {
                            a.this.h.onDismiss(dialogInterface);
                        }
                    }
                });
                this.e.show();
                this.e.getButton(-1).requestFocus();
            } catch (Exception e2) {
                if (bVar != null) {
                    bVar.a();
                }
                com.huawei.updatesdk.a.a.b.a.a.a.a("BaseAlertDialog", "show dlg error, e: ", e2);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("show dlg error, mContext = ");
            sb.append(this.b);
            sb.append(", mContext.isFinishing is ");
            Context context2 = this.b;
            sb.append(context2 == null ? "mContext == null" : Boolean.valueOf(((Activity) context2).isFinishing()));
            com.huawei.updatesdk.a.a.b.a.a.a.d("BaseAlertDialog", sb.toString());
        }
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(boolean z) {
        AlertDialog alertDialog = this.e;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public boolean b() {
        AlertDialog alertDialog = this.e;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void c() {
        try {
            AlertDialog alertDialog = this.e;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.e = null;
            }
        } catch (IllegalArgumentException unused) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("BaseAlertDialog", "dialog dismiss IllegalArgumentException");
        }
    }
}
