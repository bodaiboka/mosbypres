package hu.ott_one.mosbydemo.stock;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import hu.ott_one.mosbydemo.R;
import hu.ott_one.mosbydemo.adapter.UserAdapter;
import hu.ott_one.mosbydemo.model.User;

/**
 * Created by richardbodai on 2/11/17.
 */
public class UserFragmentStock extends Fragment {

    protected ListView listUser;
    protected UserAdapter adapter;
    protected TextView tvFragmentName;
    protected ProgressBar progressBar;
    protected Button btnLoad;
    protected View.OnClickListener loadButtonListener;

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

    protected void findViews(View view) {
        listUser = (ListView) view.findViewById(R.id.list_users);
        tvFragmentName = (TextView) view.findViewById(R.id.tv_fragment_name);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        btnLoad = (Button) view.findViewById(R.id.btn_load);
        btnLoad.setOnClickListener(loadButtonListener);
        tvFragmentName.setText(getClass().getSimpleName());
    }

}
