SELECT maker, MAX(price)
FROM product
INNER JOIN pc ON product.model=pc.model
GROUP BY maker;
