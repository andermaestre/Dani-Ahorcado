package com.example.ahorcado;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Marcador {
    private String Estado;
    private String Solucion;
    private ArrayList<Character> letras;
    private int Fallos;
    private String[] archivos;
    public AssetManager asm;

    public String getEstado()
    {
        return this.Estado;//completar
    }

    public Marcador(AssetManager asm)
    {
        this.asm=asm;
        this.letras = new ArrayList<>();
        this.Fallos = 0;
    }

    public void startMarcador(AppCompatActivity ca)
    {
        archivos=ca.getResources().getStringArray(R.array.archivos);
    }

    public void setSolucion(String pal)
    {
        String aux="";
        this.Solucion=pal;
        //this.Estado

        char[] car = aux.toCharArray();
        for (int i = 0; i<pal.length()-1;i++){
            if(i==0||i==pal.length()-1){
                car[i]=pal.charAt(i);

            }else{

            }
        }
        this.Estado=aux;
    }

    public String getSolucion()
    {
        return this.Solucion;
    }

    public boolean comprobar(char c)
    {
        for (int i = 0; i<this.Solucion.length()-1;i++){
            if(this.Solucion.charAt(i)==c){
                return true;
            }
        }
        return false;
    }

    public void contarFallo()
    {
        this.Fallos+=1;
    }

    public void draw(Canvas canvas)
    {
        //dibujar estado.
        dibujarEstado(canvas);
        //dibujar marcador.
        dibuarMarcador(canvas);
    }

    private void dibujarEstado(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextSize(90);
        String state=this.Estado;
        canvas.drawText(state.toString(),300,1100,paint);


    }

    private void dibuarMarcador(Canvas canvas)
    {   int i;
    try {
        for (i = 0; i < Fallos; i++) {

            InputStream is = asm.open(archivos[i]);
            Bitmap bmp=BitmapFactory.decodeStream(is);
            //establecer coordenadas de los rectángulos
            canvas.drawBitmap(bmp,getCoordenadasOrigen(),getCoordenadasDestino(),null);

        }
    }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private Rect getCoordenadasDestino() {
        //calcular las coordenadas de origen del Bitmap con un array en resources

        return null;
    }

    private Rect getCoordenadasOrigen() {
        //calcular las coordenadas de destino del bitmap con un array en resources

        return null;
    }

}
