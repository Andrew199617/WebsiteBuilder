CREATE DATABASE WebsiteBuilder;
use WebsiteBuilder;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `pword` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

create table pages (
	page_id int(11),
    name varchar(255),
    description varchar(255),
    tags varchar(255),
    user_id int(11)
); 

ALTER TABLE pages
ADD PRIMARY KEY (page_id);

ALTER TABLE pages
ADD FOREIGN KEY (user_id) REFERENCES users(user_id);