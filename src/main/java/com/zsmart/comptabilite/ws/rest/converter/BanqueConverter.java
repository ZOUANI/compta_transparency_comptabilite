package com.zsmart.comptabilite.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.comptabilite.service.util.*;
import com.zsmart.comptabilite.bean.Banque; 
import com.zsmart.comptabilite.ws.rest.vo.BanqueVo; 

 @Component 
public class BanqueConverter extends AbstractConverter<Banque,BanqueVo>{ 


 @Override 
 public Banque toItem(BanqueVo vo) {
 if (vo == null) {
    return null;
      } else {
Banque item = new Banque();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public BanqueVo toVo(Banque item) {
 if (item == null) {
    return null;
      } else {
BanqueVo vo = new BanqueVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
