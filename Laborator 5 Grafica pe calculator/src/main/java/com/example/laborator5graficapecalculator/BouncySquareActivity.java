package com.example.laborator5graficapecalculator;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.example.laborator5graficapecalculator.SquareRenderer;

public class BouncySquareActivity extends Activity {
    private GLSurfaceView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new GLSurfaceView(this);
        view.setRenderer(new SquareRenderer(this.getApplicationContext()));

        setContentView(view);
    }
}