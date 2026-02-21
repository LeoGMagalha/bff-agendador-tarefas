package com.leogmag.bff_agendador_tarefas.business;

import com.leogmag.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.leogmag.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.leogmag.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.leogmag.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.leogmag.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.leogmag.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.leogmag.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.leogmag.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.leogmag.bff_agendador_tarefas.infrastructure.client.EmailClient;
import com.leogmag.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse tarefasDTOResponse){
        emailClient.enviarEmail(tarefasDTOResponse);
    }
}
