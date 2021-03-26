package com.ali.auth.third.core.message;

import android.content.Context;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.ResourceUtils;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MessageUtils {
    private static Map<Integer, Message> a = new HashMap();
    private static ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final Message c;
    private static final Message d;
    private static Message e;
    private static Message f;
    private static final Object g = new Object();

    static {
        Message message = new Message();
        c = message;
        message.code = 1;
        message.message = "未在消息文件中找到 id 为 {0} 的消息";
        message.action = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        message.type = "E";
        Message message2 = new Message();
        d = message2;
        message2.code = 2;
        message2.message = "检索消息时发生如下错误 {0}";
        message2.action = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        message2.type = "E";
    }

    private static Message a(int i) {
        if (e == null) {
            synchronized (g) {
                if (e == null) {
                    Message b2 = b(1);
                    e = b2;
                    if (b2 == null) {
                        e = c;
                    }
                }
            }
        }
        try {
            Message message = (Message) e.clone();
            message.message = MessageFormat.format(message.message, String.valueOf(i));
            return message;
        } catch (CloneNotSupportedException unused) {
            return e;
        }
    }

    private static Message a(String str) {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    Message b2 = b(2);
                    f = b2;
                    if (b2 == null) {
                        f = d;
                    }
                }
            }
        }
        try {
            Message message = (Message) f.clone();
            message.message = MessageFormat.format(message.message, str);
            return message;
        } catch (CloneNotSupportedException unused) {
            return f;
        }
    }

    private static Message b(int i) {
        String str;
        String str2;
        try {
            Context applicationContext = KernelContext.getApplicationContext();
            if (ResourceUtils.getIdentifier(applicationContext, "string", "auth_sdk_message_" + i + "_message") == 0) {
                return null;
            }
            Message message = new Message();
            message.code = i;
            Context applicationContext2 = KernelContext.getApplicationContext();
            message.message = ResourceUtils.getString(applicationContext2, "auth_sdk_message_" + i + "_message");
            Context applicationContext3 = KernelContext.getApplicationContext();
            if (ResourceUtils.getIdentifier(applicationContext3, "string", "auth_sdk_message_" + i + "_action") != 0) {
                Context applicationContext4 = KernelContext.getApplicationContext();
                str = ResourceUtils.getString(applicationContext4, "auth_sdk_message_" + i + "_action");
            } else {
                str = "";
            }
            message.action = str;
            Context applicationContext5 = KernelContext.getApplicationContext();
            if (ResourceUtils.getIdentifier(applicationContext5, "string", "auth_sdk_message_" + i + "_type") != 0) {
                Context applicationContext6 = KernelContext.getApplicationContext();
                str2 = ResourceUtils.getString(applicationContext6, "auth_sdk_message_" + i + "_type");
            } else {
                str2 = "I";
            }
            message.type = str2;
            return message;
        } catch (Exception e2) {
            SDKLogger.e("kernel", "Fail to get message of the code " + i + ", the error message is " + e2.getMessage());
            return null;
        }
    }

    public static Message createMessage(int i, Object... objArr) {
        try {
            b.readLock().lock();
            Message message = a.get(Integer.valueOf(i));
            if (message == null) {
                b.readLock().unlock();
                b.writeLock().lock();
                try {
                    message = b(i);
                    if (message != null) {
                        a.put(Integer.valueOf(i), message);
                    }
                    b.readLock().lock();
                } finally {
                    b.writeLock().unlock();
                }
            }
            if (message == null) {
                try {
                    return a(i);
                } finally {
                    b.readLock().unlock();
                }
            } else if (objArr.length == 0) {
                b.readLock().unlock();
                return message;
            } else {
                Message message2 = (Message) message.clone();
                message2.message = MessageFormat.format(message.message, objArr);
                b.readLock().unlock();
                return message2;
            }
        } catch (Exception e2) {
            return a(e2.getMessage());
        }
    }

    public static String getMessageContent(int i, Object... objArr) {
        try {
            b.readLock().lock();
            Message message = a.get(Integer.valueOf(i));
            if (message == null) {
                b.readLock().unlock();
                b.writeLock().lock();
                try {
                    message = b(i);
                    if (message != null) {
                        a.put(Integer.valueOf(i), message);
                    }
                    b.readLock().lock();
                } finally {
                    b.writeLock().unlock();
                }
            }
            if (message == null) {
                try {
                    return a(i).message;
                } finally {
                    b.readLock().unlock();
                }
            } else {
                String format = MessageFormat.format(message.message, objArr);
                b.readLock().unlock();
                return format;
            }
        } catch (Exception e2) {
            return a(e2.getMessage()).message;
        }
    }
}
