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
    private List<Apunt> apunts;
    private final String FILENAME = "apunts.txt";

    public ApuntsHandler(Context context){
        restore(context);
    }

    public ApuntsHandler(List<Apunt> apunts, Context context) {
        this.apunts = apunts;
        save(context);
    }

    public List<Apunt> getApunts(){
        return apunts;
    }

    public void add(Apunt apunt, Context context){
        apunts.add(apunt);
        save(context);
    }

    public void remove(Apunt apunt, Context context){
        apunts.remove(apunt);
        save(context);
    }

    public ApuntsCollection getApuntsOfAuthor(String author){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getAuthor().contains(author)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getApuntsOfCareer(String degree){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getDegree().contains(degree)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getApuntsOfSubject(String subject){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getSubject().contains(subject)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getApuntsOfType(String type){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getType().equals(type)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getApuntsOfPageCount(int min, int max){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            int pages = apunt.getPageCount();
            if (min <= pages && pages <= max){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getApuntsOfDate(Date oldmost, Date newmost){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            Date date = apunt.getDate();
            if (date.after(oldmost) && date.before(newmost)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getFavourites(){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getIsFavourite()){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public int count(){
        return apunts.size();
    }

    private boolean create(Context context, String txtString) {
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

    private void save(Context context){
        String allString = "";
        for (Apunt a : apunts){
            allString += a.toMemString() + ";";
        }
        create(context, allString);
    }

    private String readFromFile(Context context) {

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

    private boolean isFilePresent(Context context) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + FILENAME;
        File file = new File(path);
        return file.exists();
    }

    private void restore(Context context){
        if (isFilePresent(context)){
            String all = readFromFile(context);
            apunts = new ArrayList<>();
            String[] parts = all.split(";");
            for (String s : parts){
                if (!s.equals("")){
                    apunts.add(new Apunt(s));
                }
            }
        }
        else{
            apunts = new ArrayList<>();
        }
    }
}
