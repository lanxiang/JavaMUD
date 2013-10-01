/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013 (tmtvl): Complete version.
 *          0.1: 30-09-2013 (tmtvl): Initial version.
 */
public class Lokatie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long lokatieId;
    private String beschrijving;
    private List<Item> items;
    private List<Karakter> karakters;
    private List<Lokatie> bestemmingen;
    
    protected Lokatie(){
        beschrijving = "";
        items = new ArrayList<>();
        karakters = new ArrayList<>();
        bestemmingen = new ArrayList<>();
    }
    
    public Lokatie(String beschrijving){
        this();
        setBeschrijving(beschrijving);
    }
    
    public Lokatie(String beschrijving, List<Item> items, List<Karakter> karakters){
        this(beschrijving);
        setItems(items);
        setKarakters(karakters);
    }
    
    public Lokatie(long lokatieId, String beschrijving, List<Item> items, 
            List<Karakter> karakters){
        this(beschrijving, items, karakters);
        setId(lokatieId);
    }
    
    public void setId(long lokatieId){
        this.lokatieId = lokatieId;
    }
    
    public void setBeschrijving(String beschrijving){
        this.beschrijving = beschrijving;
    }
    
    public void setItems(List<Item> items){
        this.items = items;
    }
    
    public void setKarakters(List<Karakter> karakters){
        this.karakters = karakters;
    }
    
    public void setBestemmingen(List<Lokatie> bestemmingen){
        this.bestemmingen = bestemmingen;
    }
    
    public long getId(){
        return lokatieId;
    }
    
    public String getBeschrijving(){
        return beschrijving;
    }
    
    public List<Item> getItems(){
        return items;
    }
    
    public List<Karakter> getKarakters(){
        return karakters;
    }
    
    public List<Lokatie> getBestemmingen(){
        return bestemmingen;
    }
    
    public void addItem(Item item){
        items.add(item);
        if(!equals(item.getPositie())){
            item.setPositie(this);
        }
    }
    
    public void removeItem(Item item){
        items.remove(item);
        if(equals(item.getPositie())){
            item.setPositie(null);
        }
    }
    
    public boolean hasItem(Item item){
        return items.contains(item);
    }
    
    public int getItemCount(){
        return items.size();
    }
    
    public void addKarakter(Karakter karakter){
        karakters.add(karakter);
        if(!equals(karakter.getLokatie())){
            karakter.setLokatie(this);
        }
    }
    
    public void removeKarakter(Karakter karakter){
        karakters.remove(karakter);
        if(equals(karakter.getLokatie())){
            karakter.setLokatie(null);
        }
    }
    
    public boolean hasKarakter(Karakter karakter){
        return karakters.contains(karakter);
    }
    
    public int getKarakterCount(){
        return karakters.size();
    }
    
    public void addBestemming(Lokatie bestemming){
        bestemmingen.add(bestemming);
        if(!bestemming.hasBestemming(this)){
            bestemming.addBestemming(this);
        }
    }
    
    public void removeBestemming(Lokatie bestemming){
        bestemmingen.remove(bestemming);
        if(bestemming.hasBestemming(this)){
            bestemming.removeBestemming(this);
        }
    }
    
    public boolean hasBestemming(Lokatie bestemming){
        return bestemmingen.contains(bestemming);
    }
    
    public int getBestemmingCount(){
        return bestemmingen.size();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Lokatie){
            Lokatie lok = (Lokatie) o;
            if(this.lokatieId > 0){
                return this.lokatieId == lok.getId();
            }
            else {
                return this.beschrijving.equals(lok.getBeschrijving()) && 
                        this.items.equals(lok.getItems()) && 
                        this.karakters.equals(lok.getKarakters());
            }
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        if(lokatieId > 0){
            return (int) lokatieId;
        }
        else {
            String hashString = beschrijving + items.toString() + karakters.toString();
            return hashString.hashCode();
        }
    }
    
}
