package hu.ott_one.mosbydemo.extend;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

import java.util.ArrayList;

import hu.ott_one.mosbydemo.R;
import hu.ott_one.mosbydemo.adapter.UserAdapter;
import hu.ott_one.mosbydemo.model.User;
import hu.ott_one.mosbydemo.stock.IUserView;
import hu.ott_one.mosbydemo.stock.UserPresenter;

/**
 * Created by richardbodai on 2/10/17.
 */
public class UserFragmentExtend extends MvpFragment<IUserView, UserPresenter> implements IUserView{

    ListView listUser;
    UserAdapter adapter;
    TextView tvFragmentName;
    ProgressBar progressBar;
    Button btnLoad;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        findViews(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new UserAdapter(getActivity(), new ArrayList<User>());
        adapter.setNotifyOnChange(true);
        listUser.setAdapter(adapter);
    }

    @Override
    public UserPresenter createPresenter() {
        return new UserPresenter();
    }

    @Override
    public void displayUsers(ArrayList<User> users) {
        adapter.clear();
        adapter.addAll(users);
    }

    @Override
    public void showLoader(boolean isVisible) {
        if (isVisible) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void findViews(View view) {
        listUser = (ListView) view.findViewById(R.id.list_users);
        tvFragmentName = (TextView) view.findViewById(R.id.tv_fragment_name);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        btnLoad = (Button) view.findViewById(R.id.btn_load);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadUsers();
            }
        });
        tvFragmentName.setText(getClass().getSimpleName());
    }
}
