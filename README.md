# generalbinarytree

## 1. Estrutura de árvore binária

Você deve construir uma estrutura de árvore binária em Java. Sua estrutura deve ser genérica, ou seja, capaz de armazenar objetos de qualquer tipo. Além disso, sua estrutura deve ter os seguintes métodos:

* inserir um objeto na árvore;
* buscar por um objeto na árvore;
* remover um objeto da árvore;
* caminhar em ordem;
* caminhar em nível;
* obter a altura da árvore;
* obter a quantidade de elementos da árvore;
* encontrar menor e maior elemento da árvore;
* obter pior caso de busca;

## 2 .Arquivos de entrada

Seu programa deverá receber como entrada um arquivo texto com o seguinte formato:

* A primeira linha terá apenas um número inteiro que indicará a quantidade de registros de aluno que há no arquivo;
* Da segunda linha em diante, cada linha trará a matrícula, o nome e a nota de um aluno, nesta ordem, separado por ponto-e-vírgula(;)

## 3. Leitura do arquivo e geração da árvore em memória

Seu programa deve ler o arquivo, gerando, em memória, uma árvore binária.

## 4. Execução do programa

Após a leitura e construção da árvore em memória seu programa deve exibir um menu dando as seguintes opções:

* Exibir estatísticas – Deve exibir a quantidade total de elementos, a altura da árvore, o maior e o menor elemento e o pior caso de busca.
* Efetuar busca por matrícula: o programa solicitará a matrícula do aluno, buscará o aluno e imprimirá na tela os dados do aluno (se encontrado) e a quantidade de elementos que foram percorridos até encontrá-lo.  
* Excluir por matrícula: o programa solicitará uma matrícula e excluíra o aluno, imprimindo na tela os dados do aluno excluído ou uma mensagem falando que não o encontrou.
* Incluir aluno: o programa solicitará matrícula, nome e nota do aluno e o incluirá na árvore.
Sair: o programa deve percorrer a árvore usando caminhamento "em ordem" e gerar um arquivo em que cada linha apresentará a matrícula, o nome e a nota de um aluno, sempre separados por ;. 


# Entrega

* O trabalho pode ser feito em duplas.
* Apenas um componente da dupla deve postar o trabalho.
* Deve haver um comentário no início da classe "ArvoreBinaria" contendo os nome dos autores.
* Valor desta entrega: 8 pontos
