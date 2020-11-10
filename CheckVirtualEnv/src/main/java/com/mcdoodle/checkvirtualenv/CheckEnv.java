package com.mcdoodle.checkvirtualenv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class CheckEnv {
    public static String pkg;
    public static String absPath;
    public static Context context;

    public CheckEnv(String pkg, Context context) {
        this.pkg = pkg;
        this.context = context;

        Log.d("PACKAGE", pkg);
        String shared="";
        AppPreferences.savePreferences(context, "test1", "shared_pref");
        AppPreferences.savePreferences(context,"test", "visible");

        File f = new File(context.getFilesDir(), "validate.txt");

        File loc = context.getFileStreamPath("validate.txt");
        absPath = loc.getAbsolutePath();
        Log.d("location", absPath);
    }

    public void options(){

        if(absPath.equals("/data/user/0/"+pkg+"/files/validate.txt")){
            //Toast.makeText(MainActivity.this, "here", Toast.LENGTH_LONG).show();
            Log.d("match", "true");
        }
        else {


            LayoutInflater inflater = LayoutInflater.from(context);
            View prompt = inflater.inflate(context.getResources().getLayout(R.layout.prompt_dialog), null);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
            builder.setView(prompt);
            final android.app.AlertDialog dialog1 = builder.create();
            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            //widgets
            Button continueBtn = prompt.findViewById(R.id.cont);
            Button close = prompt.findViewById(R.id.close);

            continueBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog1.dismiss();
                }
            });

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.exit(0);
                }
            });

            try {
                dialog1.show();
            } catch (Exception ex) {
                Log.d("exception", ex.getMessage());
            }

        }
    }


    public void shutDown(){
        if(absPath.equals("/data/user/0/"+pkg+"/files/validate.txt")){
            //Toast.makeText(MainActivity.this, "here", Toast.LENGTH_LONG).show();
            Log.d("match", "true");

        }

        else {
            System.exit(0);
        }
    }

    public boolean selfDecide(){
        if(absPath.equals("/data/user/0/"+pkg+"/files/validate.txt")){
            //Toast.makeText(MainActivity.this, "here", Toast.LENGTH_LONG).show();
            Log.d("match", "true");
            return false;
        }

        else {
            return true;
        }
    }

}
