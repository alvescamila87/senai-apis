// Adicione um ouvinte de eventos aos botões de exclusão

//EXCLUSÃO DO USUÁRIO - LISTA
document.querySelectorAll('.delete-user').forEach(function(button) {
    button.addEventListener('click',
    function() {
        if (confirm('Are you confirm?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const userId = this.dataset.usuarioId;

            // Realize a chamada AJAX para excluir o recurso
            fetch(`crud/usuario/${userId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    // A exclusão foi bem-sucedida
                    console.log('User has been deleted succesfully.');

                    // Remove a linha da tabela após a exclusão
                    row.remove();
                } else {
                    // A solicitação DELETE falhou
                    console.error('Error to delete user.');
                    alert('Error to delete user');
                }
            })
            .catch(error => {
                // Lidar com erros de rede ou outros erros
                console.error('Error from server:', error);
                alert('Error from server:' + error);
            });
        }
    });
});

//EXCLUSÃO DO PRODUTO - LISTA
document.querySelectorAll('.delete-product').forEach(function(button) {
    button.addEventListener('click',
    function() {
        if (confirm('Are you confirm?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const produtoId = this.dataset.productId;

            // Realize a chamada AJAX para excluir o recurso
            fetch(`crud/produto/${produtoId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    // A exclusão foi bem-sucedida
                    console.log('Product has been deleted succesfully.');

                    // Remove a linha da tabela após a exclusão
                    row.remove();
                } else {
                    // A solicitação DELETE falhou
                    console.error('Error to delete product.');
                    alert('Error to delete product');
                }
            })
            .catch(error => {
                // Lidar com erros de rede ou outros erros
                console.error('Error from server:', error);
                alert('Error from server:' + error);
            });
        }
    });
});

