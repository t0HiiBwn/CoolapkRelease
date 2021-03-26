package com.coolapk.market.view.feed;

import android.content.Intent;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.emotion.EmotionUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rx.Subscriber;

public class CommentHelper {
    public static final int PICK_APP_REQUEST_CODE = 1561;
    public static final String PICK_APP_RESULT_CODE = "pick_app_result";
    public static final int PICK_CONTACTS_REQUEST_CODE = 8655;
    public static final int PICK_TOPIC_REQUEST_CODE = 6666;
    public static final int PICK_USER_REQUEST_CODE = 3478;

    public static class FastDeleteSpan {
    }

    public static void processAddAppResult(Intent intent, final EditText editText) {
        DataManager.getInstance().getApkUrl(intent.getStringExtra("pick_app_result")).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.feed.CommentHelper.AnonymousClass1 */

            public void onNext(Result<String> result) {
                String data = result.getData();
                if (data != null) {
                    String str = " " + data + " ";
                    if (editText.isFocused()) {
                        editText.getText().insert(editText.getSelectionStart(), str);
                    } else {
                        editText.getText().append((CharSequence) str);
                    }
                }
            }
        });
    }

    public static void processAtUserResult(Intent intent, final EditText editText) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("result_contact");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            int selectionStart = editText.getSelectionStart();
            if (selectionStart >= 1) {
                int i = selectionStart - 1;
                if (editText.getText().charAt(i) == '@') {
                    editText.getText().replace(i, selectionStart, "");
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < parcelableArrayListExtra.size(); i2++) {
                sb.append("@");
                sb.append(((User) parcelableArrayListExtra.get(i2)).getUserName());
                sb.append(" ");
            }
            if (editText.isFocused()) {
                editText.getText().insert(editText.getSelectionStart(), sb);
            } else {
                editText.getText().append((CharSequence) sb);
            }
        }
        AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
            /* class com.coolapk.market.view.feed.CommentHelper.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                UiUtils.openKeyboard(editText);
            }
        }, 100);
    }

    public static void processTopicResult(Intent intent, final EditText editText) {
        String stringExtra = intent.getStringExtra("KEY_TOPIC_TITLE");
        if (!TextUtils.isEmpty(stringExtra)) {
            int selectionStart = editText.getSelectionStart();
            StringBuilder sb = new StringBuilder();
            if (selectionStart > 0 && editText.getText().charAt(selectionStart - 1) != ' ') {
                sb.append(" ");
            }
            sb.append("#");
            sb.append(stringExtra);
            sb.append("#");
            sb.append(" ");
            if (editText.isFocused()) {
                editText.getText().insert(editText.getSelectionStart(), sb.toString());
            } else {
                editText.getText().append((CharSequence) sb.toString());
            }
        }
        AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
            /* class com.coolapk.market.view.feed.CommentHelper.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                UiUtils.openKeyboard(editText);
            }
        }, 100);
    }

    public static class FastDeleteAtUserKeyListener implements View.OnKeyListener {
        private static Pattern AT_PATTERN = Pattern.compile("@[\\w\\-._]+[\\s:]");
        private static Pattern TAG_PATTERN = Pattern.compile("#[^# @]+#\\s");

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            EditText editText = (EditText) view;
            if (i == 67 && keyEvent.getAction() == 0) {
                if (removeFastDelete(editText)) {
                    return true;
                }
                Editable text = editText.getText();
                int selectionStart = editText.getSelectionStart();
                if (selectionStart <= 0) {
                    return false;
                }
                char charAt = text.charAt(selectionStart - 1);
                if ((charAt != ' ' && charAt != ':') || selectionStart != editText.getSelectionEnd()) {
                    return false;
                }
                int lastIndexOfAt = lastIndexOfAt(text, selectionStart);
                int lastIndexOfTopicStart = lastIndexOfTopicStart(text, selectionStart);
                if (lastIndexOfAt >= 0 && lastIndexOfAt > lastIndexOfTopicStart) {
                    char[] cArr = new char[(selectionStart - lastIndexOfAt)];
                    text.getChars(lastIndexOfAt, selectionStart, cArr, 0);
                    if (!AT_PATTERN.matcher(new String(cArr)).matches()) {
                        return false;
                    }
                    text.delete(lastIndexOfAt, selectionStart);
                    return true;
                } else if (lastIndexOfTopicStart >= 0 && lastIndexOfTopicStart > lastIndexOfAt) {
                    char[] cArr2 = new char[(selectionStart - lastIndexOfTopicStart)];
                    text.getChars(lastIndexOfTopicStart, selectionStart, cArr2, 0);
                    if (TAG_PATTERN.matcher(new String(cArr2)).matches()) {
                        text.delete(lastIndexOfTopicStart, selectionStart);
                        return true;
                    }
                }
            }
            return false;
        }

        private int lastIndexOfAt(Editable editable, int i) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (editable.charAt(i2) == '@') {
                    return i2;
                }
            }
            return -1;
        }

        private int lastIndexOfTopicStart(Editable editable, int i) {
            int i2 = 0;
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (editable.charAt(i3) == '#') {
                    i2++;
                }
                if (i2 == 2) {
                    return i3;
                }
            }
            return -1;
        }

        private boolean removeFastDelete(EditText editText) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) editText.getText();
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionEnd == selectionStart && selectionStart > 0) {
                selectionStart--;
            }
            FastDeleteSpan[] fastDeleteSpanArr = (FastDeleteSpan[]) spannableStringBuilder.getSpans(selectionStart, selectionEnd, FastDeleteSpan.class);
            boolean z = false;
            for (FastDeleteSpan fastDeleteSpan : fastDeleteSpanArr) {
                int spanStart = spannableStringBuilder.getSpanStart(fastDeleteSpan);
                int spanEnd = spannableStringBuilder.getSpanEnd(fastDeleteSpan);
                spannableStringBuilder.delete(spanStart, spanEnd);
                spannableStringBuilder.removeSpan(fastDeleteSpan);
                if (spanEnd == selectionEnd) {
                    z = true;
                }
            }
            return z;
        }
    }

    public static class OnTextInputListener implements TextWatcher {
        private Runnable mRunnable;
        private String mText;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public OnTextInputListener(String str, Runnable runnable) {
            this.mRunnable = runnable;
            this.mText = str;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i2 == 0 && i3 == this.mText.length() && charSequence.subSequence(i, i3 + i).toString().equals(this.mText)) {
                this.mRunnable.run();
            }
        }
    }

    public static class EmotionTextModifier implements TextWatcher {
        private static Pattern AT_PATTERN = Pattern.compile("@[\\w\\-._]+");
        private static Pattern TAG_PATTERN = Pattern.compile("#[^# @]+#");

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Spannable spannable = (Spannable) charSequence;
            int i4 = i3 + i;
            EmotionUtils.parserEmoticons(spannable, i, i4, null);
            tintPatternColor(spannable, AT_PATTERN, i, i4);
            tintPatternColor(spannable, TAG_PATTERN, i, i4);
        }

        private static void tintPatternColor(Spannable spannable, Pattern pattern, int i, int i2) {
            Matcher region = pattern.matcher(spannable).region(i, i2);
            while (region.find()) {
                String group2 = region.group();
                spannable.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), region.start(), region.start() + group2.length(), 33);
            }
        }
    }

    public static class CharRejectHelper implements TextWatcher {
        int after = -1;
        int before = -1;
        char c;
        int start = -1;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public CharRejectHelper(char c2) {
            this.c = c2;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.start = i;
            this.before = i2;
            this.after = i3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = this.after;
            if (i > 0) {
                int i2 = this.start;
                for (int i3 = (i + i2) - 1; i3 >= i2; i3--) {
                    if (editable.charAt(i3) == this.c) {
                        editable.replace(i3, i3 + 1, "");
                    }
                }
            }
        }
    }
}
