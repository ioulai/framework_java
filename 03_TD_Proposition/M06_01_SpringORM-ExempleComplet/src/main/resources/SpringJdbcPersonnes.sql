CREATE TABLE `javaavance`.`personne` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`));
insert into personne values (1, "Legrand", "Lucie", 36);
insert into personne values (2, "Lemoyen", "Jeanne", 54);
insert into personne values (3, "Lepetit", "Charles", 44);