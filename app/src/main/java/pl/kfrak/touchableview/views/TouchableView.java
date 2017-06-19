package pl.kfrak.touchableview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import pl.kfrak.touchableview.R;

import static android.R.attr.startX;
import static android.R.attr.startY;

/**
 * TODO: document your custom view class.
 */
public class TouchableView extends View implements View.OnTouchListener {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;
    private Paint paint;
    private float touchX;
    private float touchY;
    private float startX;
    private float startY;
    private float stopX;
    private float stopY;

   // private List<Point> points = new ArrayList<>:();

    public TouchableView(Context context) {
        super(context);
        init(null, 0);
    }

    public TouchableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TouchableView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }


    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.TouchableView, defStyle, 0);


        mExampleDimension = a.getDimension(
                R.styleable.TouchableView_exampleDimension,
                mExampleDimension);

        a.recycle();

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(mExampleDimension/2);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,0,mExampleDimension, mExampleDimension, paint);
        //canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, mExampleDimension, paint);
        canvas.drawCircle(touchX, touchY, mExampleDimension, paint);
        canvas.drawLine(startX, startY, stopX, stopY, paint);

        fori int i = 1; i<points.size; i++
                Points startpoint = points.get(i-1)
                        Points endpoints = points.get(i)
                                canvas.drawLine(startPoint.x, start, end, end, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        Log.d("TouchEvent", "x =" + touchX + "y = " + touchY);
        invalidate();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = touchX;
                startY = touchY;
                break;
            case MotionEvent.ACTION_MOVE:
                stopX = touchX;
                stopY = touchY;

                Point p = new Point;
                points.add(points);
                break;
        }
        return true;
    }
}
