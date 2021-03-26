package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import java.lang.reflect.Type;

public class JSONPDeserializer implements ObjectDeserializer {
    public static final JSONPDeserializer instance = new JSONPDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        int i;
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
        String scanSymbolUnQuoted = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
        jSONLexerBase.nextToken();
        int i2 = jSONLexerBase.token();
        if (i2 == 25) {
            String str = scanSymbolUnQuoted + ".";
            scanSymbolUnQuoted = str + jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
            jSONLexerBase.nextToken();
            i2 = jSONLexerBase.token();
        }
        T t = (T) new JSONPObject(scanSymbolUnQuoted);
        if (i2 == 10) {
            jSONLexerBase.nextToken();
            while (true) {
                t.addParameter(defaultJSONParser.parse());
                i = jSONLexerBase.token();
                if (i != 16) {
                    break;
                }
                jSONLexerBase.nextToken();
            }
            if (i == 11) {
                jSONLexerBase.nextToken();
                if (jSONLexerBase.token() == 24) {
                    jSONLexerBase.nextToken();
                }
                return t;
            }
            throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
    }
}
