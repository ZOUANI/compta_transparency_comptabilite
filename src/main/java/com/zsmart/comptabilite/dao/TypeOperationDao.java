package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.TypeOperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface TypeOperationDao extends JpaRepository<TypeOperation,Long> {




}
