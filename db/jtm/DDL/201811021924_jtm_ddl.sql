DROP TABLE IF EXISTS `JTBmatch`;
CREATE TABLE `JTBmatch` ( 
	`MatchId` int NOT NULL AUTO_INCREMENT,
	`MatchName` varchar(100) DEFAULT NULL,
	`NatchDate` datetime DEFAULT NULL,
	`RedTeam` varchar(50) DEFAULT NULL,
	`BuleTeam` varchar(50) DEFAULT NULL,
	`MatchResult` varchar(2)	DEFAULT NULL,
	`MatchVideo` varchar(100) DEFAULT NULL,
	`MakeTime` datetime NOT NULL,
	`ModifyTime` datetime NOT NULL,
	PRIMARY KEY (`MatchId`)
)	ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `JTBsigleplayer`;
CREATE TABLE `JTBsigleplayer` ( 
	`Playerid` int NOT NULL AUTO_INCREMENT,
	`Playername` varchar(20)	DEFAULT NULL,
	`Matchid` int	NOT NULL,
	`Matchteam` varchar(20)	DEFAULT NULL,
	`Playerheroid` int	DEFAULT NULL,
	`Playerhero` varchar(20)	DEFAULT NULL,
	`Playerskill1` varchar(20)	DEFAULT NULL,
	`Playerskill2` varchar(20)	DEFAULT NULL,
	`Ornament` varchar(20)	DEFAULT NULL,
	`Equipment1` varchar(20)	DEFAULT NULL,
	`Equipment2` varchar(20)	DEFAULT NULL,
	`Equipment3` varchar(20)	DEFAULT NULL,
	`Equipment4` varchar(20)	DEFAULT NULL,
	`Equipment5` varchar(20)	DEFAULT NULL,
	`Equipment6` varchar(20)	DEFAULT NULL,
	`Killnumber` int	DEFAULT NULL,
	`Dienumber` int	DEFAULT NULL,
	`Assistsnumber` int	DEFAULT NULL,
	`InjuryAmount` int DEFAULT NULL,
	`BearAmount` int DEFAULT NULL,
	`TreatmentAmount` int DEFAULT NULL,
	`MakeTime` datetime	NOT NULL,
	`ModifyTime` datetime	NOT NULL,
	PRIMARY KEY (`Playerid`,`Matchid`)
)	ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `JTBplayer`;
CREATE TABLE `JTBplayer` ( 
	`Playerid` int NOT NULL AUTO_INCREMENT,
	`Playername` Varchar(20)	DEFAULT NULL,
	`Playersex` Varchar(2)	DEFAULT NULL,
	`Playerbirthday` Date	DEFAULT NULL,
	`Entrytime` Varchar(20)	DEFAULT NULL,
	`Workflag` Varchar(20)	DEFAULT NULL,
	`quittime` datetime	DEFAULT NULL,
	`Entryteam` datetime	NOT NULL,
	`MakeTime` datetime	NOT NULL,
	`ModifyTime` datetime	NOT NULL,
	PRIMARY KEY (`Playerid`)
)	ENGINE=InnoDB DEFAULT CHARSET=utf8;