package com.example.estudiantapp.db;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApuntsHandler{
    private static ApuntsCollection apunts =  new ApuntsCollection();
    private static final String FILENAME = "apunts.txt";

    public static ApuntsCollection getApunts(){
        return apunts;
    }

    public static void add(Apunt apunt, Context context){
        apunts.add(apunt);
        save(context);
    }

    public static void remove(Apunt apunt, Context context){
        apunts.remove(apunt);
        save(context);
    }

    public static void changeFavourite(Apunt apunt, Context context){
        apunt.setIsFavourite(!apunt.getIsFavourite());
        save(context);
    }

    public int count(){
        return apunts.getApunts().size();
    }

    public static boolean create(Context context, String txtString) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            if (txtString != null) {
                fos.write(txtString.getBytes());
            }
            fos.close();
            return true;
        } catch (FileNotFoundException fileNotFound) {
            return false;
        } catch (IOException ioException) {
            return false;
        }

    }

    private static void save(Context context){
        String allString = "";
        for (Apunt a : apunts.getApunts()){
            allString += a.toMemString() + ";";
        }
        create(context, allString);
    }

    private static String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(FILENAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public static boolean isFilePresent(Context context) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + FILENAME;
        File file = new File(path);
        return file.exists();
    }

    public static void  restore(Context context){
        apunts = new ApuntsCollection();
        if (isFilePresent(context)){
            String all = readFromFile(context);
            String[] parts = all.split(";");
            for (String s : parts){
                if (!s.equals("")){
                    apunts.add(new Apunt(s));
                }
            }
        }
    }
}
