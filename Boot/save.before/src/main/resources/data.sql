DROP PROCEDURE IF EXISTS InsertStudentData;
CREATE PROCEDURE InsertStudentData()
BEGIN
  DECLARE i INT;
  SET i = 10;

  WHILE i < 1002 DO
    INSERT INTO student (roll_no, name) VALUES (i, CONCAT('name ', i));
    SET i = i + 1;
  END WHILE;
END;

--INSERT INTO student (roll_no, name) VALUES (3, 'John');
--INSERT INTO student (roll_no, name) VALUES (4, 'Jane');

