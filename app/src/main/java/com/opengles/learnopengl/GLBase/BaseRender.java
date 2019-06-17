package com.opengles.learnopengl.GLBase;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import com.opengles.learnopengl.JNIAPI.CoreObjectJNI;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import com.opengles.learnopengl.R;

/**
*
* @author  action.zhou
* @time    2019/6/13 下午3:46
*/
public class BaseRender implements GLSurfaceView.Renderer {

    private  CoreObjectJNI mCoreObjectJNI;
    private Context mContext;
    private LoadShader loadShader;

    public BaseRender(Context context){
        mContext=context;
        mCoreObjectJNI = new CoreObjectJNI();

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        loadShader=new LoadShader();
        String vShaderStr=loadShader.LoadShaderStr(mContext,R.raw.vshader);
        String fShaderStr= loadShader.LoadShaderStr(mContext,R.raw.fshader);
        mCoreObjectJNI.Init(vShaderStr, fShaderStr);
    }
    @Override
    public  void onDrawFrame(GL10 gl10){
        mCoreObjectJNI.Draw(0.0f, 0.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        mCoreObjectJNI.SurfaceChanged(width, height);
    }

    //触控回调方法
    public boolean onTouchEvent(MotionEvent e)
    {

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                if(mCoreObjectJNI != null)

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
