package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.iview.IWheelYearPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 年份选择器
 * <p>
 * Picker for Years
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelYearPicker extends WheelPicker implements IWheelYearPicker {
    private int mYearStart = 1000, mYearEnd = 3000;
    private int mSelectedYear;

    public WheelYearPicker(Context context) {
        this(context, null);
    }

    public WheelYearPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        updateYears();
        mSelectedYear = Calendar.getInstance().get(Calendar.YEAR);
        updateSelectedYear();
    }

    private void updateYears() {
        List<String> data = new ArrayList<>();
        for (int i = mYearStart; i <= mYearEnd; i++)
            data.add(i+"年");
        super.setData(data);
    }

    private void updateSelectedYear() {
        setSelectedItemPosition(mSelectedYear - mYearStart);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelYearPicker");
    }

    @Override
    public void setYearFrame(int start, int end) {
        mYearStart = start;
        mYearEnd = end;
        mSelectedYear = getCurrentYearInt();
        updateYears();
        updateSelectedYear();
    }

    @Override
    public int getYearStart() {
        return mYearStart;
    }

    @Override
    public void setYearStart(int start) {
        mYearStart = start;
        mSelectedYear = getCurrentYearInt();
        updateYears();
        updateSelectedYear();
    }

    @Override
    public int getYearEnd() {
        return mYearEnd;
    }

    @Override
    public void setYearEnd(int end) {
        mYearEnd = end;
        updateYears();
    }

    @Override
    public int getSelectedYear() {
        return mSelectedYear;
    }

    @Override
    public void setSelectedYear(int year) {
        mSelectedYear = year;
        updateSelectedYear();
    }

    @Override
    public String getCurrentYear() {
        return String.valueOf(getData().get(getCurrentItemPosition()));
    }

    public int getCurrentYearInt() {
        return getDataInt(getCurrentYear(),"年");
    }
}