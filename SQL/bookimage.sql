Select IMAGE_ID, Book_id, image, Image_Link from read_that_book.bookimage
USE read_that_book;

CREATE TABLE `bookimage` (
  `IMAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Book_id` int(11) DEFAULT NULL,
  `image` longblob,
  `Image_Link` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`IMAGE_ID`),
  UNIQUE KEY `Book_id` (`Book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;


INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (1,1,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (2,3,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (10,17,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (11,25,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (12,26,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (13,27,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (14,28,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (15,29,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (16,30,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (17,31,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (18,32,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (19,33,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (20,34,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (21,35,nullnullSystem.Byte[],null);
INSERT INTO `bookimage`(`IMAGE_ID`,`Book_id`,`image`,`Image_Link`) VALUES (22,38,nullnullSystem.Byte[],null);
