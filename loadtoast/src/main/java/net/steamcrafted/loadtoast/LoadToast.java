package net.steamcrafted.loadtoast;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by Wannes2 on 23/04/2015.
 */
public class LoadToast {

    private String mText = "";
    private LoadToastView mView;

    public LoadToast(Context context){
        mView = new LoadToastView(context);
        final ViewGroup vg = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        vg.addView(mView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vg.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.setTranslationX((vg.getWidth() - mView.getWidth())/2);
                mView.setTranslationY(-mView.getHeight());
            }
        },1);
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
        //mView.setVisibility(View.VISIBLE);
        mView.setAlpha(0f);
        mView.setTranslationY(-mView.getHeight());
        mView.animate().alpha(1f).translationY(25).setInterpolator(new DecelerateInterpolator())
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
        mView.animate().setStartDelay(1000).alpha(0f).translationY(-mView.getHeight())
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(300).start();
    }
}
