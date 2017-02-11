package hu.ott_one.mosbydemo.stock;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import hu.ott_one.mosbydemo.model.User;

/**
 * Created by richardbodai on 2/11/17.
 */
public class UserFragmentWithViewImpl extends UserFragmentStock implements IUserView {
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
}
