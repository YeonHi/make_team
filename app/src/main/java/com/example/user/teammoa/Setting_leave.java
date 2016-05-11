package com.example.user.teammoa;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * Created by user on 2016-05-10.
 */

public class Setting_leave extends Activity implements OnClickListener {

    private AlertDialog mDialog = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_leave);

        setLayout();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_leave:
                mDialog = createDialog();
                mDialog.show();
                break;

            default:
                break;
        }
    }

    /**
     * base 다이얼로그
     * @return ab
     */
    private AlertDialog createDialog() {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Title");
        ab.setMessage("내용");
        ab.setCancelable(false);

        ab.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                setDismiss(mDialog);
            }
        });

        ab.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                setDismiss(mDialog);
            }
        });

        return ab.create();
    }
    /**
     * 다이얼로그 종료
     * @param dialog
     */
    private void setDismiss(Dialog dialog){
        if(dialog != null && dialog.isShowing())
            dialog.dismiss();
    }
    /*
     * Layout
     */
    private Button baseButton = null;

    private void setLayout(){
        baseButton = (Button) findViewById(R.id.button_leave);

        baseButton.setOnClickListener(this);
    }
}
