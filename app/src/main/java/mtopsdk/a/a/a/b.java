package mtopsdk.a.a.a;

import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import mtopsdk.a.a.a;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: ErrorCodeMappingAfterFilter */
public final class b implements a {
    @Override // mtopsdk.a.a.c
    public final String a() {
        return "mtopsdk.ErrorCodeMappingAfterFilter";
    }

    @Override // mtopsdk.a.a.a
    public final String a(e eVar) {
        String str = "key_data_seq";
        String str2 = "key_data_response";
        String str3 = "key_data_request";
        String str4 = eVar.h;
        String str5 = "mtopsdk.ErrorCodeMappingAfterFilter";
        if (!SwitchConfig.getInstance().isGlobalErrorCodeMappingOpen()) {
            TBSdkLog.i("mtopsdk.ErrorCodeMappingAfterFilter", str4, "GlobalErrorCodeMappingOpen=false,Don't do ErrorCode Mapping.");
            return "CONTINUE";
        }
        MtopResponse mtopResponse = eVar.c;
        if (mtopResponse.isApiSuccess()) {
            return "CONTINUE";
        }
        try {
            if (mtopResponse.isNoNetwork()) {
                eVar.g.isNoNetwork = true;
            }
            if (mtopResponse.isNetworkError()) {
                mtopResponse.mappingCodeSuffix = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str6 = SwitchConfig.errorMappingMsgMap.get("NETWORK_ERROR_MAPPING");
                if (str6 == null) {
                    str6 = "网络竟然崩溃了";
                }
                mtopResponse.setRetMsg(str6);
                eVar.g.retType = 1;
                return "CONTINUE";
            }
            eVar.g.retType = 2;
            String str7 = "ES00000";
            if (mtopResponse.is41XResult() || mtopResponse.isApiLockedResult()) {
                String mappingCodeByErrorCode = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
                if (StringUtils.isNotBlank(mappingCodeByErrorCode)) {
                    str7 = mappingCodeByErrorCode;
                }
                mtopResponse.mappingCodeSuffix = str7;
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str8 = SwitchConfig.errorMappingMsgMap.get("FLOW_LIMIT_ERROR_MAPPING");
                if (str8 == null) {
                    str8 = "前方拥挤，亲稍等再试试";
                }
                mtopResponse.setRetMsg(str8);
                TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                if (mtopsdk.mtop.stat.a.a() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("key_data_request", eVar.b.getRequestLog());
                    hashMap.put("key_data_response", mtopResponse.getResponseLog());
                    hashMap.put("key_data_seq", eVar.h);
                    mtopsdk.mtop.stat.a.a();
                    mtopResponse.getHeaderFields();
                }
                return "CONTINUE";
            }
            String str9 = "服务竟然出错了";
            if (mtopResponse.isMtopServerError()) {
                if (StringUtils.isBlank(mtopResponse.mappingCodeSuffix)) {
                    String mappingCodeByErrorCode2 = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
                    if (StringUtils.isNotBlank(mappingCodeByErrorCode2)) {
                        str7 = mappingCodeByErrorCode2;
                    }
                    mtopResponse.mappingCodeSuffix = str7;
                }
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str10 = SwitchConfig.errorMappingMsgMap.get("SERVICE_ERROR_MAPPING");
                if (str10 != null) {
                    str9 = str10;
                }
                mtopResponse.setRetMsg(str9);
                TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                if (mtopsdk.mtop.stat.a.a() != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("key_data_request", eVar.b.getRequestLog());
                    hashMap2.put("key_data_response", mtopResponse.getResponseLog());
                    hashMap2.put("key_data_seq", eVar.h);
                    mtopsdk.mtop.stat.a.a();
                    mtopResponse.getHeaderFields();
                }
                return "CONTINUE";
            } else if (mtopResponse.isMtopSdkError()) {
                String retCode = mtopResponse.getRetCode();
                String mappingCodeByErrorCode3 = ErrorConstant.getMappingCodeByErrorCode(retCode);
                if (retCode != null && retCode.startsWith("ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR")) {
                    mappingCodeByErrorCode3 = "EC40002";
                }
                if (!StringUtils.isNotBlank(mappingCodeByErrorCode3)) {
                    mappingCodeByErrorCode3 = "EC00000";
                }
                mtopResponse.mappingCodeSuffix = mappingCodeByErrorCode3;
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str11 = SwitchConfig.errorMappingMsgMap.get("SERVICE_ERROR_MAPPING");
                if (str11 != null) {
                    str9 = str11;
                }
                mtopResponse.setRetMsg(str9);
                TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                if (mtopsdk.mtop.stat.a.a() != null) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("key_data_request", eVar.b.getRequestLog());
                    hashMap3.put("key_data_response", mtopResponse.getResponseLog());
                    hashMap3.put("key_data_seq", eVar.h);
                    mtopsdk.mtop.stat.a.a();
                    mtopResponse.getHeaderFields();
                }
                return "CONTINUE";
            } else {
                eVar.g.retType = 3;
                if (StringUtils.isNotBlank(mtopResponse.mappingCodeSuffix)) {
                    mtopResponse.mappingCode = mtopResponse.mappingCodeSuffix;
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                    if (mtopsdk.mtop.stat.a.a() != null) {
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("key_data_request", eVar.b.getRequestLog());
                        hashMap4.put("key_data_response", mtopResponse.getResponseLog());
                        hashMap4.put("key_data_seq", eVar.h);
                        mtopsdk.mtop.stat.a.a();
                        mtopResponse.getHeaderFields();
                    }
                    return "CONTINUE";
                }
                String retCode2 = mtopResponse.getRetCode();
                mtopResponse.mappingCode = retCode2;
                if (StringUtils.isBlank(retCode2)) {
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                    if (mtopsdk.mtop.stat.a.a() != null) {
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("key_data_request", eVar.b.getRequestLog());
                        hashMap5.put("key_data_response", mtopResponse.getResponseLog());
                        hashMap5.put("key_data_seq", eVar.h);
                        mtopsdk.mtop.stat.a.a();
                        mtopResponse.getHeaderFields();
                    }
                    return "CONTINUE";
                } else if (!SwitchConfig.getInstance().isBizErrorCodeMappingOpen()) {
                    TBSdkLog.i("mtopsdk.ErrorCodeMappingAfterFilter", str4, "BizErrorCodeMappingOpen=false,Don't do BizErrorCode Mapping.");
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                    if (mtopsdk.mtop.stat.a.a() != null) {
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put("key_data_request", eVar.b.getRequestLog());
                        hashMap6.put("key_data_response", mtopResponse.getResponseLog());
                        hashMap6.put("key_data_seq", eVar.h);
                        mtopsdk.mtop.stat.a.a();
                        mtopResponse.getHeaderFields();
                    }
                    return "CONTINUE";
                } else if (retCode2.length() == 17 && retCode2.charAt(1) == '-') {
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                    TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                    if (mtopsdk.mtop.stat.a.a() != null) {
                        HashMap hashMap7 = new HashMap();
                        hashMap7.put("key_data_request", eVar.b.getRequestLog());
                        hashMap7.put("key_data_response", mtopResponse.getResponseLog());
                        hashMap7.put("key_data_seq", eVar.h);
                        mtopsdk.mtop.stat.a.a();
                        mtopResponse.getHeaderFields();
                    }
                    return "CONTINUE";
                } else {
                    if (SwitchConfig.getInstance().degradeBizErrorMappingApiSet != null) {
                        String key = eVar.b.getKey();
                        if (SwitchConfig.getInstance().degradeBizErrorMappingApiSet.contains(key)) {
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.i("mtopsdk.ErrorCodeMappingAfterFilter", str4, "apiKey in degradeBizErrorMappingApiSet,apiKey=" + key);
                            }
                            TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                            TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                            if (mtopsdk.mtop.stat.a.a() != null) {
                                HashMap hashMap8 = new HashMap();
                                hashMap8.put("key_data_request", eVar.b.getRequestLog());
                                hashMap8.put("key_data_response", mtopResponse.getResponseLog());
                                hashMap8.put("key_data_seq", eVar.h);
                                mtopsdk.mtop.stat.a.a();
                                mtopResponse.getHeaderFields();
                            }
                            return "CONTINUE";
                        }
                    }
                    try {
                        if (MtopUtils.isContainChineseCharacter(retCode2)) {
                            mtopResponse.mappingCode = "TERR00000";
                            TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, "retCode contain chinese character,retCode=" + retCode2);
                            TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                            TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                            if (mtopsdk.mtop.stat.a.a() != null) {
                                HashMap hashMap9 = new HashMap();
                                hashMap9.put("key_data_request", eVar.b.getRequestLog());
                                hashMap9.put("key_data_response", mtopResponse.getResponseLog());
                                hashMap9.put("key_data_seq", eVar.h);
                                mtopsdk.mtop.stat.a.a();
                                mtopResponse.getHeaderFields();
                            }
                            return "CONTINUE";
                        }
                        String caesarEncrypt = MtopUtils.caesarEncrypt(retCode2);
                        if (StringUtils.isNotBlank(caesarEncrypt)) {
                            long globalBizErrorMappingCodeLength = SwitchConfig.getInstance().getGlobalBizErrorMappingCodeLength();
                            if (((long) caesarEncrypt.length()) <= globalBizErrorMappingCodeLength || globalBizErrorMappingCodeLength <= 0) {
                                mtopResponse.mappingCode = caesarEncrypt;
                            } else {
                                mtopResponse.mappingCode = caesarEncrypt.substring(0, (int) globalBizErrorMappingCodeLength);
                            }
                        }
                        TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, mtopResponse.getResponseLog());
                        TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, eVar.b.getRequestLog());
                        if (mtopsdk.mtop.stat.a.a() != null) {
                            HashMap hashMap10 = new HashMap();
                            hashMap10.put("key_data_request", eVar.b.getRequestLog());
                            hashMap10.put("key_data_response", mtopResponse.getResponseLog());
                            hashMap10.put("key_data_seq", eVar.h);
                            mtopsdk.mtop.stat.a.a();
                            mtopResponse.getHeaderFields();
                        }
                        return "CONTINUE";
                    } catch (Exception e) {
                        TBSdkLog.e("mtopsdk.ErrorCodeMappingAfterFilter", str4, "Mapping biz retCode to mappingCode error.retCode=" + retCode2, e);
                    }
                }
            }
        } finally {
            TBSdkLog.e(str5, str4, mtopResponse.getResponseLog());
            TBSdkLog.e(str5, str4, eVar.b.getRequestLog());
            if (mtopsdk.mtop.stat.a.a() != null) {
                HashMap hashMap11 = new HashMap();
                hashMap11.put(str3, eVar.b.getRequestLog());
                hashMap11.put(str2, mtopResponse.getResponseLog());
                hashMap11.put(str, eVar.h);
                mtopsdk.mtop.stat.a.a();
                mtopResponse.getHeaderFields();
            }
        }
    }
}
