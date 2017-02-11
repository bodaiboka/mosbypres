package hu.ott_one.mosbydemo.stock;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;

import hu.ott_one.mosbydemo.api.GetUserTask;
import hu.ott_one.mosbydemo.model.User;

/**
 * Created by richardbodai on 2/10/17.
 */
public class UserPresenter extends MvpBasePresenter<IUserView> {

    GetUserTask getUserTask;

    private void cancelTaskIfRunning() {
        if (getUserTask != null) {
            getUserTask.cancel(true);
        }
    }

    public void loadUsers() {
        cancelTaskIfRunning(); // ha már folyamatban van a task visszavonjuk
        getUserTask = new GetUserTask(new GetUserTask.GetUserTaskListener() {
            @Override
            public void onPreLoadUsers() {
                if (isViewAttached()) {
                    getView().showLoader(true);
                }
            }

            @Override
            public void onUsersLoaded(ArrayList<User> users) {
                if (isViewAttached()) {
                    getView().displayUsers(users);
                }
            }

            @Override
            public void onPostLoadUsers() {
                if (isViewAttached()) {
                    getView().showLoader(false);
                }
            }

            @Override
            public void onError(Exception exception) {

            }
        });
        getUserTask.execute();
    }

    @Override
    public void detachView(boolean retainPresenterInstance) {
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance) {
            cancelTaskIfRunning();
        }
    }
}
