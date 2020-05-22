package com.Repositories;

import com.Model.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapitreRepository extends JpaRepository<Chapitre, Integer> {

}
