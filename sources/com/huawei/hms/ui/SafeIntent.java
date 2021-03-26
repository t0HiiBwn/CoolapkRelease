package com.huawei.hms.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public class SafeIntent extends Intent {
    private static final String a = "SafeIntent";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    @Override // android.content.Intent
    public String getAction() {
        try {
            return super.getAction();
        } catch (Exception unused) {
            return "";
        }
    }

    public String getActionReturnNotNull() {
        try {
            String action = super.getAction();
            return action == null ? "" : action;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return (T) super.getParcelableExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public String getStringExtraReturnNotNull(String str) {
        try {
            String stringExtra = super.getStringExtra(str);
            return stringExtra == null ? "" : stringExtra;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z) {
        try {
            return super.getBooleanExtra(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // android.content.Intent
    public int getIntExtra(String str, int i) {
        try {
            return super.getIntExtra(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b) {
        try {
            return super.getByteExtra(str, b);
        } catch (Exception unused) {
            return b;
        }
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public CharSequence getCharSequenceExtraReturnNotNull(String str) {
        try {
            CharSequence charSequenceExtra = super.getCharSequenceExtra(str);
            return charSequenceExtra == null ? "" : charSequenceExtra;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c) {
        try {
            return super.getCharExtra(str, c);
        } catch (Exception unused) {
            return c;
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j) {
        try {
            return super.getLongExtra(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f) {
        try {
            return super.getFloatExtra(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d) {
        try {
            return super.getDoubleExtra(str, d);
        } catch (Exception unused) {
            return d;
        }
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    public ArrayList<CharSequence> getCharSequenceArrayListExtraReturnNotNull(String str) {
        try {
            ArrayList<CharSequence> charSequenceArrayListExtra = super.getCharSequenceArrayListExtra(str);
            return charSequenceArrayListExtra == null ? new ArrayList<>() : charSequenceArrayListExtra;
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> getIntegerArrayListExtraReturnNotNull(String str) {
        try {
            ArrayList<Integer> integerArrayListExtra = super.getIntegerArrayListExtra(str);
            return integerArrayListExtra == null ? new ArrayList<>() : integerArrayListExtra;
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    public ArrayList<String> getStringArrayListExtraReturnNotNull(String str) {
        try {
            ArrayList<String> stringArrayListExtra = super.getStringArrayListExtra(str);
            return stringArrayListExtra == null ? new ArrayList<>() : stringArrayListExtra;
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Exception unused) {
            return new boolean[0];
        }
    }

    public boolean[] getBooleanArrayExtraReturnNotNull(String str) {
        try {
            boolean[] booleanArrayExtra = super.getBooleanArrayExtra(str);
            return booleanArrayExtra == null ? new boolean[0] : booleanArrayExtra;
        } catch (Exception unused) {
            return new boolean[0];
        }
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    public Bundle getBundleExtraReturnNotNull(String str) {
        try {
            Bundle bundleExtra = super.getBundleExtra(str);
            return bundleExtra == null ? new Bundle() : bundleExtra;
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    public Bundle getExtrasReturnNotNull() {
        try {
            Bundle extras = super.getExtras();
            return extras == null ? new Bundle() : extras;
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public byte[] getByteArrayExtraReturnNotNull(String str) {
        try {
            byte[] byteArrayExtra = super.getByteArrayExtra(str);
            return byteArrayExtra == null ? new byte[0] : byteArrayExtra;
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Exception unused) {
            return new char[0];
        }
    }

    public char[] getCharArrayExtraReturnNotNull(String str) {
        try {
            char[] charArrayExtra = super.getCharArrayExtra(str);
            return charArrayExtra == null ? new char[0] : charArrayExtra;
        } catch (Exception unused) {
            return new char[0];
        }
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Exception unused) {
            return new CharSequence[0];
        }
    }

    public CharSequence[] getCharSequenceArrayExtraReturnNotNull(String str) {
        try {
            CharSequence[] charSequenceArrayExtra = super.getCharSequenceArrayExtra(str);
            return charSequenceArrayExtra == null ? new CharSequence[0] : charSequenceArrayExtra;
        } catch (Exception unused) {
            return new CharSequence[0];
        }
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Exception unused) {
            return new double[0];
        }
    }

    public double[] getDoubleArrayExtraReturnNotNull(String str) {
        try {
            double[] doubleArrayExtra = super.getDoubleArrayExtra(str);
            return doubleArrayExtra == null ? new double[0] : doubleArrayExtra;
        } catch (Exception unused) {
            return new double[0];
        }
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Exception unused) {
            return new float[0];
        }
    }

    public float[] getFloatArrayExtraReturnNotNull(String str) {
        try {
            float[] floatArrayExtra = super.getFloatArrayExtra(str);
            return floatArrayExtra == null ? new float[0] : floatArrayExtra;
        } catch (Exception unused) {
            return new float[0];
        }
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Exception unused) {
            return new int[0];
        }
    }

    public int[] getIntArrayExtraReturnNotNull(String str) {
        try {
            int[] intArrayExtra = super.getIntArrayExtra(str);
            return intArrayExtra == null ? new int[0] : intArrayExtra;
        } catch (Exception unused) {
            return new int[0];
        }
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Exception unused) {
            return new long[0];
        }
    }

    public long[] getLongArrayExtraReturnNotNull(String str) {
        try {
            long[] longArrayExtra = super.getLongArrayExtra(str);
            return longArrayExtra == null ? new long[0] : longArrayExtra;
        } catch (Exception unused) {
            return new long[0];
        }
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Exception unused) {
            return new Parcelable[0];
        }
    }

    public Parcelable[] getParcelableArrayExtraReturnNotNull(String str) {
        try {
            Parcelable[] parcelableArrayExtra = super.getParcelableArrayExtra(str);
            return parcelableArrayExtra == null ? new Parcelable[0] : parcelableArrayExtra;
        } catch (Exception unused) {
            return new Parcelable[0];
        }
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Exception unused) {
            return new String[0];
        }
    }

    public String[] getStringArrayExtraReturnNotNull(String str) {
        try {
            String[] stringArrayExtra = super.getStringArrayExtra(str);
            return stringArrayExtra == null ? new String[0] : stringArrayExtra;
        } catch (Exception unused) {
            return new String[0];
        }
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s) {
        try {
            return super.getShortExtra(str, s);
        } catch (Exception unused) {
            return s;
        }
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Exception unused) {
            return new short[0];
        }
    }

    public short[] getShortArrayExtraReturnNotNull(String str) {
        try {
            short[] shortArrayExtra = super.getShortArrayExtra(str);
            return shortArrayExtra == null ? new short[0] : shortArrayExtra;
        } catch (Exception unused) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Exception unused) {
            return false;
        }
    }
}
