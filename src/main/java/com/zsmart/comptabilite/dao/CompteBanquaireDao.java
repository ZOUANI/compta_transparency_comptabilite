package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.Banque;
import com.zsmart.comptabilite.bean.CompteBanquaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CompteBanquaireDao extends JpaRepository<CompteBanquaire,Long> {


	 public CompteBanquaire findByBanque(Banque banque);

	 public int deleteByBanque(Banque banque);

}
