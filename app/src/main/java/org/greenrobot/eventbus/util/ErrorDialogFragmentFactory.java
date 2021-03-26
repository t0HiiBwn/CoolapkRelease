package org.greenrobot.eventbus.util;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import org.greenrobot.eventbus.util.ErrorDialogFragments;

public abstract class ErrorDialogFragmentFactory<T> {
    protected final ErrorDialogConfig config;

    protected abstract T createErrorFragment(ThrowableFailureEvent throwableFailureEvent, Bundle bundle);

    protected ErrorDialogFragmentFactory(ErrorDialogConfig errorDialogConfig) {
        this.config = errorDialogConfig;
    }

    protected T prepareErrorFragment(ThrowableFailureEvent throwableFailureEvent, boolean z, Bundle bundle) {
        Bundle bundle2;
        if (throwableFailureEvent.isSuppressErrorUi()) {
            return null;
        }
        if (bundle != null) {
            bundle2 = (Bundle) bundle.clone();
        } else {
            bundle2 = new Bundle();
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.title")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.title", getTitleFor(throwableFailureEvent, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.message", getMessageFor(throwableFailureEvent, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle2.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", z);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.config.defaultEventTypeOnDialogClosed != null) {
            bundle2.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.config.defaultEventTypeOnDialogClosed);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && this.config.defaultDialogIconId != 0) {
            bundle2.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.config.defaultDialogIconId);
        }
        return createErrorFragment(throwableFailureEvent, bundle2);
    }

    protected String getTitleFor(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
        return this.config.resources.getString(this.config.defaultTitleId);
    }

    protected String getMessageFor(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
        return this.config.resources.getString(this.config.getMessageIdForThrowable(throwableFailureEvent.throwable));
    }

    public static class Support extends ErrorDialogFragmentFactory<Fragment> {
        public Support(ErrorDialogConfig errorDialogConfig) {
            super(errorDialogConfig);
        }

        /* access modifiers changed from: protected */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public Fragment createErrorFragment(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
            ErrorDialogFragments.Support support = new ErrorDialogFragments.Support();
            support.setArguments(bundle);
            return support;
        }
    }

    public static class Honeycomb extends ErrorDialogFragmentFactory<android.app.Fragment> {
        public Honeycomb(ErrorDialogConfig errorDialogConfig) {
            super(errorDialogConfig);
        }

        /* access modifiers changed from: protected */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public android.app.Fragment createErrorFragment(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
            ErrorDialogFragments.Honeycomb honeycomb = new ErrorDialogFragments.Honeycomb();
            honeycomb.setArguments(bundle);
            return honeycomb;
        }
    }
}
