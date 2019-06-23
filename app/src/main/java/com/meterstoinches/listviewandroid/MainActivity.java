package com.meterstoinches.listviewandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    int images [] = {R.drawable.apj, R.drawable.ar, R.drawable.gandhiji, R.drawable.sachin};

    String names [] = {"APJ Abdul Kalam", "A R Rehman", "Mahatma Gandhi", "Sachin Tendulkar"};

    String descriptions[] = {"Scientist", "Music Director", "Freedom Fighter", "Cricketer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("images",images[position]);
                intent.putExtra("names",names[position]);
                intent.putExtra("des",descriptions[position]);
                startActivity(intent);

            }
        });
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //we need to call a XML file
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            //whatever the view we are having we need to call them
            ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView1);
            TextView textView_name = (TextView) convertView.findViewById(R.id.textView1_name);
            TextView textView_des = (TextView) convertView.findViewById(R.id.textView2_des);

            //we need to bind the data to this imageview
            imageView.setImageResource(images[position]);
            textView_name.setText(names[position]);
            textView_des.setText(descriptions[position]);

            return convertView;
        }
    }
}
