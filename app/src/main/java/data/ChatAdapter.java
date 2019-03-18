package data;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.virus.livechat.R;

import java.util.ArrayList;
import java.util.List;

import model.Message;

public class ChatAdapter extends ArrayAdapter<Message> {

    private String mUerId;

    public ChatAdapter(Context context , String userId , List<Message> messages) {
        super(context, 0, messages);

        mUerId = userId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.chat_row, parent, false);

            final ViewHolder holder = new ViewHolder();
            holder.imageLeft = convertView.findViewById(R.id.imgProfileLeft);
            holder.imageRight = convertView.findViewById(R.id.imgProfileRight);

            holder.body = convertView.findViewById(R.id.textBody);
            convertView.setTag(holder);
        }
        final Message message = getItem(position);
        final ViewHolder holder = (ViewHolder) convertView.getTag();
        final boolean isMe = message.getUserId().equals(mUerId);

        if(isMe){
            holder.imageRight.setVisibility(View.VISIBLE);
            holder.imageLeft.setVisibility(View.GONE);
            holder.body.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        }else{
            holder.imageRight.setVisibility(View.GONE);
            holder.imageLeft.setVisibility(View.VISIBLE);
            holder.body.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        }

        final ImageView profileView = isMe ? holder.imageRight : holder.imageLeft;
        holder.body.setText(message.getBody());

        return super.getView(position, convertView, parent);

    }

    class ViewHolder{
        public ImageView imageLeft , imageRight;
        public TextView body;
    }
}
