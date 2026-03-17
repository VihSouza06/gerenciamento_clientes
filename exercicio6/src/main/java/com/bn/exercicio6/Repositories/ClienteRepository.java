package com.bn.exercicio6.Repositories;

import com.bn.exercicio6.Models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

}
