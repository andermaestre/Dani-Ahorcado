package com.example.ahorcado;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class VistaJuego extends View {
    private Marcador m;
    private AssetManager asm;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dibujarPatibulo(canvas);
        m.draw(canvas);

    }

    private void dibujarPatibulo(Canvas canvas) {
        try {
            InputStream is=asm.open("patibulo.png");
            Bitmap bmp= BitmapFactory.decodeStream(is);
            canvas.drawBitmap(bmp,new Rect(0,0, 600, 800),new Rect(420,0,1080,1200),null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public VistaJuego(Context context) {
        super(context);
        asm=getContext().getAssets();
        m=new Marcador(asm);
        m.startMarcador((AppCompatActivity)context);
    }

    public void nuevaPalabra(String[] palabras)
    {
        Random r=new Random();
        r.setSeed(System.currentTimeMillis());
        int i=r.nextInt(palabras.length);
        m.setSolucion(palabras[i]);
        this.invalidate();
    }

    public void introducirLetra(char l)
    {
        if (!m.comprobar(l))
        {
            m.contarFallo();
            this.invalidate();
        }

    }
}
