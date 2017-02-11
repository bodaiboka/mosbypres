package hu.ott_one.mosbydemo.api;

import android.os.AsyncTask;

import java.util.ArrayList;

import hu.ott_one.mosbydemo.model.User;

/**
 * Created by richardbodai on 2/10/17.
 */
public class GetUserTask extends AsyncTask<Void, Void, ArrayList<User>>{

    public static final int RESPONSETIME = 1000 * 4;

    public interface GetUserTaskListener {
        void onPreLoadUsers();
        void onUsersLoaded(ArrayList<User> users);
        void onPostLoadUsers();
        void onError(Exception exception);
    }

    GetUserTaskListener listener;

    public GetUserTask(GetUserTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onPreLoadUsers();
    }

    @Override
    protected ArrayList<User> doInBackground(Void... voids) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            users.add(new User("user_" + i));
        }
        try {
            Thread.sleep(RESPONSETIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
            listener.onError(e);
        }
        return users;
    }

    @Override
    protected void onPostExecute(ArrayList<User> users) {
        super.onPostExecute(users);
        listener.onPostLoadUsers();
        listener.onUsersLoaded(users);
    }


}
