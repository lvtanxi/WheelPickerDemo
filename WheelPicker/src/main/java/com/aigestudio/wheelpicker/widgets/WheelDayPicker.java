package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.iview.IWheelDayPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 日期选择器
 * <p>
 * Picker for Day
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelDayPicker extends WheelPicker implements IWheelDayPicker {

    private Calendar mCalendar;
    private String months_big ="135781012";
    private int mYear, mMonth;
    private int mSelectedDay;

    public WheelDayPicker(Context context) {
        this(context, null);
    }

    public WheelDayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        mCalendar = Calendar.getInstance();

        mYear = mCalendar.get(Calendar.YEAR);
        mMonth = mCalendar.get(Calendar.MONTH);

        updateDays();

        mSelectedDay = mCalendar.get(Calendar.DAY_OF_MONTH);

        updateSelectedDay();
    }

    private void updateDays() {
        mCalendar.set(Calendar.YEAR, mYear);
        mCalendar.set(Calendar.MONTH, mMonth);
        super.setData(getDays(mYear,String.valueOf(mMonth+1)));
    }

    private List<String> getDays(int cyear, String cmonth) {
        int count=0;
        List<String> days = new ArrayList<>();
        if ("2".equals(cmonth)) {
            // 闰年
            if ((cyear % 4 == 0 && cyear % 100 != 0) || cyear % 400 == 0)
                count=29;
            else
                count=28;
        } else if (months_big.contains(cmonth)) {
            count=31;
        } else {
            count=30;
        }
        for (int i = 1; i <10; i++) {
            days.add("0"+i + "日");
        }
        for (int i = 10; i <=count; i++) {
            days.add(i + "日");
        }
        return days;
    }

    private void updateSelectedDay() {
        setSelectedItemPosition(mSelectedDay - 1);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelDayPicker");
    }

    @Override
    public int getSelectedDay() {
        return mSelectedDay;
    }

    @Override
    public void setSelectedDay(int day) {
        mSelectedDay = day;
        updateSelectedDay();
    }

    @Override
    public String getCurrentDay() {
        return String.valueOf(getData().get(getCurrentItemPosition()));
    }

    public int getCurrentDayInt() {
        return getDataInt(getCurrentDay(),"日");
    }

    @Override
    public void setYearAndMonth(int year, int month) {
        mYear = year;
        mMonth = month - 1;
        updateDays();
    }

    @Override
    public int getYear() {
        return mYear;
    }

    @Override
    public void setYear(int year) {
        mYear = year;
        updateDays();
    }

    @Override
    public int getMonth() {
        return mMonth;
    }

    @Override
    public void setMonth(int month) {
        mMonth = month - 1;
        updateDays();
    }
}