package com.example.jack.interfacecallbackfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    public static final String TAG_FRAGMENT = "second fragment";
    CallBackSecondFragment callBackSecondFragment;
    private TextView et;
    private Button btn;

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
        initInterface();
    }

    private void initInterface() {
        callBackSecondFragment = (CallBackSecondFragment) getActivity();
    }

    private void initView(View view) {
        et = (TextView) view.findViewById(R.id.et);
        btn = (Button) view.findViewById(R.id.btn_send);
    }

    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBackSecondFragment.sendMessageFromFirstFragment(et.getText().toString());
            }
        });
    }


    public interface CallBackSecondFragment {
        void sendMessageFromFirstFragment(String msg);
    }


}