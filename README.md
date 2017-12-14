# treinamento

1. Criar conta no github.
2. Instalar o GitHub para Windows: https://desktop.github.com/
3. Baixar e instalar o Java 8: http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html
4. Baixar o Eclipse: http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygenr
5. Fazer o fork do projeto https://github.com/feragost/treinamento e sem seguida fazer o clone para máquina de vocês.
6. Abrir o Eclipse e importar o projeto maven localizado no local que foi feito o clone.
7. Rodar o HelloWorldWikipedia

EXERCÍCIO AUTOMATION PRACTICE
1. Selecione SUMMER DRESSES a partir do item DRESSES do menu principal.
2. Clique em LIST para obter uma visualização dos itens em forma de lista.
3. Clique em MORE para o terceiro item da lista.
4. Selecione a quantidade 3 a partir do botão +.
5. Selecione o tamanho M na combo.
6. Selecione a cor VERDE.
7. Clique em ADD TO CART.
8. Imprima o preço total da compra.
9. Clique em CONTINUE TO SHOPPING.
10. Clique em T-SHIRTS no meu principal.
11. Clique em ADD TO CART para o único produto da lista.
12. Clique em PROCEED TO CHECKOUT
13. Imprima o valor total da compra.
14. Clique em CONTINUE TO SHOPPING.
15. Imprima os valores das hints dos dois produtos em VIEWED PRODUCTS

Adiantar pageObjects
 - Mapear os componentes de cada página em pageObjects.
 - Fazer scripts que passem por estes novos componentes.
 - Pensar em reduzir o retrabalho. (fluxos para passos comuns no sistema)

Exemplo de sincronia pelo carregamento de uma nova página:
- WebDriverWait wait = new WebDriverWait(this.wd, tempoMaximo);
- ExpectedCondition<Boolean> expected = new ExpectedCondition<Boolean>() {
-   @Override
-   public Boolean apply(WebDriver w) {
- 	return w.getCurrentUrl().startsWith(url);
-   }
- };
- wait.until(expected);
 
REGRAS
- A ordem do produto que eu adiciono para comparação deve ser a mesma ordem que aparece na página de comparação.
- Quando um item está selecionado para comparação o link ADD TO COMPARE deve possuir o símbolo "-".
- O botão COMPARE deve apresentar a quantidade de itens selecionados para serem comparados.
- Ao selecionar um price range, a lista de produtos apresentados devem possuir o preço dentro do range.
- Ao selecionar uma ordenação, a lista de produtos apresentados devem estar ordenado de acordo.
- Ao selecionar o item em estoque, a lista de produtos apresentados devem possuir somente os itens em estoque.
- Os últimos dois produtos visualizados devem ser listados por ordem inversa de visita em VIEWED PRODUCTS
- As cores disponíveis no catálogo devem ser as cores que aparecem nos itens presentes na lista.
