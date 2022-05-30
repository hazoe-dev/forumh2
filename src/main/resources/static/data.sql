CREATE SCHEMA `forumh2` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `forumh2`.`tbl_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `join_date` DATE NULL,
  `tbl_usercol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `forumh2`.`tbl_forum` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `forumh2`.`tbl_topic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `created_time` DATE NULL,
  `content` VARCHAR(45) NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_topic_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_topic_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `forumh2`.`tbl_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE),
  CONSTRAINT `fk_topic_forum`
	  FOREIGN KEY (`forum_id`)
	  REFERENCES `forumh2`.`tbl_forum` (`id`)
	  ON DELETE CASCADE
	  ON UPDATE CASCADE;

    
    CREATE TABLE `forumh2`.`tbl_replymessage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `created_time` DATE NULL,
  `content` VARCHAR(45) NULL,
  `user_id` INT NULL,
  `topic_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reply_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_reply_topic_idx` (`topic_id` ASC) VISIBLE,
  CONSTRAINT `fk_reply_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `forumh2`.`tbl_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_reply_topic`
    FOREIGN KEY (`topic_id`)
    REFERENCES `forumh2`.`tbl_topic` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

    
INSERT INTO `tbl_user` (`id`, `username`, `password`, `email`, `join_date`) VALUES ('1', 'a', '1', 'a@ca', '2019-10-10');
INSERT INTO `tbl_forum` (`id`, `title`) VALUES ('1', 'a');