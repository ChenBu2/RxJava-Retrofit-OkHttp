package cn.com.san.app;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import cn.com.san.network.HttpClient;
import cn.com.san.utils.ContextUtil;
import cn.com.san.utils.ScreenUtil;

/**
 * date: Created hongchen on 16/11/05.
 */
public class HongTaiApp extends Application {

    private static Context mApplicationContext;
    private static final String LOGIN = "login";

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;
        ContextUtil.init(this);
        ScreenUtil.init(this);
        HttpClient.initOkHttpClient();
        initImageLoaderCache();
    }

    /**
     * 初始化平台分享 如果集成 需要在这里初始化
     */
    /*void initUmengShare() {
        //微信
        PlatformConfig.setWeixin(GlobalParams.WEIXIN_APP_KEY, GlobalParams.WEIXIN_APP_SECRET);
        //新浪微博
        PlatformConfig.setSinaWeibo(GlobalParams.SINA_APP_KEY, GlobalParams.SINA_APP_SECRET);
    }*/

    /**
     * 初始化imgloader
     */
    public void initImageLoaderCache() {
        File cacheDir = StorageUtils.getOwnCacheDirectory(
                getApplicationContext(), "ImageLoader/Cache");

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .memoryCacheExtraOptions(720, 1280)
                        // default = device screen dimensions
                .diskCacheExtraOptions(720, 1280, null)
                .memoryCache(new WeakMemoryCache())
//                .memoryCacheSize(2 * 1024 * 1024)
//                .memoryCacheSizePercentage(13)
                        // default
                .diskCache(new UnlimitedDiskCache(cacheDir))
                        // default
//                .diskCacheSize(50 * 1024 * 1024)
//                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                        // default
                .imageDownloader(
                        new BaseImageDownloader(getApplicationContext())) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .build();
        ImageLoader.getInstance().init(config);
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return mApplicationContext;
    }

}
