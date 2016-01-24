package com.example.jack.interfacecallbackfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FirstFragment.CallBackFirstFragment, SecondFragment.CallBackSecondFragment {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment, FirstFragment.newInstance(), FirstFragment.TAG_FRAGMENT)
                    .addToBackStack(null)
                    .commit();
        }
    }

    private void setFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment instanceof FirstFragment) {
            FirstFragment fFrag = (FirstFragment) fragmentManager.findFragmentByTag(FirstFragment.TAG_FRAGMENT);
            if (fFrag == null) {
                fragmentTransaction.replace(R.id.fragment, fragment, FirstFragment.TAG_FRAGMENT);
                fragmentTransaction.addToBackStack(null);
            } else {
                fragmentTransaction.replace(R.id.fragment, fragment, FirstFragment.TAG_FRAGMENT);
            }
        } else if (fragment instanceof SecondFragment) {
            fragmentTransaction.replace(R.id.fragment, fragment, SecondFragment.TAG_FRAGMENT);
        }

        fragmentTransaction.commit();
    }

    @Override
    public void createFragment() {
        setFragment(SecondFragment.newInstance());
    }

    @Override
    public void sendMessageFromFirstFragment(String msg) {
        Fragment fragment = fragmentManager.findFragmentByTag(FirstFragment.TAG_FRAGMENT);
        if (fragment != null && fragment instanceof FirstFragment) {
            FirstFragment firstFragment = (FirstFragment) fragment;
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment, firstFragment, FirstFragment.TAG_FRAGMENT)
                    .commit();
            firstFragment.tv.setText(msg);
        }
    }
}
