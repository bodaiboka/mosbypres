package hu.ott_one.mosbydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hu.ott_one.mosbydemo.R;
import hu.ott_one.mosbydemo.model.User;

/**
 * Created by richardbodai on 2/10/17.
 */
public class UserAdapter extends ArrayAdapter<User> {

    private static class ViewHolder {
        TextView tvUserName;
    }

    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, R.layout.listitem_user, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_user, parent, false);
            viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tv_user_name);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvUserName.setText(user.getName());
        return convertView;
    }
}
