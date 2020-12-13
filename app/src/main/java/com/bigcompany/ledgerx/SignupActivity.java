package com.bigcompany.ledgerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bigcompany.ledgerx.Users.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    TextView mLoginTxt;
    Button mSignUpBtn;
    TextInputLayout mSignUpEmailTxtField, mSignUpPasswordTxtField;

    FirebaseAuth mAuth;

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.getSupportActionBar().hide();

        mLoginTxt = findViewById(R.id.login_textView);
        mSignUpBtn = findViewById(R.id.signup_button);
        mSignUpEmailTxtField = findViewById(R.id.usernameSignup_TextField);
        mSignUpPasswordTxtField = findViewById(R.id.passwordSignup_TextField);

        mAuth = FirebaseAuth.getInstance();

        dialog = new ProgressDialog(this);
        dialog.setTitle("Registering User...");

        mLoginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LogInActivity.class));
            }
        });
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailSignUp = mSignUpEmailTxtField.getEditText().getText().toString().trim();
                String passwordSignUp = mSignUpPasswordTxtField.getEditText().getText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(emailSignUp).matches())
                {
                    mSignUpEmailTxtField.setError("Invalid Email!");
                    mSignUpEmailTxtField.setFocusable(true);
                }
                else if(passwordSignUp.length() < 6)
                {
                    mSignUpPasswordTxtField.setError("Password must have atleast 6 characters!!");
                    mSignUpPasswordTxtField.setFocusable(true);
                }
                else
                {
                    registerUser(emailSignUp, passwordSignUp);
                }
            }
        });
    }

    private void registerUser(String emailSignUp, String passwordSignUp) {
        dialog.show();
        mAuth.createUserWithEmailAndPassword(emailSignUp, passwordSignUp)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(SignupActivity.this, ""+user.getEmail()+" Register", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this, HomeActivity.class));
                            dialog.hide();
                        } else {
                            dialog.hide();
                            Toast.makeText(SignupActivity.this, "Registration Failed...", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.hide();
                Toast.makeText(SignupActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}