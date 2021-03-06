package com.vincent.template.views;


import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * packageName:	    com.vincent.template.views
 * className:	    WinProgress
 * author:	        Luoxiang
 * time:	        2017/4/4	15:24
 * desc:	        模仿win10系统的进度圈
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/4/4
 * upDateDesc:      TODO
 */


public class WinProgress
        extends View
{
    private Paint       mPaint;
    private Path        mPath;
    private PathMeasure mPathMeasure;
    private int         mWidth, mHeight;
    private ValueAnimator valueAnimator;
    //默认给100px像素大小
    private int mDefultSize = 100;
    //用这个来接受ValueAnimator的返回值，代表整个动画的进度
    private float         t;

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    private int mColor = Color.WHITE;


    //设置圆圈大小 默认15个px
    private int mPointSize = 15;

    public WinProgress(Context context) {
        this(context, null);
    }

    public WinProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void show() {
        post(new Runnable() {
            @Override
            public void run() {
                setVisibility(VISIBLE);
                if (valueAnimator == null){
                    valueAnimator = ValueAnimator.ofFloat(0f, 1f)
                                                 .setDuration(3000);
                    valueAnimator.setRepeatCount(-1);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            t = (float) animation.getAnimatedValue();
                            invalidate();
                        }
                    });
                }
                valueAnimator.start();
            }
        });

    }

    public void dismiss() {
        post(new Runnable() {
            @Override
            public void run() {
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.cancel();
                setVisibility(GONE);
            }
        });

    }

    private void init() {

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mPointSize);
        mPaint.setColor(mColor);
        //设置画笔为园笔
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //抗锯齿
        mPaint.setAntiAlias(true);

        mPath = new Path();
        RectF rect = new RectF(-(getMeasuredWidth() / 2 - mPointSize / 2), -(getMeasuredHeight() / 2 - mPointSize / 2), getMeasuredWidth() / 2 - mPointSize / 2, getMeasuredHeight() / 2 - mPointSize / 2);
        mPath.addArc(rect, -90, 359.9f);


        mPathMeasure = new PathMeasure(mPath, false);

        valueAnimator = ValueAnimator.ofFloat(0f, 1f)
                                     .setDuration(3000);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                t = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(mDefultSize, widthSize);
        } else {
            width = mDefultSize;
        }

        width += getPaddingLeft() + getPaddingRight();
        width = Math.max(width, getSuggestedMinimumWidth());
        if (heightMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(mDefultSize, heightSize);
        } else {
            height = mDefultSize;
        }
        height += getPaddingTop() + getPaddingBottom();
        height = Math.max(height, getSuggestedMinimumHeight());

        setMeasuredDimension(width, height);

        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        Path dst = new Path();
        if (t >= 0.95) {
            canvas.drawPoint(0, -(getMeasuredHeight() / 2 - mPointSize / 2), mPaint);
        }
        int   num = (int) (t / 0.05);
        float s, y, x;
        switch (num) {
            default:
            case 3:
                x = t - 0.15f * (1 - t);
                s = mPathMeasure.getLength();
                y = -s * x * x + 2 * s * x;
                mPathMeasure.getSegment(y, y + 1, dst, true);
            case 2:
                x = t - 0.10f * (1 - t);
                s = mPathMeasure.getLength();
                y = -s * x * x + 2 * s * x;
                mPathMeasure.getSegment(y, y + 1, dst, true);
            case 1:
                x = t - 0.05f * (1 - t);
                s = mPathMeasure.getLength();
                y = -s * x * x + 2 * s * x;
                mPathMeasure.getSegment(y, y + 1, dst, true);
            case 0:
                x = t;
                s = mPathMeasure.getLength();
                y = -s * x * x + 2 * s * x;
                mPathMeasure.getSegment(y, y + 1, dst, true);
                break;
        }
        canvas.drawPath(dst, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    public int getPointSize() {
        return mPointSize;
    }

    public void setPointSize(int pointSize) {
        mPointSize = pointSize;
    }

}
