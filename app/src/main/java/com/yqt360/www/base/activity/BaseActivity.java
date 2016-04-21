package com.yqt360.www.base.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqt360.www.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by FreeMason on 2016/4/1.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;
    protected Activity activity;
    protected LayoutInflater inflater;
    protected Subscription subscription;
    protected View view;
    @Bind(R.id.tool_bar)
    Toolbar toolbar;
    ViewGroup content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        initSymbol();
        initContentView();
        ButterKnife.bind(this);
        initActionBar();
        initViews();
    }

    protected abstract void initViews();

    private void initActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getActionBarTitle());
        toolbar.setTitleTextColor(Color.WHITE);
    }

    private void initSymbol() {
        context = this.getApplicationContext();
        activity = this;
        inflater = LayoutInflater.from(context);
    }


    private void initContentView() {
        content = (ViewGroup) this.findViewById(R.id.content);
        view = inflater.inflate(getContent(), null, false);
        content.addView(view);
    }

    public abstract int getContent();

    public abstract String getActionBarTitle();


    //释放资源
    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected void showBackBtn(){
        toolbar.setNavigationIcon(R.mipmap.ic_gf_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }
}
