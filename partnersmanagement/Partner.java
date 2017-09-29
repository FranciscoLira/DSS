/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partnersmanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Partner {
    
    private String name;
    private int number;
    private String course;
    private String address;
    private String year;
    private String mail;
    private String phoneNumber;
    private List<Quota> quotas;
    
    public Partner(){
        this("", "", "", "", "", "");
    }
    
    public Partner(Partner p){
        this.name = p.getName();
        this.address = p.getAddress();
        this.course = p.getCourse();
        this.mail = p.getMail();
        this.number = p.getNumber();
        this.year = p.getYear();
        this.phoneNumber = p.getPhoneNumber();
        this.quotas = p.getQuotas();
    }

    public Partner(String name, String course, String addr, String m, String phone, String year){
        this.name = name;
        this.course = course;
        this.address = addr;
        this.mail = m;
        this.phoneNumber = phone;
        this.year = year;
        this.quotas = new ArrayList<>();
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public String getCourse(){
        return this.course;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getYear(){
        return this.year;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public void setCourse(String c){
        this.course = c;
    }
    
    public void setMail(String m){
        this.mail = m;
    }   
    
    public void setPhone(String n){
        this.phoneNumber = n;
    }
    
    public void setAddress(String a){
        this.address = a;
    }
    
    public void setNumber(int x){
        this.number = x;
    }
    
    public ArrayList<Quota> getQuotas(){
        ArrayList<Quota> res = new ArrayList<Quota>();
        for(Quota q : this.quotas)
            res.add((Quota) q.clone());
        return (ArrayList<Quota>) res;
    }
    
    public boolean equals(Object o){
        if(o==null || this.getClass()!=o.getClass()) return false;
        if(o == this) return true;
        else {
            Partner p = (Partner) o;
            return (this.name.equals(p.getName()) && this.number == p.getNumber() &&
                    this.course.equals(p.getCourse()) && this.address.equals(p.getAddress())
                    && this.mail.equals(p.getMail()) && this.year.equals(p.getYear()));
        }
    }
    
    public Object clone() {
        return new Partner(this);
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("Partner(");
        sb.append(this.name);
        sb.append(",");
        sb.append(this.number);
        sb.append(",");
        sb.append(this.course);
        sb.append(",");
        sb.append(this.address);
        sb.append(",");
        sb.append(this.year);
        sb.append(",");
        sb.append(this.mail);
        sb.append(")");
        return sb.toString();
    }

}
