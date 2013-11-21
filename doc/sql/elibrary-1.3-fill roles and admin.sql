
INSERT INTO `elibrary`.`role` (`ID`,`Role`)
VALUES (1,'admin');
INSERT INTO `elibrary`.`role` (`ID`,`Role`)
VALUES (2,'user');
INSERT INTO `elibrary`.`role` (`ID`,`Role`)
VALUES (3,'guest');

INSERT INTO `elibrary`.`user`
(`ID`,
`FirstName`,
`LastName`,
`Email`,
`Password`,
`DateOfBirth`,
`Avatar`,
`RoleID`)
VALUES
(1, 'admin', 'admin', 'admin@admin.com', 'admin', null, null, 1);