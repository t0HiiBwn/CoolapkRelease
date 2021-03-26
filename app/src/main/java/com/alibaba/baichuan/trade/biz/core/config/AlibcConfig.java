package com.alibaba.baichuan.trade.biz.core.config;

import android.content.Context;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlibcConfig {
    private static final String c = "AlibcConfig";
    private Map<String, Map<String, Object>> a = new HashMap();
    private Set<String> b = new HashSet();

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094 A[SYNTHETIC, Splitter:B:34:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b3 A[SYNTHETIC, Splitter:B:39:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cd A[SYNTHETIC, Splitter:B:47:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ec A[SYNTHETIC, Splitter:B:52:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0104 A[SYNTHETIC, Splitter:B:60:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0123 A[SYNTHETIC, Splitter:B:65:0x0123] */
    public static Object readObjectFromFile(Context context, String str) {
        Object obj;
        IOException e;
        StringBuilder sb;
        String str2;
        ObjectInputStream objectInputStream;
        Throwable th;
        FileInputStream fileInputStream = null;
        Object obj2 = null;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        try {
            FileInputStream openFileInput = context.getApplicationContext().openFileInput(str);
            try {
                objectInputStream = new ObjectInputStream(openFileInput);
                do {
                    try {
                        obj2 = objectInputStream.readObject();
                    } catch (IOException unused) {
                        fileInputStream = openFileInput;
                        obj = obj2;
                        AlibcLogger.e(c, "read object from local file exception");
                        if (fileInputStream != null) {
                        }
                        if (objectInputStream != null) {
                        }
                        return obj;
                    } catch (ClassNotFoundException unused2) {
                        fileInputStream3 = openFileInput;
                        obj = obj2;
                        AlibcLogger.e(c, "class not found");
                        if (fileInputStream3 != null) {
                        }
                        if (objectInputStream != null) {
                        }
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = openFileInput;
                        obj = obj2;
                        try {
                            AlibcLogger.e(c, "Error Exception: " + th.getMessage());
                            if (fileInputStream2 != null) {
                            }
                            if (objectInputStream != null) {
                            }
                            return obj;
                        } catch (Throwable th3) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    AlibcLogger.e(c, "close file input stream exception: " + e2.getMessage());
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e3) {
                                    AlibcLogger.e(c, "close object input stream exception: " + e3.getMessage());
                                }
                            }
                            throw th3;
                        }
                    }
                } while (obj2 != null);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                        AlibcLogger.e(c, "close file input stream exception: " + e4.getMessage());
                    }
                }
                try {
                    objectInputStream.close();
                    return obj2;
                } catch (IOException e5) {
                    AlibcLogger.e(c, "close object input stream exception: " + e5.getMessage());
                    return obj2;
                }
            } catch (IOException unused3) {
                objectInputStream = null;
                fileInputStream = openFileInput;
                obj = null;
                AlibcLogger.e(c, "read object from local file exception");
                if (fileInputStream != null) {
                }
                if (objectInputStream != null) {
                }
                return obj;
            } catch (ClassNotFoundException unused4) {
                objectInputStream = null;
                fileInputStream3 = openFileInput;
                obj = null;
                AlibcLogger.e(c, "class not found");
                if (fileInputStream3 != null) {
                }
                if (objectInputStream != null) {
                }
                return obj;
            } catch (Throwable th4) {
                th = th4;
                objectInputStream = null;
                fileInputStream2 = openFileInput;
                obj = null;
                AlibcLogger.e(c, "Error Exception: " + th.getMessage());
                if (fileInputStream2 != null) {
                }
                if (objectInputStream != null) {
                }
                return obj;
            }
            sb.append("close object input stream exception: ");
            sb.append(e.getMessage());
            AlibcLogger.e(str2, sb.toString());
            return obj;
        } catch (IOException unused5) {
            obj = null;
            objectInputStream = null;
            AlibcLogger.e(c, "read object from local file exception");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    AlibcLogger.e(c, "close file input stream exception: " + e6.getMessage());
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                    e = e7;
                    str2 = c;
                    sb = new StringBuilder();
                }
            }
            return obj;
        } catch (ClassNotFoundException unused6) {
            obj = null;
            objectInputStream = null;
            AlibcLogger.e(c, "class not found");
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e8) {
                    AlibcLogger.e(c, "close file input stream exception: " + e8.getMessage());
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e9) {
                    e = e9;
                    str2 = c;
                    sb = new StringBuilder();
                }
            }
            return obj;
        } catch (Throwable th5) {
            th = th5;
            obj = null;
            objectInputStream = null;
            AlibcLogger.e(c, "Error Exception: " + th.getMessage());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e10) {
                    AlibcLogger.e(c, "close file input stream exception: " + e10.getMessage());
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e11) {
                    e = e11;
                    str2 = c;
                    sb = new StringBuilder();
                }
            }
            return obj;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0082 A[SYNTHETIC, Splitter:B:33:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3 A[SYNTHETIC, Splitter:B:38:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca A[SYNTHETIC, Splitter:B:46:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00eb A[SYNTHETIC, Splitter:B:51:0x00eb] */
    public static synchronized void writeObjectToFile(Context context, Object obj, String str) {
        ObjectOutputStream objectOutputStream;
        String str2;
        String str3;
        Throwable th;
        synchronized (AlibcConfig.class) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream openFileOutput = context.openFileOutput(str, 0);
                try {
                    objectOutputStream = new ObjectOutputStream(openFileOutput);
                    try {
                        objectOutputStream.writeObject(obj);
                        openFileOutput.getFD().sync();
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e) {
                                AlibcLogger.e(c, "close file output stream exception: " + e.getMessage());
                            }
                        }
                        try {
                            objectOutputStream.close();
                        } catch (IOException e2) {
                            str2 = c;
                            str3 = "close object output stream exception: " + e2.getMessage();
                        }
                    } catch (IOException unused) {
                        fileOutputStream = openFileOutput;
                        AlibcLogger.e(c, "write object to local file exception");
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                AlibcLogger.e(c, "close file output stream exception: " + e3.getMessage());
                            }
                        }
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e4) {
                                str2 = c;
                                str3 = "close object output stream exception: " + e4.getMessage();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = openFileOutput;
                        try {
                            AlibcLogger.e(c, "Error Exception: " + th.getMessage());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    AlibcLogger.e(c, "close file output stream exception: " + e5.getMessage());
                                }
                            }
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e6) {
                                    str2 = c;
                                    str3 = "close object output stream exception: " + e6.getMessage();
                                }
                            }
                        } catch (Throwable th3) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    AlibcLogger.e(c, "close file output stream exception: " + e7.getMessage());
                                }
                            }
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e8) {
                                    AlibcLogger.e(c, "close object output stream exception: " + e8.getMessage());
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (IOException unused2) {
                    objectOutputStream = null;
                    fileOutputStream = openFileOutput;
                    AlibcLogger.e(c, "write object to local file exception");
                    if (fileOutputStream != null) {
                    }
                    if (objectOutputStream != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    objectOutputStream = null;
                    fileOutputStream = openFileOutput;
                    AlibcLogger.e(c, "Error Exception: " + th.getMessage());
                    if (fileOutputStream != null) {
                    }
                    if (objectOutputStream != null) {
                    }
                }
            } catch (IOException unused3) {
                objectOutputStream = null;
                AlibcLogger.e(c, "write object to local file exception");
                if (fileOutputStream != null) {
                }
                if (objectOutputStream != null) {
                }
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
                AlibcLogger.e(c, "Error Exception: " + th.getMessage());
                if (fileOutputStream != null) {
                }
                if (objectOutputStream != null) {
                }
            }
        }
        AlibcLogger.e(str2, str3);
    }

    public synchronized void addUpdateFilterKeys(String str) {
        this.b.add(str);
    }

    public synchronized Object getConfigValue(String str, String str2, Object obj) {
        Map<String, Object> map = this.a.get(str);
        if (map == null || map.get(str2) == null) {
            return obj;
        }
        return map.get(str2);
    }

    public synchronized Map<String, Object> getGroupConfigMap(String str) {
        return this.a.get(str);
    }

    public synchronized void setConfigValue(String str, String str2, Object obj) {
        Map<String, Object> map = this.a.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.a.put(str, map);
        }
        map.put(str2, obj);
    }

    public synchronized void updateConfig(AlibcConfigAdapter alibcConfigAdapter) {
        Map<String, Map<String, String>> configData = alibcConfigAdapter.getConfigData();
        String str = c;
        StringBuilder sb = new StringBuilder();
        sb.append("config更新，config更新的参数值为:");
        String str2 = null;
        sb.append(configData != null ? configData : null);
        sb.append("   configMem当前值=");
        Map<String, Map<String, Object>> map = this.a;
        if (map == null) {
            map = null;
        }
        sb.append(map);
        sb.append("   filter名单=");
        Set<String> set = this.b;
        sb.append(set != null ? set.toString() : null);
        AlibcLogger.d(str, sb.toString());
        if (configData != null) {
            for (String str3 : configData.keySet()) {
                for (Map.Entry<String, String> entry : configData.get(str3).entrySet()) {
                    if (!this.b.contains(entry.getKey()) || !str3.equals("albbTradeConfig")) {
                        setConfigValue(str3, entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        String str4 = c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("更新后configMemdo=");
        Map<String, Map<String, Object>> map2 = this.a;
        if (map2 != null) {
            str2 = map2.toString();
        }
        sb2.append(str2);
        AlibcLogger.d(str4, sb2.toString());
    }
}
