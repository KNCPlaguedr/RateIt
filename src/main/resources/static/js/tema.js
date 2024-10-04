// Função para obter o valor de um cookie
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

// Função para carregar o tema do cookie quando a página for aberta
function loadTheme() {
    const savedTheme = getCookie('theme');
    if (savedTheme) {
        document.body.classList.add(savedTheme);
    } else {
        // Se não houver cookie, aplica o tema claro por padrão
        document.body.classList.add('light');
    }
}

// Chama a função para carregar o tema quando a página é carregada
window.onload = loadTheme;


