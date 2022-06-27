package com.example.login_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompatSideChannelService;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;

public class Activity2 extends AppCompatActivity {

    public static final int CAM_PER_CODE = 101;
    public static final int REQUEST_CODE_IMG = 1;
    ImageView capimg;
    TextView photolocation;
    String photopath;
    String picpath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();

        String username = intent.getStringExtra("user123");

        TextView textView = findViewById(R.id.usertxt);
        textView.setText(username);

        capimg = (ImageView) findViewById(R.id.profilepic);
        Button imgb = (Button) findViewById(R.id.imgbtn);
        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity2.this, "GO and CAPTURE AN IMAGE !!", Toast.LENGTH_SHORT).show();
                askper();
            }
        });
    }
    private void askper()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA}, CAM_PER_CODE);
        }
        else {
            opencam();
        }
    }

    @SuppressLint("MissingSuperCall")
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if(requestCode==CAM_PER_CODE)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                opencam();
            }
            else
            {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Grant Permission", Toast.LENGTH_SHORT).show();
        }

    }

    private void opencam()
    {

        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try{
            startActivityForResult(camera, REQUEST_CODE_IMG);

        }
        catch(ActivityNotFoundException e){
            Toast.makeText(this,"No Image ", Toast.LENGTH_SHORT).show();
    }
    }
    @SuppressLint("MissingSuperCall")
    protected void onActivityResult(int requestCode, int resultCode , Intent data)
    {
        if(requestCode==REQUEST_CODE_IMG && resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap img = (Bitmap) extras.get("data");
            capimg.setImageBitmap(img);
            File photofile = null;
            try{

                photofile=createImg();
                picpath = createImg().getAbsolutePath();
                photolocation = (TextView) findViewById(R.id.filepath);
                    photolocation.setText(picpath);

            }catch(IOException ex)
            {
                Toast.makeText(this, "NOT", Toast.LENGTH_SHORT).show();
            }

        }
    }
    private File createImg() throws IOException
    {
        String timest = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imgfilename = "JPEG_" + timest + "_";
        File storagedir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imgfilename,".jpg",storagedir
        );
        photopath=image.getAbsolutePath();
        return image;
    }
}