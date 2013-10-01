/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 30-09-2013 (tmtvl): Initial version.
 */
public class Karakter implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long karakterId;
    private Gebruiker gebruiker;
    private Lokatie lokatie;
    private List<Item> items;
    private String naam;
    
    protected Karakter(){
        gebruiker = null;
        naam = "";
        lokatie = null;
        items = new ArrayList<>();
    }
    
    public Karakter(Gebruiker gebruiker, String naam){
        this();
        setGebruiker(gebruiker);
        setNaam(naam);
    }
    
    public Karakter(long karakterId, Gebruiker gebruiker, String naam, 
            Lokatie lokatie, List<Item> items){
        this(gebruiker, naam);
        setId(karakterId);
        setLokatie(lokatie);
        setItems(items);
    }
    
    public void setId(long karakterId){
        this.karakterId = karakterId;
    }
    
    public void setGebruiker(Gebruiker gebruiker){
        this.gebruiker = gebruiker;
    }
    
    public void setNaam(String naam){
        this.naam = naam;
    }
    
    public void setLokatie(Lokatie lokatie){
        if(this.lokatie != null && this.lokatie.hasKarakter(this)){
            this.lokatie.removeKarakter(this);
        }
        this.lokatie = lokatie;
        if(lokatie != null & !lokatie.hasKarakter(this)){
            lokatie.addKarakter(this);
        }
    }
    
    public void setItems(List<Item> items){
        this.items = items;
    }
    
    public long getId(){
        return karakterId;
    }
    
    public Gebruiker getGebruiker(){
        return gebruiker;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public Lokatie getLokatie(){
        return lokatie;
    }
    
    public List<Item> getItems(){
        return items;
    }
    
    public void addItem(Item item){
        items.add(item);
        if(item != null && !equals(item.getEigenaar())){
            item.setEigenaar(this);
        }
    }
    
    public void removeItem(Item item){
        items.remove(item);
        if(item != null && equals(item.getEigenaar())){
            item.setEigenaar(null);
        }
    }
    
    public boolean hasItem(Item item){
        return items.contains(item);
    }
    
    public int getItemCount(){
        return items.size();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Karakter){
            Karakter k = (Karakter) obj;
            if(this.karakterId != 0){
                return this.karakterId == k.getId();
            }
            else {
                if(this.lokatie == null){
                    return this.gebruiker.equals(k.getGebruiker()) &&
                            this.items.equals(k.getItems()) && 
                            this.naam.equals(k.getNaam());
                }
                else {
                    return this.gebruiker.equals(k.getGebruiker()) &&
                            this.items.equals(k.getItems()) && 
                            this.naam.equals(k.getNaam()) &&
                            this.lokatie.equals(k.getLokatie());
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (int) (this.karakterId ^ (this.karakterId >>> 32));
        hash = 73 * hash + Objects.hashCode(this.gebruiker);
        hash = 73 * hash + Objects.hashCode(this.lokatie);
        hash = 73 * hash + Objects.hashCode(this.items);
        hash = 73 * hash + Objects.hashCode(this.naam);
        return hash;
    }
    
}
