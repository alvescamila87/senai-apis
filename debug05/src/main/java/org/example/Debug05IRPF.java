package org.example;

public class Debug05IRPF {
    public static void main(String[] args) {

        // CONTRIBUINTE 01
        Ex5 recolhimentoImpostoJoao = new Ex5(
                "João da Silva",
                " 123.456.789-00",
                "PR",
                35_001
        );


        //CÁLCULO DO IMPOSTO A PAGAR
        recolhimentoImpostoJoao.calcularImposto();
        //System.out.println(valor);

        //DADOS DO CONTRIBUINTE
        System.out.printf("""
        --------------- DADOS DO CONTRIBUINTE  -------------
                        Nome: %s",
                        CPF: %s",
                        UF: %s",
                        Renda anual R$: %.2f
                        Imposto a pagar R$: %.2f
        ----------------------------------------------------              
                        """,
                recolhimentoImpostoJoao.getNome(),
                recolhimentoImpostoJoao.getCpf(),
                recolhimentoImpostoJoao.getUf(),
                recolhimentoImpostoJoao.getRendaAnual(),
                recolhimentoImpostoJoao.calcularImposto()
        );
    }
}
