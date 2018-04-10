package com.jiaxianghudong.andfix;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.i("===>",str);
        File filefix = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
                "fix.apatch");
        try {
            String command = "chmod 777 " + Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"fix.apatch";
            Log.i("zyl", "command = " + command);
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec(command);
        } catch (IOException e) {
            Log.i("zyl","chmod fail!!!!");
            e.printStackTrace();
        }

        if(filefix.exists()){
            try {
                MyApplication.patchManager.addPatch(filefix.getAbsolutePath());
                Toast.makeText(this,"修复成功",Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this,"修复失败",Toast.LENGTH_LONG).show();
            }
        }
     }


    public void test(View view){
        Toast.makeText(MainActivity.this,"update bug finish",Toast.LENGTH_LONG).show();
    }
}
