package com.example.user.teammoa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 2016-05-10.
 */
public class Setting_notice extends Activity {
    private ListView noticeListView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_notice);

        noticeListView = (ListView) findViewById(R.id.SettingList);

        // Create and populate a List of planet names.
        String[] setting = new String[]{"업데이트 내용", "버전 정보"}; //list메뉴
        ArrayList<String> settingList = new ArrayList<String>();
        settingList.addAll(Arrays.asList(setting));
        listAdapter = new ArrayAdapter<String>(this, R.layout.setting_list_info, settingList);
        noticeListView.setAdapter(listAdapter);


        noticeListView.setClickable(true);

        noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                if ("업데이트 내용".equals(noticeListView.getItemAtPosition((int) id))) {
                    setContentView(R.layout.setting);
                } else if ("버전 정보".equals(noticeListView.getItemAtPosition((int) id))) {
                    setContentView(R.layout.setting_recommend);
                }
            }
        });
    }
}
