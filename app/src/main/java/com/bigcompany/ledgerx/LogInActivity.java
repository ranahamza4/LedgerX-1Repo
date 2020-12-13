package com.bigcompany.ledgerx;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bigcompany.ledgerx.Users.HomeActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    TextView mSignUpTxt;
    Button mLoginBtn;
    TextInputLayout mUserNameLoginTxtField, mPasswordLoginTxtField;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();
        mSignUpTxt = findViewById(R.id.signUp_textView);
        mLoginBtn = findViewById(R.id.login_button);
        mUserNameLoginTxtField = findViewById(R.id.username_TextField);
        mPasswordLoginTxtField = findViewById(R.id.password_TextField);

        mAuth = FirebaseAuth.getInstance();

        mSignUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this, SignupActivity.class));
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mUserNameLoginTxtField.getEditText().getText().toString().trim();
                String password = mPasswordLoginTxtField.getEditText().getText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mUserNameLoginTxtField.setError("Invalid Email!");
                    mUserNameLoginTxtField.setFocusable(true);
                } else if (password.length() < 6) {
                    mPasswordLoginTxtField.setError("Password contain atleast 6 characters!");
                    mPasswordLoginTxtField.setFocusable(true);
                } else {
                    loginUser(email, password);
                }
            }
        });
    }

    private void loginUser(String email, String password) {

       //disabling login check for test purposes
        startActivity(new Intent(LogInActivity.this, HomeActivity.class));



        /*mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Singed in as "+user.getEmail(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Error Occurred!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    */
    }
}