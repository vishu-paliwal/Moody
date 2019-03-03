package com.example.ishrak.moody;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.moody.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Profiledisplay extends AppCompatActivity {

    ImageView photoTV;
    TextView nameTV,emailTV,idTV;
    Button sign_out;
    GoogleSignInClient mGoogleSignInClient;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_profile);
        sign_out = (Button)findViewById(R.id.log_out);
        nameTV = (TextView) findViewById(R.id.name);
        emailTV = (TextView) findViewById(R.id.email);
        idTV = (TextView) findViewById(R.id.id);
        photoTV=(ImageView) findViewById(R.id.photo) ;



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(Profiledisplay.this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            nameTV.setText(personName);
            emailTV.setText(personEmail);
            idTV.setText(personId);
            Glide.with(this).load(personPhoto).into(photoTV);

        }
        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // ...
                    case R.id.log_out:
                        signOut();
                        break;
                    // ...
                }
            }
        });



    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Profiledisplay.this,"successfully signed out" , Toast.LENGTH_SHORT);

                        startActivity(new Intent(Profiledisplay.this, MainActivity.class));
                        finish();
                    }
                });
    }

}
