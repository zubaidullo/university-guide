drop database if exists `ugdb`;
create database `ugdb`;

use `ugdb`;
# ===================================== USERS ========================================================================
drop table if exists `users`;
create table `users` (
  `id` int(11) not null auto_increment,
  `email` varchar(50) not null,
  `name` varchar(100) default NULL,
  `surname` varchar(100) default NULL,
  `school` varchar(100) default NULL,
  `password` varchar(20) not null,
  `motivation_u_id`int(11) default NULL,
  `balance` decimal(15,2) default '0.00',
  `blocked` tinyint(1) default '0',
  `phone_number` varchar(20) not null,
  `role` varchar(255) not null,
  `country` varchar(10) default NULL,
  `city` varchar(100) default NULL,
  `sex` varchar(100) default NULL,
  `birth` varchar(100) default NULL ,
  `created_at` timestamp not null default current_timestamp,
  primary key (`id`),
  unique key `email` (`email`)
);
alter table `users` auto_increment = 100000;

# ===================================== Registration ========================================================================
drop table if exists `register_verification`;
create table `register_verification` (
  `verification_code` varchar(20) not null,
  `email` varchar(50) not null,
  `created_at` timestamp not null default current_timestamp,
  primary key (`verification_code`),
  unique key `email` (`email`)
);

# ===================================== Universities ==============================================================

drop table if exists `universities`;
create table `universities` (
  `id` int(11) not null auto_increment,
  `name` varchar(50) not null,
  `address` text default null,
  `is_visible` tinyint(1) default '0',
  `description` text default null,
  `country` varchar(100) default NULL,
  `city` varchar(100) default NULL,
  `deadline` timestamp,
  `created_at` timestamp not null,
  `logo_url` varchar(50) default NULL,
  `image_url` varchar(50) default NULL,
  `scholarship_opp` tinyint(1) default '0',
  primary key (`id`)
);

# ===================================== Exams ==============================================================

drop table if exists `exams`;
create table `exams` (
  `id` int(11) not null auto_increment,
  `type` varchar(50) not null,
  `uni_id` int(11) default NULL,
  `description` text default null,
  `min_requirement` decimal(15,2) default '0.00',
  `created_at` timestamp not null,
  primary key (`id`)
);

# ===================================== User exam scores ==============================================================

drop table if exists `user_exam_scores`;
create table `user_exam_scores` (
  `id` int(11) not null auto_increment,
  `type` varchar(50) not null,
  `user_id` int(11) default NULL,
  `score`  decimal(15,2) default '0.00',
  primary key (`id`)
);

# ===================================================================================================================