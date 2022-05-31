CREATE schema IF NOT EXISTS family;
GRANT ALL ON family .* TO 'user'@'%';

CREATE schema IF NOT EXISTS familymember;
GRANT ALL ON familymember .* TO 'user'@'%';