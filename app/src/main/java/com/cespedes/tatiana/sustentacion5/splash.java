package com.cespedes.tatiana.sustentacion5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        Imagen1 fondo = new Imagen1(this);
       // setContentView(fondo);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);

    }

    public class Imagen1 extends View {
        Drawable imagen = getResources().getDrawable(R.drawable.mapa);

        public Imagen1(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            Paint p= new Paint();
            p.setAntiAlias(true);
            //Dimensiones del canvas
            int  altoCa = getBottom();
            int anchoCa = getRight();
         //   float medioCa = (float)altoCa/anchoCa;
            //Dimensiones imagen
            int  alto = imagen.getIntrinsicHeight();
            int ancho = imagen.getIntrinsicWidth();
          //  float medio = (float)alto/ancho;
/*
            //Algortimo
            int an, al;
            if(medioCa<medio){
                an= anchoCa;
                al= (int)(medio*ancho);
            }else{
                al=altoCa;
                an = (int) (al/medio);

            }*/

            //Poner imagen
            imagen.setBounds(0, 0, 509, 511);
            imagen.draw(canvas);

         //   super.onDraw(canvas);
        }
    }

}
