package com.opengles.learnopengl.JNIAPI;
/**
*
* @author  action.zhou
* @time    2019/6/13 下午3:47
*/
public class CoreObjectJNI {

    static {
        System.loadLibrary("native-lib");
    }

    public CoreObjectJNI()
    {

    }

    public static native void Init(String vertexShaderCode, String fragmentShaderCode);
    public static native void Draw(float angleX, float angleY);
    public static native void SurfaceChanged(int width, int height);
    public native String stringFromJNI();

}
