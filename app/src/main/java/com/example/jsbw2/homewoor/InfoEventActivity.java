package com.example.jsbw2.homewoor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


/**
 * Created by jsbw2 on 2017-10-30.
 */

public class InfoEventActivity extends Activity {
    Button backButton;
    Intent intent;
    TextView textView1;
    ImageView imageView;
    Button goSite;
    int num=0;
    public void onCreate(Bundle saveInstamceState){
        super.onCreate(saveInstamceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.infoevent);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView1 = (TextView) findViewById(R.id.textView);

        intent = getIntent();

        final String string = intent.getStringExtra("go");
        num= Integer.valueOf(string).intValue();
        backButton = (Button) findViewById(R.id.backButton) ;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 finish();

            }
        });

        num = num-1;
        imageView.setImageResource(R.drawable.festival1+num);

        int j=0;
        int z=0;
        try {

            String ss;
            InputStream is = getResources().openRawResource(R.raw.festivalinseoul);
            byte[] readStr = new byte[is.available()];
            is.read(readStr);
            ss= new String(readStr);
            String[] Info = ss.split("#");
            String[][] Infomation = new String[30][8];

            for(int i=0;i<Info.length;i++){

                Infomation[j][z]=Info[i];
                z++;
                if(z==8){
                    j++;
                    z=0;
                }
            }

            String text="\n\n\n";
            String aa[] ={"제목","기간","전화번호","위치","가격","인원제한수","시간" ,"내용"
            };

            for(int i=0;i<Infomation.length;i++) {

                text += aa[i]+": "+Infomation[num][i]+"\n\n";
                textView1.setText(text);
            }
            is.close();

            goSite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://korean.visitseoul.net/event-festival"));
                    startActivity(intent);
                }
            });


        }

        catch (Exception e ){

        }

}



}

