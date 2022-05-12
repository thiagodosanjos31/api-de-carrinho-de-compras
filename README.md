## Dependências
Necessário rodar um mongo local (pode ser com o docker)
```
docker run -d -p 27017:27017 --name mongo mongo:3.4
````

## Iniciando a aplicação

### Executar os seguites comandos na raíz do projeto:
```
./gradlew bootjar

docker build -t cart .

docker run -d --name cart -p 8080:8080 app-cart
```
Pronto! Você terá uma aplicação rodando na porta 8080 do seu computador.

## Exemplos de requisição para api:

Cria um ID de carrinho
```
curl --location --request GET 'http://localhost:8080/cart/create'
```

Retorna as informações do carrinho
```
curl --location --request GET 'http://localhost:8080/cart/627b096c70658a62a9dfb13b'
```

Adiciona um produto ao carrinho
```
curl --location --request PUT 'http://localhost:8080/cart/627b096c70658a62a9dfb13b' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": "6d47d1b0-036e-469c-bf3e-ab1a58f185d8",
"quantity": 2
}'
```

Remove um produto do carrinho
```
curl --location --request DELETE 'http://localhost:8080/cart/{id-do-carrinho}/{id-do-produto}' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": "6d47d1b0-036e-469c-bf3e-ab1a58f185d8",
"quantity": 1
}'
```

Atualiza a quantidade do carrinho
```
curl --location --request PATCH 'http://localhost:8080/cart/{id-do-carrinho}/{id-do-produto}/{quantidade}' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": "6d47d1b0-036e-469c-bf3e-ab1a58f185d8",
"quantity": 1
}'
```

Adiciona um cupom ao carrinho
```
curl --location --request PUT 'http://localhost:8080/cart/{id-do-carrinho}/coupon' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": "5ee74f6b-f507-4e90-806f-79d03b4c06f0",
"name": "MENOS10"
}'
```
## Mock

https://run.mocky.io/v3/

## Produtos mockados:

Jarra:
* ID: cdd43cc9-0066-4e76-9a03-0313d1624c27

Escova de cabelo:
* ID: 6d47d1b0-036e-469c-bf3e-ab1a58f185d8

## Cupom mockado

MENOS10
* ID: 5ee74f6b-f507-4e90-806f-79d03b4c06f0