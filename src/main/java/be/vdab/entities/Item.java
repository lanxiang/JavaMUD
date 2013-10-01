/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Complete version.
 *          0.1: 30-09-2013 (tmtvl): Initial version.
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long itemId;
    private Karakter eigenaar;
    private Lokatie positie;
    
    protected Item(){
        eigenaar = null;
        positie = null;
    }
    
    public Item(Lokatie positie){
        this();
        setPositie(positie);
    }
    
    public Item(Karakter eigenaar){
        this();
        setEigenaar(eigenaar);
    }
    
    public Item(long itemId, Karakter eigenaar, Lokatie positie){
        setId(itemId);
        setEigenaar(eigenaar);
        setPositie(positie);
    }
    
    public void setId(long itemId){
        this.itemId = itemId;
    }
    
    public void setEigenaar(Karakter eigenaar){
        if(this.eigenaar != null && this.eigenaar.hasItem(this)){
            this.eigenaar.removeItem(this);
        }
        this.eigenaar = eigenaar;
        if(eigenaar != null && !eigenaar.hasItem(this)){
            eigenaar.addItem(this);
            setPositie(null);
        }
    }
    
    public void setPositie(Lokatie positie){
        if(this.positie != null && this.positie.hasItem(this)){
            this.positie.removeItem(this);
        }
        this.positie = positie;
        if(positie != null && !positie.hasItem(this)){
            positie.addItem(this);
            setEigenaar(null);
        }
    }
    
    public long getId(){
        return itemId;
    }
    
    public Karakter getEigenaar(){
        return eigenaar;
    }
    
    public Lokatie getPositie(){
        return positie;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Item){
            Item item = (Item) obj;
            if(this.itemId != 0){
                return item.getId() == this.itemId;
            }
            else {
                if(this.eigenaar != null){
                    return this.eigenaar.equals(item.getEigenaar());
                }
                else if(this.positie != null){
                    return this.positie.equals(item.getPositie());
                }
                else {
                    return item.getEigenaar() == null && item.getPositie() == null;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.itemId ^ (this.itemId >>> 32));
        hash = 83 * hash + Objects.hashCode(this.eigenaar);
        hash = 83 * hash + Objects.hashCode(this.positie);
        return hash;
    }
    
}
