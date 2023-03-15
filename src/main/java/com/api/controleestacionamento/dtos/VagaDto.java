package com.api.controleestacionamento.dtos;

import javax.validation.constraints.NotBlank;

public class VagaDto {
    @NotBlank
    private String numeroDaVaga;

    @NotBlank
    private String nomeResponsavel;

    @NotBlank
    private String apartamento;

    public String getNumeroDaVaga() {
        return numeroDaVaga;
    }

    public void setNumeroDaVaga(String numeroDaVaga) {
        this.numeroDaVaga = numeroDaVaga;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }
}
