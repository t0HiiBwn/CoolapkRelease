package com.coolapk.market.view.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;

public class SimpleDialog extends BaseDialogFragment {
    private ListAdapter adapter;
    private CharSequence[] items;
    private String message;
    private String negativeText;
    private int negativeTextRes;
    private String neutralText;
    private int neutralTextRes;
    private DialogInterface.OnClickListener onItemsListener;
    private DialogInterface.OnClickListener onNegativeListener;
    private DialogInterface.OnClickListener onNeutralListener;
    private DialogInterface.OnClickListener onPositiveListener;
    private String positiveText;
    private int positiveTextRes;
    private String title;
    private View view;

    public static SimpleDialog newInstance() {
        Bundle bundle = new Bundle();
        SimpleDialog simpleDialog = new SimpleDialog();
        simpleDialog.setArguments(bundle);
        return simpleDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String str = this.title;
        if (str != null) {
            builder.setTitle(str);
        }
        String str2 = this.message;
        if (str2 != null) {
            builder.setMessage(str2);
        } else {
            CharSequence[] charSequenceArr = this.items;
            if (charSequenceArr != null) {
                builder.setItems(charSequenceArr, this.onItemsListener);
            } else {
                ListAdapter listAdapter = this.adapter;
                if (listAdapter != null) {
                    builder.setAdapter(listAdapter, this.onItemsListener);
                } else {
                    View view2 = this.view;
                    if (view2 != null) {
                        builder.setView(view2);
                    }
                }
            }
        }
        String str3 = this.positiveText;
        if (str3 != null) {
            builder.setPositiveButton(str3, this.onPositiveListener);
        } else {
            int i = this.positiveTextRes;
            if (i != 0) {
                builder.setPositiveButton(i, this.onPositiveListener);
            }
        }
        String str4 = this.negativeText;
        if (str4 != null) {
            builder.setNegativeButton(str4, this.onNegativeListener);
        } else {
            int i2 = this.negativeTextRes;
            if (i2 != 0) {
                builder.setNegativeButton(i2, this.onNegativeListener);
            }
        }
        String str5 = this.neutralText;
        if (str5 != null) {
            builder.setNeutralButton(str5, this.onNeutralListener);
        } else {
            int i3 = this.neutralTextRes;
            if (i3 != 0) {
                builder.setNeutralButton(i3, this.onNeutralListener);
            }
        }
        return builder.create();
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.items = charSequenceArr;
        this.onItemsListener = onClickListener;
    }

    public void setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        this.positiveTextRes = i;
        this.onPositiveListener = onClickListener;
    }

    public void setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
        this.positiveText = str;
        this.onPositiveListener = onClickListener;
    }

    public void setNegativeButton(int i) {
        setNegativeButton(i, (DialogInterface.OnClickListener) null);
    }

    public void setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        this.negativeTextRes = i;
        if (onClickListener == null) {
            onClickListener = new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.base.SimpleDialog.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            };
        }
        this.onNegativeListener = onClickListener;
    }

    public void setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
        this.negativeText = str;
        if (onClickListener == null) {
            onClickListener = new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.base.SimpleDialog.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            };
        }
        this.onNegativeListener = onClickListener;
    }

    public void setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
        this.neutralTextRes = i;
        this.onNeutralListener = onClickListener;
    }

    public void setNeutralButton(String str, DialogInterface.OnClickListener onClickListener) {
        this.neutralText = str;
        this.onNeutralListener = onClickListener;
    }

    public void setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.adapter = listAdapter;
        this.onItemsListener = onClickListener;
    }

    public void setView(View view2) {
        this.view = view2;
    }

    public static class DialogItem {
        public final Drawable icon;
        public final String text;

        public DialogItem(String str, Drawable drawable) {
            this.text = str;
            this.icon = drawable;
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public String toString() {
            return this.text;
        }
    }
}
