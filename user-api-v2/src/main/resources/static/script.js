//
//  let selectedUserId = null;
//  const BASE_PATH = "usuario";
//
//  const confirmDeleteModal = document.getElementById('confirmDeleteModal');
//  confirmDeleteModal.addEventListener('show.bs.modal', function (event) {
//    const button = event.relatedTarget;
//    selectedUserId = this.dataset.user-id;
//    const userName = this.dataset.user-name;
//
//    const namePlaceholder = document.getElementById('userNamePlaceholder');
//    namePlaceholder.textContent = userName;
//  });
//
//  document.getElementById('confirmDeleteBtn').addEventListener('click', function () {
//    if (!selectedUserId) return;
//
//    fetch(`${BASE_PATH}/${selectedUserId}`, {
//      method: 'DELETE',
//      headers: {
//           'Content-Type': 'application/json'
//      },
//    })
//    .then(response => {
//      if (response.ok) {
//        const modal = bootstrap.Modal.getInstance(confirmDeleteModal);
//        modal.hide();
//
//        const row = document.querySelector(`[data-user-id="${selectedUserId}"]`).closest('tr');
//        row.remove();
//
//      } else {
//        alert("Error to delete user.");
//      }
//    })
//    .catch(err => {
//      console.error(err);
//      alert("Error fetch server.");
//    });
//  });
//


// Adicione um ouvinte de eventos aos botões de exclusão
document.document.getElementById('#confirmDeleteBtn').forEach(function(button) {
    button.addEventListener('click',
    function() {
        if (confirm('Confirma a exclusão?')) {

            const row = this.closest('tr'); // Obtém a linha atual da tabela

            const usuarioId = this.dataset.usuarioId;

            // Realize a chamada AJAX para excluir o recurso
            fetch(`/usuario/${usuarioId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    // A exclusão foi bem-sucedida
                    console.log('Usuário excluído com sucesso.');

                    // Remove a linha da tabela após a exclusão
                    row.remove();
                } else {
                    // A solicitação DELETE falhou
                    console.error('Erro ao excluir usuário.');
                    alert('Erro ao excluir usuário');
                }
            })
            .catch(error => {
                // Lidar com erros de rede ou outros erros
                console.error('Erro de rede:', error);
                alert('Erro de rede:' + error);
            });
        }
    });
});
