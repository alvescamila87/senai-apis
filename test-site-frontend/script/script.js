/** LOGIN */

/** LOGIN */

/** LOGIN */ // Validação visual do formulário
document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("loginForm");

  if (!form) {
    console.error("Formulário de login não encontrado");
    return;
  }

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const email = document.getElementById("login_email").value;
    const senha = document.getElementById("login_senha").value;

    // Validação visual
    if (!form.checkValidity()) {
      form.classList.add("was-validated");
      return;
    }

    // Validação de credenciais
    if (email === "admin@admin.com" && senha === "senha") {
      window.location.href = "../pages/index.html";
    } else {
      alert("Email ou senha inválidos!");
    }
  });
});

/** LOGIN */ // validação de senha
const form = document.getElementById("form_cadastro");

form.addEventListener("submit", function (event) {
  const senha = document.getElementById("conta_senha").value;
  const confirmarSenha = document.getElementById("conta_confirmar_senha").value;

  if (senha !== confirmarSenha) {
    event.preventDefault();
    alert("As senhas são diferentes!");
  }
});
