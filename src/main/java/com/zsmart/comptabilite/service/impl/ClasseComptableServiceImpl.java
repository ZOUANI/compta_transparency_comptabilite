
package com.zsmart.comptabilite.service.impl ;
import com.zsmart.comptabilite.service.facade.ClasseComptableService ; 
import com.zsmart.comptabilite.dao.ClasseComptableDao ;
import com.zsmart.comptabilite.service.util.SearchUtil;
import com.zsmart.comptabilite.bean.ClasseComptable;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.comptabilite.service.facade.SousClasseComptableService ; 
import com.zsmart.comptabilite.bean.SousClasseComptable ; 

 @Service  

 public class ClasseComptableServiceImpl implements ClasseComptableService  {


 @Autowired 

 private ClasseComptableDao classecomptableDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private SousClasseComptableService sousclassecomptableService; 

 @Override 
public ClasseComptable  save (ClasseComptable classecomptable){

if(classecomptable== null){ 
 return null; 
}else {
 classecomptableDao.save(classecomptable);
return classecomptable;
}
}

 @Override 
public ClasseComptable  saveWithSousClasseComptables (ClasseComptable classecomptable){

if(classecomptable== null){ 
        return null; 
}else {
   if(classecomptable.getSousClasseComptables().isEmpty()){
            return null;
        }else{
            for (SousClasseComptable sousclassecomptable : classecomptable.getSousClasseComptables()) {
sousclassecomptable.setClasseComptable(classecomptable);
 sousclassecomptableService.save(  sousclassecomptable);          
            }
            }
classecomptableDao.save(classecomptable);
return classecomptable;
}
}

 @Override 
public List< ClasseComptable>  findAll(){
 return classecomptableDao.findAll();
}

 @Override 
public ClasseComptable findById(Long id){
 return classecomptableDao.getOne(id);
}

 @Override 
public int delete(ClasseComptable classecomptable){
if(classecomptable== null){ 
  return -1; 
}else {
 classecomptableDao.delete(classecomptable);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       classecomptableDao.deleteById(id);
}
public void clone(ClasseComptable classecomptable,ClasseComptable classecomptableClone){
if(classecomptable!= null && classecomptableClone != null){
classecomptableClone.setId(classecomptable.getId());
classecomptableClone.setNumero(classecomptable.getNumero());
classecomptableClone.setLibelle(classecomptable.getLibelle());
classecomptableClone.setSousClasseComptables(sousclassecomptableService.clone(classecomptable.getSousClasseComptables()));
}
}
public ClasseComptable clone(ClasseComptable classecomptable){
if(classecomptable== null){       return null ;
}else{ClasseComptable classecomptableClone= new ClasseComptable();
classecomptableClone.setId(classecomptable.getId());
classecomptableClone.setNumero(classecomptable.getNumero());
classecomptableClone.setLibelle(classecomptable.getLibelle());
classecomptableClone.setSousClasseComptables(sousclassecomptableService.clone(classecomptable.getSousClasseComptables()));
return classecomptableClone;
}
}
public List<ClasseComptable> clone(List<ClasseComptable>classecomptables){
if(classecomptables== null){
       return null ;
}else{List<ClasseComptable> classecomptablesClone = new ArrayList();
	 	 	 classecomptables.forEach((classecomptable)->{classecomptablesClone.add(clone(classecomptable));
});return classecomptablesClone;
}
}
 @Override 
 public List< ClasseComptable>  findByCriteria(String libelle,Long idMin,Long idMax,Integer numeroMin,Integer numeroMax){
 return entityManager.createQuery(constructQuery(libelle,idMin,idMax,numeroMin,numeroMax)).getResultList(); 
 }
private String constructQuery(String libelle,Long idMin,Long idMax,Integer numeroMin,Integer numeroMax){
String query = "SELECT c FROM ClasseComptable c where 1=1 ";
query += SearchUtil.addConstraint( "c", "libelle","=",libelle);
query += SearchUtil.addConstraintMinMax("c", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("c", "numero", numeroMin, numeroMax);

  return query; 
}
}
