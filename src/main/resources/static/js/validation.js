document.getElementById('btnCadastrar').addEventListener('click', function() {
    if (validarFormulario()) {
      document.getElementById('formFilme').submit();
    }
  });

  function validarFormulario() {
    // Validar Título
    const titulo = document.getElementById('titulo').value;
    if (titulo.trim() === '') {
      alert('O título não pode estar vazio.');
      return false;
    }

    // Validar Sinopse
    const sinopse = document.getElementById('sinopse').value;
    if (sinopse.trim() === '') {
      alert('A sinopse não pode estar vazia.');
      return false;
    }

    // Validar Gênero
    const genero = document.getElementById('genero').value;
    if (genero === '') {
      alert('Por favor, selecione um gênero.');
      return false;
    }

    // Validar Ano de Lançamento
    const anoLancamento = document.getElementById('anoLancamento').value;
    if (anoLancamento === '' || anoLancamento < 1895) {
      alert('O ano de lançamento não pode ser menor que 1895.');
      return false;
    }

    // Se todas as validações passarem
    return true;
  }