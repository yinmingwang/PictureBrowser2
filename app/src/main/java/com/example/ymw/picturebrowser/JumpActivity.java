package com.example.ymw.picturebrowser;

/**
 * Created by ymw on 2016/6/28.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by ymw on 2016/6/28.
 */
public class JumpActivity extends Activity {
    private int pos;
    private int[] imgs = new int[] {
            R.drawable.img01,
            R.drawable.img02,
            R.drawable.img03,
            R.drawable.img04,
            R.drawable.img05,
            R.drawable.img06,
            R.drawable.img07,
            R.drawable.img08,
            R.drawable.img09,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jump);
        final ImageView  imgview = (ImageView) findViewById(R.id.imageView1);
        Intent intent = getIntent();
        pos =  (int) intent.getIntExtra("count", 0);
        final ImageView imgview2 = (ImageView) findViewById(R.id.imageView2);
        imgview2.setImageResource(R.drawable.img_return);
        final ImageButton imagebutton1 = (ImageButton) findViewById(R.id.imageButton1);
        imagebutton1.setImageResource(R.drawable.arrow_left);
        final ImageButton imagebutton2 = (ImageButton) findViewById(R.id.imageButton2);
        imagebutton2.setImageResource(R.drawable.arrow_right);
        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = pos - 1;
                if (pos <= 0) {
                    pos = 0;
                    Toast toast = Toast.makeText(getApplicationContext(),"已经到第一张了",Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    imgview.setImageResource(imgs[pos]);
                }
            }
        });
        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = pos + 1;
                if (pos >= imgs.length) {
                    pos = imgs.length - 1;
                    Toast toast = Toast.makeText(getApplicationContext(),"已经到最后一张了",Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    imgview.setImageResource(imgs[pos]);
                }
            }
        });
        imgview.setImageResource(imgs[pos]);
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
