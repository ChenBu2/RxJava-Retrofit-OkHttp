package cn.com.san.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import cn.com.san.R;

/**
 * date: Created hongchen on 16/11/05.
 */
public abstract class BaseActivity extends ToolBarActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRootContent();
    }

    private void setRootContent(){
        if (getContentResId() > 0){
            addContent(getContentResId());
        } else if (getFragment() != null){
            addFragment(getFragment());
        } else {
            throw new NullPointerException("必须实现getContentResId()或者getFragment()方法");
        }
    }

    private void addFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.public_layout, fragment);
        transaction.commitAllowingStateLoss();
    }

    protected int getContentResId(){
        return 0;
    }

    protected Fragment getFragment(){
        return null;
    }

}
