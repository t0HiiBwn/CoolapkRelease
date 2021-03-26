package androidx.preference;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.DialogPreference;

@Deprecated
public abstract class PreferenceDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
    @Deprecated
    protected static final String ARG_KEY = "key";
    private static final String SAVE_STATE_ICON = "PreferenceDialogFragment.icon";
    private static final String SAVE_STATE_LAYOUT = "PreferenceDialogFragment.layout";
    private static final String SAVE_STATE_MESSAGE = "PreferenceDialogFragment.message";
    private static final String SAVE_STATE_NEGATIVE_TEXT = "PreferenceDialogFragment.negativeText";
    private static final String SAVE_STATE_POSITIVE_TEXT = "PreferenceDialogFragment.positiveText";
    private static final String SAVE_STATE_TITLE = "PreferenceDialogFragment.title";
    private BitmapDrawable mDialogIcon;
    private int mDialogLayoutRes;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;
    private DialogPreference mPreference;
    private int mWhichButtonClicked;

    protected boolean needInputMethod() {
        return false;
    }

    @Deprecated
    public abstract void onDialogClosed(boolean z);

    @Deprecated
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof DialogPreference.TargetFragment) {
            DialogPreference.TargetFragment targetFragment2 = (DialogPreference.TargetFragment) targetFragment;
            String string = getArguments().getString("key");
            if (bundle == null) {
                DialogPreference dialogPreference = (DialogPreference) targetFragment2.findPreference(string);
                this.mPreference = dialogPreference;
                this.mDialogTitle = dialogPreference.getDialogTitle();
                this.mPositiveButtonText = this.mPreference.getPositiveButtonText();
                this.mNegativeButtonText = this.mPreference.getNegativeButtonText();
                this.mDialogMessage = this.mPreference.getDialogMessage();
                this.mDialogLayoutRes = this.mPreference.getDialogLayoutResource();
                Drawable dialogIcon = this.mPreference.getDialogIcon();
                if (dialogIcon == null || (dialogIcon instanceof BitmapDrawable)) {
                    this.mDialogIcon = (BitmapDrawable) dialogIcon;
                    return;
                }
                Bitmap createBitmap = Bitmap.createBitmap(dialogIcon.getIntrinsicWidth(), dialogIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                dialogIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                dialogIcon.draw(canvas);
                this.mDialogIcon = new BitmapDrawable(getResources(), createBitmap);
                return;
            }
            this.mDialogTitle = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.mPositiveButtonText = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.mNegativeButtonText = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.mDialogMessage = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.mDialogLayoutRes = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.mDialogIcon = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.mDialogTitle);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.mPositiveButtonText);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.mNegativeButtonText);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.mDialogMessage);
        bundle.putInt("PreferenceDialogFragment.layout", this.mDialogLayoutRes);
        BitmapDrawable bitmapDrawable = this.mDialogIcon;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Activity activity = getActivity();
        this.mWhichButtonClicked = -2;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity).setTitle(this.mDialogTitle).setIcon(this.mDialogIcon).setPositiveButton(this.mPositiveButtonText, this).setNegativeButton(this.mNegativeButtonText, this);
        View onCreateDialogView = onCreateDialogView(activity);
        if (onCreateDialogView != null) {
            onBindDialogView(onCreateDialogView);
            negativeButton.setView(onCreateDialogView);
        } else {
            negativeButton.setMessage(this.mDialogMessage);
        }
        onPrepareDialogBuilder(negativeButton);
        AlertDialog create = negativeButton.create();
        if (needInputMethod()) {
            requestInputMethod(create);
        }
        return create;
    }

    @Deprecated
    public DialogPreference getPreference() {
        if (this.mPreference == null) {
            this.mPreference = (DialogPreference) ((DialogPreference.TargetFragment) getTargetFragment()).findPreference(getArguments().getString("key"));
        }
        return this.mPreference;
    }

    private void requestInputMethod(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    @Deprecated
    protected View onCreateDialogView(Context context) {
        int i = this.mDialogLayoutRes;
        if (i == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    @Deprecated
    protected void onBindDialogView(View view) {
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.mDialogMessage;
            int i = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i = 0;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Deprecated
    public void onClick(DialogInterface dialogInterface, int i) {
        this.mWhichButtonClicked = i;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        onDialogClosed(this.mWhichButtonClicked == -1);
    }
}
