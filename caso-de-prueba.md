Casos de Prueba
Escenario 1
Dado un insumo con valorDolarReferencia = 1000
Y un precioEnDolares = 100
Cuando la API devuelve una cotizacion de 1450
Entonces el valorDolarReferencia debe actualizarse a 1450
Y el precioEnPesos debe actualizarse a 145000
Y el insumo debe guardarse en la base de datos

Escenario 2
Dado un insumo con valorDolarReferencia = 1450
Cuando la API devuelve una cotizacion de 1450
Entonces el insumo no debe actualizarse
Y no debe guardarse nuevamente en la base de datos