/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job_scheduling_problem;

import java.util.Date;

/**
 *
 * @author hackimos
 */
public class job {
   public String name;
   public Date firstDay;
   public Date lastDay;
  public job(String n,Date x,Date y){
      this.name=n;
      this.firstDay=x;
      this.lastDay=y;
  }
 public job(job jj){
      this.name=jj.name;
      this.firstDay=(Date) jj.firstDay.clone();
      this.lastDay=(Date) jj.lastDay.clone();
   
  }
  public void display(){
      System.out.println(name);
      System.out.println(firstDay);
      System.out.println(lastDay);
  }

 

 @Override
    public boolean equals(Object object) {
        job obj =(job) object;
        return this.name.equals(obj.name)&&this.firstDay.equals(obj.firstDay)&&this.lastDay.equals(obj.lastDay); //To change body of generated methods, choose Tools | Templates.
    }
  
  
}
