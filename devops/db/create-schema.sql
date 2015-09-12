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
  `link_id` varchar(100) not null,
  `name` varchar(100) default NULL,
  `email` varchar(50) not null,
  `password` varchar(255) not null,
  `role` varchar(255) not null default 'USER',
  `created_at` timestamp not null default current_timestamp,
  primary key (`verification_code`),
  unique key `email` (`email`)
);

# ===================================== Universities ==============================================================

drop table if exists `universities`;
create table `universities` (
  `id` int(11) not null auto_increment,
  `name` varchar(50) not null,
  `address` varchar(50) not null,
  `is_visible` tinyint(1) default '0',
  `description` varchar(255),
  `country` varchar(10) default NULL,
  `city` varchar(100) default NULL,
  `deadline` timestamp default NULL,
  `created_at` timestamp not null,
  `scholarship_opp` tinyint(1) default '0',
  primary key (`id`)
);

# ===================================== Exams ==============================================================

drop table if exists `exams`;
create table `exams` (
  `id` int(11) not null auto_increment,
  `code` varchar(50) not null,
  `uni_id` int(11) default NULL,
  `is_visible` tinyint(1) default '0',
  `description` varchar(255),
  `min_requirement` decimal(15,2) default '0.00',
  `created_at` timestamp not null,

  primary key (`id`),
  constraint `owner_fk` foreign key(`uni_id`) references `universities` (`id`) on update cascade
);

# ===================================== User exam scores ==============================================================

drop table if exists `exam_scores`;
create table `exam_scores` (
  `id` int(11) not null auto_increment,
  `code` varchar(50) not null,
  `uni_id` int(11) default NULL,
  `is_visible` tinyint(1) default '0',
  `description` varchar(255),
  `min_requirement` decimal(15,2) default '0.00',
  `created_at` timestamp not null,

  primary key (`id`),
  constraint `owner_fk` foreign key(`uni_id`) references `universities` (`id`) on update cascade
);

# ===================================================================================================================