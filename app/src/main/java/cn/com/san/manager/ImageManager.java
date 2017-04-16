package cn.com.san.manager;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * date: Created hongchen on 16/11/05.
 */
public class ImageManager {

    public static void displayImg(String uri, ImageView imageView){
        ImageLoader.getInstance().displayImage(uri, imageView);
    }

    public static void displayImg(String uri, ImageView imageView, DisplayImageOptions options){
        ImageLoader.getInstance().displayImage(uri, imageView, options);
    }

    public static void displayImg(String uri, ImageView imageView, DisplayImageOptions options, ImageLoadingListener listener){
        ImageLoader.getInstance().displayImage(uri, imageView, options, listener);
    }

}
