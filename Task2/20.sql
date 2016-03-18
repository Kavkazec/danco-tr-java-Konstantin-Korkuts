SELECT maker, COUNT(model)
FROM product
WHERE type IN('pc')
GROUP BY maker
HAVING COUNT(model)>=3;