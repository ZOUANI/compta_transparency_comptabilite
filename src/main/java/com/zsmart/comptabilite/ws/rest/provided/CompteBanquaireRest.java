package com.zsmart.comptabilite.ws.rest.provided ;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.comptabilite.service.facade.CompteBanquaireService;
import com.zsmart.comptabilite.bean.CompteBanquaire;
import com.zsmart.comptabilite.ws.rest.vo.CompteBanquaireVo;
import com.zsmart.comptabilite.ws.rest.converter.CompteBanquaireConverter;
import com.zsmart.comptabilite.service.util.* ;
@RestController
@RequestMapping("/comptabilite/CompteBanquaire")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CompteBanquaireRest {

 @Autowired 
 private CompteBanquaireService compteBanquaireService;

 @Autowired 
private CompteBanquaireConverter compteBanquaireConverter ;

@PostMapping("/")
public CompteBanquaireVo save(@RequestBody CompteBanquaireVo compteBanquaireVo){
CompteBanquaire compteBanquaire= compteBanquaireConverter.toItem(compteBanquaireVo);
return compteBanquaireConverter.toVo(compteBanquaireService.save(compteBanquaire));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
compteBanquaireService.deleteById(id);
}
@GetMapping("/")
public List<CompteBanquaireVo> findAll(){
return compteBanquaireConverter.toVo(compteBanquaireService.findAll());
}

 public CompteBanquaireConverter getCompteBanquaireConverter(){
return compteBanquaireConverter;
}
 
 public void setCompteBanquaireConverter(CompteBanquaireConverter compteBanquaireConverter){
this.compteBanquaireConverter=compteBanquaireConverter;
}

 public CompteBanquaireService getCompteBanquaireService(){
return compteBanquaireService;
}
 
 public void setCompteBanquaireService(CompteBanquaireService compteBanquaireService){
this.compteBanquaireService=compteBanquaireService;
}

}