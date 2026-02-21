package com.leogmag.bff_agendador_tarefas.business.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leogmag.bff_agendador_tarefas.infrastructure.enums.StatusNotificacao;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTOResponse {

    private String id;
    private String nomeTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacao statusNotificacao;

}

