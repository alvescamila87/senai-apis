package com.senai.convertionapi.services;

import com.senai.convertionapi.dtos.RequisicaoDTO;
import com.senai.convertionapi.dtos.RespostaDTO;
import org.springframework.stereotype.Service;

@Service
public class ConversorService {

    //Conversor compromento
    public RespostaDTO converterComprimento(RequisicaoDTO requisicao) {
        final var respostaDTO = transformaRequisicaoEmResposta(requisicao);

        if(requisicao.getTipoConversao().equalsIgnoreCase("cm-m")){
            respostaDTO.setValorConvertido(respostaDTO.getValorOriginal() / 100);
        } else if(requisicao.getTipoConversao().equalsIgnoreCase("m-cm")) {
            respostaDTO.setValorConvertido(respostaDTO.getValorOriginal() * 100);
        } else {
            //respostaDTO.setErro("Tipo de conversão de inválido! Use um dos seguintes: 'cm-m' OU 'm-cm'.");
            exibeMensagemDeErro(respostaDTO);
        }
        return respostaDTO;
    }

    //Conversor massa
    public RespostaDTO converterMassa(RequisicaoDTO requisicao) {
        final var respostaDTO = transformaRequisicaoEmResposta(requisicao);

        if(requisicao.getTipoConversao().equalsIgnoreCase("g-kg")) {
            respostaDTO.setValorConvertido(requisicao.getValor() / 1000);
        } else if (requisicao.getTipoConversao().equalsIgnoreCase("kg-g")) {
            respostaDTO.setValorConvertido(requisicao.getValor() * 1000);
        } else {
            //respostaDTO.setErro("Tipo de conversão inválido. Use um dos seguintes: 'g-kg' OU 'kg-g'.");
            exibeMensagemDeErro(respostaDTO);
        }

        return respostaDTO;
    }


    //Conversor temperatura
    public RespostaDTO converterTemperatura(RequisicaoDTO requisicao) {
        final var respostaDTO = transformaRequisicaoEmResposta(requisicao);

        if(requisicao.getTipoConversao().equalsIgnoreCase("c-f")) {
            respostaDTO.setValorConvertido((requisicao.getValor() - 32) * 5/9);
        } else if(requisicao.getTipoConversao().equalsIgnoreCase("f-c")) {
            respostaDTO.setValorConvertido((requisicao.getValor() * 9/5) + 32);
        } else {
            ////respostaDTO.setErro("Tipo de conversão inválido. Use um dos seguintes: 'c-g' OU 'f-c'.");
            exibeMensagemDeErro(respostaDTO);
        }

        return respostaDTO;
    }

    private static void exibeMensagemDeErro(RespostaDTO respostaDTO) {
        respostaDTO.setErro("Tipo de conversão inválido. Use um dos seguintes: cm-m, m-cm, kg-g, g-kg, c-f, f-c.");
    }

    private static RespostaDTO transformaRequisicaoEmResposta(RequisicaoDTO requisicao) {
        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setValorOriginal(requisicao.getValor());
        respostaDTO.setTipoConversao(requisicao.getTipoConversao());
        return respostaDTO;
    }



}
