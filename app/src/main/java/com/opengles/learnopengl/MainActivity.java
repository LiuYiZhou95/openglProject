package com.opengles.learnopengl;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.opengles.learnopengl.GLBase.BaseRender;
import com.opengles.learnopengl.GLBase.GLView;
import com.opengles.learnopengl.JNIAPI.CoreObjectJNI;

public class MainActivity extends AppCompatActivity {



    private BaseRender baseRenderer;
    private GLSurfaceView mGLView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseRenderer = new BaseRender(this);
        mGLView = new GLView(this);
        setContentView(mGLView);

//        测试JNI成功
//        setContentView(R.layout.activity_main);
//        CoreObjectJNI coreObjectJNI=new CoreObjectJNI();
//        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(coreObjectJNI.stringFromJNI());
    }


}
