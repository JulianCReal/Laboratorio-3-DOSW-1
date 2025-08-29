# Parte 2

Caso Bankify
___
## Reto 1 - Identificando los requerimientos

### Reglas de Negocio
1. Cada número de cuenta debe tener una longitud de 10 dígitos.
2. El número de cuenta solo puede contener números; no se permiten letras ni caracteres especiales.
3. Una cuenta solo es válida si los 2 primeros dígitos corresponden a un banco registrado.
4. Se deben poder realizar operaciones financieras con las cuentas válidas.

### Funcionalidades Principales

1. **Gestión de cuentas de usuarios**
    - Crear cuentas
    - Consultar información de cuentas
    - Validar cuentas

2. **Operaciones bancarias básicas**
    - Depositar dinero
    - Consultar saldo
    - Ver historial de transacciones

3. **Validaciones y seguridad**
    - Verificar la estructura del número de cuenta
    - Confirmar que el banco emisor está registrado
    - Asegurar consistencia en las operaciones

### Actores Principales

1. Bancos registrados
2. Clientes de Bankify

### Precondiciones

1. Contar con una lista de bancos registrados.
2. Para realizar un depósito o consultar saldo, la cuenta debe existir previamente.
3. Validar que el número de cuenta sea único (no duplicado).
4. La cuenta debe contener únicamente dígitos numéricos.
5. El saldo de la cuenta debe ser mayor a 0.

___




