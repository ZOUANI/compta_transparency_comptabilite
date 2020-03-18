package com.zsmart.comptabilite.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.comptabilite.service.util.*;
import com.zsmart.comptabilite.bean.Caisse; 
import com.zsmart.comptabilite.ws.rest.vo.CaisseVo; 

 @Component 
public class CaisseConverter extends AbstractConverter<Caisse,CaisseVo>{ 


 @Override 
 public Caisse toItem(CaisseVo vo) {
 if (vo == null) {
    return null;
      } else {
Caisse item = new Caisse();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

 if (vo.getSolde() != null) {
 item.setSolde(NumberUtil.toBigDecimal(vo.getSolde()));
} 

return item;
 }
 }

  @Override 
 public CaisseVo toVo(Caisse item) {
 if (item == null) {
    return null;
      } else {
CaisseVo vo = new CaisseVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

 if (item.getSolde() != null) {
 vo.setSolde(NumberUtil.toString(item.getSolde()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
