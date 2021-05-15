package com.example.estudiantapp.db;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TxtHandler {

    static final String FILENAME = "Tasks.txt";

    public static void prova(Context myContext, List<Task> L) throws IOException {


        File gpxfile = new File(myContext.getFilesDir(), FILENAME);
        gpxfile.delete();

        File file = new File(myContext.getFilesDir(), FILENAME);
        FileWriter writer = new FileWriter(file);
        writer.append("");
        writer.flush();
        writer.close();


        String txt = fromTaskListToString(L);
        Log.d("LOLAZO", txt);

        for (Task t : L){
            addTask(myContext, t);
        }


        String s = readFromFile(myContext);
        Log.d("LOLAZO", s);


    }

    // Aquí comença codi copiat fortament d'Internet

    public void writeFileOnInternalStorage(Context mcoContext, String sFileName){
        File dir = new File(mcoContext.getFilesDir(), "mydir");
        if(!dir.exists()){
            dir.mkdir();
        }

        try {
            File gpxfile = new File(dir, sFileName);
            // FileWriter writer = new FileWriter(gpxfile);
            // writer.append(sBody);
            // writer.flush();
            // writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
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

    private static boolean create(Context context, String txtString) {
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

    public static boolean isFilePresent(Context context) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + FILENAME;
        File file = new File(path);
        return file.exists();
    }

    public static List<Task> getTasks(Context context) {

        String string = "";
        boolean isFilePresent = isFilePresent(context);
        if (isFilePresent) {
            string = readFromFile(context);
            // TODO do the txt parsing here and do the rest of functionality of app
        } else {
            create(context, "");
        }


        String[] parts = string.split(";");

        List<Task> taskList = new ArrayList<>();

        for (String s : parts) {

            if (!s.equals("")) {
                taskList.add(getTaskFromString(s));
            }
        }

        return taskList;
    }

    public static void deleteTask(Context context, Task task, Activity activity) {
        List<Task> allTasks = getTasks(activity);
        allTasks.remove(task);
        StringBuilder rpr = new StringBuilder();
        for (Task t : allTasks){
            rpr.append(fromTaskToString(t)).append('|');
        }
        create(context, rpr.toString());
    }

    public static void addTask(Context context, Task task){
        List<Task> allTasks = getTasks(context);

        String txt = fromTaskListToString(allTasks);

        allTasks.add(task);
        StringBuilder rpr = new StringBuilder();
        for (Task t : allTasks){
            rpr.append(fromTaskToString(t)).append(';');
        }

        create(context.getApplicationContext(), rpr.toString());
    }

    public static String fromTaskListToString(List<Task> L) {

        StringBuilder rpr = new StringBuilder();
        for (Task t : L){
            rpr.append(fromTaskToString(t)).append(';');
        }

        return rpr.toString();

    }

    public static String fromTaskToString(Task task) {
        Date date = task.getDate();
        @SuppressLint("DefaultLocale")
        String s = String.format("%s,%s,%d,%d,%d",
                task.getNom(), task.getAssignatura(), date.getYear(), date.getMonth(), date.getDate());
        return s;
    }

    public static Task getTaskFromString(String txtString) {
        String[] parts = txtString.split(",");
        return new Task(parts[0], parts[1], new Date(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
    }


}