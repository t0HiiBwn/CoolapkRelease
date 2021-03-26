package com.coolapk.market.view.richedit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.ksoichiro.android.observablescrollview.ObservableWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RichEditor extends ObservableWebView {
    private static final String CALLBACK_SCHEME = "re-callback://";
    private static final String FOCUS_SCHEME = "re-focus://";
    private static final String SETUP_HTML = "file:///android_asset/editor.html";
    private static final String STATE_SCHEME = "re-state://";
    private boolean isReady;
    private String mContents;
    private OnDecorationStateListener mDecorationStateListener;
    private AfterInitialLoadListener mLoadListener;
    private OnEditFocusChangeListener mOnEditFocusChangeListener;
    private OnTextChangeListener mTextChangeListener;

    public interface AfterInitialLoadListener {
        void onAfterInitialLoad(boolean z);
    }

    public interface OnDecorationStateListener {
        void onStateChangeListener(String str, List<Type> list);
    }

    public interface OnEditFocusChangeListener {
        void onEditFocus(boolean z);
    }

    public interface OnTextChangeListener {
        void onTextChange(String str);
    }

    public enum Type {
        BOLD,
        ITALIC,
        SUBSCRIPT,
        SUPERSCRIPT,
        STRIKETHROUGH,
        UNDERLINE,
        H1,
        H2,
        H3,
        H4,
        H5,
        H6,
        ORDEREDLIST,
        UNORDEREDLIST,
        JUSTIFYCENTER,
        JUSTIFYFULL,
        JUSTUFYLEFT,
        JUSTIFYRIGHT
    }

    public RichEditor(Context context) {
        this(context, null);
    }

    public RichEditor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842885);
    }

    public RichEditor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isReady = false;
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        setWebChromeClient(new WebChromeClient());
        setWebViewClient(createWebviewClient());
        loadUrl("file:///android_asset/editor.html");
        applyAttributes(context, attributeSet);
    }

    protected EditorWebViewClient createWebviewClient() {
        return new EditorWebViewClient();
    }

    public void setOnTextChangeListener(OnTextChangeListener onTextChangeListener) {
        this.mTextChangeListener = onTextChangeListener;
    }

    public void setOnDecorationChangeListener(OnDecorationStateListener onDecorationStateListener) {
        this.mDecorationStateListener = onDecorationStateListener;
    }

    public void setOnInitialLoadListener(AfterInitialLoadListener afterInitialLoadListener) {
        this.mLoadListener = afterInitialLoadListener;
    }

    public void setOnEditFocusChangeListener(OnEditFocusChangeListener onEditFocusChangeListener) {
        this.mOnEditFocusChangeListener = onEditFocusChangeListener;
    }

    /* access modifiers changed from: private */
    public void callback(String str) {
        String replaceFirst = str.replaceFirst("re-callback://", "");
        this.mContents = replaceFirst;
        OnTextChangeListener onTextChangeListener = this.mTextChangeListener;
        if (onTextChangeListener != null) {
            onTextChangeListener.onTextChange(replaceFirst);
        }
    }

    /* access modifiers changed from: private */
    public void stateCheck(String str) {
        String upperCase = str.replaceFirst("re-state://", "").toUpperCase(Locale.ENGLISH);
        ArrayList arrayList = new ArrayList();
        Type[] values = Type.values();
        for (Type type : values) {
            if (TextUtils.indexOf(upperCase, type.name()) != -1) {
                arrayList.add(type);
            }
        }
        OnDecorationStateListener onDecorationStateListener = this.mDecorationStateListener;
        if (onDecorationStateListener != null) {
            onDecorationStateListener.onStateChangeListener(upperCase, arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void hasFocus(String str) {
        String replaceFirst = str.replaceFirst("re-focus://", "");
        OnEditFocusChangeListener onEditFocusChangeListener = this.mOnEditFocusChangeListener;
        if (onEditFocusChangeListener != null) {
            onEditFocusChangeListener.onEditFocus(TextUtils.equals(replaceFirst, "focus"));
        }
    }

    private void applyAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842927});
        int i = obtainStyledAttributes.getInt(0, -1);
        if (i == 1) {
            exec("javascript:RE.setTextAlign(\"center\")");
        } else if (i == 3) {
            exec("javascript:RE.setTextAlign(\"left\")");
        } else if (i == 5) {
            exec("javascript:RE.setTextAlign(\"right\")");
        } else if (i == 48) {
            exec("javascript:RE.setVerticalAlign(\"top\")");
        } else if (i == 80) {
            exec("javascript:RE.setVerticalAlign(\"bottom\")");
        } else if (i == 16) {
            exec("javascript:RE.setVerticalAlign(\"middle\")");
        } else if (i == 17) {
            exec("javascript:RE.setVerticalAlign(\"middle\")");
            exec("javascript:RE.setTextAlign(\"center\")");
        }
        obtainStyledAttributes.recycle();
    }

    public void setHtml(String str) {
        if (str == null) {
            str = "";
        }
        try {
            exec("javascript:RE.setHtml('" + URLEncoder.encode(str, "UTF-8") + "');");
        } catch (UnsupportedEncodingException unused) {
        }
        this.mContents = str;
    }

    public String getHtml() {
        return this.mContents;
    }

    public void setEditorFontColor(int i) {
        String convertHexColorString = convertHexColorString(i);
        exec("javascript:RE.setBaseTextColor('" + convertHexColorString + "');");
    }

    public void setEditorFontSize(int i) {
        exec("javascript:RE.setBaseFontSize('" + i + "px');");
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        exec("javascript:RE.setPadding('" + i + "px', '" + i2 + "px', '" + i3 + "px', '" + i4 + "px');");
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        setPadding(i, i2, i3, i4);
    }

    public void setEditorBackgroundColor(int i) {
        setBackgroundColor(i);
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Bitmap decodeResource = Utils.decodeResource(getContext(), i);
        String base64 = Utils.toBase64(decodeResource);
        decodeResource.recycle();
        exec("javascript:RE.setBackgroundImage('url(data:image/png;base64," + base64 + ")');");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        Bitmap bitmap = Utils.toBitmap(drawable);
        String base64 = Utils.toBase64(bitmap);
        bitmap.recycle();
        exec("javascript:RE.setBackgroundImage('url(data:image/png;base64," + base64 + ")');");
    }

    public void setBackground(String str) {
        exec("javascript:RE.setBackgroundImage('url(" + str + ")');");
    }

    public void setEditorWidth(int i) {
        exec("javascript:RE.setWidth('" + i + "px');");
    }

    public void setEditorHeight(int i) {
        exec("javascript:RE.setHeight('" + i + "px');");
    }

    public void setPlaceholder(String str) {
        exec("javascript:RE.setPlaceholder('" + str + "');");
    }

    public void setInputEnabled(Boolean bool) {
        exec("javascript:RE.setInputEnabled(" + bool + ")");
    }

    public void loadCSS(String str) {
        exec("javascript:" + ("(function() {    var head  = document.getElementsByTagName(\"head\")[0];    var link  = document.createElement(\"link\");    link.rel  = \"stylesheet\";    link.type = \"text/css\";    link.href = \"" + str + "\";    link.media = \"all\";    head.appendChild(link);}) ();") + "");
    }

    public void defaultParagraphSeparator() {
        exec("javascript:RE.defaultParagraphSeparator();");
    }

    public void undo() {
        exec("javascript:RE.undo();");
    }

    public void redo() {
        exec("javascript:RE.redo();");
    }

    public void setBold() {
        exec("javascript:RE.setBold();");
    }

    public void setItalic() {
        exec("javascript:RE.setItalic();");
    }

    public void setSubscript() {
        exec("javascript:RE.setSubscript();");
    }

    public void setSuperscript() {
        exec("javascript:RE.setSuperscript();");
    }

    public void setStrikeThrough() {
        exec("javascript:RE.setStrikeThrough();");
    }

    public void setUnderline() {
        exec("javascript:RE.setUnderline();");
    }

    public void setTextColor(int i) {
        exec("javascript:RE.prepareInsert();");
        String convertHexColorString = convertHexColorString(i);
        exec("javascript:RE.setTextColor('" + convertHexColorString + "');");
    }

    public void setTextBackgroundColor(int i) {
        exec("javascript:RE.prepareInsert();");
        String convertHexColorString = convertHexColorString(i);
        exec("javascript:RE.setTextBackgroundColor('" + convertHexColorString + "');");
    }

    public void setFontSize(int i) {
        if (i > 7 || i < 1) {
            Log.e("RichEditor", "Font size should have a value between 1-7");
        }
        exec("javascript:RE.setFontSize('" + i + "');");
    }

    public void removeFormat() {
        exec("javascript:RE.removeFormat();");
    }

    public void setHeading(int i) {
        exec("javascript:RE.setHeading('" + i + "');");
    }

    public void setIndent() {
        exec("javascript:RE.setIndent();");
    }

    public void setOutdent() {
        exec("javascript:RE.setOutdent();");
    }

    public void setAlignLeft() {
        exec("javascript:RE.setJustifyLeft();");
    }

    public void setAlignCenter() {
        exec("javascript:RE.setJustifyCenter();");
    }

    public void setAlignRight() {
        exec("javascript:RE.setJustifyRight();");
    }

    public void setBlockquote() {
        exec("javascript:RE.setBlockquote();");
    }

    public void setBullets() {
        exec("javascript:RE.setBullets();");
    }

    public void setNumbers() {
        exec("javascript:RE.setNumbers();");
    }

    public void insertImage(String str, String str2) {
        exec("javascript:RE.prepareInsert();");
        exec("javascript:RE.insertImage('" + str + "', '" + str2 + "');");
    }

    public void insertImage(String str, String str2, int i, int i2) {
        exec("javascript:RE.prepareInsert();");
        exec("javascript:RE.insertImageWH('" + str + "', '" + str2 + "', '" + i + "', '" + i2 + "' );");
    }

    public void insertLink(String str, String str2) {
        exec("javascript:RE.prepareInsert();");
        exec("javascript:RE.insertLink('" + str + "', '" + str2 + "');");
    }

    public void insertHtml(String str) {
        exec("javascript:RE.prepareInsert();");
        exec("javascript:RE.insertHTML('" + str + "');");
    }

    public void insertTodo() {
        exec("javascript:RE.prepareInsert();");
        exec("javascript:RE.setTodo('" + Utils.getCurrentTime() + "');");
    }

    public void focusEditor() {
        requestFocus();
        exec("javascript:RE.focus();");
    }

    public void clearFocusEditor() {
        exec("javascript:RE.blurFocus();");
    }

    private String convertHexColorString(int i) {
        return String.format("#%06X", Integer.valueOf(i & 16777215));
    }

    protected void exec(final String str) {
        if (this.isReady) {
            load(str);
        } else {
            postDelayed(new Runnable() {
                /* class com.coolapk.market.view.richedit.RichEditor.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    RichEditor.this.exec(str);
                }
            }, 100);
        }
    }

    private void load(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str, null);
        } else {
            loadUrl(str);
        }
    }

    protected class EditorWebViewClient extends WebViewClient {
        protected EditorWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            RichEditor.this.isReady = str.equalsIgnoreCase("file:///android_asset/editor.html");
            if (RichEditor.this.mLoadListener != null) {
                RichEditor.this.mLoadListener.onAfterInitialLoad(RichEditor.this.isReady);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                String decode = URLDecoder.decode(str, "UTF-8");
                if (TextUtils.indexOf(str, "re-callback://") == 0) {
                    RichEditor.this.callback(decode);
                    return true;
                } else if (TextUtils.indexOf(str, "re-state://") == 0) {
                    RichEditor.this.stateCheck(decode);
                    return true;
                } else if (TextUtils.indexOf(str, "re-focus://") != 0) {
                    return super.shouldOverrideUrlLoading(webView, str);
                } else {
                    RichEditor.this.hasFocus(decode);
                    return true;
                }
            } catch (UnsupportedEncodingException unused) {
                return false;
            }
        }
    }
}
