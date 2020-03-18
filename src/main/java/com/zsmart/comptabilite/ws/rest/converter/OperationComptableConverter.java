package com.zsmart.comptabilite.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.comptabilite.service.util.*;
import com.zsmart.comptabilite.bean.OperationComptable; 
import com.zsmart.comptabilite.ws.rest.vo.OperationComptableVo; 

 @Component 
public class OperationComptableConverter extends AbstractConverter<OperationComptable,OperationComptableVo>{ 

private boolean caisse; 

 @Autowired
 private CaisseConverter caisseConverter ; 
private boolean typeOperation; 

 @Autowired
 private TypeOperationConverter typeOperationConverter ; 
private boolean compteBanquaire; 

 @Autowired
 private CompteBanquaireConverter compteBanquaireConverter ; 
private boolean compteComptable; 

 @Autowired
 private CompteComptableConverter compteComptableConverter ; 

 @Override 
 public OperationComptable toItem(OperationComptableVo vo) {
 if (vo == null) {
    return null;
      } else {
OperationComptable item = new OperationComptable();

 if(caisse&& vo.getCaisseVo() != null) {
 item.setCaisse(caisseConverter.toItem(vo.getCaisseVo()));
} 
 
 if(typeOperation&& vo.getTypeOperationVo() != null) {
 item.setTypeOperation(typeOperationConverter.toItem(vo.getTypeOperationVo()));
} 
 
 if(compteBanquaire&& vo.getCompteBanquaireVo() != null) {
 item.setCompteBanquaire(compteBanquaireConverter.toItem(vo.getCompteBanquaireVo()));
} 
 
 if(compteComptable&& vo.getCompteComptableVo() != null) {
 item.setCompteComptable(compteComptableConverter.toItem(vo.getCompteComptableVo()));
} 
 
 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceSociete())) {
 item.setReferenceSociete(vo.getReferenceSociete());
} 

 if (StringUtil.isNotEmpty(vo.getReferenceFacture())) {
 item.setReferenceFacture(vo.getReferenceFacture());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getMontant() != null) {
 item.setMontant(NumberUtil.toBigDecimal(vo.getMontant()));
} 

 if (vo.getDateOperationComptable() != null) {
 item.setDateOperationComptable(DateUtil.parse(vo.getDateOperationComptable()));
} 

 if (vo.getDateSaisie() != null) {
 item.setDateSaisie(DateUtil.parse(vo.getDateSaisie()));
} 

return item;
 }
 }

  @Override 
 public OperationComptableVo toVo(OperationComptable item) {
 if (item == null) {
    return null;
      } else {
OperationComptableVo vo = new OperationComptableVo();

 if(caisse&& item.getCaisse() != null) {
 vo.setCaisseVo(caisseConverter.toVo(item.getCaisse()));
} 
 
 if(typeOperation&& item.getTypeOperation() != null) {
 vo.setTypeOperationVo(typeOperationConverter.toVo(item.getTypeOperation()));
} 
 
 if(compteBanquaire&& item.getCompteBanquaire() != null) {
 vo.setCompteBanquaireVo(compteBanquaireConverter.toVo(item.getCompteBanquaire()));
} 
 
 if(compteComptable&& item.getCompteComptable() != null) {
 vo.setCompteComptableVo(compteComptableConverter.toVo(item.getCompteComptable()));
} 
 
 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getReferenceSociete())) {
 vo.setReferenceSociete(item.getReferenceSociete());
} 

 if (StringUtil.isNotEmpty(item.getReferenceFacture())) {
 vo.setReferenceFacture(item.getReferenceFacture());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getMontant() != null) {
 vo.setMontant(NumberUtil.toString(item.getMontant()));
} 

 if (item.getDateOperationComptable() != null) {
 vo.setDateOperationComptable(DateUtil.formateDate(item.getDateOperationComptable()));
} 

 if (item.getDateSaisie() != null) {
 vo.setDateSaisie(DateUtil.formateDate(item.getDateSaisie()));
} 

return vo;
 }
 }
public void init() { 

caisse = true; 

typeOperation = true; 

compteBanquaire = true; 

compteComptable = true; 
}
 } 
