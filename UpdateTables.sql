use websitebuilder;

ALTER TABLE pages
ADD missionStatement varchar(255);

ALTER TABLE pages
ADD history varchar(255);

ALTER TABLE pages
DROP COLUMN tags;

ALTER TABLE pages
DROP COLUMN description;

ALTER TABLE pages ALTER COLUMN page_id set DEFAULT 0;
ALTER TABLE pages MODIFY COLUMN page_id INT auto_increment;

insert into pages values(1,"Andrew",1,"test","test");

ALTER TABLE pages
ADD address varchar(255) NULL;

ALTER TABLE pages
ADD phoneNumber varchar(255) NULL;

ALTER TABLE pages
ADD title varchar(255) NULL;

ALTER TABLE pages
ADD description varchar(255) NULL;

ALTER TABLE pages
ADD profileName varchar(255) NULL;

ALTER TABLE pages
ADD email varchar(255) NULL;

ALTER TABLE pages
ADD bio varchar(255) NULL;
