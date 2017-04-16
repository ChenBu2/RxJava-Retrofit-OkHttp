package cn.com.san.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import cn.com.san.app.HongTaiApp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class PhoneInfoUtils {
    public static Context context = HongTaiApp.getContext();

    // 获得mac地址
    public static String getMac() {
        String macSerial = null;
        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec(
                    "cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    macSerial = macSerial.replaceAll(":", "");
                    break;
                }
            }
        } catch (IOException ex) {
            // 赋予默认值
            ex.printStackTrace();
        }
        return macSerial;
    }

    //获得品牌名
    public static String getBrand(){
        return android.os.Build.MANUFACTURER;
    }

    public static String getImei(){
        return ((TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE)).getDeviceId();
    }

    public static String getOs(){
        return "android";
    }
}
