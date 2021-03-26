package com.umeng.commonsdk.internal.utils;

import android.os.Process;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* compiled from: ProcessUtil */
public class g {
    private static final String a = "\n";
    private static final byte[] b = "\nexit\n".getBytes();
    private static byte[] c = new byte[32];

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:? */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v13, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v21, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v22, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v23, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r4v24, resolved type: java.io.InputStreamReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r9 != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        c(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006e, code lost:
        r0 = th;
        r4 = r4;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0074, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00cc, code lost:
        if (r9 != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00d9, code lost:
        if (r9 != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00dc, code lost:
        if (r7 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00de, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00e3, code lost:
        return r7.toString();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    public static String a(String... strArr) {
        StringBuilder sb;
        Process process;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        InputStream inputStream2;
        OutputStream outputStream;
        InputStream inputStream3;
        InputStream inputStream4;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        Throwable th;
        try {
            process = new ProcessBuilder(new String[0]).command(strArr).start();
            try {
                outputStream = process.getOutputStream();
                try {
                    inputStream2 = process.getInputStream();
                    try {
                        inputStream = process.getErrorStream();
                        try {
                            outputStream.write(b);
                            outputStream.flush();
                            process.waitFor();
                            inputStreamReader = new InputStreamReader(inputStream2);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                            } catch (IOException unused) {
                                bufferedReader = 0;
                                inputStreamReader = inputStreamReader;
                                sb = bufferedReader;
                                a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                            } catch (Exception unused2) {
                                bufferedReader = 0;
                                inputStreamReader = inputStreamReader;
                                sb = bufferedReader;
                                a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                            } catch (Throwable th2) {
                                bufferedReader2 = null;
                                th = th2;
                                inputStreamReader2 = inputStreamReader;
                                a(outputStream, inputStream, inputStream2, inputStreamReader2, bufferedReader2);
                                if (process != null) {
                                }
                                throw th;
                            }
                        } catch (IOException unused3) {
                            inputStream3 = null;
                            bufferedReader = inputStream3;
                            inputStreamReader = inputStream3;
                            sb = bufferedReader;
                            a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                        } catch (Exception unused4) {
                            inputStream4 = null;
                            bufferedReader = inputStream4;
                            inputStreamReader = inputStream4;
                            sb = bufferedReader;
                            a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                        } catch (Throwable th3) {
                            bufferedReader2 = null;
                            th = th3;
                            inputStreamReader2 = null;
                            a(outputStream, inputStream, inputStream2, inputStreamReader2, bufferedReader2);
                            if (process != null) {
                            }
                            throw th;
                        }
                    } catch (IOException unused5) {
                        inputStream = null;
                        inputStream3 = inputStream;
                        bufferedReader = inputStream3;
                        inputStreamReader = inputStream3;
                        sb = bufferedReader;
                        a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                    } catch (Exception unused6) {
                        inputStream = null;
                        inputStream4 = inputStream;
                        bufferedReader = inputStream4;
                        inputStreamReader = inputStream4;
                        sb = bufferedReader;
                        a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                    } catch (Throwable th4) {
                        inputStreamReader2 = null;
                        bufferedReader2 = null;
                        th = th4;
                        inputStream = null;
                        a(outputStream, inputStream, inputStream2, inputStreamReader2, bufferedReader2);
                        if (process != null) {
                        }
                        throw th;
                    }
                } catch (IOException unused7) {
                    inputStream2 = null;
                    inputStream = inputStream2;
                    inputStream3 = inputStream;
                    bufferedReader = inputStream3;
                    inputStreamReader = inputStream3;
                    sb = bufferedReader;
                    a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                } catch (Exception unused8) {
                    inputStream2 = null;
                    inputStream = inputStream2;
                    inputStream4 = inputStream;
                    bufferedReader = inputStream4;
                    inputStreamReader = inputStream4;
                    sb = bufferedReader;
                    a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                } catch (Throwable th5) {
                    inputStream = null;
                    inputStreamReader2 = null;
                    bufferedReader2 = null;
                    th = th5;
                    inputStream2 = null;
                    a(outputStream, inputStream, inputStream2, inputStreamReader2, bufferedReader2);
                    if (process != null) {
                        c(process);
                    }
                    throw th;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb = new StringBuilder();
                        sb.append(readLine);
                        sb.append(a);
                        while (true) {
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 == null) {
                                break;
                            }
                            sb.append(readLine2);
                            sb.append(a);
                        }
                    } else {
                        sb = null;
                    }
                    do {
                    } while (inputStream.read(c) > 0);
                    a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                } catch (IOException unused9) {
                    a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                } catch (Exception unused10) {
                    a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
                } catch (Throwable th6) {
                }
            } catch (IOException unused11) {
                outputStream = null;
                inputStream2 = outputStream;
                inputStream = inputStream2;
                inputStream3 = inputStream;
                bufferedReader = inputStream3;
                inputStreamReader = inputStream3;
                sb = bufferedReader;
                a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
            } catch (Exception unused12) {
                outputStream = null;
                inputStream2 = outputStream;
                inputStream = inputStream2;
                inputStream4 = inputStream;
                bufferedReader = inputStream4;
                inputStreamReader = inputStream4;
                sb = bufferedReader;
                a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
            } catch (Throwable th7) {
                inputStream2 = null;
                inputStream = null;
                inputStreamReader2 = null;
                bufferedReader2 = null;
                th = th7;
                outputStream = null;
                a(outputStream, inputStream, inputStream2, inputStreamReader2, bufferedReader2);
                if (process != null) {
                }
                throw th;
            }
        } catch (IOException unused13) {
            process = null;
            outputStream = null;
            inputStream2 = outputStream;
            inputStream = inputStream2;
            inputStream3 = inputStream;
            bufferedReader = inputStream3;
            inputStreamReader = inputStream3;
            sb = bufferedReader;
            a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
        } catch (Exception unused14) {
            process = null;
            outputStream = null;
            inputStream2 = outputStream;
            inputStream = inputStream2;
            inputStream4 = inputStream;
            bufferedReader = inputStream4;
            inputStreamReader = inputStream4;
            sb = bufferedReader;
            a(outputStream, inputStream, inputStream2, inputStreamReader, bufferedReader);
        } catch (Throwable th8) {
            outputStream = null;
            inputStream2 = null;
            inputStream = null;
            inputStreamReader2 = null;
            bufferedReader2 = null;
            th = th8;
            process = null;
            a(outputStream, inputStream, inputStream2, inputStreamReader2, bufferedReader2);
            if (process != null) {
            }
            throw th;
        }
    }

    private static void a(OutputStream outputStream, InputStream inputStream, InputStream inputStream2, InputStreamReader inputStreamReader, BufferedReader bufferedReader) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused3) {
            }
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException unused4) {
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
        }
    }

    private static void a(Process process) {
        int b2 = b(process);
        if (b2 != 0) {
            try {
                Process.killProcess(b2);
            } catch (Exception unused) {
                try {
                    process.destroy();
                } catch (Exception unused2) {
                }
            }
        }
    }

    private static int b(Process process) {
        String obj = process.toString();
        try {
            return Integer.parseInt(obj.substring(obj.indexOf("=") + 1, obj.indexOf("]")));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static void c(Process process) {
        if (process != null) {
            try {
                if (process.exitValue() != 0) {
                    a(process);
                }
            } catch (IllegalThreadStateException unused) {
                a(process);
            }
        }
    }
}
