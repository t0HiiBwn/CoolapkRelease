package mtopsdk.mtop.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import mtopsdk.common.util.StringUtils;

public class ErrorConstant {
    public static final String ERRCODE_ANDROID_SYS_LOGIN_CANCEL = "ANDROID_SYS_LOGIN_CANCEL";
    public static final String ERRCODE_ANDROID_SYS_LOGIN_FAIL = "ANDROID_SYS_LOGIN_FAIL";
    public static final String ERRCODE_API_41X_ANTI_ATTACK = "ANDROID_SYS_API_41X_ANTI_ATTACK";
    public static final String ERRCODE_API_FLOW_LIMIT_LOCKED = "ANDROID_SYS_API_FLOW_LIMIT_LOCKED";
    public static final String ERRCODE_BUILD_PROTOCOL_PARAMS_ERROR = "ANDROID_SYS_BUILD_PROTOCOL_PARAMS_ERROR";
    public static final String ERRCODE_FAIL_SYS_ACCESS_TOKEN_EXPIRED = "FAIL_SYS_ACCESS_TOKEN_EXPIRED";
    public static final String ERRCODE_FAIL_SYS_ILLEGAL_ACCESS_TOKEN = "FAIL_SYS_ILLEGAL_ACCESS_TOKEN";
    public static final String ERRCODE_FAIL_SYS_REQUEST_QUEUED = "FAIL_SYS_REQUEST_QUEUED";
    public static final String ERRCODE_FAIL_SYS_SESSION_EXPIRED = "FAIL_SYS_SESSION_EXPIRED";
    public static final String ERRCODE_GENERATE_MTOP_SIGN_ERROR = "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR";
    public static final String ERRCODE_ILLEGAL_JSPARAM_ERROR = "ANDROID_SYS_ILLEGAL_JSPARAM_ERROR";
    public static final String ERRCODE_INIT_MTOP_ISIGN_ERROR = "ANDROID_SYS_INIT_MTOP_ISIGN_ERROR";
    public static final String ERRCODE_JSONDATA_BLANK = "ANDROID_SYS_JSONDATA_BLANK";
    public static final String ERRCODE_JSONDATA_PARSE_ERROR = "ANDROID_SYS_JSONDATA_PARSE_ERROR";
    public static final String ERRCODE_MTOPCONTEXT_INIT_ERROR = "ANDROID_SYS_MTOPCONTEXT_INIT_ERROR";
    public static final String ERRCODE_MTOPSDK_INIT_ERROR = "ANDROID_SYS_MTOPSDK_INIT_ERROR";
    public static final String ERRCODE_MTOP_APICALL_ASYNC_TIMEOUT = "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT";
    public static final String ERRCODE_MTOP_MISS_CALL_FACTORY = "ANDROID_SYS_MTOP_MISS_CALL_FACTORY";
    public static final String ERRCODE_NETWORK_ERROR = "ANDROID_SYS_NETWORK_ERROR";
    public static final String ERRCODE_NETWORK_REQUEST_CONVERT_ERROR = "ANDROID_SYS_NETWORK_REQUEST_CONVERT_ERROR";
    public static final String ERRCODE_NO_NETWORK = "ANDROID_SYS_NO_NETWORK";
    public static final String ERRCODE_PARSE_JSPARAM_ERROR = "ANDROID_SYS_PARSE_JSPARAM_ERROR";
    public static final String ERRCODE_SUCCESS = "SUCCESS";
    @Deprecated
    public static final String ERRCODE_SYSTEM_ERROR = "SYSTEM_ERROR";
    public static final String ERRMSG_ANDROID_SYS_LOGIN_CANCEL = "登录被取消";
    public static final String ERRMSG_ANDROID_SYS_LOGIN_FAIL = "登录失败";
    public static final String ERRMSG_API_41X_ANTI_ATTACK = "哎哟喂,被挤爆啦,请稍后重试(419)!";
    public static final String ERRMSG_API_FLOW_LIMIT_LOCKED = "哎哟喂,被挤爆啦,请稍后重试(420)";
    public static final String ERRMSG_BUILD_PROTOCOL_PARAMS_ERROR = "组装MTOP协议参数错误";
    public static final String ERRMSG_FAIL_SYS_SESSION_EXPIRED = "Session过期";
    public static final String ERRMSG_GENERATE_MTOP_SIGN_ERROR = "生成Mtop签名sign失败";
    public static final String ERRMSG_ILLEGAL_JSPARAM_ERROR = "MTOP JSBridge 参数错误";
    public static final String ERRMSG_INIT_MTOP_ISIGN_ERROR = "初始化Mtop签名类ISign失败";
    public static final String ERRMSG_JSONDATA_BLANK = "返回JSONDATA为空";
    public static final String ERRMSG_JSONDATA_PARSE_ERROR = "解析JSONDATA错误";
    public static final String ERRMSG_MTOPCONTEXT_INIT_ERROR = "MTOPCONTEXT初始化错误";
    public static final String ERRMSG_MTOPSDK_INIT_ERROR = "MTOPSDK初始化失败";
    public static final String ERRMSG_MTOP_APICALL_ASYNC_TIMEOUT = "MTOP异步调用超时";
    public static final String ERRMSG_MTOP_MISS_CALL_FACTORY = "Mtop实例没有设置Call Factory";
    public static final String ERRMSG_NETWORK_ERROR = "网络错误";
    public static final String ERRMSG_NETWORK_REQUEST_CONVERT_ERROR = "网络Request转换失败";
    public static final String ERRMSG_NO_NETWORK = "无网络";
    public static final String ERRMSG_PARSE_JSPARAM_ERROR = "MTOP JSBridge 参数解析错误";
    @Deprecated
    public static final int INT_ANDROID_SYS_ERROR = -2500;
    @Deprecated
    public static final int INT_ERRCODE_SUCCESS = -1001;
    public static final int INT_ERR_SID_INVALID = -2005;
    @Deprecated
    public static final int INT_UNKNOWN_ERROR = -1000;
    public static final String MAPPING_CODE_GENERATE_MTOP_SIGN_ERROR = "EC40002";
    @Deprecated
    public static final String RET_MSG_OFFLINE_SUCCESS = "离线调用成功";
    public static final String UNKNOWN_CLIENT_MAPPING_CODE_SUFFIX = "EC00000";
    public static final String UNKNOWN_SERVER_MAPPING_CODE_SUFFIX = "ES00000";
    public static final String UNKNOWN_SERVICE_PROVIDER_MAPPING_CODE_SUFFIX = "TERR00000";
    private static HashMap<String, String> a = new HashMap<>(128);
    private static HashMap<String, String> b = new HashMap<>(24);
    private static HashMap<String, String> c;

