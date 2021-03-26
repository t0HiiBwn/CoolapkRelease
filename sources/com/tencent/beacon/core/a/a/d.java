package com.tencent.beacon.core.a.a;

import java.util.Locale;

/* compiled from: DBConst */
public final class d {
    public static int a = 30;
    public static final String[][] b;

    static {
        String[][] strArr = new String[7][];
        b = strArr;
        strArr[0] = new String[]{"t_event", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int , %s int , %s int , %s int , %s blob)", "t_event", "_id", "_time", "_type", "_prority", "_length", "_datas")};
        strArr[1] = new String[]{"t_count_event", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s varchar(255) unique  , %s int , %s int , %s int , %s int , %s int , %s text)", "t_count_event", "_id", "_countid", "_prority", "_local", "_stime", "_utime", "_ctime", "_cparams")};
        strArr[2] = new String[]{"t_strategy", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", "t_strategy", "_id", "_key", "_ut", "_datas")};
        strArr[3] = new String[]{"t_file", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text , %s int , %s int , %s text , %s text , %s text , %s text)", "t_file", "_id", "_n", "_ut", "_sz", "_ac", "_sa", "_t", "_p")};
        strArr[4] = new String[]{"t_req_data", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s int , %s int , %s blob)", "t_req_data", "_id", "_rid", "_time", "_cnt", "_datas")};
        strArr[5] = new String[]{"t_apple", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s blob unique , %s int , %s int, %s int)", "t_apple", "_id", "_a", "_b", "_c", "_d")};
        strArr[6] = new String[]{"t_conf", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s text , %s int , %s int)", "t_conf", "_id", "_key", "_value", "_vdate", "_time")};
    }
}
