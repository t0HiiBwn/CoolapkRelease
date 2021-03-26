package com.blankj.utilcode.util;

import com.blankj.utilcode.util.Utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
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

    public static CommandResult execCmd(String str, List<String> list, boolean z) {
        return execCmd(new String[]{str}, list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static CommandResult execCmd(List<String> list, boolean z) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static CommandResult execCmd(List<String> list, List<String> list2, boolean z) {
        String[] strArr = null;
        String[] strArr2 = list == null ? null : (String[]) list.toArray(new String[0]);
        if (list2 != null) {
            strArr = (String[]) list2.toArray(new String[0]);
        }
        return execCmd(strArr2, strArr, z, true);
    }

    public static CommandResult execCmd(String[] strArr, boolean z) {
        return execCmd(strArr, z, true);
    }

    public static CommandResult execCmd(String str, boolean z, boolean z2) {
        return execCmd(new String[]{str}, z, z2);
    }

    public static CommandResult execCmd(String str, List<String> list, boolean z, boolean z2) {
        return execCmd(new String[]{str}, list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    public static CommandResult execCmd(String str, String[] strArr, boolean z, boolean z2) {
        return execCmd(new String[]{str}, strArr, z, z2);
    }

    public static CommandResult execCmd(List<String> list, boolean z, boolean z2) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    public static CommandResult execCmd(String[] strArr, boolean z, boolean z2) {
        return execCmd(strArr, (String[]) null, z, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0133, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0134, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0139, code lost:
        r9.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0159, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x015a, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0163, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0164, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x016d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x016e, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0173, code lost:
        r9.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c2, code lost:
        r4 = null;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c9, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ca, code lost:
        r4 = null;
        r5 = null;
        r3 = r10;
        r10 = r8;
        r8 = r11;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f8, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f9, code lost:
        r4 = null;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x011f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0120, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0129, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x012a, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012f A[SYNTHETIC, Splitter:B:100:0x012f] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0155 A[SYNTHETIC, Splitter:B:117:0x0155] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x015f A[SYNTHETIC, Splitter:B:122:0x015f] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0169 A[SYNTHETIC, Splitter:B:127:0x0169] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011b A[SYNTHETIC, Splitter:B:90:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0125 A[SYNTHETIC, Splitter:B:95:0x0125] */
    public static CommandResult execCmd(String[] strArr, String[] strArr2, boolean z, boolean z2) {
        Process process;
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        StringBuilder sb3;
        Exception e;
        DataOutputStream dataOutputStream;
        Exception e2;
        String str2 = "";
        int i = -1;
        if (strArr == null || strArr.length == 0) {
            return new CommandResult(-1, str2, str2);
        }
        DataOutputStream dataOutputStream2 = null;
        BufferedReader bufferedReader3 = null;
        dataOutputStream2 = null;
        try {
            process = Runtime.getRuntime().exec(z ? "su" : "sh", strArr2, (File) null);
            try {
                dataOutputStream = new DataOutputStream(process.getOutputStream());
            } catch (Exception e3) {
                e = e3;
                sb3 = null;
                sb = sb3;
                bufferedReader2 = sb;
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
                    sb2 = sb3;
                    if (sb2 != null) {
                    }
                    if (sb != null) {
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
                    sb2 = new StringBuilder();
                    sb = new StringBuilder();
                    bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
                    } catch (Exception e4) {
                        e2 = e4;
                        bufferedReader = null;
                        dataOutputStream2 = dataOutputStream;
                        sb3 = sb2;
                        e = e2;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        sb2 = sb3;
                        if (sb2 != null) {
                        }
                        if (sb != null) {
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
                            sb2.append(readLine);
                            while (true) {
                                String readLine2 = bufferedReader2.readLine();
                                if (readLine2 == null) {
                                    break;
                                }
                                sb2.append(LINE_SEP);
                                sb2.append(readLine2);
                            }
                        }
                        String readLine3 = bufferedReader.readLine();
                        if (readLine3 != null) {
                            sb.append(readLine3);
                            while (true) {
                                String readLine4 = bufferedReader.readLine();
                                if (readLine4 == null) {
                                    break;
                                }
                                sb.append(LINE_SEP);
                                sb.append(readLine4);
                            }
                        }
                        bufferedReader3 = bufferedReader2;
                    } catch (Exception e5) {
                        e2 = e5;
                        dataOutputStream2 = dataOutputStream;
                        sb3 = sb2;
                        e = e2;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        sb2 = sb3;
                        if (sb2 != null) {
                        }
                        if (sb != null) {
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
                    sb2 = null;
                    sb = null;
                    bufferedReader = null;
                }
                try {
                    dataOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
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
                e = e9;
                sb = null;
                bufferedReader2 = null;
                bufferedReader = null;
                dataOutputStream2 = dataOutputStream;
                sb3 = null;
                e.printStackTrace();
                if (dataOutputStream2 != null) {
                }
                if (bufferedReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                if (process != null) {
                }
                sb2 = sb3;
                if (sb2 != null) {
                }
                if (sb != null) {
                }
                return new CommandResult(i, str, str2);
            } catch (Throwable th6) {
            }
        } catch (Exception e10) {
            e = e10;
            process = null;
            sb3 = null;
            sb = sb3;
            bufferedReader2 = sb;
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
            sb2 = sb3;
            if (sb2 != null) {
            }
            if (sb != null) {
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
        if (sb2 != null) {
            str = str2;
        } else {
            str = sb2.toString();
        }
        if (sb != null) {
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
