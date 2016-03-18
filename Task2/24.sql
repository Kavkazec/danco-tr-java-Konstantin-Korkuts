SELECT MAX(price), model FROM pc UNION
SELECT MAX(price), model FROM laptop UNION
SELECT MAX(price), model FROM printer;