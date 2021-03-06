/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  student
 * Created: 21-nov-2017
 */

DROP TABLE wel PURGE;
DROP TABLE niet PURGE;
DROP TABLE studenten PURGE;
DROP TABlE groepen PURGE;
DROP TABLE rollen PURGE;
DROP TABLE gebruikers PURGE;

CREATE TABLE gebruikers (
    gnr int,
    gebnaam VARCHAR2 (50),
    ww VARCHAR2 (20),
    PRIMARY KEY (gnr)
);

CREATE TABLE rollen (
    gnr int,
    rnaam VARCHAR2 (20),
    PRIMARY KEY (gnr),
    FOREIGN KEY (gnr) REFERENCES gebruikers (gnr)
);

CREATE TABLE groepen (
    gid int,
    gnaam VARCHAR2 (50),
    finaal int,
    PRIMARY KEY (gid)
);

CREATE TABLE studenten (
    snr int,
    gid int,
    PRIMARY KEY (snr),
    FOREIGN KEY (snr) REFERENCES gebruikers (gnr),
    FOREIGN KEY (gid) REFERENCES groepen (gid)
);

CREATE TABLE wel (
    wnr int,
    aanvrager int,
    vriend int,
    PRIMARY KEY (wnr),
    FOREIGN KEY (aanvrager) REFERENCES studenten (snr),
    FOREIGN KEY (vriend) REFERENCES studenten (snr)
);

CREATE TABLE niet (
    nnr int,
    hater int,
    slachtoffer int,
    PRIMARY KEY (nnr),
    FOREIGN KEY (hater) REFERENCES studenten (snr),
    FOREIGN KEY (slachtoffer) REFERENCES studenten (snr)
);

INSERT INTO gebruikers VALUES(1, 'Herman Crauwels','docent');
INSERT INTO gebruikers VALUES(2, 'student1','student');
INSERT INTO gebruikers VALUES(3, 'student2','student');
INSERT INTO gebruikers VALUES (4, 'student3','student');
INSERT INTO rollen VALUES (1, 'docent');
INSERT INTO rollen VALUES(2, 'student');
INSERT INTO rollen VALUES(3, 'student');
INSERT INTO rollen VALUES(4, 'student');
INSERT INTO groepen  VALUES (0, 'null',0);
INSERT INTO groepen VALUES (1, 'groep1',0);
INSERT INTO studenten VALUES (2,1);
INSERT INTO studenten VALUES (3,0);
INSERT INTO studenten VALUES (4,0);
INSERT INTO wel VALUES(1,2,4);
INSERT INTO Niet VALUES(1,4,2);