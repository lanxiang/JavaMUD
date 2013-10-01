/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.dao;
    
import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Initial version.
 */
@Repository
public class ItemDAOImpl implements ItemDAO {
    private static final Map<Long, Item> items = new ConcurrentHashMap<>();
    
    public ItemDAOImpl(){
        // TODO: Add items.
    }
    
    @Override
    public void create(Item item){
        long id = 0;
        for(Long l : items.keySet()){
            id = l > id ? l : id;
        }
        id++;
        item.setId(id);
        items.put(id, item);
    }
    
    @Override
    public Item read(long id){
        return items.get(id);
    }
    
    @Override
    public void update(Item item){
        items.put(item.getId(), item);
    }
    
    @Override
    public void delete(long id){
        items.remove(id);
    }
    
    @Override
    public List<Item> findByKarakter(Karakter karakter){
        List<Item> result = new ArrayList<>();
        
        for(Item item : items.values()){
            if(karakter.equals(item.getEigenaar())){
                result.add(item);
            }
        }
        
        return result;
    }
    
    @Override
    public List<Item> findByLokatie(Lokatie lokatie){
        List<Item> result = new ArrayList<>();
        
        for(Item item : items.values()){
            if(lokatie.equals(item.getPositie())){
                result.add(item);
            }
        }
        
        return result;
    }
    
}
