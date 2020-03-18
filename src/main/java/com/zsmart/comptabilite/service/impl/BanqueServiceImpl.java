
package com.zsmart.comptabilite.service.impl ;
import com.zsmart.comptabilite.service.facade.BanqueService ; 
import com.zsmart.comptabilite.dao.BanqueDao ;
import com.zsmart.comptabilite.service.util.SearchUtil;
import com.zsmart.comptabilite.bean.Banque;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class BanqueServiceImpl implements BanqueService  {


 @Autowired 

 private BanqueDao banqueDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public Banque  save (Banque banque){

if(banque== null){ 
 return null; 
}else {
 banqueDao.save(banque);
return banque;
}
}

 @Override 
public List< Banque>  findAll(){
 return banqueDao.findAll();
}

 @Override 
public Banque findById(Long id){
 return banqueDao.getOne(id);
}

 @Override 
public int delete(Banque banque){
if(banque== null){ 
  return -1; 
}else {
 banqueDao.delete(banque);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       banqueDao.deleteById(id);
}
public void clone(Banque banque,Banque banqueClone){
if(banque!= null && banqueClone != null){
banqueClone.setId(banque.getId());
banqueClone.setLibelle(banque.getLibelle());
banqueClone.setCode(banque.getCode());
}
}
public Banque clone(Banque banque){
if(banque== null){       return null ;
}else{Banque banqueClone= new Banque();
banqueClone.setId(banque.getId());
banqueClone.setLibelle(banque.getLibelle());
banqueClone.setCode(banque.getCode());
return banqueClone;
}
}
public List<Banque> clone(List<Banque>banques){
if(banques== null){
       return null ;
}else{List<Banque> banquesClone = new ArrayList();
	 	 	 banques.forEach((banque)->{banquesClone.add(clone(banque));
});return banquesClone;
}
}
 @Override 
 public List< Banque>  findByCriteria(String libelle,String code,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax){
String query = "SELECT b FROM Banque b where 1=1 ";
query += SearchUtil.addConstraint( "b", "libelle","=",libelle);
query += SearchUtil.addConstraint( "b", "code","=",code);
query += SearchUtil.addConstraintMinMax("b", "id", idMin, idMax);

  return query; 
}
}
