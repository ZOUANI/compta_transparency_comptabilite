
package com.zsmart.comptabilite.service.impl ;
import com.zsmart.comptabilite.service.facade.EtatOperationComptableService ; 
import com.zsmart.comptabilite.dao.EtatOperationComptableDao ;
import com.zsmart.comptabilite.service.util.SearchUtil;
import com.zsmart.comptabilite.bean.EtatOperationComptable;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class EtatOperationComptableServiceImpl implements EtatOperationComptableService  {


 @Autowired 

 private EtatOperationComptableDao etatoperationcomptableDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public EtatOperationComptable  save (EtatOperationComptable etatoperationcomptable){

if(etatoperationcomptable== null){ 
 return null; 
}else {
 etatoperationcomptableDao.save(etatoperationcomptable);
return etatoperationcomptable;
}
}

 @Override 
public List< EtatOperationComptable>  findAll(){
 return etatoperationcomptableDao.findAll();
}

 @Override 
public EtatOperationComptable findById(Long id){
 return etatoperationcomptableDao.getOne(id);
}

 @Override 
public int delete(EtatOperationComptable etatoperationcomptable){
if(etatoperationcomptable== null){ 
  return -1; 
}else {
 etatoperationcomptableDao.delete(etatoperationcomptable);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       etatoperationcomptableDao.deleteById(id);
}
public void clone(EtatOperationComptable etatoperationcomptable,EtatOperationComptable etatoperationcomptableClone){
if(etatoperationcomptable!= null && etatoperationcomptableClone != null){
etatoperationcomptableClone.setId(etatoperationcomptable.getId());
etatoperationcomptableClone.setLibelle(etatoperationcomptable.getLibelle());
etatoperationcomptableClone.setCode(etatoperationcomptable.getCode());
}
}
public EtatOperationComptable clone(EtatOperationComptable etatoperationcomptable){
if(etatoperationcomptable== null){       return null ;
}else{EtatOperationComptable etatoperationcomptableClone= new EtatOperationComptable();
etatoperationcomptableClone.setId(etatoperationcomptable.getId());
etatoperationcomptableClone.setLibelle(etatoperationcomptable.getLibelle());
etatoperationcomptableClone.setCode(etatoperationcomptable.getCode());
return etatoperationcomptableClone;
}
}
public List<EtatOperationComptable> clone(List<EtatOperationComptable>etatoperationcomptables){
if(etatoperationcomptables== null){
       return null ;
}else{List<EtatOperationComptable> etatoperationcomptablesClone = new ArrayList();
	 	 	 etatoperationcomptables.forEach((etatoperationcomptable)->{etatoperationcomptablesClone.add(clone(etatoperationcomptable));
});return etatoperationcomptablesClone;
}
}
 @Override 
 public List< EtatOperationComptable>  findByCriteria(String libelle,String code,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax){
String query = "SELECT e FROM EtatOperationComptable e where 1=1 ";
query += SearchUtil.addConstraint( "e", "libelle","=",libelle);
query += SearchUtil.addConstraint( "e", "code","=",code);
query += SearchUtil.addConstraintMinMax("e", "id", idMin, idMax);

  return query; 
}
}
