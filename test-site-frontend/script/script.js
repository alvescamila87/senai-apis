/** LOGIN */

/** LOGIN */ // Validação visual do formulário
document
  .getElementById("loginForm")
  .addEventListener("submit", function (event) {
    const form = this;
    if (!form.checkValidity()) {
      event.preventDefault();
      event.stopPropagation();
    }
    form.classList.add("was-validated");
  });

/** LOGIN */ // Modo escuro
function toggleDarkMode() {
  const html = document.documentElement;
  const current = html.getAttribute("data-bs-theme");
  html.setAttribute("data-bs-theme", current === "dark" ? "light" : "dark");
}

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

/** CADASTRO */

function toggleTheme() {
  const html = document.documentElement;
  const currentTheme = html.getAttribute("data-bs-theme");
  const newTheme = currentTheme === "dark" ? "light" : "dark";
  html.setAttribute("data-bs-theme", newTheme);

  // Alterna ícone
  const icon = document.querySelector(".theme-toggle-btn i");
  icon.classList.toggle("bi-moon-stars-fill");
  icon.classList.toggle("bi-brightness-high-fill");
}
