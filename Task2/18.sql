SELECT maker 
FROM product 
INNER JOIN printer ON product.model=printer.model
WHERE printer<(SELECT AVG(price) FROM printer);