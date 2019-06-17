#include <jni.h>
#include <string>
#include <Shape/Trangles.h>
#include "glm/mat4x4.hpp"
#include "glm/ext.hpp"
#include <iostream>
#include <GLES2/gl2.h>
#include <android/log.h>


using namespace std;
#define LOGI(level, ...) __android_log_print(ANDROID_LOG_INFO, "NATIVE_LOG", __VA_ARGS__)


Trangles mShape;

//mvp矩阵
glm::mat4 projection;
glm::mat4 view;
glm::mat4 module;

#define JNI_METHOD(return_type, method_name) \
  JNIEXPORT return_type JNICALL              \
        Java_com_opengles_learnopengl_JNIAPI_CoreObjectJNI_##method_name

//c++11特性 声明这段代码用C
#ifdef __cplusplus
extern "C" {
#endif


//测试jni
JNI_METHOD(jstring,stringFromJNI)(JNIEnv *env,jobject jobject1)
{
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

//绘制三角形

JNI_METHOD(void,Init)(JNIEnv *env, jclass type,
                      jstring vertexShaderCode_,
                      jstring fragmentShaderCode_) {
    const char *vertexShaderCode = env->GetStringUTFChars(vertexShaderCode_, 0);
    const char *fragmentShaderCode = env->GetStringUTFChars(fragmentShaderCode_, 0);

    //着色器
    mShape.initGL(vertexShaderCode,fragmentShaderCode);
    env->ReleaseStringUTFChars(vertexShaderCode_, vertexShaderCode);
    env->ReleaseStringUTFChars(fragmentShaderCode_, fragmentShaderCode);
    glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
    glDisable(GL_DEPTH_TEST);
    LOGI(1, "init绘制----");

}

JNI_METHOD(void,Draw)(JNIEnv *env, jclass type, jfloat angleX, jfloat angleY) {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
//    module = glm::rotate(module, angleX, glm::vec3(1,0,0));
//    module = glm::rotate(module, angleY, glm::vec3(0,1,0));


    glm::mat4 mvpMatrix = projection * view * module;
    float *mvp = (float *) glm::value_ptr(mvpMatrix);
    // TODO
    mShape.draw(mvp);


    LOGI(1, "draw绘制----");
}

JNI_METHOD(void,SurfaceChanged)(JNIEnv *env, jclass type,jint width, jint height) {

    projection = glm::ortho(-1.0f, 1.0f, -(float) height / width, (float) height / width, 5.0f, 7.0f);
    projection = glm::perspective(glm::radians(50.0f), (float)width/height, 5.0f ,7.0f);
    view = glm::lookAt(glm::vec3(0.0f, 0.0f, 6.0f),
                       glm::vec3(0.0f, 0.0f, 0.0f),
                       glm::vec3(0.0f, 1.0f, 0.0f));
    glViewport(0, 0, width, height);
}


#ifdef __cplusplus
}
#endif