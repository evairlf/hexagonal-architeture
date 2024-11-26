# Projeto para aprender arquitetura hexagonal

![Texto alternativo](https://othercode.io/user/pages/02.blog/hexagonal-architecture/hexagonal-architecture-layers.webp)


A arquitetura hexagonal, também conhecida como ports and adapters é um modelo de design de softaware que busca isolar o nucleo da aplicacão de interações externas
como acesso ao banco de dados, outras apis e o que o projeto precisar, a principal ideia é garantir que o nucleo do sistema o core(regra de negócios) 
nao dependa diretamente de nenhum dos detalhes da aplicacao externa, facilitando a troca de bancos de dados por exemplo, também facilitando testes e a sua manutenção,
por ser um sistema mais complexo pode integrar tudo do melhor de outros modelos como mvc e ddd.

# Principais conceitos:

### Core da aplicação:
-  é onde fica a regra de negocios, a parte mais importante da aplicação independente de frameworks e tecnologias, basicamente dentro dela
  não são usados annotations e nada que dependa de um framework, é tudo feito cru na mão, possui as portas de entrada(input) as portas de saida(output)
  que são os acessos do core ao mundo externo também as entidades/dominios, algumas aplicações sao mantidas no padrão de um arquivo por caso de uso(use case)
  ou por contexto de uso(use context).

### Portas
- As portas de entrada e de saida que ficam tanto junto da pasta application onde fica core da aplicacão tambem fica junto dos adapters para que possam ser usadas para
  permitir que o nucleo interaja com o ambiente externo.

### Adapters
- Os adaptadores tem a funcao de fazer a implementacao concreta que basicamente traduz e adapta as tecnologias como bancos de dados, messageria e outros frameworks
  para que possam ser usadas convertendo as portas de entrada e de saida em um formato que o nucleo entende.

  obs: não se pode esquecer que como nao tem como fazer anotações de @Bean e @Component direto no core é usado uma pasta config onde la ficam os mapeamentos tanto dos
  use cases ou use contexts.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

Docker:
```
https://www.docker.com/products/docker-desktop/
```
Wiremock
```
https://wiremock.org/docs/download-and-installation/
```
KafkaLytic - plugin do intelij
```
https://plugins.jetbrains.com/plugin/11946-kafkalytic
```

### 🔧 Instalação

Uma série de exemplos passo-a-passo que informam o que você deve executar para ter um ambiente de desenvolvimento em execução.

Após baixar o docker os pre requisitos:

- vá na pasta docker-local do seu projeto e use o comando

```
docker-compose up
```
isso irá baixar todas os conteiners que estão configurados no arquivo docker-compose.

- Vá onde voce baixou o wiremock e use o seguinte comando

```
java -jar wiremock-standalone-3.9.2 port=8082
```
surgirão duas pastas, somente a mappings é importante no momento para nós
dentro dela coloque os 2 proximos jsons

address.json
```
{
    "request": {
        "method": "GET",
        "url": "/addresses/38400000"
    },
    "response": {
        "status": 200,
        "headers": {
            "Content-Type": "application/json"
        },
        "jsonBody": {
            "street": "Rua Hexagonal",
            "city": "Uberlândia",
            "state": "Minas Gerais"
        }
    }
}
```
Address_2.json
```
{
    "request": {
        "method": "GET",
        "url": "/addresses/38400001"
    },
    "response": {
        "status": 200,
        "headers": {
            "Content-Type": "application/json"
        },
        "jsonBody": {
            "street": "Rua das Flores",
            "city": "São Paulo",
            "state": "São Paulo"
        }
    }
}
```
Abra o plugin kafkalytic
Em Host coloque o seguinte:
```
localhost:9092
```
Em cluster coloque:
```
Hexagonal
```
irá conectar, então em tópicos adcione um novo topico chamado:
```
tp-cpf-validation
```

## ⚙️ Estrutura de pastas de un projeto hexagonal

```
src/
├── core/                          # Núcleo da aplicação (regra de negócio)
│   ├── domain/                    # Entidades e modelos de domínio
│   │   ├── Pedido.java
│   │   ├── Cliente.java
│   ├── usecase/                   # Casos de uso ou serviços de domínio
│   │   ├── CriarPedido.java
│   │   ├── CancelarPedido.java
│   ├── port/                      # Portas (interfaces)
│   │   ├── input/                 # Portas de entrada (como APIs)
│   │   │   ├── PedidoInputPort.java
│   │   │   ├── ClienteInputPort.java
│   │   ├── output/                # Portas de saída (como banco de dados)
│   │   │   ├── PedidoOutputPort.java
│   │   │   ├── ClienteOutputPort.java
├── adapters/                      # Adaptadores (integração com o mundo externo)
│   ├── inbound/                   # Adaptadores de entrada (interface de usuário, API, etc.)
│   │   ├── rest/                  # Adaptadores para endpoints REST
│   │   │   ├── PedidoController.java
│   │   │   ├── ClienteController.java
│   ├── outbound/                  # Adaptadores de saída (banco de dados, serviços externos)
│   │   ├── database/              # Implementações relacionadas ao banco de dados
│   │   │   ├── PedidoRepository.java
│   │   │   ├── ClienteRepository.java
│   │   ├── external/              # Implementações para serviços externos (por exemplo, email, pagamentos)
│   │   │   ├── EmailService.java
│   │   │   ├── PagamentoService.java
├── config/                         # Configurações gerais da aplicação
│   ├── AppConfig.java
│   ├── DatabaseConfig.java
└── main/                           # Arquivo principal ou de inicialização da aplicação
    ├── Application.java
```

by Evairlf
