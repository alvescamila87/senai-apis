<script>
  let selectedUserId = null;

  const confirmDeleteModal = document.getElementById('confirmDeleteModal');
  confirmDeleteModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;
    selectedUserId = button.getAttribute('data-user-id');
    const userName = button.getAttribute('data-user-name');

    const namePlaceholder = document.getElementById('userNamePlaceholder');
    namePlaceholder.textContent = userName;
  });

  document.getElementById('confirmDeleteBtn').addEventListener('click', function () {
    if (!selectedUserId) return;

    fetch(`/deleteuser/${selectedUserId}`, {
      method: 'DELETE',
      headers: {
        'X-Requested-With': 'XMLHttpRequest'
      }
    })
    .then(response => {
      if (response.ok) {
        const modal = bootstrap.Modal.getInstance(confirmDeleteModal);
        modal.hide();

        const row = document.querySelector(`[data-user-id="${selectedUserId}"]`).closest('tr');
        row.remove();

      } else {
        alert("Erro ao deletar o usuário.");
      }
    })
    .catch(err => {
      console.error(err);
      alert("Erro na comunicação com o servidor.");
    });
  });
</script>
