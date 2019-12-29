CREATE SCHEMA project1;

DROP TABLE IF EXISTS project1.ers_reimbursement_status;
CREATE TABLE project1.ers_reimbursement_status(
reimb_status_id NUMERIC PRIMARY KEY,
reimb_status VARCHAR(10));

DROP TABLE IF EXISTS project1.ers_reimbursement_type;
CREATE TABLE project1.ers_reimbursement_type(
reimb_type_id NUMERIC PRIMARY KEY,
reimb_type VARCHAR(10));

DROP TABLE IF EXISTS project1.ers_user_roles;
CREATE TABLE project1.ers_user_roles(
ers_user_role_id NUMERIC PRIMARY KEY,
user_role VARCHAR(20));

DROP TABLE IF EXISTS project1.ers_users;
CREATE TABLE project1.ers_users(
ers_user_id NUMERIC PRIMARY KEY,
ers_username VARCHAR(50) UNIQUE,
ers_password VARCHAR(50),
user_first_name VARCHAR(100),
user_last_name VARCHAR(100),
user_email VARCHAR(150),
user_role_id NUMERIC);

ALTER TABLE project1.ers_users
	ADD CONSTRAINT user_roles_fk
	FOREIGN KEY (user_role_id) REFERENCES project1.ers_user_roles(ers_user_role_id);

DROP TABLE IF EXISTS project1.ers_reimbursement;
CREATE TABLE project1.ers_reimbursement(
reimb_id NUMERIC PRIMARY KEY,
reimb_amount NUMERIC,
reimb_submitted TIMESTAMP,
reimb_resolved TIMESTAMP,
reimb_description VARCHAR(250),
reimb_receipt BYTEA,
reimb_author NUMERIC,
reimb_resolver NUMERIC,
reimb_status_id NUMERIC,
reimb_type_id NUMERIC);

ALTER TABLE project1.ers_reimbursement
	ADD CONSTRAINT ers_users_fk_auth
	FOREIGN KEY (reimb_author) REFERENCES project1.ers_users(ers_user_id),
	ADD CONSTRAINT ers_users_fk_reslver
	FOREIGN KEY (reimb_resolver) REFERENCES project1.ers_users(ers_user_id),
	ADD CONSTRAINT ers_reimbursement_status_fk
	FOREIGN KEY (reimb_status_id) REFERENCES project1.ers_reimbursement_status(reimb_status_id),
	ADD CONSTRAINT ers_reimbursement_type_fk
	FOREIGN KEY (reimb_type_id) REFERENCES project1.ers_reimbursement_type(reimb_type_id);

