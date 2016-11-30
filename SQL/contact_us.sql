Select contactUsID, username, category, description from read_that_book.contact_us
USE read_that_book;

CREATE TABLE `contact_us` (
  `contactUsID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`contactUsID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `read_that_book`.`contact_us`(`contactUsID`,`username`,`category`,`description`) VALUES (1,'raka','Site Feedback','You have a great site! Keep it up.
Can you add more features like Amazon link up?');
INSERT INTO `read_that_book`.`contact_us`(`contactUsID`,`username`,`category`,`description`) VALUES (2,'sanju','Access related','I want Critic access. I have already raised access for the same and mailed my documents. 
Kindly approve my critic role access.

Regards,
Sanju KH');
INSERT INTO `read_that_book`.`contact_us`(`contactUsID`,`username`,`category`,`description`) VALUES (3,'pavan','Error reporting','My home page doesnt load any book images .
Kindly check the issue.

Since I am an admin I would like to see the books in database.
-
Pavan');
