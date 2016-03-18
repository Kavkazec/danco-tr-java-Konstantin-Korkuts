SELECT maker, AVG(screen)  
FROM laptop 
INNER JOIN  product ON product.model=laptop.model
GROUP BY maker; 