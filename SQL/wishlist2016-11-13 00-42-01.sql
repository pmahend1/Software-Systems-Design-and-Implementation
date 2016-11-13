Select UserName, BookID from read_that_book.wishlist
USE read_that_book;

CREATE TABLE `wishlist` (
  `UserName` varchar(20) NOT NULL,
  `BookID` int(11) NOT NULL,
  PRIMARY KEY (`UserName`,`BookID`),
  KEY `BookID` (`BookID`),
  CONSTRAINT `wishlist_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `book` (`BookID`),
  CONSTRAINT `wishlist_ibfk_2` FOREIGN KEY (`UserName`) REFERENCES `user` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


