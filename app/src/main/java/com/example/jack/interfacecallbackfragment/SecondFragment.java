package com.example.jack.interfacecallbackfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private static final String TAG_FRAGMENT = "second fragment";
    private CallBackSecondFragment mCallBackSecondFragment;
    private TextView mEt;
    private Button mBtn;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBackSecondFragment = (CallBackSecondFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(this.getClass().getSimpleName() + " must implement HomeFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        mCallBackSecondFragment = null;
        super.onDetach();
    }

    private void initView(View view) {
        mEt = (TextView) view.findViewById(R.id.et);
        mBtn = (Button) view.findViewById(R.id.btn_send);
    }

    private void initListener() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageFromFirstFragment();
            }
        });
    }

    private void sendMessageFromFirstFragment() {
        mCallBackSecondFragment.sendMessageFromFirstFragment(mEt.getText().toString());
    }


    public interface CallBackSecondFragment {
        void sendMessageFromFirstFragment(String msg);
    }


}