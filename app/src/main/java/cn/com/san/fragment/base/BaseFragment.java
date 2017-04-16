package cn.com.san.fragment.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * date: Created hongchen on 16/11/05.
 */
public abstract class BaseFragment extends UmengFragment {
    private View mRootLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootLayout = inflater.inflate(getContentResId(), null);
        return mRootLayout;
    }

    protected abstract int getContentResId();

    protected <VG extends View> VG getViewById(int resId){
        return (VG) mRootLayout.findViewById(resId);
    }
}
