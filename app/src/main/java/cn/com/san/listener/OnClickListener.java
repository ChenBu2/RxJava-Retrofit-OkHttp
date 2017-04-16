package cn.com.san.listener;

import android.view.View;

/**
 * date: Created hongchen on 16/11/05.
 */
public abstract class OnClickListener implements View.OnClickListener {
    private long lastestClickTime = 0;
    private long period = 500;

    public OnClickListener(){}

    public OnClickListener(long millsecond){
        this.period = millsecond;
    }

    @Override
    public void onClick(View v) {
        long clickTime = System.currentTimeMillis();
        if (Math.abs(clickTime - lastestClickTime) < period){
            return;
        }
        clickOperate();
        lastestClickTime = clickTime;
    }

    protected abstract void clickOperate();
}
