package com.example.estudiantapp.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApuntsCollection {
    private List<Apunt> apunts;

    public ApuntsCollection(){
        apunts = new ArrayList<>();
    }

    public ApuntsCollection(List<Apunt> apunts) {
        this.apunts = apunts;
    }

    public List<Apunt> getApunts(){
        return apunts;
    }

    public void add(Apunt apunt){
        apunts.add(apunt);
    }

    public void remove(Apunt apunt){
        apunts.remove(apunt);
    }

    public ApuntsCollection getApuntsOfAuthor(String author){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getAuthor().equals(author)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getApuntsOfCareer(String career){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getCareer().equals(career)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public ApuntsCollection getApuntsOfSubject(String subject){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getSubject().equals(subject)){
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

    public int Count(){
        return apunts.size();
    }
}
