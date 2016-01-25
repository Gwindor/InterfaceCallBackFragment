package com.example.jack.interfacecallbackfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jack on 23.01.16.
 */
public class FirstFragment extends Fragment {
    public static final String TAG_FRAGMENT = "first fragment";

    TextView tv;
    Button btn;
    CallBackFirstFragment callBackFirstFragment;
    private String SAVE_TAG = "save";

    public static FirstFragment newInstance() {
        FirstFragment firstFragment = new FirstFragment();
        return firstFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
        initInterface();
    }

    private void initView(View view) {
        tv = (TextView) view.findViewById(R.id.tv);
        btn = (Button) view.findViewById(R.id.btn_second_fragment);
    }

    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBackFirstFragment.createFragment2();
            }
        });
    }

    private void initInterface() {
        callBackFirstFragment = (CallBackFirstFragment) getActivity();
    }

    public void editTextView(String string) {
        tv.setText(string);
    }

    public interface CallBackFirstFragment {
        void createFragment2();
    }
}
