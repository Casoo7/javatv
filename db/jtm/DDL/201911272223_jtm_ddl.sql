DROP TABLE IF EXISTS `JbUser`;
CREATE TABLE `JbUser` (
  `UserId` varchar(20) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `UserName` varchar(30) DEFAULT NULL,
  `PassWords` varchar(20) DEFAULT NULL,
	`LastLoginDate` Date DEFAULT NULL,
	`LastLoginTime` varchar(8) DEFAULT NULL,
	`MakeDate` Date DEFAULT NULL,
	`MakeTime` varchar(8) DEFAULT NULL,
	`ModifyDate` Date DEFAULT NULL,
	`ModifyTime` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `JBMaxNo`;
CREATE TABLE `JBMaxNo` (
  `MaxNoType` varchar(20) NOT NULL,
  `MaxNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaxNoType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;