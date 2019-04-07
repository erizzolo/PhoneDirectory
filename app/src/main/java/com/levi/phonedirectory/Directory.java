package com.levi.phonedirectory;

import android.app.Activity;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Directory implements Serializable {

    private Entry[] entries = new Entry[0];

    public Directory() {
    }

    public boolean save(OutputStream outputStream) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
        }
        return false;
    }

    public static Directory load(InputStream inputStream) {
        // return a Directory saved to the given stream with method save
        // or a new empty Directory
    }

    public Entry searchByName(String name) {
        Entry search = new Entry(name, null);
        Entry result = null;
        for (int i = 0; i < entries.length && result == null; i++) {
            if (search.equalsByName(entries[i])) {
                result = entries[i];
            }
        }
        return result == null ? search : result;
    }

    public Entry searchByNumber(String number) {
        // if an entry exists with a matching number
        //      return it
        // else
        //      return an entry with the given number and a null name
    }

    public void add(Entry e) {
        entries = Arrays.copyOf(entries, entries.length + 1);
        entries[entries.length - 1] = e;
    }

    public int getNumEntries() {
        return entries.length;
    }

}
