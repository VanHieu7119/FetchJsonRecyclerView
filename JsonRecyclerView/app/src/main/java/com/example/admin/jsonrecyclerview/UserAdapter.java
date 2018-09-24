package com.example.admin.jsonrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUserList;



    public UserAdapter(Context context) {
        mContext = context;
        mUserList = new ArrayList<>();
    }

    public void updateData(List<User> listUser) {
        if (mUserList != null) {
            mUserList.clear();
        }
        assert mUserList != null;
        mUserList.addAll(listUser);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;
        itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User mUser = mUserList.get(i);
        viewHolder.mTextViewName.setText(mUser.getName());
        viewHolder.mTextViewId.setText(mUser.getId());
        Glide.with(mContext)
                .load(mUser.getAvatar_url())
                .apply(new RequestOptions().override(1000, 2000).centerCrop())
                .into(viewHolder.mImageViewAvatar);

    }

    @Override
    public int getItemCount() {
        return mUserList != null ? mUserList.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        private TextView mTextViewName;
        private TextView mTextViewId;
        private ImageView mImageViewAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.textViewName);
            mTextViewId = itemView.findViewById(R.id.textViewId);
            mImageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
            mImageViewAvatar.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"Position: "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
