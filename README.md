# Aprenda Jobs Spring Batch para resolver problemas reais das empresas de processamento de dados

Este projeto tem como objetivo demonstrar a utilização do **Spring Batch** para resolver problemas reais enfrentados por empresas de processamento de dados. O Spring Batch é uma framework poderosa para processamento de grandes volumes de dados, permitindo a execução de jobs em lote de forma eficiente e confiável.

## Estrutura do Projeto

O projeto utiliza **dois bancos de dados distintos**:

1. **Banco de dados para metadados do Spring Batch**: Armazena informações sobre a execução dos jobs, como status, parâmetros, e detalhes de execução.
2. **Banco de dados de negócio**: Contém os dados específicos do domínio da aplicação.

## Configuração do Banco de Dados

O Spring Batch fornece scripts SQL para a criação das tabelas necessárias em diferentes bancos de dados. Para o **MySQL**, o script pode ser encontrado [aqui](https://github.com/spring-projects/spring-batch/tree/main/spring-batch-core/src/main/resources/org/springframework/batch/core).

### Tabelas do Spring Batch

Abaixo estão os comandos SQL para criar as tabelas necessárias para o Spring Batch no MySQL:

```sql
CREATE TABLE BATCH_JOB_INSTANCE  (
    JOB_INSTANCE_ID BIGINT  NOT NULL PRIMARY KEY ,
    VERSION BIGINT ,
    JOB_NAME VARCHAR(100) NOT NULL,
    JOB_KEY VARCHAR(32) NOT NULL,
    constraint JOB_INST_UN unique (JOB_NAME, JOB_KEY)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_EXECUTION  (
    JOB_EXECUTION_ID BIGINT  NOT NULL PRIMARY KEY ,
    VERSION BIGINT  ,
    JOB_INSTANCE_ID BIGINT NOT NULL,
    CREATE_TIME DATETIME(6) NOT NULL,
    START_TIME DATETIME(6) DEFAULT NULL ,
    END_TIME DATETIME(6) DEFAULT NULL ,
    STATUS VARCHAR(10) ,
    EXIT_CODE VARCHAR(2500) ,
    EXIT_MESSAGE VARCHAR(2500) ,
    LAST_UPDATED DATETIME(6),
    constraint JOB_INST_EXEC_FK foreign key (JOB_INSTANCE_ID)
    references BATCH_JOB_INSTANCE(JOB_INSTANCE_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_EXECUTION_PARAMS  (
    JOB_EXECUTION_ID BIGINT NOT NULL ,
    PARAMETER_NAME VARCHAR(100) NOT NULL ,
    PARAMETER_TYPE VARCHAR(100) NOT NULL ,
    PARAMETER_VALUE VARCHAR(2500) ,
    IDENTIFYING CHAR(1) NOT NULL ,
    constraint JOB_EXEC_PARAMS_FK foreign key (JOB_EXECUTION_ID)
    references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_STEP_EXECUTION  (
    STEP_EXECUTION_ID BIGINT  NOT NULL PRIMARY KEY ,
    VERSION BIGINT NOT NULL,
    STEP_NAME VARCHAR(100) NOT NULL,
    JOB_EXECUTION_ID BIGINT NOT NULL,
    CREATE_TIME DATETIME(6) NOT NULL,
    START_TIME DATETIME(6) DEFAULT NULL ,
    END_TIME DATETIME(6) DEFAULT NULL ,
    STATUS VARCHAR(10) ,
    COMMIT_COUNT BIGINT ,
    READ_COUNT BIGINT ,
    FILTER_COUNT BIGINT ,
    WRITE_COUNT BIGINT ,
    READ_SKIP_COUNT BIGINT ,
    WRITE_SKIP_COUNT BIGINT ,
    PROCESS_SKIP_COUNT BIGINT ,
    ROLLBACK_COUNT BIGINT ,
    EXIT_CODE VARCHAR(2500) ,
    EXIT_MESSAGE VARCHAR(2500) ,
    LAST_UPDATED DATETIME(6),
    constraint JOB_EXEC_STEP_FK foreign key (JOB_EXECUTION_ID)
    references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_STEP_EXECUTION_CONTEXT  (
    STEP_EXECUTION_ID BIGINT NOT NULL PRIMARY KEY,
    SHORT_CONTEXT VARCHAR(2500) NOT NULL,
    SERIALIZED_CONTEXT TEXT ,
    constraint STEP_EXEC_CTX_FK foreign key (STEP_EXECUTION_ID)
    references BATCH_STEP_EXECUTION(STEP_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_EXECUTION_CONTEXT  (
    JOB_EXECUTION_ID BIGINT NOT NULL PRIMARY KEY,
    SHORT_CONTEXT VARCHAR(2500) NOT NULL,
    SERIALIZED_CONTEXT TEXT ,
    constraint JOB_EXEC_CTX_FK foreign key (JOB_EXECUTION_ID)
    references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ENGINE=InnoDB;

CREATE TABLE BATCH_STEP_EXECUTION_SEQ (
    ID BIGINT NOT NULL,
    UNIQUE_KEY CHAR(1) NOT NULL,
    constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_EXECUTION_SEQ (
    ID BIGINT NOT NULL,
    UNIQUE_KEY CHAR(1) NOT NULL,
    constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
) ENGINE=InnoDB;

CREATE TABLE BATCH_JOB_SEQ (
    ID BIGINT NOT NULL,
    UNIQUE_KEY CHAR(1) NOT NULL,
    constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
) ENGINE=InnoDB;

-- Inserts simplificados
INSERT INTO BATCH_STEP_EXECUTION_SEQ (ID, UNIQUE_KEY) VALUES (0, '0');
INSERT INTO BATCH_JOB_EXECUTION_SEQ (ID, UNIQUE_KEY) VALUES (0, '0');
INSERT INTO BATCH_JOB_SEQ (ID, UNIQUE_KEY) VALUES (0, '0');
