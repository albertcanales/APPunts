package com.example.estudiantapp.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApuntsCollection {
    private List<Apunt> apunts;
    private final String FILENAME = "apunts.txt";

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

    public List<String> getAuthors(){
        List<String> ans = new ArrayList<>();
        for (Apunt apunt : apunts){
            if (!ans.contains(apunt.getAuthor())){
                ans.add(apunt.getAuthor());
            }
        }
        return ans;
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

    public List<String> getDegrees(){
        List<String> ans = new ArrayList<>();
        for (Apunt apunt : apunts){
            if (!ans.contains(apunt.getDegree())){
                ans.add(apunt.getDegree());
            }
        }
        return ans;
    }

    public ApuntsCollection getApuntsOfDegree(String degree){
        ApuntsCollection answer = new ApuntsCollection();
        for (Apunt apunt : apunts){
            if (apunt.getDegree().contains(degree)){
                answer.add(apunt);
            }
        }
        return answer;
    }

    public List<String> getSubjects(){
        List<String> ans = new ArrayList<>();
        for (Apunt apunt : apunts){
            if (!ans.contains(apunt.getSubject())){
                ans.add(apunt.getSubject());
            }
        }
        return ans;
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

    public List<String> getTypes(){
        List<String> ans = new ArrayList<>();
        for (Apunt apunt : apunts){
            if (!ans.contains(apunt.getType())){
                ans.add(apunt.getType());
            }
        }
        return ans;
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

    @Override
    public String toString() {
        return "ApuntsCollection{" +
                "apunts=" + apunts +
                '}';
    }
}
