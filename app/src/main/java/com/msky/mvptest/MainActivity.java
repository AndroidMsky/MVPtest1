package com.msky.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.msky.mvptest.Presenter.PersonPresenter;
import com.msky.mvptest.Presenter.iPersonPresenter;
import com.msky.mvptest.View.iPersonView;

public class MainActivity extends AppCompatActivity implements iPersonView {

    private TextView textView;
    private iPersonPresenter personPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personPresenter=new PersonPresenter(this);
        textView=(TextView)findViewById(R.id.textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personPresenter.getPersonByID();
            }
        });




    }

    @Override
    public void setPersoninformation(String s) {
        textView.setText(s);
    }

    @Override
    public int getid() {
        return 1110;
    }
}
