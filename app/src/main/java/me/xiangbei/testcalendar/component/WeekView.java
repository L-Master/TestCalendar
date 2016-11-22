package me.xiangbei.testcalendar.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import me.xiangbei.testcalendar.theme.DefultWeekTheme;
import me.xiangbei.testcalendar.theme.IWeekTheme;

/*
 *  @项目名：  TestCalendar 
 *  @包名：    me.xiangbei.testcalendar.component
 *  @文件名:   MotheView
 *  @创建者:   zcj
 *  @创建时间:  2016/11/22 22:21
 *  @描述：    TODO
 */

public class WeekView extends View {

    private DisplayMetrics mDisplayMetrics;
    private Paint mPaint;
    private IWeekTheme mWeekTheme;
    private String[] weekString = new String[]{"日","一","二","三","四","五","六"};

    public WeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WeekView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**
         * 1. 初始化资源文件.画笔,默认style.
         */
        mDisplayMetrics = getResources().getDisplayMetrics();
        mPaint = new Paint();
        mWeekTheme = new DefultWeekTheme();

    }

    public WeekView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int withSize = MeasureSpec.getSize(widthMeasureSpec);
        int withMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (withMode == MeasureSpec.AT_MOST)
        {
            withSize = (int) (mDisplayMetrics.density*30);
        }
        if (heightMode == MeasureSpec.AT_MOST){
            heightSize = (int) (mDisplayMetrics.density*300);
        }
        setMeasuredDimension(withSize ,heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        //画背景
        canvas.drawColor(mWeekTheme.colorWeekView());
        //画上边框线
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mWeekTheme.colorTopLinen());
        mPaint.setStrokeWidth(mWeekTheme.sizeLine());
        canvas.drawLine(0,0,width,0,mPaint);
        //画下边框
        mPaint.setColor(mWeekTheme.colorBottomLine());
        canvas.drawLine(0,height,width,height,mPaint);
        //画文字
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(mWeekTheme.sizeText()*mDisplayMetrics.density);
        int columnWidth = width / 7;
        for (int i=0 ;i<=weekString.length;i++){
            //1.获得文字
            String text = weekString[i];

            //2.得到文字宽度
            float textWidth = mPaint.measureText(text);

            //3.得到文字起始位置
            int startX = (int) (columnWidth*i + (columnWidth - textWidth)/2);
            int startY = (int) (height/2 - (mPaint.ascent() + mPaint.descent())/2);
            //4. 设置周末文字style
            if (text.indexOf("日")>-1 || text.indexOf("六")>-1){
                mPaint.setColor(mWeekTheme.colorWeekend());
            }else{
                mPaint.setColor(mWeekTheme.colorWeekday());
            }
            //5. 画文字
            canvas.drawText(text,startX,startY,mPaint);
        }


    }

    public void setWeekTheme(IWeekTheme weekTheme) {
        this.mWeekTheme = weekTheme;
    }

    /**
     * 设置星期的形式
     * @param weekString
     * 默认值	"日","一","二","三","四","五","六"
     */
    public void setWeekString(String[] weekString) {
        this.weekString = weekString;
    }
}
