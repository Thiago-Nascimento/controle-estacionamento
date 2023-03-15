package com.api.controleestacionamento.controllers;

import com.api.controleestacionamento.dtos.VagaDto;
import com.api.controleestacionamento.models.VagaModel;
import com.api.controleestacionamento.services.VagaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vaga")
public class VagaController {

    final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<Object> criarVaga(@RequestBody @Valid VagaDto vagaDto) {
        if (vagaService.existsByNumeroDaVaga(vagaDto.getNumeroDaVaga())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Numero de Vaga já existe!!");
        }

        if (vagaService.existsByApartamento(vagaDto.getApartamento())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Apartamento já tem uma vaga!!");
        }

        var vagaModel = new VagaModel();
        BeanUtils.copyProperties(vagaDto, vagaModel);
        vagaModel.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaService.salvar(vagaModel));
    }

    @GetMapping
    public ResponseEntity<List<VagaModel>> getVagas() {
        return ResponseEntity.status(HttpStatus.OK).body(vagaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id) {
        Optional<VagaModel> vagaModelOptional = vagaService.findById(id);

        if (!vagaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(vagaModelOptional.get());
    }
}
