package cn.com.san.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.com.san.R;
import cn.com.san.listener.OnRefreshListener;

/**
 * date: Created hongchen on 16/11/05.
 */
public class PublicLoadLayout extends RelativeLayout implements View.OnClickListener {
//    private Context mContext;
    private FrameLayout mContentLayout;
    private LinearLayout mLoadingLayout;
    private LinearLayout mNoDataLayout;
    private LinearLayout mNetErrorLayout;

    private OnRefreshListener refreshListener;

    public PublicLoadLayout(Context context) {
        this(context, null);
    }

    public PublicLoadLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public static PublicLoadLayout createPage(Context context, int layoutId, OnRefreshListener listener) {
        PublicLoadLayout rootView = new PublicLoadLayout(context);
        rootView.addContent(layoutId);
        rootView.refreshListener = listener;
        return rootView;
    }

    public static PublicLoadLayout createPage(Context context, FragmentManager manager, Fragment fragment, OnRefreshListener listener){
        PublicLoadLayout rootView = new PublicLoadLayout(context);
        rootView.addFragment(fragment, manager);
        rootView.refreshListener = listener;
        return rootView;
    }

    public void addContent(int viewId) {
        inflate(getContext(), viewId, mContentLayout);
    }

    public void addFragment(Fragment fragment, FragmentManager manager){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.content_layout, fragment);
        transaction.commitAllowingStateLoss();
    }

    private void init(Context context) {
//        this.mContext = context;
        inflate(context, R.layout.base_loading_layout, this);
        initViews();
        setRefreshListener();
    }

    private void initViews() {
        mContentLayout = (FrameLayout) findViewById(R.id.content_layout);
        mLoadingLayout = (LinearLayout) findViewById(R.id.loading_layout);
        mNoDataLayout = (LinearLayout) findViewById(R.id.no_data_layout);
        mNetErrorLayout = (LinearLayout) findViewById(R.id.net_error_layout);
    }

    private void setRefreshListener(){
        mNoDataLayout.setOnClickListener(this);
        mNetErrorLayout.setOnClickListener(this);
    }

    public void showNoData(){
        mNoDataLayout.setVisibility(View.VISIBLE);
        mLoadingLayout.setVisibility(View.GONE);
    }

    public void showNetError(){
        mNetErrorLayout.setVisibility(View.VISIBLE);
        mLoadingLayout.setVisibility(View.GONE);
    }

    public void showLoading(){
        mLoadingLayout.setVisibility(View.VISIBLE);
        mNoDataLayout.setVisibility(View.GONE);
        mNetErrorLayout.setVisibility(View.GONE);
    }

    public void goneLoading(){
        mContentLayout.setVisibility(View.VISIBLE);
        mLoadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.no_data_layout:
            case R.id.net_error_layout:
                showLoading();
                if (refreshListener != null) {
                    refreshListener.refreshData();
                }
                break;
        }
    }

}
