UPDATE
    users
SET
    first_name = SUBSTRING(name, 0, POSITION(' ' in name)),
    last_name = TRIM(SUBSTRING(name, POSITION(' ' in name)));




