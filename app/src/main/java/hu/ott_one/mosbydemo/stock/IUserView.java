package hu.ott_one.mosbydemo.stock;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.ArrayList;

import hu.ott_one.mosbydemo.model.User;

/**
 * Created by richardbodai on 2/10/17.
 */
public interface IUserView extends MvpView {

    void displayUsers(ArrayList<User> users);
    void showLoader(boolean isVisible);
    void showMessage(String message);
}
