package com.shindejayesharun.imagenetworkload;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogo=findViewById(R.id.imgLogo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        downloadImageFromUri("https://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G");
    }

    private void downloadImageFromUri(String address) {
       URL url;
        try {
            url=new URL(address);
        } catch (MalformedURLException e) {
           url=null;
        }

        try {
            URLConnection conn=url.openConnection();
            conn.connect();
            InputStream in=conn.getInputStream();
            Bitmap bitmap= BitmapFactory.decodeStream(in);
            in.close();
            imgLogo.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
