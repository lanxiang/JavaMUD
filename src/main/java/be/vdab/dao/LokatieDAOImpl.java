/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.dao;
    
import be.vdab.entities.Lokatie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013 (tmtvl): Initial version.
 */
@Repository
public class LokatieDAOImpl implements LokatieDAO {
    private static final Map<Long, Lokatie> lokaties = new ConcurrentHashMap<>();
    
    public LokatieDAOImpl(){
        Lokatie l = new Lokatie("De eerste lokatie");
        l.setId(1L);
        lokaties.put(1L, l);
    }
    
    @Override
    public void create(Lokatie lokatie){
        long id = 0;
        for(Long l : lokaties.keySet()){
            id = l > id ? l : id;
        }
        id++;
        lokatie.setId(id);
        lokaties.put(id, lokatie);
    }
    
    @Override
    public Lokatie read(long id){
        return lokaties.get(id);
    }
    
    @Override
    public void update(Lokatie lokatie){
        lokaties.put(lokatie.getId(), lokatie);
    }
    
    @Override
    public void delete(long id){
        lokaties.remove(id);
    }
    
    @Override
    public List<Lokatie> findByBestemming(Lokatie bestemming){
        List<Lokatie> result = new ArrayList<>();
        for(Lokatie lokatie : lokaties.values()){
            if(lokatie.hasBestemming(bestemming)){
                result.add(lokatie);
            }
        }
        return result;
    }
    
}
