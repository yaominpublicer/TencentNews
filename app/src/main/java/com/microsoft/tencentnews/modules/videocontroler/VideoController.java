package com.microsoft.tencentnews.modules.videocontroler;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.MediaController;

/**
 * Created by Administrator on 2016/7/10.
 */
public class VideoController extends MediaController {



    public VideoController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoController(Context context, boolean useFastForward) {
        super(context, useFastForward);
    }

    public VideoController(Context context) {
        super(context);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
