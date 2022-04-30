package machinex;

import machinex.models.Geraete;
import java.util.List;

/**
 *
 * @author ysfzyak
 */

public interface GeraeteCtrl {
    
    public void save(Geraete geraete);
    public void update(Geraete geraete);
    public void delete(Geraete geraete);
    public Geraete get(int produktCode);
    public List<Geraete> list();
 
}
