package com.example.mvclogin.Controller;

import android.content.Intent;

import com.example.mvclogin.MainActivity;
import com.example.mvclogin.Model.User;
import com.example.mvclogin.R;
import com.example.mvclogin.View.ILoginView;

public class LoginController implements ILoginController {

    ILoginView iLoginView;

    public LoginController(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void OnLogin(String email, String password) {

        User user=new User(email,password);
        int LoginCode=user.isValid();

        if (LoginCode==0){
            iLoginView.OnLoginFailure("Please Enter Email!");
        }else if (LoginCode==1){
            iLoginView.OnLoginFailure("Please Enter a Valid Email");
        }else if (LoginCode==2){
            iLoginView.OnLoginFailure("Please Enter a Password");
        }else if (LoginCode==3){
            iLoginView.OnLoginFailure("Password should be in 6 character");
        }
        else {
            iLoginView.OnLoginSuccess("Login Success");
        }


    }
}
