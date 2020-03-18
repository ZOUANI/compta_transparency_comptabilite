
package com.zsmart.comptabilite.service.impl ;
import com.zsmart.comptabilite.service.facade.CaisseService ; 
import com.zsmart.comptabilite.dao.CaisseDao ;
import com.zsmart.comptabilite.service.util.SearchUtil;
import com.zsmart.comptabilite.bean.Caisse;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class CaisseServiceImpl implements CaisseService  {


 @Autowired 

 private CaisseDao caisseDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public Caisse  save (Caisse caisse){

if(caisse== null){ 
 return null; 
}else {
 caisseDao.save(caisse);
return caisse;
}
}

 @Override 
public List< Caisse>  findAll(){
 return caisseDao.findAll();
}

 @Override 
public Caisse findById(Long id){
 return caisseDao.getOne(id);
}

 @Override 
public int delete(Caisse caisse){
if(caisse== null){ 
  return -1; 
}else {
 caisseDao.delete(caisse);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       caisseDao.deleteById(id);
}
public void clone(Caisse caisse,Caisse caisseClone){
if(caisse!= null && caisseClone != null){
caisseClone.setId(caisse.getId());
caisseClone.setLibelle(caisse.getLibelle());
caisseClone.setCode(caisse.getCode());
caisseClone.setSolde(caisse.getSolde());
}
}
public Caisse clone(Caisse caisse){
if(caisse== null){       return null ;
}else{Caisse caisseClone= new Caisse();
caisseClone.setId(caisse.getId());
caisseClone.setLibelle(caisse.getLibelle());
caisseClone.setCode(caisse.getCode());
caisseClone.setSolde(caisse.getSolde());
return caisseClone;
}
}
public List<Caisse> clone(List<Caisse>caisses){
if(caisses== null){
       return null ;
}else{List<Caisse> caissesClone = new ArrayList();
	 	 	 caisses.forEach((caisse)->{caissesClone.add(clone(caisse));
});return caissesClone;
}
}
 @Override 
 public List< Caisse>  findByCriteria(String libelle,String code,Long idMin,Long idMax,BigDecimal soldeMin,BigDecimal soldeMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax,soldeMin,soldeMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax,BigDecimal soldeMin,BigDecimal soldeMax){
String query = "SELECT c FROM Caisse c where 1=1 ";
query += SearchUtil.addConstraint( "c", "libelle","=",libelle);
query += SearchUtil.addConstraint( "c", "code","=",code);
query += SearchUtil.addConstraintMinMax("c", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("c", "solde", soldeMin, soldeMax);

  return query; 
}
}
