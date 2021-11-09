CREATE TABLE `Themes` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`description` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Users` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`user` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Posts` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`title` varchar(255) NOT NULL,
	`text` varchar(1000) NOT NULL,
	`date` TIMESTAMP NOT NULL,
	`theme_id` bigint NOT NULL,
	`user_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Posts` ADD CONSTRAINT `Posts_fk0` FOREIGN KEY (`theme_id`) REFERENCES `Themes`(`id`);

ALTER TABLE `Posts` ADD CONSTRAINT `Posts_fk1` FOREIGN KEY (`user_id`) REFERENCES `Users`(`id`);




