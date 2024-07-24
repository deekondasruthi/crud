package curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import curd.entity.CurdEntity;

public interface CurdRepository extends JpaRepository<CurdEntity, Integer>{

}
