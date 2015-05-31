CREATE TABLE IF NOT EXISTS `user` (
  `EMAIL` varchar(50) NOT NULL,
  `FIRSTNAME` varchar(20) NOT NULL,
  `LASTNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(64) NOT NULL,
  `REGISTER` datetime NOT NULL,
  PRIMARY KEY  (`EMAIL`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `user` (`EMAIL`, `FIRSTNAME`, `LASTNAME`, `PASSWORD`, `REGISTER`) VALUES
('fritz.walther@gmx.de', 'fritz', 'walther', '5906ac361a137e2d286465cd6588ebb5ac3f5ae955001100bc41577c3d751764', '2014-02-07 07:23:22');/*password3 */

CREATE TABLE IF NOT EXISTS `user_role` (
  `EMAIL` varchar(50) NOT NULL,
  `ROLENAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`EMAIL`,`ROLENAME`),
  KEY `FK_user_user_role_ROLENAME` (`ROLENAME`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `user_role` (`EMAIL`, `ROLENAME`) VALUES
('fritz.walther@gmx.de', 'admin');

CREATE TABLE IF NOT EXISTS `role` (
  `ROLENAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`ROLENAME`),
  UNIQUE KEY `UNQ_role_0` (`ROLENAME`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `role` (`ROLENAME`) VALUES
('admin'),
('user');
