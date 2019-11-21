package com.example.ahorcado;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Marcador {
    private String Estado;
    private String Solucion;
    private ArrayList<Character> letras;
    private int Fallos;
    private String[] archivos;
    public String getEstado()
    {
        return "";//completar
    }
    public AssetManager asm;
    Marcador(AssetManager asm)
    {
        this.asm=asm;
    }

    public void startMarcador(AppCompatActivity ca)
    {
        archivos=ca.getResources().getStringArray(R.array.archivos);
    }

    public void setSolucion(String pal)
    {
        //Establece la solución
        //e inicializar el estado.
    }

    public String getSolucion()
    {
        return ""; //completar
    }

    public boolean comprobar(char c)
    {
        //Actualiza el estado, buscando las ocurrencias
        //del caracter c en la solución.
        //devuelve true o false dependiendo si hemos encontrado
        //alguna ocurrencia o no
        return false;//Completar
    }

    public void contarFallo()
    {
        //suma 1 a fallos

    }

    public void draw(Canvas canvas)
    {
        //dibujar estado.
        //dibujar marcador.
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
        //calcular las coordenadas de origen del Bitmap
        return null;
    }

    private Rect getCoordenadasOrigen() {
        //calcular las coordenadas de destino del bitmap
        return null;
    }

}
