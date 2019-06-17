package com.opengles.learnopengl.GLBase;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadShader {

    public  LoadShader(){

    }

    public static  String LoadShaderStr(Context context, int resId){
        StringBuffer strBuf = new StringBuffer();
        try {
            InputStream inputStream = context.getResources().openRawResource(resId);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String read = in.readLine();
            while (read != null) {
                strBuf.append(read + "\n");
                read = in.readLine();
            }
            strBuf.deleteCharAt(strBuf.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strBuf.toString();
    }
}
