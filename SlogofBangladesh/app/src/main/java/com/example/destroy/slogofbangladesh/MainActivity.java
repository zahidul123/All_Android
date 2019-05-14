package com.example.destroy.slogofbangladesh;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        VideoView videoView = findViewById(R.id.video_view);
       // TextView tvc=(TextView)findViewById(R.id.textView);

      //  String data="";

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.vedio;
      /*  String videoPath2= "android.resource://" + getPackageName() + "/" + R.raw.dhaka;

        StringBuffer sbuffer=new StringBuffer();

        InputStream is=this.getResources().openRawResource(Integer.parseInt(videoPath2));

        BufferedReader breader=new BufferedReader(new InputStreamReader(is));

        try {
            while((data=breader.readLine())!=null){
                sbuffer.append("\n");

            }

            tvc.setText(sbuffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
