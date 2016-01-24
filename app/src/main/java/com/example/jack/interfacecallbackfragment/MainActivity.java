package com.example.jack.interfacecallbackfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FirstFragment.CallBackFirstFragment, SecondFragment.CallBackSecondFragment {
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            firstFragment = FirstFragment.newInstance();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment, firstFragment, FirstFragment.TAG_FRAGMENT)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void createFragment2() {
        secondFragment = SecondFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, secondFragment)
                .commit();
    }

    @Override
    public void sendMessageFromFirstFragment(String msg) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, firstFragment);
        fragmentTransaction.commit();
        if (firstFragment != null) {
            firstFragment.editTextView(msg);
        }
    }
}
