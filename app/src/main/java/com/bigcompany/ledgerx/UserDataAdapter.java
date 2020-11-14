package com.bigcompany.ledgerx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.ViewHolder> {

 private UserData mUserDataArray[];
 Context context;

    public UserDataAdapter(UserData[] mUserData, HomeActivity activity) {
        this.mUserDataArray = mUserData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.data_item_list,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
 final UserData mUserDataList= mUserDataArray[position];

         holder.mUserNameTextView.setText(mUserDataList.getmUserName());
//      holder.mLastEditTimeAndDate.setText(mUserDataList.getmLastTimeEdited());
      holder.mUserGiveTextView.setText(""+mUserDataList.getmTotalGiveAmount());
      holder.mUserTakeTextView.setText(""+mUserDataList.getmTotalTakeAmount());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              context.startActivity(new Intent(context, HisLedgerActivity.class));
          }
      });
    }

    @Override
    public int getItemCount() {
        return mUserDataArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mUserImageView;
        private TextView mUserNameTextView;
        private TextView mLastEditTimeAndDate;
        private TextView mUserGiveTextView;
        private TextView mUserTakeTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           // mUserGiveTextView= itemView.findViewById(R.id.user_profileimage_view);
            mUserNameTextView= itemView.findViewById(R.id.other_username_textView);
          //  mLastEditTimeAndDate=itemView.findViewById(R.id.last_edited_DateAndTime_TextView);
            mUserGiveTextView=itemView.findViewById(R.id.user_TotalGive_TextView);
            mUserTakeTextView=itemView.findViewById(R.id.user_TotalTake_TextView);

        }
    }
}
