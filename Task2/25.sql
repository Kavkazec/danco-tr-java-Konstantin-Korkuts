SELECT DISTINCT maker 
FROM product  
WHERE maker IN (SELECT DISTINCT maker FROM product WHERE type IN('printer')) 
AND maker IN (SELECT DISTINCT maker FROM product, pc WHERE product.model=pc.model GROUP BY maker HAVING MAX(speed)) 
AND maker IN (SELECT DISTINCT maker FROM product, pc WHERE product.model=pc.model GROUP BY maker HAVING MIN(ram));