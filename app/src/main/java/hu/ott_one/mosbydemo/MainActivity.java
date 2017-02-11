package hu.ott_one.mosbydemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import hu.ott_one.mosbydemo.delegate.UserFragmentDelegate;
import hu.ott_one.mosbydemo.extend.UserFragmentExtend;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    UserFragmentExtend userFragmentExtend;
    UserFragmentDelegate userFragmentDelegate;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initFragments();
    }

    private void findViews() {
        frameLayout = (FrameLayout)findViewById(R.id.main_frame);
    }

    public void onExtends(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, userFragmentExtend);
        fragmentTransaction.commit();
    }

    public void onDelegates(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, userFragmentDelegate);
        fragmentTransaction.commit();
    }

    public void onViewstate(View view) {

    }

    private void initFragments() {
        userFragmentExtend = new UserFragmentExtend();
        userFragmentDelegate = new UserFragmentDelegate();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_frame, userFragmentExtend);
        fragmentTransaction.commit();
    }
}
