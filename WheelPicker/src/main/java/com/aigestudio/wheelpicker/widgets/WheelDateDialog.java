package com.aigestudio.wheelpicker.widgets;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.aigestudio.wheelpicker.R;
import com.aigestudio.wheelpicker.iview.IWheelDatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WheelDateDialog extends BaseDialog implements  IWheelDatePicker{
    private static final String deFormat = "yyyy年-MM月-dd日";
    private String mCustFormat;
    private SimpleDateFormat mDateFormat;
    private WheelYearPicker mPickerYear;
    private WheelMonthPicker mPickerMonth;
    private WheelDayPicker mPickerDay;
    private int mYear, mMonth, mDay;
    private Button mCancel, mConfirm, mRollback;
    private OnConfirmClickListener mConfirmClickListener;


    public void setDateFormat(String format) {
        mCustFormat = format;
    }


    private void setMaximumWidthTextYear() {
        List years = mPickerYear.getData();
        String lastYear = String.valueOf(years.get(years.size() - 1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastYear.length(); i++)
            sb.append("0");
        mPickerYear.setMaximumWidthText(sb.toString());
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        if (picker.getId() == R.id.wheel_date_picker_year) {
            mYear = picker.getDataInt(data, "年");
            mPickerDay.setYear(mYear);
        } else if (picker.getId() == R.id.wheel_date_picker_month) {
            mMonth = picker.getDataInt(data, "月");
            mPickerDay.setMonth(mMonth);
        }
        mDay = mPickerDay.getCurrentDayInt();
    }

    public interface OnConfirmClickListener {
        void onConfirmClick(WheelDateDialog dateDialog, String dateStr);
    }


    public void setConfirmClickListener(OnConfirmClickListener confirmClickListener) {
        mConfirmClickListener = confirmClickListener;
    }


    public void setVisibleItemCount(int count) {
        mPickerYear.setVisibleItemCount(count);
        mPickerMonth.setVisibleItemCount(count);
        mPickerDay.setVisibleItemCount(count);
    }


    public void setCyclic(boolean isCyclic) {
        mPickerYear.setCyclic(isCyclic);
        mPickerMonth.setCyclic(isCyclic);
        mPickerDay.setCyclic(isCyclic);
    }


    public void setSelectedItemTextColor(int color) {
        mPickerYear.setSelectedItemTextColor(color);
        mPickerMonth.setSelectedItemTextColor(color);
        mPickerDay.setSelectedItemTextColor(color);
    }


    public void setItemTextColor(int color) {
        mPickerYear.setItemTextColor(color);
        mPickerMonth.setItemTextColor(color);
        mPickerDay.setItemTextColor(color);
    }


    public void setItemTextSize(int size) {
        mPickerYear.setItemTextSize(size);
        mPickerMonth.setItemTextSize(size);
        mPickerDay.setItemTextSize(size);
    }

    public int getItemSpace() {
        if (mPickerYear.getItemSpace() == mPickerMonth.getItemSpace() &&
                mPickerMonth.getItemSpace() == mPickerDay.getItemSpace())
            return mPickerYear.getItemSpace();
        throw new RuntimeException("Can not get item space correctly from WheelDatePicker!");
    }

    public void setItemSpace(int space) {
        mPickerYear.setItemSpace(space);
        mPickerMonth.setItemSpace(space);
        mPickerDay.setItemSpace(space);
    }

    public void setIndicator(boolean hasIndicator) {
        mPickerYear.setIndicator(hasIndicator);
        mPickerMonth.setIndicator(hasIndicator);
        mPickerDay.setIndicator(hasIndicator);
    }


    public void setIndicatorSize(int size) {
        mPickerYear.setIndicatorSize(size);
        mPickerMonth.setIndicatorSize(size);
        mPickerDay.setIndicatorSize(size);
    }


    public void setIndicatorColor(int color) {
        mPickerYear.setIndicatorColor(color);
        mPickerMonth.setIndicatorColor(color);
        mPickerDay.setIndicatorColor(color);
    }

    public void setCurtain(boolean hasCurtain) {
        mPickerYear.setCurtain(hasCurtain);
        mPickerMonth.setCurtain(hasCurtain);
        mPickerDay.setCurtain(hasCurtain);
    }


    public void setCurtainColor(int color) {
        mPickerYear.setCurtainColor(color);
        mPickerMonth.setCurtainColor(color);
        mPickerDay.setCurtainColor(color);
    }

    public void setAtmospheric(boolean hasAtmospheric) {
        mPickerYear.setAtmospheric(hasAtmospheric);
        mPickerMonth.setAtmospheric(hasAtmospheric);
        mPickerDay.setAtmospheric(hasAtmospheric);
    }


    public void setCurved(boolean isCurved) {
        mPickerYear.setCurved(isCurved);
        mPickerMonth.setCurved(isCurved);
        mPickerDay.setCurved(isCurved);
    }


    @Override
    public void setItemAlignYear(int align) {
        mPickerYear.setItemAlign(align);
    }

    @Override
    public void setItemAlignMonth(int align) {
        mPickerMonth.setItemAlign(align);
    }

    @Override
    public void setItemAlignDay(int align) {
        mPickerDay.setItemAlign(align);
    }

    @Override
    public WheelYearPicker getWheelYearPicker() {
        return mPickerYear;
    }

    @Override
    public WheelMonthPicker getWheelMonthPicker() {
        return mPickerMonth;
    }

    @Override
    public WheelDayPicker getWheelDayPicker() {
        return mPickerDay;
    }


    public void setSelectedDay(int day) {
        mDay = day;
        mPickerDay.setSelectedDay(day);
    }

    public void setYearAndMonth(int year, int month) {
        mYear = year;
        mMonth = month;
        mPickerYear.setSelectedYear(year);
        mPickerMonth.setSelectedMonth(month);
        mPickerDay.setYearAndMonth(year, month);
    }


    @Override
    protected int loadLayoutId() {
        return R.layout.view_wheel_date_dialog;
    }

    @Override
    protected void initViews() {
        mPickerYear = $(R.id.wheel_date_picker_year);
        mPickerMonth = $(R.id.wheel_date_picker_month);
        mPickerDay = $(R.id.wheel_date_picker_day);
        mCancel = $(R.id.wheel_date_picker_cancel);
        mConfirm = $(R.id.wheel_date_picker_confirm);
        mRollback = $(R.id.wheel_date_picker_rollback);
    }

    @Override
    protected void initData() {
        mDateFormat = new SimpleDateFormat();
        setMaximumWidthTextYear();
        mPickerMonth.setMaximumWidthText("00");
        mPickerDay.setMaximumWidthText("00");

        mYear = mPickerYear.getCurrentYearInt();
        mMonth = mPickerMonth.getCurrentMonthInt();
        mDay = mPickerDay.getCurrentDayInt();
    }

    @Override
    protected void bindListener() {
        mPickerYear.setOnItemSelectedListener(this);
        mPickerMonth.setOnItemSelectedListener(this);
        mPickerDay.setOnItemSelectedListener(this);

        bindClickListener(mCancel, mRollback, mConfirm);
    }

    @Override
    protected void onClick(View view, int id) {
        if (id == R.id.wheel_date_picker_cancel)
            dismiss();
        else if (id == R.id.wheel_date_picker_rollback)
            doRollback();
        else
            callBack();
    }

    private void callBack() {
        if (null != mConfirmClickListener) {
            StringBuffer resultStr = new StringBuffer(mPickerYear.getCurrentYear())
                    .append("-")
                    .append(mPickerMonth.getCurrentMonth())
                    .append("-")
                    .append(mPickerDay.getCurrentDay());
            if (null == mCustFormat || TextUtils.equals(deFormat, mCustFormat)) {
                mConfirmClickListener.onConfirmClick(this, resultStr.toString());
                dismiss();
                return;
            }
            mDateFormat.applyPattern(deFormat);
            try {
                Date date = mDateFormat.parse(resultStr.toString());
                mDateFormat.applyPattern(mCustFormat);
                mConfirmClickListener.onConfirmClick(this, mDateFormat.format(date));
                dismiss();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        dismiss();
    }

    private void doRollback() {
        Calendar calendar = Calendar.getInstance();
        setYearAndMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
        setSelectedDay(calendar.get(Calendar.DAY_OF_MONTH));
    }


}