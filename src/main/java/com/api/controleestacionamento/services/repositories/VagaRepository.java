package com.api.controleestacionamento.services.repositories;

import com.api.controleestacionamento.models.VagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, UUID> {
    boolean existsByNumeroDaVaga(String numeroDaVaga);

    boolean existsByApartamento(String apartamento);
}
