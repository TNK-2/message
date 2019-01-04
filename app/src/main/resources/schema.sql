
#USE testdb;


DROP TABLE IF EXISTS message;
CREATE TABLE `message` ( 
  	id int(8) NOT NULL AUTO_INCREMENT,
    message varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

#drop table item;
#drop table image;
#drop database restApp
#drop user 'rest'@'localhost';