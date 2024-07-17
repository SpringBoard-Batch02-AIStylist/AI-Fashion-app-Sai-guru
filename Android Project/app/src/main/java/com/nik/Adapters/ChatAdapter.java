package com.nik.Adapters;

import static com.nik.R.color.white;

import android.annotation.SuppressLint;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nik.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<String> messages;

    private List<String> isUser;

    public ChatAdapter(List<String> messages,List<String> isUser) {
        this.messages = messages;
        this.isUser = isUser;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_response_item, parent, false);
        return new ChatViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.messageTextView.setText(messages.get(position));
        if(isUser.get(position).equals("yes"))
        {
            holder.messageTextView.setBackground(holder.itemView.getContext().getResources().getDrawable(R.drawable.bubble2));
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;

        ChatViewHolder(View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            messageTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
