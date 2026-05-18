package com.example.bouncysquare;

import android.content.Context;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class BouncySquareRenderer implements GLSurfaceView.Renderer {

    private Square mSquare1;
    private Square mSquare2;
    private float mTransY = 0.0f;
    private Context mContext;

    // ── Schimbă MODE pentru fiecare exercițiu ─────────────────────────────────
    // 1 = Culori solide, fără blending
    // 2 = Alpha blending standard (SRC_ALPHA)
    // 3 = GL_ONE blending
    // 4 = Ordine inversată
    // 5 = glColorMask
    // 6 = Per-vertex multicolor
    // 7 = Texture blending
    // 8 = Multitexturing
    private static final int MODE = 1;

    public BouncySquareRenderer(Context context) {
        mContext = context;
        mSquare1 = new Square();
        mSquare2 = new Square();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        mSquare1.useYMCAColors();
        mSquare2.useRGBAColors();

        // Pentru MODE 7 si 8, pune hedly.png si splash.png in res/drawable/
        // si decomenteaza linia de jos:
         mSquare1.setTextures(gl, mContext, R.drawable.hedly, R.drawable.splash);
         mSquare2.setTextures(gl, mContext, R.drawable.hedly, R.drawable.splash);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        float ratio = (float) width / height;
        gl.glFrustumf(-ratio, ratio, -1.0f, 1.0f, 1.0f, 10.0f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL11.GL_MODELVIEW);

        switch (MODE) {

            // ── MODE 1: Culori solide, fără blending ──────────────────────────
            case 1:
                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -3.0f);
                gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
                mSquare1.draw(gl);

                gl.glLoadIdentity();
                gl.glTranslatef((float)(Math.sin(mTransY) / 2.0), 0.0f, -2.9f);
                gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
                mSquare2.draw(gl);
                break;

            // ── MODE 2: Alpha blending SRC_ALPHA ──────────────────────────────
            case 2:
                gl.glEnable(GL10.GL_BLEND);
                gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -3.0f);
                gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
                mSquare1.draw(gl);

                gl.glLoadIdentity();
                gl.glTranslatef((float)(Math.sin(mTransY) / 2.0), 0.0f, -2.9f);
                gl.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
                mSquare2.draw(gl);

                gl.glDisable(GL10.GL_BLEND);
                break;

            // ── MODE 3: GL_ONE blending ────────────────────────────────────────
            case 3:
                gl.glEnable(GL10.GL_BLEND);
                gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);

                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -3.0f);
                gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
                mSquare1.draw(gl);

                gl.glLoadIdentity();
                gl.glTranslatef((float)(Math.sin(mTransY) / 2.0), 0.0f, -2.9f);
                gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
                mSquare2.draw(gl);

                gl.glDisable(GL10.GL_BLEND);
                break;

            // ── MODE 4: Ordine inversată, ambele alpha=0.5 ────────────────────
            case 4:
                gl.glEnable(GL10.GL_BLEND);
                gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

                gl.glLoadIdentity();
                gl.glTranslatef((float)(Math.sin(mTransY) / 2.0), 0.0f, -3.0f);
                gl.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
                mSquare2.draw(gl);

                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -2.9f);
                gl.glColor4f(0.0f, 0.0f, 1.0f, 0.5f);
                mSquare1.draw(gl);

                gl.glDisable(GL10.GL_BLEND);
                break;

            // ── MODE 5: glColorMask ────────────────────────────────────────────
            case 5:
                gl.glEnable(GL10.GL_BLEND);
                gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);

                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -3.0f);
                gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
                mSquare1.draw(gl);

                gl.glColorMask(true, false, true, true);
                gl.glLoadIdentity();
                gl.glTranslatef((float)(Math.sin(mTransY) / 2.0), 0.0f, -2.9f);
                gl.glColor4f(1.0f, 1.0f, 0.0f, 1.0f);
                mSquare2.draw(gl);
                gl.glColorMask(true, true, true, true);

                gl.glDisable(GL10.GL_BLEND);
                break;

            // ── MODE 6: Per-vertex multicolor ─────────────────────────────────
            case 6:
                gl.glEnable(GL10.GL_BLEND);
                gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);

                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -3.0f);
                mSquare1.drawWithColors(gl);

                gl.glLoadIdentity();
                gl.glTranslatef((float)(Math.sin(mTransY) / 2.0), 0.0f, -2.9f);
                mSquare2.drawWithColors(gl);

                gl.glDisable(GL10.GL_BLEND);
                break;

            // ── MODE 7: Texture blending ───────────────────────────────────────
            case 7:
                gl.glEnable(GL10.GL_BLEND);
                gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -3.0f);
                gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                mSquare1.drawWithTexture(gl);

                gl.glLoadIdentity();
                gl.glTranslatef((float)(Math.sin(mTransY) / 2.0), 0.0f, -2.9f);
                gl.glColor4f(1.0f, 1.0f, 1.0f, 0.75f);
                mSquare2.drawWithTexture(gl);

                gl.glDisable(GL10.GL_BLEND);
                break;

            // ── MODE 8: Multitexturing ─────────────────────────────────────────
            case 8:
                gl.glLoadIdentity();
                gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -3.0f);
                mSquare1.drawMultiTexture(gl);
                break;
        }

        mTransY += 0.075f;
    }
}