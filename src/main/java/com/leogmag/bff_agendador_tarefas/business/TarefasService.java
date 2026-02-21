package com.leogmag.bff_agendador_tarefas.business;


import com.leogmag.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.leogmag.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.leogmag.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import com.leogmag.bff_agendador_tarefas.infrastructure.enums.StatusNotificacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                            LocalDateTime dataFinal,
                                                            String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorEmail(String token) {

        return tarefasClient.buscaListadeTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacao status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);

    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id, token);
    }

}
