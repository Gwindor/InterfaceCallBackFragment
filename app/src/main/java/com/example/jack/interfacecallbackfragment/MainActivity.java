package com.example.jack.interfacecallbackfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements SecondFragment.CallBackSecondFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Fragment firstFragment = FirstFragment.newInstance();
            Fragment secondFragment = SecondFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.firstFragment, firstFragment)
                    .add(R.id.secondFragment, secondFragment)
                    .commit();
        }
    }

    @Override
    public void sendMessageFromFirstFragment(String msg) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.firstFragment);
        if (fragment != null && fragment instanceof FirstFragment) {
            FirstFragment firstFragment = (FirstFragment) fragment;
            firstFragment.editTextView(msg);
        }
    }
}
