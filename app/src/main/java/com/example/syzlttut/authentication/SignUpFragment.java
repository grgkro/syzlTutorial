package com.example.syzlttut.authentication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.syzlttut.R;

public class SignUpFragment extends Fragment {

    private static final String TAG = "SignUpFragment";

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button signUpButton;
    private String email;
    private String password;

    @Override
    public void onStart() {

        super.onStart();
        editTextEmail = getView().findViewById(R.id.editTextEmail);
        editTextPassword = getView().findViewById(R.id.editTextPassword);
        signUpButton = getView().findViewById(R.id.signUpButton);

        editTextEmail.requestFocus();
        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    signUp();
                    handled = true;
                }
                return handled;
            }
        });
        signUpButton.setOnClickListener(v -> signUp());
    }

    private void signUp() {
        Log.i(TAG, "signUp: clicked");
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        if (validateInput(email, password)) {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.viewConfirm);
        }
    }

    private boolean validateInput(String email, String password) {
        return email != null && email.length() > 0 && password != null && password.length() > 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }
}