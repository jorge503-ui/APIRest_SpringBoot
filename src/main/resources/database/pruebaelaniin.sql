--------------------------------------------------------
-- Archivo creado  - domingo-abril-12-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "PRUEBAELANIIN"."PRODUCTO" 
   (	"ID" NUMBER(9,0), 
	"SKU" VARCHAR2(100 BYTE), 
	"NOMBRE" VARCHAR2(150 BYTE), 
	"CANTIDAD" NUMBER(*,0), 
	"PRECIO" NUMBER(14,2), 
	"DESCRIPCION" VARCHAR2(300 BYTE), 
	"IMAGEN" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "PRUEBAELANIIN"."USUARIO" 
   (	"ID" NUMBER(9,0), 
	"NOMBRE" VARCHAR2(150 BYTE), 
	"USERNAME" VARCHAR2(50 BYTE), 
	"FECHANACIMIENTO" TIMESTAMP (6), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"TELEFONO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PRODUCTO
--------------------------------------------------------

   CREATE SEQUENCE  "PRUEBAELANIIN"."SEQ_PRODUCTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_USUARIO
--------------------------------------------------------

   CREATE SEQUENCE  "PRUEBAELANIIN"."SEQ_USUARIO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
REM INSERTING into PRUEBAELANIIN.PRODUCTO
SET DEFINE OFF;
Insert into PRUEBAELANIIN.PRODUCTO (ID,SKU,NOMBRE,CANTIDAD,PRECIO,DESCRIPCION,IMAGEN) values (1,'12-0','MOUSE LC55',0,25.36,'Mouse inalambrico','imagen/1523566.jpg');
Insert into PRUEBAELANIIN.PRODUCTO (ID,SKU,NOMBRE,CANTIDAD,PRECIO,DESCRIPCION,IMAGEN) values (2,'12-2','TECLADO MC56',56,50.36,'Teclado inalambrico','imagen/15235jh64.jpg');
REM INSERTING into PRUEBAELANIIN.USUARIO
SET DEFINE OFF;
Insert into PRUEBAELANIIN.USUARIO (ID,NOMBRE,USERNAME,FECHANACIMIENTO,EMAIL,PASSWORD,TELEFONO) values (1,'Jorge Pe�a','jpena',to_timestamp('22/05/95 12:00:00.000000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),'jorge.p.391@gmail.com','$2a$10$8jfDORN4XBTJnSz9vzJMH.O1w7djWQ2PaXJEypTiH6nyfKn8BP8Lu','70464553');
Insert into PRUEBAELANIIN.USUARIO (ID,NOMBRE,USERNAME,FECHANACIMIENTO,EMAIL,PASSWORD,TELEFONO) values (2,'Yovani Vivas','yvivas',to_timestamp('22/05/95 12:00:00.000000000 AM','DD/MM/RR HH12:MI:SSXFF AM'),'yovani.v.391@gmail.com','$2a$10$IvFz3E67hTOAiRKYH/KlKe1vwbCL4gK3QZsWgxLXXeB/VTR3tBOC.',null);
--------------------------------------------------------
--  DDL for Index EMPLOYEE_UNQ_IDENTI
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRUEBAELANIIN"."EMPLOYEE_UNQ_IDENTI" ON "PRUEBAELANIIN"."USUARIO" ("EMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USUARIO_UNQ_IDENTI
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRUEBAELANIIN"."USUARIO_UNQ_IDENTI" ON "PRUEBAELANIIN"."USUARIO" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USUARIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRUEBAELANIIN"."USUARIO_PK" ON "PRUEBAELANIIN"."USUARIO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRODCUTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRUEBAELANIIN"."PRODCUTO_PK" ON "PRUEBAELANIIN"."PRODUCTO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PRUEBAELANIIN"."PRODUCTO" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PRUEBAELANIIN"."PRODUCTO" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "PRUEBAELANIIN"."PRODUCTO" MODIFY ("CANTIDAD" NOT NULL ENABLE);
  ALTER TABLE "PRUEBAELANIIN"."PRODUCTO" MODIFY ("PRECIO" NOT NULL ENABLE);
  ALTER TABLE "PRUEBAELANIIN"."PRODUCTO" ADD CONSTRAINT "PRODCUTO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "PRUEBAELANIIN"."USUARIO" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PRUEBAELANIIN"."USUARIO" ADD CONSTRAINT "USUARIO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
