package cn.com.san.utils;

import android.content.Context;

import com.google.gson.Gson;
import cn.com.san.app.HongTaiApp;
import cn.com.san.bean.CookieInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * date: Created hongchen on 16/11/05.
 */
public class CookieUtil {

    public static String createCookie() {
        Context context = HongTaiApp.getContext();
        long first_time = PreferenceUtils.getPrefLong(context, "first_time", 0);
        String uuid = PreferenceUtils.getPrefString(context, "cookie_id", getUUID());
        if (first_time == 0) {
            first_time = System.currentTimeMillis();
            PreferenceUtils.setPrefString(context, "cookie_id", uuid);
        } else {
            long days = (System.currentTimeMillis() - first_time) / (1000 * 60 * 60 * 24);
            if (days > 30) {
                first_time = System.currentTimeMillis();
                uuid = getUUID();
                PreferenceUtils.setPrefString(context, "cookie_id", uuid);
            }
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date time = new Date(first_time);
        String channel = Utilitys.getChannel();
        String versionInfo = "ZhanToefl_android_v" + VersionUtils.getVersionName(context);
        CookieInfo cookieInfo = new CookieInfo(uuid, df.format(time), channel, versionInfo);
        String s = new Gson().toJson(cookieInfo, CookieInfo.class);
        return "cpsInfo=" + s;
    }

    private static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
