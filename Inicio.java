package com.pierogranda.proyectointegrador12;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.pierogranda.proyectointegrador12.fragmentpricipal.MenuPrincipal1;

public class Inicio extends AppCompatActivity {

    private static final String TAG =Inicio.class.getSimpleName();
    /**     * Google SignIn     */
    /* Request code used to invoke sign in user interactions for Google+ */
    private static final int GOOGLE_SIGNIN_REQUEST = 1000;
    private ProgressBar progressBar;
    private View loginPanel;
    /* Client used to interact with Google APIs. */
    private GoogleApiClient mGoogleApiClient;
    /**
     *
     *
     * * Firebase Auth
     *
     * */
    private FirebaseAuth mAuth;
    private EditText emailInput;
    private EditText passwordInput;
    /**     * Firebase AuthStateListener     */
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        loginPanel = findViewById(R.id.login_panel);

        // Init FirebaseAuth
              initFirebaseAuth();

        // Init GoogleSignIn
        initGoogleSignIn();

             // Init FirebaseAuthStateListener
        initFirebaseAuthStateListener();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Log.d(TAG, "user: " + user);

    }

    private void initGoogleSignIn() {
        // Configure SingIn Button
             SignInButton mGoogleLoginButton = (SignInButton) findViewById(R.id.sign_in_button);
             mGoogleLoginButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     loginPanel.setVisibility(View.GONE);
                     progressBar.setVisibility(View.VISIBLE);
                     // OnClick Google SingIn Button
                     Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                     startActivityForResult(signInIntent, GOOGLE_SIGNIN_REQUEST);


                 }
             });




        // Configure sign-in to request the user's ID, email address, and basic profile. ID and basic profile areincluded in DEFAULT_SIGN_IN.
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("394878452182-f1v99t8delcsnflfref84au94om42iii.apps.googleusercontent.com")
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the options specified by gso.
               mGoogleApiClient = new GoogleApiClient.Builder(this)
                       .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                           @Override
                           public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                               // An unresolvable error has occurred and Google APIs (including Sign-In) will not be available.
                                                      Log.e(TAG, "onConnectionFailed:" + connectionResult);
                           }
                       })
                       .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                       .build();



    }

    @Override    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Log.d(TAG, "onActivityResult: " + requestCode);
            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
                      if (requestCode == GOOGLE_SIGNIN_REQUEST) {
                          GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                          if (result.isSuccess()) {
                              // Google Sign In was successful
                                                GoogleSignInAccount account = result.getSignInAccount();
                                                Log.d(TAG, "IC: " + account.getId());
                                                Log.d(TAG, "DISPLAYNAME: " + account.getDisplayName());
                                                Log.d(TAG, "EMAIL: " + account.getEmail());
                                                Log.d(TAG, "PHOTO: " + account.getPhotoUrl());
                                                Log.d(TAG, "TOKEN: " + account.getIdToken());
        // SignIn in firebaseAuthWithGoogle
                                              AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
                                              mAuth.signInWithCredential(credential)
                                                      .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                                          @Override
                                                          public void onComplete(@NonNull Task<AuthResult> task) {
                                                              Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                                                              if (!task.isSuccessful()) {
                                                                  loginPanel.setVisibility(View.VISIBLE);
                                                                  progressBar.setVisibility(View.GONE);
                                                                  Log.e(TAG, "signInWithCredential:failed", task.getException());
                                                                  Toast.makeText(Inicio.this, "Authentication failed.",
                                                                          Toast.LENGTH_SHORT).show();
                                                              }                                }
                                                      });


                          } else {
                              // Google Sign In failed, hide Progress Bar & Show Login Panel again
                                                loginPanel.setVisibility(View.VISIBLE);
                                                progressBar.setVisibility(View.GONE);
                                                Log.e(TAG, "Google Sign In failed!");
                          }
                      }
        }catch (Throwable t){
            try {
                // Google Sign In failed, hide Progress Bar & Show Login Panel again
                             loginPanel.setVisibility(View.VISIBLE);
                             progressBar.setVisibility(View.GONE);
                             Log.e(TAG, "onThrowable: " + t.getMessage(), t);
                             if(getApplication()!=null) Toast.makeText(getApplication(),
                                     t.getMessage(), Toast.LENGTH_LONG).show();
            } catch (Throwable x) {}
        }
    }

    @Override    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);    }

        @Override    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                callLogout(null);
                return true;
        }
                return super.onOptionsItemSelected(item);
    }

    private void callLogout(View view){
        Log.d(TAG, "Ssign out user");
        FirebaseAuth.getInstance().signOut();
        finish();
    }

    private void initFirebaseAuth(){
        // initialize the FirebaseAuth instance
             mAuth = FirebaseAuth.getInstance();
             emailInput = (EditText)findViewById(R.id.email_input);
             passwordInput = (EditText)findViewById(R.id.password_input);
    }

    public void callLogin(View view){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Debes completar estos campos", Toast.LENGTH_SHORT).show();
            return;
        }
        loginPanel.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        // Sign In user
             mAuth.signInWithEmailAndPassword(email, password)
                     .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                         @Override

                         public void onComplete(@NonNull Task<AuthResult> task) {
                             Log.d(TAG, "signInWithEmailAndPassword:onComplete:" + task.isSuccessful());
                             if (!task.isSuccessful()) {
                                 loginPanel.setVisibility(View.VISIBLE);
                                 progressBar.setVisibility(View.GONE);
                                 Log.e(TAG, "signInWithEmailAndPassword:failed", task.getException());
                                 Toast.makeText(Inicio.this, "Nombre de usuario y / o contraseña inválida", Toast.LENGTH_SHORT).show();

                             }
                         }
                     });
    }

    public void callRegister(View view){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "\n" +
                    "Debes completar estos campos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.length() < 6){
            Toast.makeText(this, "Usando una contraseña débil", Toast.LENGTH_SHORT).show();
            return;
        }
        loginPanel.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:" + task.isSuccessful());                    if (!task.isSuccessful()) {                        loginPanel.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "createUserWithEmailAndPassword:failed", task.getException());
                        Toast.makeText(Inicio.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initFirebaseAuthStateListener(){
    // and the AuthStateListener method so you can track whenever the user signs in or out
              mAuthListener = new FirebaseAuth.AuthStateListener() {
                  @Override
                  public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                      FirebaseUser user = firebaseAuth.getCurrentUser();
                      if (user != null) {
                          // User is signed in
                                           Log.d(TAG, "onAuthStateChanged:signed_in:"
                                                   + user.getUid());
                                           Toast.makeText(Inicio.this, "Welcome "
                                                   + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                                           // Go MainActivity
                                         startActivity(new Intent(Inicio.this, MenuPrincipal1.class));
                                         finish();
                      } else {
                          // User is signed out
                                           Log.d(TAG, "onAuthStateChanged:signed_out");
                      }
                  }
              };
}    @Override
public void onStart() {
    super.onStart();
    mAuth.addAuthStateListener(mAuthListener);
}    @Override
public void onStop() {
    super.onStop();
    if (mAuthListener != null) {
        mAuth.removeAuthStateListener(mAuthListener);
    }
}
}