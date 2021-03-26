package com.bytedance.sdk.openadsdk.dislike;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;

/* compiled from: TTCommentDialog */
public class c extends Dialog {
    private View a;
    private ImageView b;
    private EditText c;
    private TextView d;
    private TextView e;
    private l f;
    private a g;

    /* compiled from: TTCommentDialog */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void b();
    }

    public c(Context context, l lVar) {
        super(context, ac.g(context, "quick_option_dialog"));
        this.f = lVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(ac.f(getContext(), "tt_dislike_comment_layout"), (ViewGroup) null);
        this.a = inflate;
        setContentView(inflate);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        a(getContext());
        c();
        b();
    }

    private void b() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    private void a(Context context) {
        EditText editText = (EditText) findViewById(ac.e(getContext(), "tt_comment_content"));
        this.c = editText;
        a(editText);
        TextView textView = (TextView) findViewById(ac.e(getContext(), "tt_comment_commit"));
        this.d = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = c.this.c.getText().toString();
                if (obj.length() > 0 && !obj.isEmpty()) {
                    FilterWord filterWord = new FilterWord("0:00", obj);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    d.a(c.this.f, arrayList);
                    if (c.this.g != null) {
                        try {
                            c.this.g.a(0, filterWord);
                        } catch (Throwable unused) {
                        }
                    }
                    c.this.dismiss();
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(ac.e(getContext(), "tt_comment_close"));
        this.b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.e = (TextView) findViewById(ac.e(getContext(), "tt_comment_number"));
        this.c.addTextChangedListener(new TextWatcher() {
            /* class com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass3 */

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int round = Math.round((float) charSequence.length());
                c.this.e.setText(round + "");
                if (round > 0) {
                    c.this.d.setTextColor(-16777216);
                    c.this.d.setClickable(true);
                    return;
                }
                c.this.d.setTextColor(-7829368);
                c.this.d.setClickable(false);
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        InputMethodManager inputMethodManager = (InputMethodManager) this.c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
        }
        this.c.clearFocus();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
        }
        super.dismiss();
    }

    private void c() {
        setOnShowListener(new DialogInterface.OnShowListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass4 */

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (c.this.g != null) {
                    c.this.g.a();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass5 */

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.g != null) {
                    c.this.g.b();
                }
            }
        });
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.f = lVar;
        }
    }

    public void a() {
        EditText editText = this.c;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public static void a(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() {
            /* class com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass6 */

            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }
}
