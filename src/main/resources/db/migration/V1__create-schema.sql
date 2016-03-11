-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- TB_ACCOUNT Table Create SQL
CREATE TABLE TB_ACCOUNT
(
    id           LONG            NOT NULL, 
    username     VARCHAR2(20)    NOT NULL, 
    password     VARCHAR2(20)    NOT NULL, 
    rgstDtm      DATE            NULL, 
    rgstId       LONG            NULL, 
    updtDtm      DATE            NULL, 
    updtId       LONG            NULL, 
    adminYn      CHAR(1)         NULL, 
    companyId    LONG            NOT NULL, 
    CONSTRAINT TB_ACCOUNT_PK PRIMARY KEY (id)
)

-- TB_COMPANY Table Create SQL
CREATE TABLE TB_COMPANY
(
    companyId      LONG            NOT NULL, 
    companyName    VARCHAR2(20)    NULL, 
    CONSTRAINT TB_COMPANY_PK PRIMARY KEY (companyId)
)


ALTER TABLE TB_COMPANY
    ADD CONSTRAINT FK_TB_COMPANY_companyId_TB_ACC FOREIGN KEY (companyId)
        REFERENCES TB_ACCOUNT (companyId)



