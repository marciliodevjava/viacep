package br.com.viacep.service;

import br.com.viacep.domain.Cep;
import br.com.viacep.dto.response.CepDto;
import br.com.viacep.http.RequestViaCep;
import br.com.viacep.mapper.CepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    @Autowired
    private CepMapper cepMapper;
    @Autowired
    private RequestViaCep requestViaCep;

    public CepDto buscarCep(String cep) {
        Cep consultar = requestViaCep.buscarCep(cep);
        CepDto dto = cepMapper.mapeiaDto(consultar);
        return dto;
    }
}
