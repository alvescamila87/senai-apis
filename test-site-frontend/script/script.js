// validação de senha
const form = document.getElementById("form_cadastro");

form.addEventListener("submit", function (event) {
  const senha = document.getElementById("conta_senha").value;
  const confirmarSenha = document.getElementById("conta_confirmar_senha").value;

  if (senha !== confirmarSenha) {
    event.preventDefault();
    alert("As senhas são diferentes!");
  }
});
