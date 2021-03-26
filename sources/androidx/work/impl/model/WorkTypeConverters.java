package androidx.work.impl.model;

import android.net.Uri;
import androidx.work.BackoffPolicy;
import androidx.work.ContentUriTriggers;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WorkTypeConverters {

    public interface BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final int LINEAR = 1;
    }

    public interface NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int UNMETERED = 2;
    }

    public interface StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;
    }

    public static int stateToInt(WorkInfo.State state) {
        switch (AnonymousClass1.$SwitchMap$androidx$work$WorkInfo$State[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + state + " to int");
        }
    }

    public static WorkInfo.State intToState(int i) {
        if (i == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to State");
    }

    public static int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        int i = AnonymousClass1.$SwitchMap$androidx$work$BackoffPolicy[backoffPolicy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + backoffPolicy + " to int");
    }

    public static BackoffPolicy intToBackoffPolicy(int i) {
        if (i == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
    }

    /* renamed from: androidx.work.impl.model.WorkTypeConverters$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$BackoffPolicy;
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;
        static final /* synthetic */ int[] $SwitchMap$androidx$work$WorkInfo$State;

        static {
            int[] iArr = new int[NetworkType.values().length];
            $SwitchMap$androidx$work$NetworkType = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[BackoffPolicy.values().length];
            $SwitchMap$androidx$work$BackoffPolicy = iArr2;
            try {
                iArr2[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$work$BackoffPolicy[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[WorkInfo.State.values().length];
            $SwitchMap$androidx$work$WorkInfo$State = iArr3;
            try {
                iArr3[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public static int networkTypeToInt(NetworkType networkType) {
        int i = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    public static NetworkType intToNetworkType(int i) {
        if (i == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i == 1) {
            return NetworkType.CONNECTED;
        }
        if (i == 2) {
            return NetworkType.UNMETERED;
        }
        if (i == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i == 4) {
            return NetworkType.METERED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071 A[SYNTHETIC, Splitter:B:36:0x0071] */
    public static byte[] contentUriTriggersToByteArray(ContentUriTriggers contentUriTriggers) {
        Throwable th;
        IOException e;
        ObjectOutputStream objectOutputStream = null;
        if (contentUriTriggers.size() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeInt(contentUriTriggers.size());
                for (ContentUriTriggers.Trigger trigger : contentUriTriggers.getTriggers()) {
                    objectOutputStream2.writeUTF(trigger.getUri().toString());
                    objectOutputStream2.writeBoolean(trigger.shouldTriggerForDescendants());
                }
                try {
                    objectOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (IOException e4) {
                e = e4;
                objectOutputStream = objectOutputStream2;
                try {
                    e.printStackTrace();
                    if (objectOutputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e.printStackTrace();
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046 A[SYNTHETIC, Splitter:B:25:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005a A[SYNTHETIC, Splitter:B:35:0x005a] */
    public static ContentUriTriggers byteArrayToContentUriTriggers(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        IOException e;
        ContentUriTriggers contentUriTriggers = new ContentUriTriggers();
        if (bArr == null) {
            return contentUriTriggers;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                    contentUriTriggers.add(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean());
                }
                try {
                    objectInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    byteArrayInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (IOException e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    byteArrayInputStream.close();
                    return contentUriTriggers;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (IOException e8) {
            objectInputStream = null;
            e = e8;
            e.printStackTrace();
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return contentUriTriggers;
        } catch (Throwable th3) {
            objectInputStream = null;
            th = th3;
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            throw th;
        }
        return contentUriTriggers;
    }

    private WorkTypeConverters() {
    }
}
