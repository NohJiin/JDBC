CREATE TABLE "HR"."MEMBER2" 
( 	"ID" VARCHAR2(10), 
	"PW" VARCHAR2(10), 
	"NAME" VARCHAR2(10), 
	"TEL" VARCHAR2(10), 
	 CONSTRAINT "MEMBER2_PK" PRIMARY KEY ("ID")
)

CREATE TABLE "HR"."BBS4" 
(	"NO" NUMBER(38,0) NOT NULL ENABLE, 
	"TITLE" VARCHAR2(100), 
	"CONTENT" VARCHAR2(100), 
	"WRITER" VARCHAR2(100), 
	 CONSTRAINT "BBS4_PK" PRIMARY KEY ("NO")
)