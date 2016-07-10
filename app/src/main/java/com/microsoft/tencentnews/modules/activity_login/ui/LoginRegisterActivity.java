package com.microsoft.tencentnews.modules.activity_login.ui;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseActivity;

/**
 * Created by Administrator on 16-7-9.
 */
public class LoginRegisterActivity extends BaseActivity implements View.OnClickListener{

    private ImageView img_close_login;
    private TextView account_login;
    private TextView pwd_login;
    private Button loginButton_login;
    private Button registerButton_login;

    private boolean isChangedColor=false;

    @Override
    protected int setViewID(){
        return R.layout.activity_login_me;
    }

    @Override
    protected void findViews(){
        img_close_login = (ImageView) findViewById(R.id.close_login);
        account_login = (EditText) findViewById(R.id.account_login);
        pwd_login = (EditText) findViewById(R.id.pwd_login);
        loginButton_login = (Button) findViewById(R.id.loginbutton_login);
        registerButton_login = (Button) findViewById(R.id.registerbutton_login);
    }

    @Override
    protected void initData(){
        img_close_login.setOnClickListener(this);
        loginButton_login.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                if( !isChangedColor){

                }


                isChangedColor=true;

                return true;
            }
        });
        registerButton_login.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                if( !isChangedColor){

                }
                isChangedColor=true;
                return true;
            }
        });
    }

    @Override
    protected void initEvent(){
    }

    @Override
    protected void loadData(){
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.close_login:

                this.finish();

                break;
            case R.id.loginbutton_login:

                break;
            case R.id.registerbutton_login:

                break;
        }
    }
}
