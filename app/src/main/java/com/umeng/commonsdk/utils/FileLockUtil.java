package com.umeng.commonsdk.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockUtil {
    private final Object lockObject = new Object();

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, Object obj) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file.getName(), obj);
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e) {
                            e = e;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Throwable th) {
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        }
        return;
        e.printStackTrace();
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, int i) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file, i);
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e) {
                        try {
                            e.printStackTrace();
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            }
            return;
        }
        return;
        th.printStackTrace();
        return;
        throw th;
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file.getName());
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e) {
                            e = e;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Throwable th) {
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        }
        return;
        e.printStackTrace();
    }

    public void doFileOperateion(String str, FileLockCallback fileLockCallback) {
        File file = new File(str);
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(str);
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file.getName());
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e) {
                            e = e;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Throwable th) {
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        }
        return;
        e.printStackTrace();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022 A[SYNTHETIC, Splitter:B:15:0x0022] */
    private static FileLock getFileLock(String str) {
        FileChannel fileChannel;
        FileNotFoundException e;
        IOException e2;
        try {
            try {
                return new RandomAccessFile(str, "rw").getChannel().lock();
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return null;
            } catch (IOException e5) {
                e2 = e5;
                e2.printStackTrace();
                if (fileChannel != null) {
                }
                return null;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileChannel = null;
            e.printStackTrace();
            if (fileChannel != null) {
            }
            return null;
        } catch (IOException e7) {
            e2 = e7;
            fileChannel = null;
            e2.printStackTrace();
            if (fileChannel != null) {
            }
            return null;
        }
    }
}
