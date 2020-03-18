
package com.zsmart.comptabilite.service.impl ;
import com.zsmart.comptabilite.service.facade.CompteBanquaireService ; 
import com.zsmart.comptabilite.dao.CompteBanquaireDao ;
import com.zsmart.comptabilite.service.util.SearchUtil;
import com.zsmart.comptabilite.bean.CompteBanquaire;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.comptabilite.bean.Banque; 
import com.zsmart.comptabilite.service.facade.BanqueService ; 

 @Service  

 public class CompteBanquaireServiceImpl implements CompteBanquaireService  {


 @Autowired 

 private CompteBanquaireDao comptebanquaireDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private BanqueService banqueService; 

 @Override 
public CompteBanquaire  save (CompteBanquaire comptebanquaire){

if(comptebanquaire== null){ 
 return null; 
}else {
 comptebanquaireDao.save(comptebanquaire);
return comptebanquaire;
}
}

 @Override 
public List< CompteBanquaire>  findAll(){
 return comptebanquaireDao.findAll();
}

 @Override 
public CompteBanquaire findById(Long id){
 return comptebanquaireDao.getOne(id);
}

 @Override 
public int delete(CompteBanquaire comptebanquaire){
if(comptebanquaire== null){ 
  return -1; 
}else {
 comptebanquaireDao.delete(comptebanquaire);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       comptebanquaireDao.deleteById(id);
}
public void clone(CompteBanquaire comptebanquaire,CompteBanquaire comptebanquaireClone){
if(comptebanquaire!= null && comptebanquaireClone != null){
comptebanquaireClone.setId(comptebanquaire.getId());
comptebanquaireClone.setLibelle(comptebanquaire.getLibelle());
comptebanquaireClone.setCode(comptebanquaire.getCode());
comptebanquaireClone.setSolde(comptebanquaire.getSolde());
comptebanquaireClone.setBanque(banqueService.clone(comptebanquaire.getBanque()));
}
}
public CompteBanquaire clone(CompteBanquaire comptebanquaire){
if(comptebanquaire== null){       return null ;
}else{CompteBanquaire comptebanquaireClone= new CompteBanquaire();
comptebanquaireClone.setId(comptebanquaire.getId());
comptebanquaireClone.setLibelle(comptebanquaire.getLibelle());
comptebanquaireClone.setCode(comptebanquaire.getCode());
comptebanquaireClone.setSolde(comptebanquaire.getSolde());
comptebanquaireClone.setBanque(banqueService.clone(comptebanquaire.getBanque()));
return comptebanquaireClone;
}
}
public List<CompteBanquaire> clone(List<CompteBanquaire>comptebanquaires){
if(comptebanquaires== null){
       return null ;
}else{List<CompteBanquaire> comptebanquairesClone = new ArrayList();
	 	 	 comptebanquaires.forEach((comptebanquaire)->{comptebanquairesClone.add(clone(comptebanquaire));
});return comptebanquairesClone;
}
}
 @Override 
 public List< CompteBanquaire>  findByCriteria(String libelle,String code,Long idMin,Long idMax,BigDecimal soldeMin,BigDecimal soldeMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax,soldeMin,soldeMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax,BigDecimal soldeMin,BigDecimal soldeMax){
String query = "SELECT c FROM CompteBanquaire c where 1=1 ";
query += SearchUtil.addConstraint( "c", "libelle","=",libelle);
query += SearchUtil.addConstraint( "c", "code","=",code);
query += SearchUtil.addConstraintMinMax("c", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("c", "solde", soldeMin, soldeMax);

  return query; 
}
}
