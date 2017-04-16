package cn.com.san.utils;

import android.content.Context;

/**
 * date: Created hongchen on 16/11/05.
 */
public class ContextUtil {
    private static Context sContext;

    private ContextUtil() {

    }

    public static void init(Context context) {
        sContext = context;
    }

    public static Context getInstance() {
        if (sContext == null) {
            throw new NullPointerException("the context is null,please init ContextUtil in Application first.");
        }
        return sContext;
    }
}