    public interface ErrorMappingType {
        public static final String FLOW_LIMIT_ERROR_MAPPING = "FLOW_LIMIT_ERROR_MAPPING";
        public static final String NETWORK_ERROR_MAPPING = "NETWORK_ERROR_MAPPING";
        public static final String SERVICE_ERROR_MAPPING = "SERVICE_ERROR_MAPPING";

        @Retention(RetentionPolicy.SOURCE)
        public @interface Definition {
        }
    }

    public interface MappingMsg {
        public static final String FLOW_LIMIT_MAPPING_MSG = "前方拥挤，亲稍等再试试";
        public static final String NETWORK_MAPPING_MSG = "网络竟然崩溃了";
        public static final String SERVICE_MAPPING_MSG = "服务竟然出错了";

        @Retention(RetentionPolicy.SOURCE)
        public @interface Definition {
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>(64);
        c = hashMap;
        hashMap.put("FAIL_SYS_API_STOP_SERVICE", "ES10000");
        c.put("FAIL_SYS_SM_ODD_REQUEST", "ES10001");
        c.put("FAIL_SYS_API_NOT_FOUNDED", "ES10002");
        c.put("FAIL_SYS_SESSION_EXPIRED", "ES10003");
        c.put("FAIL_SYS_SYSTEM_BUSY_ERROR", "ES10004");
        c.put("FAIL_SYS_SERVLET_ASYNC_START_FAIL", "ES10005");
        c.put("FAIL_SYS_FLOWLIMIT", "ES10006");
        c.put("FAIL_SYS_API_UNAUTHORIZED", "ES10007");
        c.put("FAIL_SYS_PROTOPARAM_MISSED", "ES10008");
        c.put("FAIL_SYS_PROTOVER_MISSED", "ES10009");
        c.put("FAIL_SYS_REQUEST_EXPIRED", "ES10010");
        c.put("FAIL_SYS_ILEGEL_SIGN", "ES10011");
        c.put("FAIL_SYS_INVALID_HTTP_METHOD", "ES10012");
        c.put("FAIL_SYS_BADARGUMENT_T", "ES10013");
        c.put("FAIL_SYS_UNKNOWN_APP", "ES10014");
        c.put("FAIL_SYS_INTERNAL_FAULT", "ES10015");
        c.put("FAIL_SYS_TRAFFIC_LIMIT", "ES10016");
        c.put("FAIL_SYS_BIZPARAM_TYPE_ERROR", "ES10017");
        c.put("FAIL_SYS_BIZPARAM_MISSED", "ES10018");
        c.put("FAIL_SYS_TOPAUTHPARAM_MISSED", "ES10019");
        c.put("FAIL_SYS_TOPAUTH_FAILED", "ES10020");
        c.put("FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR", "ES10021");
        c.put("FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR", "ES10022");
        c.put("FAIL_SYS_TOPUNAUTHAPI_ERROR", "ES10023");
        c.put("FAIL_SYS_TOPAUTH_FAULT", "ES10024");
        c.put("FAIL_SYS_RETMISSED_ERROR", "ES10025");
        c.put("FAIL_SYS_PARAMINVALID_ERROR", "ES10026");
        c.put("SYSTEM_ERROR", "ES10027");
        c.put("FAIL_SYS_UNAUTHORIZED_ENTRANCE", "ES10028");
        c.put("FAIL_SYS_SESSION_ERROR", "ES10029");
        c.put("FAIL_SYS_MT_ODD_REQUEST", "ES10030");
        c.put("FAIL_SYS_EXPIRED_REQUEST", "ES10031");
        c.put("FAIL_SYS_PORTOCOLPARAM_INVALID", "ES10032");
        c.put("FAIL_SYS_INVALID_PROTOCOLVERSION", "ES10033");
        c.put("FAIL_SYS_PARAM_MISSING", "ES10035");
        c.put("FAIL_SYS_PARAM_FORMAT_ERROR", "ES10036");
        c.put("FAIL_SYS_ILLEGAL_ARGUMENT_TTID", "ES10034");
        c.put("FAIL_SYS_ILLEGAL_ACCESS_TOKEN", "ES10037");
        c.put("FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE", "ES10038");
        c.put("FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT", "ES10039");
        c.put("FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT", "ES10040");
        c.put("FAIL_SYS_ACCESS_TOKEN_EXPIRED", "ES10041");
        c.put("FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID", "ES10042");
        c.put("FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR", "ES10043");
        c.put("FAIL_SYS_REQUEST_QUEUED", "ES10044");
        c.put("FAIL_SYS_SERVICE_NOT_EXIST", "ES20000");
        c.put("FAIL_SYS_SERVICE_TIMEOUT", "ES20001");
        c.put("FAIL_SYS_SERVICE_FAULT", "ES20002");
        c.put("FAIL_SYS_HTTP_QUERYIP_ERROR", "ES30000");
        c.put("FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED", "ES30001");
        c.put("FAIL_SYS_HTTP_INVOKE_ERROR", "ES30002");
        c.put("FAIL_SYS_HTTP_RESPONSE_TIMEOUT", "ES30003");
        c.put("FAIL_SYS_HTTP_CONNECT_TIMEOUT", "ES30004");
        c.put("UNKNOWN_FAIL_CODE", "ES40000");
        c.put("FAIL_SYS_HSF_THROWN_EXCEPTION", "ES40001");
        c.put("FAIL_SYS_HTTP_RESULT_FIELDMISSED", "ES40003");
        c.put("FAIL_SYS_SERVICE_INNER_FAULT", "ES40002");
        b.put("ANDROID_SYS_NO_NETWORK", "EC10000");
        b.put("ANDROID_SYS_NETWORK_ERROR", "EC10001");
        b.put("ANDROID_SYS_JSONDATA_BLANK", "EC30000");
        b.put("ANDROID_SYS_JSONDATA_PARSE_ERROR", "EC30001");
        b.put("ANDROID_SYS_MTOPSDK_INIT_ERROR", "EC40000");
        b.put("ANDROID_SYS_MTOPCONTEXT_INIT_ERROR", "EC40001");
        b.put("ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR", "EC40002");
        b.put("ANDROID_SYS_NETWORK_REQUEST_CONVERT_ERROR", "EC40003");
        b.put("ANDROID_SYS_API_FLOW_LIMIT_LOCKED", "EC20000");
        b.put("ANDROID_SYS_API_41X_ANTI_ATTACK", "EC20001");
        b.put("ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", "EC40004");
        b.put("ANDROID_SYS_INIT_MTOP_ISIGN_ERROR", "EC40005");
        b.put("ANDROID_SYS_MTOP_MISS_CALL_FACTORY", "EC40006");
        b.put("ANDROID_SYS_LOGIN_FAIL", "EC40007");
        b.put("ANDROID_SYS_LOGIN_CANCEL", "EC40008");
        b.put("ANDROID_SYS_ILLEGAL_JSPARAM_ERROR", "EC40009");
        b.put("ANDROID_SYS_PARSE_JSPARAM_ERROR", "EC40010");
        b.put("ANDROID_SYS_BUILD_PROTOCOL_PARAMS_ERROR", "EC40011");
        a.putAll(c);
        a.putAll(b);
        a.put("SUCCESS", "SUCCESS");
    }

