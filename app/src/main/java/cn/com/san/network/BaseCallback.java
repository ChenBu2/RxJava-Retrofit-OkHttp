package cn.com.san.network;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * date: Created hongchen on 16/11/05.
 */
public abstract class BaseCallback<T> implements Callback<T> {

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
