-- Nombre, apellido e IP, donde la última conexión se dió de 221.XXX.XXX.XXX
SELECT
	first_name,
	last_name,
	last_connection
FROM
	users
WHERE
	last_connection LIKE '221.%';
	

-- Nombre, apellido y seguidores(followers) de todos a los que lo siguen más de 4600 personas
SELECT
	first_name,
	last_name,
	followers
FROM
	users
WHERE
	followers >= 4999;
	




-- Nombre, apellido e IP, donde la última conexión se dió de 221.XXX.XXX.XXX

select * from users;

select
    concat(first_name, ' ', last_name) as nombre,
    last_connection as ip
from
    users
WHERE
    last_connection like '221.%';

-- Nombre, apellido y seguidores(followers) de todos a los que lo siguen más de 4600 personas

select
    concat(first_name, ' ', last_name) as nombre,
    followers as seguidores
from
    users
WHERE
    followers > 4600;