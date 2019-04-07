package com.levi.phonedirectory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchByName(View view) {
        // if a name has been supplied
        //      start an EntryActivity with SEARCH = name and KIND = ByName
        // else
        // display an error message (Toast)
    }

    public void searchByNumber(View view) {
        // if a number has been supplied
        //      start an EntryActivity with SEARCH = number and KIND = ByNumber
        // else
        // display an error message (Toast)
    }
}
