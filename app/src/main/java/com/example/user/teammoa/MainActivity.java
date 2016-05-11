package com.example.user.teammoa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    private ListView mainListView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        mainListView = (ListView) findViewById( R.id.SettingList);

        // Create and populate a List of planet names.
        String[] setting = new String[] {"공지사항","건의사항","자주묻는 질문","탈퇴"}; //list메뉴
        ArrayList<String> settingList = new ArrayList<String>();
        settingList.addAll(Arrays.asList(setting));
        listAdapter = new ArrayAdapter<String>(this, R.layout.setting_list_info, settingList);
        mainListView.setAdapter(listAdapter);


        mainListView.setClickable(true);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                if ("공지사항".equals(mainListView.getItemAtPosition((int) id))) {
                    setContentView(R.layout.setting_notice);
                }

                else if ("건의사항".equals(mainListView.getItemAtPosition((int) id))) {
                    setContentView(R.layout.setting_recommend);
                }

                else if ("자주묻는 질문".equals(mainListView.getItemAtPosition((int) id))) {
                    setContentView(R.layout.setting_question);
                }

                else if ("탈퇴".equals(mainListView.getItemAtPosition((int) id))) {
                    setContentView(R.layout.setting_leave);
                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}