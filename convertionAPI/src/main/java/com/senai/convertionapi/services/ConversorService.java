package com.senai.convertionapi.services;

import com.senai.convertionapi.dtos.RequisicaoDTO;
import com.senai.convertionapi.dtos.RespostaDTO;
import org.springframework.stereotype.Service;

@Service
public class ConversorService {

    public RespostaDTO converterPorTipo(RequisicaoDTO requisicao) {
        var respostaDTO = transformarRequisicaoEmResposta(requisicao);

        if(requisicao.getTipoConversao().equalsIgnoreCase("cm-m") || requisicao.getTipoConversao().equalsIgnoreCase("m-cm")) {
            respostaDTO = converterComprimento(requisicao);
        } else if(requisicao.getTipoConversao().equalsIgnoreCase("g-kg") || requisicao.getTipoConversao().equalsIgnoreCase("kg-g")) {
            respostaDTO = converterMassa(requisicao);
        } else if(requisicao.getTipoConversao().equalsIgnoreCase("c-f") || requisicao.getTipoConversao().equalsIgnoreCase("f-c")) {
            respostaDTO = converterTemperatura(requisicao);
        } else {
            exibirMensagemDeErro(respostaDTO);
        }

        return respostaDTO;
    }

    private RespostaDTO converterComprimento(RequisicaoDTO requisicao) {
        final var respostaDTO = transformarRequisicaoEmResposta(requisicao);

        if(requisicao.getTipoConversao().equalsIgnoreCase("cm-m")){
            respostaDTO.setValorConvertido(respostaDTO.getValorOriginal() / 100);
        } else if(requisicao.getTipoConversao().equalsIgnoreCase("m-cm")) {
            respostaDTO.setValorConvertido(respostaDTO.getValorOriginal() * 100);
        }

        return respostaDTO;
    }

    private RespostaDTO converterMassa(RequisicaoDTO requisicao) {
        final var respostaDTO = transformarRequisicaoEmResposta(requisicao);

        if(requisicao.getTipoConversao().equalsIgnoreCase("g-kg")) {
            respostaDTO.setValorConvertido(requisicao.getValor() / 1000);
        } else if (requisicao.getTipoConversao().equalsIgnoreCase("kg-g")) {
            respostaDTO.setValorConvertido(requisicao.getValor() * 1000);
        }

        return respostaDTO;
    }

    private RespostaDTO converterTemperatura(RequisicaoDTO requisicao) {
        final var respostaDTO = transformarRequisicaoEmResposta(requisicao);

        if(requisicao.getTipoConversao().equalsIgnoreCase("c-f")) {
            respostaDTO.setValorConvertido((requisicao.getValor() * 9/5) + 32);
        } else if(requisicao.getTipoConversao().equalsIgnoreCase("f-c")) {
            respostaDTO.setValorConvertido((requisicao.getValor() - 32) * 5/9);
        }

        return respostaDTO;
    }

    private static RespostaDTO transformarRequisicaoEmResposta(RequisicaoDTO requisicao) {
        RespostaDTO respostaDTO = new RespostaDTO();

        respostaDTO.setValorOriginal(requisicao.getValor());
        respostaDTO.setTipoConversao(requisicao.getTipoConversao());

        return respostaDTO;
    }

    private static void exibirMensagemDeErro(RespostaDTO respostaDTO) {
        respostaDTO.setErro("Tipo de conversão inválido. Use um dos seguintes: cm-m, m-cm, kg-g, g-kg, c-f, f-c.");
    }
}
