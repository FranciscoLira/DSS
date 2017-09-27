/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partnersmanagement;

import java.time.LocalDate;

/**
 *
 * @author Tiago
 */
public class Quota {
    
    private LocalDate date;
    private double value;
    
    public Quota(LocalDate d, double v){
        this.date = d;
        this.value = v;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public double getValue(){
        return this.value;
    }
    
    public void setDate(LocalDate d){
        this.date = d;
    }
    
    public void setValue(double v){
        this.value = v;
    }
    
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        else{
            Quota q = (Quota) o;
            return (this.date.equals(q.getDate()) && this.value == q.getValue());
        }
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("Quota(");
        sb.append(this.date);
        sb.append(",");
        sb.append(this.value);
        sb.append(")");
        return sb.toString();
    }
    
    public Object clone(){
        return new Quota(this.date, this.value);
    }
}
