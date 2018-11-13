package com.gft.lab_rs.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gft.lab_rs.R;
import com.gft.lab_rs.base.BaseFragment;

public class ContentFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_content;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }
}