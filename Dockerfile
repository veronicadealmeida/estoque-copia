# Fase de Build
FROM ubuntu:latest AS build

# Atualiza e instala OpenJDK e Maven
RUN apt-get update && apt-get install openjdk-21-jdk maven -y

# Copia o código-fonte da aplicação
COPY . .

# Executa o Maven para construir o projeto e gerar o .jar
RUN mvn clean install

# Fase de Execução
FROM openjdk:21-jdk-slim

# Expõe a porta 8081 (ou a porta que sua aplicação usa)
EXPOSE 8081

# Copia o arquivo .jar gerado na fase de build para a fase de execução
COPY --from=build /target/estoque-0.0.1-SNAPSHOT.jar /app/estoque.jar

# Comando para iniciar a aplicação
ENTRYPOINT [ "java", "-jar", "/app/estoque.jar" ]