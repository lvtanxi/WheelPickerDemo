package com.aigestudio.wheelpicker.widgets;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.aigestudio.wheelpicker.R;


/**
 * User: 吕勇
 * Date: 2016-08-16
 * Time: 09:00
 * Description:
 */
public abstract class BaseDialog extends DialogFragment implements View.OnClickListener{
    protected View contentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.dateDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initFragment(inflater);
        return contentView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initWindow();
        initData();
        bindListener();
    }

    private void initFragment(LayoutInflater inflater) {
        this.contentView = inflater.inflate(loadLayoutId(), null);
        initViews();
    }


    private void initWindow() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = Gravity.BOTTOM;
        window.setAttributes(attributes);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }




    /**
     * 为Fragment加载布局
     */
    protected abstract int loadLayoutId();

    /**
     * 初始化控件
     */
    protected abstract void initViews();

    /**
     * 初始化数
     */
    protected abstract void initData();

    /**
     * 为控件设置监
     */
    protected abstract void bindListener();

    /**
     * 控件点击回调
     */
    protected void onClick(View view, int id) {

    }

    @Override
    public void onClick(View v) {
        onClick(v, v.getId());
    }

    protected <T extends View> T $(@IdRes int viewId) {
        return (T) contentView.findViewById(viewId);
    }

    protected void bindClickListener(View... views) {
        for (View view : views) {
            if (view != null)
                view.setOnClickListener(this);
        }
    }


}
