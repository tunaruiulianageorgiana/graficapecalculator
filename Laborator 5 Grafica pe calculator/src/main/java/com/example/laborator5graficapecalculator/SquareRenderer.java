package com.example.laborator5graficapecalculator;

import android.content.Context;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SquareRenderer implements GLSurfaceView.Renderer {
    private Square mSquare;
    private Context context;

    private float x = 0.0f;
    private float y = 0.0f;
    private float xSpeed = 0.02f;
    private float ySpeed = 0.015f;

    public SquareRenderer(Context context) {
        this.context = context;
        this.mSquare = new Square();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0f, 0f, 0f, 1f);

        int resid = R.drawable.hedly;
        mSquare.createTexture(gl, this.context, resid);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float ratio = (float) width / height;
        gl.glOrthof(-ratio, ratio, -1, 1, -1, 1);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        x += xSpeed;
        y += ySpeed;

        if (x > 0.6f || x < -0.6f) xSpeed = -xSpeed;
        if (y > 0.6f || y < -0.6f) ySpeed = -ySpeed;

        gl.glTranslatef(x, y, 0f);
        mSquare.draw(gl);
    }
}