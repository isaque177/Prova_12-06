// Carrega os dados ao carregar a página
document.addEventListener('DOMContentLoaded', function() {
    carregarLivros();
    carregarBibliotecarios();
});

// API GET - Carregar livros
function carregarLivros() {
    fetch('http://localhost:8080/api/livros', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => response.json())
    .then(data => {
        addLinhaLivros(data);
    })
    .catch(error => {
        console.log('Erro ao carregar livros:', error);
    });
}

// Carregar bibliotecários para o select
function carregarBibliotecarios() {
    fetch('http://localhost:8080/api/bibliotecario', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => response.json())
    .then(data => {
        preencherSelectBibliotecarios(data);
    })
    .catch(error => {
        console.log('Erro ao carregar bibliotecários:', error);
    });
}

// Preencher select de bibliotecários
function preencherSelectBibliotecarios(bibliotecarios) {
    const select = document.getElementById('bibliotecario');
    select.innerHTML = '<option value="">Selecione um bibliotecário</option>';
    
    bibliotecarios.forEach(bib => {
        const option = document.createElement('option');
        option.value = bib.id;
        option.textContent = bib.nome;
        select.appendChild(option);
    });
}

// Adicionar linhas na tabela de livros
function addLinhaLivros(dadosAPI) {
    const tabela = document.getElementById('tabelaCorpo');
    tabela.innerHTML = ''; // Limpa a tabela antes de adicionar
    
    dadosAPI.forEach(element => {   
        const linha = document.createElement('tr');
        linha.innerHTML = `
            <td class="px-4 py-2">${element.id}</td>
            <td class="px-4 py-2">${element.titulo}</td>
            <td class="px-4 py-2">${element.genero}</td>
            <td class="px-4 py-2">${element.bibliotecario ? element.bibliotecario.nome : 'Não atribuído'}</td>
            <td class="px-4 py-2">${element.autor}</td>
            <td class="px-4 py-2">${element.status || 'DISPONIVEL'}</td>
            <td class="px-4 py-2">
                <button class="bg-red-500 text-white px-2 py-1 rounded hover:bg-red-600" 
                        onclick="remover(${element.id})">Remover</button>
            </td>
        `;
        tabela.appendChild(linha);
    });
}

// Cadastrar novo livro
function cadastrar() {
    event.preventDefault();

    const titulo = document.getElementById('titulo').value;
    const genero = document.getElementById('genero').value;
    const bibliotecarioId = document.getElementById('bibliotecario').value;
    const autor = document.getElementById('autor').value;
    const status = document.getElementById('status').value || 'DISPONIVEL';

    if (titulo && genero && autor && bibliotecarioId) {
        const livroData = {
            titulo: titulo.trim(),
            genero: genero.trim(),
            autor: autor.trim(),
            status: status,
            dataCadastro: new Date().toISOString().split('T')[0],
            bibliotecario: {
                id: parseInt(bibliotecarioId)
            }
        };

        // API POST  
        fetch('http://localhost:8080/api/livros', { 
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(livroData)
        })
        .then(response => response.json())
        .then(data => {
            console.log("Resposta da API:", data);
            // Limpar campos
            document.getElementById('titulo').value = "";
            document.getElementById('genero').value = "";
            document.getElementById('bibliotecario').value = "";
            document.getElementById('autor').value = "";
            document.getElementById('status').value = "DISPONIVEL";
            
            // Recarregar a lista
            carregarLivros();
            
            Swal.fire({
                icon: 'success',
                title: 'Sucesso!',
                text: 'Livro cadastrado com sucesso'
            });
        })
        .catch(error => {
            console.error("Erro ao enviar dados:", error);
            Swal.fire({
                icon: 'error',
                title: 'Erro!',
                text: 'Erro ao cadastrar livro'
            });
        });
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Erro!',
            text: 'Preencha todos os campos obrigatórios'
        });
    }
}

// Remover livro
function remover(id) {
    Swal.fire({
        icon: 'question',
        title: 'Você tem certeza?',
        text: 'Esta ação não pode ser desfeita!',
        showCancelButton: true,
        confirmButtonText: 'Sim, remover!',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch(`http://localhost:8080/api/livros/${id}`, {
                method: 'DELETE'
            })
            .then(() => {
                carregarLivros();
                Swal.fire('Removido!', 'Livro removido com sucesso.', 'success');
            })
            .catch(error => {
                console.error('Erro ao remover:', error);
                Swal.fire('Erro!', 'Erro ao remover livro.', 'error');
            });
        }
    });
}