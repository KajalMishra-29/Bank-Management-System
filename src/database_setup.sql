CREATE DATABASE bankSystem;
USE bankSystem;

CREATE TABLE signup(
	form_no varchar(30),
    name varchar(60),
    father_name varchar(60),
    dob varchar(30),
    gender varchar(20),
    email varchar(60),
    marital_status varchar(20),
    address varchar(60),
    city varchar(40),
    state varchar(40),
    pincode varchar(40)
);

CREATE TABLE signupTwo(
	form_no varchar(30),
    religion varchar(30),
    category varchar(50),
    income varchar(30),
    education varchar(50),
    occupation varchar(50),
    pan varchar(50),
    aadhar varchar(50),
    senior_citizen varchar(30),
    existing_account varchar(30)
);

CREATE TABLE signupThree(
	form_no varchar(30),
    account_type varchar(50),
    card_no varchar(25),
    pin varchar(10),
    services varchar(150)
);

CREATE TABLE login(
	form_no varchar(30),
    card_no varchar(50),
    pin varchar(10)
);

CREATE TABLE bank(
	pin varchar(10),
    date varchar(150),
    type varchar(20),
    amount varchar(30)
);

select * from signup;
select * from signupTwo;
select * from signupThree;
select * from login;
select * from bank;
