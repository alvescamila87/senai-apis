package org.example;

public class Debug06MateriaisConstrucao {
    public static void main(String[] args) {

        //MATERIAL 01
        Ex6 cimento = new Ex6(
                "Cimento",
                " Saco de cimento de 50kg para uso geral na construção.",
                45.00,
                50.00,
                500
                );

        System.out.printf("""
                ----------- MATERIAL CONSTRUÇÃO -----------
                Nome: %s,
                Descrição: %s,
                Preço: R$ %.2f,
                Peso: %s,
                Estoque: %s,
                -------------------------------------------
                """,
                cimento.getNome(),
                cimento.getDescricao(),
                cimento.getPreco(),
                cimento.getPeso(),
                cimento.getEstoque()
        );

        //Adicionar ao estoque
        cimento.adicionarEstoque(50);
        cimento.adicionarEstoque();
        System.out.printf("""
                ----------- MATERIAL CONSTRUÇÃO -----------
                Nome: %s,
                Descrição: %s,
                Preço: R$ %.2f,
                Peso: %s,
                Estoque: %s,
                -------------------------------------------
                """,
                cimento.getNome(),
                cimento.getDescricao(),
                cimento.getPreco(),
                cimento.getPeso(),
                cimento.getEstoque()
        );

        //Venda do produto ao estoque
        cimento.venderProduto(50);
        //cimento.venderProduto(502);
        System.out.printf("""
                ----------- MATERIAL CONSTRUÇÃO -----------
                Nome: %s,
                Descrição: %s,
                Preço: R$ %.2f,
                Peso: %s,
                Estoque: %s,
                -------------------------------------------
                """,
                cimento.getNome(),
                cimento.getDescricao(),
                cimento.getPreco(),
                cimento.getPeso(),
                cimento.getEstoque()
        );

        //Promoção do produto ao estoque
        cimento.aplicarPromocao(50);
        System.out.printf("""
                ----------- MATERIAL CONSTRUÇÃO -----------
                Nome: %s,
                Descrição: %s,
                Preço: R$ %.2f,
                Peso: %s,
                Estoque: %s,
                -------------------------------------------
                """,
                cimento.getNome(),
                cimento.getDescricao(),
                cimento.getPreco(),
                cimento.getPeso(),
                cimento.getEstoque()
        );
    }
}
