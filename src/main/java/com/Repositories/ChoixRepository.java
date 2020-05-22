package com.Repositories;

import com.Model.Choix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoixRepository extends JpaRepository<Choix, Integer> {

}
