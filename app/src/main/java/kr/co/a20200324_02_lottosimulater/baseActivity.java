package kr.co.a20200324_02_lottosimulater;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class baseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setupEvents();
    public abstract void setupValues();



}
