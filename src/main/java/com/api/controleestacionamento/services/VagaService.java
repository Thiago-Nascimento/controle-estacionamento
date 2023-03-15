package com.api.controleestacionamento.services;

import com.api.controleestacionamento.models.VagaModel;
import com.api.controleestacionamento.services.repositories.VagaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VagaService {

    final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Transactional
    public VagaModel salvar(VagaModel vagaModel) {
        return vagaRepository.save(vagaModel);
    }

    public boolean existsByNumeroDaVaga(String numeroDaVaga) {
        return vagaRepository.existsByNumeroDaVaga(numeroDaVaga);
    }

    public boolean existsByApartamento(String apartamento) {
        return vagaRepository.existsByApartamento(apartamento);
    }

    public List<VagaModel> findAll() {
        return vagaRepository.findAll();
    }

    public Optional<VagaModel> findById(UUID id) {
        return vagaRepository.findById(id);
    }
}
