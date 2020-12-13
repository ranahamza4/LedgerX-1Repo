package com.bigcompany.ledgerx.Users;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bigcompany.ledgerx.Loans.LoanActivity;
import com.bigcompany.ledgerx.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.UserDataViewHolder> {

 private UserData mUserDataArray[];
 Context context;

    public UserDataAdapter(UserData[] mUserData, HomeActivity activity) {
        this.mUserDataArray = mUserData;
        this.context = activity;
    }

    @NonNull
    @Override
    public UserDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.user_view_listfile,parent,false);
        UserDataViewHolder viewHolder= new UserDataViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserDataViewHolder holder, int position) {
 final UserData mUserDataList= mUserDataArray[position];

         holder.mUserNameTextView.setText(mUserDataList.getmUserName());
//      holder.mLastEditTimeAndDate.setText(mUserDataList.getmLastTimeEdited());
      holder.mUserGiveTextView.setText(""+mUserDataList.getmTotalGiveAmount());
      holder.mUserTakeTextView.setText(""+mUserDataList.getmTotalTakeAmount());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(context,mUserDataList.getmUserName(),Toast.LENGTH_SHORT).show();

              Intent intent= new Intent(context, LoanActivity.class);
              context.startActivity(intent);


          }
      });
    }

    @Override
    public int getItemCount() {
        return mUserDataArray.length;
    }

    public class UserDataViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mUserImageView;
        private TextView mUserNameTextView;
        private TextView mLastEditTimeAndDate;
        private TextView mUserGiveTextView;
        private TextView mUserTakeTextView;
        public UserDataViewHolder(@NonNull View itemView) {
            super(itemView);

           // mUserGiveTextView= itemView.findViewById(R.id.user_profileimage_view);

            mUserNameTextView= itemView.findViewById(R.id.other_username_textView);
          //  mLastEditTimeAndDate=itemView.findViewById(R.id.last_edited_DateAndTime_TextView);
            mUserGiveTextView=itemView.findViewById(R.id.user_TotalGive_TextView);
            mUserTakeTextView=itemView.findViewById(R.id.user_TotalTake_TextView);

        }
    }
}
