package com.Repositories;

import com.Model.Examen;
import com.Model.Explication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplicationRepository extends JpaRepository<Explication, Integer> {

}
