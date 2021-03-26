package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.OSSRetryType;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.CheckedInputStream;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    private OkHttpClient client;
    private ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser<T> responseParser;
    private OSSRetryHandler retryHandler;

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser2, ExecutionContext executionContext, int i) {
        this.responseParser = responseParser2;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0185 A[Catch:{ Exception -> 0x02bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01b7 A[Catch:{ Exception -> 0x02bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x030c A[SYNTHETIC, Splitter:B:92:0x030c] */
    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        ClientException clientException;
        Request request;
        Call call;
        ResponseMessage responseMessage;
        OSSRetryType shouldRetry;
        Exception e;
        String str;
        long j;
        String str2;
        FileInputStream fileInputStream;
        long contentLength;
        try {
            if (this.context.getApplicationContext() != null) {
                OSSLog.logInfo(OSSUtils.buildBaseLogInfo(this.context.getApplicationContext()));
            }
            OSSLog.logDebug("[call] - ");
            OSSRequest request2 = this.context.getRequest();
            OSSUtils.ensureRequestValid(request2, this.message);
            OSSUtils.signRequest(this.message);
            if (!this.context.getCancellationHandler().isCancelled()) {
                Request.Builder builder = new Request.Builder();
                if (request2 instanceof ListBucketsRequest) {
                    str = this.message.buildOSSServiceURL();
                } else {
                    str = this.message.buildCanonicalURL();
                }
                Request.Builder url = builder.url(str);
                for (String str3 : this.message.getHeaders().keySet()) {
                    url = url.addHeader(str3, (String) this.message.getHeaders().get(str3));
                }
                String str4 = (String) this.message.getHeaders().get("Content-Type");
                OSSLog.logDebug("request method = " + this.message.getMethod());
                int i = AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[this.message.getMethod().ordinal()];
                if (i == 1 || i == 2) {
                    OSSUtils.assertTrue(str4 != null, "Content type can't be null when upload!");
                    if (this.message.getUploadData() != null) {
                        fileInputStream = new ByteArrayInputStream(this.message.getUploadData());
                        contentLength = (long) this.message.getUploadData().length;
                    } else {
                        if (this.message.getUploadFilePath() != null) {
                            File file = new File(this.message.getUploadFilePath());
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            j = file.length();
                            if (j > 0) {
                                str2 = null;
                                fileInputStream = fileInputStream2;
                            } else {
                                throw new ClientException("the length of file is 0!");
                            }
                        } else if (this.message.getUploadUri() != null) {
                            fileInputStream = this.context.getApplicationContext().getContentResolver().openInputStream(this.message.getUploadUri());
                            contentLength = this.context.getApplicationContext().getContentResolver().openFileDescriptor(this.message.getUploadUri(), "r").getStatSize();
                        } else if (this.message.getContent() != null) {
                            fileInputStream = this.message.getContent();
                            contentLength = this.message.getContentLength();
                        } else {
                            j = 0;
                            str2 = this.message.getStringBody();
                            fileInputStream = null;
                        }
                        if (fileInputStream == null) {
                            if (this.message.isCheckCRC64()) {
                                fileInputStream = new CheckedInputStream(fileInputStream, new CRC64());
                            }
                            this.message.setContent(fileInputStream);
                            this.message.setContentLength(j);
                            url = url.method(this.message.getMethod().toString(), NetworkProgressHelper.addProgressRequestBody(fileInputStream, j, str4, this.context));
                        } else if (str2 != null) {
                            url = url.method(this.message.getMethod().toString(), RequestBody.create(MediaType.parse(str4), str2.getBytes("UTF-8")));
                        } else {
                            url = url.method(this.message.getMethod().toString(), RequestBody.create((MediaType) null, new byte[0]));
                        }
                    }
                    j = contentLength;
                    str2 = null;
                    if (fileInputStream == null) {
                    }
                } else if (i == 3) {
                    url = url.get();
                } else if (i == 4) {
                    url = url.head();
                } else if (i == 5) {
                    url = url.delete();
                }
                request = url.build();
                try {
                    if (request2 instanceof GetObjectRequest) {
                        this.client = NetworkProgressHelper.addProgressResponseListener(this.client, this.context);
                        OSSLog.logDebug("getObject");
                    }
                    call = this.client.newCall(request);
                    try {
                        this.context.getCancellationHandler().setCall(call);
                        Response execute = call.execute();
                        if (OSSLog.isEnableLog()) {
                            Map<String, List<String>> multimap = execute.headers().toMultimap();
                            StringBuilder sb = new StringBuilder();
                            sb.append("response:---------------------\n");
                            sb.append("response code: " + execute.code() + " for url: " + request.url() + "\n");
                            for (String str5 : multimap.keySet()) {
                                sb.append("responseHeader [" + str5 + "]: ");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(multimap.get(str5).get(0));
                                sb2.append("\n");
                                sb.append(sb2.toString());
                            }
                            OSSLog.logDebug(sb.toString());
                        }
                        responseMessage = buildResponseMessage(this.message, execute);
                        clientException = null;
                    } catch (Exception e2) {
                        e = e2;
                        OSSLog.logError("Encounter local execpiton: " + e.toString());
                        if (OSSLog.isEnableLog()) {
                        }
                        clientException = new ClientException(e.getMessage(), e);
                        responseMessage = null;
                        if (clientException != null) {
                        }
                        if (clientException == null) {
                        }
                        clientException = new ClientException("Task is cancelled!", clientException.getCause(), true);
                        shouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
                        OSSLog.logError("[run] - retry, retry type: " + shouldRetry);
                        if (shouldRetry != OSSRetryType.OSSRetryTypeShouldRetry) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    call = null;
                    OSSLog.logError("Encounter local execpiton: " + e.toString());
                    if (OSSLog.isEnableLog()) {
                        e.printStackTrace();
                    }
                    clientException = new ClientException(e.getMessage(), e);
                    responseMessage = null;
                    if (clientException != null) {
                    }
                    if (clientException == null) {
                    }
                    clientException = new ClientException("Task is cancelled!", clientException.getCause(), true);
                    shouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
                    OSSLog.logError("[run] - retry, retry type: " + shouldRetry);
                    if (shouldRetry != OSSRetryType.OSSRetryTypeShouldRetry) {
                    }
                }
                if (clientException != null && (responseMessage.getStatusCode() == 203 || responseMessage.getStatusCode() >= 300)) {
                    clientException = ResponseParsers.parseResponseErrorXML(responseMessage, request.method().equals("HEAD"));
                } else if (clientException == null) {
                    try {
                        T parse = this.responseParser.parse(responseMessage);
                        if (this.context.getCompletedCallback() != null) {
                            this.context.getCompletedCallback().onSuccess(this.context.getRequest(), parse);
                        }
                        return parse;
                    } catch (IOException e4) {
                        clientException = new ClientException(e4.getMessage(), e4);
                    }
                }
                if ((call != null && call.isCanceled()) || this.context.getCancellationHandler().isCancelled()) {
                    clientException = new ClientException("Task is cancelled!", clientException.getCause(), true);
                }
                shouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
                OSSLog.logError("[run] - retry, retry type: " + shouldRetry);
                if (shouldRetry != OSSRetryType.OSSRetryTypeShouldRetry) {
                    this.currentRetryCount++;
                    if (this.context.getRetryCallback() != null) {
                        this.context.getRetryCallback().onRetryCallback();
                    }
                    try {
                        Thread.sleep(this.retryHandler.timeInterval(this.currentRetryCount, shouldRetry));
                    } catch (InterruptedException e5) {
                        Thread.currentThread().interrupt();
                        e5.printStackTrace();
                    }
                    return call();
                } else if (shouldRetry == OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry) {
                    if (responseMessage != null) {
                        String str6 = (String) responseMessage.getHeaders().get("Date");
                        try {
                            DateUtil.setCurrentServerTime(DateUtil.parseRfc822Date(str6).getTime());
                            this.message.getHeaders().put("Date", str6);
                        } catch (Exception unused) {
                            OSSLog.logError("[error] - synchronize time, reponseDate:" + str6);
                        }
                    }
                    this.currentRetryCount++;
                    if (this.context.getRetryCallback() != null) {
                        this.context.getRetryCallback().onRetryCallback();
                    }
                    return call();
                } else {
                    if (clientException instanceof ClientException) {
                        if (this.context.getCompletedCallback() != null) {
                            this.context.getCompletedCallback().onFailure(this.context.getRequest(), clientException, null);
                        }
                    } else if (this.context.getCompletedCallback() != null) {
                        this.context.getCompletedCallback().onFailure(this.context.getRequest(), null, (ServiceException) clientException);
                    }
                    throw clientException;
                }
            } else {
                throw new InterruptedIOException("This task is cancelled!");
            }
        } catch (Exception e6) {
            e = e6;
            call = null;
            request = null;
            OSSLog.logError("Encounter local execpiton: " + e.toString());
            if (OSSLog.isEnableLog()) {
            }
            clientException = new ClientException(e.getMessage(), e);
            responseMessage = null;
            if (clientException != null) {
            }
            if (clientException == null) {
            }
            clientException = new ClientException("Task is cancelled!", clientException.getCause(), true);
            shouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
            OSSLog.logError("[run] - retry, retry type: " + shouldRetry);
            if (shouldRetry != OSSRetryType.OSSRetryTypeShouldRetry) {
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.network.OSSRequestTask$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.GET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.HEAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private ResponseMessage buildResponseMessage(RequestMessage requestMessage, Response response) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequest(requestMessage);
        responseMessage.setResponse(response);
        HashMap hashMap = new HashMap();
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            hashMap.put(headers.name(i), headers.value(i));
        }
        responseMessage.setHeaders(hashMap);
        responseMessage.setStatusCode(response.code());
        responseMessage.setContentLength(response.body().contentLength());
        responseMessage.setContent(response.body().byteStream());
        return responseMessage;
    }
}
