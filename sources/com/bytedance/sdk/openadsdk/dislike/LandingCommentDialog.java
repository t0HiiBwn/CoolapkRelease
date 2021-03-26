package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;

public class LandingCommentDialog extends FrameLayout {
    private View a;
    private ImageView b;
    private EditText c;
    private TextView d;
    private TextView e;
    private l f;
    private a g;

    public interface a {
        void a(View view);

        void a(String str, boolean z);

        void b(View view);
    }

    public LandingCommentDialog(Context context, l lVar) {
        super(context, null, ac.g(context, "quick_option_dialog"));
        this.f = lVar;
        a(context);
    }

    private void a(Context context) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingCommentDialog.this.a();
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.a = LayoutInflater.from(context).inflate(ac.f(context, "tt_dislike_comment_layout"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.a.setLayoutParams(layoutParams);
        this.a.setClickable(true);
        c();
    }

    public void a() {
        setVisibility(8);
        InputMethodManager inputMethodManager = (InputMethodManager) this.c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
        }
        a aVar = this.g;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void b() {
        if (this.a.getParent() == null) {
            addView(this.a);
        }
        setVisibility(0);
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private void c() {
        EditText editText = (EditText) this.a.findViewById(ac.e(getContext(), "tt_comment_content"));
        this.c = editText;
        setEditTextInputSpace(editText);
        TextView textView = (TextView) this.a.findViewById(ac.e(getContext(), "tt_comment_commit"));
        this.d = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = LandingCommentDialog.this.c.getText().toString();
                if (obj.length() > 0 && !obj.isEmpty()) {
                    FilterWord filterWord = new FilterWord("0:00", obj);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    d.a(LandingCommentDialog.this.f, arrayList);
                    if (LandingCommentDialog.this.g != null) {
                        try {
                            LandingCommentDialog.this.g.a(obj, true);
                        } catch (Throwable unused) {
                        }
                    }
                    LandingCommentDialog.this.a();
                }
            }
        });
        ImageView imageView = (ImageView) this.a.findViewById(ac.e(getContext(), "tt_comment_close"));
        this.b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingCommentDialog.this.a();
            }
        });
        this.e = (TextView) this.a.findViewById(ac.e(getContext(), "tt_comment_number"));
        this.c.addTextChangedListener(new TextWatcher() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.AnonymousClass4 */

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int round = Math.round((float) charSequence.length());
                LandingCommentDialog.this.e.setText(round + "");
                if (round > 0) {
                    LandingCommentDialog.this.d.setTextColor(-16777216);
                    LandingCommentDialog.this.d.setClickable(true);
                    return;
                }
                LandingCommentDialog.this.d.setTextColor(-7829368);
                LandingCommentDialog.this.d.setClickable(false);
            }
        });
    }

    public void setCallback(a aVar) {
        this.g = aVar;
    }

    public static void setEditTextInputSpace(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() {
            /* class com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.AnonymousClass5 */

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
