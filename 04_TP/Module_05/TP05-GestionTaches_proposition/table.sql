CREATE TABLE `javaavance`.`Tache` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(45) NULL,
  `importance` INT NULL,
  PRIMARY KEY (`id`));
insert into Tache values (1, "TODO 1", 1);
insert into Tache values (2, "TODO 2", 2);
insert into Tache values (3, "TODO 3", 3);