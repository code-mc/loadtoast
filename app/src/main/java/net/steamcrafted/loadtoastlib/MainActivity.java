package net.steamcrafted.loadtoastlib;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.steamcrafted.loadtoast.LoadToast;
import net.steamcrafted.loadtoast.MaterialProgressDrawable;


public class MainActivity extends AppCompatActivity {

    // Example activity

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String text = "dhfbsd kjsdfjnskdfs dfs";
        final LoadToast lt = new LoadToast(this)
                .setProgressColor(Color.RED)
                .setText(text)
                .setTranslationY(100)
                .setBorderColor(Color.LTGRAY)
            .show();
        //lt.success();
        final ViewGroup root = (ViewGroup) findViewById(android.R.id.content);

        View v = new View(this);
        v.setBackgroundColor(Color.RED);
        //root.addView(v, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lt.show();
            }
        });
        findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lt.error();
            }
        });
        findViewById(R.id.success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lt.success();
            }
        });
        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = new View(MainActivity.this);
                v.setBackgroundColor(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
                root.addView(v, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
            }
        });
        findViewById(R.id.hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lt.hide();
            }
        });

        ImageView progressView = ((ImageView) findViewById(R.id.progressdrawable));
        MaterialProgressDrawable drawable = new MaterialProgressDrawable(this, progressView);
    }
}