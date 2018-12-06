DROP TABLE IF EXISTS `jtbmatch`;

CREATE TABLE `jtbmatch` ( 
	`MatchId` int(11) NOT NULL AUTO_INCREMENT,
	`MatchName` varchar(100) DEFAULT NULL,
	`NatchDate` datetime DEFAULT NULL,
	`RedTeam` varchar(50) DEFAULT NULL,
	`BuleTeam` varchar(50) DEFAULT NULL,
	`MatchResult` varchar(2)	DEFAULT NULL,
	`MatchVideo` varchar(100) DEFAULT NULL,
	PRIMARY KEY (`MatchId`)
)	ENGINE=InnoDB DEFAULT CHARSET=utf8;