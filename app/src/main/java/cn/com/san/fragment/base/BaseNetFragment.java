package cn.com.san.fragment.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import cn.com.san.utils.ToastUtils;

import org.apache.http.HttpException;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * date: Created hongchen on 16/11/05.
 */
public abstract class BaseNetFragment<T> extends BaseLoadFragment implements Callback<T> {
    private final int mNetWorkTryCount = 3;
    private int mNetWorkTryNum = 0;

    private Handler mNetTryHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            loadData();
        }
    };

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        load();
    }

    private void load() {
        showLoading();
        loadData();
    }

    protected abstract void initViews();

    protected abstract void loadData();

    protected abstract void processData(T t);

    @Override
    public void refreshData() {
        load();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T t = response.body();
        processData(t);
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof HttpException || throwable instanceof UnknownHostException) {
            showNetError();
            ToastUtils.showShort("请检查您的网络连接");
        } else if (throwable instanceof IllegalStateException) {
            showNoData();
        } else if (++mNetWorkTryNum < mNetWorkTryCount) {
            mNetTryHandler.sendEmptyMessageDelayed(0, 1000);
        }
    }

}
