package com.example.basektest.util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class ResourceManager {

    public static String readFromAssets(Context context, String filename) {
        String сontent = "";

        try {
            InputStream stream = context.getAssets().open(filename);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            сontent = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        return сontent;
    }
}