    @Deprecated
    public static Integer getIntErrCodeByStrErrorCode(String str) {
        return -1000;
    }

    @Deprecated
    public static Integer getMtopSdkIntErrCode(String str) {
        return -1000;
    }

    public static String getMappingCodeByErrorCode(String str) {
        return a.get(str);
    }

    public static boolean isSystemError(String str) {
        return c.containsKey(str);
    }

    public static boolean isMtopSdkError(String str) {
        return StringUtils.isBlank(str) || b.containsKey(str);
    }

    public static boolean isNetworkError(String str) {
        return "ANDROID_SYS_NETWORK_ERROR".equals(str) || "ANDROID_SYS_NO_NETWORK".equals(str);
    }

    public static boolean isNoNetwork(String str) {
        return "ANDROID_SYS_NO_NETWORK".equals(str);
    }

    public static boolean isSessionInvalid(String str) {
        return "FAIL_SYS_SESSION_EXPIRED".equals(str) || "ANDROID_SYS_LOGIN_FAIL".equals(str);
    }

    public static boolean isIllegelSign(String str) {
        return "FAIL_SYS_ILEGEL_SIGN".equals(str);
    }

    public static boolean isSuccess(String str) {
        return "SUCCESS".equals(str);
    }

    public static boolean is41XResult(String str) {
        return "ANDROID_SYS_API_41X_ANTI_ATTACK".equals(str);
    }

    public static boolean isApiLockedResult(String str) {
        return "ANDROID_SYS_API_FLOW_LIMIT_LOCKED".equals(str);
    }

    public static boolean isExpiredRequest(String str) {
        return "FAIL_SYS_EXPIRED_REQUEST".equals(str) || "FAIL_SYS_REQUEST_EXPIRED".equals(str);
    }

    public static boolean isMtopServerError(String str) {
        if (str != null) {
            return c.containsKey(str) || str.startsWith("FAIL_SYS_");
        }
        return false;
    }

    public static String appendMappingCode(int i, String str) {
        return i + "A" + str;
    }
}
