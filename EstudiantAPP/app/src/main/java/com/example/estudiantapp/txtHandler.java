package com.example.estudiantapp;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class txtHandler {

    private MainActivity mainActivity;


    public txtHandler(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    // Aquí comença codi copiat fortament d'Internet

    private static String read(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line+'\n');
            }
            return sb.toString();
        } catch (FileNotFoundException fileNotFound) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

    private boolean create(Context context, String fileName, String txtString) {
        String FILENAME = fileName;
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
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

    public boolean isFilePresent(Context context, String fileName) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }


    public List<Task> getTasks(Activity activity, String FileName) {

        String string;
        boolean isFilePresent = isFilePresent(activity, FileName);
        if (isFilePresent) {
            string = read(activity, FileName);
            // TODO do the txt parsing here and do the rest of functionality of app
        } else {
            boolean isFileCreated = create(activity, FileName, "{}");
            if (isFileCreated) {
                //proceed with storing the first todo  or show ui
            } else {
                //show error or try again.
            }

            List<Task> taskList = new ArrayList<>();
            return taskList;
        }

        String[] parts = string.split("\n");

        List<Task> taskList = new ArrayList<>();
        for (String s : parts) {
            taskList.add(MainActivity.getTaskFromString(s));
        }

        return taskList;
    }

    public void DeleteTask(Task task, Activity activity, String filename) {
        List<Task> allTasks = getTasks(activity, filename);
        allTasks.remove(task);
        String rpr = "";
        for (Task t : allTasks){
            rpr += MainActivity.fromTaskToString(t) + '\n';
        }
        create(mainActivity.getApplicationContext(), filename, rpr);
    }

    public void AddTask(Task task, Activity activity, String filename){
        List<Task> allTasks = getTasks(activity, filename);
        allTasks.add(task);
        String rpr = "";
        for (Task t : allTasks){
            rpr += MainActivity.fromTaskToString(t) + '\n';
        }
        create(mainActivity.getApplicationContext(), filename, rpr);
    }
}
