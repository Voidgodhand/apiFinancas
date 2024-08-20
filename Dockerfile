# Baixando a imagem do JDK para executar o projeto
FROM openjdk:18

# Definindo a pasta de trabalho dentro do contêiner
WORKDIR /app

# Copiando todos os arquivos para esta pasta de trabalho
COPY . /app

# Baixando o script wait-for-it
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Executando o comando para publicar o projeto no contêiner
RUN ./mvnw clean package

# Definir a porta para execução do projeto
EXPOSE 8083

# Comando para rodar o projeto que foi publicado, esperando o MySQL estar pronto
CMD ["./wait-for-it.sh", "mysql8-server:3306", "--", "java", "-jar", "target/apiFinancas-0.0.1-SNAPSHOT.jar"]