/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.dao.ItemDAO;
import be.vdab.entities.Item;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): initial version.
 */
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemDAO itemDAO;
    
    @Autowired
    public ItemServiceImpl(ItemDAO itemDAO){
        this.itemDAO = itemDAO;
    }
    
    @Override
    public void create(Item item){
        itemDAO.create(item);
    }
    
    @Override
    public Item read(long id){
        return itemDAO.read(id);
    }
    
    @Override
    public void update(Item item){
        itemDAO.update(item);
    }
    
    @Override
    public void delete(long id){
        itemDAO.delete(id);
    }
    
    @Override
    public List<Item> findByKarakter(Karakter karakter){
        return itemDAO.findByKarakter(karakter);
    }
    
    @Override
    public List<Item> findByLokatie(Lokatie lokatie){
        return itemDAO.findByLokatie(lokatie);
    }
    
}
