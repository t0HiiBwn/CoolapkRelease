package com.bytedance.embedapplog;

import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class bf {
    private static SparseArray<String> a;
    private static Set<Integer> b;
    private static LruCache<Class, String> c = new LruCache<>(100);

    private static boolean a(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18 || i2 == 145;
    }

    private static String b(String str) {
        return str;
    }

    static String a(Class cls) {
        String str = c.get(cls);
        if (TextUtils.isEmpty(str)) {
            str = cls.getSimpleName();
            if (TextUtils.isEmpty(str)) {
                str = "Anonymous";
            }
            c.put(cls, str);
            bc.a(cls, str);
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0113, code lost:
        if (r0 != null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0123, code lost:
        if (r0 != null) goto L_0x0127;
     */
    static ArrayList<String> a(View view, String str) {
        String str2;
        String str3;
        Object tag = view.getTag(84159244);
        ArrayList<String> arrayList = null;
        if (tag != null) {
            str2 = String.valueOf(tag);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            ArrayList<String> arrayList2 = new ArrayList<>(childCount);
            int i = 0;
            while (i < childCount && viewGroup.getChildAt(i).getVisibility() == 0) {
                arrayList2.addAll(a(viewGroup.getChildAt(i), (String) null));
                i++;
            }
            str2 = null;
            arrayList = arrayList2;
        } else {
            if (view instanceof EditText) {
                if (view.getTag(84159251) != null) {
                    EditText editText = (EditText) view;
                    if (!a(editText.getInputType())) {
                        CharSequence a2 = a((TextView) editText);
                        str2 = a2 == null ? "" : a2.toString();
                    }
                }
            } else if (view instanceof RatingBar) {
                str2 = String.valueOf(((RatingBar) view).getRating());
            } else if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                Object selectedItem = spinner.getSelectedItem();
                if (selectedItem instanceof String) {
                    str3 = (String) selectedItem;
                } else {
                    View selectedView = spinner.getSelectedView();
                    if (selectedView instanceof TextView) {
                        TextView textView = (TextView) selectedView;
                        if (textView.getText() != null) {
                            str3 = textView.getText().toString();
                        }
                    }
                    str3 = null;
                }
                str2 = str3;
            } else if (view instanceof SeekBar) {
                str2 = String.valueOf(((SeekBar) view).getProgress());
            } else if (view instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) view;
                View findViewById = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                if (findViewById != null && (findViewById instanceof RadioButton)) {
                    RadioButton radioButton = (RadioButton) findViewById;
                    if (radioButton.getText() != null) {
                        str2 = radioButton.getText().toString();
                    }
                }
            } else if (view instanceof TextView) {
                TextView textView2 = (TextView) view;
                if (textView2.getText() != null) {
                    str2 = textView2.getText().toString();
                }
            } else if (!(view instanceof ImageView)) {
                if (view instanceof WebView) {
                    WebView webView = (WebView) view;
                    if (!bg.a(webView)) {
                        str2 = webView.getUrl();
                    }
                }
                if (bc.h(view)) {
                    str2 = ((com.tencent.smtt.sdk.WebView) view).getUrl();
                }
            } else if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            str2 = null;
        }
        if (arrayList == null) {
            if (TextUtils.isEmpty(str2)) {
                if (str == null) {
                    str = view.getContentDescription() != null ? view.getContentDescription().toString() : str2;
                }
                str2 = a(str);
            }
            arrayList = new ArrayList<>(1);
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static String a(String str) {
        if (str == null) {
            return "";
        }
        if (!TextUtils.isEmpty(str) && str.length() > 20) {
            str = str.substring(0, 20);
        }
        return b(str);
    }

    static boolean a(View view) {
        return (view instanceof AdapterView) || bc.c(view) || bc.e(view) || bc.b(view) || bc.d(view);
    }

    static String a(View view, boolean z) {
        Object tag = view.getTag(84159242);
        if (tag != null && (tag instanceof String)) {
            return (String) tag;
        }
        if (z) {
            return null;
        }
        if (a == null) {
            a = new SparseArray<>();
        }
        if (b == null) {
            b = new HashSet();
        }
        int id = view.getId();
        if (id > 2130706432 && !b.contains(Integer.valueOf(id))) {
            String str = a.get(id);
            if (str != null) {
                return str;
            }
            try {
                String resourceEntryName = view.getResources().getResourceEntryName(id);
                a.put(id, resourceEntryName);
                return resourceEntryName;
            } catch (Exception unused) {
                b.add(Integer.valueOf(id));
            }
        }
        return null;
    }

    static int a(List list, int i) {
        return i % list.size();
    }

    static boolean b(View view) {
        return view == null || view.getTag(R.id.tag_ignore) != null;
    }

    private static CharSequence a(TextView textView) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mText");
            declaredField.setAccessible(true);
            return (CharSequence) declaredField.get(textView);
        } catch (Throwable th) {
            bo.a(th);
            return null;
        }
    }
}
