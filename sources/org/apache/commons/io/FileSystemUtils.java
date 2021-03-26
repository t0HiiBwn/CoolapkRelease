package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

@Deprecated
public class FileSystemUtils {
    private static final String DF;
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        int i;
        String str = "df";
        try {
            String property = System.getProperty("os.name");
            if (property != null) {
                String lowerCase = property.toLowerCase(Locale.ENGLISH);
                i = 3;
                if (lowerCase.contains("windows")) {
                    i = 1;
                } else {
                    if (!lowerCase.contains("linux") && !lowerCase.contains("mpe/ix") && !lowerCase.contains("freebsd") && !lowerCase.contains("openbsd") && !lowerCase.contains("irix") && !lowerCase.contains("digital unix") && !lowerCase.contains("unix")) {
                        if (!lowerCase.contains("mac os x")) {
                            if (!lowerCase.contains("sun os") && !lowerCase.contains("sunos")) {
                                if (!lowerCase.contains("solaris")) {
                                    if (!lowerCase.contains("hp-ux")) {
                                        if (!lowerCase.contains("aix")) {
                                            i = 0;
                                        }
                                    }
                                }
                            }
                            str = "/usr/xpg4/bin/df";
                        }
                    }
                    i = 2;
                }
                OS = i;
                DF = str;
                return;
            }
            throw new IOException("os.name not found");
        } catch (Exception unused) {
            i = -1;
        }
    }

    @Deprecated
    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, false, -1);
    }

    @Deprecated
    public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1);
    }

    @Deprecated
    public static long freeSpaceKb(long j) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), j);
    }

    @Deprecated
    public static long freeSpaceKb(String str) throws IOException {
        return freeSpaceKb(str, -1);
    }

    @Deprecated
    public static long freeSpaceKb(String str, long j) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, true, j);
    }

    long freeSpaceOS(String str, int i, boolean z, long j) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be null");
        } else if (i == 0) {
            throw new IllegalStateException("Unsupported operating system");
        } else if (i == 1) {
            long freeSpaceWindows = freeSpaceWindows(str, j);
            return z ? freeSpaceWindows / 1024 : freeSpaceWindows;
        } else if (i == 2) {
            return freeSpaceUnix(str, z, false, j);
        } else {
            if (i == 3) {
                return freeSpaceUnix(str, z, true, j);
            }
            throw new IllegalStateException("Exception caught when determining operating system");
        }
    }

    long freeSpaceUnix(String str, boolean z, boolean z2, long j) throws IOException {
        if (!str.isEmpty()) {
            String str2 = "-";
            if (z) {
                str2 = str2 + "k";
            }
            if (z2) {
                str2 = str2 + "P";
            }
            List<String> performCommand = performCommand(str2.length() > 1 ? new String[]{DF, str2, str} : new String[]{DF, str}, 3, j);
            if (performCommand.size() >= 2) {
                StringTokenizer stringTokenizer = new StringTokenizer(performCommand.get(1), " ");
                if (stringTokenizer.countTokens() >= 4) {
                    stringTokenizer.nextToken();
                } else if (stringTokenizer.countTokens() != 1 || performCommand.size() < 3) {
                    throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + str + "'- check path is valid");
                } else {
                    stringTokenizer = new StringTokenizer(performCommand.get(2), " ");
                }
                stringTokenizer.nextToken();
                stringTokenizer.nextToken();
                return parseBytes(stringTokenizer.nextToken(), str);
            }
            throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + str + "'- response was " + performCommand);
        }
        throw new IllegalArgumentException("Path must not be empty");
    }

    long freeSpaceWindows(String str, long j) throws IOException {
        String normalize = FilenameUtils.normalize(str, false);
        if (normalize != null) {
            if (normalize.length() > 0 && normalize.charAt(0) != '\"') {
                normalize = "\"" + normalize + "\"";
            }
            List<String> performCommand = performCommand(new String[]{"cmd.exe", "/C", "dir /a /-c " + normalize}, Integer.MAX_VALUE, j);
            for (int size = performCommand.size() - 1; size >= 0; size--) {
                String str2 = performCommand.get(size);
                if (str2.length() > 0) {
                    return parseDir(str2, normalize);
                }
            }
            throw new IOException("Command line 'dir /-c' did not return any info for path '" + normalize + "'");
        }
        throw new IllegalArgumentException(str);
    }

    Process openProcess(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }

    long parseBytes(String str, String str2) throws IOException {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e) {
            throw new IOException("Command line '" + DF + "' did not return numeric data as expected for path '" + str2 + "'- check path is valid", e);
        }
    }

    long parseDir(String str, String str2) throws IOException {
        int i;
        int i2;
        int i3;
        int length = str.length();
        while (true) {
            length--;
            i = 0;
            if (length < 0) {
                i2 = 0;
                break;
            } else if (Character.isDigit(str.charAt(length))) {
                i2 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i3 = 0;
                break;
            }
            char charAt = str.charAt(length);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i3 = length + 1;
                break;
            }
            length--;
        }
        if (length >= 0) {
            StringBuilder sb = new StringBuilder(str.substring(i3, i2));
            while (i < sb.length()) {
                if (sb.charAt(i) == ',' || sb.charAt(i) == '.') {
                    sb.deleteCharAt(i);
                    i--;
                }
                i++;
            }
            return parseBytes(sb.toString(), str2);
        }
        throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012d  */
    /* JADX WARNING: Unknown variable types count: 2 */
    List<String> performCommand(String[] strArr, int i, long j) throws IOException {
        Throwable th;
        ?? r7;
        InputStream inputStream;
        OutputStream outputStream;
        Process process;
        InputStream inputStream2;
        InputStream inputStream3;
        InterruptedException e;
        InputStream inputStream4;
        InputStream inputStream5;
        ?? bufferedReader;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream6 = null;
        try {
            Thread start = ThreadMonitor.start(j);
            process = openProcess(strArr);
            try {
                inputStream3 = process.getInputStream();
                try {
                    outputStream = process.getOutputStream();
                    try {
                        inputStream = process.getErrorStream();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream3, Charset.defaultCharset()));
                        } catch (InterruptedException e2) {
                            e = e2;
                            inputStream5 = null;
                            inputStream6 = process;
                            inputStream4 = inputStream5;
                            try {
                                throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                            } catch (Throwable th2) {
                                th = th2;
                                process = inputStream6;
                                inputStream2 = inputStream4;
                                inputStream6 = inputStream3;
                                r7 = inputStream2;
                                IOUtils.closeQuietly(inputStream6);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly((Reader) r7);
                                if (process != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream2 = null;
                            inputStream6 = inputStream3;
                            r7 = inputStream2;
                            IOUtils.closeQuietly(inputStream6);
                            IOUtils.closeQuietly(outputStream);
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly((Reader) r7);
                            if (process != null) {
                            }
                            throw th;
                        }
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null && arrayList.size() < i; readLine = bufferedReader.readLine()) {
                                arrayList.add(readLine.toLowerCase(Locale.ENGLISH).trim());
                            }
                            process.waitFor();
                            ThreadMonitor.stop(start);
                            if (process.exitValue() != 0) {
                                throw new IOException("Command line returned OS error code '" + process.exitValue() + "' for command " + Arrays.asList(strArr));
                            } else if (!arrayList.isEmpty()) {
                                bufferedReader.close();
                                inputStream3.close();
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                        outputStream = null;
                                    } catch (InterruptedException e3) {
                                        e = e3;
                                        inputStream3 = null;
                                        inputStream5 = null;
                                        inputStream6 = process;
                                        inputStream4 = inputStream5;
                                        throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        r7 = 0;
                                        IOUtils.closeQuietly(inputStream6);
                                        IOUtils.closeQuietly(outputStream);
                                        IOUtils.closeQuietly(inputStream);
                                        IOUtils.closeQuietly((Reader) r7);
                                        if (process != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                IOUtils.closeQuietly((InputStream) null);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly((Reader) null);
                                if (process != null) {
                                    process.destroy();
                                }
                                return arrayList;
                            } else {
                                throw new IOException("Command line did not return any info for command " + Arrays.asList(strArr));
                            }
                        } catch (InterruptedException e4) {
                            e = e4;
                            inputStream5 = bufferedReader;
                            inputStream6 = process;
                            inputStream4 = inputStream5;
                            throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream2 = bufferedReader;
                            inputStream6 = inputStream3;
                            r7 = inputStream2;
                            IOUtils.closeQuietly(inputStream6);
                            IOUtils.closeQuietly(outputStream);
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly((Reader) r7);
                            if (process != null) {
                            }
                            throw th;
                        }
                    } catch (InterruptedException e5) {
                        e = e5;
                        inputStream = null;
                        inputStream5 = inputStream;
                        inputStream6 = process;
                        inputStream4 = inputStream5;
                        throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                        inputStream2 = inputStream;
                        inputStream6 = inputStream3;
                        r7 = inputStream2;
                        IOUtils.closeQuietly(inputStream6);
                        IOUtils.closeQuietly(outputStream);
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly((Reader) r7);
                        if (process != null) {
                        }
                        throw th;
                    }
                } catch (InterruptedException e6) {
                    e = e6;
                    outputStream = null;
                    inputStream = outputStream;
                    inputStream5 = inputStream;
                    inputStream6 = process;
                    inputStream4 = inputStream5;
                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
                } catch (Throwable th7) {
                    th = th7;
                    outputStream = null;
                    inputStream = null;
                    inputStream2 = inputStream;
                    inputStream6 = inputStream3;
                    r7 = inputStream2;
                    IOUtils.closeQuietly(inputStream6);
                    IOUtils.closeQuietly(outputStream);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((Reader) r7);
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (InterruptedException e7) {
                e = e7;
                inputStream3 = null;
                outputStream = null;
                inputStream = outputStream;
                inputStream5 = inputStream;
                inputStream6 = process;
                inputStream4 = inputStream5;
                throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
            } catch (Throwable th8) {
                th = th8;
                outputStream = null;
                inputStream = outputStream;
                r7 = inputStream;
                IOUtils.closeQuietly(inputStream6);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((Reader) r7);
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (InterruptedException e8) {
            e = e8;
            inputStream3 = null;
            outputStream = null;
            inputStream = null;
            inputStream4 = null;
            throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j, e);
        } catch (Throwable th9) {
            th = th9;
            process = null;
            outputStream = null;
            inputStream = outputStream;
            r7 = inputStream;
            IOUtils.closeQuietly(inputStream6);
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly((Reader) r7);
            if (process != null) {
            }
            throw th;
        }
    }
}
