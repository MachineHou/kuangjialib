package com.lxj.xpopupdemo.custom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.haier.cellarette.baselibrary.R;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;

import java.util.ArrayList;
import java.util.List;

;


/**
 * Description: 自定义带有ViewPager的Bottom弹窗
 * Create by dance, at 2019/5/5
 */
public class PagerBottomPopup extends BottomPopupView {
    public PagerBottomPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_view_pager;
    }

    ViewPager pager;

    @Override
    protected void onCreate() {
        super.onCreate();
        pager = findViewById(R.id.pager);
        FragmentActivity activity = (FragmentActivity) getContext();
        pager.setAdapter(new PAdapter(activity.getSupportFragmentManager()));

//        ViewGroup.MarginLayoutParams params = (MarginLayoutParams) getPopupContentView().getLayoutParams();
//        params.bottomMargin = 200;
//        getPopupContentView().setLayoutParams(params);
    }

    @Override
    protected List<String> getInternalFragmentNames() {
        ArrayList<String> list = new ArrayList<>();
        list.add(TestFragment.class.getSimpleName());
        return list;
    }

    @Override
    protected void onShow() {
        super.onShow();
    }

    @Override
    protected void onDismiss() {
        super.onDismiss();
    }

    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getScreenHeight(getContext()) * .85f);
    }


}
