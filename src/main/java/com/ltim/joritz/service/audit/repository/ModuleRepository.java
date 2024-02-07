package com.ltim.joritz.service.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltim.joritz.service.audit.entity.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {

}
