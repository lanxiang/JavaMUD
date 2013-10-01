/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.services;
    
import be.vdab.dao.LokatieDAO;
import be.vdab.entities.Lokatie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013(tmtvl): Initial version.
 */
@Service
public class LokatieServiceImpl implements LokatieService {
    private final LokatieDAO lokatieDAO;
    
    @Autowired
    public LokatieServiceImpl(LokatieDAO lokatieDAO){
        this.lokatieDAO = lokatieDAO;
    }
    
    @Override
    public void create(Lokatie lokatie){
        lokatieDAO.create(lokatie);
    }
    
    @Override
    public Lokatie read(long id){
        return lokatieDAO.read(id);
    }
    
    @Override
    public void update(Lokatie lokatie){
        lokatieDAO.update(lokatie);
    }
    
    @Override
    public void delete(long id){
        Lokatie lokatie = read(id);
        List<Lokatie> lokaties = lokatie.getBestemmingen();
        for(Lokatie bestemming : lokaties){
            bestemming.removeBestemming(lokatie);
            update(bestemming);
        }
        lokatieDAO.delete(id);
    }
    
    @Override
    public List<Lokatie> findByBestemming(Lokatie bestemming){
        return lokatieDAO.findByBestemming(bestemming);
    }
    
}
