### Instalação

Para rodar os testes é necessário ter o Maven instalado e criar suas variáveis de dependência

 Tutorial para Windows, Linux e Mac [aqui.](https://www.baeldung.com/install-maven-on-windows-linux-mac)

### Para rodar o testes pelo prompt de comando do Windows:

Abrir o Prompt de Comando

	Pesquisar -> cmd
	
Vá até o diretório do arquivo 

	cd .../BairesTestes/
	
Dgite o comando + Enter

	mvn test

 Tutorial completo [aqui.](https://toolsqa.com/selenium-cucumber-framework/run-cucumber-test-from-command-line-terminal/)


### Teste de métodos de pesquisa disponíveis em: https://jobs.bairesdev.com/

Considerando que temos dois métodos para encontrar ofertas de emprego:

	Clicar na caixa de pesquisa, aguardar a lista suspensa e clicar em um título de emprego/palavra-chave
	
	Digitar manualmente o termo de pesquisa na caixa de pesquisa e, em seguida, pressionar Enter

Deduzi que eles retornariam os mesmos resultados, por exemplo, clicando no item suspenso "QA/Testing" ou usando "QA" como termo de pesquisa. 
Mas o segundo método mostra menos ofertas de emprego do que o primeiro. 

E ao combinar os dois métodos, fazer a pesquisa primeiro e depois clicar no mesmo termo mostrado no item suspenso, obteremos ainda outro resultado.

Uma versão estática do relatório pode ser encontrados na raiz desse repositório como Cucumber Reports.pdf

### Framework: JUnit5 + Cucumber + Selenium WebDriver + Maven
