

SELECT
	count(*),
	SUBSTRING(email, POSITION('@' IN email) + 1) AS DOMAIN
FROM
	users
GROUP BY
	SUBSTRING(email, POSITION('@' IN email) + 1)
HAVING
	count(*) > 1
order by 
	SUBSTRING(email, POSITION('@' IN email) + 1) asc;









SELECT email, SUBSTRING(email, POSITION('@%' in email)) as email_domain from users;
SELECT email, SUBSTRING(email, POSITION('@' in email) + 1) as email_domain from users;
