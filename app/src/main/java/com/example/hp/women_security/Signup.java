package com.example.hp.women_security;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLOutput;

public class Signup extends AppCompatActivity {
Button sign;
    EditText name,email,phone,pass,confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        sign=(Button)findViewById(R.id.signup);
        name=(EditText)findViewById(R.id.Name);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.Phone);
        pass=(EditText)findViewById(R.id.password);
        confirm=(EditText)findViewById(R.id.confirm);


        name.addTextChangedListener(new MyTextWatcher(name));
        email.addTextChangedListener(new MyTextWatcher(email));
        pass.addTextChangedListener(new MyTextWatcher(pass));
        phone.addTextChangedListener(new MyTextWatcher(phone));
        confirm.addTextChangedListener(new MyTextWatcher(confirm));

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitForm();

            }
        });
    }
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }
        if (!validatephone()) {
            return;
        }
        if(!validateconfirmpass()){
            return;
        }

        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Signup.this,Resetpass.class);
        startActivity(i);
    }

    private boolean validateName() {
        if (name.getText().toString().trim().isEmpty()) {
            name.setError(getString(R.string.err_msg_name));
            requestFocus(name);
            return false;
        } else {
            //name.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateconfirmpass() {
        String pass1 = pass.getText().toString().trim();
        String cpass1=confirm.getText().toString();

        if (cpass1.isEmpty() || !isValidconfirm(cpass1,pass1)) {
            confirm.setError(getString(R.string.err_msg_confirm));
            requestFocus(confirm);
            return false;
        } else {
            //inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateEmail() {
        String emails = email.getText().toString().trim();

        if (emails.isEmpty() || !isValidEmail(emails)) {
            email.setError(getString(R.string.err_msg_email));
            requestFocus(email);
            return false;
        } else {
            //inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatephone() {

String phno=phone.getText().toString();

        if (phno.isEmpty() || !isValidphoneno(phno)) {
            phone.setError(getString(R.string.err_msg_phone));
            requestFocus(phone);
            return false;
        } else {
            //inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (pass.getText().toString().trim().isEmpty()) {
            pass.setError(getString(R.string.err_msg_password));
            requestFocus(pass);
            return false;
        } else {
            //pass.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private static boolean isValidconfirm(String con,String pass) {
        boolean r=!TextUtils.isEmpty(con) && con.equals(pass);
        return r;
    }
    private static boolean isValidphoneno(String phno) {
        return !TextUtils.isEmpty(phno) && Patterns.PHONE.matcher(phno).matches();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.Name:
                    validateName();
                    break;
                case R.id.email:
                    validateEmail();
                    break;
                case R.id.password:
                    validatePassword();
                    break;
                case R.id.Phone:
                    validatephone();
                    break;
                case R.id.confirm:
                    validateconfirmpass();

            }
        }
    }
}
