/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partnersmanagement;

import java.time.LocalDate;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.*;

/**
 *
 * @author Tiago
 */
public class PartnersList extends Observable{
    
    private Map<String,Partner> group;
    
    public PartnersList(){
        this.group = new TreeMap<String,Partner>();
    }
    
    public PartnersList(PartnersList l){
        this.group = new TreeMap<String,Partner>();
        for(Partner p : l.getGroup().values()){
            this.group.put(p.getMail(), (Partner) p.clone());
        }
    }
    
    public Map<String, Partner> getGroup(){
        Map<String,Partner> res = new TreeMap<String,Partner>();
        this.group.values().forEach(p -> res.put(p.getMail(), (Partner) p.clone()));
        return res;
    }
    
    /*public Map<Integer, Partner> getGroup(){
        Map<Integer,Partner> res = new TreeMap<Integer,Partner>();
        for(Partner p: this.group.values()){
            res.put(p.getNumber(), (Partner) p.clone());
        }
        return res;
    }*/
    
    public void pagarQuota(Integer numero, Double valor){
        LocalDate d = null;
        for(Partner p: this.group.values()){
            if(p.getNumber() == numero){
                this.group.get(p.getMail()).getQuotas().add(new Quota(d.now(), valor));
            }
        }
    }
    
    public Partner getPartner(int numero){
        return this.group.get(numero);
    }
    
    public boolean containsPartner(String n){
        return this.group.containsKey(n);
    }
    
    public void addPartner(Partner p){
        this.group.put(p.getMail(), (Partner) p.clone());
    }
    
    public int size(){
        return this.group.size();
    }
    
    public Object clone(){
        return new PartnersList(this);
    }

}