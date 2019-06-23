package com.meterstoinches.listviewandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t1,t2;
    ImageView iv;
    int images;
    String names,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1=findViewById(R.id.textView_heading1);
        t2=findViewById(R.id.textView_heading2);
        iv=findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();
        images = bundle.getInt("images");
        names = bundle.getString("names");
        description = bundle.getString("des");

        t1.setText(names);
        t2.setText(description);
        iv.setImageResource(images);

    }
}
