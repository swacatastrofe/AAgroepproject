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
DROP TABLE gebruikers PURGE;
DROP TABLE rollen PURGE;

CREATE TABLE rollen (
    rid int,
    rnaam VARCHAR2 (20),
    PRIMARY KEY (rid)
);

CREATE TABLE gebruikers (
    gnr int,
    gebnaam VARCHAR2 (50),
    ww VARCHAR2 (20),
    rol int,
    PRIMARY KEY (gnr),
    FOREIGN KEY (rol) REFERENCES rollen (rid)
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

CREATE TABLE niet (
    aanvrager int,
    vriend int,
    FOREIGN KEY (aanvrager) REFERENCES studenten (snr),
    FOREIGN KEY (vriend) REFERENCES studenten (snr)
);

CREATE TABLE wel (
    hater int,
    slachtoffer int,
    FOREIGN KEY (hater) REFERENCES studenten (snr),
    FOREIGN KEY (slachtoffer) REFERENCES studenten (snr)
);

INSERT INTO rollen VALUES (1, 'docent');
INSERT INTO rollen VALUES(2, 'student');
INSERT INTO gebruikers VALUES(1, 'Herman Crauwels','docent',1);
INSERT INTO gebruikers VALUES(2, 'student1','student',2);
INSERT INTO gebruikers VALUES(3, 'student2','student',2);
INSERT INTO gebruikers VALUES (4, 'student3','student',2);
INSERT INTO groepen  VALUES (0, 'null',0);
INSERT INTO groepen VALUES (1, 'groep1',0);
INSERT INTO studenten VALUES (2,0);
INSERT INTO studenten VALUES (3,0);
INSERT INTO studenten VALUES (4,0);