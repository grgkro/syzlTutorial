package com.example.syzlttut.authentication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.syzlttut.R;

public class ConfirmFragment extends Fragment {

    private static final String TAG = "ConfirmFragment";

    private EditText editTextCode;
    private Button confirmButton;

    @Override
    public void onStart() {

        super.onStart();
        editTextCode = getView().findViewById(R.id.editTextCode);
        confirmButton = getView().findViewById(R.id.confirmButton);

        editTextCode.requestFocus();
        editTextCode.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    confirm();
                    handled = true;
                }
                return handled;
            }
        });



        InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        confirmButton.setOnClickListener(v -> confirm());
    }

    private void confirm() {
        Log.i(TAG, "confirm: clicked");
        String code = editTextCode.getText().toString();
        if (validateInput(code)) {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.viewConfirm);
        }
    }

    private boolean validateInput(String code) {
        return code != null && code.length() > 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_confirm, container, false);
    }
}