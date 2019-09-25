package produto;

/**
 * Classe que representa um repositorio de produtos usando arrays como estrutura
 * sobrejacente. Alguns metodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercicio, o erro serah
 * representado por uma RuntimeException que nao precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que voce deve utilizar a estrutura de dados array e nao
 * implementacoes de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoNaoPerecivelArray {
	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private ProdutoNaoPerecivel[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial eh -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoNaoPerecivelArray(int size) {
		super();
		this.produtos = new ProdutoNaoPerecivel[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse metodo eh util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse metodo.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int retorno = -1;
		for(int i = 0; i < produtos.length; i ++) {
			if (produtos[i].getCodigo() == codigo) {
				retorno = i;
			}
		}
		return retorno;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		boolean retorno = false;
		for(int i = 0; i < produtos.length; i ++) {
			if (produtos[i].getCodigo() == codigo) {
				retorno = true;
			}
		}
		return retorno;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(ProdutoNaoPerecivel produto) {
		if (this.index != (produtos.length - 1)){
			this.index = index + 1;
			produtos[index] = produto;
		}
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o codigo do produto sera
	 * utilizado.
	 * @throws Exception 
	 */
	public void atualizar(ProdutoNaoPerecivel produto){
		int indexProduto = procurarIndice(produto.getCodigo());
		
		if (indexProduto == -1) {
			throw new RuntimeException("Produto nao existe!");
		} else {
			produtos[indexProduto] = produto;
		}
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrario. Note que a remocao NAO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 * @throws Exception 
	 */
	public void remover(int codigo) {
		int indexProduto = procurarIndice(codigo);
		
		if (indexProduto == -1) {
			throw new RuntimeException("Produto nao existe!");
		} else {
			for (int i = indexProduto; i < produtos.length; i++) {
				if (i == produtos.length - 1) {
					produtos[i] = null;
					break;
				}
				produtos[i] = produtos[i + 1];
			}
		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception 
	 */
	public ProdutoNaoPerecivel procurar(int codigo){
		int indexProduto = procurarIndice(codigo);
		
		if (indexProduto == -1) {
			throw new RuntimeException("Produto nao existe!");
		} else {
			return produtos[indexProduto];
		}
	}

}
