package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.Caisse;
import com.zsmart.comptabilite.bean.TypeOperation;
import com.zsmart.comptabilite.bean.CompteBanquaire;
import com.zsmart.comptabilite.bean.CompteComptable;
import com.zsmart.comptabilite.bean.OperationComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface OperationComptableDao extends JpaRepository<OperationComptable,Long> {


	 public OperationComptable findByCaisse(Caisse caisse);
	 public OperationComptable findByTypeOperation(TypeOperation typeOperation);
	 public OperationComptable findByCompteBanquaire(CompteBanquaire compteBanquaire);
	 public OperationComptable findByCompteComptable(CompteComptable compteComptable);

	 public int deleteByCaisse(Caisse caisse);
	 public int deleteByTypeOperation(TypeOperation typeOperation);
	 public int deleteByCompteBanquaire(CompteBanquaire compteBanquaire);
	 public int deleteByCompteComptable(CompteComptable compteComptable);

}
