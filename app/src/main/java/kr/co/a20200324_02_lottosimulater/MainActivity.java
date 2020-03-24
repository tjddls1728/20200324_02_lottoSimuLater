package kr.co.a20200324_02_lottosimulater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import kr.co.a20200324_02_lottosimulater.databinding.ActivityMainBinding;

public class MainActivity extends baseActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setupValues();

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setupValues() {

    }
}
