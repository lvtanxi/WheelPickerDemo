package com.aigestudio.wheelpicker.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aigestudio.wheelpicker.widgets.WheelDateDialog;

/**
 * User: 吕勇
 * Date: 2016-08-15
 * Time: 20:47
 * Description:
 */
public class DateAct extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_date2);
    }

    public void showDate(View view) {
        WheelDateDialog dateDialog=new WheelDateDialog();
        dateDialog.setConfirmClickListener(new WheelDateDialog.OnConfirmClickListener() {
            @Override
            public void onConfirmClick(WheelDateDialog dateDialog, String dateStr) {
                Toast.makeText(DateAct.this, dateStr, Toast.LENGTH_SHORT).show();
            }
        });
        dateDialog.show(getSupportFragmentManager(),"");
    }
}
