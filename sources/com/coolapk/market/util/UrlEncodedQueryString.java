package com.coolapk.market.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class UrlEncodedQueryString {
    private static final String PARSE_PARAMETER_SEPARATORS = (String.valueOf(Separator.AMPERSAND) + Separator.SEMICOLON);
    private final Map<String, List<String>> queryMap = new LinkedHashMap();

    public enum Separator {
        AMPERSAND {
            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "&";
            }
        },
        SEMICOLON {
            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return ";";
            }
        }
    }

    public static UrlEncodedQueryString create() {
        return new UrlEncodedQueryString();
    }

    public static UrlEncodedQueryString create(Map<String, List<String>> map) {
        UrlEncodedQueryString urlEncodedQueryString = new UrlEncodedQueryString();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            urlEncodedQueryString.queryMap.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return urlEncodedQueryString;
    }

    public static UrlEncodedQueryString parse(CharSequence charSequence) {
        UrlEncodedQueryString urlEncodedQueryString = new UrlEncodedQueryString();
        urlEncodedQueryString.appendOrSet(charSequence, true);
        return urlEncodedQueryString;
    }

    public static UrlEncodedQueryString parse(URI uri) {
        return parse(uri.getRawQuery());
    }

    public String get(String str) {
        List<String> values = getValues(str);
        if (values == null || values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }

    public boolean contains(String str) {
        return this.queryMap.containsKey(str);
    }

    public Iterator<String> getNames() {
        return this.queryMap.keySet().iterator();
    }

    public List<String> getValues(String str) {
        return this.queryMap.get(str);
    }

    public Map<String, List<String>> getMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : this.queryMap.entrySet()) {
            linkedHashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return linkedHashMap;
    }

    public UrlEncodedQueryString set(String str, String str2) {
        appendOrSet(str, str2, false);
        return this;
    }

    public UrlEncodedQueryString set(String str, Number number) {
        if (number == null) {
            remove(str);
            return this;
        }
        appendOrSet(str, number.toString(), false);
        return this;
    }

    public UrlEncodedQueryString set(String str) {
        appendOrSet(str, false);
        return this;
    }

    public UrlEncodedQueryString append(String str, String str2) {
        appendOrSet(str, str2, true);
        return this;
    }

    public UrlEncodedQueryString append(String str, Number number) {
        appendOrSet(str, number.toString(), true);
        return this;
    }

    public UrlEncodedQueryString append(String str) {
        appendOrSet(str, true);
        return this;
    }

    public boolean isEmpty() {
        return this.queryMap.isEmpty();
    }

    public UrlEncodedQueryString remove(String str) {
        appendOrSet(str, null, false);
        return this;
    }

    public URI apply(URI uri) {
        return apply(uri, Separator.AMPERSAND);
    }

    public URI apply(URI uri, Separator separator) {
        StringBuilder sb = new StringBuilder();
        if (uri.getScheme() != null) {
            sb.append(uri.getScheme());
            sb.append(':');
        }
        if (uri.getHost() != null) {
            sb.append("//");
            if (uri.getUserInfo() != null) {
                sb.append(uri.getUserInfo());
                sb.append('@');
            }
            sb.append(uri.getHost());
            if (uri.getPort() != -1) {
                sb.append(':');
                sb.append(uri.getPort());
            }
        } else if (uri.getAuthority() != null) {
            sb.append("//");
            sb.append(uri.getAuthority());
        }
        if (uri.getPath() != null) {
            sb.append(uri.getPath());
        }
        String urlEncodedQueryString = toString(separator);
        if (urlEncodedQueryString.length() != 0) {
            sb.append('?');
            sb.append(urlEncodedQueryString);
        }
        if (uri.getFragment() != null) {
            sb.append('#');
            sb.append(uri.getFragment());
        }
        try {
            return new URI(sb.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UrlEncodedQueryString)) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return toString(Separator.AMPERSAND);
    }

    public String toString(Separator separator) {
        StringBuilder sb = new StringBuilder();
        for (String str : this.queryMap.keySet()) {
            for (String str2 : this.queryMap.get(str)) {
                if (sb.length() != 0) {
                    sb.append(separator);
                }
                try {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                    if (str2 != null) {
                        sb.append('=');
                        sb.append(URLEncoder.encode(str2, "UTF-8"));
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return sb.toString();
    }

    private UrlEncodedQueryString() {
    }

    private void appendOrSet(String str, String str2, boolean z) {
        Objects.requireNonNull(str, "name");
        if (z) {
            List<String> list = this.queryMap.get(str);
            if (list != null) {
                list.add(str2);
                return;
            }
        } else if (str2 == null) {
            this.queryMap.remove(str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        this.queryMap.put(str, arrayList);
    }

    private void appendOrSet(CharSequence charSequence, boolean z) {
        String str;
        if (charSequence != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(charSequence.toString(), PARSE_PARAMETER_SEPARATORS);
            HashSet hashSet = null;
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    str = null;
                } else {
                    try {
                        String substring = nextToken.substring(0, indexOf);
                        str = nextToken.substring(indexOf + 1);
                        nextToken = substring;
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
                String decode = URLDecoder.decode(nextToken, "UTF-8");
                if (!z) {
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    if (!hashSet.contains(decode)) {
                        remove(decode);
                    }
                    hashSet.add(decode);
                }
                if (str != null) {
                    str = URLDecoder.decode(str, "UTF-8");
                }
                appendOrSet(decode, str, true);
            }
        }
    }
}
