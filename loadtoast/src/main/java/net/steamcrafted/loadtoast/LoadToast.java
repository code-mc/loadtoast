package net.steamcrafted.loadtoast;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by Wannes2 on 23/04/2015.
 */
public class LoadToast {

    private String mText = "";
    private LoadToastView mView;
    private int mTranslationY = 0;

    public LoadToast(Context context){
        mView = new LoadToastView(context);
        final ViewGroup vg = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        vg.addView(mView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vg.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.setVisibility(View.GONE);
                mView.setTranslationX((vg.getWidth() - mView.getWidth())/2);
                mView.setTranslationY(-mView.getHeight() + mTranslationY);
            }
        },1);
    }

    public LoadToast setTranslationY(int pixels){
        mTranslationY = pixels;
        return this;
    }

    public LoadToast setText(String message){
        mText = message;
        mView.setText(mText);
        return this;
    }

    public LoadToast setTextColor(int color){
        mView.setTextColor(color);
        return this;
    }

    public LoadToast setBackgroundColor(int color){
        mView.setBackgroundColor(color);
        return this;
    }

    public LoadToast setProgressColor(int color){
        mView.setProgressColor(color);
        return this;
    }

    public LoadToast show(){
        mView.show();
        mView.setAlpha(0f);
        mView.setTranslationY(-mView.getHeight() + mTranslationY);
        mView.setVisibility(View.VISIBLE);
        mView.animate().alpha(1f).translationY(25 + mTranslationY).setInterpolator(new DecelerateInterpolator())
                .setDuration(300).setStartDelay(0).start();
        return this;
    }

    public void success(){
        mView.success();
        slideUp();
    }

    public void error(){
        mView.error();
        slideUp();
    }

    private void slideUp(){
        mView.animate().setStartDelay(1000).alpha(0f).translationY(-mView.getHeight() + mTranslationY)
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(300).start();
    }
}
