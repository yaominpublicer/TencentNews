package com.microsoft.tencentnews.modules.fragment_aboutme.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.base.BaseFragment;

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

    @Override
    protected int setViewID(){
        return R.layout.fragment_aboutme;
    }

    @Override
    protected void findViews(View mView){


        left_top_img = (ImageView) mView.findViewById(R.id.left_top_img_me);
        right_top_img = (ImageView) mView.findViewById(R.id.right_top_img_me);
        user_header = (ImageView) mView.findViewById(R.id.user_head_me);

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
    public void onClick(View view) {

        switch (view.getId()){

            //1:3个

            case R.id.left_top_img_me:

                break;

            case R.id.right_top_img_me:

                break;

            case R.id.user_head_me:

                break;


            //2:6个
            case R.id.img01_me:

                break;

            case R.id.img02_me:

                break;

            case R.id.img03_me:

                break;


            case R.id.text01_me:

                break;
            case R.id.text02_me:

                break;

            case R.id.text03_me:

                break;

            //3:5个

            case R.id.myattention_me:

                break;

            case R.id.myshoucang_me:

                break;

            case R.id.mycomment_me:

                break;

            case R.id.game_me:

                break;
            case R.id.fankui_me:

                break;








        }





    }
}
