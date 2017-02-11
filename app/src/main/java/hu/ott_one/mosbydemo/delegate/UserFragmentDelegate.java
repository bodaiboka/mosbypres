package hu.ott_one.mosbydemo.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback;
import com.hannesdorfmann.mosby.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby.mvp.delegate.FragmentMvpDelegateImpl;

import hu.ott_one.mosbydemo.stock.IUserView;
import hu.ott_one.mosbydemo.stock.UserFragmentWithViewImpl;
import hu.ott_one.mosbydemo.stock.UserPresenter;

/**
 * Created by richardbodai on 2/10/17.
 */
public class UserFragmentDelegate extends UserFragmentWithViewImpl implements BaseMvpDelegateCallback<IUserView, UserPresenter>, IUserView{

    FragmentMvpDelegate<IUserView, UserPresenter> mvpDelegate = new FragmentMvpDelegateImpl<>(this);
    UserPresenter userPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpDelegate.onCreate(savedInstanceState);
        loadButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().loadUsers();
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mvpDelegate.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mvpDelegate.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mvpDelegate.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mvpDelegate.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mvpDelegate.onStop();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpDelegate.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mvpDelegate.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mvpDelegate.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mvpDelegate.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mvpDelegate.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public UserPresenter createPresenter() {
        userPresenter = new UserPresenter();
        return userPresenter;
    }

    @Override
    public UserPresenter getPresenter() {
        return userPresenter;
    }

    @Override
    public void setPresenter(UserPresenter presenter) {
        userPresenter = presenter;
    }

    @Override
    public IUserView getMvpView() {
        return this;
    }

    @Override
    public boolean isRetainInstance() {
        return false;
    }

    @Override
    public boolean shouldInstanceBeRetained() {
        return false;
    }

}
