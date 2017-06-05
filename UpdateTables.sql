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

insert into pages values(1,"Andrew",1,"test","test")