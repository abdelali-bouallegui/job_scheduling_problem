/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job_scheduling_problem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hackimos
 */
public class job_scheduling_problem {

    /**
     * @param l
     * @param args the command line arguments
     */
    public static job earliestCompletionDate(ArrayList<job> l){
        job earliest=new job(l.get(0));
        for(int i=1;i<l.size();i++){
            job newJob=new job(l.get(i));
        if(newJob.lastDay.before(earliest.lastDay)){
            earliest =new job(newJob);
        }    
        }
        return new job(earliest);
    }
    public static void removeIntersected(ArrayList<job> l,job j){
       int i=0;
       while(i<l.size()){
            job newJob=new job(l.get(i));
            boolean cond1=(newJob.firstDay.before(j.lastDay));
            boolean cond2=(newJob.firstDay.after(j.firstDay));
            boolean conditions1=(cond1)&&(cond2);
            boolean cond3=(newJob.lastDay.after(j.firstDay));
            boolean cond4=(newJob.firstDay.before(j.firstDay));
            boolean conditions2=(cond3&&cond4);
        if(conditions1||conditions2){
            l.remove(newJob);
        }else{
            ++i;
        }
        }
    }
    public static ArrayList<job> maxJobs(ArrayList<job> l){
        ArrayList<job> nL=new ArrayList<job>();
        while(!l.isEmpty()){
          job j=new job(earliestCompletionDate(l));
          nL.add(new job(j));
          int index =l.indexOf(j);
          l.remove(index);
          removeIntersected(l,j);
        }
        return nL;    
    }
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        ArrayList<job> l;
        l=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning=sdf.parse("2000-01-10");
        Date end=sdf.parse("2000-01-20");
        job a=new job("A",beginning,end);
        l.add(a);
        beginning=sdf.parse("2000-01-24");
        end=sdf.parse("2000-01-31");
        job b=new job("B",beginning,end);
        l.add(b);
        beginning=sdf.parse("2000-01-01");
        end=sdf.parse("2000-01-16");
        job c=new job("C",beginning,end);
        l.add(c);
        beginning=sdf.parse("2000-01-18");
        end=sdf.parse("2000-01-26");
        job d=new job("D",beginning,end);
        l.add(d);
        beginning=sdf.parse("2000-01-30");
        end=sdf.parse("2000-02-03");
        job e=new job("E",beginning,end);
        l.add(e);
        beginning=sdf.parse("2000-01-09");
        end=sdf.parse("2000-01-13");
        job x=new job("X",beginning,end);
        l.add(x);
        beginning=sdf.parse("2000-01-15");
        end=sdf.parse("2000-01-23");
        job f=new job("F",beginning,end);
        l.add(f);
        beginning=sdf.parse("2000-01-28");
        end=sdf.parse("2000-02-01");
        job g=new job("G",beginning,end);
        l.add(g);
        beginning=sdf.parse("2000-02-02");
        end=sdf.parse("2000-02-05");
        job h=new job("H",beginning,end);
        l.add(h);
        ArrayList<job> nL=maxJobs(l);
        int size = nL.size();
        for(int i=0;i<size;i++){
            nL.get(i).display();
        }
    }
}
 