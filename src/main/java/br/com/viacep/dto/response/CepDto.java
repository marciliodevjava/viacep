package br.com.viacep.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CepDto {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
}
