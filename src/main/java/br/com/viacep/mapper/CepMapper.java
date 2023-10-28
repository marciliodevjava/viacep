package br.com.viacep.mapper;

import br.com.viacep.domain.Cep;
import br.com.viacep.dto.response.CepDto;
import br.com.viacep.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CepMapper {
    @Autowired
    private CepRepository cepRepository;

    public CepDto mapeiaDto(Cep consultar) {
        if (Objects.nonNull(consultar)) {
            CepDto dto = new CepDto();

            dto.setCep(consultar.getCep());
            dto.setUf(consultar.getUf());
            dto.setComplemento(consultar.getComplemento());
            dto.setLogradouro(consultar.getLogradouro());
            dto.setLocalidade(consultar.getLocalidade());
            dto.setBairro(consultar.getBairro());
            return dto;
        }
        return null;
    }
}
