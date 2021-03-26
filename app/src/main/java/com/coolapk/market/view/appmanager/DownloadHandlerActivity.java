package com.coolapk.market.view.appmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.MinimumWidthDialog;

public class DownloadHandlerActivity extends FakeStatusBarActivity {
    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSlidrEnable(false);
        ThemeUtils.setTranslucentStatusBar(this);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
        } else if (TextUtils.isEmpty(data.toString())) {
            finish();
        } else {
            ConfirmDialog.newInstance(getIntent()).show(getSupportFragmentManager(), (String) null);
        }
    }

    public static class ConfirmDialog extends MinimumWidthDialog {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String KEY_INTENT = "INTENT";

        public static ConfirmDialog newInstance(Intent intent) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("INTENT", intent);
            ConfirmDialog confirmDialog = new ConfirmDialog();
            confirmDialog.setArguments(bundle);
            return confirmDialog;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        @Override // com.coolapk.market.widget.MinimumWidthDialog, com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            super.onStart();
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0035: APUT  (r3v0 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r5v0 java.lang.Object) */
        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            String str;
            Intent intent = (Intent) getArguments().getParcelable("INTENT");
            final String uri = intent.getData().toString();
            final String stringExtra = intent.getStringExtra("TITLE".toLowerCase());
            final String[] stringArrayExtra = intent.getStringArrayExtra("HEADERS".toLowerCase());
            Object[] objArr = new Object[2];
            objArr[0] = stringExtra;
            objArr[1] = stringArrayExtra != null ? stringArrayExtra : "No";
            LogUtils.d("Title: %s, Headers: %s", objArr);
            if (!TextUtils.isEmpty(stringExtra)) {
                str = getString(2131886748, stringExtra, uri);
            } else {
                str = getString(2131886749, uri);
            }
            return new AlertDialog.Builder(getActivity()).setTitle(2131886304).setMessage(str).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.DownloadHandlerActivity.ConfirmDialog.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActionManager.startDownload(ConfirmDialog.this.getActivity(), uri, stringExtra, stringArrayExtra);
                    ConfirmDialog.this.getActivity().finish();
                }
            }).setNegativeButton(2131886140, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.DownloadHandlerActivity.ConfirmDialog.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ConfirmDialog.this.getActivity().finish();
                }
            }).create();
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            if (getActivity() != null) {
                getActivity().finish();
            }
        }
    }
}
