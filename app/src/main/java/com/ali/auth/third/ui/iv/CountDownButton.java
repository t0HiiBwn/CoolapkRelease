package com.ali.auth.third.ui.iv;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.Button;
import com.ali.auth.third.ui.R;

public class CountDownButton extends Button {
    private a a;
    private boolean b;
    protected CountListener mCountListener;
    protected int mGetCodeTitleRes;
    protected int mTickTitleRes;

    public interface CountListener {
        void onTick(long j);
    }

    private class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            int i;
            Context context;
            CountDownButton countDownButton;
            if (CountDownButton.this.mGetCodeTitleRes != 0) {
                countDownButton = CountDownButton.this;
                context = countDownButton.getContext();
                i = CountDownButton.this.mGetCodeTitleRes;
            } else {
                countDownButton = CountDownButton.this;
                context = countDownButton.getContext();
                i = R.string.ali_auth_verification_reGetCode;
            }
            countDownButton.setText(context.getString(i));
            CountDownButton.this.setEnabled(true);
            CountDownButton.this.b = false;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CountDownButton countDownButton;
            String str;
            long j2 = (j / 1000) + 1;
            if (CountDownButton.this.mTickTitleRes != 0) {
                countDownButton = CountDownButton.this;
                str = countDownButton.getResources().getString(CountDownButton.this.mTickTitleRes, String.valueOf(j2));
            } else {
                countDownButton = CountDownButton.this;
                str = String.valueOf(j2) + CountDownButton.this.getContext().getString(R.string.ali_auth_verification_reGetCode);
            }
            countDownButton.setText(str);
            CountDownButton.this.setEnabled(false);
            if (CountDownButton.this.mCountListener != null) {
                CountDownButton.this.mCountListener.onTick(j);
            }
        }
    }

    public CountDownButton(Context context) {
        super(context);
        this.b = false;
        this.b = false;
    }

    public CountDownButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.b = false;
    }

    public void cancelCountDown() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.cancel();
        }
        this.b = false;
    }

    public boolean isCountDowning() {
        return this.b;
    }

    public void setGetCodeTitle(int i) {
        this.mGetCodeTitleRes = i;
    }

    public void setTickListener(CountListener countListener) {
        this.mCountListener = countListener;
    }

    public void setTickTitleRes(int i) {
        this.mTickTitleRes = i;
    }

    public void startCountDown(long j, long j2) {
        a aVar = new a(j, j2);
        this.a = aVar;
        aVar.start();
        this.b = true;
    }
}
