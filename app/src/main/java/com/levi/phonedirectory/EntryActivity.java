package com.levi.phonedirectory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class EntryActivity extends AppCompatActivity {

    private Directory directory = new Directory();
    private Entry entry = null;
    private EditText txtName;
    private EditText txtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        txtName = findViewById(R.id.txtEntryName);
        txtNumber = findViewById(R.id.txtEntryNumber);

        // get parameters from starting activity
        Intent intent = getIntent();
        String search = intent.getStringExtra("SEARCH");
        String kind = intent.getStringExtra("KIND");
        try {
            directory = Directory.load(openFileInput("directory.dat"));
            Toast.makeText(this, "Read directory with " + directory.getNumEntries() + " entries.", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Cannot open directory!!!", Toast.LENGTH_LONG).show();
        }
        switch (kind) {
            case "ByName":
                // search by name
                txtName.setEnabled(false);
                entry = directory.searchByName(search);
                txtName.setText(search);
                if (entry.getNumber() != null) {
                    txtNumber.setText(entry.getNumber());
                } else {
                    directory.add(entry);
                }
                break;
            case "ByNumber":
                // search by number
            default:
        }
    }

    public void cancelSearch(View view) {
        finish();
    }

    public void saveSearch(View view) {
        // update entry
        // save directory to PRIVATE directory.dat
        // go back to starting activity
    }

}
