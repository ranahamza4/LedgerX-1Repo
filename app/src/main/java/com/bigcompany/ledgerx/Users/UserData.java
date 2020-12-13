package com.bigcompany.ledgerx.Users;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserData {
    private String mUserName;
    private String mUserID;
    private String mUserEmail;
    private int mTotalGiveAmount;
    private int mTotalTakeAmount;
  private String mLastTimeEdited;
    private CircleImageView mUserImage;


    public UserData(String mUserName, String mUserID, String mUserEmail, int mTotalGiveAmount, int mTotalTakeAmount) {
        this.mUserName = mUserName;
        this.mUserID = mUserID;
        this.mUserEmail = mUserEmail;
        this.mTotalGiveAmount = mTotalGiveAmount;
        this.mTotalTakeAmount = mTotalTakeAmount;
    }

    public CircleImageView getmUserImage() {
        return mUserImage;
    }

    public void setmUserImage(CircleImageView mUserImage) {
        this.mUserImage = mUserImage;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserID() {
        return mUserID;
    }

    public void setmUserID(String mUserID) {
        this.mUserID = mUserID;
    }

    public String getmUserEmail() {
        return mUserEmail;
    }

    public void setmUserEmail(String mUserEmail) {
        this.mUserEmail = mUserEmail;
    }

    public int getmTotalGiveAmount() {
        return mTotalGiveAmount;
    }

    public void setmTotalGiveAmount(int mTotalGiveAmount) {
        this.mTotalGiveAmount = mTotalGiveAmount;
    }

    public int getmTotalTakeAmount() {
        return mTotalTakeAmount;
    }

    public void setmTotalTakeAmount(int mTotalTakeAmount) {
        this.mTotalTakeAmount = mTotalTakeAmount;
    }


    public String getmLastTimeEdited() {
        return mLastTimeEdited;
    }

    public void setmLastTimeEdited(String mLastTimeEdited) {
        this.mLastTimeEdited = mLastTimeEdited;
    }
}
