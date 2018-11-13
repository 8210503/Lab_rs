package com.gft.lab_rs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.gft.lab_rs.R;
import com.gft.lab_rs.base.BaseFragment;
import com.gft.lab_rs.fragment.mediumFragment.AddFragment;
import com.gft.lab_rs.fragment.mediumFragment.SeeFragment;
import com.gft.lab_rs.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * medium 培养基
 */
public class MediumFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.image_see)
    ImageView imageSee;
    @BindView(R.id.image_add)
    ImageView imageAdd;

    @BindView(R.id.layout_see)
    FrameLayout layoutSee;
    @BindView(R.id.layout_add)
    FrameLayout layoutAdd;



    private Fragment fragment_see;
    private Fragment fragment_add;
    private FragmentTransaction ft;
    private FragmentManager mFragmentManager;
    private FragmentTransaction tran;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot_news;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

        //创建Fragment管理事务
        ft = getChildFragmentManager().beginTransaction();

        if (fragment_see == null) {
            fragment_see = new SeeFragment();
            ft.add(R.id.mendium_fram, fragment_see);
            ft.commit();
        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * 隐藏已经初始化的Fragment
     */
    private void hideFragment(FragmentTransaction tran) {
        if (fragment_see != null) {
            tran.hide(fragment_see);
        }
        if (fragment_add != null) {
            tran.hide(fragment_add);
        }
    }

    @OnClick({R.id.layout_see, R.id.layout_add})
    public void onViewClicked(View view) {
        tran = getChildFragmentManager().beginTransaction();
        hideFragment(tran);//隐藏已经add的fragment
        switch (view.getId()) {
            case R.id.layout_see:
                ToastUtils.showShort("点击了1");
                if (fragment_see == null) {
                    fragment_see = new SeeFragment();
                    tran.add(R.id.mendium_fram, fragment_see);
                } else {
                    tran.show(fragment_see);
                }
                imageAdd.setSelected(false);
                imageSee.setSelected(true);
                break;
            case R.id.layout_add:
                if (fragment_add == null) {
                    fragment_add = new AddFragment();
                    tran.add(R.id.mendium_fram, fragment_add);
                } else {
                    tran.show(fragment_add);
                }
                imageAdd.setSelected(true);
                imageSee.setSelected(false);
                break;
        }
        tran.commit();
    }
}
