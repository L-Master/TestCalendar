package me.xiangbei.testcalendar.theme;
/*
 *  @项目名：  TestCalendar 
 *  @包名：    me.xiangbei.testcalendar.theme
 *  @文件名:   DefultWeekTheme
 *  @创建者:   zcj
 *  @创建时间:  2016/11/22 22:33
 *  @描述：    TODO
 */

import android.graphics.Color;

public class DefultWeekTheme implements IWeekTheme {
    @Override
    public int colorTopLinen() {
        return Color.parseColor("#CCE4F2");
    }

    @Override
    public int colorBottomLine() {
        return Color.parseColor("#CCE4F2");
    }

    @Override
    public int colorWeekday() {
        return Color.parseColor("#1FC2F3");
    }

    @Override
    public int colorWeekend() {
        return Color.parseColor("#fa4451");
    }

    @Override
    public int colorWeekView() {
        return Color.parseColor("#FEFEFF");
    }

    @Override
    public int sizeLine() {
        return 4;
    }

    @Override
    public int sizeText() {
        return 14;
    }
}
