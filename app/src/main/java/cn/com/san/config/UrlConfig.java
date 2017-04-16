package cn.com.san.config;

/**
 * date: Created hongchen on 16/11/05.
 */
public class UrlConfig {

    public static String TestHostUrl;
    public final static String door_one = "http://mogita.cn/gate.php?1";
    public final static String door_two = "http://mogita.cn/gate.php?2";

    // 0测试环境
    public static final int Test = 0;
    // 1线上环境
    public static final int Online = 1;

    static {
        switch (Online) {
            case Test:
                TestHostUrl = "http://59.110.21.9:28001/";
                break;
            case Online:
                TestHostUrl = "http://59.110.21.9:28001/";
                break;
        }
    }


    public final static String API_V1_0_TEST = "contact/company/list.json";
}
