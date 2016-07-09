package com.microsoft.tencentnews.modules.fragment_aboutme.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;
import com.microsoft.tencentnews.modules.activity_login.ui.LoginRegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMeFragment extends BaseFragment implements View.OnClickListener{

    private Context context;
    private ImageView left_top_img;
    private ImageView right_top_img;
    private ImageView user_header;
    private View myattention_me;
    private View shoucang_me;
    private View myComment;
    private View game_me;
    private View fankui_me;
    private ImageView img01_me;
    private ImageView img02_me;
    private ImageView img03_me;
    private TextView text01_me;
    private TextView text02_me;
    private TextView text03_me;
    private TextView textlogin_head_me;
    private TextView changeimg_head_me;

    private boolean img01_status=true;
    private boolean img02_status=true;


    @Override
    protected int setViewID(){
        return R.layout.fragment_aboutme;
    }

    @Override
    protected void findViews(View mView){
        left_top_img = (ImageView) mView.findViewById(R.id.left_top_img_me);
        right_top_img = (ImageView) mView.findViewById(R.id.right_top_img_me);
        user_header = (ImageView) mView.findViewById(R.id.user_head_me);
        textlogin_head_me = (TextView) mView.findViewById(R.id.textlogin_head_me);
        changeimg_head_me = (TextView) mView.findViewById(R.id.changeimg_head_me);
        myattention_me = mView.findViewById(R.id.myattention_me);
        shoucang_me = mView.findViewById(R.id.myshoucang_me);
        myComment = mView.findViewById(R.id.mycomment_me);
        game_me = mView.findViewById(R.id.game_me);
        fankui_me = mView.findViewById(R.id.fankui_me);
        img01_me = (ImageView) mView.findViewById(R.id.img01_me);
        img02_me = (ImageView) mView.findViewById(R.id.img02_me);
        img03_me = (ImageView) mView.findViewById(R.id.img03_me);
        text01_me = (TextView) mView.findViewById(R.id.text01_me);
        text02_me = (TextView) mView.findViewById(R.id.text02_me);
        text03_me = (TextView) mView.findViewById(R.id.text03_me);
    }

    @Override
    protected void initData(){
    }

    @Override
    protected void initEvent(){
        left_top_img.setOnClickListener(this);
        right_top_img.setOnClickListener(this);
        user_header.setOnClickListener(this);
        textlogin_head_me.setOnClickListener(this);
        changeimg_head_me.setOnClickListener(this);
        myattention_me.setOnClickListener(this);
        shoucang_me.setOnClickListener(this);
        myComment.setOnClickListener(this);
        game_me.setOnClickListener(this);
        fankui_me.setOnClickListener(this);
        img01_me.setOnClickListener(this);
        img02_me.setOnClickListener(this);
        img03_me.setOnClickListener(this);
        text01_me.setOnClickListener(this);
        text02_me.setOnClickListener(this);
        text03_me.setOnClickListener(this);
    }

    @Override
    protected void loadData(){
    }

    @Override
    protected void obtainContext(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            //1:3个
            case R.id.left_top_img_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.right_top_img_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_head_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(context, LoginRegisterActivity.class);
                context.startActivity(intent);
                break;
            case R.id.textlogin_head_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.changeimg_head_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();

                Intent imgIntent = new Intent();
                imgIntent.setAction(Intent.ACTION_GET_CONTENT);
                imgIntent.addCategory(Intent.CATEGORY_OPENABLE);
                imgIntent.setType("image/*");
                imgIntent.setType("png/*");
                startActivityForResult(imgIntent,1);





                break;
            //2:6个
            case R.id.img01_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();

                if(img01_status){
                    img01_me.setImageDrawable(context.getResources().getDrawable(R.drawable.night_personal_icon_yejian));
                    text01_me.setText("夜间模式");

                }else {

                    img01_me.setImageDrawable(context.getResources().getDrawable(R.drawable.night_personal_iocn_rijian));
                    text01_me.setText("日间模式");

                }
                img01_status = ! img01_status;






                break;
            case R.id.img02_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();

                if(img02_status){
                    img02_me.setImageDrawable(context.getResources().getDrawable(R.drawable.night_personal_iocn_wenzi));
                    text02_me.setText("文字模式");

                }else {

                    img02_me.setImageDrawable(context.getResources().getDrawable(R.drawable.night_personal_iocn_tupian));
                    text02_me.setText("图片模式");

                }
                img02_status = ! img02_status;


                break;
            case R.id.img03_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();



                break;
            case R.id.text01_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text02_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text03_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            //3:5个
            case R.id.myattention_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myshoucang_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mycomment_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.game_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fankui_me:
                Toast.makeText(context, "ads", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);






    }
}
