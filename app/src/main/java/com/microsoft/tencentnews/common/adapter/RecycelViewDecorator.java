package com.microsoft.tencentnews.common.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.IllegalFormatFlagsException;

/**
 * Created by Administrator on 16-7-6.
 */
public class RecycelViewDecorator extends RecyclerView.ItemDecoration{


    private final int HORIZONTAL=1;
    private final int VERITAL = 0;
    private Context context;
    private int myorientation;

    int[] customattrs={android.R.attr.listDivider};
    private  Drawable dividerDrawable;

    public RecycelViewDecorator(Context context,int orientation){

        this.context = context ;
       setOrientation(orientation);
        TypedArray typedArray = context.obtainStyledAttributes(customattrs);
        dividerDrawable = typedArray.getDrawable(0);

        typedArray.recycle();


    }

    private void setOrientation(int orientation){
        if(HORIZONTAL == orientation || VERITAL == orientation){

            myorientation = orientation ;
        }else {

            throw  new IllegalFormatFlagsException("inputed orientation flag is error ");
        }
    }







    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state){
        super.onDraw(c, parent, state);

        if( HORIZONTAL==myorientation){

            //水平滑动 画竖线
            drawVeritalDividor(c,parent);

        }else {

            //竖直滑动 画横线
            drawHorizontalDividor(c,parent);
        }



    }

    private void drawVeritalDividor(Canvas c, RecyclerView parent){


        int top=parent.getPaddingTop();

        int bottom=parent.getHeight()-parent.getPaddingBottom();

        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child=parent.getChildAt(i);

            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();



            int left=child.getRight()+params.rightMargin;
            int right=left+dividerDrawable.getIntrinsicHeight();

            dividerDrawable.setBounds(left,top,right,bottom);
            dividerDrawable.draw(c);


        }


    }

    private void drawHorizontalDividor(Canvas c, RecyclerView parent){


        int left=parent.getPaddingLeft();
        int right=parent.getWidth()- parent.getPaddingRight();


        int childCount=parent.getChildCount();

        for(int i=0;i<childCount;i++){

            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();

            int top=child.getBottom()+params.bottomMargin;

            int bottom=top+dividerDrawable.getIntrinsicHeight();

            dividerDrawable.setBounds(left,top,right,bottom);
            dividerDrawable.draw(c);
            //Log.e("params.bottomMargin--", params.bottomMargin+"ViewCompat.getTranslationY(child):--"+ ViewCompat.getTranslationY(child)+":"+parent.toString());






        }


    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        super.getItemOffsets(outRect, view, parent, state);

        if(myorientation == HORIZONTAL){

            outRect.set(0,0,dividerDrawable.getIntrinsicWidth(),0);

        }else {
            outRect.set(0,0,0,dividerDrawable.getIntrinsicHeight());

        }

    }
}
