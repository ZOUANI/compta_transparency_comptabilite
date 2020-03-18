package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.EtatOperationComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface EtatOperationComptableDao extends JpaRepository<EtatOperationComptable,Long> {




}
