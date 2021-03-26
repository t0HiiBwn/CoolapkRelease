package com.blankj.utilcode.util;

import com.blankj.utilcode.util.Utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public final class ShellUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    private ShellUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String[] strArr, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(strArr, z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z, z2, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z, z2, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(final String[] strArr, final boolean z, final boolean z2, Utils.Consumer<CommandResult> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<CommandResult> (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<CommandResult>(consumer) {
            /* class com.blankj.utilcode.util.ShellUtils.AnonymousClass1 */

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public CommandResult doInBackground() {
                return ShellUtils.execCmd(strArr, z, z2);
            }
        });
    }

    public static CommandResult execCmd(String str, boolean z) {
        return execCmd(new String[]{str}, z, true);
    }

    public static CommandResult execCmd(List<String> list, boolean z) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static CommandResult execCmd(String[] strArr, boolean z) {
        return execCmd(strArr, z, true);
    }

    public static CommandResult execCmd(String str, boolean z, boolean z2) {
        return execCmd(new String[]{str}, z, z2);
    }

    public static CommandResult execCmd(List<String> list, boolean z, boolean z2) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x00f5 */
    /* JADX DEBUG: Multi-variable search result rejected for r12v4, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r10v3, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r10v9, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r12v6, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r12v11, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r10v24, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r10v25, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r12v12, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r10v26, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r12v15, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r10v31, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r12v17, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0137, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0138, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x013d, code lost:
        r11.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x015e, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x015f, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0168, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0169, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0172, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0173, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0178, code lost:
        r11.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cc, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cd, code lost:
        r0 = null;
        r5 = null;
        r6 = null;
        r3 = r4;
        r12 = r10;
        r10 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00fc, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00fd, code lost:
        r5 = null;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0102, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0103, code lost:
        r12 = null;
        r0 = null;
        r5 = null;
        r6 = null;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0123, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0124, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x012d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x012e, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0133 A[SYNTHETIC, Splitter:B:100:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x015a A[SYNTHETIC, Splitter:B:117:0x015a] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0164 A[SYNTHETIC, Splitter:B:122:0x0164] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x016e A[SYNTHETIC, Splitter:B:127:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fc A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011f A[SYNTHETIC, Splitter:B:90:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0129 A[SYNTHETIC, Splitter:B:95:0x0129] */
    public static CommandResult execCmd(String[] strArr, boolean z, boolean z2) {
        Process process;
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        BufferedReader bufferedReader3;
        Exception e;
        BufferedReader bufferedReader4;
        DataOutputStream dataOutputStream;
        StringBuilder sb3;
        StringBuilder sb4;
        Exception e2;
        String str2 = "";
        int i = -1;
        if (strArr == null || strArr.length == 0) {
            return new CommandResult(-1, str2, str2);
        }
        DataOutputStream dataOutputStream2 = null;
        BufferedReader bufferedReader5 = null;
        dataOutputStream2 = null;
        try {
            process = Runtime.getRuntime().exec(z ? "su" : "sh");
            try {
                dataOutputStream = new DataOutputStream(process.getOutputStream());
            } catch (Exception e3) {
                e = e3;
                bufferedReader3 = null;
                bufferedReader4 = bufferedReader3;
                bufferedReader2 = bufferedReader4;
                bufferedReader = bufferedReader2;
                try {
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (process != null) {
                    }
                    sb2 = bufferedReader3;
                    sb = bufferedReader4;
                    if (sb2 != 0) {
                    }
                    if (sb != 0) {
                    }
                    return new CommandResult(i, str, str2);
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = null;
                bufferedReader = bufferedReader2;
                if (dataOutputStream2 != null) {
                }
                if (bufferedReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                if (process != null) {
                }
                throw th;
            }
            try {
                for (String str3 : strArr) {
                    if (str3 != null) {
                        dataOutputStream.write(str3.getBytes());
                        dataOutputStream.writeBytes(LINE_SEP);
                        dataOutputStream.flush();
                    }
                }
                dataOutputStream.writeBytes("exit" + LINE_SEP);
                dataOutputStream.flush();
                i = process.waitFor();
                if (z2) {
                    sb3 = new StringBuilder();
                    sb4 = new StringBuilder();
                    bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
                    } catch (Exception e4) {
                        e2 = e4;
                        bufferedReader = null;
                        dataOutputStream2 = dataOutputStream;
                        bufferedReader3 = sb3;
                        e = e2;
                        bufferedReader4 = sb4;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        sb2 = bufferedReader3;
                        sb = bufferedReader4;
                        if (sb2 != 0) {
                        }
                        if (sb != 0) {
                        }
                        return new CommandResult(i, str, str2);
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        dataOutputStream2 = dataOutputStream;
                        if (dataOutputStream2 != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        throw th;
                    }
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb3.append(readLine);
                            while (true) {
                                String readLine2 = bufferedReader2.readLine();
                                if (readLine2 == null) {
                                    break;
                                }
                                sb3.append(LINE_SEP);
                                sb3.append(readLine2);
                            }
                        }
                        String readLine3 = bufferedReader.readLine();
                        if (readLine3 != null) {
                            sb4.append(readLine3);
                            while (true) {
                                String readLine4 = bufferedReader.readLine();
                                if (readLine4 == null) {
                                    break;
                                }
                                sb4.append(LINE_SEP);
                                sb4.append(readLine4);
                            }
                        }
                        bufferedReader5 = bufferedReader2;
                        sb2 = sb3;
                        sb = sb4;
                    } catch (Exception e5) {
                        e2 = e5;
                        dataOutputStream2 = dataOutputStream;
                        bufferedReader3 = sb3;
                        e = e2;
                        bufferedReader4 = sb4;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        sb2 = bufferedReader3;
                        sb = bufferedReader4;
                        if (sb2 != 0) {
                        }
                        if (sb != 0) {
                        }
                        return new CommandResult(i, str, str2);
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream2 = dataOutputStream;
                        if (dataOutputStream2 != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        throw th;
                    }
                } else {
                    sb2 = 0;
                    sb = 0;
                    bufferedReader = null;
                }
                try {
                    dataOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                if (bufferedReader5 != null) {
                    try {
                        bufferedReader5.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e9) {
                e2 = e9;
                bufferedReader2 = null;
                bufferedReader = null;
                dataOutputStream2 = dataOutputStream;
                bufferedReader3 = sb3;
                e = e2;
                bufferedReader4 = sb4;
                e.printStackTrace();
                if (dataOutputStream2 != null) {
                }
                if (bufferedReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                if (process != null) {
                }
                sb2 = bufferedReader3;
                sb = bufferedReader4;
                if (sb2 != 0) {
                }
                if (sb != 0) {
                }
                return new CommandResult(i, str, str2);
            } catch (Throwable th6) {
            }
        } catch (Exception e10) {
            e = e10;
            process = null;
            bufferedReader3 = null;
            bufferedReader4 = bufferedReader3;
            bufferedReader2 = bufferedReader4;
            bufferedReader = bufferedReader2;
            e.printStackTrace();
            if (dataOutputStream2 != null) {
            }
            if (bufferedReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            if (process != null) {
            }
            sb2 = bufferedReader3;
            sb = bufferedReader4;
            if (sb2 != 0) {
            }
            if (sb != 0) {
            }
            return new CommandResult(i, str, str2);
        } catch (Throwable th7) {
            th = th7;
            process = null;
            bufferedReader2 = null;
            bufferedReader = bufferedReader2;
            if (dataOutputStream2 != null) {
            }
            if (bufferedReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            if (process != null) {
            }
            throw th;
        }
        if (sb2 != 0) {
            str = str2;
        } else {
            str = sb2.toString();
        }
        if (sb != 0) {
            str2 = sb.toString();
        }
        return new CommandResult(i, str, str2);
    }

    public static class CommandResult {
        public String errorMsg;
        public int result;
        public String successMsg;

        public CommandResult(int i, String str, String str2) {
            this.result = i;
            this.successMsg = str;
            this.errorMsg = str2;
        }

        public String toString() {
            return "result: " + this.result + "\nsuccessMsg: " + this.successMsg + "\nerrorMsg: " + this.errorMsg;
        }
    }
}
