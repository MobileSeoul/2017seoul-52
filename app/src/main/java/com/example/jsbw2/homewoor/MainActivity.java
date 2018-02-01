package com.example.jsbw2.homewoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

import static com.example.jsbw2.homewoor.R.id.listView;


public class MainActivity extends AppCompatActivity {

    ListView listview;
    StudentAdapter adapter;


    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int j = 0;
        int z = 0;
        try {
            String ss;
            InputStream is = getResources().openRawResource(R.raw.festivalinseoul);
            byte[] readStr = new byte[is.available()];
            is.read(readStr);
            ss = new String(readStr);
            String[] Info = ss.split("#");
            String[][] Infomation = new String[30][8];

            for (int i = 0; i < Info.length; i++) {

                Infomation[j][z] = Info[i];
                z++;
                if (z == 8) {
                    j++;
                    z = 0;
                }

            }
            is.close();

            listview = (ListView) findViewById(listView);
            adapter = new StudentAdapter();

            adapter.addItem(new StudentItem(Infomation[0][0].trim(), Infomation[0][1].trim(), "1"));
            adapter.addItem(new StudentItem(Infomation[1][0].trim(), Infomation[1][1].trim(), "2"));
            adapter.addItem(new StudentItem(Infomation[2][0].trim(), Infomation[2][1].trim(), "3"));
            adapter.addItem(new StudentItem(Infomation[3][0].trim(), Infomation[3][1].trim(), "4"));
            adapter.addItem(new StudentItem(Infomation[4][0].trim(), Infomation[4][1].trim(), "5"));
            adapter.addItem(new StudentItem(Infomation[5][0].trim(), Infomation[5][1].trim(), "6"));
            adapter.addItem(new StudentItem(Infomation[6][0].trim(), Infomation[6][1].trim(), "7"));
            adapter.addItem(new StudentItem(Infomation[7][0].trim(), Infomation[7][1].trim(), "8"));
            adapter.addItem(new StudentItem(Infomation[8][0].trim(), Infomation[8][1].trim(), "9"));
            adapter.addItem(new StudentItem(Infomation[9][0].trim(), Infomation[9][1].trim(), "10"));
            adapter.addItem(new StudentItem(Infomation[10][0].trim(), Infomation[10][1].trim(), "11"));
            adapter.addItem(new StudentItem(Infomation[11][0].trim(), Infomation[11][1].trim(), "12"));
            adapter.addItem(new StudentItem(Infomation[12][0].trim(), Infomation[12][1].trim(), "13"));
            adapter.addItem(new StudentItem(Infomation[13][0].trim(), Infomation[13][1].trim(), "14"));
            adapter.addItem(new StudentItem(Infomation[14][0].trim(), Infomation[14][1].trim(), "15"));
            adapter.addItem(new StudentItem(Infomation[15][0].trim(), Infomation[15][1].trim(), "16"));
            adapter.addItem(new StudentItem(Infomation[16][0].trim(), Infomation[16][1].trim(), "17"));
            adapter.addItem(new StudentItem(Infomation[17][0].trim(), Infomation[17][1].trim(), "18"));
            adapter.addItem(new StudentItem(Infomation[18][0].trim(), Infomation[18][1].trim(), "19"));
            adapter.addItem(new StudentItem(Infomation[19][0].trim(), Infomation[19][1].trim(), "20"));


            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), InfoEventActivity.class);
                    String a = adapter.items.get(position).getClassNum();
                    intent.putExtra("go", a);
                    startActivityForResult(intent, REQUEST_CODE_ANOTHER);
                }
            });


        } catch (Exception e) {

        }


    }

    public static final int REQUEST_CODE_ANOTHER = 1001;


    class StudentAdapter extends BaseAdapter {

        ArrayList<StudentItem> items = new ArrayList<StudentItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(StudentItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {

            StudentitemView view = new StudentitemView(getApplicationContext());
            StudentItem item = items.get(position);
            view.setName(item.getName());
            view.setTel(item.getTel());
            view.setClassNum(item.getClassNum());

            return view;
        }
    }

}
