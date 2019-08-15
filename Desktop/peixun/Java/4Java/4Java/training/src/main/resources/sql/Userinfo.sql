DROP TABLE IF EXISTS  training.userinfo;
CREATE TABLE training.userinfo (
id VARCHAR(20) PRIMARY KEY,
trans_seq VARCHAR(20),
trans_date CHAR(8),
name  VARCHAR(60),
sex   CHAR(1),
age  int,
tel_no VARCHAR(20),
credit_id VARCHAR(20)

)