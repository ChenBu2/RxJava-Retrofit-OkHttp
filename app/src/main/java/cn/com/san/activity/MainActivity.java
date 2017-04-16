package cn.com.san.activity;

import android.os.Bundle;

import cn.com.san.R;
import cn.com.san.activity.base.BaseNetActivity;
import cn.com.san.listener.OnClickListener;
import cn.com.san.network.RetrofitManager;
import cn.com.san.network.api.TestApi;
import cn.com.san.utils.LogUtils;
import cn.com.san.utils.ToastUtils;
import cn.com.san.view.ColorFilterImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseNetActivity<Object> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goneLoading();
        mHeaderBuilder.goneToolbar();
//        setContentView(R.layout.activity_main);
//        TestModel.test();
    }

    @Override
    protected void initViews() {
        ColorFilterImageView door_1 = getViewById(R.id.iv_men_1);
        ColorFilterImageView door_2 = getViewById(R.id.iv_men_2);
        door_1.setOnClickListener(new OnClickListener() {
            @Override
            protected void clickOperate() {
                openDoorOne();
            }
        });

        door_2.setOnClickListener(new OnClickListener() {
            @Override
            protected void clickOperate() {
                openDoorTwo();
            }
        });
    }

    private void openDoorTwo() {
        TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);
        Call<Object> objectCall = testApi.door2();
        objectCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                ToastUtils.showShort("开门成功");
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                LogUtils.e("MainActivity", t);
                ToastUtils.showShort("开门成功");
            }
        });
    }

    private void openDoorOne() {
        TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);
        Call<Object> objectCall = testApi.door1();
        objectCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                ToastUtils.showShort("开门成功");
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                LogUtils.e("MainActivity", t);
                ToastUtils.showShort("开门成功");
            }
        });
    }

    @Override
    protected void loadData() {
        /*TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);
        Call<Object> testCall = testApi.test();
        testCall.enqueue(this);*/
    }

    @Override
    protected void processData(Object o) {
        LogUtils.w(o.toString());
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_main;
    }
}
